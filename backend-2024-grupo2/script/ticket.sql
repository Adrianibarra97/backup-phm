CREATE TABLE ticket(
    id SERIAL NOT NULL PRIMARY KEY,
    base_user_id INT NOT NULL,
    seat_type INT NOT NULL
);