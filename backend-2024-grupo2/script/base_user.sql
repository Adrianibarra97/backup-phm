CREATE TABLE base_user(
    id SERIAL NOT NULL PRIMARY KEY,
    base_user_name VARCHAR(40),
    sur_name VARCHAR(40),
    user_name VARCHAR(40),
    image_url VARCHAR(40),
    country VARCHAR(40),
    dni INT,
    base_user_password INT,
    available_money DECIMAL(5),
    birth_of_date DATE,
    show_id INT NULL REFERENCES show(id),
    role_id INT NOT NULL
);