-- CREATE TABLE IF NOT EXISTS clients
-- (
--     id    SERIAL PRIMARY KEY ,
--     name  VARCHAR(200) NOT NULL ,
--     email VARCHAR(254) NOT NULL ,
--     phone VARCHAR(50)  NOT NULL
-- );
--    DROP TABLE IF EXISTS client

-- DROP TABLE IF EXISTS clients;
-- DROP SEQUENCE IF EXISTS clients_id_seq
--
CREATE TABLE IF NOT EXISTS clients
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(50)  NOT NULL
);
CREATE SEQUENCE clients_id_seq START WITH 3 INCREMENT BY 1;