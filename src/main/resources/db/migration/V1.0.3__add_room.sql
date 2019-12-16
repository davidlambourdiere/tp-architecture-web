CREATE TABLE  room (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
num VARCHAR(255)
);

ALTER TABLE lifetech.light ADD COLUMN room_id BIGINT UNSIGNED NOT NULL;

ALTER TABLE lifetech.light
ADD CONSTRAINT FK_light_room_id FOREIGN KEY (room_id) REFERENCES room(id);

ALTER TABLE lifetech.shutter ADD COLUMN room_id  BIGINT UNSIGNED NOT NULL;

ALTER TABLE lifetech.shutter
ADD CONSTRAINT FK_shutter_room_id FOREIGN KEY (room_id) REFERENCES room(id);


ALTER TABLE lifetech.heater ADD COLUMN room_id  BIGINT UNSIGNED NOT NULL;

ALTER TABLE lifetech.heater
ADD CONSTRAINT FK_heater_room_id FOREIGN KEY (room_id) REFERENCES room(id);


ALTER TABLE lifetech.clock ADD COLUMN room_id  BIGINT UNSIGNED NOT NULL;

ALTER TABLE lifetech.clock
ADD CONSTRAINT FK_clock_room_id FOREIGN KEY (room_id) REFERENCES room(id);