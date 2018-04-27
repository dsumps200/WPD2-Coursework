INSERT INTO MILESTONE (title, description, due_date) VALUES ('Presentation', 'Create web development presentation', CURRENT_TIMESTAMP());
INSERT INTO MILESTONE (title, description, due_date) VALUES ('Create unit tests', 'Create unit tests for the application', CURRENT_TIMESTAMP());
INSERT INTO MILESTONE (title, description, due_date) VALUES ('Wireframes', 'Craft a beautiful set of wireframes', CURRENT_TIMESTAMP());
INSERT INTO MILESTONE (title, description, due_date) VALUES ('User Authentication', 'Create a register and login system', CURRENT_TIMESTAMP());
INSERT INTO MILESTONE (title, description, due_date) VALUES ('Database relationships', 'Associate a user with the milestones they create', CURRENT_TIMESTAMP());

INSERT INTO Role (role_id, role) VALUES (1, 'USER');
INSERT INTO Role (role_id, role) VALUES (2, 'ADMIN');

INSERT INTO User (user_id, email, `name`, password, last_name, role_id, active) VALUES (1, 'lyle@test.com', 'lyle', '$2y$10$4AWLwLy2aiw2zu8Pcq8ozuSO4GwsCEX0isHCrWA1CT9zJlN4DZDlO', 'Simpson', 1, 1);
INSERT INTO User (user_id, email, `name`, password, last_name, role_id, active) VALUES (2, 'dave@test.com', 'dave', '$2y$10$zm3NAke4NAJnzbswFJs36.vL0dWB4Ngfe02PQfMUSbELWfbu1A3yy', 'Sumpster', 1, 1);
INSERT INTO User (user_id, email, `name`, password, last_name, role_id, active) VALUES (3, 'abdul@test.com', 'abdul', '$2y$10$BkK3K1xYWoQKQrX7xMW6j.KFNVwOrdCXUsuY1a6ANHgiH75RM3RcG', 'Dar', 1, 1);
