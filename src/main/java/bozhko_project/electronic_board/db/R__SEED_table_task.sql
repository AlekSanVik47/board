TRUNCATE TABLE users  CASCADE;

INSERT INTO users  (id, nick, password, name, surname, email, phone)
VALUES (1, 'FromMigrationTask', now(), 0);