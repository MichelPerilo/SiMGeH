CREATE SCHEMA SiMGeH;
USE SiMGeH;

CREATE TABLE pessoa (
  CPF        varchar(11),
  dta_nascto      date,
  pNome       varchar(15) not null, 
  uNome       varchar(20) not null,
  tel_celular varchar(11),
  tel_fixo    varchar(10),
  primary key (CPF)
);

CREATE TABLE usuario(
  MATRICULA 	integer(12),
  CPF 		varchar(11) unique 		 not null,
  admin 	boolean,
  login 	varchar(50) unique	 not null,
  senha 	varchar(8) unique	 not null,
  primary key(MATRICULA),
  foreign key (CPF) references pessoa(CPF)
);  

CREATE TABLE medico (
  MATRICULA		integer(12) 	not null,	
  crmv 			int 	not null,
  especialidade varchar(40) not null,
  primary key(crmv),
  foreign key(MATRICULA) references usuario(MATRICULA)
);

CREATE TABLE animal(
  
