CREATE TABLE IF NOT EXISTS checkListItems (
    id SERIAL,
    content VARCHAR (255),
    checkListId int REFERENCES checkLists (id),
    completed boolean,
    PRIMARY KEY (id)
);