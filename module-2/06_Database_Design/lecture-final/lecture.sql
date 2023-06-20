--wrapping it all in a transaction so that it's either all the database gets created or none of it
BEGIN TRANSACTION;

--drop the tables in the opposite order you create them 
DROP TABLE IF EXISTS person_purchase;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS person;

--create the table
CREATE TABLE person (

	--create the columns (name datatype constraint)
	person_id serial PRIMARY KEY, -- serial is an auto incrementing int
	name varchar(100) NOT NULL,
	address varchar(250) NOT NULL,
	phone varchar(25) UNIQUE
	
	--create the constraints (primary keys, foreign keys)
	-- CONSTRAINT pk_person PRIMARY KEY(person_Id)
	
);

CREATE TABLE art(
	
	--columns
	art_id serial PRIMARY KEY,
	title varchar(100) NOT NULL,
	purchase_date date NOT NULL,
	purchase_price int NOT NULL, -- don't forget about money
	artist_id int NOT NULL REFERENCES person(person_id),
	
	--constraints
	--CONSTRAINT fk_person_art FOREIGN KEY(artist_id) REFERENCES person(person_id),
	CONSTRAINT chk_price CHECK( purchase_price >= 0)
);

CREATE TABLE person_purchase(
	customer_id int REFERENCES person(person_id),
	purchase_id int REFERENCES art(art_id),
	CONSTRAINT pk_person_purchase PRIMARY KEY (customer_id, purchase_id)
);



COMMIT;
