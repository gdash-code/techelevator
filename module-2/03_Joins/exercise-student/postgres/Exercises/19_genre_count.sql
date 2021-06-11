-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
SELECT
        genre_name, COUNT(m.movie_id) AS num_of_movies
FROM movie m
JOIN movie_genre mg ON m.movie_id = mg.movie_id
JOIN genre ON mg.genre_id = genre.genre_id
GROUP BY genre_name;