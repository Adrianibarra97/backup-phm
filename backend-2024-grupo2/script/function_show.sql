CREATE TABLE function_show(
    id SERIAL NOT NULL PRIMARY KEY,
    hour_of_function DATE,
    ticket_id INT NULL REFERENCES ticket(id)
);