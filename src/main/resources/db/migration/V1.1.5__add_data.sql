INSERT INTO lifetech.residence (adress) VALUES ("10 avenue de paris");


INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Jean-Paul', 'Gauthier', 'admin', 'admin', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Justin', 'Aguesse', 'Justindu94', 'jujulebg', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Louis', 'Beaudin', 'Loulou', 'Louis123', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Marie', 'Collin', 'Coco', 'Marie145', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Mohammed', 'Henni', 'Momo', 'Momodu13', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password,userrole, residence_id) VALUES ('Henry', 'Dupont', 'Henry', 'henry','RESIDENT', 1);

INSERT INTO lifetech.person(firstname,lastname,login,password,profileType,residence_id) VALUES ('Mohamed','Emam','mohamed','mohamed','essential',1);
INSERT INTO lifetech.person(firstname,lastname,login,password,profileType,residence_id) VALUES ('Lucas','Meunier','lucas','lucas','serenity',1);
INSERT INTO lifetech.person(firstname,lastname,login,password,profileType,residence_id) VALUES ('Tristan','Da Silva','tristan','tristan','confort',1);
INSERT INTO lifetech.person(firstname,lastname,login,password,profileType,residence_id) VALUES ('Alexis','Boisseau','alexis','alexis','total-confort',1);

INSERT INTO lifetech.room (num) VALUES (1);
INSERT INTO lifetech.room (num) VALUES (2);
INSERT INTO lifetech.room (num) VALUES (3);
INSERT INTO lifetech.room (num) VALUES (4);
INSERT INTO lifetech.room (num) VALUES (5);

INSERT INTO lifetech.light (ipadress, state, breakdownstatus, percentage, color, person_id, room_id,price) VALUES ('172.163.92.0','ON','NOT_BREAKDOWN', '92%', 'blue', 1, 1,130);
INSERT INTO lifetech.light (ipadress, state, breakdownstatus, percentage, color, person_id, room_id) VALUES ('172.163.92.2','ON','NOT_BREAKDOWN', '28%', 'red', 2, 2);


INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id,price) VALUES ('172.163.92.4','ON','NOT_BREAKDOWN', 3, 3,150);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.5','OFF','NOT_BREAKDOWN', 4, 4);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.6','ON','NOT_BREAKDOWN', 5, 5);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.6','ON','NOT_BREAKDOWN', 5, 3);



INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id,price) VALUES ('172.163.92.8','ON','NOT_BREAKDOWN', 1, 1,150);
INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.9','OFF','NOT_BREAKDOWN', 1, 1);


INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id,price) VALUES ('172.163.92.12','ON','NOT_BREAKDOWN', '50%', 3, 3,70);
INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id) VALUES ('172.163.92.13','ON','NOT_BREAKDOWN', '50%', 5, 5);


INSERT INTO lifetech.strap (ipadress, state,breakdownstatus, minsysto, maxsysto, minsteps, person_id,price) VALUES ('172.163.92.16','ON','NOT_BREAKDOWN', '300mg', '600mg', '300', 2,125);


INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-24 9:00:00","2020-02-24 12:00:00","WHITE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 23:00:00","2020-02-24 9:00:00","WHITE",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 18:00:00","2020-02-23 23:00:00","WHITE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 12:00:00","2020-02-23 15:00:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 11:50:00","2020-02-23 12:00:00","GREEN",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 10:00:00","2020-02-23 11:50:00","GREEN",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 09:00:00","2020-02-23 10:00:00","GREEN",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-23 08:30:00","2020-02-23 09:00:00","PURPLE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 20:30:00","2020-02-23 08:30:00","PURPLE",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 20:00:00","2020-02-22 20:30:00","PURPLE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-02-22 19:00:00","2020-02-22 20:00:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-02-22 17:00:00","2019-02-22 19:00:00","RED",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 16:00:00","2020-02-22 17:00:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 15:30:00","2020-02-22 16:00:00","YELLOW",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 14:00:00","2020-02-22 15:30:00","WHITE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-22 08:00:00","2020-02-22 14:00:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 23:40:00","2020-02-22 08:00:00","RED",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 22:00:00","2020-02-21 23:40:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 20:00:00","2020-02-21 22:00:00","RED",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 17:00:00","2020-02-21 20:00:00","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 15:00:00","2020-02-21 16:00:00","WHITE",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-21 12:00:00","2020-02-21 15:00:00","WHITE",'OFF',"NOT_BREAKDOWN",1);


INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state, breakdownstatus,heaterid) VALUES ("2020-02-08 00:00:00","2020-02-10 00:00:00","18",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-06 00:00:00","2020-02-08 00:00:00","0",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-03 00:00:00","2020-02-06 00:00:00","19",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-28 00:00:00","2020-02-01 00:00:00","0",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-22 00:00:00","2020-01-28 00:00:00","19",'ON',"NOT_BREAKDOWN",1);


INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state, breakdownstatus,heaterid) VALUES ("2020-02-08 00:00:00","2020-02-10 00:00:00","19",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-06 00:00:00","2020-02-08 00:00:00","0",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-03 00:00:00","2020-02-06 00:00:00","25",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-28 00:00:00","2020-02-03 00:00:00","0",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-26 00:00:00","2020-01-28 00:00:00","0",'OFF',"BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-22 00:00:00","2020-01-26 00:00:00","0",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-17 00:00:00","2020-01-22 00:00:00","21",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-12 00:00:00","2020-01-17 00:00:00","18",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-06 00:00:00","2020-01-12 00:00:00","15",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-02 00:00:00","2020-01-06 00:00:00","0",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-26 00:00:00","2020-01-02 00:00:00","22",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-24 00:00:00","2019-12-26 00:00:00","15",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-12-20 00:00:00","2020-12-24 00:00:00","0",'OFF',"NOT_BREAKDOWN",2);

INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state, breakdownstatus,heaterid) VALUES ("2020-02-08 00:00:00","2020-02-10 00:00:00","16",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-06 00:00:00","2020-02-08 00:00:00","0",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-03 00:00:00","2020-02-06 00:00:00","18",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-28 00:00:00","2020-02-03 00:00:00","0",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-12 00:00:00","2020-01-28 00:00:00","18",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-06 00:00:00","2020-01-12 00:00:00","0",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-02 00:00:00","2020-01-06 00:00:00","17",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-26 00:00:00","2020-01-02 00:00:00","45",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-24 00:00:00","2019-12-26 00:00:00","14",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-12-20 00:00:00","2020-12-24 00:00:00","0",'OFF',"NOT_BREAKDOWN",3);


INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-02-23 23:00:00","2020-02-24 09:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-02-10 01:00:00","2020-02-23 23:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-02-02 10:00:00","2020-02-10 01:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-01-29 23:00:00","2020-02-02 10:00:00",'OFF',"NOT_BREAKDOWN",1);


INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-02-09 23:00:00","2020-02-24 09:00:00",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-02-03 01:00:00","2020-02-09 23:00:00",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-01-28 10:00:00","2020-02-03 01:00:00",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.clockhistoric (startdate, endingdate,state, breakdownstatus,clockid) VALUES ("2020-01-26 23:00:00","2020-01-28 10:00:00",'OFF',"NOT_BREAKDOWN",2);


INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-23 23:00:00","2020-02-24 10:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-23 10:00:00","2020-02-23 23:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-23 08:00:00","2020-02-23 10:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-19 23:00:00","2020-02-23 08:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-17 23:30:00","2020-02-19 23:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-14 23:00:00","2020-02-17 23:30:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-01-26 10:00:00","2020-02-14 23:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-01-26 08:00:00","2020-01-26 10:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-01-25 23:00:00","2020-01-26 08:00:00",'ON',"NOT_BREAKDOWN",1);

INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-23 23:00:00","2020-02-24 10:00:00",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-16 08:00:00","2020-02-23 23:00:00",'OFF',"BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-15 23:00:00","2020-02-16 08:00:00",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-14 23:00:00","2020-02-15 23:00:00",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-10 23:00:00","2020-02-14 23:00:00",'OFF',"BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-09 02:00:00","2020-02-10 23:00:00",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-02-06 23:00:00","2020-02-09 02:00:00",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-01-27 23:00:00","2020-02-06 23:00:00",'OFF',"BREAKDOWN",2);
INSERT INTO lifetech.shutterhistoric (startdate, endingdate,state, breakdownstatus,shutterid) VALUES ("2020-01-25 00:00:00","2020-01-27 23:00:00",'ON',"NOT_BREAKDOWN",2);


