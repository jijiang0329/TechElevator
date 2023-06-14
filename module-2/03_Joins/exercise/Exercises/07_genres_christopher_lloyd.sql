-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
select distinct g.genre_name
from person p
join movie_actor ma on ma.actor_id = p.person_id
join movie m on m.movie_id = ma.movie_id
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where p.person_name = 'Christopher Lloyd'
order by g.genre_name;