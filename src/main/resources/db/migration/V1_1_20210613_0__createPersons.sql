create table IF NOT EXISTS persons
(
    id_persons bigserial not null constraint persons_pk primary key,
    vorname varchar,
    name varchar,
    email varchar not null
);

alter table persons owner to members;
create unique index persons_email_uindex on persons (email);


create sequence if not exists persons_id_persons_seq;
alter sequence persons_id_persons_seq owner to members;


