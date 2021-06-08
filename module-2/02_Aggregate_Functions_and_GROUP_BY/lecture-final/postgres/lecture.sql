-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
-- Note DESC in ORDER BY
SELECT state_name, population
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
-- Note order of columns in the ORDER BY: census_region is the major sort, state_name the minor sort,
--   meaning it's sorted within the major column, i.e. census_region.
-- Note order of columns in the SELECT only controls order columns are returned (i.e. "displayed"), not sort order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
-- Note that area isn't in the SELECT, but is used in the ORDER BY
SELECT park_name
FROM park
ORDER BY area DESC;



-- LIMITING RESULTS

-- The 10 largest cities by populations
-- Note ORDER BY to sort city population from largest to smallest.
-- Note TOP 10 limits the number of results (i.e. "rows") returned. It has nothing to do with sort order, as in
--   returning the 10 "top" (i.e. largest populated) cities.
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
-- Note use of alternative calculates and/or non-aggregate functions to calculate age of park in years. (Pick one to show students)
-- Note TOP 20 returns rows where several of the parksare the same age in years.
-- Note park_name ASC in ORDER BY means parks that are the same years in age will be returned in alphabetic
--   order within the shared age.
SELECT CURRENT_DATE - date_established AS age, park_name -- difference between the two dates is given in days
--SELECT (CURRENT_DATE - date_established) / 365 AS age, park_name -- divide difference by 365 to determine years
--SELECT (date_part('year', CURRENT_DATE) - date_part('year', date_established)) AS age, park_name
--SELECT (EXTRACT(year FROM CURRENT_DATE) - EXTRACT(year FROM date_established)) AS age, park_name
FROM park
ORDER BY age DESC, park_name ASC
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- Note surrounding "()" on state abbreviation.
-- Note the implied default ASC in ORDER BY. In general practice, only DESC is typically specified in the
--   SQL as needed.
-- Note building strings is typically not done within the SQL. Normally, the raw values are returned, and
--   concatenating is done within the application code that requested the data from the database.
SELECT (city_name || ' (' || state_abbreviation || ')') AS city_state_abbreviation
FROM city
ORDER BY city_name;

-- All park names and area
-- Note "Name: " and " Area: " in the concatenated string
SELECT ('Name: ' || park_name || ' Area: ' || area) as park_area
FROM park
ORDER BY park_name;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
-- Note colon-space between census region and state -- "census_region: state"
-- (optional) Note alternative ORDER BY, discuss why just the column names in the ORDER BY still returns
--   the same results as using the region_and_state concatenated string alias.
SELECT (census_region || ': ' || state_name) AS region_and_state
FROM state
WHERE census_region ILIKE '%west'
ORDER BY region_and_state;
-- ORDER BY census_region, state_name; -- Alternative producing the same results


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_population
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(population) AS big_cities_count
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
-- Note COUNT(*) is commonly used to specify a row count rather than counting a specific column.
-- Note difference in the counts. NULL state nicknames are ignored by COUNT(state_nickname).
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS row_count
FROM state;

-- The area of the smallest and largest parks.
-- Note SQL statements aren't limited to just one aggregate function at a time.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
-- Note state_abbreviation can be included in SELECT because it's included in GROUP BY.
SELECT COUNT(city_name) AS cities, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) as sum_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_population;

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
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;
-- Increment/decrement the OFFSET value by 10 each time you want the next/previous "page".
-- OFFSET may not be less than 0. Doh!


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
--   ordered from most cities to least.
-- Note subquery wrapped in () in the SELECT.
-- Note use of an alias on the city table. Table aliases figure prominently with JOIN statements.
SELECT COUNT(city_name) AS cities,
	(
        SELECT state_name FROM state WHERE state_abbreviation = c.state_abbreviation
    ) AS state_name
FROM city AS c
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Include the names of the smallest and largest parks
-- Note subquery wrapped in () in the FROM
-- Note aliases on park table and subquery
-- Note neither GROUP BY nor ORDER BY are required for subqueries.
SELECT park_name, area
--SELECT park_name, area, (CASE WHEN area = sl.smallest THEN 'Smallest' ELSE 'Largest' END) AS size
FROM park p,
	(
		SELECT MIN(area) AS smallest, MAX(area) AS largest
		FROM park
		WHERE area > 0
	) as sl
WHERE p.area = sl.smallest OR p.area = sl.largest;

-- List the capital cities for the states in the Northeast census region.
-- Note the subquery wrapped in () in the WHERE
-- Note the outer SELECT is FROM city, the inner subquery is FROM state
-- Note there is no aliasing required anywhere in the statement.
SELECT state_abbreviation, city_name
FROM city
WHERE city_id IN
    (
        SELECT capital
        FROM state
        WHERE census_region = 'Northeast'
    )
ORDER BY state_abbreviation;

-- ALTERNATE to previous example producing the same results.
-- Note the subquery wrapped in () in the SELECT
-- Note the outer SELECT is FROM state, the inner subquery is FROM city
-- Note added alias for the sheer joy of it!
SELECT s.state_abbreviation,
	(SELECT c.city_name FROM city AS c WHERE c.city_id = s.capital)
FROM state AS s
WHERE s.census_region = 'Northeast'
ORDER BY s.state_abbreviation;
