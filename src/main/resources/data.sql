CREATE OR REPLACE FUNCTION insert_members_username() RETURNS TRIGGER AS '
    BEGIN
        IF NEW.table_name IS NULL THEN
            NEW.table_name := concat(''table'', NEW.id);
        END IF;
        RETURN new;
    END;
' LANGUAGE plpgsql;

DROP TABLE IF EXISTS users_states;
DROP TABLE IF EXISTS states;
DROP TABLE IF EXISTS custom_schedule;
DROP TABLE IF EXISTS users;

CREATE TABLE users (

                       id SERIAL PRIMARY KEY,
                       user_name VARCHAR(32)
);

CREATE TABLE custom_schedule (

                                 id SERIAL PRIMARY KEY NOT NULL,
                                 table_name VARCHAR(255),
                                 names TEXT[] NOT NULL,
                                 keys TEXT[] NOT NULL,
                                 "user" INT NOT NULL REFERENCES users(id),
                                 UNIQUE ("user", table_name)
);

CREATE TABLE states (

                        id SERIAL PRIMARY KEY,
                        state_name VARCHAR(255) NOT NULL UNIQUE,
                        num_of_stages INT NOT NULL
);

CREATE TABLE users_states (

                              id SERIAL PRIMARY KEY NOT NULL,
                              "user" INT NOT NULL REFERENCES users(id) UNIQUE,
                              state INT REFERENCES states(id),
                              stage INT NOT NULL
);

CREATE TRIGGER trig_insert_members_username
    BEFORE INSERT
    ON custom_schedule
    FOR EACH ROW
EXECUTE PROCEDURE insert_members_username();

INSERT INTO users(user_name)
VALUES ('kyrylo0629');

INSERT INTO custom_schedule(table_name, names, keys, "user")
VALUES (NULL, '{kyrylo, max, igor}', '{floor, fridge, table}', 1);

INSERT INTO states(state_name, num_of_stages)
VALUES ('create', 3);
