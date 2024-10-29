CREATE TABLE place_of_show(
    id SERIAL NOT NULL PRIMARY KEY,
    place_name VARCHAR(40),
    fixed_cost DECIMAL(5),
    location_id INT NOT NULL
);