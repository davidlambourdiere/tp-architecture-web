CREATE TABLE  heatermessage (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
minvaluerefmessage VARCHAR (255),
maxvaluerefmessage VARCHAR(255),
statemessage VARCHAR(255),
temperaturemessage VARCHAR(255),
insertdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
heater_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_heatermessage_heater_id FOREIGN KEY (heater_id) REFERENCES heater(id)
);