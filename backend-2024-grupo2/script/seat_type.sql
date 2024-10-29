CREATE TABLE seat_type(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(40),
    capacity INT,
    cost_seat_type DECIMAL(5)
);