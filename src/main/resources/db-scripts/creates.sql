
create table if not exists `actor` 
(  
	`actor_id`     		bigint(6) not null auto_increment,     
    `actor_name`   		varchar(30) not null unique,
    `actor_birth_name`  varchar(60),
    `actor_nickname`    varchar(20),    
    `country`      		varchar(30),
    `city`      		varchar(30),
    `birthday`     		date,  
    `height`     		float,  
    `biography`     	varchar(10000),  
    constraint pk_actor_id primary key (actor_id)
);