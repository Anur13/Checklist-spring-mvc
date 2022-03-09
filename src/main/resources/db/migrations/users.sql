CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    name VARCHAR (50),
    password VARCHAR (50),
    PRIMARY KEY (id)
    );




--    SELECT * FROM checkListItems WHERE checkListId IN (SELECT id FROM checkLists WHERE userId = 1 );
--SELECT * from checkLists  LEFT JOIN checkListItems on checkListItems.checklistid = checkLists.id where checkLists.userid = 1 ORDER BY checkListItems.checklistid;