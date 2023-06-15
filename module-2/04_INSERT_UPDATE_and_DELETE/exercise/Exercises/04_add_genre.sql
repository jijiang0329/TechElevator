-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
insert into genre(genre_name)
values('Sports'); 

insert into movie_genre
select movie_id, 11771
from movie 
where title = 'Coach Carter';