
--member table
CREATE TABLE member(
member_id serial not null,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(50) not null,
phone_number varchar(13),
date_of_birth date not null,
flag boolean NOT NULL default true,
CONSTRAINT pk_member_member_id PRIMARY KEY (member_id)
);

--Events table
CREATE TABLE event(
event_id serial not null,
event_name varchar(50) not null,
description varchar(100) not null,
start_date_time timestamp not null,
duration integer not null,
group_id integer not null,
CONSTRAINT pk_events_event_id PRIMARY KEY (event_id),
CONSTRAINT ck_events_duration CHECK (duration >= 30)
);

--group table
CREATE TABLE interest_group(
group_id serial NOT NULL, 
interest_group_name varchar(50) UNIQUE NOT NULL,
CONSTRAINT pk_interest_group_group_id PRIMARY KEY (group_id)
);

-- Member Event
CREATE TABLE member_event (
member_id integer NOT NULL,
event_id integer NOT NULL,
CONSTRAINT pk_member_event_member_id_event_id PRIMARY KEY (member_id, event_id)
);

--Member Group
CREATE TABLE member_group (
member_id integer NOT NULL,
group_id integer NOT NULL,
CONSTRAINT pk_member_group_member_id_group_id PRIMARY KEY (member_id, group_id)
);

--ALTERS

--Membergroup alters
ALTER TABLE member_group
ADD FOREIGN KEY (group_id)
REFERENCES interest_group (group_id);
--Membegroup alters
ALTER TABLE member_group
ADD FOREIGN KEY (member_id)
REFERENCES member (member_id);
--Member event alters
ALTER TABLE member_event
ADD FOREIGN KEY (member_id)
REFERENCES member (member_id);
 --MEMber event alters
 ALTER TABLE member_event
ADD FOREIGN KEY (event_id)
REFERENCES event (event_id);
--Altering events
ALTER TABLE event
ADD FOREIGN KEY (group_id)
REFERENCES interest_group (group_id);

--INSERTS
--members
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Parton', 'Dolly', 'dollyisamazing@mountain.com', '555-345-3456', '1999-07-23', true);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Perry', 'Tyler', 'madeaisinthehouse@mountain.com', '444-345-1234', '1888-04-23', false);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Carter', 'Aaron', 'aaronisofftherails@mountain.com', null, '1994-02-04', true);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Naruto', 'Hulk', 'neverwatched@mountain.com', '888-180-1254', '1812-05-03', true);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Invincible', 'Mark', 'savetheworld@mountain.com', null, '1995-12-12', false);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Goku', 'Unknown', 'notmyfinalform@mountain.com', '345-234-1234', '1990-09-04', true);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Master', 'Roshi', 'gokuiswild@mountain.com', null, '1880-12-12', true);
INSERT INTO member (last_name, first_name, email, phone_number, date_of_birth, flag)
VALUES ('Ice', 'Cream', 'ihearanicecreamtruck@mountain.com', null, '1990-12-05', false);

--Groups
INSERT INTO interest_group (interest_group_name)
VALUES ('Rage Against the Machine Club');
INSERT INTO interest_group (interest_group_name)
VALUES ('seltzer water enthusiasts');
INSERT INTO interest_group (interest_group_name)
VALUES ('Little Nightmares Fan Club');

--Events
INSERT INTO event (event_name, description, start_date_time, duration, group_id) 
VALUES ('Moshpit Etiquete', 'Learn how to mosh with the best', '06-15-2021 5:30', 60,(SELECT group_id FROM interest_group WHERE interest_group_name = 'Rage Against the Machine Club'));

INSERT INTO event (event_name, description, start_date_time, duration, group_id) 
VALUES ('La Croix V. Perrier', 'The bubbliest of the bubblies duke it out.', '06-24-2021 22:30', 45, (SELECT group_id FROM interest_group WHERE interest_group_name = 'seltzer water enthusiasts'));

INSERT INTO event (event_name, description, start_date_time, duration, group_id) 
VALUES ('Rescue the Little Boy', 'Protect the little boy from the monsters Aah!', '11-20-2021 6:00', 60, (SELECT group_id FROM interest_group WHERE interest_group_name = 'Little Nightmares Fan Club'));

INSERT INTO event (event_name, description, start_date_time, duration, group_id) 
VALUES ('Zack de la Rocha Fan Club', 'All hail the the leader of the band', '04-18-2021 16:30', 30, (SELECT group_id FROM interest_group WHERE interest_group_name = 'Rage Against the Machine Club'));

--Members into groups
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Rage Against the Machine Club'),
       (SELECT member_id FROM member WHERE email = 'ihearanicecreamtruck@mountain.com' ));    
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Little Nightmares Fan Club'),
       (SELECT member_id FROM member WHERE email = 'gokuiswild@mountain.com' ));
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'seltzer water enthusiasts'),
       (SELECT member_id FROM member WHERE email = 'notmyfinalform@mountain.com' ));
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Little Nightmares Fan Club'),
       (SELECT member_id FROM member WHERE email = 'savetheworld@mountain.com' ));     
 INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'seltzer water enthusiasts'),
       (SELECT member_id FROM member WHERE email = 'neverwatched@mountain.com' ));
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Little Nightmares Fan Club'),
       (SELECT member_id FROM member WHERE email = 'aaronisofftherails@mountain.com' ));     
--Members to events
INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM event WHERE event_name = 'Moshpit Etiquete'),
       (SELECT member_id FROM member WHERE email = 'ihearanicecreamtruck@mountain.com' ));
INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM event WHERE event_name = 'La Croix V. Perrier'),
       (SELECT member_id FROM member WHERE email = 'neverwatched@mountain.com' ));
INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM event WHERE event_name = 'Rescue the Little Boy'),
       (SELECT member_id FROM member WHERE email = 'aaronisofftherails@mountain.com' ));
INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM event WHERE event_name = 'Zack de la Rocha Fan Club'),
       (SELECT member_id FROM member WHERE email = 'aaronisofftherails@mountain.com'));       
       