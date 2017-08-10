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
ID VARCHAR(20),
nome VARCHAR(90),
especie VARCHAR(128),
peso SMALLINT(3),

 
CREATE TABLE tutor(
nome VARCHAR(30),
sobrenome VARCHAR(100),
CPF VARCHAR(14),
Dta_nacto DATE,
tel_fixo VARCHAR(13),
tel_celular VARCHAR(14),
CONSTRAINT tuto_pk primary key(CPF)
);

ALTER TABLE tutor
	DROP PRIMARY KEY;
    
ALTER table tutor
	ADD CONSTRAINT tutor_pessoa_fk foreign key(CPF_Tutor) references pessoa(CPF);
	
  
CREATE TABLE prontuario(
ID VARCHAR(17),
constraint prontuario_pk primary key(ID)
);

create table servico(
ID VARCHAR(10),
ID_Prontuario VARCHAR(17),
Type VARCHAR(100) 
);


