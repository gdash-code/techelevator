-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
SELECT
        title,
        tagline
FROM
        movie m
        JOIN movie_genre mg ON m.movie_id = mg.movie_id
        JOIN genre g ON mg.genre_id = g.genre_id
        JOIN movie_actor ma ON m.movie_id = ma.movie_id
        JOIN person p ON ma.actor_id = p.person_id
WHERE
        genre_name = 'Family' AND
        person_name = 'Samuel L. Jackson';

