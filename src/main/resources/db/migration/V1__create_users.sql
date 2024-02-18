create table users
(
    id           uuid primary key default uuid_generate_v4(),
    email        varchar(200) not null,
    username     varchar(200) not null,
    password     varchar(300) not null,
    created_time timestamp with time zone,
    updated_time timestamp with time zone
);