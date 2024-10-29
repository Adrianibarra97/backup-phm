CREATE TABLE comment(
    id SERIAL NOT NULL PRIMARY KEY,
    score INT,
    description_comment VARCHAR(40),
    date_comment DATE,
    show_id INT NOT NULL,
    base_user_id INT NOT NULL
);