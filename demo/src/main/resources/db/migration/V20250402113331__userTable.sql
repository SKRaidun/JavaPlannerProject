CREATE TABLE user_table (
        id BIGSERIAL PRIMARY KEY,
        login VARCHAR UNIQUE NOT NULL,
        passwd VARCHAR NOT NULL);

CREATE INDEX user_login_idx ON user_table (login);