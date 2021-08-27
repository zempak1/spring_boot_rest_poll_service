create table if not exists users
(
    username varchar(255) not null
        primary key,
    password varchar(255) not null,
    enabled  smallint     not null
);

create table if not exists authorities
(
    username  varchar(255) not null
        primary key,
    authority varchar(255) not null
);

create table if not exists users_authorities
(
    user_username      varchar(255) not null,
    authority_username varchar(255) not null,
    constraint users_authorities_userUsername_users_username_fk
        foreign key (user_username) references users (username),
    constraint users_authorities_authorityUsername_authorities_username_fk
        foreign key (authority_username) references authorities (username)
);