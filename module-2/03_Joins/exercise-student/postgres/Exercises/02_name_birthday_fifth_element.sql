-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday

FROM person

JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id = movie.movie_id

WHERE title = 'The Fifth Element';

