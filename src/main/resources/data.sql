INSERT INTO Role VALUES (1, 'ADMIN');
INSERT INTO Role VALUES (2, 'Professor');
INSERT INTO Role VALUES (3, 'Student');

INSERT INTO User(user_id,active, email, name, last_name, password) values(1,1, 'atantawy@mum.edu', 'Abdelrady', 'Tantawy', '$2a$10$ZgRPJUO7A37cnK1ALVdfZuCsGBOSpYm4Rcs6jR2GVSKccok6iYnM6');
INSERT INTO User(user_id,active, email, name, last_name, password) values(2,1, 'rxing@mum.edu', 'Tina', 'Xing', '$2a$10$ZgRPJUO7A37cnK1ALVdfZuCsGBOSpYm4Rcs6jR2GVSKccok6iYnM6');
INSERT INTO User(user_id,active, email, name, last_name, password) values(3,1, 'jbreun@mum.edu', 'Joe', 'Breun', '$2a$10$ZgRPJUO7A37cnK1ALVdfZuCsGBOSpYm4Rcs6jR2GVSKccok6iYnM6');

INSERT INTO Student VALUES (986834, '11-18', 1);

INSERT INTO BLOCK VALUES (1, '11-18', '22', '2018-11-30',  '2018-11-01');
INSERT INTO BLOCK VALUES (2, '12-18', '22', '2018-12-31',  '2018-12-01');

INSERT INTO COURSE  VALUES (1, 'FPP');
INSERT INTO COURSE  VALUES (2, 'MPP');
INSERT INTO COURSE  VALUES (3, 'WAP');
INSERT INTO COURSE  VALUES (4, 'WAA');
INSERT INTO COURSE  VALUES (5, 'EA');

INSERT INTO PROFESSOR VALUES (1, 2);
INSERT INTO PROFESSOR VALUES (2, 3);

INSERT INTO COURSE_BLOCK(Id, Block_id, Course_id, Professor_id) values(1, 1, 1, 1);
INSERT INTO COURSE_BLOCK(Id, Block_id, Course_id, Professor_id) values(2, 1, 2, 2);
INSERT INTO COURSE_BLOCK(Id, Block_id, Course_id, Professor_id) values(3, 2, 3, 2);
INSERT INTO COURSE_BLOCK(Id, Block_id, Course_id, Professor_id) values(4, 2, 4, 1);

