CREATE TABLE IF NOT EXISTS checklist (
    id SERIAL,
    name VARCHAR (50),
    userId INTEGER REFERENCES users (id),
    PRIMARY KEY (id)
    );