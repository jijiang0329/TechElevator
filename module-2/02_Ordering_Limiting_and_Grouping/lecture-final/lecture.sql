-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT *
FROM state
ORDER BY census_region DESC, state_name ASC; 

-- The biggest park by area
SELECT *
FROM park
ORDER BY area DESC;

-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

--SELECT EXTRACT(year FROM CURRENT_DATE) - EXTRACT(year FROM date_established) AS age, park_name
--SELECT EXTRACT(year FROM NOW()) - EXTRACT(year FROM date_established) AS age, park_name
SELECT (CURRENT_DATE - date_established)/365 AS age, park_name
--SELECT (NOW() - date_established)/365 AS age, park_name
FROM park
ORDER BY age DESC, park_name
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ' (' || state_abbreviation || ')' AS city_state
FROM city;

-- The all parks by name and date established.
SELECT park_name || ',' || date_established
FROM park
;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT  census_region || ',' || state_name AS state_region
FROM state
WHERE census_region = 'West' OR census_region = 'Midwest'
--WHERE census_region IN ('West','Midwest')
ORDER BY state_region;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population)
FROM state
WHERE census_region IN ('West','South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT *
FROM state
WHERE state_nickname IS NULL;

SELECT COUNT(state_nickname) AS num_of_values_in_column, COUNT(*) AS num_of_rows
FROM state;


-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) AS num_cities, SUM(population), AVG(population)
FROM city
GROUP BY state_abbreviation
ORDER BY num_cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area)
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population)
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;


-- Miscelleneous


-- SUBQUERIES (optional)

SELECT city_name, state_abbreviation
FROM city
WHERE population IN (
	SELECT MIN(population) AS smallest_city
	FROM city
	GROUP BY state_abbreviation
);



-- Include the names of the smallest and largest parks
SELECT p.park_name, p.area
FROM park p,
	(
		SELECT MIN(area) AS smallest, MAX(area) AS largest
		FROM park
	) AS s1
WHERE p.area = s1.smallest OR p.area = s1.largest;

-- put capital cities with the state
SELECT city_name, state_abbreviation
FROM city
WHERE city_id IN (
	SELECT capital
	FROM state
);



-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)

SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 20 ROWS LIMIT 10;

