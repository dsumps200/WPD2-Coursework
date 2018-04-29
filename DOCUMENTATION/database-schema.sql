create sequence hibernate_sequence start with 1 increment by 1;
create table milestone (id bigint generated by default as identity, completion_date date, description varchar(255), due_date date, public boolean, title varchar(255), user_id bigint not null, primary key (id));
create table role (id bigint not null, name varchar(255), primary key (id));
create table user (id bigint not null, password varchar(255), username varchar(255), primary key (id));
create table user_role (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id));
alter table milestone add constraint FKti3140u16yj214iyxi34ltsd0 foreign key (user_id) references user;
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role;
alter table user_role add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user;