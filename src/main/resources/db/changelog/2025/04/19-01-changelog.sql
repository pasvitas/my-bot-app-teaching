-- liquibase formatted sql

-- changeset pasvitas:1745046312576-1
CREATE SEQUENCE IF NOT EXISTS groups_id_seq START WITH 1 INCREMENT BY 1;

-- changeset pasvitas:1745046312576-2
CREATE SEQUENCE IF NOT EXISTS students_id_seq START WITH 1 INCREMENT BY 1;

-- changeset pasvitas:1745046312576-3
CREATE TABLE groups
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_groups PRIMARY KEY (id)
);

-- changeset pasvitas:1745046312576-4
CREATE TABLE students
(
    id          BIGINT NOT NULL,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    group_id    BIGINT,
    CONSTRAINT pk_students PRIMARY KEY (id)
);

-- changeset pasvitas:1745046312576-5
ALTER TABLE students
    ADD CONSTRAINT FK_STUDENTS_ON_GROUP FOREIGN KEY (group_id) REFERENCES groups (id);

