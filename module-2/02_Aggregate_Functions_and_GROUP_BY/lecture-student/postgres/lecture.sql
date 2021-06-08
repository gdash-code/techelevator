-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT census_region, state_name
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area

SELECT park_name, area 
FROM park
ORDER BY area DESC
LIMIT 1;

-- LIMITING RESULTS

-- The 10 largest cities by populations

SELECT city_name, population 
FROM city
ORDER BY population DESC
LIMIT 10;
-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

SELECT park_name, (CURRENT_DATE - date_established)/365  AS park_age 
FROM park
ORDER BY park_age DESC, park_name ASC
LIMIT 20;



-- CONCATENATING OUTPUTS ||

-- All city names and their state abbreviation.
SELECT city_name || ',' || state_abbreviation AS city_state
FROM city;

-- The all parks by name and date established.
SELECT
        park_name || ' ' || date_established AS park_date
FROM
        park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.

SELECT
        census_region,
        state_name
FROM
        state
WHERE
        census_region IN ('Midwest', 'West')
ORDER BY
        census_region DESC,
        state_name;  
      

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT
        AVG(population), COUNT(*)
FROM
        state
;

-- Total population in the West and South census regions
SELECT
        SUM(population), COUNT(*)
FROM
        state
WHERE
        census_region IN ('West', 'South')
;

-- The number of cities with populations greater than 1 million
SELECT
        COUNT(*)
FROM
        city
WHERE
        population > 1000000;


-- The number of state nicknames.
SELECT
        COUNT(*) AS total_state, COUNT(state_nickname) AS state_with_nicknames
FROM
        state;

-- The area of the smallest and largest parks.
SELECT 
        MIN(area), MAX(area)
        
FROM park
;




SELECT (SELECT area FROM park ORDER BY area LIMIT 1) AS MIN_PARK, (SELECT area FROM park ORDER BY area DESC LIMIT 1) AS MAX_PARK;

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT
        state_abbreviation, COUNT(city_id) AS cities
FROM
        city
GROUP BY
        state_abbreviation 
ORDER BY 
        cities DESC;               
-- Determine the average park area depending upon whether parks allow camping or not.
SELECT
        has_camping, AVG(area) AS avg_park_area
FROM
        park
GROUP BY
        has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT
        state_abbreviation, SUM(population) AS pop
FROM
        city
GROUP BY
        state_abbreviation
ORDER BY
        state_abbreviation;                        

-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population 
FROM city 
ORDER BY city_name 
OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name) AS cities,
        (SELECT state_name FROM state WHERE state_abbreviation = c.state_abbreviation) AS state_name
FROM
        city AS c
GROUP BY
        state_abbreviation
ORDER BY
        cities DESC;

-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

