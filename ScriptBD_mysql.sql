create database remesadoraG8;
create database bancoG8;
use remesadoraG8;


create table tipo_remesa
(id_tipo int primary key,
nombre varchar(20));



create table cliente
( id_cliente int(5) auto_increment primary key,
nombre varchar(20),
apellido varchar(20),
dpi varchar(13)
);


create table estado
( id_estado int primary key,
nombre varchar(20)
);


create table remesa
( id_remesa int auto_increment primary key,
nombre_emisor varchar(20),
apellido_receptor varchar(20),
fecha_agregado Datetime,
id_receptor int not null,
FOREIGN KEY (id_receptor)
      REFERENCES cliente(id_cliente)
      ON UPDATE CASCADE ON DELETE RESTRICT
);


create table historial
(
id_remesa int not null,
id_estado int not null,
fecha Datetime,
FOREIGN KEY (id_remesa)
      REFERENCES remesa(id_remesa)
      ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY (id_estado)
      REFERENCES estado(id_estado)
      ON UPDATE CASCADE ON DELETE RESTRICT,
PRIMARY KEY(id_remesa,id_estado,fecha)
);

use bancoG8;

create table cliente
( id_cliente int primary key,
nombre varchar(20),
apellido varchar(20),
dpi varchar(13)
);

create table tipo_cuenta
( id_tipo_cuenta int primary key,
nombre varchar(25)
);

create table tipo_transaccion
( id_tipo_trans int primary key,
nombre varchar(25)
);

create table cuenta
( id_cuenta int primary key,
fecha_creada Datetime,
id_owner int not null,
id_tipo_cuenta int not null,
FOREIGN KEY (id_owner)
      REFERENCES cliente(id_cliente)
      ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY (id_tipo_cuenta)
      REFERENCES tipo_cuenta(id_tipo_cuenta)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table transaccion
( id_transaccion int primary key,
fecha Datetime,
id_cuenta int not null,
id_tipo_trans int not null,
FOREIGN KEY (id_cuenta)
      REFERENCES cuenta(id_cuenta)
      ON UPDATE CASCADE ON DELETE RESTRICT,
FOREIGN KEY (id_tipo_trans)
      REFERENCES tipo_transaccion(id_tipo_trans)
      ON UPDATE CASCADE ON DELETE RESTRICT
);


