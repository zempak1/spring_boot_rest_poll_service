create table if not exists answer
(
    id          serial
        primary key,
    person_id   int not null,
    poll_id     int not null,
    question_id int not null,
    constraint answer_questionID_questions_id_fk
        foreign key (question_id) references questions (id),
    constraint answer_pollID_polls_id_fk
        foreign key (poll_id) references polls (id),
    constraint answer_personID_persons_id_fk
        foreign key (person_id) references persons (id)
);

create table if not exists answers_answer_variants
(
    answer_id         int not null,
    answer_variant_id int not null,
    constraint answers_answer_variants_answerID_answer_id_fk
        foreign key (answer_id) references answer (id),
    constraint answers_answer_variants_answerVariantId_answer_variants_id_fk
        foreign key (answer_variant_id) references answer_variants (id)
);
