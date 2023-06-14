-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result between 110-120)
select AVG(m.length_minutes) as average_length
from movie m
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where g.genre_name = 'Science Fiction'
