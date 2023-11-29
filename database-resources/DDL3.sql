-- -----------------------------------
-- ----------- TABLE ROLES -----------
-- -----------------------------------

-- Select all roles ordered alphabetically:
SELECT * FROM roles ORDER BY `name`;

-- Count the number of users for each role:
SELECT r.`name` AS `role`, COUNT(u.id) AS user_count
FROM roles r
LEFT JOIN users u ON r.id = u.id_role
GROUP BY r.`name`;

-- Find the role with the most users:
SELECT r.`name` AS `role`, COUNT(u.id) AS user_count
FROM roles r
LEFT JOIN users u ON r.id = u.id_role
GROUP BY r.`name`
ORDER BY user_count DESC
LIMIT 1;

-- List roles with at least one user and their corresponding usernames:
SELECT r.`name` AS `role`, u.`name`
FROM roles r
JOIN users u ON r.id = u.id_role
WHERE u.id IS NOT NULL;


-- -----------------------------------
-- ----------- TABLE USERS -----------
-- -----------------------------------

-- Get all users with their corresponding roles:
SELECT u.`name`, u.email, r.`name` AS `role`
FROM users u
JOIN roles r ON u.id_role = r.id;

-- Find users who have a specific role (e.g., 'ADMIN'):
SELECT u.`name`, u.email, r.`name` AS `role`
FROM users u
JOIN roles r ON u.id_role = r.id
WHERE r.`name` = 'ADMIN';

-- Count the number of users registered per year:
SELECT YEAR(registration_date) AS registration_year, COUNT(id) AS user_count
FROM users
GROUP BY registration_year;

-- List users who registered in the last 30 days:
SELECT `name`, email, registration_date
FROM users
WHERE registration_date >= CURDATE() - INTERVAL 30 DAY;


-- ------------------------------------
-- ---------- TABLE SERVICES ----------
-- ------------------------------------

-- Select services for a specific hotel (Reus Boutique Hotel)
SELECT s.`name` AS service_name
FROM hotel_services hs
JOIN services s ON hs.id_service = s.id
WHERE hs.id_hotel = (SELECT id FROM hotels WHERE `name` = 'Tarragona Beach Hotel');

-- Show all services with the number of hotels offering them:
SELECT s.`name` AS service_name, COUNT(hs.id_hotel) AS hotel_count
FROM services s
LEFT JOIN hotel_services hs ON s.id = hs.id_service
GROUP BY s.`name`;


-- ------------------------------------
-- ----------- TABLE TOWNS ------------
-- ------------------------------------

-- List all towns ordered by postal code:
SELECT * FROM towns ORDER BY postal_code;

-- Find the closest town to a specific location (e.g., latitude 40.5, longitude -3.7):
SELECT *, SQRT(POW(latitude - 40.5, 2) + POW(longitude + 3.7, 2)) AS distance
FROM towns
ORDER BY distance
LIMIT 1;

-- Show towns with at least one hotel and the number of hotels in each town:
SELECT t.`name` AS town, COUNT(h.id) AS hotel_count
FROM towns t
LEFT JOIN hotels h ON t.id = h.id_town
GROUP BY t.`name`
HAVING hotel_count > 0;

-- Find towns with no associated hotels:
SELECT t.`name` AS town
FROM towns t
LEFT JOIN hotels h ON t.id = h.id_town
WHERE h.id IS NULL;

-- Calculate the average hotel prices per town:
SELECT t.`name` AS town, AVG(h.price) AS avg_hotel_price
FROM towns t
JOIN hotels h ON t.id = h.id_town
GROUP BY t.`name`;


-- ------------------------------------
-- ----------- TABLE HOTELS -----------
-- ------------------------------------

-- Select hotels with a price less than 150.00
SELECT * FROM hotels WHERE price < 150.00;

-- Show all hotels with their corresponding services:
SELECT h.`name` AS hotel, s.`name` AS service
FROM hotels h
LEFT JOIN hotel_services hs ON h.id = hs.id_hotel
LEFT JOIN services s ON hs.id_service = s.id;

-- List hotels with more than 100 rooms and their room counts:
SELECT `name`, number_rooms
FROM hotels
WHERE number_rooms > 100;

-- Show all hotels in the city of 'Tarragona'
SELECT * 
FROM hotels
WHERE id_town = (SELECT id FROM towns WHERE `name` = 'Tarragona');


-- ------------------------------------
-- ----------- TABLE EVENTS -----------
-- ------------------------------------

-- Select public events in Tarragona
SELECT * 
FROM `events`
WHERE is_public = true AND id_hotel IN (
	SELECT id 
	FROM hotels 
	WHERE id_town = (
		SELECT id 
		FROM towns 
		WHERE `name` = 'Tarragona'));

-- Select events with an entry price greater than 20.00€
SELECT * FROM `events` WHERE entry_price > 20.00;

-- Retrieve all events that are ocurring after some date ordered by the events end date in ascending order:
SELECT title AS event_name, start_date, end_date, `description`
FROM `events`
WHERE end_date > '2023-12-18'
ORDER BY end_date ASC;

-- Get all events associated with a hotel by id_hotel:
SELECT *
FROM `events`
WHERE id_hotel = 3;

-- Get private events of a hotel by id:
SELECT *
FROM `events`
WHERE id_hotel = 6 AND is_public = false;