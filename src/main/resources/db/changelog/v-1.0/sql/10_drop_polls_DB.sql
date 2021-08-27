alter table questions drop constraint questions_pollID_polls_id_fk;
alter table answer_variants drop constraint answer_variants_questionID_questions_id_fk;

drop table questions;
drop table answer_variants;
drop table polls;