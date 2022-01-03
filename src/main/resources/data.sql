create or replace function insert_members_username() returns trigger as '
    begin
        if NEW.table_name is null then
            NEW.table_name := concat(''table'', NEW.id);
        end if;
        return new;
    end;
' language plpgsql;

DROP TABLE IF EXISTS users_states;
DROP TABLE IF EXISTS custom_schedule;
DROP TABLE IF EXISTS users;
CREATE TABLE users (

                       id SERIAL PRIMARY KEY,
                       user_name varchar(32)
);

CREATE TABLE custom_schedule (

                                 id SERIAL PRIMARY KEY NOT NULL,
                                 table_name varchar(255),
                                 names text[] NOT NULL,
                                 keys text[] NOT NULL,
                                 "user" int NOT NULL references users(id),
                                 UNIQUE ("user", table_name)
);

CREATE TABLE users_states (
                              id SERIAL PRIMARY KEY NOT NULL,
                              "user" int NOT NULL references users(id),
                              state varchar(255) NOT NULL
);

create trigger trig_insert_members_username
    before insert
    on custom_schedule
    for each row
execute procedure insert_members_username();

INSERT INTO users(user_name)
VALUES ('kyrylo0629');

INSERT INTO custom_schedule(table_name, names, keys, "user")
VALUES (null, '{kyrylo, max, igor}', '{floor, fridge, table}', 1);
