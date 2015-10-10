use bancoG8;

create table cliente
(
id_cliente int primary key,
nombre varchar(20),
apellido varchar(20)
);

create table cuenta
(
id_cuenta int primary key,
fecha_creada Datetime,
id_owner int not null,
id_tipo_cuenta int not null,
FOREIGN KEY (id_owner)
      REFERENCES cliente(id_cliente)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table transaccion
( id_transaccion int primary key,
fecha Datetime,
id_cuenta int not null,
id_tipo_trans int not null,
FOREIGN KEY (id_cuenta)
      REFERENCES cuenta(id_cuenta)
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table remesas_efectivo
(
id_remesa int,
id_remesadora int,
fecha Datetime,
nombre_emisor varchar(100),
nombre_receptor varchar(100),
monto_Q numeric(10,2),
monto_D numeric(10,2),
estado varchar(3),
primary key(id_remesa,id_remesadora)
);

create table tipo_cambio
(
cambioCompra numeric(10,2),
cambioVenta numeric(10,2)
);


