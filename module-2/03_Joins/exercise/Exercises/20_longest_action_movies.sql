-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
select m.title, m.length_minutes, m.release_date

from movie m
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where g.genre_name in ('Action')
order by m.length_minutes DESC, release_date DESC
limit 5;