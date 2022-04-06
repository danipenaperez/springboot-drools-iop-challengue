--SET timezone TO 'UTC';

-- Prepare
drop table if exists price CASCADE;
drop table if exists role CASCADE ;
drop table if exists user_role CASCADE ;
drop table if exists users CASCADE ;
drop sequence if exists hibernate_sequence;

-- Default sequences
create sequence hibernate_sequence start with 1 increment by 1;

--User Roles Tables
create table role (id bigint not null, name varchar(255), primary key (id));
create table user_role (role_id bigint not null, user_id bigint not null);
create table users (id bigint not null, email varchar(255), hobbies varchar(255), name varchar(255), password varchar(255), primary key (id));

-- Constraints and Relations
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table user_role add constraint FKdnjkp24v4kpfcj4lqniebkwym foreign key (user_id) references role;
alter table user_role add constraint FKlgwbmu50w42ab81uwujjm8vdt foreign key (role_id) references users;