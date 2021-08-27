alter table users_authorities drop constraint uname_users_auth_usname_users_fk;
alter table users_authorities drop constraint auth_uname_users_auth_uname_auth_fk;
drop table users_authorities;
drop table authorities;
drop table users;

