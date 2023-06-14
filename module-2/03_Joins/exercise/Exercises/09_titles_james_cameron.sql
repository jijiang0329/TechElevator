-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)
select m.title
from person p
join movie m on m.director_id = p.person_id
where p.person_name = 'James Cameron'
order by m.title