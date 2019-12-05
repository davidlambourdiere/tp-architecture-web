CREATE TABLE person (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
firstname VARCHAR (255),
lastname VARCHAR (255),
login VARCHAR (255),
password VARCHAR (255),
deseas VARCHAR(255),
ismobile VARCHAR(255),
userevaluation INT,
userrole VARCHAR (255)
);
