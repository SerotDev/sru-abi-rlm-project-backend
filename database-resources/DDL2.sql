DROP DATABASE IF EXISTS hohoho;
CREATE DATABASE hohoho;
USE hohoho;

CREATE TABLE roles(
id INT AUTO_INCREMENT,
`name` VARCHAR(20),
PRIMARY KEY(id)
);
-- Insertions to the roles table
INSERT INTO roles (`name`) VALUES ('VISITOR');
INSERT INTO roles (`name`) VALUES ('HOTEL');
INSERT INTO roles (`name`) VALUES ('ADMIN');

CREATE TABLE users(
id INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
surname VARCHAR(100),
phone VARCHAR(20),
prof_img_url VARCHAR(500),
email VARCHAR(200),
`password` VARCHAR(255) NOT NULL,
registration_date DATETIME DEFAULT CURRENT_TIMESTAMP,
roles_id INT DEFAULT 1, -- By default it is a visitor user
PRIMARY KEY(id),
FOREIGN KEY (roles_id) REFERENCES roles (id) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Insertions of visitant users to the users table
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Kerwinn', 'McKernan', 34642084879, 'kmckernan0@jigsy.com', '$2a$04$1/9ATrB.fbR.Rr6J9IeTTejbUh1Cl4P4unCtIwifSpZnfCZ6vd/Ta');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Domini', 'Seymer', 34605085699, 'dseymer1@devhub.com', '$2a$04$ZjGnHbg/OjB/OouCjBkPrOc1iVOOPdaDT9eAT8WzqsFUz4Ucz4FYW');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Edvard', 'Dockrey', 34653234171, 'edockrey2@cmu.edu', '$2a$04$Zs700UBbPvAAtZ8rQ9Siz.OgpI4/pb18HJkE9h3FKdRI1IrdtqG9C');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Georgeanna', 'Winsbury', 34659002434, 'gwinsbury3@wikimedia.org', '$2a$04$tBCoQVsqHvp5ulinrslo1.WwVAn2jsO4iMzTixkLZ.I59D8VsRM8u');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Roddy', 'Balshen', 34675993502, 'rbalshen4@histats.com', '$2a$04$qMzYFpcKTbpspYTbBqMNI.1X7FP7IHwwf0ZtLr5SjbYkC9GtS1Hfe');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Loren', 'Churchlow', 34636294159, 'lchurchlow5@nasa.gov', '$2a$04$eXqTa6IuTA5KYvwl6EiKCeKxOZkt3OgDHstyadeTzdAILufKesv2C');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Petronella', 'Cleveley', 34656412473, 'pcleveley6@twitpic.com', '$2a$04$YJXHBIcqUwS0FQWaTyW7fOW708TAwUm7cT5jX3UzeqvoAv7zK8bUK');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Raychel', 'Guerrin', 34652393363, 'rguerrin7@earthlink.net', '$2a$04$oPUygXDiL1HvF1K1h/RoAeix5XL2Vbv3uVRLOP6bIoC3LvfzN.ZjK');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Viola', 'Catterill', 34683804790, 'vcatterill8@businessweek.com', '$2a$04$6CRrFOGg7R8Qk6FN1pwZBusCOaqn6qxfSwaoNd/y/Faiy2vnsoQky');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Mortie', 'Capon', 34631328836, 'mcapon9@wikimedia.org', '$2a$04$9yqXBodu51dB8bO2uNLwjegmyObsiA.OuE7Zd9SH3FKaTcsxsGp6a');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Mohandis', 'Presidey', 34628652599, 'mpresideya@harvard.edu', '$2a$04$PyXFMJ5dG5syTQi3XNIxyeB9ao9e32mMO3pqShOnrQHFA4SvjkdK6');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Levi', 'Churchill', 34679714278, 'lchurchillb@tumblr.com', '$2a$04$irxnoHYPfBn06ZXXD9wnqeK2.xvfFt34VIFx1Lr6YwbN7IfYfMFlS');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Kathryne', 'Bortolozzi', 34620099810, 'kbortolozzic@yale.edu', '$2a$04$V8QUTsCEe7iVYRnukDjHeel65aXddQ.baKE8RiCGcNZKFJQFEAI7O');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Dallas', 'Sirette', 34637582075, 'dsiretted@vimeo.com', '$2a$04$6E5Q5CGHU012oyKveiCJ7ektcrDhX3XA3oV/N//hoT75WMdTEWMhW');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Paddy', 'Greenland', 34605002498, 'pgreenlande@shutterfly.com', '$2a$04$l2ujvq9hFd6HJwqB5DRFJOu6Nf2bJ4qjftFDGE.A4NXA7te4/A1xK');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Tallie', 'Yuranovev', 34648813370, 'tyuranovevf@nba.com', '$2a$04$bbFJcBkq2bcEStb9F5USn.NzRjPa3oaWZh0vzXKGWlXMi0SOXzIPC');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Tarrance', 'Spary', 34650589164, 'tsparyg@shareasale.com', '$2a$04$9ux68l6Qf24CbkN2OqFVeedcBW.YsBHOZroasPnz6O8Rgv1dHHWl6');
INSERT INTO users (`name`, surname, phone, email, `password`) VALUES ('Cyndia', 'Draijer', 34621833893, 'cdraijerh@uiuc.edu', '$2a$04$y/iELa0Zj7tz6qmlZ5DA1OZ9fXzG9Yu4vA/TyTcQpdXc5RaFYZ7Py');
-- Insertions of hotel users to the users table
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Sigismondo', 'Adrien', 34614307477, 'sadrienj@issuu.com', '$2a$04$91h7n8DPBRRxXs1Czax1tOVRy1Lu8on/Q.8ekMa8haFk4osrgTqpi', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Susanetta', 'Stirley', 34687016590, 'sstirleyk@businesswire.com', '$2a$04$UpVYECsbeCiAFv9o8NO8HOK/0h/48Q59sKDzTHB1m1ainaIIFzWfq', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Allistir', 'Gaukrodge', 34698312296, 'agaukrodgel@sciencedirect.com', '$2a$04$olrX8euXCjPGbGYhnVwMIu/.OcKkMnjTjwKXomRd2P84L3EYvvqRK', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Marge', 'Duhig', 34657308061, 'mduhigm@chronoengine.com', '$2a$04$YXQ/wt.p0399Xvy2qUbqK.RfpyZAWeVUnHcWPdx1fZsroq6T3uBq.', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Massimiliano', 'Bassom', 34697172341, 'mbassomn@youtube.com', '$2a$04$TdKABIJ14cooZsNwM1517ekVhpNhJKft2Amd4X4K8KCVq/fZ4JTtS', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Errol', 'Brownsell', 34616213948, 'ebrownsello@hp.com', '$2a$04$1eGxNrGeDd.0PIyN1tiqZ.PwFOqCcRyxIXt7rcugECGzZhJElr14m', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Fae', 'Scoterbosh', 34632771852, 'fscoterboshp@woothemes.com', '$2a$04$LeWzw3w6YuYXGdidqL5NM.1DbIui/OzE7.rEIvcobEvyiDVvqjO0i', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Rois', 'Baron', 34627863854, 'rbaronq@miibeian.gov.cn', '$2a$04$a38fp5U/QMdTNbbP2ag92uQvja9xRnUZxgXMCZZvHwV8CcYaAFk86', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Dorise', 'Raynes', 34689764181, 'draynesr@icio.us', '$2a$04$TWA6jHRSTHI2cU1DlmIGyu3D7ZLGzt8k90PCnaLmRyiv5iRHxg.gG', 1);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Rosalynd', 'Pirri', 34658397844, 'rpirris@xinhuanet.com', '$2a$04$CZA.ljPatQnhV5JnxD6Ovu0RQdRf1LZ9jYHUJv19HgyoQMWnBLVSK', 1);
-- Insertions of admin users to the users table
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Jessie', 'Effnert', 34618980196, 'jeffnertt@unicef.org', '$2a$04$UcVL6qyJcICeF9VsDsDwrudT4ThvL9aPLvXdcJHdWxMQidDHZHnWW', 2);
INSERT INTO users (`name`, surname, phone, email, `password`, roles_id) VALUES ('Costa', 'Haggerstone', 34679494629, 'chaggerstonei@opera.com', '$2a$04$hamFdzqsvp8Y7pdmYtJWrOjhpWokbMBx67UAeO1gfgSPW6YnGuuK6', 2);

