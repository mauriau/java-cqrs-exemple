CREATE TABLE "user"
(
    id       UUID NOT NULL,
    username VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);