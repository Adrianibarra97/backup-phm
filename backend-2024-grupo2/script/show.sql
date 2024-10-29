CREATE TABLE show(
    id SERIAL NOT NULL PRIMARY KEY,
    band_name VARCHAR(40),
    name_of_recital VARCHAR(40),
    img VARCHAR(40),
    cost_band DECIMAL(5),
    function_show_id INT NULL REFERENCES function_show(id),
    place_of_show_id INT NOT NULL,
    comment_id INT NULL REFERENCES comment(id),
    status_show_id INT NOT NULL
);