CREATE table services(
id INT AUTO_INCREMENT,
`name` VARCHAR (200) NOT NULL,
PRIMARY KEY(id)
);
-- Insertions to the services table
INSERT INTO services (`name`) VALUES ('SPA');
INSERT INTO services (`name`) VALUES ('Swimming Pool');
INSERT INTO services (`name`) VALUES ('Gym');
INSERT INTO services (`name`) VALUES ('Room Service');
INSERT INTO services (`name`) VALUES ('Pet-Friendly');
INSERT INTO services (`name`) VALUES ('Near the beach');
INSERT INTO services (`name`) VALUES ('Free Wi-Fi');
INSERT INTO services (`name`) VALUES ('Own activities');

CREATE table towns(
id INT AUTO_INCREMENT,
`name` VARCHAR (100) NOT NULL,
postal_code VARCHAR(50) NOT NULL,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
PRIMARY KEY(id)
);

-- Insertions for the towns table
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Tarragona', '43001', 41.1189, 1.2445);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Reus', '43201', 41.1544, 1.1063);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Salou', '43840', 41.0762, 1.1316);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Cambrils', '43850', 41.0746, 1.0620);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Valls', '43800', 41.2880, 1.2445);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('El Vendrell', '43700', 41.2190, 1.5316);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Amposta', '43870', 40.7034, 0.5814);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Falset', '43730', 41.1453, 0.8218);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Móra d\'Ebre', '43740', 41.1951, 0.8075);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Altafulla', '43893', 41.1535, 1.3661);
INSERT INTO towns (`name`, postal_code, latitude, longitude) VALUES ('Vila-seca', '43480', 41.0876, 1.1668);

