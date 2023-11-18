DROP DATABASE if exists hohoho;
CREATE DATABASE hohoho;

CREATE table roles(
id int auto_increment,
name VARCHAR (20),
primary key (id)
);

CREATE table users(
id int auto_increment,
name VARCHAR(50) NOT NULL,
surname VARCHAR(100),
phone VARCHAR(20),
prof_img_url VARCHAR(500),
email VARCHAR(200),
password VARCHAR(100) NOT NULL,
registration_date datetime default current_timestamp,
roles_id int,
foreign key (roles_id) REFERENCES roles (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id)
);

CREATE table services(
id int auto_increment,
name VARCHAR (200) NOT NULL,
primary key (id)
);

CREATE table towns(
id int auto_increment,
name VARCHAR (100) NOT NULL,
postal_code VARCHAR(50) NOT NULL,
latitude double NOT NULL,
longitude double NOT NULL,
primary key (id)
);

CREATE table events(
id int auto_increment,
title VARCHAR(500) NOT NULL,
description VARCHAR(3000),
img_url VARCHAR (500),
start_date datetime default current_timestamp,
end_date datetime,
entry_price double,
is_public boolean,
latitude double NOT NULL,
longitude double NOT NULL,
id_towns int,
CHECK (end_date>start_date),
foreign key (id_towns) REFERENCES towns (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id)
);

CREATE table hotels(
id int auto_increment,
name VARCHAR (100) NOT NULL,
description VARCHAR (3000),
phone VARCHAR (20),
adress VARCHAR (200),
email VARCHAR(200),
web VARCHAR (500),
number_rooms int,
imgs_url VARCHAR (3000),
price double,
latitude double NOT NULL,
longitude double NOT NULL,
id_users int,
id_towns int,
foreign key (id_users) REFERENCES users (id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (id_towns) REFERENCES towns (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id)
);

CREATE table hotels_events(
id_hotels int,
id_events int,
foreign key (id_hotels) REFERENCES hotels (id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (id_events) REFERENCES events (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id_hotels, id_events)
);

CREATE table add_favourites(
id_hotels int,
id_users int,
star_rating VARCHAR (100),
foreign key (id_hotels) REFERENCES hotels (id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (id_users) REFERENCES users (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id_hotels, id_users)
);

CREATE table hotel_services(
id_services int,
id_hotels int,
foreign key (id_services) REFERENCES services (id)
ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (id_hotels) REFERENCES hotels (id)
ON UPDATE CASCADE ON DELETE CASCADE,
primary key (id_services, id_hotels)
);