INSERT INTO user(user_id, password, name, email) VALUES('lcy1111', '123456', 'changyong1', 'a1@a');
INSERT INTO user(user_id, password, name, email) VALUES('lcy1112', '123456', 'changyong2', 'a2@a');
INSERT INTO user(user_id, password, name, email) VALUES('lcy1113', '123456', 'changyong3', 'a3@a');
INSERT INTO user(user_id, password, name, email) VALUES('lcy1114', '123456', 'changyong4', 'a4@a');
INSERT INTO user(user_id, password, name, email) VALUES('lcy1115', '123456', 'changyong5', 'a5@a');

INSERT INTO question(contents, title, user_id) VALUES('hello aaa', 'aaa', 1);
INSERT INTO question(contents, title, user_id) VALUES('hello abc', 'abc', 1);

INSERT INTO answer(contents, question_id, user_id, deleted) VALUES('asd', 1, 1, false);