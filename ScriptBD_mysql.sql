create database remesadoraG8;
create database bancoG8;
use remesadoraG8;
--TIPO DE REMESA
create table tipo_remesa
( id_tipo int primary key,
nombre varchar(20));
--CLIENTE
create table cliente
( id_cliente int primary key,
nombre varchar(20),
apellido varchar(20),
dpi varchar(13)
);
--ESTADO
create table estado
( id_estado int primary key,
nombre varchar(20)
);
--REMESA
create table remesa
( id_tipo int primary key,
nombre_emisor varchar(20),
apellido_receptor varchar(20),
fecha_agregado Datetime
id_receptor int not null REFERENCES cliente(id_cliente)
);
--HISTORIAL DE REMESA
create table historial
( id_tipo int primary key,
nombre varchar(20)
);
