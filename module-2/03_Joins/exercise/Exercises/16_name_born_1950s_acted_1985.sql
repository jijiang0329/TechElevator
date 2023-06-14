-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
select distinct p.person_name, p.birthday
from person p
join movie_actor ma on ma.actor_id = p.person_id
join movie m on m.movie_id = ma.movie_id
where p.birthday > '1950-01-01' and p.birthday < '1960-01-01' and m.release_date > '1985-01-01' and m.release_date < '1986-01-01'
order by p.birthday