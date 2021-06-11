-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'

SELECT person_name, COUNT(movie_id) AS num_of_movies
FROM person p
LEFT JOIN movie_actor ma ON p.person_id = ma.actor_id
WHERE person_name LIKE 'George %'
GROUP BY person_id, person_name
ORDER BY person_name;

--STEP BY STEP APPROACH TO SOLVING

SELECT *
FROM person p
LEFT OUTER JOIN movie_actor ma
        ON ma.actor_id = p.person_id
WHERE p.person_name LIKE 'George %';


SELECT p.person_name, COUNT(ma.*)
FROM person p
LEFT OUTER JOIN movie_actor ma
        ON ma.actor_id = p.person_id
WHERE p.person_name LIKE 'George %'
GROUP BY  p.person_name;


/* REVIEW DAY HACK/TIP/TRICK #1 */
-- HOW TO IDENTIFY DUPLICATED VALUES??

-- 1)  Create Agg Query

SELECT person_name, count(*), MIN(person_id), MAX(person_id)
FROM person
WHERE person_name LIKE 'George %'
GROUP BY person_name
HAVING count(*) > 1;

--INSERT INTO person ( person_name, birthday, deathday, biography, profile_path, home_page) VALUES ('George Wallace', '01/01/1901', null, 'That guy, the 3rd Geo Wallace', 'http://www.google.com/?q=geo', '');

-- 2) USE COUNT DISTINCT TO VALIDATE UNIQUENESS OF AGG GROUPING (IF APPROPRIATE)

SELECT p.person_name, COUNT(ma.*), COUNT( DISTINCT(p.person_id))
FROM person p
LEFT OUTER JOIN movie_actor ma
        ON ma.actor_id = p.person_id
WHERE p.person_name LIKE 'George %'
GROUP BY  p.person_name
HAVING COUNT( DISTINCT(p.person_id)) > 1;

-- 3) THERE ARE 3 GEORGE WALLACES, MIN AND MAX AREN'T HELPFUL ANYMORE

SELECT person_name, count(*), MIN(person_id), MAX(person_id), ARRAY_AGG(person_id) as all_dup_ids
FROM person
WHERE person_name LIKE 'George %'
GROUP BY person_name
HAVING count(*) > 1;

-- 4) DELETING THE LAST CREATED 'GEORGE WALLACE'

DELETE FROM person
WHERE person_id = (SELECT MAX(person_id) FROM person WHERE WHERE person_name = 'George Wallace');




