-- create database pronosticodeportivo;
/*create table participantes(idP int not null auto_increment, nomP varchar(20) not null, apeP varchar(20) not null,
puntosP int not null, primary key(idP));*/
/*insert into participantes (idP, nomP, apeP, puntosP)
values(idP, 'Dario', 'Nani', 0),
	  (idP, 'Claudio', 'Bossa', 0),
      (idP, 'Fernando', 'Zalazar', 0),
      (idP, 'Nahuel', 'Rosina', 0),
      (idP, 'Esteban', 'Migliore', 0),
      (idP, 'Rodrigo', 'Campos', 0);*/
/*create table partidos(partido int not null auto_increment, equipLocal varchar(20) not null, resultado varchar(1) not null,
equipVisit varchar(20) not null, primary key(partido));
insert into partidos(partido, equipLocal, resultado, equipVisit)
values(partido, 'Napoli', 'l', 'Liverpool'),
      (partido, 'Ajax', 'l', 'Rangers'),
      (partido, 'Liverpool', 'l', 'Ajax'),
      (partido, 'Rangers', 'v', 'Napoli'),
      (partido, 'Ajax', 'v', 'Napoli'),
      (partido, 'Liverpool', 'l', 'Rangers');*/
/*create table pronosticos(participante varchar(41) not null, result1 varchar(1) not null, result2 varchar(1) not null
, result3 varchar(1) not null, result4 varchar(1) not null, result5 varchar(1) not null, result6 varchar(1) not null, puntos int not null, primary key(puntos));*/
/*alter table pronosticos
drop primary key;*/
/*insert into pronosticos (participante, result1, result2, result3, result4, result5, result6, puntos)
values('Dario Nani', 'l', 'v', 'v', 'l', 'l', 'l', 0),
      ('Claudio Bossa', 'v', 'l', 'l', 'l', 'v', 'l', 0),
      ('Fernando Zalazar', 'v', 'v', 'v', 'v', 'l', 'l', 0),
      ('Nahuel Rosina', 'l', 'l', 'l', 'l', 'v', 'v', 0),
      ('Esteban Migliore', 'v', 'l', 'v', 'l', 'v', 'l', 0),
      ('Rodrigo Campos', 'l', 'v', 'l', 'v', 'l', 'v', 0);*/
/*alter table pronosticos
add idP int not null auto_increment primary key;*/
