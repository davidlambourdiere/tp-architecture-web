CREATE TABLE  heaterhistoric (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
startdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
endingdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
state VARCHAR(255),
heaterid VARCHAR(255)
);

CREATE TABLE  lighthistoric (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
startdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
endingdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
state VARCHAR(255),
lightid VARCHAR(255),
color VARCHAR(255),
percentage VARCHAR(255)
);

CREATE TABLE  clockhistoric (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
startdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
endingdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
state VARCHAR(255),
clockid VARCHAR(255)
);

CREATE TABLE  shutterhistoric (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
startdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
endingdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
state VARCHAR(255),
shutterid VARCHAR(255),
percentage VARCHAR(255)
);

CREATE TABLE  straphistoric (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
startdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
endingdate TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
state VARCHAR(255),
strapid VARCHAR(255)
);