CREATE TABLE users (
                      id           serial,
                      email        VARCHAR(255) NOT NULL,
                      image        VARCHAR(255),
                      name         VARCHAR(255) NOT NULL,
                      status       ENUM('OFFLINE', 'ONLINE') NOT NULL,
                      CONSTRAINT pk_user PRIMARY KEY (id),
                      CONSTRAINT uk_user_email UNIQUE (email)
);