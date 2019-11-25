CREATE TABLE  iot (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
status VARCHAR(255),
state VARCHAR(255),
suspect VARCHAR(255),
startdate TIMESTAMP(3),
minvalueref VARCHAR (255),
maxvalueref VARCHAR(255),
activityduration TIMESTAMP(3),
person_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_iot_person_id FOREIGN KEY (person_id) REFERENCES person(id)
);