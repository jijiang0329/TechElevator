--wrapping it all in a transaction so that it's either all the database gets created or none of it
BEGIN TRANSACTION;

--create the table
CREATE TABLE member (

	--create the columns (name datatype constraint)
	member_id serial PRIMARY KEY, -- serial is an auto incrementing int
	last_name varchar(100) NOT NULL,
	first_name varchar(100) NOT NULL,
	email_address varchar(250) NOT NULL,
	phone varchar(25) UNIQUE,
	birthday date NULL,
	isFlag boolean 
	
	--create the constraints (primary keys, foreign keys)
);

CREATE TABLE groups (
	
	--columns
	group_id serial PRIMARY KEY,
	group_title varchar(100) UNIQUE
	
	--constraints
	
);
CREATE TABLE group_members(
	group_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_group_members PRIMARY KEY (group_id, member_id),
	CONSTRAINT FK_group_members_event FOREIGN KEY(group_id) REFERENCES groups(group_id),
    CONSTRAINT FK_group_members_members FOREIGN KEY(member_id) REFERENCES member(member_id)
);
CREATE TABLE event (

	--create the columns (name datatype constraint)
	event_id serial PRIMARY KEY, -- serial is an auto incrementing int
	event_name varchar(100) NOT NULL,
	description varchar(500) NOT NULL,
	event_date_time timestamp,
	duration_mins int,
	group_running int NOT NULL,
	
	--create the constraints (primary keys, foreign keys)
	CONSTRAINT FK_event_group FOREIGN KEY(group_running) REFERENCES groups(group_id),
	CONSTRAINT CHK_duration_mins CHECK (duration_mins >= 30)
);
CREATE TABLE event_members(
	event_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_event_members PRIMARY KEY (event_id, member_id),
	CONSTRAINT FK_event_members_event FOREIGN KEY(event_id) REFERENCES event(event_id),
    CONSTRAINT FK_event_members_members FOREIGN KEY(member_id) REFERENCES member(member_id)
);

INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Otto', 'Miranto', 'miranto@hotmail.com', '5123067896','1967-12-16', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Fisher', 'Carrie', 'fisher@hotmail.com', '5129078957','1956-10-21', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Hardy', 'Tom', 'tomhardy@hotmail.com', '5127869412','1967-12-16', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Szarabajka', 'Keith', 'keith@hotmail.com', '512765399','12/2/1952', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Nolan', 'Christopher', 'chris@hotmail.com', '5123051287','7/30/1970', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Liv', 'Tyler', 'tyler@hotmail.com', '5128799065','7/1/1977', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Boyd', 'Billy', 'billy@hotmail.com', '5128970332','8/28/1968', true);
INSERT INTO member (last_name, first_name, email_address, phone, birthday, isFlag) VALUES('Claire', 'Ryann', 'ryann@hotmail.com', '5129800673','2012-10-05', true);

INSERT INTO groups (group_title) VALUES('We were on a break!');
INSERT INTO groups (group_title) VALUES('Joe doesnt share food!');
INSERT INTO groups (group_title) VALUES('How are you doing');
INSERT INTO groups (group_title) VALUES('Purple wall');

INSERT INTO event (event_name, description, event_date_time, duration_mins, group_running) VALUES('Friends Fan Meeting','TV Series Friends', null, 120, 2);
INSERT INTO event (event_name, description, event_date_time, duration_mins, group_running) VALUES('Friends Fan Meeting','TV Series Friends', null, 120, 3);
INSERT INTO event (event_name, description, event_date_time, duration_mins, group_running) VALUES('Friends Fan Meeting','TV Series Friends', null, 120, 1);
INSERT INTO event (event_name, description, event_date_time, duration_mins, group_running) VALUES('Friends Fan Meeting','TV Series Friends', null, 120, 4);

COMMIT;
