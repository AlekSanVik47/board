CREATE TABLE IF NOT EXISTS public.role_tbl
(
    role_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    role_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_tbl_pkey PRIMARY KEY (role_id),
    CONSTRAINT role_tbl_role_fld_key UNIQUE (role_fld)
);

CREATE TABLE IF NOT EXISTS public.state_tbl
(
    state_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    state_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT state_tbl_pkey PRIMARY KEY (state_id),
    CONSTRAINT state_tbl_state_fld_key UNIQUE (state_fld)
);
CREATE TABLE IF NOT EXISTS public.status_tbl
(
    status_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    status_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT status_tbl_pkey PRIMARY KEY (status_id),
    CONSTRAINT status_tbl_status_fld_key UNIQUE (status_fld)
);
CREATE TABLE IF NOT EXISTS public.users_tbl
(
    id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    login character varying(255) COLLATE pg_catalog."default" NOT NULL,
    surname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(20) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    status_id smallint NOT NULL,
    state_id smallint NOT NULL,
    recording_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT users_tbl_email_key UNIQUE (email),
    CONSTRAINT users_tbl_login_key UNIQUE (login),
    CONSTRAINT users_tbl_password_key UNIQUE (password),
    CONSTRAINT users_tbl_phone_key UNIQUE (phone),
    CONSTRAINT state_fk FOREIGN KEY (state_id)
        REFERENCES public.state_tbl (state_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT status_fk FOREIGN KEY (status_id)
        REFERENCES public.status_tbl (status_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
INSERT INTO role_tbl (role_fld) VALUES ('USER'), ('ADMIN');
INSERT INTO state_tbl (state_fld) VALUES ('NOT_CONFIRMED'), ('CONFIRMED'), ('DELETE'), ('BANNED');
INSERT INTO status_tbl (status_fld) VALUES ('NEW'), ('IN_PROGRESS'), ('DELETE'), ('COMPLETED');


INSERT INTO users_tbl (login, surname, name, phone, email, password, state_id, status_id)
VALUES ('login_1', 'surname_1', 'name_1', '705-705', 'email@mail.ru', 'password_1', 2, 1);
