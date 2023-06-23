create database movie_theater;

use movie_theater;

create table type_of_movie(
id int auto_increment primary key,
name_type_of_movie varchar(50)
);

create table movie(
id int auto_increment primary key,
name_movie varchar(50),
date_start datetime,
duration int,
age_limit int,
poster varchar(200),
trailer varchar(200)
);

create table detail_movie(
id_movie int,
foreign key(id_movie) references movie(id),
id_type_of_movie int,
foreign key(id_type_of_movie) references type_of_movie(id),
primary key (id_movie,id_type_of_movie)
);

create table room(
id int auto_increment primary key,
notes varchar(200),
maintenance boolean
);

create table chair(
room_id int,
foreign key(room_id) references room(id),
location varchar(4),
primary key(room_id,location)
);

create table movie_showtime(
id int auto_increment primary key,
id_movie int,
foreign key(id_movie) references movie(id),
id_room int,
foreign key(id_room) references room(id),
show_date date,
show_time time
);




