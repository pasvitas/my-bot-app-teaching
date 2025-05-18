-- liquibase formatted sql

-- changeset pasvitas:1745047298706-1
CREATE SEQUENCE IF NOT EXISTS teacher_id_seq START WITH 1 INCREMENT BY 1;

-- changeset pasvitas:1745047298706-2
CREATE TABLE teachers
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_teachers PRIMARY KEY (id)
);

-- changeset pasvitas:1745047298706-3
ALTER TABLE groups
    ADD teacher_id BIGINT;

-- changeset pasvitas:1745047298706-4
ALTER TABLE groups
    ADD CONSTRAINT uc_groups_teacher UNIQUE (teacher_id);

-- changeset pasvitas:1745047298706-5
ALTER TABLE groups
    ADD CONSTRAINT FK_GROUPS_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teachers (id);

