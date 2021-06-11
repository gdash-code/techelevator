-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 0.78 square miles and does not offer camping.)
CREATE TABLE park (
park_id SERIAL NOT NULL, 
park_name CHARACTER VARYING(50) NOT NULL, 
date_established DATE NOT NULL, 
area NUMERIC(6,1) NOT NULL, 
has_camping BOOLEAN NOT NULL, 
CONSTRAINT pk_park PRIMARY KEY (park_id), 
CONSTRAINT uq_park_name UNIQUE (park_name));

BEGIN TRANSACTION;

SELECT * FROM park WHERE park_name = 'Disneyland';

INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Disneyland', '07/17/1995', 0.78, false);

SELECT * FROM park WHERE park_name = 'Disneyland';

-- Add Hawkins, IN (with a population of 30,000 and an area of 14.71 square miles) and Cicely, AK (with a popuation of 839 and an area of 4.39 square miles) to the city table.
BEGIN TRANSACTION;

SELECT 'PRE-TRANS STATE' AS STATUS, COUNT(*) FROM city WHERE city_name IN ('Hawkins', 'Cicely');

INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ( 'Hawkins', 'IN', 30000, 14.71);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ( 'Cicely', 'AK', 839, 4.39);

SELECT 'POST-INSERT STATE' AS STATUS, COUNT(*) FROM city WHERE city_name IN ('Hawkins', 'Cicely');

ROLLBACK;

INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ( 'Hawkins', 'IN', 30000, 14.71);
INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ( 'Cicely', 'AK', 839, 4.39);
-- Since Disneyland is in California (CA), add a record representing that to the park_state table.

SELECT * FROM park_state;

INSERT INTO park_state
        (
                park_id, 
                state_abbreviation
        ) 
VALUES(
        (SELECT park_id FROM park WHERE park_name = 'Disneyland'),
        --'CA'
        (SELECT state_abbreviation FROM state WHERE state_name = 'California')
        );
        
 SELECT * FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');       

-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state WHERE state_name = 'California';

UPDATE state

SET
        state_nickname = 'The Happiest Place on Earth';
WHERE
        state_name = 'California';
        
SELECT * FROM state WHERE state_name = 'California';

-- Increase the population of California by 1,000,000.
UPDATE state

SET
        population = population + 1000000
WHERE
        state_name = 'California';

SELECT * FROM state WHERE state_name = 'California';

-- Change the capital of California to Anaheim.

SELECT * FROM state WHERE state_name = 'California';

UPDATE state

SET
        capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')      
WHERE
        state_name = 'California';

SELECT * FROM state WHERE state_name = 'California';

-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
SELECT * FROM state WHERE state_name = 'California';

UPDATE state

SET
        state_nickname = 'The Golden State',
        population = population - 1000000,
        capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE
        state_name = 'California';

SELECT * FROM state WHERE state_name = 'California';
-- DELETE

-- Delete Hawkins, IN from the city table.
SELECT COUNT (*) FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

BEGIN TRANSACTION;

DELETE FROM city
WHERE 
        city_name = 'Hawkins'
        AND 
        state_abbreviation = 'IN'
        ;

ROLLBACK;

SELECT COUNT (*) FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

-- Delete all cities with a population of less than 1,000 people from the city table.
BEGIN TRANSACTION;

SELECT * FROM city WHERE population < 1000;

DELETE FROM city
WHERE 
       population < 1000;
       
SELECT * FROM city WHERE population < 1000;    
  
ROLLBACK;

-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.

INSERT INTO city (city_name, state_abbreviation, population, area) VALUES ( 'Cicely', 'XX', 839, 4.39);

-- Try deleting California from the state table.

DELETE FROM state WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.

DELETE FROM park_state WHERE park_name = 'Disneyland';
DELETE FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');
DELETE FROM park_state WHERE park_name = 'Disneyland';

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.

INSERT INTO city ( city_name, state_abbreviation, area) VALUES ( 'Smallville','KS', 25);

SELECT MAX(city_id) FROM city;

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.


-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * FROM city WHERE city_id = (SELECT MAX(city_id) FROM city);

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).

UPDATE state SET state_nickname = 'Vacationland' WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).

UPDATE state SET census_region = 'Mars7' WHERE state_abbreviation = 'FL';

-- TRANSACTIONS
CREATE TABLE state (state_abbreviation CHARACTER(2) NOT NULL, 
state_name CHARACTER VARYING(50) NOT NULL, 
population INTEGER NOT NULL, 
area INTEGER NOT NULL, 
capital INTEGER NOT NULL, 
sales_tax NUMERIC(5,3) NOT NULL, 
state_nickname CHARACTER VARYING(100), 
census_region CHARACTER VARYING(10), 
CONSTRAINT pk_state PRIMARY KEY (state_abbreviation), 
CONSTRAINT fk_state_city FOREIGN KEY (capital) REFERENCES "city" ("city_id"), 
CONSTRAINT uq_state_name UNIQUE (state_name), 
CONSTRAINT uq_state_nickname UNIQUE (state_nickname), 
CONSTRAINT chk_census_region CHECK ((census_region IS NULL) OR ((census_region)::text = ANY ((ARRAY['Northeast'::character varying, 'South'::character varying, 'Midwest'::character varying, 'West'::character varying])::text[]))));

-- Delete the record for Smallville, KS within a transaction.


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.


-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
