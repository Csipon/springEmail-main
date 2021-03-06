DROP SCHEMA IF EXISTS public CASCADE;
COMMIT;
CREATE SCHEMA public;
COMMIT;
-- DROP TABLE IF EXISTS orders CASCADE;
-- DROP TABLE IF EXISTS users CASCADE;
-- DROP TABLE IF EXISTS user_roles CASCADE;
-- DROP TABLE IF EXISTS car_details CASCADE;
--
-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS user_roles;
-- DROP TABLE IF EXISTS car_details;
-- DROP TABLE IF EXISTS cars;
-- DROP TABLE IF EXISTS orders;

CREATE TABLE user_roles (
  id INTEGER not null,
  role varchar not null,
  Constraint role_PK PRIMARY KEY (id)

);

CREATE TABLE users (
  id bigserial NOT NULL,
  first_name varchar NOT NULL,
  last_name varchar NOT NULL,
  email varchar NOT NULL,
  password varchar NOT NULL,
  user_roles_id INTEGER NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE cars (
  id bigserial NOT NULL,
  model varchar(255) NOT NULL,
  mark varchar(50) NOT NULL,
  year INTEGER NOT NULL,
  price_per_hour Float NOT NULL,
  car_details_id INTEGER,
  CONSTRAINT cars_PK PRIMARY KEY (id)
);


CREATE TABLE car_details (
  id BIGSERIAL NOT NULL,
  speed INTEGER NOT NULL,
  class TEXT NOT NULL,
  power TEXT NOT NULL,
  fuel_type TEXT NOT NULL,
  fuel_consume INTEGER NOT NULL,
  type TEXT,
  salon TEXT,
  turbo boolean,
  acceleration INTEGER,
  CONSTRAINT car_details_PK PRIMARY KEY (id)
);

CREATE TABLE orders (
  id bigserial NOT NULL,
  date TIMESTAMP NOT NULL,
  due_date TIMESTAMP NOT NULL,
  total_price float NOT NULL,
  car_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  CONSTRAINT orders_pk PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT user_roles_id_FK FOREIGN KEY (user_roles_id) REFERENCES user_roles(id);
ALTER TABLE orders ADD CONSTRAINT cars_id_FK FOREIGN KEY (car_id) REFERENCES cars(id);
ALTER TABLE orders ADD CONSTRAINT users_id_FK FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE cars ADD CONSTRAINT car_details_id_FK FOREIGN KEY (car_details_id) REFERENCES car_details(id);

INSERT INTO user_roles (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (id, role) VALUES (2, 'ROLE_ADMIN');
