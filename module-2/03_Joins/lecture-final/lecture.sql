-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT *
FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT *
FROM city
JOIN state
	ON city.state_abbreviation = state.state_abbreviation
WHERE city.city_name = 'Columbus';

-- When trying to differentiate columns named the same but on two different tables, use the table name or alias
SELECT city.area AS city_area, state.area AS state_area
FROM city
JOIN state
	ON city.state_abbreviation = state.state_abbreviation
WHERE city.city_name = 'Columbus';

--If I want only some columns from state, but all columns from city
SELECT state.state_name, city.*
FROM city
JOIN state
	ON city.state_abbreviation = state.state_abbreviation
WHERE city.city_name = 'Columbus';

-- I can also alias the tables so that I don't have to type out the whole name
SELECT s.state_name, c.*
FROM city c
JOIN state s
	ON c.state_abbreviation = s.state_abbreviation
WHERE c.city_name = 'Columbus';


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT p.park_name, ps.state_abbreviation
FROM park p
JOIN park_state ps 
	ON p.park_id = ps.park_id;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT p.park_name, s.state_name
FROM park p
JOIN park_state ps 
	ON p.park_id = ps.park_id
JOIN state s
	ON ps.state_abbreviation = s.state_abbreviation;
	
	--When doing a join
	-- 1) Type JOIN followed by the table name we want data from
	-- 2) Alias the table if you want to
	-- 3) Type ON and then the column that corresponds to the column in the other table
	
	
	
	

-- Modify the previous query to include the name of the state's capital city.
SELECT p.park_name, s.state_name, c.city_name
FROM park p
JOIN park_state ps 
	ON p.park_id = ps.park_id
JOIN state s
	ON ps.state_abbreviation = s.state_abbreviation
JOIN city c
	ON s.capital = c.city_id
	;
	

-- Modify the previous query to include the area of each park.
SELECT p.park_name, s.state_name, c.city_name, p.area AS park_area
FROM park p
JOIN park_state ps 
	ON p.park_id = ps.park_id
JOIN state s
	ON ps.state_abbreviation = s.state_abbreviation
JOIN city c
	ON s.capital = c.city_id
	;

-- Write a query to retrieve the names and populations of all the cities in the 
-- Midwest census region.
SELECT city_name, city.population
FROM city
JOIN state s
	ON city.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
;


-- Write a query to retrieve the number of cities in the city table for each state 
-- in the Midwest census region.
SELECT s.state_name, COUNT(*) AS num_of_cities
FROM city
JOIN state s
	ON city.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name
;

-- Modify the previous query to sort the results by the number of cities in 
--descending order.
SELECT s.state_name, COUNT(*) AS num_of_cities
FROM state s
JOIN city
	ON city.state_abbreviation = s.state_abbreviation
WHERE s.census_region = 'Midwest'
GROUP BY s.state_name
ORDER BY num_of_cities DESC
;

SELECT *
FROM state
;

-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was 
--established in that state (or territory) for every record in the state table that 
--has park records associated with it.
SELECT state_name, date_established
FROM state
JOIN park_state ps
	ON state.state_abbreviation = ps.state_abbreviation
JOIN park p
	ON ps.park_id = p.park_id;

-- Modify the previous query so the results include entries for all the records in 
-- the state table, even if they have no park records associated with them.
SELECT state_name, date_established
FROM state
LEFT JOIN park_state ps
	ON state.state_abbreviation = ps.state_abbreviation
LEFT JOIN park p
	ON ps.park_id = p.park_id;
	
-- IF we only want to see w here there are no matches
SELECT state_name, date_established
FROM state
LEFT JOIN park_state ps
	ON state.state_abbreviation = ps.state_abbreviation
LEFT JOIN park p
	ON ps.park_id = p.park_id
WHERE p.park_id IS NULL;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that 
--begin with "W" sorted alphabetically. (Washington is the name of a city and a state
--how many times does it appear in the results?)
SELECT city_name as place_name
FROM city
UNION
SELECT state_name as place_name
FROM state;


-- Modify the previous query to include a column that indicates whether the 
-- place is a city or state.
SELECT city_name as place_name, 'City' as type
FROM city
UNION
SELECT state_name as place_name, 'State' as type
FROM state
ORDER BY type;


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

