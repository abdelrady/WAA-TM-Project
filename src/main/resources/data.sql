create table if not exists persistent_logins (
                                               username varchar_ignorecase(100) not null,
                                               series varchar(64) primary key,
                                               token varchar(64) not null,
                                               last_used timestamp not null
);

INSERT INTO Role VALUES (1, 'ADMIN');

INSERT INTO Role VALUES (2, 'FACULTY');
INSERT INTO Role VALUES (3, 'STUDENT');

INSERT INTO User(user_id,active, email, name, last_name, password) values(1,1, 'atantawy@mum.edu', 'Abdelrady', 'Tantawy', '$2a$10$.YWv5U13xQQdeWCYSZx8UeauVA3N4byEtBZgNLDwfVUj2iQ6UcB72');
INSERT INTO User(user_id,active, email, name, last_name, password) values(2,1, 'rxing@mum.edu', 'Tina', 'Xing', '$2a$10$.YWv5U13xQQdeWCYSZx8UeauVA3N4byEtBZgNLDwfVUj2iQ6UcB72');
INSERT INTO User(user_id,active, email, name, last_name, password) values(3,1, 'jbreun@mum.edu', 'Joe', 'Breun', '$2a$10$.YWv5U13xQQdeWCYSZx8UeauVA3N4byEtBZgNLDwfVUj2iQ6UcB72');
INSERT INTO User(user_id,active, email, name, last_name, password) values(4,1, 'ehassan@mum.edu', 'Eman', 'Hassan', '$2a$10$.YWv5U13xQQdeWCYSZx8UeauVA3N4byEtBZgNLDwfVUj2iQ6UcB72');

INSERT into USER_ROLE values (1,3);
INSERT into USER_ROLE values (2,2);
INSERT into USER_ROLE values (3,3);
INSERT into USER_ROLE values (4,1);


INSERT INTO Student VALUES (986834, '11-18', 1);

INSERT INTO BLOCK VALUES (1, '11-18', '22', '2018-11-30',  '2018-11-01');
INSERT INTO BLOCK VALUES (2, '12-18', '21', '2018-12-31',  '2018-12-01');
INSERT INTO BLOCK VALUES (3, '01-19', '21', '2019-01-31',  '2019-01-01');
INSERT INTO BLOCK VALUES (4, '02-19', '22', '2019-02-28',  '2019-02-01');
INSERT INTO BLOCK VALUES (5, '03-19', '22', '2019-03-31',  '2019-03-01');
INSERT INTO BLOCK VALUES (6, '04-19', '21', '2019-04-30',  '2019-04-01');
INSERT INTO BLOCK VALUES (7, '05-19', '22', '2019-05-31',  '2019-05-01');
INSERT INTO BLOCK VALUES (8, '06-19', '22', '2019-06-30',  '2019-06-01');
INSERT INTO BLOCK VALUES (9, '07-19', '22', '2019-07-31',  '2019-07-01');

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

INSERT INTO STUDENTS_BLOCK_COURSES VALUES (986834, 1);
INSERT INTO STUDENTS_BLOCK_COURSES VALUES (986834, 3);

INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (1, '2018-11-01', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (2, '2018-11-02', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (3, '2018-11-03', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (4, '2018-11-04', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (5, '2018-11-05', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (6, '2018-11-06', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (7, '2018-11-07', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (8, '2018-11-08', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (9, '2018-11-09', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (10, '2018-11-10', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (11, '2018-11-11', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (12, '2018-11-12', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (13, '2018-11-13', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (14, '2018-11-14', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (15, '2018-11-15', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (16, '2018-11-16', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (17, '2018-11-17', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (18, '2018-11-18', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (19, '2018-11-19', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (20, '2018-12-01', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (21, '2018-12-02', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (22, '2018-12-03', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (23, '2018-12-04', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (24, '2018-12-05', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (25, '2018-12-06', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (26, '2018-12-06', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (27, '2018-12-07', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (28, '2018-12-08', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (29, '2018-12-09', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (30, '2018-12-10', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (31, '2018-12-11', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (32, '2018-12-12', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (33, '2018-12-13', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (34, '2018-12-14', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (35, '2018-12-15', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (36, '2018-12-16', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (37, '2018-12-17', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (38, '2018-12-18', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (39, '2018-12-19', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (40, '2018-12-20', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (41, '2018-12-21', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (42, '2018-12-22', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (43, '2018-12-23', 'Argiro', 0, 1, 986834);
INSERT INTO TM_ATTENDANCE(ID, DATE, LOCATION, TYPE, BLOCK_ID, STUDENT_ID) VALUES (44, '2018-12-24', 'Argiro', 0, 1, 986834);


INSERT INTO Entry (id, date_entry) VALUES (1, '2018-08-08');
INSERT INTO Entry (id, date_entry) VALUES (2, '2018-11-08');
INSERT INTO Entry (id, date_entry) VALUES (3, '2019-02-08');

