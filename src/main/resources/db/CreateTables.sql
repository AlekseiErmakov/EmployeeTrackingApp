DROP TABLE IF EXISTS code,holiday,department,post,employee,employee_post,absence,address,contact,employee_day,app_user,app_role,user_role, CASCADE ;

CREATE TABLE code
(
    code_id SERIAL PRIMARY KEY NOT NULL ,
    status CHARACTER VARYING(5),
    description CHARACTER VARYING(255),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

INSERT INTO code (status, description, created) VALUES ('Я','Полный рабочий день','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('Н','Отсутствие на рабочем месте по невыясненной причине','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('B','Выходные и праздничные дни','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('Рв','Работа в праздничные и выходные дни; а также работа в праздничные и выходные дни, при
нахождении в командировке','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('Б','Дни временной нетрудоспособности','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('К','Командировочные дни; а также, выходные (нерабочие) дни при нахождении в командировке,
когда сотрудник отдыхает, в соответствии с графиком работы ООО «Наука» в командировке','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('ОТ','Ежегодный основной оплаченный отпуск','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('До','Неоплачиваемый отпуск','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('Хд','Хозяйственный день','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('У','Отпуск на период обучения','2020-05-15');
INSERT INTO code (status, description, created) VALUES ('Ож','Отпуск по уходу за ребенком','2020-05-15');

CREATE TABLE holiday
(
    holiday_id SERIAL PRIMARY KEY NOT NULL ,
    date TIMESTAMP,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);
INSERT INTO holiday (date,created) VALUES ('2020-01-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-02','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-03','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-06','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-07','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-11','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-18','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-19','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-25','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-01-26','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-02','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-09','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-15','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-16','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-22','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-23','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-24','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-02-29','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-07','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-09','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-14','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-15','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-21','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-22','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-28','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-03-29','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-11','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-18','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-19','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-25','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-04-26','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-02','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-03','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-09','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-10','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-11','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-16','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-17','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-23','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-24','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-30','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-05-31','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-06','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-07','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-13','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-14','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-20','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-21','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-27','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-06-28','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-11','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-18','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-19','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-25','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-07-26','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-02','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-09','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-15','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-16','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-22','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-23','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-29','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-08-30','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-06','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-13','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-19','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-20','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-26','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-09-27','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-03','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-10','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-11','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-17','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-18','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-24','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-25','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-10-31','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-01','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-04','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-07','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-08','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-14','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-15','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-21','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-22','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-28','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-11-29','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-05','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-06','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-12','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-13','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-19','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-20','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-26','2020-05-15');
INSERT INTO holiday (date,created) VALUES ('2020-12-27','2020-05-15');

CREATE TABLE department
(
    department_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    label CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP
);

INSERT INTO department (name,label,created) VALUES ('Rocket Science Department','/img/deps/rocket-science.jpg','2020-05-15');
INSERT INTO department (name,label,created) VALUES ('Tesla Department','/img/deps/tesla.jpg','2020-05-15');
INSERT INTO department (name,label,created) VALUES ('HyperLoop Department','/img/deps/hyperloop.jpg','2020-05-15');
INSERT INTO department (name,label,created) VALUES ('Underground Department','/img/deps/underground.jpg','2020-05-15');
INSERT INTO department (name,label,created) VALUES ('Social Department','/img/deps/social.jpg','2020-05-15');
INSERT INTO department (name,label,created) VALUES ('Game Dev Department','/img/deps/game-dev.jpg','2020-05-15');

CREATE TABLE contact
(
    contact_id BIGSERIAL PRIMARY KEY NOT NULL ,
    email CHARACTER VARYING(30),
    phone CHARACTER VARYING(20),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

CREATE TABLE address
(
    address_id BIGSERIAL PRIMARY KEY NOT NULL ,
    city CHARACTER VARYING(30),
    street CHARACTER VARYING(30),
    house CHARACTER VARYING(10),
    flat CHARACTER VARYING(10),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);
CREATE TABLE post
(
    post_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);
CREATE TABLE employee
(
    employee_id BIGSERIAL PRIMARY KEY  NOT NULL ,
    num CHARACTER VARYING(30),
    first_name CHARACTER VARYING(30),
    last_name CHARACTER VARYING(30),
    birthday TIMESTAMP,
    gender CHARACTER VARYING(30),
    is_remote BOOLEAN,
    address_id BIGINT,
    contact_id BIGINT,
    department_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (contact_id) REFERENCES contact(contact_id),
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
CREATE TABLE employee_day
(
    employee_day_id BIGSERIAL PRIMARY KEY ,
    date TIMESTAMP,
    code_id INTEGER,
    employee_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (code_id) REFERENCES code(code_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE app_user
(
    app_user_id BIGSERIAL PRIMARY KEY ,
    username CHARACTER VARYING(255) NOT NULL UNIQUE,
    password CHARACTER VARYING(255) NOT NULL,
    email CHARACTER VARYING(255) NOT NULL UNIQUE ,
    phone_number CHARACTER VARYING(255) NOT NULL UNIQUE,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP
);

CREATE TABLE app_role
(
    app_role_id BIGSERIAL PRIMARY KEY ,
    name CHARACTER VARYING(30) NOT NULL ,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

CREATE TABLE user_role
(
    app_user_id BIGINT NOT NULL ,
    app_role_id BIGINT NOT NULL ,
    PRIMARY KEY (app_user_id, app_role_id),
    FOREIGN KEY (app_user_id) REFERENCES app_user(app_user_id),
    FOREIGN KEY (app_role_id) REFERENCES app_role(app_role_id)
);

INSERT INTO app_role (name, created) VALUES ('ROLE_USER','2020-05-15');
INSERT INTO app_role (name, created) VALUES ('ROLE_ADMIN','2020-05-15');


