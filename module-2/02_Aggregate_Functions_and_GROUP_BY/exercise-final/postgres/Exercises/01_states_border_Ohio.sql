-- 1. The city name, state abbreviation, and population of all cities in the states that border Ohio.
-- The states are: Pennsylvania (PA), West Virginia (WV), Kentucky (KY), Indiana (IN), and Michigan (MI).
-- The city name and state abbreviation should be returned as a single column called 'name_and_state' and should contain values such as "Detroit, MI".
-- Order the results alphabetically by state abbreviation and then by city name.
-- (20 rows)

SELECT (city_name || ', ' || state_abbreviation) AS name_and_state, population
FROM city
WHERE state_abbreviation IN ('PA', 'WV', 'KY', 'IN', 'MI')
ORDER BY state_abbreviation, city_name;
