CREATE TABLE code
(
    code_id SERIAL PRIMARY KEY NOT NULL ,
    char_code CHARACTER VARYING(5),
    description CHARACTER VARYING(255),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

INSERT INTO code (char_code, description, created) VALUES ('Я','Полный рабочий день','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('Н','Отсутствие на рабочем месте по невыясненной причине','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('B','Выходные и праздничные дни','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('Рв','Работа в праздничные и выходные дни; а также работа в праздничные и выходные дни, при
нахождении в командировке','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('Б','Дни временной нетрудоспособности','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('К','Командировочные дни; а также, выходные (нерабочие) дни при нахождении в командировке,
когда сотрудник отдыхает, в соответствии с графиком работы ООО «Наука» в командировке','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('ОТ','Ежегодный основной оплаченный отпуск','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('До','Неоплачиваемый отпуск','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('Хд','Хозяйственный день','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('У','Отпуск на период обучения','2020-05-15');
INSERT INTO code (char_code, description, created) VALUES ('Ож','Отпуск по уходу за ребенком','2020-05-15');

CREATE TABLE holiday_weekend
(
      holiday_weekend_id SERIAL PRIMARY KEY NOT NULL ,
      date TIMESTAMP,
      code_id INTEGER,
      created TIMESTAMP NOT NULL ,
      updated TIMESTAMP
);
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-02',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-03',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-06',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-07',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-11',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-18',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-19',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-25',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-01-26',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-02',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-09',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-15',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-16',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-22',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-23',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-24',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-02-29',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-07',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-09',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-14',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-15',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-21',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-22',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-28',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-03-29',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-11',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-18',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-19',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-25',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-04-26',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-02',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-03',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-09',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-10',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-11',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-16',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-17',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-23',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-24',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-30',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-05-31',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-06',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-07',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-13',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-14',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-20',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-21',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-27',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-06-28',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-11',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-18',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-19',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-25',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-07-26',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-02',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-09',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-15',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-16',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-22',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-23',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-29',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-08-30',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-06',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-13',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-19',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-20',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-26',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-09-27',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-03',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-10',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-11',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-17',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-18',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-24',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-25',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-10-31',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-01',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-04',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-07',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-08',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-14',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-15',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-21',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-22',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-28',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-11-29',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-05',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-06',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-12',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-13',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-19',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-20',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-26',3,'2020-05-15');
INSERT INTO holiday_weekend (date,code_id,created) VALUES ('2020-12-27',3,'2020-05-15');


CREATE TABLE department
(
    department_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP
);

INSERT INTO department (name,created) VALUES ('Rocket Science Department','2020-05-15');
INSERT INTO department (name,created) VALUES ('Tesla Department','2020-05-15');
INSERT INTO department (name,created) VALUES ('HyperLoop Department','2020-05-15');
INSERT INTO department (name,created) VALUES ('Underground Department','2020-05-15');
INSERT INTO department (name,created) VALUES ('Social Department','2020-05-15');
INSERT INTO department (name,created) VALUES ('Game Dev Department','2020-05-15');
CREATE TABLE employee
(
    employee_id BIGSERIAL PRIMARY KEY  NOT NULL ,
    num CHARACTER VARYING(30),
    first_name CHARACTER VARYING(30),
    last_name CHARACTER VARYING(30),
    birthday TIMESTAMP,
    sex CHARACTER VARYING(30),
    is_remote BOOLEAN,
    department_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);
CREATE TABLE absence
(
    absence_id BIGSERIAL PRIMARY KEY NOT NULL ,
    date_start TIMESTAMP,
    date_end TIMESTAMP,
    employee_id BIGINT,
    code_id INTEGER,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (code_id) REFERENCES code(code_id)
);
CREATE TABLE contact
(
    contact_id BIGSERIAL PRIMARY KEY NOT NULL ,
    email CHARACTER VARYING(30),
    phone CHARACTER VARYING(20),
    employee_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE address
(
    address_id BIGSERIAL PRIMARY KEY NOT NULL ,
    city CHARACTER VARYING(30),
    street CHARACTER VARYING(30),
    house CHARACTER VARYING(10),
    flat INTEGER,
    employee_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE post
(
    post_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

INSERT INTO post (name, created) VALUES ('Frontend Developer','2020-05-15');
INSERT INTO post (name, created) VALUES ('Backend Developer','2020-05-15');
INSERT INTO post (name, created) VALUES ('Devops','2020-05-15');
INSERT INTO post (name, created) VALUES ('Big Data developer','2020-05-15');
INSERT INTO post (name, created) VALUES ('QA engineer','2020-05-15');
INSERT INTO post (name, created) VALUES ('Human resource manager','2020-05-15');
INSERT INTO post (name, created) VALUES ('Project Manager','2020-05-15');
INSERT INTO post (name, created) VALUES ('Frontend TeamLead','2020-05-15');
INSERT INTO post (name, created) VALUES ('Backend Teemlead','2020-05-15');
INSERT INTO post (name, created) VALUES ('SEO','2020-05-15');
INSERT INTO post (name, created) VALUES ('Designer','2020-05-15');
INSERT INTO post (name, created) VALUES ('Project manager','2020-05-15');


CREATE TABLE employee_post
(
    employee_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id,post_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);
CREATE TABLE worker_day
(
    worker_day_id BIGSERIAL PRIMARY KEY ,
    date TIMESTAMP,
    code_id INTEGER,
    absence_id INTEGER,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (code_id) references code(code_id),
    FOREIGN KEY (absence_id) references absence(absence_id)
)