CREATE table `events`(
id INT AUTO_INCREMENT,
title VARCHAR(500) NOT NULL,
`description` VARCHAR(3000),
img_url VARCHAR (500),
start_date DATE DEFAULT (CURRENT_DATE),
end_date DATE DEFAULT (CURRENT_DATE),
entry_price DOUBLE,
is_public BOOLEAN,
latitude DOUBLE,
longitude DOUBLE,
id_towns INT,
PRIMARY KEY(id),
FOREIGN KEY (id_towns) REFERENCES towns (id) ON UPDATE CASCADE ON DELETE CASCADE,
CHECK (end_date >= start_date)
);

-- Insertions for the events table
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Christmas Market in Tarragona', 'Explore the festive market with various stalls and holiday decorations.', 'img/christmas_market_tarragona.jpg', '2023-12-15', '2023-12-23', 0.00, true, 41.1189, 1.2445, 1);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Reus Winter Festival', 'Join the winter festivities in Reus with live music, food, and entertainment.', 'img/winter_festival_reus.jpg', '2023-12-10', '2023-12-20', 5.00, true, 41.1544, 1.1063, 2);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Salou Christmas Parade', 'Enjoy the magical Christmas parade featuring Santa Claus and colorful floats.', 'img/christmas_parade_salou.jpg', '2023-12-18', '2023-12-18', 0.00, true, 41.0762, 1.1316, 3);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Cambrils Ice Skating Extravaganza', 'Experience the joy of ice skating in Cambrils with a beautiful winter setup.', 'img/ice_skating_cambrils.jpg', '2023-12-12', '2023-12-26', 8.00, true, 41.0746, 1.0620, 4);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Valls Christmas Choir Concert', 'Immerse yourself in the melodious Christmas choir concert in Valls.', 'img/choir_concert_valls.jpg', '2023-12-22', '2023-12-22', 10.00, true, 41.2880, 1.2445, 5);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Three Wise Men Parade in Tarragona', 'Experience the magical parade welcoming the Three Wise Men with colorful floats and celebrations.', 'img/wise_men_parade_tarragona.jpg', '2023-01-05', '2023-01-05', 0.00, true, 41.1189, 1.2445, 1);

