CREATE TABLE IF NOT EXISTS checkListItems (
    id SERIAL,
    content VARCHAR (255),
    checkListId int REFERENCES checkList (id),
    PRIMARY KEY (id)
);