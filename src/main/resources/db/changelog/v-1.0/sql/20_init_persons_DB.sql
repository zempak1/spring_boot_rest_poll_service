create table if not exists persons
(
    id       serial
        primary key,
    email varchar(255) null,
    constraint persons_email_users_username_fk
        foreign key (email) references users (username)
);