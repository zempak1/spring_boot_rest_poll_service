create table if not exists polls
(
    id          serial
        primary key,
    name        varchar(255) not null,
    description varchar(255) null,
    start_date  date         not null,
    end_date    date         null
);

create table if not exists questions
(
    id           serial
        primary key,
    poll_id      int          null,
    questionType int          null,
    name         varchar(255) not null,
    constraint questions_pollID_polls_id_fk
        foreign key (poll_id) references polls (id)
);

create table if not exists answer_variants
(
    id          serial
        primary key,
    question_id int          null,
    text        varchar(255) not null,
    constraint answer_variants_questionID_questions_id_fk
        foreign key (question_id) references questions (id)
);
