insert into category(category_id, category_name) values 
	(1, 'Action'), 
	(2, 'comedy'), 
	(3, 'Horror');
    
insert into actor (actor_name, country) values ('Linda Hamilton', 'US');
insert into actor (actor_name, country) values ('Joaquim de Almeida', 'POR');
insert into actor (actor_name, country) values ('Schwarzenegger', 'AUT');
insert into actor (actor_name, country) values ('Franka Potente', 'GER');
insert into actor (actor_name, country) values ('Gerard Depardieu', 'FRA');

insert into actor_tvshow (actor_id, tvshow_id) values (1, 1);
insert into actor_tvshow (actor_id, tvshow_id) values (1, 2);
insert into actor_tvshow (actor_id, tvshow_id) values (2, 1);
insert into actor_tvshow (actor_id, tvshow_id) values (2, 2);

insert into actor_film (actor_id, film_id) values (1, 1);
insert into actor_film (actor_id, film_id) values (1, 2);
insert into actor_film (actor_id, film_id) values (2, 1);
insert into actor_film (actor_id, film_id) values (2, 2); 

insert into category_tvshow (category_id, tvshow_id) values (1, 1);
insert into category_tvshow (category_id, tvshow_id) values (1, 2);
insert into category_tvshow (category_id, tvshow_id) values (2, 1);
insert into category_tvshow (category_id, tvshow_id) values (2, 2);

insert into category_film (category_id, film_id) values (1, 1);
insert into category_film (category_id, film_id) values (1, 2);
insert into category_film (category_id, film_id) values (2, 1);
insert into category_film (category_id, film_id) values (2, 2); 




















