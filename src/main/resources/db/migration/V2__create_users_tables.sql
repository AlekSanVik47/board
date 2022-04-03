create table users (
	id serial constraint users_pk primary key,
	login varchar(100) not null, unique(login),
	surname varchar(100) not null,
	name varchar(100) not null,
	phone varchar(100) not null, unique(phone),
	email varchar(100) not null, unique(email),
	password varchar(100) not null, unique (password),
	status varchar(50)not null DEFAULT 'NEW', FOREIGN KEY(status) REFERENCES user_status(status),
	role_id VARCHAR(50)not null DEFAULT 'USER', FOREIGN KEY(role_id) REFERENCES user_role(role),
	state VARCHAR(50)not null DEFAULT 'CONFIRMED', FOREIGN KEY(state) REFERENCES user_state(state)
);

--create sequence hibernate_sequence
--    start with 1
--    increment by 1
--    no minvalue
--    no maxvalue
--    cache 1;
--


insert into users (login, surname, name, phone, email, password, role_id) VALUES
('Alex', 'Ivanov', 'Alexey', '+79053451338', 'test@mail.ru', 'pass1@', 'ADMIN'),
 ('Jon', 'Petrov', 'Alexander', '+79053551338', 'test1@mail.ru', 'pass2@', 'ADMIN');

 INSERT INTO users (login, name, surname, phone,email, password)
 VALUES
   ('Sam', 'Samson', 'Gallagher','8-922-836-5167','tempus@hotmail.com',  'pass3@'),
   ('Yve', 'Yvette', 'Copeland','8-874-994-5748','phasellus.dapibus.quam@google.edu', 'pass4@'),
   ('Laur', 'Laurel', 'Hoover','8-761-315-6632','aliquam@yahoo.org', 'pass5@'),
   ('Miranda', 'Myra', 'Miranda','(833) 396-6711','porta.elit.a@yahoo.com', 'pass6@'),
   ('Ima', 'Ima', 'Keith','(112) 544-1433','curabitur.sed@protonmail.com', 'pass7@');


--alter sequence hibernate_sequence owned by users.id;

--create unique index ix_auth_nick on authorities (login,authority);
--
--create table oauth_client_details
--(
--    client_id               varchar(255) not null
--        constraint oauth_client_details_client_id_pkey
--            primary key,
--    access_token_validity   integer,
--    additional_information  varchar(255),
--    authorities             varchar(255),
--    authorized_grant_types  varchar(255),
--    autoapprove             boolean      not null,
--    client_secret           varchar(255),
--    refresh_token_validity  integer,
--    resource_ids            varchar(255),
--    scope                   varchar(255),
--    web_server_redirect_uri varchar(255)
--);