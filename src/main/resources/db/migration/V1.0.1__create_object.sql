CREATE TABLE objectiot (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
status VARCHAR (255),
date TIMESTAMP(3),
minValue INT ,
maximValue INT ,
actualValue INT
);