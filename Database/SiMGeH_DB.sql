CREATE SCHEMA SiMGeH;
USE SiMGeH;

CREATE TABLE pessoa (
  CPF        varchar(11) not null,
  dta_nascto      date,
  pNome       varchar(15) not null, 
  uNome       varchar(20) not null,
  tel_celular varchar(11),
  tel_fixo    varchar(10),
  primary key (CPF)
);