CREATE TABLE hotels(
id INT AUTO_INCREMENT,
`name` VARCHAR (100) NOT NULL,
`description` VARCHAR (3000),
phone VARCHAR (20),
adress VARCHAR (200),
email VARCHAR(200),
web VARCHAR (500),
number_rooms INT,
imgs_url VARCHAR (3000),
price DOUBLE,
latitude DOUBLE,
longitude DOUBLE,
id_users INT,
id_towns INT,
PRIMARY KEY(id),
FOREIGN KEY (id_users) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_towns) REFERENCES towns (id) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Insertions for the hotels table
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('Tarragona Beach Hotel', 'A beachfront hotel with stunning views of the Mediterranean.', '123456789', 'Passeig Marítim 1', 'info@tarragonabeachhotel.com', 'www.tarragonabeachhotel.com', 80, 'tarragona_beach_hotel1.jpg,tarragona_beach_hotel2.jpg', 150.00, 41.1189, 1.2445, 20, 1);
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('Reus Boutique Hotel', 'An intimate boutique hotel in the heart of Reus.', '987654321', 'Carrer Major 15', 'reservations@reusboutiquehotel.com', 'www.reusboutiquehotel.com', 30, 'reus_boutique_hotel1.jpg,reus_boutique_hotel2.jpg', 120.00, 41.1544, 1.1063, 21, 2);
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('Salou Resort & Spa', 'A luxurious resort and spa experience in Salou.', '555123456', 'Avinguda de la Costa 123', 'reservations@salouresort.com', 'www.salouresort.com', 150, 'salou_resort_spa1.jpg,salou_resort_spa2.jpg', 200.00, 41.0762, 1.1316, 22, 3);
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('Cambrils Golf & Spa Hotel', 'Experience a golf and spa retreat in Cambrils.', '999876543', 'Carrer del Golf 567', 'info@cambrilsgolfspa.com', 'www.cambrilsgolfspa.com', 120, 'cambrils_golf_spa1.jpg,cambrils_golf_spa2.jpg', 180.00, 41.0746, 1.0620, 23, 4);
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('Valls Historic Inn', 'Stay in a charming historic inn in the heart of Valls.', '111222333', 'Plaça del Blat 8', 'reservations@vallshistoricinn.com', 'www.vallshistoricinn.com', 15, 'valls_historic_inn1.jpg,valls_historic_inn2.jpg', 80.00, 41.2880, 1.2445, 24, 5);
INSERT INTO hotels (`name`, `description`, phone, adress, email, web, number_rooms, imgs_url, price, latitude, longitude, id_users, id_towns) VALUES ('PortAventura Hotel', 'A magical hotel within the PortAventura resort in Vila-seca.', '987654321', 'Avenida Alcalde Pere Molas, s/n', 'info@portaventurahotel.com', 'www.portaventurahotel.com', 200, 'portaventura_hotel1.jpg,portaventura_hotel2.jpg', 250.00, 41.0876, 1.1668, 25, 11);

CREATE table hotels_events(
id INT AUTO_INCREMENT,
id_hotels INT,
id_events INT,
PRIMARY KEY(id),
UNIQUE KEY hotels_events_uk (id_hotels, id_events),
FOREIGN KEY (id_hotels) REFERENCES hotels (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_events) REFERENCES `events` (id) ON UPDATE CASCADE ON DELETE CASCADE
);
-- Insertions for the private events of hotels
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Tarragona Beach Hotel Christmas Gala', 'Join us for a festive gala by the beach with live music and a special Christmas dinner.', 'tarragona_beach_hotel_gala.jpg', '2023-12-24', '2023-12-24', 75.00, true, 41.1189, 1.2445, 1);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Salou Resort & Spa New Year\'s Spa Retreat', 'Indulge in a luxurious New Year\'s spa retreat at our resort in Salou.', 'salou_resort_spa_new_years_retreat.jpg', '2023-12-31', '2023-12-31', 120.00, true, 41.0762, 1.1316, 3);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('Valls Historic Inn Masquerade Ball', 'Join us for an elegant masquerade ball at our historic inn in Valls.', 'valls_historic_inn_masquerade_ball.jpg', '2023-12-31', '2023-12-31', 60.00, true, 41.2880, 1.2445, 5);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('PortAventura Hotel Christmas Gala', 'Experience the magic of Christmas at our festive gala with live music, a gourmet dinner, and holiday decorations.', 'portaventura_hotel_christmas_gala.jpg', '2023-12-24', '2023-12-24', 120.00, false, 41.0876, 1.1668, 11);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('PortAventura Hotel Christmas Day Brunch', 'Celebrate Christmas Day with a special brunch at PortAventura Hotel, featuring a delicious spread of festive treats.', 'portaventura_hotel_christmas_brunch.jpg', '2023-12-25', '2023-12-25', 80.00, false, 41.0876, 1.1668, 11);
INSERT INTO `events` (title, `description`, img_url, start_date, end_date, entry_price, is_public, latitude, longitude, id_towns) VALUES ('PortAventura Hotel New Year\'s Eve Celebration', 'Ring in the New Year with an exclusive celebration at PortAventura Hotel, featuring fireworks, live performances, and a festive atmosphere.', 'portaventura_hotel_new_years_eve.jpg', '2023-12-31', '2023-12-31', 150.00, false, 41.0876, 1.1668, 11);
-- Insertions for the hotels_events table
INSERT INTO hotels_events (id_hotels, id_events) VALUES (1, 6);
INSERT INTO hotels_events (id_hotels, id_events) VALUES (3, 7);
INSERT INTO hotels_events (id_hotels, id_events) VALUES (5, 8);
INSERT INTO hotels_events (id_hotels, id_events) VALUES (6, 9);
INSERT INTO hotels_events (id_hotels, id_events) VALUES (6, 10);
INSERT INTO hotels_events (id_hotels, id_events) VALUES (6, 11);

