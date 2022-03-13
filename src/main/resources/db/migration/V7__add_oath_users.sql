ALTER TABLE authorities ADD FOREIGN KEY (nick) REFERENCES users(nick);
INSERT INTO users (nick)
SELECT 'nick'
FROM authorities;

