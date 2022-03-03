CREATE SEQUENCE hibernate_sequence
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1

CREATE TABLE postgres.users (
	id integer NOT NULL,
	nick varchar(100) NOT NULL,
	surname varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	phone varchar(100) NOT NULL,
	email varchar(100) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);