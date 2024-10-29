CREATE TABLE role(
    id SERIAL NOT NULL PRIMARY KEY,
    role_name VARCHAR(40),
    is_administrator BOOLEAN
);