-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
select m.title, m.tagline
from person p
join movie_actor ma on ma.actor_id = p.person_id
join movie m on m.movie_id = ma.movie_id
join movie_genre mg on mg.movie_id = m.movie_id
join genre g on g.genre_id = mg.genre_id
where genre_name = 'Family' and p.person_name = 'Samuel L. Jackson'
order by m.title