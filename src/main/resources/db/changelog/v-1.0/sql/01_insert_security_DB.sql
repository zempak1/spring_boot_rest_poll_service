INSERT INTO users (username, password, enabled)
VALUES ('admin@email.com', '{bcrypt}$2a$12$NtQyuElkluXmYUyJa3OLEeQDqsRsGvge9Jy.atOZ84mp7Z.S93Y2K', 1);

INSERT INTO authorities (username, authority)
VALUES ('admin@email.com', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled)
VALUES ('person1@email.com', '{bcrypt}$2a$12$gJaqsD1FWypDt2pYigCOJezwXdQFoI8VDu2XTQRFSFdvg//8vRcaS', 1);

INSERT INTO authorities (username, authority)
VALUES ('person1@email.com', 'ROLE_PERSON');

INSERT INTO users (username, password, enabled)
VALUES ('person2@email.com', '{bcrypt}$2a$12$JEIuUEuiMF3V9YJsprEkO.QMb4UUxgKbqDMl8GmcX9ienT9hnOOoK', 1);

INSERT INTO authorities (username, authority)
VALUES ('person2@email.com', 'ROLE_PERSON');