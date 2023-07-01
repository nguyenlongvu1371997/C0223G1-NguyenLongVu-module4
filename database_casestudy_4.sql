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

create table poisition(
id int auto_increment primary key,
`name` varchar(50)
);

create table employee(
id int auto_increment primary key,
`name` varchar(50),
phone_number varchar(12),
email varchar(50),
date_of_birth date,
citizen_id varchar(15),
poisition_id int,
foreign key(poisition_id) references poisition(id)
);

create table movie_showtime(
id int auto_increment primary key,
movie_id int,
foreign key(movie_id) references movie(id),
room_id int,
foreign key(room_id) references room(id),
show_date date,
show_time time
);

create table seat(
location varchar(4),
id_movie_showtime int,
foreign key(id_movie_showtime) references movie_showtime(id),
primary key(location, id_movie_showtime),
`status` boolean
);

create table members(
id int auto_increment primary key,
`name` varchar(30)
);

create table customer(
id int auto_increment primary key,
`name` varchar(50),
phone_number varchar(12),
email varchar(50),
date_of_birth date,
members int,
foreign key(members) references members(id)
);

create table ticket(
id int auto_increment primary key,
id_movie_showtime int,
foreign key(id_movie_showtime) references movie_showtime(id),
location varchar(4),
foreign key(location) references seat(location),
id_employee int,
foreign key(id_employee) references employee(id),
id_customer int,
foreign key(id_customer) references customer(id),
ticket_code varchar(50)
);

create table users(
id varchar(50) primary key,
pass varchar(50) not null,
id_customer int,
foreign key(id_customer) references customer(id),
roles int
);

delete from book_rent where book_id=1 limit 1;
