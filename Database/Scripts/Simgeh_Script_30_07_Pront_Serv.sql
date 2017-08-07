create schema SimGeh;
use SimGeh;

CREATE TABLE prontuario(
ID VARCHAR(17),
constraint prontuario_pk primary key(ID)
);

create table servico(
ID VARCHAR(10),
ID_Prontuario VARCHAR(17),
Type VARCHAR(100) 
);