INSERT INTO lifetech.straphistoric (startdate, endingdate,state, breakdownstatus,strapid) VALUES ("2020-02-22 00:00:00","2020-02-24 23:00:00",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.straphistoric (startdate, endingdate,state, breakdownstatus,strapid) VALUES ("2020-01-25 00:00:00","2020-02-22 00:00:00",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.straphistoric (startdate, endingdate,state, breakdownstatus,strapid) VALUES ("2020-01-24 00:00:00","2020-01-25 00:00:00",'OFF',"NOT_BREAKDOWN",1);

INSERT INTO lifetech.subscription (name,description, listofiot,listofservice) VALUES ('essential','This subscription is for our residents who enjoy tranquility and security.', 'Strap,Heater', 'Sport');
INSERT INTO lifetech.subscription (name,description,listofiot,listofservice) VALUES ('serenity', 'This subscription is intended for our resident who like pratice and love connected objects','Strap,Light,Heater', 'Bingo,Yoga');
INSERT INTO lifetech.subscription (name,description,listofiot,listofservice) VALUES ('confort','This subscription is intended for our residents who can not stay in place and want to associate activites ans connected objects', 'Strap,Light,Heater,Shutter', 'Cultural Visite,Sport,Cinema');
INSERT INTO lifetech.subscription (name,description, listofiot,listofservice) VALUES ('total-confort','This subscription is for our residents who need connected objects to help them in everyday life', 'Strap,Light,Shutter,Heater,Clock', 'Bingo');

INSERT INTO lifetech.referencesprices (descriptionService, nameService, numSerie, price) VALUES ('blabla', 'bingo','S01', '25');
INSERT INTO lifetech.referencesprices (descriptionService, nameService, numSerie, price) VALUES ('blabla', 'cinéma','A01', '100');
INSERT INTO lifetech.referencesprices (descriptionService, nameService, numSerie, price) VALUES ('blabla', 'sport', 'A01', '45');
INSERT INTO lifetech.referencesprices (descriptionService, nameService, numSerie, price) VALUES ('blabla', 'yoga', 'S01', '30');
INSERT INTO lifetech.referencesprices (descriptionService, nameService, numSerie, price) VALUES ('blabla', 'viste culturel', 'A01', '50');
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id) VALUES ('5','4','ON','105','2020-01-21 15:05:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','24','2020-01-21 15:06:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id) VALUES ('5','4','ON','24','2020-01-21 15:05:29',2);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','24','2020-01-21 15:06:29',2);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','24','2020-01-21 15:07:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id) VALUES ('5','4','ON','105','2020-01-21 15:05:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','105','2020-01-22 15:05:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','107','2020-01-23 15:05:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','68','2020-01-22 15:05:29',3);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','107','2020-01-23 15:05:29',4);
INSERT INTO lifetech.heatermessage (minvaluerefmessage,maxvaluerefmessage,statemessage,temperaturemessage,insertdate,heater_id)  VALUES ('5','4','ON','68','2020-01-22 15:05:29',1);


