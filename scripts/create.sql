create table IF NOT EXISTS users
(
    id bigint not null
    constraint users_pkey
    primary key,
    password varchar(255),
    username varchar(255)
    );


create table IF NOT EXISTS roles
(
    id bigint not null
    constraint roles_pkey
    primary key,
    name varchar(255)
    );

create table IF NOT EXISTS users_roles
(
    user_id bigint not null,
    roles_id bigint not null
    constraint fka62j07k5mhgifpp955h37ponj
    references roles,
    constraint users_roles_pkey
    primary key (user_id, roles_id)
    );

create table IF NOT EXISTS valutes
(
    id bigint not null
    constraint valutes_pkey
    primary key,
    actual_date timestamp,
    char_code varchar(255),
    name varchar(255),
    nominal integer,
    num_code varchar(255),
    value double precision
    );

create table IF NOT EXISTS conversions
(
    id bigint not null constraint conversions_pkey primary key,
    amount double precision not null,
    from_valute_id bigint constraint fkhwujtfr8va5lgfiun41h4bboe references valutes,
    to_valute_id   bigint constraint fknw8engp2gy5lrjmt7nd2mbsat references valutes,
    user_id        bigint,
    date           timestamp
);

alter sequence hibernate_sequence;