TRUNCATE TABLE user;

INSERT INTO user(email, phone, password, name, image)
VALUES ('vik@mail.ru', 375291111111, 'abcdefgh', 'Viktoria', 'BASIC'),
       ('alice@gmail.com', 375442222222, 'abc123Alice.', 'Alice', 'BEGINNER'),
       ('alexander@gmail.com', NULL, 'Alexander749', 'Alex', 'BEGINNER'),
       ('maksim@mail.ru', 375333333333, 'MaXiM_333', 'Maxim', 'BASIC');