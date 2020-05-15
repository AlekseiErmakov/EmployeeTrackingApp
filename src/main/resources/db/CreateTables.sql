CREATE TABLE code
(
    code_id SERIAL PRIMARY KEY NOT NULL ,
    char_code CHARACTER VARYING(5),
    description CHARACTER VARYING(255),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

CREATE TABLE absence
(
    vacation_id BIGSERIAL PRIMARY KEY NOT NULL ,
    date_start TIMESTAMP,
    date_end TIMESTAMP,
    person_id BIGINT,
    code_id INTEGER,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES person(person_id),
    FOREIGN KEY (code_id) REFERENCES code(code_id)
);
CREATE TABLE department
(
    department_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP
);
CREATE TABLE person
(
    person_id BIGSERIAL PRIMARY KEY  NOT NULL ,
    num CHARACTER VARYING(30),
    first_name CHARACTER VARYING(30),
    last_name CHARACTER VARYING(30),
    birthday TIMESTAMP,
    is_remote BOOLEAN,
    department_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE contact
(
    contact_id BIGSERIAL PRIMARY KEY NOT NULL ,
    email CHARACTER VARYING(30),
    phone CHARACTER VARYING(20),
    person_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

CREATE TABLE address
(
    address_id BIGSERIAL PRIMARY KEY NOT NULL ,
    city CHARACTER VARYING(30),
    street CHARACTER VARYING(30),
    house CHARACTER VARYING(10),
    flat INTEGER,
    person_id BIGINT,
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES person(person_id)
);

CREATE TABLE post
(
    post_id BIGSERIAL PRIMARY KEY NOT NULL ,
    name CHARACTER VARYING(30),
    created TIMESTAMP NOT NULL ,
    updated TIMESTAMP
);

CREATE TABLE person_post
(
    person_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    PRIMARY KEY (person_id,post_id),
    FOREIGN KEY (person_id) REFERENCES person(person_id),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);

