CREATE TABLE  lifetech.notification (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
message VARCHAR (1000),
isread BIT NOT NULL,
typeiot VARCHAR(30),
emetteur VARCHAR(50),
destinataire VARCHAR(50),
iotid VARCHAR(255)
);

create table lifetech.position (
id serial,
optlock datetime,
date datetime not null,
latitude float,
longitude float,
strap_id BIGINT UNSIGNED NOT NULL,
primary key (strap_id, id),
CONSTRAINT FK_strap_position_id FOREIGN KEY (strap_id) REFERENCES lifetech.strap(id));
