INSERT INTO users (name, password) VALUES ('Bob', 'bob123');
INSERT INTO users (name, password) VALUES ('Don', '123');


INSERT INTO checkLists (name, userId) VALUES ('First checklist', '1');
INSERT INTO checkLists (name, userId) VALUES ('second checklist', '1');

INSERT INTO checkListItems (content, checkListId, completed) VALUES ('item1', '1', true);
INSERT INTO checkListItems (content, checkListId, completed) VALUES ('item2', '1', false);

INSERT INTO checkListItems (content, checkListId, completed) VALUES ('item1', '2', true);
INSERT INTO checkListItems (content, checkListId, completed) VALUES ('item1', '2', true);
