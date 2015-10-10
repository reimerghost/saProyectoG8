drop database bancoG8;
create database bancoG8;
use bancoG8;

create table cuenta
(
id_cuenta int auto_increment primary key,
fecha_creada Datetime,
nombre varchar(20),
apellido varchar(20),
email varchar(50)
);

create table transaccion
(
id_transaccion int auto_increment primary key,
fecha Datetime,
montoQ numeric(10,2),
montoD numeric(10,2),
id_cuenta int,
FOREIGN KEY (id_cuenta)
      REFERENCES cuenta(id_cuenta)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table remesas_efectivo
(
id_remesa int auto_increment,
id_remesadora int,
fecha Datetime,
nombre_emisor varchar(100),
nombre_receptor varchar(100),
montoQ numeric(10,2),
montoD numeric(10,2),
estado varchar(3),
primary key(id_remesa,id_remesadora)
);

create table prestamo
(
id_prestamo int auto_increment primary key,
fecha_creada Datetime,
nombre varchar(20),
apellido varchar(20),
email varchar(50),
montoQ numeric(10,2) not null,
saldo_actual numeric(10,2) not null
);

create table abonos
( id_abono int auto_increment primary key,
fecha Datetime,
montoQ numeric(10,2),
montoD numeric(10,2),
id_prestamo int not null,
FOREIGN KEY (id_prestamo)
      REFERENCES prestamo(id_prestamo)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table tipo_cambio
(
cambioCompra numeric(10,2),
cambioVenta numeric(10,2)
);


