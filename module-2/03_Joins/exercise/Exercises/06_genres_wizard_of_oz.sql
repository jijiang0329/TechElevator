-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
select g.genre_name
from movie m
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where m.title = 'The Wizard of Oz'
order by g.genre_name