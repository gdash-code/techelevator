-- 9. The titles of movies directed by James Cameron (6 rows)
SELECT title
FROM movie
JOIN person p ON movie.director_id = p.person_id
WHERE person_name = 'James Cameron';
