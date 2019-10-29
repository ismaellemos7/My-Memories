create database MyMemories;

create table Usuario(
	idUsuario integer not null AUTO_INCREMENT UNIQUE,
    Nome varchar(45) not null,
    Email varchar(60) not null UNIQUE,
    Senha varchar(20) not null,
    Telefone integer not null UNIQUE,
    primary key(idUsuario)
);

create table Contato(
	idContato integer not null AUTO_INCREMENT UNIQUE,
    Nome varchar(45) not null,
    Numero integer not null UNIQUE,
    contato_usuario integer,
    id_usuario integer not null,
    foreign key(contato_usuario)
    references Usuario(idUsuario),
    foreign key(id_usuario)
    references Usuario(idUsuario),
    primary key(idContato)
);

create table Tipo_Lembranca(
	idTipo integer not null AUTO_INCREMENT UNIQUE,
    Nome varchar(45),
    primary key(idTipo)
);

create table Lembranca(
	idLembranca integer not null AUTO_INCREMENT UNIQUE,
    Titulo varchar(45) not null,
    Texto varchar(200),
    Data datetime not null,
    Local varchar(20),
    Dono_lembranca integer not null,
    Tipo_de_lembranca integer not null,
    foreign key(Dono_lembranca)
    references Usuario(idUsuario),
    foreign key(Tipo_de_lembranca)
    references Tipo_Lembranca(idTipo),
    primary key(idLembranca)
);

create table ContatoEmLembranca(
	Lembranca_idLembranca integer not null UNIQUE,
    Contato_idContato integer,
    CONSTRAINT foreign key(Lembranca_idLembranca)
    references Lembranca(idLembranca),
    CONSTRAINT foreign key(Contato_idContato)
    references Contato(idContato)
);

INSERT INTO Usuario()
VALUES(1,'João','joao@email.com','123abc',4002-8922),
	  (2,'Jose','Jose@email.com','123abc',4102-8922),
	  (3,'Joaquim','Joaquim@email.com','123abc',4202-8922),
      (4,'Simei','Simei@email.com','123abc',4302-8922),
      (5,'Rafael','Rafael@email.com','123abc',4402-8922),
      (6,'Ismael','Ismael@email.com','123abc',4502-8922),
      (7,'Eymael','Eymael@email.com','123abc',4602-8922),
      (8,'Tiago','Tiago@email.com','123abc',4702-8922),
      (9,'Newton','Newton@email.com','123abc',4802-8922),
      (10,'Raquel','Raquel@email.com','123abc',4902-8922);
      
INSERT INTO Contato()
VALUES(1,'Romulo',4001-8921,NULL,9),
	  (2,'Mozart',4002-8921,NULL,2),
      (3,'Lucas',4003-8921,NULL,6),
      (4,'Mateus',4004-8921,NULL,10),
      (5,'Breno',4005-8921,NULL,2),
      (6,'Rafael',4006-8921,5,3),
      (7,'Ismael',4007-8921,6,5),
      (8,'Simei',4008-8921,4,6),
      (9,'Newton',4009-8921,9,3),
      (10,'Raquel',4000-8921,10,8);
      
INSERT INTO tipo_lembranca() /* Os tipos de lembrança são limitados em 7 */
VALUES(1,'Familiar'),
	  (2,'Data Comemorativa'),
      (3,'Evento'),
      (4,'Compartilhada'),
      (5,'Pessoal'),
      (6,'Amorosa'),
      (7,'Religiosa');
      
INSERT INTO Lembranca()
VALUES(1,'wtads 2018','muito legal','2018-11-05','IFRN - miniauditório',6,3),
	  (2,'Palestra','','2019-09-08','IFRN - miniauditório',6,3),
      (3,'Hacktoberfest','','2018-07-05','',6,3),
      (4,'Hackaton','','2018-07-14','',8,3),
      (5,'Minicurso','gostei da experiencia','2019-04-14','IFRN - lab06',8,3),
      (6,'Minicurso django','','2018-08-19','IFRN - lab07',9,3),
      (7,'Aniversario Fulano','','2018-10-21','',10,2),
      (8,'Termino de Namoro','muito legal','2017-12-31','whatsapp',2,6),
      (9,'Entrega de Trabalho','Banco de dados','2019-10-29','IFRN - lab 04',5,3),
      (10,'Casamento','','2019-12-20','Arena da Dunas',7,6);
      
INSERT INTO contatoemlembranca()
VALUES(1,8),
	  (2,6),
      (3,3),
      (4,10),
      (5,10),
      (6,1),
      (7,4),
      (8,NULL),
      (9,7),
      (10,NULL);