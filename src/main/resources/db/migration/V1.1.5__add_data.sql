INSERT INTO lifetech.residence (adress) VALUES ("10 avenue de paris");

INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Jean-Paul', 'Gauthier', 'admin', 'admin', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Justin', 'Aguesse', 'Justindu94', 'jujulebg', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Louis', 'Beaudin', 'Loulou', 'Louis123', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Marie', 'Collin', 'Coco', 'Marie145', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Mohammed', 'Henni', 'Momo', 'Momodu13', 1);
INSERT INTO lifetech.person (firstname, lastname, login, password, residence_id) VALUES ('Henry', 'Dupont', 'Henry', 'henry', 1);

INSERT INTO lifetech.room (num) VALUES (1);
INSERT INTO lifetech.room (num) VALUES (2);

INSERT INTO lifetech.light (ipadress, state, breakdownstatus, percentage, color, person_id, room_id) VALUES ('172.163.92.0','ON','NOT_BREAKDOWN', '92%', 'blue', 2, 1);
INSERT INTO lifetech.light (ipadress, state, breakdownstatus, percentage, color, person_id, room_id) VALUES ('172.163.92.1','OFF','NOT_BREAKDOWN', '0%', 'white',2, 1);
INSERT INTO lifetech.light (ipadress, state, breakdownstatus, percentage, color, person_id, room_id) VALUES ('172.163.92.2','ON','NOT_BREAKDOWN', '0%', 'red', 5, 2);
INSERT INTO lifetech.light (ipadress, state,breakdownstatus, percentage, color, person_id, room_id) VALUES ('172.163.92.3','OFF','NOT_BREAKDOWN', '100%', 'green', 3, 2);

INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.4','ON','NOT_BREAKDOWN', 3, 1);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.5','OFF','NOT_BREAKDOWN', 4, 1);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.6','ON','NOT_BREAKDOWN', 2, 2);
INSERT INTO lifetech.heater (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.7','OFF','NOT_BREAKDOWN', 1, 2);

INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.8','ON','NOT_BREAKDOWN', 2, 1);
INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.9','OFF','NOT_BREAKDOWN', 6, 1);
INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.10','OFF','NOT_BREAKDOWN', 4, 2);
INSERT INTO lifetech.clock (ipadress, state,breakdownstatus, person_id, room_id) VALUES ('172.163.92.11','ON','NOT_BREAKDOWN', 5, 2);

INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id) VALUES ('172.163.92.12','ON','NOT_BREAKDOWN', '50%', 3, 1);
INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id) VALUES ('172.163.92.13','ON','NOT_BREAKDOWN', '50%', 3, 1);
INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id) VALUES ('172.163.92.14','ON','NOT_BREAKDOWN', '50%', 3, 2);
INSERT INTO lifetech.shutter (ipadress, state,breakdownstatus, percentage, person_id, room_id) VALUES ('172.163.92.15','ON','NOT_BREAKDOWN', '50%', 3, 2);

INSERT INTO lifetech.strap (ipadress, state,breakdownstatus, minsysto, maxsysto, minsteps, person_id) VALUES ('172.163.92.16','ON','NOT_BREAKDOWN', '300mg', '600mg', '300', 2);
INSERT INTO lifetech.strap (ipadress, state,breakdownstatus, minsysto, maxsysto, minsteps, person_id) VALUES ('172.163.92.17','OFF', 'NOT_BREAKDOWN','300mg', '600mg', '300', 4);
INSERT INTO lifetech.strap (ipadress, state,breakdownstatus, minsysto, maxsysto, minsteps, person_id) VALUES ('172.163.92.18','ON','NOT_BREAKDOWN', '300mg', '600mg', '300', 5);
INSERT INTO lifetech.strap (ipadress, state,breakdownstatus, minsysto, maxsysto, minsteps, person_id) VALUES ('172.163.92.19','ON','NOT_BREAKDOWN', '300mg', '600mg', '300', 6);

INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-08","2020-02-10","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-06","2020-02-08","YELLOW",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-03","2020-02-06","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-28","2020-02-01","RED",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-22","2020-01-28","GREEN",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-17","2020-01-22","BLUE",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-12","2020-01-17","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-06","2020-01-12","PURPLE",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-02","2020-01-06","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-26","2020-01-02","RED",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-24","2019-12-26","RED",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-12-20","2020-12-24","RED",'OFF',"NOT_BREAKDOWN",1);

INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-06","2020-02-08","YELLOW",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-04","2020-02-06","RED",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-01","2020-02-04","RED",'OFF',"BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-28","2020-02-01","RED",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-22","2020-01-28","GREEN",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-17","2020-01-22","BLUE",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-12","2020-01-17","RED",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-06","2020-01-12","PURPLE",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-02","2020-01-06","RED",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-26","2020-01-02","RED",'OFF',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-24","2019-12-26","RED",'ON',"NOT_BREAKDOWN",2);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-12-20","2020-12-24","RED",'OFF',"NOT_BREAKDOWN",2);

INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-08","2020-02-10","RED",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-06","2020-02-08","YELLOW",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-02-03","2020-02-06","RED",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-28","2020-02-01","RED",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-22","2020-01-28","RED",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-17","2020-01-22","BLUE",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-12","2020-01-17","BLUE",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-06","2020-01-12","BLUE",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-01-02","2020-01-06","PURPLE",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-26","2020-01-02","PURPLE",'OFF',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2019-12-24","2019-12-26","PURPLE",'ON',"NOT_BREAKDOWN",3);
INSERT INTO lifetech.lighthistoric (startdate, endingdate,color,state,breakdownstatus,lightid) VALUES ("2020-12-20","2020-12-24","RED",'ON',"NOT_BREAKDOWN",3);

INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state, breakdownstatus,heaterid) VALUES ("2020-02-08","2020-02-10","10",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-06","2020-02-08","25",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-02-03","2020-02-06","0",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-28","2020-02-01","12",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-22","2020-01-28","5",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-17","2020-01-22","9",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-12","2020-01-17","15",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-06","2020-01-12","24",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-01-02","2020-01-06","28",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-26","2020-01-02","26",'OFF',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2019-12-24","2019-12-26","14",'ON',"NOT_BREAKDOWN",1);
INSERT INTO lifetech.heaterhistoric (startdate, endingdate,temperature,state,breakdownstatus,heaterid) VALUES ("2020-12-20","2020-12-24","12",'OFF',"NOT_BREAKDOWN",1);