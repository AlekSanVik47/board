ALTER TABLE authorities ADD FOREIGN KEY (login) REFERENCES users(login);
INSERT INTO users (login)
SELECT 'login'
FROM authorities;

