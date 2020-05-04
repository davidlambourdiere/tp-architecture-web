create table lifetech.position (
id serial,
optlock datetime,
date datetime not null,
latitude float,
longitude float,
strap_id int not null,
primary key (strap_id, id),
CONSTRAINT FK_strap_position_id FOREIGN KEY (strap_id) REFERENCES lifetech.strap(id));
