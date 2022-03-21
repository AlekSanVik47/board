create table users (
	id bigint not null,
	login varchar(100) not null, unique(login),
	surname varchar(100) not null,
	name varchar(100) not null,
	phone varchar(100) not null, unique(phone),
	email varchar(100) not null, unique(email),
	password varchar(100) not null, unique (password),
	constraint users_pkey
	primary key (id)
);

create sequence hibernate_sequence
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

alter sequence hibernate_sequence owned by users.id;