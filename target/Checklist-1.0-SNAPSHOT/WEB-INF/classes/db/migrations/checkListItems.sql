CREATE TABLE IF NOT EXISTS checkListItems (
    id SERIAL,
    content VARCHAR (255),
    checkListId REFERENCES checkLists (id)
)