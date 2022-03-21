create table authorities (
                             login varchar(50) not null,
                             authority varchar(50) not null,
                             constraint fk_authorities_users foreign key(login) references users(login)
);
create unique index ix_auth_nick on authorities (login,authority);

create table oauth_client_details
(
    client_id               varchar(255) not null
        constraint oauth_client_details_client_id_pkey
            primary key,
    access_token_validity   integer,
    additional_information  varchar(255),
    authorities             varchar(255),
    authorized_grant_types  varchar(255),
    autoapprove             boolean      not null,
    client_secret           varchar(255),
    refresh_token_validity  integer,
    resource_ids            varchar(255),
    scope                   varchar(255),
    web_server_redirect_uri varchar(255)
);