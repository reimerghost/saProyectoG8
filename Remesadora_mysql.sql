drop database remesadoraG8;
create database remesadoraG8;
use remesadoraG8;

create table remesa
( id_remesa int auto_increment primary key,
nombre_emisor varchar(50),
nombre_receptor varchar(50),
fecha_agregado Datetime,
tipo_remesa varchar(50)
);


create table historial
(
id_historial int auto_increment not null,
id_remesa int not null,
estado varchar(50) not null,
fecha Datetime,
FOREIGN KEY (id_remesa)
      REFERENCES remesa(id_remesa)
      ON UPDATE CASCADE ON DELETE RESTRICT,
PRIMARY KEY(id_historial)
);
