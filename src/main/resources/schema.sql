
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS User_roles CASCADE;
DROP TABLE IF EXISTS Car_params CASCADE;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS User_roles;
DROP TABLE IF EXISTS Car_params;
DROP TABLE IF EXISTS Cars;
DROP TABLE IF EXISTS Orders;

CREATE TABLE User_roles (
  id INTEGER not null,
  role varchar not null,
  Constraint Role_PK PRIMARY KEY (id)

);

CREATE TABLE Users (
  id bigserial NOT NULL,
  first_name varchar NOT NULL,
  last_name varchar NOT NULL,
  email varchar NOT NULL,
  password varchar NOT NULL,
  user_roles_id INTEGER NOT NULL,
  CONSTRAINT Users_pk PRIMARY KEY (id)
);

CREATE TABLE Cars (
  id bigserial NOT NULL,
  model varchar(255) NOT NULL,
  mark varchar(50) NOT NULL,
  year INTEGER NOT NULL,
  price_per_hour Float NOT NULL,
  car_params_id INTEGER NOT NULL,
  CONSTRAINT Cars_PK PRIMARY KEY (id)
);


CREATE TABLE Car_params (
  id bigserial NOT NULL,
  speed INTEGER NOT NULL,
  class varchar(10) NOT NULL,
  power varchar NOT NULL,
  fuel_type varchar(50) NOT NULL,
  fuel_consume INTEGER NOT NULL,
  type varchar(50),
  salon varchar,
  turbo char(1),
  acceleration INTEGER,
  CONSTRAINT Car_params_PK PRIMARY KEY (id)
);


CREATE TABLE Orders (
  id bigserial NOT NULL,
  date DATE NOT NULL,
  due_date DATE NOT NULL,
  total_price float NOT NULL,
  car_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  CONSTRAINT Orders_pk PRIMARY KEY (id)
);

ALTER TABLE Users ADD CONSTRAINT ruser_roles_id_FK FOREIGN KEY (user_roles_id) REFERENCES User_roles(id);
ALTER TABLE Orders ADD CONSTRAINT cars_id_FK FOREIGN KEY (car_id) REFERENCES Cars(id);
ALTER TABLE Orders ADD CONSTRAINT users_id_FK FOREIGN KEY (user_id) REFERENCES Users(id);
ALTER TABLE Cars ADD CONSTRAINT car_params_id_FK FOREIGN KEY (car_params_id) REFERENCES Car_params(id);

INSERT INTO User_roles (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO User_roles (id, role) VALUES (2, 'ROLE_ADMIN');
