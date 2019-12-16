create table subscription (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
name VARCHAR(255),
price DOUBLE ,
description VARCHAR(255),
listofiot VARCHAR(255),
listofservice VARCHAR(255)
);


create table bill(
id SERIAL,
subscriptionid BIGINT UNSIGNED NOT NULL,
personid BIGINT UNSIGNED NOT NULL,
amount float,
programdate int,
primary key(id, subscriptionid, personid),
CONSTRAINT fk_subscription_bill_id foreign key (subscriptionid) references subscription (id),
CONSTRAINT fk_subscription_person_id foreign key (personid) references person (id)
);

