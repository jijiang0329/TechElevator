-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)
select p.person_name, m.title
from person p
join movie_actor ma on ma.actor_id = p.person_id
join movie m on m.movie_id = ma.movie_id
where p.person_name like '% Jones'
order by p.person_name, m.title