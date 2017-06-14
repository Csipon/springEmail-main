DROP SCHEMA IF EXISTS public CASCADE;
COMMIT;
CREATE SCHEMA public;
COMMIT;

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
  statuses_id INTEGER,
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
  customer_id INTEGER NOT NULL,
  manager_id INTEGER NOT NULL,
  status_id INTEGER NOT NULL,
  CONSTRAINT orders_PK PRIMARY KEY (id)
);

CREATE TABLE statuses (
  id BIGSERIAL NOT NULL,
  status varchar,
  CONSTRAINT statuses_PK PRIMARY KEY (id)
);

CREATE TABLE history (
  id BIGSERIAL NOT NULL,
  date TIMESTAMP NOT NULL,
  description TEXT,
  orders_id INTEGER NOT NULL,
  change_statuses_id INTEGER NOT NULL
);

ALTER TABLE users ADD CONSTRAINT user_roles_id_FK FOREIGN KEY (user_roles_id) REFERENCES user_roles(id);
ALTER TABLE orders ADD CONSTRAINT cars_id_FK FOREIGN KEY (car_id) REFERENCES cars(id);
ALTER TABLE orders ADD CONSTRAINT customer_id_FK FOREIGN KEY (customer_id) REFERENCES users(id);
ALTER TABLE orders ADD CONSTRAINT manager_id_FK FOREIGN KEY (manager_id) REFERENCES users(id);
ALTER TABLE orders ADD CONSTRAINT statuses_id_FK FOREIGN KEY (status_id) REFERENCES statuses(id);
ALTER TABLE cars ADD CONSTRAINT cars_details_id_FK FOREIGN KEY (car_details_id) REFERENCES car_details(id);
ALTER TABLE cars ADD CONSTRAINT cars_statuses_FK FOREIGN KEY (statuses_id) REFERENCES statuses(id);
ALTER TABLE history ADD CONSTRAINT history_orders_FK FOREIGN KEY (orders_id) REFERENCES orders(id);
ALTER TABLE history ADD CONSTRAINT history_statuses_FK FOREIGN KEY (change_statuses_id) REFERENCES statuses(id);

INSERT INTO user_roles (id, role) VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (id, role) VALUES (2, 'ROLE_ADMIN');

INSERT INTO statuses(status) VALUES ('ENABLE');
INSERT INTO statuses(status) VALUES ('RESERVED');
INSERT INTO statuses(status) VALUES ('ORDERED');

INSERT INTO statuses(status) VALUES ('NEW');
INSERT INTO statuses(status) VALUES ('PROCESSING');
INSERT INTO statuses(status) VALUES ('ACTIVE');
INSERT INTO statuses(status) VALUES ('FINISHED');



