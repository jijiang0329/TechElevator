-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)
select p.person_name, COUNT(m.movie_id) as num_of_movies
from person p
left join movie_actor ma on ma.actor_id = p.person_id
left join movie m on m.movie_id = ma.movie_id
where p.person_name like 'George %'
group by p.person_id
order by p.person_name;