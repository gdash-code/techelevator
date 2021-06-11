-- IN, what is it about?

-- Is this value IN this set of values?

SELECT m.*
FROM movie m
WHERE 
        m.title LIKE '%Alien%' 
        OR 
        m.title LIKE '%Zombie%' 
        
-- IN OPERATOR REQUIRES EXACT VALUES, DO NOT USE WILDCARDS WITHIN IN (LISTS)        
        
SELECT m.*
FROM movie m
WHERE 
        m.title IN ('Alien', 'Aliens')
        
-- JOINS IN UPDATES

SELECT * FROM person WHERE person_name = 'George Wallace' ORDER BY person_id

-- Add an extra george if you don't have one handy
-- INSERT INTO person ( person_name, birthday, deathday, biography, profile_path, home_page) VALUES ('George Wallace', '01/01/1901', null, 'That guy, the 3rd Geo Wallace', 'http://www.google.com/?q=geo', '');

-- Let's create a new table with some association to person to use for an update

CREATE TABLE person_page (
        person_id serial not null,
        page_name varchar(255)
)        

INSERT INTO person_page (person_id, page_name) VALUES (1273694, '1917 Awesomeness');
INSERT INTO person_page (person_id, page_name) VALUES (552139, '1948 Was way better');
INSERT INTO person_page (person_id, page_name) VALUES (3984916, 'Silly Kid Georges');

-- 1) Start with a select
SELECT p.home_page, pp.page_name
FROM
        person p 
        LEFT OUTER JOIN person_page pp
                ON pp.person_id = p.person_id
WHERE person_name = 'George Wallace';                

-- 2. CHANGE SELECT TO AN UPDATE AND ADD SET CLAUSE INSTEAD OF FIELD LIST

UPDATE person p
SET
        home_page = 'UPDATE QUERY WITH JOIN THE RIGHT WAY: ' || pp.page_name
FROM
        person 
        INNER JOIN person_page pp
                ON pp.person_id = person.person_id
WHERE p.person_name = 'George Wallace';   
                
-- 3. OR ... I could use a correlated subquery

UPDATE person p
SET home_page = (SELECT 'CORRELATED SUBQUERY ' || page_name  FROM person_page pp WHERE pp.person_id = p.person_id)
WHERE p.person_name = 'George Wallace';

UPDATE person SET home_page = 'https://www.google.com' WHERE home_page IS NULL;