CREATE table add_favourites(
id INT AUTO_INCREMENT,
id_hotels INT,
id_users INT,
star_rating TINYINT UNSIGNED,
PRIMARY KEY(id),
UNIQUE KEY add_favourites_uk (id_hotels, id_users),
FOREIGN KEY (id_hotels) REFERENCES hotels (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_users) REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
CHECK (star_rating <= 5)
);
-- Insertions for the add_favourites table
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (1, 1, 4); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (3, 1, 5); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (5, 1, 3); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (6, 1, 4); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (6, 2, 5); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (2, 2, 3); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (4, 2, 1); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (1, 2, 5); -- visitor
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (1, 29, 2); -- admin
INSERT INTO add_favourites (id_hotels, id_users, star_rating) VALUES (6, 29, 4); -- admin

CREATE table hotel_services(
id INT AUTO_INCREMENT,
id_hotels INT,
id_services INT,
PRIMARY KEY(id),
UNIQUE KEY hotel_services_uk (id_hotels, id_services),
FOREIGN KEY (id_hotels) REFERENCES hotels (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_services) REFERENCES services (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Insertions for the hotel_services table
INSERT INTO hotel_services (id_hotels, id_services) VALUES (1, 1); -- Tarragona Beach Hotel - SPA
INSERT INTO hotel_services (id_hotels, id_services) VALUES (1, 6); -- Tarragona Beach Hotel - Near the beach
INSERT INTO hotel_services (id_hotels, id_services) VALUES (1, 8); -- Tarragona Beach Hotel - Own activities
INSERT INTO hotel_services (id_hotels, id_services) VALUES (2, 3); -- Reus Boutique Hotel - Gym
INSERT INTO hotel_services (id_hotels, id_services) VALUES (3, 1); -- Salou Resort & Spa - SPA
INSERT INTO hotel_services (id_hotels, id_services) VALUES (3, 2); -- Salou Resort & Spa - Swimming Pool
INSERT INTO hotel_services (id_hotels, id_services) VALUES (3, 8); -- Salou Resort & Spa - Own activities
INSERT INTO hotel_services (id_hotels, id_services) VALUES (4, 3); -- Cambrils Golf & Spa Hotel - Gym
INSERT INTO hotel_services (id_hotels, id_services) VALUES (4, 7); -- Cambrils Golf & Spa Hotel - Free Wi-Fi
INSERT INTO hotel_services (id_hotels, id_services) VALUES (5, 4); -- Valls Historic Inn - Room Service
INSERT INTO hotel_services (id_hotels, id_services) VALUES (5, 5); -- Valls Historic Inn - Pet-Friendly
INSERT INTO hotel_services (id_hotels, id_services) VALUES (5, 8); -- Valls Historic Inn - Own activities
INSERT INTO hotel_services (id_hotels, id_services) VALUES (6, 1); -- PortAventura Hotel - SPA
INSERT INTO hotel_services (id_hotels, id_services) VALUES (6, 2); -- PortAventura Hotel - Swimming Pool
INSERT INTO hotel_services (id_hotels, id_services) VALUES (6, 7); -- PortAventura Hotel - Free Wi-Fi
INSERT INTO hotel_services (id_hotels, id_services) VALUES (6, 8); -- PortAventura Hotel - Own activities