create table lifetech.extracost(
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
extraname VARCHAR(255),
date TIMESTAMP,
price DOUBLE,
id_person BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_person_extracost_id FOREIGN KEY (id_person) REFERENCES lifetech.person(id)
);