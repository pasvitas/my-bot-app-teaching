-- liquibase formatted sql

-- changeset pasvitas:1745650453025-1
CREATE SEQUENCE IF NOT EXISTS role_id_seq START WITH 1 INCREMENT BY 1;

-- changeset pasvitas:1745650453025-3
CREATE SEQUENCE IF NOT EXISTS users_id_seq START WITH 1 INCREMENT BY 1;

-- changeset pasvitas:1745650453025-4
CREATE TABLE roles
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

-- changeset pasvitas:1745650453025-6
CREATE TABLE users
(
    id       BIGINT NOT NULL,
    login    VARCHAR(255),
    password VARCHAR(255),
    role_id  BIGINT,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- changeset pasvitas:1745650453025-10
ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

