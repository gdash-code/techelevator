-- First, remove all data from the database.
-- TRUNCATE is like DELETE, but only for removing all records from a table.
-- CASCADE means that records associated with foreign keys will also be removed rather than preventing deletion.
TRUNCATE state, city, park, park_state CASCADE;

-- Temporarily remove the not-null constraint so we can create states without specifying capital cities.
ALTER TABLE state ALTER COLUMN capital DROP NOT NULL;

INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax)
VALUES ('AA', 'State A', 0, 0, 0),
       ('BB', 'State B', 0, 0, 0),
       ('CC', 'State C', 0, 0, 0);

INSERT INTO city (city_id, city_name, state_abbreviation, population, area)
VALUES (1, 'City 1', 'AA', 11, 111),
       (2, 'City 2', 'BB', 22, 222),
       (3, 'City 3', 'CC', 33, 333),
       (4, 'City 4', 'AA', 44, 444); -- One city that isn't a capital so it can be deleted by tests.

UPDATE state SET capital = 1 WHERE state_abbreviation = 'AA';
UPDATE state SET capital = 2 WHERE state_abbreviation = 'BB';
UPDATE state SET capital = 3 WHERE state_abbreviation = 'CC';

-- Restore the not-null constraint we removed earlier now that the states have capital cities.
ALTER TABLE state ALTER COLUMN capital SET NOT NULL;

INSERT INTO park (park_id, park_name, date_established, area, has_camping)
VALUES (1, 'Park 1', '1800-01-02', 100, true),
       (2, 'Park 2', '1900-12-31', 200, false),
       (3, 'Park 3', '2000-06-15', 300, false);

INSERT INTO park_state (park_id, state_abbreviation)
VALUES (1, 'AA'),
       (2, 'BB'),
       (3, 'CC'),
       (3, 'AA'); -- Park 3 is in 2 states.
