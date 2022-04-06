-- Initial Application Roles
insert into role (name, id) values ('ROLE_ADMIN', 1);
insert into role (name, id) values ('ROLE_BACKEND', 2);
insert into role (name, id) values ('ROLE_USER', 3);

-- Initial Users
insert into users (email, hobbies, name, password, id) values ('admin@gmail.com', 'jpobies de adminstrador', 'John Doe', '$2a$10$ZeiheSoSBBTNyYBVK3xUk.aOeASK.ckDnVrMAc0VL7Zs6isVkOoly', 1);
insert into users (email, hobbies, name, password, id) values ('backend@gmail.com', 'jobies de backend', 'John Doe', '$2a$10$ZeiheSoSBBTNyYBVK3xUk.aOeASK.ckDnVrMAc0VL7Zs6isVkOoly', 2);
insert into users (email, hobbies, name, password, id) values ('user@gmail.com', 'futbol pesca RayoVallecano', 'John Doe', '$2a$10$ZeiheSoSBBTNyYBVK3xUk.aOeASK.ckDnVrMAc0VL7Zs6isVkOoly', 3);

-- Assignament role to user
insert into user_role (role_id, user_id) values (1, 1);
insert into user_role (role_id, user_id) values (2, 2);
insert into user_role (role_id, user_id) values (3, 3);