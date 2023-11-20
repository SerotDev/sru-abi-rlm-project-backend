-- -----------------------------------
-- ----------- TABLE TOWNS -----------
-- -----------------------------------

-- Select all towns
SELECT * FROM towns;

-- Select towns with latitude greater than 41.15
SELECT * FROM towns WHERE latitude > 41.15;

-- Select towns ordered by postal code in descending order
SELECT * FROM towns ORDER BY postal_code DESC;

-- ------------------------------------
-- ----------- TABLE HOTELS -----------
-- ------------------------------------

-- Select all hotels
SELECT * FROM hotels;

-- Select hotels in Tarragona
SELECT * FROM hotels WHERE id_towns = 1;

-- Select hotels with a price less than 150.00
SELECT * FROM hotels WHERE price < 150.00;

-- ------------------------------------
-- ----------- TABLE EVENTS -----------
-- ------------------------------------

-- Select all events
SELECT * FROM events;

-- Select public events in Tarragona
SELECT * FROM events WHERE is_public = true AND id_towns = 1;

-- Select events with an entry price greater than 5.00€
SELECT * FROM events WHERE entry_price > 5.00;

-- ------------------------------------
-- ------- TABLE HOTEL_SERVICES -------
-- ------------------------------------

-- Select all of hotel_services table
SELECT * FROM hotel_services;

-- Select services for a specific hotel (Tarragona Beach Hotel)
SELECT * FROM hotel_services WHERE id_hotels = 1;

-- Select hotels offering the 'Free Wi-Fi' service
SELECT h.* FROM hotels h
	JOIN hotel_services hs ON h.id = hs.id_hotels
	JOIN services s ON hs.id_services = s.id
	WHERE s.name = 'Free Wi-Fi';

-- Select services for a specific hotel (Reus Boutique Hotel)
SELECT s.* FROM services s
	JOIN hotel_services hs ON s.id = hs.id_services
	JOIN hotels h ON hs.id_hotels = h.id
	WHERE h.name = 'Reus Boutique Hotel';

-- ------------------------------------
-- -------- TABLE HOTEL_EVENTS --------
-- ------------------------------------

-- Select all of hotels_events table
SELECT * FROM hotels_events;

-- Select events associated with a specific hotel (Tarragona Beach Hotel)
SELECT e.* FROM `events` e
	JOIN hotels_events he ON e.id = he.id_events
	JOIN hotels h ON he.id_hotels = h.id
	WHERE h.name = 'Tarragona Beach Hotel';

-- Select hotels hosting the 'PortAventura Hotel Christmas Gala' event
SELECT h.* FROM hotels h
	JOIN hotels_events he ON h.id = he.id_hotels
	JOIN `events` e ON he.id_events = e.id
	WHERE e.title = 'PortAventura Hotel Christmas Gala';

-- ------------------------------------
-- ------- TABLE ADD_FAVOURITES -------
-- ------------------------------------

-- Select all of add_favourites table
SELECT * FROM add_favourites;

-- Select hotels favorited and the star_rating by a specific user (User with id 2)
SELECT af.star_rating, h.* FROM hotels h
	JOIN add_favourites af ON h.id = af.id_hotels
	JOIN users u ON af.id_users = u.id
	WHERE u.id = 2;

-- Select users who favorited the 'Salou Resort & Spa'
SELECT u.* FROM users u
	JOIN add_favourites af ON u.id = af.id_users
	JOIN hotels h ON af.id_hotels = h.id
	WHERE h.name = 'Salou Resort & Spa';