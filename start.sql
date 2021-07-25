CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

CREATE TABLE account(
                        id int PRIMARY KEY,
                        userName text,
                        email text,
                        password varint
);
INSERT INTO account (id, userName, email, password)
VALUES (1, 'Ratto', 'Rissella@example.com', 'mcvg133');