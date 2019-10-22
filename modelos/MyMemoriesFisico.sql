create database MyMemories;

create table Usuario(
	idUsuario integer not null,
    Nome varchar(45) not null,
    Email varchar(60) not null,
    Senha varchar(20) not null,
    Telefone integer not null,
    primary key(idUsuario)
);

create table Contato(
	idContato integer not null,
    Nome varchar(45) not null,
    Numero integer not null,
    contato_usuario integer,
    id_usuario integer not null,
    foreign key(contato_usuario)
    references Usuario(idUsuario),
    foreign key(id_usuario)
    references Usuario(idUsuario),
    primary key(idContato)
);

create table Lembranca(
	idLembranca integer not null,
    Titulo varchar(45) not null,
    Texto varchar(200),
    Data datetime not null,
    Local varchar(20),
    Dono_lembranca integer not null,
    foreign key(Dono_lembranca)
    references Usuario(idUsuario),
    primary key(idLembranca)
);

create table Tipo_Lembranca(
	idTipo integer not null,
    Nome varchar(45),
    codLembranca integer not null,
    foreign key(codLembranca)
    references Lembranca(idLembranca),
    primary key(idTipo)
);

create table ContatoEmLembranca(
	Lembranca_idLembranca integer not null,
    Contato_idContato integer,
    CONSTRAINT fk_ContatoEmLembranca
    foreign key(Lembranca_idLembranca)
    references Lembranca(idLembranca)
    
    
);