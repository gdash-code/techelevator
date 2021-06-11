-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT
       DISTINCT person_name, birthday
FROM
        person p
        JOIN movie_actor ma ON p.person_id = ma.actor_id
        JOIN movie m ON ma.movie_id = m.movie_id
WHERE
        (birthday BETWEEN '1950-01-01'AND '1959-12-31') AND
        (release_date BETWEEN '1985-01-01' AND '1985-12-31');
