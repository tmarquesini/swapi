drop table if exists swapi;

create table users (
        id int not null auto_increment,
        username varchar(32) not null unique,
        password varchar(255) not null,
        token varchar(255),
        primary key (id)
);
