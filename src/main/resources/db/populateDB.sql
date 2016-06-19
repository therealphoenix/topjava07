DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, description, calories)
VALUES (100000,'Завтрак', '150');
INSERT INTO meals (user_id, description, calories)
VALUES (100000,'Полдник', '100');
INSERT INTO meals (user_id, description, calories)
VALUES (100000,'Обед', '300');
INSERT INTO meals (user_id, description, calories)
VALUES (100000,'Ужин', '200');

