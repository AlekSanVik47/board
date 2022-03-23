create table user_role (id bigint not null constraint user_role_pk primary key,
                        role varchar(50) not null, unique (role)
                        );

create table user_state (id bigint not null constraint user_state_pk primary key,
                         state varchar(50) not null, unique (state)
                         );

create table user_status (id bigint not null constraint user_status_pk primary key,
                         status varchar(50) not null, unique (status)
                          );

insert into user_role (role) values ('USER'), ('ADMIN');
insert into user_state (state) values ('NOT_CONFIRMED'), ('CONFIRMED'), ('DELETE'), ('BANNED');
insert into user_status (status) values ('NEW'), ('IN_PROGRESS'), ('DELETE'), ('COMPLETED');




create sequence hibernate_sequence
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;

alter sequence hibernate_sequence owned by user_role.id;
alter sequence hibernate_sequence owned by user_state.id;
alter sequence hibernate_sequence owned by user_status.id;

