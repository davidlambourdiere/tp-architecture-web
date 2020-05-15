create table lifetech.subscription (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
name VARCHAR(255),
price DOUBLE,
description VARCHAR(255),
listofiot VARCHAR(255),
listofservice VARCHAR(255)
);


create table lifetech.bill(
id SERIAL,
subscriptionid BIGINT UNSIGNED NOT NULL,
personid BIGINT UNSIGNED NOT NULL,
amount float,
programdate int,
primary key(id, subscriptionid, personid),
CONSTRAINT fk_subscription_bill_id foreign key (subscriptionid) references subscription (id),
CONSTRAINT fk_subscription_person_id foreign key (personid) references person(id)
);

create table lifetech.referencesPrices(
id SERIAL PRIMARY KEY,
numSerie VARCHAR(255),
type VARCHAR(255),
nameService VARCHAR (255),
descriptionService VARCHAR(255),
price DOUBLE
);

create table lifetech.subscriptionresident(
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
name VARCHAR(255),
description VARCHAR(255),
listofiot VARCHAR(255),
listofservice VARCHAR(255),
price DOUBLE,
id_person BIGINT UNSIGNED NOT NULL,
CONSTRAINT FK_person_subscription_id FOREIGN KEY (id_person) REFERENCES lifetech.person(id)
);

