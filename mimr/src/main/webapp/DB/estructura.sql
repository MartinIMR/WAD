-- Crear tablas
create table users (id_user int4 not null, tx_login varchar(30) not null unique, tx_password varchar(100) not null, primary key (id_user));
create table role (id_role serial not null, nb_role varchar(50) not null unique, ds_role varchar(250) not null, st_valid bool not null, primary key (id_role));
create table account (id_account serial not null, id_role int4 not null, id_user int4 not null, fh_begin date not null, fh_end date, primary key (id_account));
create table person (id_person serial not null, tx_first_name varchar(30) not null, tx_last_name_a varchar(30) not null, tx_last_name_b varchar(30) not null, tx_curp varchar(18) not null unique, fh_birth date not null, primary key (id_person));
create table access (id_access int4 not null, nu_attempt int4 not null, fh_failed timestamp(0), fh_lock timestamp(0), primary key (id_access));
create table type_contact (id_type serial not null, nb_type varchar(50) not null unique, ds_type varchar(200) not null, st_valid bool not null, primary key (id_type));
create table person_contacto (id_persona_contacto serial not null, id_persona int4 not null, id_tipo int4 not null, tx_contact varchar(50), primary key (id_persona_contacto));
create table contact (id_person int4 not null, id_contact int4 not null, primary key (id_person, id_contact));

--Agregar llaves 

alter table account add constraint FKaccount713322 foreign key (id_role) references role;
alter table account add constraint FKaccount999795 foreign key (id_user) references users;
alter table access add constraint FKaccess801659 foreign key (id_access) references users;
alter table person_contacto add constraint FKperson_con849379 foreign key (id_persona) references person;
alter table person_contacto add constraint FKperson_con408257 foreign key (id_tipo) references type_contact;
alter table users add constraint FKusers311802 foreign key (id_user) references person;
alter table contact add constraint FKcontact249289 foreign key (id_person) references person;
alter table contact add constraint FKcontact337911 foreign key (id_contact) references person;