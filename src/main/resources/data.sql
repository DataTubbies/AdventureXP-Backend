-- CREATE DATABASE IF NOT EXISTS recipes;
USE adventurexp;

--INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span)
--VALUES (UNHEX(REPLACE('a1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), 'Go Karting', 20.00, '<base64 encoded image data>', 'Experience the thrill of racing with our high-speed Go Karts!', 10, 10, 1, 24, 30);

--INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span)
--VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345679', '-', '')), 'Mini Golf', 15.00, '<base64 encoded image data>', 'Enjoy a fun-filled round of Mini Golf with family and friends!', 20, 5, 1, 12, 60);

---INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span)
--VALUES (UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345680', '-', '')), 'Sumo Wrestling', 25.00, '<base64 encoded image data>', 'Step into the ring and experience the excitement of Sumo Wrestling!', 8, 18, 1, 48, 45);rst_name, last_name, email, street_name, street_number, zip_code, city, phone_number, username) VALUES (UUID(), 'Company ApS', 55555555, true, 'John', 'Doe', 'customer@lol.dk', 'Street', 1, 1234, 'City', 12345678, 'customer1');