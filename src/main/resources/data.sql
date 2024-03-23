USE adventurexp;

DELETE FROM adventurexp.activities;
DELETE FROM adventurexp.customers;
DELETE FROM adventurexp.activity_events;
DELETE FROM adventurexp.bookings;

-- Insert activities
INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span) VALUES (UNHEX(REPLACE('a1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), 'Go Karting', 200.00, '<base64 encoded image data>', 'Experience the thrill of racing with our high-speed Go Karts!', 10, 10, 1, 60, 30);
INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span) VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345679', '-', '')), 'Mini Golf', 100.00, '<base64 encoded image data>', 'Enjoy a fun-filled round of Mini Golf with family and friends!', 20, 5, 1, 120, 60);
INSERT INTO adventurexp.activities (id, name, price, base64image, description, capacity, age_limit, is_active, cancel_limit, time_span) VALUES (UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345680', '-', '')), 'Sumo Wrestling', 150.00, '<base64 encoded image data>', 'Step into the ring and experience the excitement of Sumo Wrestling!', 8, 18, 1, 90, 45);

-- Insert activity events
INSERT INTO adventurexp.activity_events (id, activity_id, start_time, available_spots, capacity) VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), UNHEX(REPLACE('a1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), '2024-03-22 10:30:00', 10, 10);
INSERT INTO adventurexp.activity_events (id, activity_id, start_time, available_spots, capacity) VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345676', '-', '')), UNHEX(REPLACE('a1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), '2024-03-22 11:00:00', 10, 10);
INSERT INTO adventurexp.activity_events (id, activity_id, start_time, available_spots, capacity) VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345677', '-', '')), UNHEX(REPLACE('a1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), '2024-03-22 11:30:00', 10, 10);
INSERT INTO adventurexp.activity_events (id, activity_id, start_time, available_spots, capacity) VALUES (UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345679', '-', '')), '2023-04-11 09:00:00', 20, 20);


-- Insert customers
INSERT INTO adventurexp.customers (id, company_name, cvr, is_company, first_name, last_name, email, street_name, street_number, zip_code, city, phone_number, username) VALUES (UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), 'MagnuTron ApS', 37930385, true, 'Mads', 'Kristensen', 'mk@magnutron.dk', 'Tagensvej', '169 TH', 2400, 'KBH NV', 21278060, 'magnutron');
INSERT INTO adventurexp.customers (id, company_name, cvr, is_company, first_name, last_name, email, street_name, street_number, zip_code, city, phone_number, username) VALUES (UNHEX(REPLACE('c1b2c3d4-5678-90ab-cdef-123456789abc', '-', '')), NULL, NULL, false, 'John', 'Doe', 'john.doe@example.com', 'Example Street', '123', 12345, 'Example City', 12345678, 'johndoe');


-- Insert bookings
INSERT INTO adventurexp.bookings (id, customer_id, activity_event_id, booking_number, participants) VALUES (UNHEX(REPLACE('d1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), 1, 4);
INSERT INTO adventurexp.bookings (id, customer_id, activity_event_id, booking_number, participants) VALUES (UNHEX(REPLACE('d1b2c3d4-1234-5678-90ab-cdef12345676', '-', '')), UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345676', '-', '')), 2, 6);
INSERT INTO adventurexp.bookings (id, customer_id, activity_event_id, booking_number, participants) VALUES (UNHEX(REPLACE('d1b2c3d4-1234-5678-90ab-cdef12345677', '-', '')), UNHEX(REPLACE('c1b2c3d4-1234-5678-90ab-cdef12345675', '-', '')), UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345677', '-', '')), 3, 8);
INSERT INTO adventurexp.bookings (id, customer_id, activity_event_id, booking_number, participants) VALUES (UNHEX(REPLACE('d1b2c3d4-1234-5678-90ab-cdef12345679', '-', '')), UNHEX(REPLACE('c1b2c3d4-5678-90ab-cdef-123456789abc', '-', '')), UNHEX(REPLACE('b1b2c3d4-1234-5678-90ab-cdef12345678', '-', '')), 4, 5);
