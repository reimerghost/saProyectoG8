create database remesadoraG8;
create database bancoG8;
use remesadoraG8;
--TIPO DE REMESA
create table tipo_remesa
( id_tipo int primary key,
nombre varchar(20));
--CLIENTE
create table cliente
( id_tipo int primary key,
nombre varchar(20));
--ESTADO
create table estado
( id_tipo int primary key,
nombre varchar(20));
--REMESA
create table remesa
( id_tipo int primary key,
nombre varchar(20));
--HISTORIAL DE REMESA
create table historial
( id_tipo int primary key,
nombre varchar(20));
