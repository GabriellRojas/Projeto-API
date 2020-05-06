drop table if exists jogo;

create table jogo(
    id_jogo bigint auto_increment,
    nome varchar(100) not null,
    genero varchar(20) not null,
    data_lancamento varchar(100) not null,
    primary key (id_jogo));
