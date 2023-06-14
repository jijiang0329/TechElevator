-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)
select m.title
from movie m
join collection c on c.collection_id = m.collection_id
where c.collection_name in ('Star Wars Collection')
order by m.release_date DESC;
