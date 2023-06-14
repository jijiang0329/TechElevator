-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)
select distinct p.person_name
from movie m
join collection c on c.collection_id = m.collection_id
join person p on p.person_id = m.director_id
where c.collection_name in ('Harry Potter Collection')
order by p.person_name;
