-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)
select distinct g.genre_name
from person p
join movie_actor ma on ma.actor_id = p.person_id
join movie m on m.movie_id = ma.movie_id
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where p.person_name = 'Robert De Niro' and release_date > '2010-01-01'
order by g.genre_name