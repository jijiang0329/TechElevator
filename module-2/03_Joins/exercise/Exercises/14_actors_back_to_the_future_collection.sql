-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)
select distinct p.person_name
from movie m
join collection c on c.collection_id = m.collection_id
join movie_actor ma on m.movie_id = ma.movie_id
join person p on p.person_id = ma.actor_id
where c.collection_name in ('Back to the Future Collection')
order by p.person_name;
