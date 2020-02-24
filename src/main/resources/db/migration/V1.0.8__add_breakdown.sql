CREATE TABLE  clockbreakdown (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
numclockbreakdown VARCHAR(255),
startdateclockbreakdown VARCHAR(255),
enddateclockbreakdown VARCHAR(255),
suspectclockbreakdown VARCHAR(255),
stopclockbreakdown VARCHAR(255),
messageclockbreakdown VARCHAR(255),
iotclockbreakdown_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_breakdown_clock_id FOREIGN KEY (iotclockbreakdown_id) REFERENCES clock(id)
);

CREATE TABLE  heaterbreakdown (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
numheaterbreakdown VARCHAR(255),
startdateheaterbreakdown VARCHAR(255),
enddateheaterbreakdown VARCHAR(255),
suspectheaterbreakdown VARCHAR(255),
stopheaterbreakdown VARCHAR(255),
messageheaterbreakdown VARCHAR(255),
iotheaterbreakdown_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_breakdown_heater_id FOREIGN KEY (iotheaterbreakdown_id) REFERENCES heater(id)
);

CREATE TABLE  lightbreakdown (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
numlightbreakdown VARCHAR(255),
startdatelightbreakdown VARCHAR(255),
enddatelightbreakdown VARCHAR(255),
suspectlightbreakdown VARCHAR(255),
stoplightbreakdown VARCHAR(255),
messagelightbreakdown VARCHAR(255),
iotlightbreakdown_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_breakdown_light_id FOREIGN KEY (iotlightbreakdown_id) REFERENCES light(id)
);

CREATE TABLE  strapbreakdown (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
numstrapbreakdown VARCHAR(255),
startdatestrapbreakdown VARCHAR(255),
enddatestrapbreakdown VARCHAR(255),
suspectstrapbreakdown VARCHAR(255),
stopstrapbreakdown VARCHAR(255),
messagestrapbreakdown VARCHAR(255),
iotstrapbreakdown_id  BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_breakdown_strap_id FOREIGN KEY (iotstrapbreakdown_id) REFERENCES strap(id)
);