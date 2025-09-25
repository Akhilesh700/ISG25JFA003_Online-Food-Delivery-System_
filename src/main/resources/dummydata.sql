-- =======================================================================================
-- SCRIPT TO POPULATE ONLINE FOOD DELIVERY SYSTEM
-- Total Users: 100
-- (50 Customers, 30 Restaurants, 20 Delivery Agents)
-- All user passwords are 'password'
-- Bcrypt hash: $2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW
-- =======================================================================================


-- =======================================================================================
-- SECTION 1: USERS (100 TOTAL)
-- =======================================================================================
-- 50 Customer Users
INSERT INTO Users (Email, Password, Role, created_at, updated_at) VALUES
('customer1@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer2@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer3@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer4@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer5@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer6@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer7@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer8@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer9@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer10@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer11@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer12@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer13@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer14@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer15@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer16@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer17@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer18@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer19@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer20@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer21@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer22@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer23@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer24@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer25@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer26@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer27@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer28@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer29@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer30@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer31@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer32@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer33@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer34@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer35@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer36@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer37@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer38@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer39@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer40@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer41@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer42@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer43@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer44@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer45@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer46@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer47@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer48@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer49@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW()),
('customer50@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_CUSTOMER', NOW(), NOW());

-- 30 Restaurant Users
INSERT INTO Users (Email, Password, Role, created_at, updated_at) VALUES
('restaurant1@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant2@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant3@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant4@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant5@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant6@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant7@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant8@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant9@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant10@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant11@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant12@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant13@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant14@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant15@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant16@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant17@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant18@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant19@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant20@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant21@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant22@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant23@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant24@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant25@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant26@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant27@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant28@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant29@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW()),
('restaurant30@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_RESTAURANT', NOW(), NOW());

-- 20 Delivery Agent Users
INSERT INTO Users (Email, Password, Role, created_at, updated_at) VALUES
('agent1@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent2@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent3@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent4@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent5@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent6@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent7@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent8@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent9@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent10@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent11@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent12@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent13@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent14@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent15@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent16@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent17@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent18@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent19@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('agent20@example.com', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzUaH9wohPWMoA9pY/o9oPyTwMYEW', 'ROLE_DELIVERY_AGENT', NOW(), NOW()),
('customer@adminn.com', 'abcd', 'ROLE_CUSTOMER', NOW(), NOW());

-- +=====================================================================================+
-- |====================================	ADMIN    ====================================|
-- +=====================================================================================+
INSERT INTO Users (Email, Password, Role, created_at, updated_at) VALUES
('admin@admin.com', 'abcd', 'ROLE_ADMIN', NOW(), NOW());


-- =======================================================================================
-- SECTION 2: CUSTOMERS (50 TOTAL)
-- Linked to UserIDs 1-50
-- =======================================================================================
INSERT INTO Customer (Name, Phone, Address, DOB, Preferred_Payment, UserID) VALUES
('Aarav Sharma', '9876543210', '123 MG Road, Bengaluru', '1995-05-20', 'Credit Card', 1),
('Vivaan Singh', '9876543211', '456 Park Street, Kolkata', '1990-11-30', 'UPI', 2),
('Aditya Kumar', '9876543212', '789 Anna Salai, Chennai', '1988-02-15', 'Net Banking', 3),
('Vihaan Gupta', '9876543213', '101 Marine Drive, Mumbai', '2000-07-25', 'Cash on Delivery', 4),
('Arjun Patel', '9876543214', '202 Connaught Place, New Delhi', '1998-09-05', 'UPI', 5),
('Sai Reddy', '9876543215', '303 Jubilee Hills, Hyderabad', '1992-03-12', 'Credit Card', 6),
('Reyansh Mehta', '9876543216', '404 Koregaon Park, Pune', '1996-08-19', 'Wallet', 7),
('Krishna Iyer', '9876543217', '505 Ashram Road, Ahmedabad', '1985-12-01', 'UPI', 8),
('Ishaan Nair', '9876543218', '606 C.G. Road, Jaipur', '1999-06-22', 'Credit Card', 9),
('Advik Choudhury', '9876543219', '707 Hazratganj, Lucknow', '1991-04-14', 'Cash on Delivery', 10),
('Ananya Rao', '9123456780', '111 Besant Nagar, Chennai', '1997-01-28', 'UPI', 11),
('Diya Verma', '9123456781', '222 Indiranagar, Bengaluru', '1993-10-03', 'Wallet', 12),
('Saanvi Bose', '9123456782', '333 Salt Lake, Kolkata', '1989-07-16', 'Credit Card', 13),
('Myra Desai', '9123456783', '444 Bandra, Mumbai', '2001-05-09', 'UPI', 14),
('Aadhya Joshi', '9123456784', '555 Hauz Khas, New Delhi', '1994-09-21', 'Net Banking', 15),
('Kiara Pillai', '9123456785', '666 Gachibowli, Hyderabad', '1990-12-31', 'Credit Card', 16),
('Pari Shah', '9123456786', '777 Viman Nagar, Pune', '1998-04-08', 'Cash on Delivery', 17),
('Riya Menon', '9123456787', '888 Satellite, Ahmedabad', '1987-08-27', 'UPI', 18),
('Zoya Agarwal', '9123456788', '999 Vaishali Nagar, Jaipur', '2002-02-18', 'Wallet', 19),
('Avni Das', '9123456789', '1010 Gomti Nagar, Lucknow', '1995-11-11', 'Credit Card', 20),
('Kabir Malhotra', '9234567890', '112 Jayanagar, Bengaluru', '1996-06-06', 'UPI', 21),
('Rohan Kapoor', '9234567891', '213 Alipore, Kolkata', '1991-01-01', 'Cash on Delivery', 22),
('Aryan Bajaj', '9234567892', '314 T. Nagar, Chennai', '1986-03-25', 'Credit Card', 23),
('Neel Khanna', '9234567893', '415 Juhu, Mumbai', '2000-10-10', 'Net Banking', 24),
('Shaurya Bhat', '9234567894', '516 Saket, New Delhi', '1997-07-13', 'UPI', 25),
('Atharv Sengupta', '9234567895', '617 Banjara Hills, Hyderabad', '1992-05-17', 'Wallet', 26),
('Ayaan Khan', '9234567896', '718 Deccan Gymkhana, Pune', '1999-08-30', 'Credit Card', 27),
('Dev Goel', '9234567897', '819 Navrangpura, Ahmedabad', '1984-11-04', 'UPI', 28),
('Ryan Mathew', '9234567898', '910 Malviya Nagar, Jaipur', '2001-09-02', 'Cash on Delivery', 29),
('Veer Dutta', '9234567899', '1111 Aliganj, Lucknow', '1994-12-24', 'Credit Card', 30),
('Fatima Begum', '9345678901', '121 Koramangala, Bengaluru', '1995-02-11', 'UPI', 31),
('Lakshmi Pandit', '9345678902', '222 Howrah, Kolkata', '1990-08-08', 'Wallet', 32),
('Parvati Chavan', '9345678903', '323 Mylapore, Chennai', '1988-10-20', 'Net Banking', 33),
('Gauri Thakur', '9345678904', '424 Dadar, Mumbai', '2000-04-15', 'Credit Card', 34),
('Indira Prasad', '9345678905', '525 Karol Bagh, New Delhi', '1998-01-30', 'UPI', 35),
('Sita Bhattacharya', '9345678906', '626 Madhapur, Hyderabad', '1992-07-07', 'Cash on Delivery', 36),
('Meera Kulkarni', '9345678907', '727 Camp, Pune', '1996-09-13', 'Credit Card', 37),
('Radha Solanki', '9345678908', '828 Maninagar, Ahmedabad', '1985-06-18', 'Wallet', 38),
('Kavita Rathore', '9345678909', '929 C-Scheme, Jaipur', '1999-03-03', 'UPI', 39),
('Pooja Srivastava', '9345678910', '1212 Indira Nagar, Lucknow', '1991-05-29', 'Credit Card', 40),
('Vikram Rathod', '9456789012', '131 Whitefield, Bengaluru', '1993-02-04', 'Net Banking', 41),
('Imran Shaikh', '9456789013', '232 Ballygunge, Kolkata', '1987-11-23', 'UPI', 42),
('Suresh Moorthy', '9456789014', '333 Adyar, Chennai', '1989-01-19', 'Cash on Delivery', 43),
('Rajesh Pandey', '9456789015', '434 Andheri, Mumbai', '2002-06-08', 'Credit Card', 44),
('Manoj Tiwari', '9456789016', '535 Lajpat Nagar, New Delhi', '1994-08-16', 'Wallet', 45),
('Arunachalam Pillai', '9456789017', '636 Secunderabad, Hyderabad', '1990-03-22', 'UPI', 46),
('Prakash Jadhav', '9456789018', '737 Kothrud, Pune', '1998-12-07', 'Credit Card', 47),
('Sanjay Vaghela', '9456789019', '838 Bodakdev, Ahmedabad', '1986-07-31', 'Net Banking', 48),
('Deepak Shekhawat', '9456789020', '939 Raja Park, Jaipur', '2001-10-26', 'UPI', 49),
('Amitabh Saxena', '9456789021', '1313 Aminabad, Lucknow', '1995-04-01', 'Cash on Delivery', 50),
('Ashish Ranjan Singh', '6203899163', 'Dhanoura, Chapra, Bihar', '2003-07-13', 'UPI', 51 );

-- =======================================================================================
-- SECTION 3: Carts (50 TOTAL)
-- Linked to CustomerIDs 1-50
-- =======================================================================================
INSERT INTO cart(custid) VALUES (1);
INSERT INTO cart(custid) VALUES (2);
INSERT INTO cart(custid) VALUES (3);
INSERT INTO cart(custid) VALUES (4);
INSERT INTO cart(custid) VALUES (5);
INSERT INTO cart(custid) VALUES (6);
INSERT INTO cart(custid) VALUES (7);
INSERT INTO cart(custid) VALUES (8);
INSERT INTO cart(custid) VALUES (9);
INSERT INTO cart(custid) VALUES (10);
INSERT INTO cart(custid) VALUES (11);
INSERT INTO cart(custid) VALUES (12);
INSERT INTO cart(custid) VALUES (13);
INSERT INTO cart(custid) VALUES (14);
INSERT INTO cart(custid) VALUES (15);
INSERT INTO cart(custid) VALUES (16);
INSERT INTO cart(custid) VALUES (17);
INSERT INTO cart(custid) VALUES (18);
INSERT INTO cart(custid) VALUES (19);
INSERT INTO cart(custid) VALUES (20);
INSERT INTO cart(custid) VALUES (21);
INSERT INTO cart(custid) VALUES (22);
INSERT INTO cart(custid) VALUES (23);
INSERT INTO cart(custid) VALUES (24);
INSERT INTO cart(custid) VALUES (25);
INSERT INTO cart(custid) VALUES (26);
INSERT INTO cart(custid) VALUES (27);
INSERT INTO cart(custid) VALUES (28);
INSERT INTO cart(custid) VALUES (29);
INSERT INTO cart(custid) VALUES (30);
INSERT INTO cart(custid) VALUES (31);
INSERT INTO cart(custid) VALUES (32);
INSERT INTO cart(custid) VALUES (33);
INSERT INTO cart(custid) VALUES (34);
INSERT INTO cart(custid) VALUES (35);
INSERT INTO cart(custid) VALUES (36);
INSERT INTO cart(custid) VALUES (37);
INSERT INTO cart(custid) VALUES (38);
INSERT INTO cart(custid) VALUES (39);
INSERT INTO cart(custid) VALUES (40);
INSERT INTO cart(custid) VALUES (41);
INSERT INTO cart(custid) VALUES (42);
INSERT INTO cart(custid) VALUES (43);
INSERT INTO cart(custid) VALUES (44);
INSERT INTO cart(custid) VALUES (45);
INSERT INTO cart(custid) VALUES (46);
INSERT INTO cart(custid) VALUES (47);
INSERT INTO cart(custid) VALUES (48);
INSERT INTO cart(custid) VALUES (49);
INSERT INTO cart(custid) VALUES (50);
-- =======================================================================================
-- SECTION 4: RESTAURANTS (30 TOTAL)
-- Linked to UserIDs 51-80
-- =======================================================================================
INSERT INTO Restaurant (Name, img_Url, Address, Phone, Rating, Open_Time, Close_Time, UserID) VALUES
('Punjabi Tadka', 'https://i.imgur.com/punjabi.jpg', '55 Brigade Road, Bengaluru', '8012345678', 4.5, '11:00:00', '23:00:00', 51),
('Coastal Bites', 'https://i.imgur.com/coastal.jpg', '88 Beach Road, Chennai', '4487654321', 4.8, '12:00:00', '22:30:00', 52),
('Dilli Darbar', 'https://i.imgur.com/dilli.jpg', '12 Khan Market, New Delhi', '1123456789', 4.2, '10:00:00', '23:30:00', 53),
('Mumbai Masala', 'https://i.imgur.com/mumbai.jpg', '21 Carter Road, Mumbai', '2298765432', 4.6, '09:00:00', '00:00:00', 54),
('Hyderabadi House', 'https://i.imgur.com/hyderabad.jpg', '45 Hitech City, Hyderabad', '4011223344', 4.7, '11:30:00', '23:00:00', 55),
('Kolkata Kitchen', 'https://i.imgur.com/kolkata.jpg', '7 Park Street, Kolkata', '3355667788', 4.4, '12:00:00', '22:00:00', 56),
('Pune Platter', 'https://i.imgur.com/pune.jpg', '9 F.C. Road, Pune', '2044332211', 4.3, '10:30:00', '23:00:00', 57),
('Rajasthani Rasoi', 'https://i.imgur.com/rajasthan.jpg', '18 M.I. Road, Jaipur', '1418899001', 4.9, '11:00:00', '22:30:00', 58),
('Gujarati Garima', 'https://i.imgur.com/gujarat.jpg', '25 S.G. Highway, Ahmedabad', '7933445566', 4.1, '09:30:00', '22:00:00', 59),
('Nawabi Zaiqa', 'https://i.imgur.com/lucknow.jpg', '30 Hazratganj, Lucknow', '5227788990', 4.5, '12:30:00', '23:30:00', 60),
('The Italian Spot', 'https://i.imgur.com/italian.jpg', '67 Koramangala, Bengaluru', '8023456789', 4.7, '12:00:00', '23:00:00', 61),
('Dragon Wok', 'https://i.imgur.com/chinese.jpg', '91 Nungambakkam, Chennai', '4434567890', 4.3, '11:30:00', '22:30:00', 62),
('Taco Town', 'https://i.imgur.com/mexican.jpg', '105 Connaught Place, New Delhi', '1145678901', 4.0, '11:00:00', '23:00:00', 63),
('Sushi Central', 'https://i.imgur.com/sushi.jpg', '34 Pali Hill, Mumbai', '2256789012', 4.8, '13:00:00', '23:00:00', 64),
('Biryani Bliss', 'https://i.imgur.com/biryani.jpg', '56 Banjara Hills, Hyderabad', '4067890123', 4.9, '12:00:00', '00:00:00', 65),
('Dosa Corner', 'https://i.imgur.com/dosa.jpg', '11 Jayanagar, Bengaluru', '8078901234', 4.6, '08:00:00', '22:00:00', 66),
('Chettinad Spice', 'https://i.imgur.com/chettinad.jpg', '19 T. Nagar, Chennai', '4489012345', 4.5, '11:00:00', '23:00:00', 67),
('Mughlai Marvel', 'https://i.imgur.com/mughlai.jpg', '27 Greater Kailash, New Delhi', '1190123456', 4.4, '12:00:00', '00:30:00', 68),
('Pav Bhaji Palace', 'https://i.imgur.com/pavbhaji.jpg', '48 Juhu Beach, Mumbai', '2212345678', 4.7, '16:00:00', '01:00:00', 69),
('Andhra Flavors', 'https://i.imgur.com/andhra.jpg', '69 Madhapur, Hyderabad', '4023456789', 4.3, '11:30:00', '22:30:00', 70),
('Bengal Sweets', 'https://i.imgur.com/sweets.jpg', '81 Gariahat, Kolkata', '3334567890', 4.8, '09:00:00', '21:00:00', 71),
('Maharashtrian Meals', 'https://i.imgur.com/maharashtra.jpg', '101 Deccan, Pune', '2045678901', 4.2, '10:00:00', '22:00:00', 72),
('Jaipuri Junction', 'https://i.imgur.com/jaipur.jpg', '35 Tonk Road, Jaipur', '1415678901', 4.6, '11:00:00', '23:00:00', 73),
('Kebab Kingdom', 'https://i.imgur.com/kebab.jpg', '41 Aminabad, Lucknow', '5226789012', 4.7, '17:00:00', '00:00:00', 74),
('The Health Hub', 'https://i.imgur.com/health.jpg', '72 Indiranagar, Bengaluru', '8078901235', 4.9, '09:00:00', '21:00:00', 75),
('Sagar Ratna', 'https://i.imgur.com/sagarratna.jpg', '112 Adyar, Chennai', '4489012346', 4.4, '08:30:00', '22:30:00', 76),
('Karim''s', 'https://i.imgur.com/karims.jpg', '133 Chandni Chowk, New Delhi', '1190123457', 4.8, '12:00:00', '23:30:00', 77),
('Leopold Cafe', 'https://i.imgur.com/leopold.jpg', '51 Colaba, Mumbai', '2212345679', 4.3, '10:00:00', '01:30:00', 78),
('Paradise Biryani', 'https://i.imgur.com/paradise.jpg', '78 Secunderabad, Hyderabad', '4023456780', 4.6, '11:00:00', '23:00:00', 79),
('Bawarchi', 'https://i.imgur.com/bawarchi.jpg', '89 RTC X Roads, Hyderabad', '4034567891', 4.5, '11:30:00', '23:30:00', 80);


-- =======================================================================================
-- SECTION 4: DELIVERY AGENTS (20 TOTAL)
-- Linked to UserIDs 81-100
-- =======================================================================================
INSERT INTO Delivery_Agent (Name, Phone, status, Identity_Proof_Type, Identity_Proof_No, UserID) VALUES
('Suresh Kumar', '7890123450', 'Available', 'Aadhar Card', '123456789012', 81),
('Ramesh Patel', '7890123451', 'Offline', 'Driving License', 'DL01234567890', 82),
('Mahesh Singh', '7890123452', 'Available', 'Aadhar Card', '234567890123', 83),
('Ganesh Yadav', '7890123453', 'InDelivery', 'PAN Card', 'ABCDE1234F', 84),
('Rajesh Sharma', '7890123454', 'Available', 'Aadhar Card', '345678901234', 85),
('Vikram Verma', '7890123455', 'Offline', 'Driving License', 'DL02345678901', 86),
('Murali Krishna', '7890123456', 'Available', 'Aadhar Card', '456789012345', 87),
('Arjun Reddy', '7890123457', 'InDelivery', 'PAN Card', 'BCDEF2345G', 88),
('Anand Gupta', '7890123458', 'Available', 'Aadhar Card', '567890123456', 89),
('Prakash Jain', '7890123459', 'Offline', 'Driving License', 'DL03456789012', 90),
('Kiran Desai', '7890123460', 'Available', 'Aadhar Card', '678901234567', 91),
('Sunil Nair', '7890123461', 'Available', 'PAN Card', 'CDEFG3456H', 92),
('John Fernandes', '7890123462', 'Offline', 'Aadhar Card', '789012345678', 93),
('Imran Khan', '7890123463', 'InDelivery', 'Driving License', 'DL04567890123', 94),
('Salim Sheikh', '7890123464', 'Available', 'Aadhar Card', '890123456789', 95),
('Joseph Dsouza', '7890123465', 'Available', 'PAN Card', 'DEFGH4567I', 96),
('Harish Iyer', '7890123466', 'Offline', 'Aadhar Card', '901234567890', 97),
('Gopal Varma', '7890123467', 'Available', 'Driving License', 'DL05678901234', 98),
('Dinesh Choudhary', '7890123468', 'InDelivery', 'Aadhar Card', '112233445566', 99),
('Manish Tiwari', '7890123469', 'Available', 'PAN Card', 'EFGHI5678J', 100);


-- =======================================================================================
-- SECTION 5: STATUS LOOKUP TABLE
-- Defines possible order statuses.
-- =======================================================================================
INSERT INTO Status (Status_Type) VALUES
('PLACED'),
('PENDING')
('PREPARING'),
('OUT_FOR_DELIVERY'),
('DELIVERED'),
('FAILED'),
('NOT_ACCEPTED');


-- =======================================================================================
-- SECTION 6: MENU ITEMS
-- Creating a variety of menu items for each restaurant.
-- =======================================================================================

-- =======================================================================================
-- Restaurant 1: Punjabi Tadka (RestID: 1)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Paneer Butter Masala', 'https://i.imgur.com/6hJ0n.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Creamy paneer in a rich tomato and butter gravy.', 350.00, 25, 1),
('Tandoori Chicken', 'https://i.imgur.com/4gX5A.jpeg', 'North Indian', TRUE, FALSE, 'large', 'Chicken marinated in yogurt and spices, cooked in a tandoor.', 450.00, 30, 1),
('Dal Makhani', 'https://i.imgur.com/N7gG9.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Black lentils and kidney beans slow-cooked in a buttery sauce.', 300.00, 25, 1),
('Garlic Naan', 'https://i.imgur.com/lO7hS.jpeg', 'Breads', TRUE, TRUE, 'small', 'Soft leavened flatbread with garlic and butter.', 60.00, 10, 1),
('Amritsari Kulcha', 'https://i.imgur.com/K3v2a.jpeg', 'North Indian', TRUE, TRUE, 'large', 'Stuffed bread with potatoes and spices, served with chole.', 250.00, 20, 1),
('Chicken Tikka Masala', 'https://i.imgur.com/dZ4fJ.jpeg', 'North Indian', TRUE, FALSE, 'medium', 'Grilled chicken chunks in a spicy, creamy tomato sauce.', 480.00, 30, 1),
('Malai Kofta', 'https://i.imgur.com/rS9gH.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Fried paneer and vegetable balls in a rich, creamy gravy.', 370.00, 25, 1),
('Jeera Rice', 'https://i.imgur.com/Y2wzE.jpeg', 'Rice', TRUE, TRUE, 'medium', 'Basmati rice tempered with cumin seeds.', 180.00, 15, 1),
('Mutton Rogan Josh', 'https://i.imgur.com/qW5xL.jpeg', 'North Indian', TRUE, FALSE, 'medium', 'Aromatic lamb curry with a blend of Kashmiri spices.', 550.00, 40, 1),
('Lassi', 'https://i.imgur.com/jP4fT.jpeg', 'Beverages', TRUE, TRUE, 'medium', 'Sweet and creamy yogurt-based drink.', 120.00, 5, 1);

-- =======================================================================================
-- Restaurant 2: Coastal Bites (RestID: 2)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Fish Curry', 'https://i.imgur.com/sB8vD.jpeg', 'South Indian', TRUE, FALSE, 'medium', 'Spicy and tangy fish curry with coconut milk.', 400.00, 20, 2),
('Prawn Fry', 'https://i.imgur.com/aO9pC.jpeg', 'South Indian', TRUE, FALSE, 'medium', 'Prawns stir-fried with traditional coastal spices.', 420.00, 20, 2),
('Appam with Stew', 'https://i.imgur.com/fG6wB.jpeg', 'South Indian', TRUE, TRUE, 'large', 'Soft rice pancakes served with a mild vegetable stew.', 250.00, 15, 2),
('Neer Dosa', 'https://i.imgur.com/xR1yZ.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Thin, soft rice crepes, a Mangalorean specialty.', 150.00, 15, 2),
('Chicken Ghee Roast', 'https://i.imgur.com/zV0xN.jpeg', 'South Indian', TRUE, FALSE, 'medium', 'Mangalorean style spicy and tangy chicken roasted in ghee.', 380.00, 25, 2),
('Crab Masala', 'https://i.imgur.com/mU4tG.jpeg', 'Seafood', TRUE, FALSE, 'large', 'Fresh crab cooked in a spicy and aromatic masala.', 600.00, 35, 2),
('Squid Rings Fry', 'https://i.imgur.com/bE2sF.jpeg', 'Seafood', TRUE, FALSE, 'medium', 'Crispy fried squid rings seasoned with spices.', 350.00, 20, 2),
('Vegetable Korma', 'https://i.imgur.com/iJ7uH.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Mixed vegetables in a creamy coconut-based gravy.', 280.00, 20, 2),
('Malabar Parotta', 'https://i.imgur.com/kL5pI.jpeg', 'Breads', TRUE, TRUE, 'small', 'Layered flatbread from the Malabar region.', 50.00, 10, 2),
('Coconut Rice', 'https://i.imgur.com/oP3qJ.jpeg', 'Rice', TRUE, TRUE, 'medium', 'Rice flavored with fresh grated coconut and mild spices.', 200.00, 15, 2);

-- =======================================================================================
-- Restaurant 3: Dilli Darbar (RestID: 3)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Chole Bhature', 'https://i.imgur.com/cK9vM.jpeg', 'North Indian', TRUE, TRUE, 'large', 'Spicy chickpeas served with fluffy deep-fried bread.', 280.00, 20, 3),
('Butter Chicken', 'https://i.imgur.com/rT8vN.jpeg', 'North Indian', TRUE, FALSE, 'medium', 'The classic Delhi-style butter chicken in a creamy tomato sauce.', 480.00, 30, 3),
('Shahi Paneer', 'https://i.imgur.com/vL2wP.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Paneer in a rich, creamy Mughlai gravy with nuts.', 380.00, 25, 3),
('Mutton Korma', 'https://i.imgur.com/aQ1xR.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Slow-cooked mutton in a flavorful and aromatic gravy.', 550.00, 40, 3),
('Kulfi Falooda', 'https://i.imgur.com/sT3yS.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Traditional Indian ice cream served with vermicelli and rose syrup.', 150.00, 10, 3),
('Dahi Bhalla', 'https://i.imgur.com/uV4zT.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'Soft lentil dumplings soaked in creamy yogurt and topped with chutneys.', 160.00, 15, 3),
('Nihari Gosht', 'https://i.imgur.com/wX5aU.jpeg', 'Mughlai', TRUE, FALSE, 'large', 'Slow-cooked lamb shank stew, a delicacy from Old Delhi.', 600.00, 50, 3),
('Paneer Tikka', 'https://i.imgur.com/yB6bV.jpeg', 'Tandoori', TRUE, TRUE, 'medium', 'Cubes of paneer marinated in spices and grilled in a tandoor.', 320.00, 20, 3),
('Rumali Roti', 'https://i.imgur.com/zC7cW.jpeg', 'Breads', TRUE, TRUE, 'small', 'Thin, soft flatbread folded like a handkerchief.', 50.00, 10, 3),
('Jalebi with Rabri', 'https://i.imgur.com/aD8dX.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Crispy, syrupy spirals served with thickened sweet milk.', 180.00, 15, 3);

-- =======================================================================================
-- Restaurant 4: Mumbai Masala (RestID: 4)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Vada Pav', 'https://i.imgur.com/bE9eY.jpeg', 'Street Food', TRUE, TRUE, 'small', 'The iconic Mumbai burger with a spiced potato fritter.', 40.00, 5, 4),
('Pav Bhaji', 'https://i.imgur.com/cF0fZ.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'A flavorful mash of mixed vegetables served with soft, buttered bread.', 180.00, 15, 4),
('Bhel Puri', 'https://i.imgur.com/dG1gA.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'A savory snack made of puffed rice, vegetables, and tangy tamarind sauce.', 90.00, 10, 4),
('Pani Puri', 'https://i.imgur.com/eH2hB.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'Hollow puri filled with spiced water, chutney, and fillings.', 80.00, 10, 4),
('Dabeli', 'https://i.imgur.com/fI3iC.jpeg', 'Street Food', TRUE, TRUE, 'small', 'A sweet and spicy potato mixture stuffed in a bun, garnished with pomegranate.', 60.00, 10, 4),
('Chicken Frankie', 'https://i.imgur.com/gJ4jD.jpeg', 'Street Food', TRUE, FALSE, 'large', 'A juicy chicken filling wrapped in a soft flatbread.', 150.00, 15, 4),
('Tawa Pulao', 'https://i.imgur.com/hK5kE.jpeg', 'Rice', TRUE, TRUE, 'medium', 'A popular street food rice dish cooked with vegetables and pav bhaji masala.', 220.00, 20, 4),
('Bombay Sandwich', 'https://i.imgur.com/iL6lF.jpeg', 'Street Food', TRUE, TRUE, 'large', 'A simple yet delicious sandwich with sliced vegetables and chutney.', 120.00, 10, 4),
('Keema Pav', 'https://i.imgur.com/jM7mG.jpeg', 'Street Food', TRUE, FALSE, 'medium', 'Spicy minced meat curry served with soft bread rolls.', 250.00, 20, 4),
('Kanda Bhaji', 'https://i.imgur.com/kN8nH.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'Crispy onion fritters, a perfect monsoon snack.', 100.00, 15, 4);

-- =======================================================================================
-- Restaurant 5: Hyderabadi House (RestID: 5)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Chicken Dum Biryani', 'https://i.imgur.com/lO9oI.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'World-famous slow-cooked layered rice and chicken dish.', 450.00, 45, 5),
('Mutton Haleem', 'https://i.imgur.com/mP0pJ.jpeg', 'Hyderabadi', TRUE, FALSE, 'medium', 'A rich and savory stew of meat, lentils, and pounded wheat.', 500.00, 60, 5),
('Mirchi ka Salan', 'https://i.imgur.com/nQ1qK.jpeg', 'Hyderabadi', TRUE, TRUE, 'medium', 'A spicy chili and peanut curry, a classic side for biryani.', 250.00, 20, 5),
('Hyderabadi Mutton Biryani', 'https://i.imgur.com/oR2rL.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'Authentic biryani made with succulent pieces of lamb.', 520.00, 50, 5),
('Pathar ka Gosht', 'https://i.imgur.com/pS3sM.jpeg', 'Hyderabadi', TRUE, FALSE, 'medium', 'Mutton marinated overnight and cooked on a hot stone.', 480.00, 35, 5),
('Baghare Baingan', 'https://i.imgur.com/qT4tN.jpeg', 'Hyderabadi', TRUE, TRUE, 'medium', 'Eggplants cooked in a tangy peanut and sesame seed gravy.', 280.00, 25, 5),
('Double ka Meetha', 'https://i.imgur.com/rU5uO.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'A bread pudding dessert soaked in saffron and cardamom flavored milk.', 180.00, 20, 5),
('Lukhmi', 'https://i.imgur.com/sV6vP.jpeg', 'Appetizers', TRUE, FALSE, 'small', 'Savory pastries filled with minced meat.', 160.00, 15, 5),
('Hyderabadi Chicken 65', 'https://i.imgur.com/tW7wQ.jpeg', 'Appetizers', TRUE, FALSE, 'medium', 'Spicy, deep-fried chicken bites tossed in a tangy sauce.', 350.00, 20, 5),
('Qubani ka Meetha', 'https://i.imgur.com/uX8xR.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'A traditional dessert made from dried apricots, served with cream.', 200.00, 15, 5);

-- =======================================================================================
-- Restaurant 6: Kolkata Kitchen (RestID: 6)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Macher Jhol', 'https://i.imgur.com/yZ9yS.jpeg', 'Bengali', TRUE, FALSE, 'medium', 'Traditional Bengali fish curry in a light, spicy gravy.', 380.00, 25, 6),
('Kosha Mangsho', 'https://i.imgur.com/za0aT.jpeg', 'Bengali', TRUE, FALSE, 'medium', 'Slow-cooked spicy mutton curry with a thick gravy.', 550.00, 50, 6),
('Shukto', 'https://i.imgur.com/Ab1bU.jpeg', 'Bengali', TRUE, TRUE, 'medium', 'A classic Bengali mixed vegetable dish with a hint of bitterness.', 280.00, 20, 6),
('Luchi Alur Dom', 'https://i.imgur.com/Bc2cV.jpeg', 'Bengali', TRUE, TRUE, 'large', 'Fluffy deep-fried bread served with a spicy potato curry.', 220.00, 20, 6),
('Chingri Malai Curry', 'https://i.imgur.com/Cd3dW.jpeg', 'Bengali', TRUE, FALSE, 'medium', 'Prawns cooked in a creamy and delicious coconut milk gravy.', 480.00, 30, 6),
('Bhetki Paturi', 'https://i.imgur.com/De4eX.jpeg', 'Bengali', TRUE, FALSE, 'medium', 'Barramundi fish marinated in mustard paste and steamed in banana leaves.', 500.00, 35, 6),
('Aloo Posto', 'https://i.imgur.com/Ef5fY.jpeg', 'Bengali', TRUE, TRUE, 'medium', 'Potatoes cooked in a thick and nutty poppy seed paste.', 260.00, 20, 6),
('Mishti Doi', 'https://i.imgur.com/Fg6gZ.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Traditional sweet yogurt from Bengal.', 100.00, 5, 6),
('Kolkata Chicken Biryani', 'https://i.imgur.com/Gh7hA.jpeg', 'Bengali', TRUE, FALSE, 'large', 'Mildly spiced biryani with chicken, potato, and egg.', 420.00, 45, 6),
('Fish Fry', 'https://i.imgur.com/Hi8iB.jpeg', 'Snacks', TRUE, FALSE, 'medium', 'Crumb-coated fish fillet, deep-fried to perfection.', 320.00, 15, 6);

-- =======================================================================================
-- Restaurant 7: Pune Platter (RestID: 7)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Misal Pav', 'https://i.imgur.com/Ij9jC.jpeg', 'Maharashtrian', TRUE, TRUE, 'large', 'Spicy sprouted bean curry topped with farsan, served with pav.', 180.00, 20, 7),
('Pithla Bhakri', 'https://i.imgur.com/Jk0kD.jpeg', 'Maharashtrian', TRUE, TRUE, 'large', 'A traditional gram flour curry served with sorghum flatbread.', 200.00, 20, 7),
('Sabudana Khichdi', 'https://i.imgur.com/Kl1lE.jpeg', 'Maharashtrian', TRUE, TRUE, 'medium', 'Sago pearls cooked with peanuts and potatoes, a popular fasting dish.', 160.00, 15, 7),
('Bharli Vangi', 'https://i.imgur.com/Lm2mF.jpeg', 'Maharashtrian', TRUE, TRUE, 'medium', 'Baby eggplants stuffed with a coconut and peanut masala.', 280.00, 25, 7),
('Kothimbir Vadi', 'https://i.imgur.com/Mn3nG.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'Crispy fritters made from cilantro and gram flour.', 140.00, 20, 7),
('Chicken Kolhapuri', 'https://i.imgur.com/No4oH.jpeg', 'Maharashtrian', TRUE, FALSE, 'medium', 'A fiery hot chicken curry from Kolhapur.', 450.00, 30, 7),
('Puran Poli', 'https://i.imgur.com/Op5pI.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Sweet flatbread stuffed with a lentil and jaggery filling.', 120.00, 25, 7),
('Aamras Puri', 'https://i.imgur.com/Pq6qJ.jpeg', 'Seasonal', TRUE, TRUE, 'large', 'Sweet mango pulp served with fluffy deep-fried bread.', 250.00, 15, 7),
('Shrikhand', 'https://i.imgur.com/Qr7rK.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A sweet dish made of strained yogurt, flavored with saffron and cardamom.', 130.00, 5, 7),
('Solkadhi', 'https://i.imgur.com/Rs8sL.jpeg', 'Beverages', TRUE, TRUE, 'small', 'A refreshing drink made from coconut milk and kokum.', 90.00, 5, 7);

-- =======================================================================================
-- Restaurant 8: Rajasthani Rasoi (RestID: 8)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Dal Baati Churma', 'https://i.imgur.com/St9tM.jpeg', 'Rajasthani', TRUE, TRUE, 'large', 'The classic Rajasthani platter of lentils, baked wheat balls, and sweetened cereal.', 450.00, 40, 8),
('Laal Maas', 'https://i.imgur.com/Tu0uN.jpeg', 'Rajasthani', TRUE, FALSE, 'medium', 'A fiery mutton curry known for its vibrant red color from Mathania chillies.', 580.00, 50, 8),
('Gatte ki Sabzi', 'https://i.imgur.com/Uv1vO.jpeg', 'Rajasthani', TRUE, TRUE, 'medium', 'Gram flour dumplings cooked in a tangy yogurt-based gravy.', 320.00, 25, 8),
('Ker Sangri', 'https://i.imgur.com/Vw2wP.jpeg', 'Rajasthani', TRUE, TRUE, 'medium', 'A traditional dish made from desert beans and berries.', 350.00, 30, 8),
('Pyaz Kachori', 'https://i.imgur.com/Wx3xQ.jpeg', 'Snacks', TRUE, TRUE, 'small', 'Crispy, deep-fried pastry filled with a spicy onion mixture.', 60.00, 15, 8),
('Safed Maas', 'https://i.imgur.com/Xy4yR.jpeg', 'Rajasthani', TRUE, FALSE, 'medium', 'A delicate mutton curry cooked in a white gravy of yogurt, nuts, and seeds.', 560.00, 45, 8),
('Bajre ki Roti', 'https://i.imgur.com/Yz5zS.jpeg', 'Breads', TRUE, TRUE, 'small', 'Hearty flatbread made from pearl millet flour.', 70.00, 15, 8),
('Malpua with Rabri', 'https://i.imgur.com/Za6aT.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Sweet pancakes soaked in sugar syrup, served with thickened milk.', 180.00, 20, 8),
('Ghevar', 'https://i.imgur.com/Ab7bU.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'A disc-shaped sweet cake made with flour and soaked in sugar syrup.', 200.00, 25, 8),
('Mirchi Bada', 'https://i.imgur.com/Bc8cV.jpeg', 'Snacks', TRUE, TRUE, 'small', 'Large green chillies stuffed with potato filling, battered, and fried.', 50.00, 15, 8);

-- =======================================================================================
-- Restaurant 9: Gujarati Garima (RestID: 9)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Gujarati Thali', 'https://i.imgur.com/Cd9dW.jpeg', 'Gujarati', TRUE, TRUE, 'extraLarge', 'A complete meal with a variety of Gujarati dishes.', 500.00, 30, 9),
('Dhokla', 'https://i.imgur.com/De0eX.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'A soft and spongy steamed cake made from fermented batter.', 120.00, 20, 9),
('Khandvi', 'https://i.imgur.com/Ef1fY.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'Soft, yellowish, tightly rolled bite-sized pieces made of gram flour.', 140.00, 25, 9),
('Undhiyu', 'https://i.imgur.com/Fg2gZ.jpeg', 'Gujarati', TRUE, TRUE, 'medium', 'A classic mixed vegetable dish, slow-cooked to perfection.', 350.00, 40, 9),
('Thepla', 'https://i.imgur.com/Gh3hA.jpeg', 'Breads', TRUE, TRUE, 'small', 'Soft flatbreads made from wheat flour and fenugreek leaves.', 50.00, 10, 9),
('Fafda Jalebi', 'https://i.imgur.com/Hi4iB.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'A popular breakfast combo of crispy gram flour strips and sweet syrupy swirls.', 160.00, 15, 9),
('Dal Dhokli', 'https://i.imgur.com/Ij5jC.jpeg', 'Gujarati', TRUE, TRUE, 'medium', 'Wheat flour dumplings simmered in a sweet and tangy lentil curry.', 280.00, 25, 9),
('Basundi', 'https://i.imgur.com/Jk6kD.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A sweetened dense milk dish flavored with cardamom and nuts.', 150.00, 10, 9),
('Sev Tameta nu Shaak', 'https://i.imgur.com/Kl7lE.jpeg', 'Gujarati', TRUE, TRUE, 'medium', 'A sweet and sour tomato curry topped with crispy gram flour noodles.', 260.00, 20, 9),
('Chaas', 'https://i.imgur.com/Lm8mF.jpeg', 'Beverages', TRUE, TRUE, 'small', 'Spiced buttermilk, a refreshing digestive drink.', 70.00, 5, 9);

-- =======================================================================================
-- Restaurant 10: Nawabi Zaiqa (RestID: 10)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Galouti Kebab', 'https://i.imgur.com/Mn9nG.jpeg', 'Awadhi', TRUE, FALSE, 'medium', 'Melt-in-the-mouth minced mutton kebabs, a Lucknowi specialty.', 480.00, 30, 10),
('Lucknowi Biryani', 'https://i.imgur.com/No0oH.jpeg', 'Awadhi', TRUE, FALSE, 'large', 'Subtly flavored and aromatic biryani cooked in the dum pukht style.', 520.00, 50, 10),
('Tunday Kebab', 'https://i.imgur.com/Op1pI.jpeg', 'Awadhi', TRUE, FALSE, 'medium', 'The legendary soft buffalo meat kebabs with a secret blend of spices.', 450.00, 30, 10),
('Shami Kebab', 'https://i.imgur.com/Pq2qJ.jpeg', 'Awadhi', TRUE, FALSE, 'medium', 'Delicate patties of minced meat and lentils, pan-fried.', 420.00, 25, 10),
('Sheermal', 'https://i.imgur.com/Qr3rK.jpeg', 'Breads', TRUE, TRUE, 'small', 'A saffron-flavored traditional flatbread, slightly sweet.', 80.00, 15, 10),
('Nihari', 'https://i.imgur.com/Rs4sL.jpeg', 'Awadhi', TRUE, FALSE, 'large', 'Slow-cooked shank meat stew, a royal breakfast dish.', 580.00, 60, 10),
('Veg Galouti Kebab', 'https://i.imgur.com/St5tM.jpeg', 'Awadhi', TRUE, TRUE, 'medium', 'A vegetarian version of the famous kebab made with yam and spices.', 380.00, 25, 10),
('Shahi Tukda', 'https://i.imgur.com/Tu6uN.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Rich bread pudding with fried bread slices soaked in thickened milk.', 220.00, 20, 10),
('Kulfi', 'https://i.imgur.com/Uv7vO.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Traditional slow-frozen milk-based ice cream.', 150.00, 5, 10),
('Warqi Paratha', 'https://i.imgur.com/Vw8wP.jpeg', 'Breads', TRUE, TRUE, 'small', 'A flaky, layered paratha that pairs well with rich curries.', 70.00, 15, 10);

-- =======================================================================================
-- Restaurant 11: The Italian Spot (RestID: 11)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Margherita Pizza', 'https://i.imgur.com/4gX5A.jpeg', 'Italian', TRUE, TRUE, 'large', 'Classic pizza with fresh mozzarella, tomatoes, and basil.', 450.00, 20, 11),
('Pasta Carbonara', 'https://i.imgur.com/N7gG9.jpeg', 'Italian', TRUE, FALSE, 'medium', 'Spaghetti with eggs, cheese, pancetta, and black pepper.', 520.00, 25, 11),
('Mushroom Risotto', 'https://i.imgur.com/lO7hS.jpeg', 'Italian', TRUE, TRUE, 'medium', 'Creamy risotto cooked with wild mushrooms and parmesan.', 480.00, 30, 11),
('Lasagna Bolognese', 'https://i.imgur.com/K3v2a.jpeg', 'Italian', TRUE, FALSE, 'large', 'Layered pasta with meat sauce, béchamel, and cheese.', 550.00, 35, 11),
('Garlic Bread with Cheese', 'https://i.imgur.com/dZ4fJ.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Toasted bread with garlic butter and melted mozzarella.', 250.00, 15, 11),
('Pesto Pasta', 'https://i.imgur.com/rS9gH.jpeg', 'Italian', TRUE, TRUE, 'medium', 'Penne pasta tossed in a fresh basil pesto sauce.', 460.00, 20, 11),
('Tiramisu', 'https://i.imgur.com/Y2wzE.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Classic Italian coffee-flavored dessert.', 300.00, 10, 11),
('Bruschetta', 'https://i.imgur.com/qW5xL.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Grilled bread topped with fresh tomatoes, garlic, and olive oil.', 220.00, 15, 11),
('Chicken Parmesan', 'https://i.imgur.com/jP4fT.jpeg', 'Italian', TRUE, FALSE, 'large', 'Breaded chicken breast topped with marinara sauce and cheese.', 580.00, 30, 11),
('Minestrone Soup', 'https://i.imgur.com/sB8vD.jpeg', 'Soups', TRUE, TRUE, 'medium', 'A hearty Italian vegetable soup.', 200.00, 20, 11);

-- =======================================================================================
-- Restaurant 12: Dragon Wok (RestID: 12)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Veg Hakka Noodles', 'https://i.imgur.com/noodles.jpeg', 'Chinese', TRUE, TRUE, 'large', 'Stir-fried noodles with a variety of vegetables.', 280.00, 15, 12),
('Chicken Momos', 'https://i.imgur.com/momos.jpeg', 'Chinese', TRUE, FALSE, 'medium', 'Steamed dumplings with a savory chicken filling.', 220.00, 20, 12),
('Chilli Paneer Dry', 'https://i.imgur.com/cp.jpeg', 'Indo-Chinese', TRUE, TRUE, 'medium', 'Fried paneer cubes tossed in a spicy and tangy sauce.', 340.00, 20, 12),
('Manchurian Gravy', 'https://i.imgur.com/manchurian.jpeg', 'Indo-Chinese', TRUE, TRUE, 'medium', 'Vegetable balls in a classic soy-garlic sauce.', 320.00, 20, 12),
('Kung Pao Chicken', 'https://i.imgur.com/kungpao.jpeg', 'Chinese', TRUE, FALSE, 'medium', 'A spicy stir-fry dish made with chicken, peanuts, and vegetables.', 450.00, 25, 12),
('Spring Rolls', 'https://i.imgur.com/springroll.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Crispy fried rolls stuffed with vegetables.', 200.00, 15, 12),
('Sweet Corn Soup', 'https://i.imgur.com/sweetcorn.jpeg', 'Soups', TRUE, TRUE, 'medium', 'A comforting and creamy soup made with sweet corn.', 180.00, 15, 12),
('Schezwan Fried Rice', 'https://i.imgur.com/friedrice.jpeg', 'Indo-Chinese', TRUE, FALSE, 'large', 'Spicy fried rice with chicken, egg, and Schezwan sauce.', 350.00, 20, 12),
('Hot & Sour Soup', 'https://i.imgur.com/hotsour.jpeg', 'Soups', TRUE, FALSE, 'medium', 'A spicy and sour soup with chicken and vegetables.', 200.00, 15, 12),
('Date Pancakes with Ice Cream', 'https://i.imgur.com/datepancake.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Crispy pancakes with a date filling, served with vanilla ice cream.', 250.00, 15, 12);

-- =======================================================================================
-- Restaurant 13: Taco Town (RestID: 13)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Classic Chicken Tacos', 'https://i.imgur.com/taco.jpeg', 'Mexican', TRUE, FALSE, 'medium', 'Soft tacos with grilled chicken, salsa, and cheese.', 350.00, 20, 13),
('Bean and Cheese Burrito', 'https://i.imgur.com/burrito.jpeg', 'Mexican', TRUE, TRUE, 'large', 'A large flour tortilla filled with refried beans, rice, and cheese.', 380.00, 20, 13),
('Veggie Quesadilla', 'https://i.imgur.com/quesadilla.jpeg', 'Mexican', TRUE, TRUE, 'large', 'Grilled tortilla filled with cheese, bell peppers, and corn.', 320.00, 15, 13),
('Nachos Supreme', 'https://i.imgur.com/nachos.jpeg', 'Mexican', TRUE, FALSE, 'large', 'Corn chips loaded with ground meat, cheese sauce, beans, and jalapenos.', 400.00, 15, 13),
('Chicken Enchiladas', 'https://i.imgur.com/enchilada.jpeg', 'Mexican', TRUE, FALSE, 'large', 'Corn tortillas rolled around a chicken filling and covered with a chili pepper sauce.', 450.00, 25, 13),
('Guacamole with Chips', 'https://i.imgur.com/guac.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Freshly made avocado dip served with crispy corn chips.', 280.00, 10, 13),
('Taco Salad', 'https://i.imgur.com/tacosalad.jpeg', 'Salads', TRUE, TRUE, 'large', 'A crisp tortilla bowl filled with lettuce, beans, corn, and salsa.', 300.00, 15, 13),
('Churros with Chocolate Sauce', 'https://i.imgur.com/churros.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Fried-dough pastry served with a rich chocolate dipping sauce.', 250.00, 15, 13),
('Spicy Lamb Tacos', 'https://i.imgur.com/lambtaco.jpeg', 'Mexican', TRUE, FALSE, 'medium', 'Hard shell tacos with spicy minced lamb and sour cream.', 420.00, 20, 13),
('Horchata', 'https://i.imgur.com/horchata.jpeg', 'Beverages', TRUE, TRUE, 'medium', 'A traditional Mexican drink made from rice milk and cinnamon.', 150.00, 5, 13);

-- =======================================================================================
-- Restaurant 14: Sushi Central (RestID: 14)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('California Roll', 'https://i.imgur.com/caliroll.jpeg', 'Japanese', TRUE, FALSE, 'medium', 'An inside-out sushi roll with crab meat, avocado, and cucumber.', 550.00, 20, 14),
('Spicy Tuna Roll', 'https://i.imgur.com/tunaroll.jpeg', 'Japanese', TRUE, FALSE, 'medium', 'Sushi roll with spicy tuna, and scallions.', 600.00, 20, 14),
('Avocado Maki', 'https://i.imgur.com/avomaki.jpeg', 'Japanese', TRUE, TRUE, 'medium', 'A simple and creamy sushi roll with just avocado.', 450.00, 15, 14),
('Salmon Nigiri', 'https://i.imgur.com/nigiri.jpeg', 'Japanese', TRUE, FALSE, 'small', 'A slice of raw salmon over pressed vinegared rice (2 pieces).', 400.00, 15, 14),
('Chicken Katsu Curry', 'https://i.imgur.com/katsu.jpeg', 'Japanese', TRUE, FALSE, 'large', 'A crispy fried chicken cutlet with a savory Japanese curry sauce.', 650.00, 25, 14),
('Edamame', 'https://i.imgur.com/edamame.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Steamed young soybeans sprinkled with sea salt.', 250.00, 10, 14),
('Miso Soup', 'https://i.imgur.com/miso.jpeg', 'Soups', TRUE, TRUE, 'small', 'A traditional Japanese soup with tofu, and seaweed.', 200.00, 10, 14),
('Tempura Prawns', 'https://i.imgur.com/tempura.jpeg', 'Appetizers', TRUE, FALSE, 'medium', 'Lightly battered and deep-fried prawns.', 580.00, 20, 14),
('Dragon Roll', 'https://i.imgur.com/dragonroll.jpeg', 'Japanese', TRUE, FALSE, 'large', 'An elaborate roll with eel, crab, and avocado, resembling a dragon.', 750.00, 25, 14),
('Mochi Ice Cream', 'https://i.imgur.com/mochi.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A small, round confection consisting of a soft, pounded sticky rice dumpling.', 300.00, 5, 14);

-- =======================================================================================
-- Restaurant 15: Biryani Bliss (RestID: 15)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Lucknowi Chicken Biryani', 'https://i.imgur.com/aO9pC.jpeg', 'Awadhi', TRUE, FALSE, 'large', 'Subtly flavored biryani with succulent chicken pieces.', 460.00, 45, 15),
('Hyderabadi Mutton Biryani', 'https://i.imgur.com/fG6wB.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'Spicy and aromatic biryani with tender mutton.', 520.00, 50, 15),
('Kolkata Chicken Biryani', 'https://i.imgur.com/xR1yZ.jpeg', 'Bengali', TRUE, FALSE, 'large', 'Mildly spiced biryani with chicken, potato, and egg.', 440.00, 45, 15),
('Vegetable Dum Biryani', 'https://i.imgur.com/zV0xN.jpeg', 'Hyderabadi', TRUE, TRUE, 'large', 'Aromatic rice dish with mixed vegetables and spices.', 380.00, 40, 15),
('Paneer Tikka Biryani', 'https://i.imgur.com/mU4tG.jpeg', 'Fusion', TRUE, TRUE, 'large', 'Layered biryani with grilled paneer tikka.', 420.00, 40, 15),
('Fish Biryani', 'https://i.imgur.com/bE2sF.jpeg', 'Coastal', TRUE, FALSE, 'large', 'Flavorful biryani with seer fish fillets.', 500.00, 45, 15),
('Prawn Biryani', 'https://i.imgur.com/iJ7uH.jpeg', 'Coastal', TRUE, FALSE, 'large', 'Spicy and tangy biryani with fresh prawns.', 540.00, 45, 15),
('Egg Biryani', 'https://i.imgur.com/kL5pI.jpeg', 'Hyderabadi', TRUE, TRUE, 'large', 'Aromatic basmati rice cooked with boiled eggs and spices.', 350.00, 40, 15),
('Mirchi ka Salan', 'https://i.imgur.com/oP3qJ.jpeg', 'Hyderabadi', TRUE, TRUE, 'medium', 'Spicy chili and peanut curry to accompany biryani.', 150.00, 20, 15),
('Raita', 'https://i.imgur.com/cK9vM.jpeg', 'Sides', TRUE, TRUE, 'small', 'Yogurt with cucumber and mint, a cool side for biryani.', 80.00, 5, 15);

-- =======================================================================================
-- Restaurant 16: Dosa Corner (RestID: 16)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Masala Dosa', 'https://i.imgur.com/dosa.jpeg', 'South Indian', TRUE, TRUE, 'large', 'A crispy rice crepe filled with a savory potato mash.', 180.00, 15, 16),
('Ghee Roast Dosa', 'https://i.imgur.com/gheedosa.jpeg', 'South Indian', TRUE, TRUE, 'large', 'A conical, crispy dosa roasted with generous amounts of ghee.', 220.00, 15, 16),
('Onion Rava Dosa', 'https://i.imgur.com/ravadosa.jpeg', 'South Indian', TRUE, TRUE, 'large', 'A crisp and lacy crepe made from semolina and rice flour, with onions.', 200.00, 20, 16),
('Idli Sambar', 'https://i.imgur.com/idli.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Steamed rice and lentil cakes served with lentil stew and chutney.', 120.00, 10, 16),
('Medu Vada', 'https://i.imgur.com/vada.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Crispy and savory deep-fried lentil doughnuts.', 140.00, 15, 16),
('Mysore Masala Dosa', 'https://i.imgur.com/mysoredosa.jpeg', 'South Indian', TRUE, TRUE, 'large', 'A dosa smeared with a spicy red chutney before adding the potato filling.', 210.00, 20, 16),
('Pongal', 'https://i.imgur.com/pongal.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'A savory dish made with rice and yellow lentils, seasoned with pepper and cumin.', 160.00, 20, 16),
('Poori Masala', 'https://i.imgur.com/poori.jpeg', 'South Indian', TRUE, TRUE, 'large', 'Fluffy deep-fried bread served with a potato masala.', 170.00, 15, 16),
('Filter Coffee', 'https://i.imgur.com/coffee.jpeg', 'Beverages', TRUE, TRUE, 'small', 'Strong, aromatic South Indian filter coffee.', 60.00, 5, 16),
('Plain Uthappam', 'https://i.imgur.com/uthappam.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'A thick pancake-like dosa, soft in the center and crisp at the edges.', 150.00, 15, 16);

-- =======================================================================================
-- Restaurant 17: Chettinad Spice (RestID: 17)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Chicken Chettinad', 'https://i.imgur.com/chettinad.jpeg', 'Chettinad', TRUE, FALSE, 'medium', 'A fiery and aromatic chicken curry made with a special blend of spices.', 450.00, 30, 17),
('Mutton Chukka', 'https://i.imgur.com/chukka.jpeg', 'Chettinad', TRUE, FALSE, 'medium', 'Dry mutton dish where meat is roasted with spices until tender.', 580.00, 40, 17),
('Kola Urundai', 'https://i.imgur.com/kola.jpeg', 'Chettinad', TRUE, FALSE, 'medium', 'Spicy minced mutton balls, deep-fried to perfection.', 420.00, 25, 17),
('Paniyaram', 'https://i.imgur.com/paniyaram.jpeg', 'Chettinad', TRUE, TRUE, 'medium', 'Pan-fried dumplings made from fermented rice and lentil batter.', 180.00, 20, 17),
('Vanjaram Fish Fry', 'https://i.imgur.com/fishfry.jpeg', 'Chettinad', TRUE, FALSE, 'medium', 'Seer fish slices marinated in Chettinad spices and tawa fried.', 550.00, 20, 17),
('Mushroom Chettinad', 'https://i.imgur.com/mushroom.jpeg', 'Chettinad', TRUE, TRUE, 'medium', 'A vegetarian version of the classic curry with mushrooms.', 350.00, 25, 17),
('Parotta Salna', 'https://i.imgur.com/parotta.jpeg', 'Chettinad', TRUE, TRUE, 'large', 'Layered flatbread served with a spicy, watery gravy.', 150.00, 15, 17),
('Nattukozhi Rasam', 'https://i.imgur.com/rasam.jpeg', 'Soups', TRUE, FALSE, 'small', 'A spicy soup made with country chicken and traditional spices.', 200.00, 20, 17),
('Kavuni Arisi', 'https://i.imgur.com/kavuni.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A sweet pudding made from black rice, coconut, and jaggery.', 160.00, 10, 17),
('Ennai Kathirikai', 'https://i.imgur.com/kathirikai.jpeg', 'Chettinad', TRUE, TRUE, 'medium', 'Stuffed baby eggplants cooked in a tangy and spicy gravy.', 300.00, 25, 17);

-- =======================================================================================
-- Restaurant 18: Mughlai Marvel (RestID: 18)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Mutton Korma', 'https://i.imgur.com/korma.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'A rich and creamy mutton curry made with yogurt, nuts, and spices.', 560.00, 45, 18),
('Chicken Jahangiri', 'https://i.imgur.com/jahangiri.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'A royal chicken dish cooked in a rich and aromatic gravy.', 520.00, 35, 18),
('Navratan Korma', 'https://i.imgur.com/navratan.jpeg', 'Mughlai', TRUE, TRUE, 'medium', 'A creamy curry made with nine different vegetables, fruits, and nuts.', 420.00, 30, 18),
('Paneer Pasanda', 'https://i.imgur.com/pasanda.jpeg', 'Mughlai', TRUE, TRUE, 'medium', 'Stuffed paneer sandwiches in a rich, creamy tomato-based gravy.', 450.00, 30, 18),
('Seekh Kebab', 'https://i.imgur.com/seekh.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Minced meat kebabs, skewered and cooked in a tandoor.', 480.00, 25, 18),
('Mughlai Paratha', 'https://i.imgur.com/mughlaiparatha.jpeg', 'Mughlai', TRUE, FALSE, 'large', 'A rich, pan-fried bread stuffed with minced meat and egg.', 300.00, 20, 18),
('Shahi Tukda', 'https://i.imgur.com/shahitukda.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Royal bread pudding with fried bread, thickened milk, and nuts.', 220.00, 15, 18),
('Zafrani Pulao', 'https://i.imgur.com/pulao.jpeg', 'Rice', TRUE, TRUE, 'medium', 'Aromatic basmati rice cooked with saffron, nuts, and raisins.', 350.00, 20, 18),
('Haleem', 'https://i.imgur.com/haleem.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'A rich stew of meat, lentils, and wheat, slow-cooked for hours.', 550.00, 60, 18),
('Phirni', 'https://i.imgur.com/phirni.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A creamy pudding made from ground rice, milk, and sugar.', 160.00, 10, 18);

-- =======================================================================================
-- Restaurant 19: Pav Bhaji Palace (RestID: 19)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Classic Pav Bhaji', 'https://i.imgur.com/pavbhaji.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'The quintessential mashed vegetable curry served with soft buttered buns.', 180.00, 15, 19),
('Cheese Pav Bhaji', 'https://i.imgur.com/cheesepav.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'Classic pav bhaji topped with a generous amount of grated cheese.', 220.00, 20, 19),
('Paneer Pav Bhaji', 'https://i.imgur.com/paneerpav.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'Pav bhaji with added chunks of soft paneer.', 240.00, 20, 19),
('Mushroom Pav Bhaji', 'https://i.imgur.com/mushroompav.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'A variation of pav bhaji with the earthy flavor of mushrooms.', 230.00, 20, 19),
('Jain Pav Bhaji', 'https://i.imgur.com/jainpav.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'Pav bhaji prepared without onions, garlic, or potatoes.', 200.00, 20, 19),
('Khada Pav Bhaji', 'https://i.imgur.com/khadapav.jpeg', 'Street Food', TRUE, TRUE, 'medium', 'A version where the vegetables are kept chunky instead of being mashed.', 190.00, 15, 19),
('Tawa Pulao', 'https://i.imgur.com/tawapulao.jpeg', 'Rice', TRUE, TRUE, 'medium', 'Rice cooked on a large griddle with pav bhaji masala and vegetables.', 220.00, 20, 19),
('Extra Pav (2 pcs)', 'https://i.imgur.com/pav.jpeg', 'Sides', TRUE, TRUE, 'small', 'A pair of extra buttered buns.', 40.00, 5, 19),
('Masala Pav', 'https://i.imgur.com/masalapav.jpeg', 'Snacks', TRUE, TRUE, 'medium', 'Buns sliced and stuffed with a spicy onion and tomato mixture.', 120.00, 10, 19),
('Caramel Custard', 'https://i.imgur.com/custard.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A classic creamy egg custard with a layer of soft caramel on top.', 150.00, 5, 19);

-- =======================================================================================
-- Restaurant 20: Andhra Flavors (RestID: 20)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Gongura Mutton', 'https://i.imgur.com/gongura.jpeg', 'Andhra', TRUE, FALSE, 'medium', 'A tangy and spicy mutton curry made with sorrel leaves.', 580.00, 40, 20),
('Andhra Chicken Curry', 'https://i.imgur.com/andhrachicken.jpeg', 'Andhra', TRUE, FALSE, 'medium', 'A fiery chicken curry with a distinct flavor of green chillies and spices.', 460.00, 30, 20),
('Pesarattu Upma', 'https://i.imgur.com/pesarattu.jpeg', 'Andhra', TRUE, TRUE, 'large', 'A crepe made from green gram, stuffed with semolina upma.', 200.00, 20, 20),
('Gutti Vankaya Kura', 'https://i.imgur.com/vankaya.jpeg', 'Andhra', TRUE, TRUE, 'medium', 'Stuffed eggplant curry with a peanut and sesame seed masala.', 320.00, 25, 20),
('Royyala Vepudu', 'https://i.imgur.com/royyala.jpeg', 'Andhra', TRUE, FALSE, 'medium', 'Spicy and flavorful prawn fry.', 550.00, 25, 20),
('Andhra Veg Meals', 'https://i.imgur.com/andhraveg.jpeg', 'Andhra', TRUE, TRUE, 'extraLarge', 'A traditional thali with rice, pappu, sambar, and various curries.', 400.00, 20, 20),
('Chicken 65', 'https://i.imgur.com/chicken65.jpeg', 'Appetizers', TRUE, FALSE, 'medium', 'Spicy, deep-fried chicken bites, Andhra style.', 380.00, 20, 20),
('Pappu Charu', 'https://i.imgur.com/pappu.jpeg', 'Soups', TRUE, TRUE, 'medium', 'A tangy lentil stew similar to rasam.', 150.00, 15, 20),
('Curd Rice', 'https://i.imgur.com/curdrice.jpeg', 'Rice', TRUE, TRUE, 'medium', 'A cooling and comforting dish of yogurt and rice.', 160.00, 10, 20),
('Boorelu', 'https://i.imgur.com/boorelu.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Deep-fried sweet dumplings with a lentil and jaggery filling.', 180.00, 25, 20);

-- =======================================================================================
-- Restaurant 21: Bengal Sweets (RestID: 21)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Rosogolla', 'https://i.imgur.com/rasgulla.jpeg', 'Sweets', TRUE, TRUE, 'small', 'Spongy cheese balls soaked in light sugar syrup (2 pcs).', 80.00, 5, 21),
('Sandesh', 'https://i.imgur.com/sandesh.jpeg', 'Sweets', TRUE, TRUE, 'small', 'A delicate sweet made from fresh paneer (2 pcs).', 100.00, 5, 21),
('Mishti Doi', 'https://i.imgur.com/mishtidoi.jpeg', 'Sweets', TRUE, TRUE, 'medium', 'Traditional sweet yogurt, set in an earthen pot.', 120.00, 5, 21),
('Cham Cham', 'https://i.imgur.com/chamcham.jpeg', 'Sweets', TRUE, TRUE, 'small', 'Oval-shaped sweets made from paneer, often coated in coconut.', 90.00, 5, 21),
('Kheer Kodom', 'https://i.imgur.com/kheerkodom.jpeg', 'Sweets', TRUE, TRUE, 'small', 'A small rasgulla encased in a layer of sweet khoya.', 130.00, 10, 21),
('Patisapta', 'https://i.imgur.com/patisapta.jpeg', 'Sweets', TRUE, TRUE, 'medium', 'Thin crepes stuffed with a coconut and jaggery filling.', 150.00, 15, 21),
('Shor Bhaja', 'https://i.imgur.com/shorbhaja.jpeg', 'Sweets', TRUE, TRUE, 'medium', 'A rich sweet made by deep-frying layers of milk cream.', 180.00, 20, 21),
('Pantua', 'https://i.imgur.com/pantua.jpeg', 'Sweets', TRUE, TRUE, 'small', 'Similar to a gulab jamun, but with a distinct Bengali taste.', 80.00, 10, 21),
('Ledikeni', 'https://i.imgur.com/ledikeni.jpeg', 'Sweets', TRUE, TRUE, 'small', 'A light brown sweetmeat made of chhana and flour.', 90.00, 10, 21),
('Sita Bhog', 'https://i.imgur.com/sitabhog.jpeg', 'Sweets', TRUE, TRUE, 'medium', 'A rice-based sweet that looks like vermicelli, mixed with small gulab jamuns.', 160.00, 15, 21);

-- =======================================================================================
-- Restaurant 22: Maharashtrian Meals (RestID: 22)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Zunka Bhakar', 'https://i.imgur.com/zunka.jpeg', 'Maharashtrian', TRUE, TRUE, 'large', 'A traditional dish of gram flour paste served with sorghum flatbread.', 220.00, 20, 22),
('Varan Bhaat', 'https://i.imgur.com/varan.jpeg', 'Maharashtrian', TRUE, TRUE, 'medium', 'A comforting meal of plain dal, steamed rice, and a dollop of ghee.', 180.00, 15, 22),
('Batata Vada', 'https://i.imgur.com/batatavada.jpeg', 'Snacks', TRUE, TRUE, 'small', 'Spiced potato fritters, the filling for a Vada Pav (2 pcs).', 80.00, 15, 22),
('Thalipeeth', 'https://i.imgur.com/thalipeeth.jpeg', 'Maharashtrian', TRUE, TRUE, 'medium', 'A savory multi-grain pancake, served with butter.', 160.00, 20, 22),
('Malvani Fish Curry', 'https://i.imgur.com/malvani.jpeg', 'Maharashtrian', TRUE, FALSE, 'medium', 'A spicy and tangy fish curry from the Konkan coast.', 520.00, 30, 22),
('Pandhra Rassa', 'https://i.imgur.com/pandhra.jpeg', 'Maharashtrian', TRUE, FALSE, 'medium', 'A white, soupy mutton curry made with coconut milk.', 480.00, 40, 22),
('Tambda Rassa', 'https://i.imgur.com/tambda.jpeg', 'Maharashtrian', TRUE, FALSE, 'medium', 'A fiery red mutton curry, a specialty of Kolhapur.', 480.00, 40, 22),
('Modak', 'https://i.imgur.com/modak.jpeg', 'Desserts', TRUE, TRUE, 'medium', 'Steamed rice flour dumplings with a coconut-jaggery filling (2 pcs).', 140.00, 25, 22),
('Kombdi Vade', 'https://i.imgur.com/kombdi.jpeg', 'Maharashtrian', TRUE, FALSE, 'large', 'A traditional dish of chicken curry served with fluffy, deep-fried bread.', 450.00, 35, 22),
('Amti', 'https://i.imgur.com/amti.jpeg', 'Maharashtrian', TRUE, TRUE, 'medium', 'A sweet and sour lentil curry.', 150.00, 20, 22);

-- =======================================================================================
-- Restaurant 23: Jaipuri Junction (RestID: 23)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Dal Baati', 'https://i.imgur.com/dalbaati.jpeg', 'Rajasthani', TRUE, TRUE, 'large', 'A platter of spicy lentils served with hard baked wheat balls.', 400.00, 40, 23),
('Ker Sangri', 'https://i.imgur.com/kersangri.jpeg', 'Rajasthani', TRUE, TRUE, 'medium', 'A traditional piquant dish made from desert beans and berries.', 350.00, 30, 23),
('Laal Maas', 'https://i.imgur.com/laalmaas.jpeg', 'Rajasthani', TRUE, FALSE, 'medium', 'A fiery mutton curry made with red Mathania chillies.', 580.00, 50, 23),
('Gatte ki Sabzi', 'https://i.imgur.com/gatte.jpeg', 'Rajasthani', TRUE, TRUE, 'medium', 'Gram flour dumplings in a tangy yogurt gravy.', 320.00, 25, 23),
('Mawa Kachori', 'https://i.imgur.com/mawa.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A rich pastry stuffed with sweetened khoya and nuts.', 120.00, 20, 23),
('Pyaz Kachori with Kadi', 'https://i.imgur.com/pyazkachori.jpeg', 'Rajasthani', TRUE, TRUE, 'medium', 'Crispy onion-stuffed pastry served with a spicy yogurt curry.', 180.00, 20, 23),
('Rajasthani Thali', 'https://i.imgur.com/thali.jpeg', 'Rajasthani', TRUE, TRUE, 'extraLarge', 'A grand platter featuring Dal, Baati, Gatte, Ker Sangri and more.', 600.00, 30, 23),
('Jungli Maas', 'https://i.imgur.com/jungli.jpeg', 'Rajasthani', TRUE, FALSE, 'medium', 'A simple but robust mutton curry made with just a few ingredients.', 560.00, 45, 23),
('Mohanthal', 'https://i.imgur.com/mohanthal.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A dense, fudgy sweet made from gram flour and ghee.', 150.00, 10, 23),
('Churma Ladoo', 'https://i.imgur.com/churma.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Sweet ladoos made from crumbled baatis, ghee, and jaggery.', 140.00, 10, 23);

-- =======================================================================================
-- Restaurant 24: Kebab Kingdom (RestID: 24)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Mutton Seekh Kebab', 'https://i.imgur.com/muttonseekh.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Minced mutton blended with spices, skewered and grilled.', 480.00, 25, 24),
('Chicken Malai Tikka', 'https://i.imgur.com/malaitikka.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Creamy, non-spicy chicken kebabs marinated in cheese and cream.', 460.00, 25, 24),
('Paneer Tikka Shashlik', 'https://i.imgur.com/shashlik.jpeg', 'Tandoori', TRUE, TRUE, 'medium', 'Paneer, bell peppers, and onions marinated and grilled.', 380.00, 20, 24),
('Galouti Kebab with Ulte Tawe ka Paratha', 'https://i.imgur.com/galouti.jpeg', 'Awadhi', TRUE, FALSE, 'large', 'Melt-in-the-mouth mutton kebabs served with a special griddle bread.', 550.00, 30, 24),
('Hara Bhara Kebab', 'https://i.imgur.com/harabhara.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Pan-fried spicy patties made with spinach, peas, and potatoes.', 320.00, 20, 24),
('Tangdi Kebab', 'https://i.imgur.com/tangdi.jpeg', 'Tandoori', TRUE, FALSE, 'large', 'Chicken drumsticks marinated and cooked in a tandoor.', 450.00, 30, 24),
('Dahi Ke Kebab', 'https://i.imgur.com/dahikebab.jpeg', 'Appetizers', TRUE, TRUE, 'medium', 'Soft, creamy kebabs made from hung curd and spices.', 360.00, 20, 24),
('Fish Tikka', 'https://i.imgur.com/fishtikka.jpeg', 'Tandoori', TRUE, FALSE, 'medium', 'Boneless fish chunks marinated in yogurt and spices, grilled.', 520.00, 25, 24),
('Boti Kebab', 'https://i.imgur.com/boti.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Tender chunks of lamb marinated and grilled to perfection.', 580.00, 30, 24),
('Kebab Platter', 'https://i.imgur.com/platter.jpeg', 'Mughlai', TRUE, FALSE, 'extraLarge', 'An assortment of our best chicken, mutton, and fish kebabs.', 1200.00, 35, 24);

-- =======================================================================================
-- Restaurant 25: The Health Hub (RestID: 25)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Quinoa Salad with Grilled Chicken', 'https://i.imgur.com/quinoasalad.jpeg', 'Healthy', TRUE, FALSE, 'large', 'A wholesome salad with quinoa, fresh veggies, and grilled chicken breast.', 450.00, 20, 25),
('Avocado Toast', 'https://i.imgur.com/avocadotoast.jpeg', 'Healthy', TRUE, TRUE, 'medium', 'Smashed avocado on multi-grain toast, topped with seeds.', 350.00, 10, 25),
('Green Smoothie Bowl', 'https://i.imgur.com/smoothiebowl.jpeg', 'Healthy', TRUE, TRUE, 'large', 'A thick smoothie with spinach and banana, topped with fruits and granola.', 380.00, 15, 25),
('Grilled Fish with Sautéed Veggies', 'https://i.imgur.com/grilledfish.jpeg', 'Healthy', TRUE, FALSE, 'large', 'Grilled sea bass served with a side of lightly sautéed vegetables.', 550.00, 25, 25),
('Millet Upma', 'https://i.imgur.com/milletupma.jpeg', 'Healthy', TRUE, TRUE, 'medium', 'A healthy twist on the classic upma, made with foxtail millet.', 250.00, 20, 25),
('Oats Idli', 'https://i.imgur.com/oatsidli.jpeg', 'Healthy', TRUE, TRUE, 'medium', 'Steamed savory cakes made from oats, low in calories.', 220.00, 20, 25),
('Hummus Platter', 'https://i.imgur.com/hummusplatter.jpeg', 'Mediterranean', TRUE, TRUE, 'large', 'Creamy hummus served with whole wheat pita and fresh veggie sticks.', 400.00, 15, 25),
('Fruit Salad with Yogurt', 'https://i.imgur.com/fruitsalad.jpeg', 'Healthy', TRUE, TRUE, 'medium', 'A bowl of assorted fresh fruits served with Greek yogurt.', 300.00, 10, 25),
('Brown Rice with Lentil Curry', 'https://i.imgur.com/brownrice.jpeg', 'Healthy', TRUE, TRUE, 'large', 'A simple, nutritious meal of steamed brown rice and lentil curry.', 320.00, 20, 25),
('Detox Juice', 'https://i.imgur.com/detoxjuice.jpeg', 'Beverages', TRUE, TRUE, 'medium', 'A refreshing blend of cucumber, mint, and lemon.', 180.00, 5, 25);

-- =======================================================================================
-- Restaurant 26: Sagar Ratna (RestID: 26)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('South Indian Thali', 'https://i.imgur.com/souththali.jpeg', 'South Indian', TRUE, TRUE, 'extraLarge', 'A complete meal with sambar, rasam, poriyal, rice, and appalam.', 380.00, 20, 26),
('Rava Kesari', 'https://i.imgur.com/kesari.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A sweet pudding made from semolina, ghee, and sugar.', 120.00, 15, 26),
('Paper Masala Dosa', 'https://i.imgur.com/paperdosa.jpeg', 'South Indian', TRUE, TRUE, 'extraLarge', 'A very thin, large and crispy dosa with potato filling.', 250.00, 20, 26),
('Onion Tomato Uthappam', 'https://i.imgur.com/onionuthappam.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'A thick pancake dosa topped with onions and tomatoes.', 200.00, 15, 26),
('Sambar Vada', 'https://i.imgur.com/sambarvada.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Crispy lentil doughnuts soaked in hot sambar.', 150.00, 10, 26),
('Bisi Bele Bath', 'https://i.imgur.com/bisibelebath.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'A hot lentil and rice dish from Karnataka, cooked with vegetables.', 220.00, 20, 26),
('Rasam Rice', 'https://i.imgur.com/rasamrice.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Steamed rice mixed with a tangy and spicy tamarind soup.', 160.00, 15, 26),
('Paneer Dosa', 'https://i.imgur.com/paneerdosa.jpeg', 'Fusion', TRUE, TRUE, 'large', 'A crispy dosa with a spicy paneer filling.', 240.00, 20, 26),
('Mini Idlis in Sambar', 'https://i.imgur.com/miniidli.jpeg', 'South Indian', TRUE, TRUE, 'medium', 'Button-sized idlis dunked in a bowl of flavorful sambar.', 140.00, 15, 26),
('Badam Halwa', 'https://i.imgur.com/badamhalwa.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A rich and decadent sweet made from almonds.', 180.00, 10, 26);

-- =======================================================================================
-- Restaurant 27: Karim's (RestID: 27)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Mutton Burra', 'https://i.imgur.com/burra.jpeg', 'Mughlai', TRUE, FALSE, 'large', 'Tender mutton chops marinated and chargrilled to perfection.', 650.00, 35, 27),
('Chicken Jahangiri', 'https://i.imgur.com/jahangirichicken.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'A rich, creamy chicken curry fit for a king.', 550.00, 30, 27),
('Badam Pasanda', 'https://i.imgur.com/badampasanda.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Mutton curry cooked in a rich and nutty almond gravy.', 620.00, 40, 27),
('Brain Curry', 'https://i.imgur.com/braincurry.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'A delicacy of goat brain cooked in a thick, spicy gravy.', 500.00, 25, 27),
('Khamiri Roti', 'https://i.imgur.com/khamiri.jpeg', 'Breads', TRUE, TRUE, 'small', 'A soft and spongy leavened flatbread.', 60.00, 10, 27),
('Nihari', 'https://i.imgur.com/nihari.jpeg', 'Mughlai', TRUE, FALSE, 'large', 'Slow-cooked mutton stew, a signature dish.', 600.00, 60, 27),
('Karim Roll', 'https://i.imgur.com/karimroll.jpeg', 'Rolls', TRUE, FALSE, 'large', 'A skewer of mutton seekh kebab wrapped in a paratha.', 250.00, 15, 27),
('Akbari Murgh Masala', 'https://i.imgur.com/akbari.jpeg', 'Mughlai', TRUE, FALSE, 'medium', 'Chicken cooked in a robust tomato and onion gravy.', 540.00, 30, 27),
('Shahi Paneer', 'https://i.imgur.com/shahipaneer.jpeg', 'Mughlai', TRUE, TRUE, 'medium', 'Paneer in a rich, creamy gravy (vegetarian option).', 420.00, 25, 27),
('Kheer Benazeer', 'https://i.imgur.com/kheer.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A unique and flavorful rice pudding.', 180.00, 10, 27);

-- =======================================================================================
-- Restaurant 28: Leopold Cafe (RestID: 28)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Chilli Chicken', 'https://i.imgur.com/chillichicken.jpeg', 'Indo-Chinese', TRUE, FALSE, 'medium', 'A classic spicy and tangy dish of fried chicken.', 480.00, 20, 28),
('Leopold Special Pasta', 'https://i.imgur.com/leopasta.jpeg', 'Continental', TRUE, TRUE, 'large', 'Penne pasta in a creamy mixed sauce with exotic vegetables.', 550.00, 25, 28),
('Mutton Keema Pav', 'https://i.imgur.com/keemapav.jpeg', 'Indian', TRUE, FALSE, 'medium', 'Spicy minced mutton curry served with soft bread rolls.', 450.00, 25, 28),
('Fish and Chips', 'https://i.imgur.com/fishchips.jpeg', 'Continental', TRUE, FALSE, 'large', 'Battered fried fish served with french fries.', 600.00, 20, 28),
('Leopold Beer Tower', 'https://i.imgur.com/beer.jpeg', 'Beverages', TRUE, FALSE, 'extraLarge', 'A large dispenser of draft beer to share.', 1500.00, 5, 28),
('Veg Club Sandwich', 'https://i.imgur.com/clubsandwich.jpeg', 'Continental', TRUE, TRUE, 'large', 'A double-decker sandwich with fresh vegetables.', 400.00, 15, 28),
('Beef Chilli Dry', 'https://i.imgur.com/beefchilli.jpeg', 'Indo-Chinese', TRUE, FALSE, 'medium', 'Strips of beef tossed in a spicy soy and chili sauce.', 580.00, 25, 28),
('Cheesecake', 'https://i.imgur.com/cheesecake.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A classic New York style baked cheesecake.', 350.00, 5, 28),
('Chicken Stroganoff', 'https://i.imgur.com/stroganoff.jpeg', 'Continental', TRUE, FALSE, 'large', 'Sautéed pieces of chicken in a sauce with sour cream, served with rice.', 620.00, 30, 28),
('Iced Tea', 'https://i.imgur.com/icedtea.jpeg', 'Beverages', TRUE, TRUE, 'medium', 'A refreshing lemon iced tea.', 180.00, 5, 28);

-- =======================================================================================
-- Restaurant 29: Paradise Biryani (RestID: 29)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Paradise Special Chicken Biryani', 'https://i.imgur.com/paradisechicken.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'The legendary chicken biryani from Paradise.', 480.00, 45, 29),
('Paradise Special Mutton Biryani', 'https://i.imgur.com/paradisemutton.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'Tender mutton pieces in fragrant basmati rice.', 550.00, 50, 29),
('Egg Biryani', 'https://i.imgur.com/paradiseegg.jpeg', 'Hyderabadi', TRUE, TRUE, 'large', 'Aromatic biryani with boiled eggs.', 380.00, 40, 29),
('Veg Biryani', 'https://i.imgur.com/paradiseveg.jpeg', 'Hyderabadi', TRUE, TRUE, 'large', 'Flavorful biryani with assorted fresh vegetables.', 360.00, 40, 29),
('Chicken Tikka Kebab', 'https://i.imgur.com/paradisetikka.jpeg', 'Tandoori', TRUE, FALSE, 'medium', 'Boneless chicken chunks marinated in spices and grilled.', 450.00, 25, 29),
('Paneer Tikka Kebab', 'https://i.imgur.com/paradisepaneer.jpeg', 'Tandoori', TRUE, TRUE, 'medium', 'Grilled paneer cubes with a smoky flavor.', 400.00, 25, 29),
('Apollo Fish', 'https://i.imgur.com/apollofish.jpeg', 'Appetizers', TRUE, FALSE, 'medium', 'Spicy, batter-fried fish, a Hyderabadi specialty.', 520.00, 20, 29),
('Mutton Seekh Kebab', 'https://i.imgur.com/paradiseseekh.jpeg', 'Tandoori', TRUE, FALSE, 'medium', 'Minced mutton kebabs cooked on skewers.', 500.00, 25, 29),
('Qubani ka Meetha', 'https://i.imgur.com/paradisequbani.jpeg', 'Desserts', TRUE, TRUE, 'small', 'A classic Hyderabadi dessert made from dried apricots.', 200.00, 10, 29),
('Double ka Meetha', 'https://i.imgur.com/paradisedouble.jpeg', 'Desserts', TRUE, TRUE, 'small', 'Sweet bread pudding with a rich, milky texture.', 180.00, 10, 29);

-- =======================================================================================
-- Restaurant 30: Bawarchi (RestID: 30)
-- =======================================================================================
INSERT INTO Menu_items (Name, img_Url, Cuisine_Type, is_Available, is_Vegetarian, Size, Description, Price, Prep_Time, RestID) VALUES
('Bawarchi Chicken Dum Biryani', 'https://i.imgur.com/bawarchichicken.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'Famous RTC X Roads style chicken biryani.', 470.00, 45, 30),
('Bawarchi Mutton Dum Biryani', 'https://i.imgur.com/bawarchimutton.jpeg', 'Hyderabadi', TRUE, FALSE, 'large', 'Spicy mutton biryani, a local favorite.', 540.00, 50, 30),
('Tandoori Roti', 'https://i.imgur.com/tandooriroti.jpeg', 'Breads', TRUE, TRUE, 'small', 'Whole wheat flatbread cooked in a clay oven.', 40.00, 10, 30),
('Kadai Chicken', 'https://i.imgur.com/kadaichicken.jpeg', 'North Indian', TRUE, FALSE, 'medium', 'Chicken cooked in a wok with tomatoes, onions, and bell peppers.', 480.00, 30, 30),
('Kadai Paneer', 'https://i.imgur.com/kadaipaneer.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Paneer cooked in a wok with a spicy tomato-based gravy.', 420.00, 25, 30),
('Chicken Fried Rice', 'https://i.imgur.com/chickenfriedrice.jpeg', 'Indo-Chinese', TRUE, FALSE, 'large', 'Classic fried rice with chicken, egg, and vegetables.', 350.00, 20, 30),
('Chicken Majestic', 'https://i.imgur.com/majestic.jpeg', 'Appetizers', TRUE, FALSE, 'medium', 'Spicy chicken strips tossed in a yogurt-based sauce.', 400.00, 25, 30),
('Mutton Fry', 'https://i.imgur.com/muttonfry.jpeg', 'Andhra', TRUE, FALSE, 'medium', 'Dry and spicy mutton pieces roasted with spices.', 560.00, 35, 30),
('Dal Tadka', 'https://i.imgur.com/daltadka.jpeg', 'North Indian', TRUE, TRUE, 'medium', 'Yellow lentils tempered with ghee and spices.', 250.00, 20, 30),
('Veg Soft Noodles', 'https://i.imgur.com/vegnoodles.jpeg', 'Indo-Chinese', TRUE, TRUE, 'large', 'Simple stir-fried noodles with mixed vegetables.', 300.00, 20, 30);
-- =======================================================================================
-- For a real script, TotalAmount would be calculated. Here, plausible values are used.
-- =======================================================================================
-- SECTION 7: ORDERS (200 TOTAL) - COMPLETE SCRIPT
-- Simulating a history of orders with realistic status distribution.
-- =======================================================================================

-- Status Key: 1=PLACED, 2=PREPARING, 3=OUT_FOR_DELIVERY, 4=DELIVERED, 5=FAILED, 6=NOT_ACCEPTED
-- CustID is 1-50, RestID is 1-30.
INSERT INTO `Order` (Special_Req, Order_Time, Total_Amount, CustID, RestID, Status) VALUES
-- Provided Sample Data (Orders 1-15)
('Less spicy please.', '2025-09-23 19:30:00', 410.00, 1, 1, 4),
('Extra onions.', '2025-09-24 07:05:00', 670.00, 2, 2, 3),
(NULL, '2025-09-24 08:30:00', 280.00, 3, 3, 2),
('No coriander.', '2025-09-22 20:00:00', 180.00, 4, 4, 5),
(NULL, '2025-09-24 08:45:10', 700.00, 5, 5, 1),
('Pack cutlery.', '2025-09-23 14:00:00', 530.00, 10, 10, 4),
(NULL, '2025-09-23 18:45:00', 830.00, 15, 15, 4),
('Double wrap the curry.', '2025-09-24 08:10:15', 390.00, 20, 20, 3),
(NULL, '2025-09-24 08:35:00', 450.00, 25, 25, 2),
('Birthday message on box.', '2025-09-21 19:00:00', 1200.00, 30, 30, 4),
(NULL, '2025-09-24 08:48:05', 350.00, 35, 1, 1),
('Call before arriving.', '2025-09-24 08:20:00', 420.00, 40, 2, 3),
(NULL, '2025-09-23 21:00:00', 280.00, 45, 3, 4),
('No plastic bags please.', '2025-09-20 12:30:00', 180.00, 50, 4, 6),
(NULL, '2025-09-24 08:49:30', 520.00, 6, 18, 1),

-- Newly Generated Data (Orders 16-200)
('Make it extra hot!', '2025-09-22 13:10:20', 780.00, 12, 22, 4),
('Please provide extra tissues.', '2025-09-23 19:45:11', 455.00, 28, 7, 4),
('No nuts, allergy alert.', '2025-09-21 20:05:33', 950.00, 42, 11, 4),
(NULL, '2025-09-24 08:40:00', 320.00, 8, 16, 2),
('Separate packing for all items.', '2025-09-22 18:30:00', 1150.00, 33, 29, 4),
('Less oil in the curry.', '2025-09-23 12:15:45', 620.00, 19, 5, 4),
('Add a slice of lemon.', '2025-09-24 08:25:18', 250.00, 48, 19, 3),
(NULL, '2025-09-20 11:40:00', 880.00, 7, 13, 4),
('Ensure the food is hot on arrival.', '2025-09-24 08:46:00', 510.00, 21, 8, 1),
('No garlic in any dish.', '2025-09-19 19:55:00', 730.00, 37, 25, 4),
(NULL, '2025-09-22 20:30:10', 490.00, 14, 2, 4),
('Do not ring the bell, call on arrival.', '2025-09-23 22:00:00', 310.00, 25, 14, 4),
('Please add extra spoons.', '2025-09-18 13:00:00', 980.00, 44, 28, 4),
(NULL, '2025-09-24 01:15:00', 650.00, 3, 23, 5),
('Keep the salad separate from hot food.', '2025-09-24 08:42:00', 890.00, 39, 17, 2),
('Extra cheese on one pizza.', '2025-09-21 21:10:00', 1250.00, 4, 11, 4),
(NULL, '2025-09-23 17:50:00', 430.00, 16, 26, 4),
('Use whole wheat bread for the sandwich.', '2025-09-24 07:45:00', 290.00, 29, 25, 3),
('Send only ripened avocados.', '2025-09-22 09:00:00', 350.00, 41, 25, 4),
(NULL, '2025-09-24 08:50:00', 760.00, 18, 12, 1),
('Mild spicy for kids.', '2025-09-20 19:20:00', 1450.00, 22, 6, 4),
('Payment failed, trying again.', '2025-09-19 18:00:00', 560.00, 31, 20, 5),
('Cut the pizza into 6 slices.', '2025-09-23 20:10:00', 780.00, 11, 11, 4),
(NULL, '2025-09-24 08:38:00', 480.00, 49, 27, 2),
('Deliver to the security desk.', '2025-09-22 12:45:00', 330.00, 2, 15, 4),
('No sugar in the juice.', '2025-09-21 10:30:00', 180.00, 27, 25, 6),
('Restaurant did not accept the order.', '2025-09-23 13:00:00', 910.00, 34, 9, 6),
(NULL, '2025-09-24 08:33:00', 580.00, 43, 22, 2),
('Extra mayo for the rolls.', '2025-09-20 18:45:00', 680.00, 5, 24, 4),
('Please include a fork.', '2025-09-22 19:00:00', 210.00, 13, 16, 4),
('Gift wrap the dessert box.', '2025-09-21 16:00:00', 450.00, 36, 21, 4),
(NULL, '2025-09-24 08:49:00', 610.00, 23, 13, 1),
('Crush the ginger in the tea.', '2025-09-24 06:30:00', 150.00, 47, 7, 4),
('Chop the vegetables finely.', '2025-09-23 11:00:00', 790.00, 9, 23, 4),
('Make the noodles extra saucy.', '2025-09-24 08:15:00', 380.00, 38, 12, 3),
(NULL, '2025-09-19 20:20:00', 1050.00, 1, 10, 4),
('Slightly burnt toast, please.', '2025-09-20 09:15:00', 220.00, 17, 28, 4),
('No ice in the drink.', '2025-09-23 15:00:00', 180.00, 26, 28, 4),
(NULL, '2025-09-22 21:05:00', 850.00, 32, 1, 4),
('Extra sambar for the idlis.', '2025-09-24 07:55:00', 160.00, 46, 16, 3),
('Use olive oil for cooking.', '2025-09-21 12:30:00', 550.00, 15, 25, 4),
(NULL, '2025-09-24 08:36:00', 470.00, 30, 18, 2),
('Incorrect address provided.', '2025-09-20 19:00:00', 630.00, 20, 17, 5),
('Add chili flakes on the side.', '2025-09-22 18:00:00', 920.00, 40, 11, 4),
(NULL, '2025-09-23 20:45:00', 530.00, 2, 8, 4),
('Make sure the box is sealed properly.', '2025-09-24 08:47:00', 710.00, 10, 30, 1),
('Send the hottest sauce you have.', '2025-09-19 21:30:00', 480.00, 45, 13, 4),
('No egg in the biryani please.', '2025-09-21 14:00:00', 440.00, 3, 6, 4),
('Two sets of chopsticks.', '2025-09-22 20:00:00', 1100.00, 24, 14, 4),
(NULL, '2025-09-24 08:41:00', 360.00, 1, 16, 2),
('The restaurant is closed.', '2025-09-23 23:30:00', 800.00, 28, 1, 6),
('Toast the bread well.', '2025-09-20 08:45:00', 320.00, 12, 4, 4),
(NULL, '2025-09-21 19:30:00', 750.00, 33, 2, 4),
('Please provide a GST invoice.', '2025-09-24 08:00:00', 1500.00, 42, 29, 3),
(NULL, '2025-09-22 13:20:00', 490.00, 8, 20, 4),
('Card declined.', '2025-09-24 02:00:00', 390.00, 19, 21, 5),
('Pack the gravy and rice separately.', '2025-09-23 12:50:00', 580.00, 37, 22, 4),
('Not too sweet.', '2025-09-20 16:30:00', 250.00, 48, 21, 4),
(NULL, '2025-09-24 08:48:30', 920.00, 7, 27, 1),
('A little extra salt.', '2025-09-22 19:15:00', 460.00, 21, 10, 4),
('Add fresh cream on top.', '2025-09-21 22:00:00', 370.00, 39, 1, 4),
('Cancel the order.', '2025-09-23 18:05:00', 680.00, 14, 3, 5),
('Send the warmest bread possible.', '2025-09-24 08:28:00', 150.00, 29, 17, 3),
(NULL, '2025-09-19 13:45:00', 1120.00, 4, 15, 4),
('No lettuce in the sandwich.', '2025-09-22 11:30:00', 410.00, 18, 28, 4),
('Make it Jain style.', '2025-09-21 20:00:00', 590.00, 25, 9, 4),
('Liquid diet only, send soups.', '2025-09-24 08:44:00', 380.00, 35, 12, 1),
('No fish sauce in the noodles.', '2025-09-23 19:00:00', 720.00, 41, 12, 4),
(NULL, '2025-09-20 20:10:00', 880.00, 11, 24, 4),
('Please check for freshness.', '2025-09-22 08:00:00', 300.00, 31, 25, 4),
('No MSG please.', '2025-09-24 08:32:00', 450.00, 49, 12, 2),
(NULL, '2025-09-21 12:00:00', 1300.00, 16, 30, 4),
('The delivery agent is too far.', '2025-09-22 22:30:00', 500.00, 6, 26, 6),
('Extra spicy chicken wings.', '2025-09-23 21:30:00', 650.00, 23, 13, 4),
(NULL, '2025-09-24 08:43:00', 810.00, 44, 29, 1),
('Less cheese, more vegetables.', '2025-09-19 19:40:00', 470.00, 30, 11, 4),
('Need it urgently.', '2025-09-24 08:05:00', 390.00, 9, 19, 3),
('Pack for a long journey.', '2025-09-21 07:00:00', 1100.00, 50, 4, 4),
('Restaurant not responding.', '2025-09-20 21:00:00', 740.00, 2, 7, 6),
(NULL, '2025-09-22 14:00:00', 940.00, 17, 6, 4),
('Allergic to peanuts.', '2025-09-23 18:20:00', 540.00, 34, 10, 4),
('No tomatoes in the salad.', '2025-09-24 08:39:00', 310.00, 7, 25, 2),
(NULL, '2025-09-18 19:00:00', 860.00, 43, 22, 4),
('Add extra butter to everything.', '2025-09-21 20:30:00', 1020.00, 27, 8, 4),
('Please include tissues and mouth freshener.', '2025-09-22 19:45:00', 660.00, 13, 27, 4),
('Requesting a quick delivery.', '2025-09-24 08:47:30', 480.00, 5, 1, 1),
(NULL, '2025-09-23 20:15:00', 920.00, 38, 5, 4),
('Very little sugar in the coffee.', '2025-09-24 06:45:00', 180.00, 22, 16, 4),
('No bell peppers.', '2025-09-22 12:30:00', 530.00, 45, 11, 4),
(NULL, '2025-09-24 08:22:00', 720.00, 1, 12, 3),
('The restaurant is out of stock of this item.', '2025-09-23 13:30:00', 450.00, 19, 14, 6),
('Pack the food in a cardboard box, not plastic.', '2025-09-21 19:10:00', 1350.00, 28, 2, 4),
('Make the soup thick.', '2025-09-24 08:37:00', 220.00, 36, 12, 2),
(NULL, '2025-09-20 20:25:00', 890.00, 3, 29, 4),
('Duplicate order, please cancel.', '2025-09-22 18:10:00', 600.00, 11, 30, 5),
('Extra oregano sachets.', '2025-09-23 19:50:00', 500.00, 29, 11, 4),
(NULL, '2025-09-24 08:49:50', 340.00, 12, 19, 1),
('Use less turmeric.', '2025-09-21 11:45:00', 420.00, 24, 8, 4),
('No green chillies.', '2025-09-22 20:40:00', 770.00, 47, 20, 4),
('Please deliver to the 5th floor.', '2025-09-24 08:18:00', 560.00, 17, 23, 3),
(NULL, '2025-09-23 12:00:00', 1050.00, 32, 27, 4),
('The item is unavailable.', '2025-09-19 21:15:00', 950.00, 43, 18, 6),
('Blend the juice well, no chunks.', '2025-09-20 09:45:00', 240.00, 20, 25, 4),
('Add extra wasabi.', '2025-09-21 21:45:00', 1500.00, 8, 14, 4),
(NULL, '2025-09-24 08:45:30', 680.00, 37, 26, 1),
('Well done steak please.', '2025-09-22 19:35:00', 850.00, 10, 28, 4),
('Garnish with cilantro.', '2025-09-23 18:55:00', 430.00, 26, 13, 4),
(NULL, '2025-09-24 08:34:00', 390.00, 4, 9, 2),
('No salt.', '2025-09-20 13:15:00', 310.00, 15, 25, 4),
('Payment issue.', '2025-09-21 19:25:00', 790.00, 40, 24, 5),
('Extra chutney with the dosa.', '2025-09-24 08:08:00', 210.00, 33, 16, 3),
('Send fresh curd.', '2025-09-22 10:00:00', 100.00, 21, 7, 4),
(NULL, '2025-09-23 20:55:00', 990.00, 49, 15, 4),
('Don''t make it greasy.', '2025-09-21 18:30:00', 640.00, 14, 3, 4),
('Keep the rolls crispy.', '2025-09-24 08:46:30', 440.00, 2, 24, 1),
(NULL, '2025-09-20 19:05:00', 1230.00, 39, 6, 4),
('Make it with brown rice.', '2025-09-22 13:05:00', 370.00, 1, 25, 4),
('Please add a candle for a birthday cake.', '2025-09-23 17:00:00', 800.00, 25, 21, 4),
(NULL, '2025-09-24 08:24:00', 510.00, 50, 20, 3),
('Technical glitch in the app.', '2025-09-19 22:00:00', 700.00, 27, 28, 5),
('Serve the ice cream in a cup, not cone.', '2025-09-21 21:00:00', 250.00, 7, 14, 4),
('Extra napkins and plates.', '2025-09-22 18:40:00', 1600.00, 18, 29, 4),
('The delivery location is outside service area.', '2025-09-20 14:00:00', 480.00, 44, 10, 6),
('No onion, no garlic.', '2025-09-23 12:40:00', 820.00, 34, 9, 4),
(NULL, '2025-09-24 08:49:15', 550.00, 9, 18, 1),
('Less fenugreek in thepla.', '2025-09-21 08:30:00', 120.00, 16, 9, 4),
(NULL, '2025-09-22 21:20:00', 960.00, 42, 27, 4),
('Make sure the vada is crispy.', '2025-09-24 07:30:00', 140.00, 3, 16, 4),
('Cancel order, wrong items selected.', '2025-09-23 19:05:00', 850.00, 22, 1, 5),
('The food was cold.', '2025-09-19 20:00:00', 670.00, 30, 17, 4),
('Thin crust pizza please.', '2025-09-22 20:20:00', 900.00, 5, 11, 4),
(NULL, '2025-09-24 08:12:00', 480.00, 38, 22, 3),
('Grind the chutney coarsely.', '2025-09-21 10:00:00', 280.00, 13, 17, 4),
('More sauce on the pasta.', '2025-09-23 20:35:00', 580.00, 20, 11, 4),
(NULL, '2025-09-24 08:31:00', 650.00, 41, 30, 2),
('No cabbage in the noodles.', '2025-09-22 19:25:00', 320.00, 19, 12, 4),
('The restaurant is too busy.', '2025-09-21 20:45:00', 1150.00, 48, 29, 6),
('Add more veggies to the pulao.', '2025-09-23 13:40:00', 250.00, 23, 4, 4),
('The delivery was very late.', '2025-09-18 21:00:00', 730.00, 31, 23, 4),
(NULL, '2025-09-24 08:48:45', 490.00, 15, 5, 1),
('Please use fresh oil.', '2025-09-20 18:50:00', 560.00, 2, 7, 4),
('One item was missing from the order.', '2025-09-22 21:50:00', 980.00, 40, 15, 4),
(NULL, '2025-09-24 08:26:00', 880.00, 11, 2, 3),
('The packaging was damaged.', '2025-09-21 14:30:00', 620.00, 35, 13, 4),
('Add extra raita with biryani.', '2025-09-23 19:15:00', 520.00, 29, 15, 4),
(NULL, '2025-09-24 08:38:30', 750.00, 17, 24, 2),
('The app crashed during payment.', '2025-09-22 19:55:00', 1050.00, 6, 27, 5),
('No whipped cream on the shake.', '2025-09-20 15:00:00', 280.00, 36, 28, 4),
('The order was delivered to the wrong address.', '2025-09-23 20:05:00', 470.00, 46, 19, 4),
('Slightly undercooked pasta, al dente.', '2025-09-22 20:50:00', 540.00, 1, 11, 4),
(NULL, '2025-09-24 08:47:50', 360.00, 24, 26, 1),
('The delivery agent was rude.', '2025-09-19 19:10:00', 840.00, 8, 20, 4),
('The food tasted stale.', '2025-09-20 21:45:00', 510.00, 26, 10, 4),
(NULL, '2025-09-21 13:00:00', 1180.00, 34, 6, 4),
('The portion size was too small.', '2025-09-23 21:25:00', 790.00, 42, 18, 4),
('The discount coupon did not work.', '2025-09-24 08:02:00', 930.00, 13, 30, 5),
(NULL, '2025-09-22 18:25:00', 690.00, 27, 2, 4),
('The drink spilled inside the bag.', '2025-09-20 12:00:00', 430.00, 39, 4, 4),
(NULL, '2025-09-23 18:35:00', 1080.00, 50, 8, 4),
('Wrong order was delivered.', '2025-09-21 20:15:00', 870.00, 7, 23, 4),
('The restaurant called and cancelled.', '2025-09-22 19:40:00', 520.00, 44, 21, 6),
('The food was too oily.', '2025-09-19 20:30:00', 760.00, 18, 22, 4),
('The delivery took over an hour.', '2025-09-23 22:15:00', 610.00, 3, 1, 4),
(NULL, '2025-09-24 08:40:30', 460.00, 22, 16, 2),
('The food was excellent.', '2025-09-21 19:50:00', 1400.00, 33, 29, 4),
('The rider could not find the location.', '2025-09-22 21:10:00', 570.00, 12, 17, 5),
(NULL, '2025-09-23 14:30:00', 880.00, 47, 7, 4),
('The food quality has gone down.', '2025-09-20 20:55:00', 940.00, 28, 3, 4),
(NULL, '2025-09-24 08:29:00', 780.00, 5, 27, 3),
('The prices have increased.', '2025-09-21 18:50:00', 500.00, 15, 30, 4),
('The app showed delivered but I never received it.', '2025-09-22 20:30:00', 650.00, 37, 26, 4),
('The delivery person was very professional.', '2025-09-23 20:25:00', 1150.00, 49, 10, 4),
(NULL, '2025-09-24 08:49:40', 290.00, 10, 4, 1),
('Will order again.', '2025-09-21 21:35:00', 790.00, 24, 14, 4),
('The soup was watery.', '2025-09-22 19:05:00', 210.00, 4, 12, 4),
('Perfectly cooked.', '2025-09-23 19:35:00', 960.00, 14, 24, 4),
(NULL, '2025-09-20 19:45:00', 1030.00, 30, 6, 4),
('The salad was not fresh.', '2025-09-22 12:00:00', 350.00, 9, 25, 4),
('The best biryani in town!', '2025-09-23 13:50:00', 550.00, 43, 29, 4),
('Too much food coloring was used.', '2025-09-21 19:55:00', 830.00, 19, 1, 4),
(NULL, '2025-09-24 08:35:30', 770.00, 39, 17, 2),
('The restaurant is permanently closed.', '2025-09-22 18:55:00', 680.00, 16, 19, 6),
('The food was authentic.', '2025-09-23 20:40:00', 1250.00, 31, 8, 4),
('Great value for money.', '2025-09-20 21:20:00', 710.00, 41, 20, 4),
(NULL, '2025-09-24 08:50:15', 590.00, 21, 10, 1);
-- =======================================================================================
-- SECTION 8: ORDER ITEMS (Complete for 200 Orders)
-- NOTE: The price here is the price of the item at the time of order.
-- =======================================================================================
INSERT INTO Order_Item (quantity, price, menu_item_id, order_Id) VALUES
-- Order 1 (RestID: 1) -> Total: 410.00
(1, 350.00, 1, 1), (1, 60.00, 4, 1),
-- Order 2 (RestID: 2) -> Total: 670.00
(1, 420.00, 12, 2), (1, 250.00, 13, 2),
-- Order 3 (RestID: 3) -> Total: 280.00
(1, 280.00, 21, 3),
-- Order 4 (RestID: 4) -> Total: 180.00
(1, 180.00, 32, 4),
-- Order 5 (RestID: 5) -> Total: 700.00
(1, 450.00, 41, 5), (1, 250.00, 43, 5),
-- Order 6 (RestID: 10) -> Total: 560.00
(1, 480.00, 91, 6), (1, 80.00, 95, 6),
-- Order 7 (RestID: 15) -> Total: 600.00
(1, 520.00, 142, 7), (1, 80.00, 150, 7),
-- Order 8 (RestID: 20) -> Total: 380.00
(1, 380.00, 197, 8),
-- Order 9 (RestID: 25) -> Total: 450.00
(1, 450.00, 241, 9),
-- Order 10 (RestID: 30) -> Total: 820.00
(1, 470.00, 291, 10), (1, 350.00, 296, 10),
-- Order 11 (RestID: 1) -> Total: 350.00
(1, 350.00, 1, 11),
-- Order 12 (RestID: 2) -> Total: 400.00
(1, 400.00, 11, 12),
-- Order 13 (RestID: 3) -> Total: 320.00
(1, 320.00, 28, 13),
-- Order 14 (RestID: 4) -> Total: 220.00
(1, 220.00, 37, 14),
-- Order 15 (RestID: 18) -> Total: 520.00
(1, 520.00, 172, 15),
-- Order 16 (RestID: 22) -> Total: 620.00
(1, 480.00, 216, 16), (1, 140.00, 218, 16),
-- Order 17 (RestID: 7) -> Total: 460.00
(1, 450.00, 66, 17), (2, 5.00, 70, 17),
-- Order 18 (RestID: 11) -> Total: 980.00
(1, 550.00, 104, 18), (1, 430.00, 106, 18),
-- Order 19 (RestID: 16) -> Total: 320.00
(1, 180.00, 151, 19), (1, 140.00, 155, 19),
-- Order 20 (RestID: 29) -> Total: 1150.00
(1, 550.00, 282, 20), (1, 400.00, 286, 20), (2, 100.00, 289, 20),
-- Order 21 (RestID: 5) -> Total: 630.00
(1, 350.00, 49, 21), (1, 280.00, 46, 21),
-- Order 22 (RestID: 19) -> Total: 220.00
(1, 180.00, 181, 22), (1, 40.00, 188, 22),
-- Order 23 (RestID: 13) -> Total: 880.00
(1, 450.00, 125, 23), (1, 430.00, 129, 23),
-- Order 24 (RestID: 8) -> Total: 510.00
(1, 350.00, 74, 24), (2, 80.00, 77, 24),
-- Order 25 (RestID: 25) -> Total: 730.00
(1, 450.00, 241, 25), (1, 280.00, 250, 25),
-- Order 26 (RestID: 2) -> Total: 490.00
(1, 400.00, 11, 26), (2, 45.00, 19, 26),
-- Order 27 (RestID: 14) -> Total: 850.00
(1, 550.00, 131, 27), (1, 300.00, 140, 27),
-- Order 28 (RestID: 28) -> Total: 980.00
(1, 580.00, 277, 28), (1, 400.00, 276, 28),
-- Order 29 (RestID: 23) -> Total: 650.00
(1, 580.00, 223, 29), (1, 70.00, 229, 29),
-- Order 30 (RestID: 17) -> Total: 890.00
(1, 580.00, 162, 30), (1, 310.00, 170, 30),
-- Order 31 (RestID: 11) -> Total: 1250.00
(1, 550.00, 104, 31), (1, 450.00, 101, 31), (1, 250.00, 105, 31),
-- Order 32 (RestID: 26) -> Total: 430.00
(1, 250.00, 253, 32), (1, 180.00, 260, 32),
-- Order 33 (RestID: 25) -> Total: 290.00
(1, 290.00, 245, 33),
-- Order 34 (RestID: 25) -> Total: 350.00
(1, 350.00, 242, 34),
-- Order 35 (RestID: 12) -> Total: 760.00
(1, 450.00, 115, 35), (1, 310.00, 111, 35),
-- Order 36 (RestID: 6) -> Total: 1450.00
(2, 550.00, 52, 36), (1, 350.00, 56, 36),
-- Order 37 (RestID: 20) -> Total: 560.00
(1, 560.00, 191, 37),
-- Order 38 (RestID: 11) -> Total: 780.00
(1, 580.00, 109, 38), (1, 200.00, 110, 38),
-- Order 39 (RestID: 27) -> Total: 480.00
(1, 480.00, 267, 39),
-- Order 40 (RestID: 15) -> Total: 330.00
(1, 330.00, 148, 40),
-- Order 41 (RestID: 25) -> Total: 180.00
(1, 180.00, 250, 41),
-- Order 42 (RestID: 9) -> Total: 910.00
(1, 500.00, 81, 42), (1, 350.00, 84, 42), (2, 30.00, 85, 42),
-- Order 43 (RestID: 22) -> Total: 580.00
(1, 450.00, 219, 43), (1, 130.00, 212, 43),
-- Order 44 (RestID: 4) -> Total: 680.00
(2, 180.00, 32, 44), (2, 120.00, 38, 44), (2, 40.00, 31, 44),
-- Order 45 (RestID: 16) -> Total: 210.00
(1, 210.00, 156, 45),
-- Order 46 (RestID: 21) -> Total: 450.00
(2, 100.00, 202, 46), (1, 100.00, 205, 46), (1, 150.00, 206, 46),
-- Order 47 (RestID: 13) -> Total: 610.00
(1, 380.00, 122, 47), (1, 230.00, 126, 47),
-- Order 48 (RestID: 7) -> Total: 150.00
(1, 150.00, 63, 48),
-- Order 49 (RestID: 23) -> Total: 790.00
(1, 400.00, 221, 49), (1, 320.00, 224, 49), (1, 70.00, 230, 49),
-- Order 50 (RestID: 12) -> Total: 380.00
(1, 200.00, 119, 50), (1, 180.00, 117, 50),
-- Programmatically generated data continued
(2, 480.00, 6, 51), (1, 300.00, 3, 51),
(1, 220.00, 276, 52),
(1, 250.00, 39, 53), (1, 180.00, 32, 53),
(2, 450.00, 2, 54),
(1, 120.00, 159, 55), (1, 140.00, 155, 55),
(1, 550.00, 104, 56),
(1, 450.00, 174, 57),
(1, 580.00, 191, 58), (1, 50.00, 199, 58),
(1, 450.00, 101, 59), (1, 520.00, 102, 59),
(1, 480.00, 72, 60), (1, 60.00, 75, 60),
(1, 470.00, 291, 61), (1, 250.00, 299, 61),
(1, 350.00, 121, 62), (1, 150.00, 130, 62),
(1, 420.00, 59, 63),
(2, 550.00, 134, 64), (1, 200.00, 137, 64),
(1, 180.00, 151, 65), (1, 120.00, 154, 65),
(1, 80.00, 201, 66), (1, 100.00, 202, 66),
(1, 120.00, 38, 67), (1, 180.00, 32, 67),
(1, 550.00, 9, 68), (1, 180.00, 8, 68),
(1, 480.00, 281, 69), (1, 520.00, 287, 69), (1, 500.00, 288, 69),
(1, 320.00, 194, 70), (1, 160.00, 199, 70),
(1, 390.00, 192, 71),
(1, 460.00, 215, 72), (1, 120.00, 218, 72),
(1, 100.00, 208, 73), (1, 150.00, 206, 73),
(1, 470.00, 291, 74), (1, 420.00, 295, 74),
(1, 320.00, 73, 75), (1, 150.00, 229, 75),
(1, 550.00, 9, 76), (1, 120.00, 10, 76),
(1, 680.00, 171, 77),
(1, 150.00, 218, 78),
(1, 520.00, 142, 79), (1, 500.00, 146, 79), (1, 80.00, 150, 79),
(1, 410.00, 276, 80),
(1, 380.00, 97, 81), (1, 220.00, 98, 81),
(1, 380.00, 243, 82),
(1, 520.00, 102, 83), (1, 220.00, 108, 83),
(1, 480.00, 231, 84), (1, 460.00, 232, 84),
(1, 300.00, 248, 85),
(1, 340.00, 113, 86), (1, 180.00, 117, 86),
(1, 520.00, 282, 87), (1, 500.00, 288, 87), (1, 200.00, 289, 87),
(1, 500.00, 134, 88),
(1, 420.00, 129, 89), (1, 250.00, 128, 89),
(1, 450.00, 281, 90), (1, 360.00, 284, 90),
(1, 470.00, 101, 91),
(1, 180.00, 181, 92), (1, 220.00, 182, 92),
(1, 500.00, 42, 93), (1, 450.00, 41, 93),
(1, 740.00, 52, 94),
(1, 440.00, 59, 95), (1, 500.00, 56, 95),
(1, 540.00, 165, 96),
(1, 310.00, 248, 97),
(1, 480.00, 216, 98), (1, 140.00, 218, 98), (1, 240.00, 219, 98),
(1, 560.00, 76, 99), (1, 450.00, 71, 99),
(1, 660.00, 261, 100),
(1, 480.00, 6, 101),
(1, 500.00, 42, 102), (1, 450.00, 41, 102),
(1, 180.00, 151, 103),
(1, 450.00, 101, 104), (1, 80.00, 105, 104),
(1, 450.00, 115, 105), (1, 280.00, 111, 105),
(1, 450.00, 131, 106),
(1, 550.00, 9, 107), (1, 500.00, 6, 107), (1, 300.00, 3, 107),
(1, 220.00, 112, 108),
(1, 450.00, 281, 109), (1, 440.00, 284, 109),
(1, 600.00, 180, 110),
(1, 500.00, 109, 111),
(1, 340.00, 181, 112),
(1, 420.00, 74, 113),
(1, 770.00, 162, 114),
(1, 560.00, 223, 115),
(1, 550.00, 262, 116), (1, 500.00, 268, 116),
(1, 950.00, 171, 117),
(1, 240.00, 193, 118),
(1, 750.00, 139, 119), (1, 750.00, 138, 119),
(1, 400.00, 286, 120), (1, 280.00, 284, 120),
(1, 580.00, 277, 121), (1, 280.00, 280, 121),
(1, 430.00, 161, 122),
(1, 390.00, 81, 123),
(1, 310.00, 245, 124),
(1, 790.00, 231, 125),
(1, 210.00, 151, 126),
(1, 100.00, 63, 127),
(1, 990.00, 142, 128),
(1, 640.00, 21, 129),
(1, 440.00, 291, 130),
(1, 550.00, 52, 131), (1, 500.00, 56, 131), (1, 180.00, 58, 131),
(1, 370.00, 241, 132),
(1, 800.00, 201, 133),
(1, 510.00, 191, 134),
(1, 700.00, 261, 135),
(1, 750.00, 139, 136),
(1, 800.00, 281, 137), (1, 800.00, 282, 137),
(1, 480.00, 91, 138),
(1, 820.00, 81, 139),
(1, 550.00, 171, 140),
(1, 120.00, 82, 141),
(1, 960.00, 261, 142),
(1, 140.00, 155, 143),
(1, 850.00, 1, 144),
(1, 670.00, 161, 145),
(1, 900.00, 101, 146),
(1, 480.00, 216, 147),
(1, 280.00, 73, 148),
(1, 580.00, 109, 149),
(1, 650.00, 291, 150),
(1, 320.00, 111, 151),
(1, 1150.00, 282, 152),
(1, 250.00, 32, 153),
(1, 730.00, 221, 154),
(1, 490.00, 41, 155),
(1, 560.00, 61, 156),
(1, 980.00, 142, 157),
(1, 880.00, 11, 158),
(1, 620.00, 125, 159),
(1, 520.00, 142, 160),
(1, 750.00, 231, 161),
(1, 1050.00, 261, 162),
(1, 280.00, 276, 163),
(1, 470.00, 181, 164),
(1, 540.00, 104, 165),
(1, 360.00, 251, 166),
(1, 840.00, 191, 167),
(1, 510.00, 91, 168),
(1, 1180.00, 52, 169),
(1, 790.00, 171, 170),
(1, 930.00, 291, 171),
(1, 690.00, 11, 172),
(1, 430.00, 32, 173),
(1, 1080.00, 71, 174),
(1, 870.00, 221, 175),
(1, 520.00, 201, 176),
(1, 760.00, 215, 177),
(1, 610.00, 1, 178),
(1, 460.00, 151, 179),
(1, 1400.00, 282, 180),
(1, 570.00, 161, 181),
(1, 880.00, 61, 182),
(1, 940.00, 21, 183),
(1, 780.00, 261, 184),
(1, 500.00, 291, 185),
(1, 650.00, 251, 186),
(1, 1150.00, 91, 187),
(1, 290.00, 32, 188),
(1, 790.00, 131, 189),
(1, 210.00, 117, 190),
(1, 960.00, 231, 191),
(1, 1030.00, 52, 192),
(1, 350.00, 241, 193),
(1, 550.00, 282, 194),
(1, 830.00, 1, 195),
(1, 770.00, 161, 196),
(1, 680.00, 181, 197),
(1, 1250.00, 71, 198),
(1, 710.00, 191, 199),
(1, 590.00, 91, 200);

-- =======================================================================================
-- SECTION 9: PAYMENTS (Complete for 200 Orders)
-- NOTE: The Amount here is the actual calculated total from the OrderItems to ensure data consistency.
-- =======================================================================================

INSERT INTO Payment (Method, Amount, TransactionID, Timestamp, payment_type, payment_status, OrderID) VALUES
('Credit Card', 410.00, 'txn_cc_001', '2025-09-23 19:30:05', 'ONLINE', 'SUCCESS', 1),
('UPI', 670.00, 'txn_upi_002', '2025-09-24 07:05:10', 'ONLINE', 'SUCCESS', 2),
('Net Banking', 280.00, 'txn_nb_003', '2025-09-24 08:30:08', 'ONLINE', 'SUCCESS', 3),
('Credit Card', 180.00, 'txn_cc_004', '2025-09-22 20:00:15', 'ONLINE', 'FAILED', 4),
('Cash on Delivery', 700.00, NULL, '2025-09-24 08:45:10', 'COD', 'PENDING', 5),
('Wallet', 560.00, 'txn_wal_006', '2025-09-23 14:00:20', 'ONLINE', 'SUCCESS', 6),
('UPI', 600.00, 'txn_upi_007', '2025-09-23 18:45:07', 'ONLINE', 'SUCCESS', 7),
('Cash on Delivery', 380.00, NULL, '2025-09-24 08:10:15', 'COD', 'PENDING', 8),
('Credit Card', 450.00, 'txn_cc_009', '2025-09-24 08:35:05', 'ONLINE', 'SUCCESS', 9),
('Net Banking', 820.00, 'txn_nb_010', '2025-09-21 19:00:12', 'ONLINE', 'SUCCESS', 10),
('UPI', 350.00, 'txn_upi_011', '2025-09-24 08:48:05', 'ONLINE', 'SUCCESS', 11),
('Cash on Delivery', 400.00, NULL, '2025-09-24 08:20:00', 'COD', 'PENDING', 12),
('Wallet', 320.00, 'txn_wal_013', '2025-09-23 21:00:18', 'ONLINE', 'SUCCESS', 13),
('Credit Card', 220.00, 'txn_cc_014', '2025-09-20 12:31:05', 'ONLINE', 'SUCCESS', 14),
('UPI', 520.00, 'txn_upi_015', '2025-09-24 08:49:30', 'ONLINE', 'SUCCESS', 15),
('Credit Card', 620.00, 'txn_cc_016', '2025-09-22 13:10:25', 'ONLINE', 'SUCCESS', 16),
('UPI', 460.00, 'txn_upi_017', '2025-09-23 19:45:16', 'ONLINE', 'SUCCESS', 17),
('Net Banking', 980.00, 'txn_nb_018', '2025-09-21 20:05:38', 'ONLINE', 'SUCCESS', 18),
('Wallet', 320.00, 'txn_wal_019', '2025-09-24 08:40:05', 'ONLINE', 'SUCCESS', 19),
('UPI', 1150.00, 'txn_upi_020', '2025-09-22 18:30:05', 'ONLINE', 'SUCCESS', 20),
('Credit Card', 630.00, 'txn_cc_021', '2025-09-23 12:15:50', 'ONLINE', 'SUCCESS', 21),
('Cash on Delivery', 220.00, NULL, '2025-09-24 08:25:18', 'COD', 'PENDING', 22),
('UPI', 880.00, 'txn_upi_023', '2025-09-20 11:40:05', 'ONLINE', 'SUCCESS', 23),
('Wallet', 510.00, 'txn_wal_024', '2025-09-24 08:46:00', 'ONLINE', 'SUCCESS', 24),
('Credit Card', 730.00, 'txn_cc_025', '2025-09-19 19:55:05', 'ONLINE', 'SUCCESS', 25),
('Net Banking', 490.00, 'txn_nb_026', '2025-09-22 20:30:15', 'ONLINE', 'SUCCESS', 26),
('UPI', 850.00, 'txn_upi_027', '2025-09-23 22:00:05', 'ONLINE', 'SUCCESS', 27),
('Credit Card', 800.00, 'txn_cc_028', '2025-09-18 13:00:05', 'ONLINE', 'SUCCESS', 28),
('UPI', 650.00, 'txn_upi_029', '2025-09-24 01:15:05', 'ONLINE', 'FAILED', 29),
('Wallet', 890.00, 'txn_wal_030', '2025-09-24 08:42:05', 'ONLINE', 'SUCCESS', 30),
('Credit Card', 1250.00, 'txn_cc_031', '2025-09-21 21:10:05', 'ONLINE', 'SUCCESS', 31),
('Net Banking', 430.00, 'txn_nb_032', '2025-09-23 17:50:05', 'ONLINE', 'SUCCESS', 32),
('Cash on Delivery', 290.00, NULL, '2025-09-24 07:45:00', 'COD', 'PENDING', 33),
('Credit Card', 350.00, 'txn_cc_034', '2025-09-22 09:00:05', 'ONLINE', 'SUCCESS', 34),
('UPI', 760.00, 'txn_upi_035', '2025-09-24 08:50:00', 'ONLINE', 'SUCCESS', 35),
('Wallet', 1450.00, 'txn_wal_036', '2025-09-20 19:20:05', 'ONLINE', 'SUCCESS', 36),
('Credit Card', 560.00, 'txn_cc_037', '2025-09-19 18:00:05', 'ONLINE', 'FAILED', 37),
('UPI', 780.00, 'txn_upi_038', '2025-09-23 20:10:05', 'ONLINE', 'SUCCESS', 38),
('Net Banking', 480.00, 'txn_nb_039', '2025-09-24 08:38:05', 'ONLINE', 'SUCCESS', 39),
('Credit Card', 330.00, 'txn_cc_040', '2025-09-22 12:45:05', 'ONLINE', 'SUCCESS', 40),
('UPI', 180.00, 'txn_upi_041', '2025-09-21 10:30:05', 'ONLINE', 'SUCCESS', 41),
('Wallet', 910.00, 'txn_wal_042', '2025-09-23 13:00:05', 'ONLINE', 'SUCCESS', 42),
('Credit Card', 580.00, 'txn_cc_043', '2025-09-24 08:33:05', 'ONLINE', 'SUCCESS', 43),
('UPI', 680.00, 'txn_upi_044', '2025-09-20 18:45:05', 'ONLINE', 'SUCCESS', 44),
('Net Banking', 210.00, 'txn_nb_045', '2025-09-22 19:00:05', 'ONLINE', 'SUCCESS', 45),
('Credit Card', 450.00, 'txn_cc_046', '2025-09-21 16:00:05', 'ONLINE', 'SUCCESS', 46),
('Wallet', 610.00, 'txn_wal_047', '2025-09-24 08:49:00', 'ONLINE', 'SUCCESS', 47),
('UPI', 150.00, 'txn_upi_048', '2025-09-24 06:30:05', 'ONLINE', 'SUCCESS', 48),
('Credit Card', 790.00, 'txn_cc_049', '2025-09-23 11:00:05', 'ONLINE', 'SUCCESS', 49),
('Cash on Delivery', 380.00, NULL, '2025-09-24 08:15:00', 'COD', 'PENDING', 50),
('UPI', 1260.00, 'txn_upi_051', '2025-09-19 20:20:05', 'ONLINE', 'SUCCESS', 51),
('Net Banking', 220.00, 'txn_nb_052', '2025-09-20 09:15:05', 'ONLINE', 'SUCCESS', 52),
('Credit Card', 180.00, 'txn_cc_053', '2025-09-23 15:00:05', 'ONLINE', 'SUCCESS', 53),
('Wallet', 800.00, 'txn_wal_054', '2025-09-22 21:05:05', 'ONLINE', 'SUCCESS', 54),
('Cash on Delivery', 260.00, NULL, '2025-09-24 07:55:00', 'COD', 'PENDING', 55),
('UPI', 550.00, 'txn_upi_056', '2025-09-21 12:30:05', 'ONLINE', 'SUCCESS', 56),
('Credit Card', 470.00, 'txn_cc_057', '2025-09-24 08:36:05', 'ONLINE', 'SUCCESS', 57),
('Net Banking', 630.00, 'txn_nb_058', '2025-09-20 19:00:05', 'ONLINE', 'FAILED', 58),
('UPI', 970.00, 'txn_upi_059', '2025-09-22 18:00:05', 'ONLINE', 'SUCCESS', 59),
('Credit Card', 590.00, 'txn_cc_060', '2025-09-23 20:45:05', 'ONLINE', 'SUCCESS', 60),
('Wallet', 710.00, 'txn_wal_061', '2025-09-24 08:47:00', 'ONLINE', 'SUCCESS', 61),
('UPI', 500.00, 'txn_upi_062', '2025-09-19 21:30:05', 'ONLINE', 'SUCCESS', 62),
('Net Banking', 440.00, 'txn_nb_063', '2025-09-21 14:00:05', 'ONLINE', 'SUCCESS', 63),
('Credit Card', 1300.00, 'txn_cc_064', '2025-09-22 20:00:05', 'ONLINE', 'SUCCESS', 64),
('UPI', 300.00, 'txn_upi_065', '2025-09-24 08:41:05', 'ONLINE', 'SUCCESS', 65),
('Wallet', 80.00, 'txn_wal_066', '2025-09-23 23:30:05', 'ONLINE', 'SUCCESS', 66),
('Credit Card', 320.00, 'txn_cc_067', '2025-09-20 08:45:05', 'ONLINE', 'SUCCESS', 67),
('UPI', 730.00, 'txn_upi_068', '2025-09-21 19:30:05', 'ONLINE', 'SUCCESS', 68),
('Cash on Delivery', 1500.00, NULL, '2025-09-24 08:00:00', 'COD', 'PENDING', 69),
('Net Banking', 480.00, 'txn_nb_070', '2025-09-22 13:20:05', 'ONLINE', 'SUCCESS', 70),
('Credit Card', 390.00, 'txn_cc_071', '2025-09-24 02:00:05', 'ONLINE', 'FAILED', 71),
('UPI', 580.00, 'txn_upi_072', '2025-09-23 12:50:05', 'ONLINE', 'SUCCESS', 72),
('Wallet', 250.00, 'txn_wal_073', '2025-09-20 16:30:05', 'ONLINE', 'SUCCESS', 73),
('UPI', 920.00, 'txn_upi_074', '2025-09-24 08:48:30', 'ONLINE', 'SUCCESS', 74),
('Credit Card', 470.00, 'txn_cc_075', '2025-09-22 19:15:05', 'ONLINE', 'SUCCESS', 75),
('Net Banking', 370.00, 'txn_nb_076', '2025-09-21 22:00:05', 'ONLINE', 'SUCCESS', 76),
('UPI', 680.00, 'txn_upi_077', '2025-09-23 18:05:05', 'ONLINE', 'FAILED', 77),
('Cash on Delivery', 150.00, NULL, '2025-09-24 08:28:00', 'COD', 'PENDING', 78),
('Credit Card', 1100.00, 'txn_cc_079', '2025-09-19 13:45:05', 'ONLINE', 'SUCCESS', 79),
('Wallet', 410.00, 'txn_wal_080', '2025-09-22 11:30:05', 'ONLINE', 'SUCCESS', 80),
('UPI', 600.00, 'txn_upi_081', '2025-09-21 20:00:05', 'ONLINE', 'SUCCESS', 81),
('Credit Card', 380.00, 'txn_cc_082', '2025-09-24 08:44:05', 'ONLINE', 'SUCCESS', 82),
('Net Banking', 720.00, 'txn_nb_083', '2025-09-23 19:00:05', 'ONLINE', 'SUCCESS', 83),
('UPI', 940.00, 'txn_upi_084', '2025-09-20 20:10:05', 'ONLINE', 'SUCCESS', 84),
('Credit Card', 300.00, 'txn_cc_085', '2025-09-22 08:00:05', 'ONLINE', 'SUCCESS', 85),
('Wallet', 450.00, 'txn_wal_086', '2025-09-24 08:32:05', 'ONLINE', 'SUCCESS', 86),
('UPI', 1320.00, 'txn_upi_087', '2025-09-21 12:00:05', 'ONLINE', 'SUCCESS', 87),
('Credit Card', 500.00, 'txn_cc_088', '2025-09-22 22:30:05', 'ONLINE', 'SUCCESS', 88),
('Net Banking', 670.00, 'txn_nb_089', '2025-09-23 21:30:05', 'ONLINE', 'SUCCESS', 89),
('UPI', 810.00, 'txn_upi_090', '2025-09-24 08:43:00', 'ONLINE', 'SUCCESS', 90),
('Credit Card', 470.00, 'txn_cc_091', '2025-09-19 19:40:05', 'ONLINE', 'SUCCESS', 91),
('Cash on Delivery', 400.00, NULL, '2025-09-24 08:05:00', 'COD', 'PENDING', 92),
('Wallet', 1100.00, 'txn_wal_093', '2025-09-21 07:00:05', 'ONLINE', 'SUCCESS', 93),
('UPI', 740.00, 'txn_upi_094', '2025-09-20 21:00:05', 'ONLINE', 'SUCCESS', 94),
('Credit Card', 940.00, 'txn_cc_095', '2025-09-22 14:00:05', 'ONLINE', 'SUCCESS', 95),
('Net Banking', 540.00, 'txn_nb_096', '2025-09-23 18:20:05', 'ONLINE', 'SUCCESS', 96),
('UPI', 310.00, 'txn_upi_097', '2025-09-24 08:39:05', 'ONLINE', 'SUCCESS', 97),
('Credit Card', 860.00, 'txn_cc_098', '2025-09-18 19:00:05', 'ONLINE', 'SUCCESS', 98),
('Wallet', 1020.00, 'txn_wal_099', '2025-09-21 20:30:05', 'ONLINE', 'SUCCESS', 99),
('UPI', 660.00, 'txn_upi_100', '2025-09-22 19:45:05', 'ONLINE', 'SUCCESS', 100),
('Credit Card', 1260.00, 'txn_cc_101', '2025-09-24 08:47:35', 'ONLINE', 'SUCCESS', 101),
('Net Banking', 950.00, 'txn_nb_102', '2025-09-23 20:15:05', 'ONLINE', 'SUCCESS', 102),
('UPI', 180.00, 'txn_upi_103', '2025-09-24 06:45:05', 'ONLINE', 'SUCCESS', 103),
('Wallet', 530.00, 'txn_wal_104', '2025-09-22 12:30:05', 'ONLINE', 'SUCCESS', 104),
('Cash on Delivery', 730.00, NULL, '2025-09-24 08:22:00', 'COD', 'PENDING', 105),
('Credit Card', 450.00, 'txn_cc_106', '2025-09-23 13:30:05', 'ONLINE', 'SUCCESS', 106),
('UPI', 1350.00, 'txn_upi_107', '2025-09-21 19:10:05', 'ONLINE', 'SUCCESS', 107),
('Net Banking', 220.00, 'txn_nb_108', '2025-09-24 08:37:05', 'ONLINE', 'SUCCESS', 108),
('Credit Card', 890.00, 'txn_cc_109', '2025-09-20 20:25:05', 'ONLINE', 'SUCCESS', 109),
('UPI', 600.00, 'txn_upi_110', '2025-09-22 18:10:05', 'ONLINE', 'FAILED', 110),
('Wallet', 500.00, 'txn_wal_111', '2025-09-23 19:50:05', 'ONLINE', 'SUCCESS', 111),
('UPI', 340.00, 'txn_upi_112', '2025-09-24 08:49:50', 'ONLINE', 'SUCCESS', 112),
('Credit Card', 420.00, 'txn_cc_113', '2025-09-21 11:45:05', 'ONLINE', 'SUCCESS', 113),
('Net Banking', 770.00, 'txn_nb_114', '2025-09-22 20:40:05', 'ONLINE', 'SUCCESS', 114),
('Cash on Delivery', 560.00, NULL, '2025-09-24 08:18:00', 'COD', 'PENDING', 115),
('UPI', 1050.00, 'txn_upi_116', '2025-09-23 12:00:05', 'ONLINE', 'SUCCESS', 116),
('Credit Card', 950.00, 'txn_cc_117', '2025-09-19 21:15:05', 'ONLINE', 'SUCCESS', 117),
('Wallet', 240.00, 'txn_wal_118', '2025-09-20 09:45:05', 'ONLINE', 'SUCCESS', 118),
('UPI', 1500.00, 'txn_upi_119', '2025-09-21 21:45:05', 'ONLINE', 'SUCCESS', 119),
('Net Banking', 680.00, 'txn_nb_120', '2025-09-24 08:45:30', 'ONLINE', 'SUCCESS', 120),
('Credit Card', 860.00, 'txn_cc_121', '2025-09-22 19:35:05', 'ONLINE', 'SUCCESS', 121),
('UPI', 430.00, 'txn_upi_122', '2025-09-23 18:55:05', 'ONLINE', 'SUCCESS', 122),
('Wallet', 390.00, 'txn_wal_123', '2025-09-24 08:34:05', 'ONLINE', 'SUCCESS', 123),
('Credit Card', 310.00, 'txn_cc_124', '2025-09-20 13:15:05', 'ONLINE', 'SUCCESS', 124),
('UPI', 790.00, 'txn_upi_125', '2025-09-21 19:25:05', 'ONLINE', 'FAILED', 125),
('Cash on Delivery', 210.00, NULL, '2025-09-24 08:08:00', 'COD', 'PENDING', 126),
('Net Banking', 100.00, 'txn_nb_127', '2025-09-22 10:00:05', 'ONLINE', 'SUCCESS', 127),
('UPI', 990.00, 'txn_upi_128', '2025-09-23 20:55:05', 'ONLINE', 'SUCCESS', 128),
('Credit Card', 640.00, 'txn_cc_129', '2025-09-21 18:30:05', 'ONLINE', 'SUCCESS', 129),
('Wallet', 440.00, 'txn_wal_130', '2025-09-24 08:46:30', 'ONLINE', 'SUCCESS', 130),
('UPI', 1230.00, 'txn_upi_131', '2025-09-20 19:05:05', 'ONLINE', 'SUCCESS', 131),
('Credit Card', 370.00, 'txn_cc_132', '2025-09-22 13:05:05', 'ONLINE', 'SUCCESS', 132),
('Net Banking', 800.00, 'txn_nb_133', '2025-09-23 17:00:05', 'ONLINE', 'SUCCESS', 133),
('Cash on Delivery', 510.00, NULL, '2025-09-24 08:24:00', 'COD', 'PENDING', 134),
('UPI', 700.00, 'txn_upi_135', '2025-09-19 22:00:05', 'ONLINE', 'FAILED', 135),
('Credit Card', 250.00, 'txn_cc_136', '2025-09-21 21:00:05', 'ONLINE', 'SUCCESS', 136),
('Wallet', 1600.00, 'txn_wal_137', '2025-09-22 18:40:05', 'ONLINE', 'SUCCESS', 137),
('UPI', 480.00, 'txn_upi_138', '2025-09-20 14:00:05', 'ONLINE', 'SUCCESS', 138),
('Credit Card', 820.00, 'txn_cc_139', '2025-09-23 12:40:05', 'ONLINE', 'SUCCESS', 139),
('Net Banking', 550.00, 'txn_nb_140', '2025-09-24 08:49:15', 'ONLINE', 'SUCCESS', 140),
('UPI', 120.00, 'txn_upi_141', '2025-09-21 08:30:05', 'ONLINE', 'SUCCESS', 141),
('Credit Card', 960.00, 'txn_cc_142', '2025-09-22 21:20:05', 'ONLINE', 'SUCCESS', 142),
('Wallet', 140.00, 'txn_wal_143', '2025-09-24 07:30:05', 'ONLINE', 'SUCCESS', 143),
('UPI', 850.00, 'txn_upi_144', '2025-09-23 19:05:05', 'ONLINE', 'FAILED', 144),
('Credit Card', 670.00, 'txn_cc_145', '2025-09-19 20:00:05', 'ONLINE', 'SUCCESS', 145),
('Net Banking', 900.00, 'txn_nb_146', '2025-09-22 20:20:05', 'ONLINE', 'SUCCESS', 146),
('Cash on Delivery', 480.00, NULL, '2025-09-24 08:12:00', 'COD', 'PENDING', 147),
('UPI', 280.00, 'txn_upi_148', '2025-09-21 10:00:05', 'ONLINE', 'SUCCESS', 148),
('Credit Card', 580.00, 'txn_cc_149', '2025-09-23 20:35:05', 'ONLINE', 'SUCCESS', 149),
('Wallet', 650.00, 'txn_wal_150', '2025-09-24 08:31:05', 'ONLINE', 'SUCCESS', 150),
('UPI', 320.00, 'txn_upi_151', '2025-09-22 19:25:05', 'ONLINE', 'SUCCESS', 151),
('Credit Card', 1150.00, 'txn_cc_152', '2025-09-21 20:45:05', 'ONLINE', 'SUCCESS', 152),
('Net Banking', 250.00, 'txn_nb_153', '2025-09-23 13:40:05', 'ONLINE', 'SUCCESS', 153),
('UPI', 730.00, 'txn_upi_154', '2025-09-18 21:00:05', 'ONLINE', 'SUCCESS', 154),
('Credit Card', 490.00, 'txn_cc_155', '2025-09-24 08:48:45', 'ONLINE', 'SUCCESS', 155),
('Wallet', 560.00, 'txn_wal_156', '2025-09-20 18:50:05', 'ONLINE', 'SUCCESS', 156),
('UPI', 980.00, 'txn_upi_157', '2025-09-22 21:50:05', 'ONLINE', 'SUCCESS', 157),
('Cash on Delivery', 880.00, NULL, '2025-09-24 08:26:00', 'COD', 'PENDING', 158),
('Credit Card', 620.00, 'txn_cc_159', '2025-09-21 14:30:05', 'ONLINE', 'SUCCESS', 159),
('Net Banking', 520.00, 'txn_nb_160', '2025-09-23 19:15:05', 'ONLINE', 'SUCCESS', 160),
('UPI', 750.00, 'txn_upi_161', '2025-09-24 08:38:30', 'ONLINE', 'SUCCESS', 161),
('Credit Card', 1050.00, 'txn_cc_162', '2025-09-22 19:55:05', 'ONLINE', 'FAILED', 162),
('Wallet', 280.00, 'txn_wal_163', '2025-09-20 15:00:05', 'ONLINE', 'SUCCESS', 163),
('UPI', 470.00, 'txn_upi_164', '2025-09-23 20:05:05', 'ONLINE', 'SUCCESS', 164),
('Credit Card', 540.00, 'txn_cc_165', '2025-09-22 20:50:05', 'ONLINE', 'SUCCESS', 165),
('Net Banking', 360.00, 'txn_nb_166', '2025-09-24 08:47:50', 'ONLINE', 'SUCCESS', 166),
('UPI', 840.00, 'txn_upi_167', '2025-09-19 19:10:05', 'ONLINE', 'SUCCESS', 167),
('Credit Card', 510.00, 'txn_cc_168', '2025-09-20 21:45:05', 'ONLINE', 'SUCCESS', 168),
('Wallet', 1180.00, 'txn_wal_169', '2025-09-21 13:00:05', 'ONLINE', 'SUCCESS', 169),
('UPI', 790.00, 'txn_upi_170', '2025-09-23 21:25:05', 'ONLINE', 'SUCCESS', 170),
('Credit Card', 930.00, 'txn_cc_171', '2025-09-24 08:02:05', 'ONLINE', 'FAILED', 171),
('Net Banking', 690.00, 'txn_nb_172', '2025-09-22 18:25:05', 'ONLINE', 'SUCCESS', 172),
('UPI', 430.00, 'txn_upi_173', '2025-09-20 12:00:05', 'ONLINE', 'SUCCESS', 173),
('Credit Card', 1080.00, 'txn_cc_174', '2025-09-23 18:35:05', 'ONLINE', 'SUCCESS', 174),
('Wallet', 870.00, 'txn_wal_175', '2025-09-21 20:15:05', 'ONLINE', 'SUCCESS', 175),
('UPI', 520.00, 'txn_upi_176', '2025-09-22 19:40:05', 'ONLINE', 'SUCCESS', 176),
('Credit Card', 760.00, 'txn_cc_177', '2025-09-19 20:30:05', 'ONLINE', 'SUCCESS', 177),
('Net Banking', 610.00, 'txn_nb_178', '2025-09-23 22:15:05', 'ONLINE', 'SUCCESS', 178),
('UPI', 460.00, 'txn_upi_179', '2025-09-24 08:40:30', 'ONLINE', 'SUCCESS', 179),
('Credit Card', 1400.00, 'txn_cc_180', '2025-09-21 19:50:05', 'ONLINE', 'SUCCESS', 180),
('Wallet', 570.00, 'txn_wal_181', '2025-09-22 21:10:05', 'ONLINE', 'FAILED', 181),
('UPI', 880.00, 'txn_upi_182', '2025-09-23 14:30:05', 'ONLINE', 'SUCCESS', 182),
('Credit Card', 940.00, 'txn_cc_183', '2025-09-20 20:55:05', 'ONLINE', 'SUCCESS', 183),
('Cash on Delivery', 780.00, NULL, '2025-09-24 08:29:00', 'COD', 'PENDING', 184),
('Net Banking', 500.00, 'txn_nb_185', '2025-09-21 18:50:05', 'ONLINE', 'SUCCESS', 185),
('UPI', 650.00, 'txn_upi_186', '2025-09-22 20:30:05', 'ONLINE', 'SUCCESS', 186),
('Credit Card', 1150.00, 'txn_cc_187', '2025-09-23 20:25:05', 'ONLINE', 'SUCCESS', 187),
('Wallet', 290.00, 'txn_wal_188', '2025-09-24 08:49:40', 'ONLINE', 'SUCCESS', 188),
('UPI', 790.00, 'txn_upi_189', '2025-09-21 21:35:05', 'ONLINE', 'SUCCESS', 189),
('Credit Card', 210.00, 'txn_cc_190', '2025-09-22 19:05:05', 'ONLINE', 'SUCCESS', 190),
('Net Banking', 960.00, 'txn_nb_191', '2025-09-23 19:35:05', 'ONLINE', 'SUCCESS', 191),
('UPI', 1030.00, 'txn_upi_192', '2025-09-20 19:45:05', 'ONLINE', 'SUCCESS', 192),
('Credit Card', 350.00, 'txn_cc_193', '2025-09-22 12:00:05', 'ONLINE', 'SUCCESS', 193),
('Wallet', 550.00, 'txn_wal_194', '2025-09-23 13:50:05', 'ONLINE', 'SUCCESS', 194),
('UPI', 830.00, 'txn_upi_195', '2025-09-21 19:55:05', 'ONLINE', 'SUCCESS', 195),
('Credit Card', 770.00, 'txn_cc_196', '2025-09-24 08:35:30', 'ONLINE', 'SUCCESS', 196),
('Net Banking', 680.00, 'txn_nb_197', '2025-09-22 18:55:05', 'ONLINE', 'SUCCESS', 197),
('UPI', 1250.00, 'txn_upi_198', '2025-09-23 20:40:05', 'ONLINE', 'SUCCESS', 198),
('Credit Card', 710.00, 'txn_cc_199', '2025-09-20 21:20:05', 'ONLINE', 'SUCCESS', 199),
('Wallet', 590.00, 'txn_wal_200', '2025-09-24 08:50:15', 'ONLINE', 'SUCCESS', 200);



-- AgentID is 1-20.
-- =======================================================================================
-- SECTION 10: DELIVERIES (Complete & Final Script)
-- NOTE: This data is generated based on the logic in DeliveryServiceImpl.java
-- for all orders with status 2 (PREPARING), 3 (OUT_FOR_DELIVERY), or 4 (DELIVERED).
-- =======================================================================================

INSERT INTO Delivery (Pickup_Time, Delivery_Time, ETA, Tracking_Link, OrderID, AgentID) VALUES
-- Delivered Orders (Status 4)
('2025-09-23 19:50:00', '2025-09-23 20:18:00', '2025-09-23 20:22:00', 'https://track.me/order1', 1, 1),
('2025-09-23 14:21:00', '2025-09-23 14:48:00', '2025-09-23 14:51:00', 'https://track.me/order6', 6, 8),
('2025-09-23 19:08:00', '2025-09-23 19:33:00', '2025-09-23 19:38:00', 'https://track.me/order7', 7, 14),
('2025-09-21 19:24:00', '2025-09-21 19:51:00', '2025-09-21 19:54:00', 'https://track.me/order10', 10, 5),
('2025-09-23 21:23:00', '2025-09-23 21:41:00', '2025-09-23 21:48:00', 'https://track.me/order13', 13, 11),
('2025-09-22 13:34:00', '2025-09-22 13:59:00', '2025-09-22 14:04:00', 'https://track.me/order16', 16, 7),
('2025-09-23 20:07:00', '2025-09-23 20:29:00', '2025-09-23 20:32:00', 'https://track.me/order17', 17, 12),
('2025-09-21 20:28:00', '2025-09-21 20:53:00', '2025-09-21 20:58:00', 'https://track.me/order18', 18, 15),
('2025-09-22 18:53:00', '2025-09-22 19:21:00', '2025-09-22 19:23:00', 'https://track.me/order20', 20, 20),
('2025-09-23 12:37:00', '2025-09-23 12:58:00', '2025-09-23 13:02:00', 'https://track.me/order21', 21, 3),
('2025-09-20 12:02:00', '2025-09-20 12:29:00', '2025-09-20 12:32:00', 'https://track.me/order23', 23, 10),
('2025-09-19 20:17:00', '2025-09-19 20:41:00', '2025-09-19 20:47:00', 'https://track.me/order25', 25, 17),
('2025-09-22 20:52:00', '2025-09-22 21:18:00', '2025-09-22 21:22:00', 'https://track.me/order26', 26, 9),
('2025-09-23 22:22:00', '2025-09-23 22:48:00', '2025-09-23 22:52:00', 'https://track.me/order27', 27, 13),
('2025-09-18 13:22:00', '2025-09-18 13:49:00', '2025-09-18 13:52:00', 'https://track.me/order28', 28, 18),
('2025-09-21 21:32:00', '2025-09-21 21:58:00', '2025-09-21 22:02:00', 'https://track.me/order31', 31, 1),
('2025-09-23 18:12:00', '2025-09-23 18:38:00', '2025-09-23 18:42:00', 'https://track.me/order32', 32, 5),
('2025-09-22 09:22:00', '2025-09-22 09:48:00', '2025-09-22 09:52:00', 'https://track.me/order34', 34, 8),
('2025-09-20 19:42:00', '2025-09-20 20:08:00', '2025-09-20 20:12:00', 'https://track.me/order36', 36, 12),
('2025-09-23 20:32:00', '2025-09-23 20:58:00', '2025-09-23 21:02:00', 'https://track.me/order38', 38, 11),
('2025-09-22 13:07:00', '2025-09-22 13:33:00', '2025-09-22 13:37:00', 'https://track.me/order40', 40, 4),
('2025-09-20 19:07:00', '2025-09-20 19:33:00', '2025-09-20 19:37:00', 'https://track.me/order44', 44, 18),
('2025-09-22 19:22:00', '2025-09-22 19:48:00', '2025-09-22 19:52:00', 'https://track.me/order45', 45, 9),
('2025-09-21 16:22:00', '2025-09-21 16:48:00', '2025-09-21 16:52:00', 'https://track.me/order46', 46, 3),
('2025-09-24 06:52:00', '2025-09-24 07:18:00', '2025-09-24 07:22:00', 'https://track.me/order48', 48, 20),
('2025-09-23 11:22:00', '2025-09-23 11:48:00', '2025-09-23 11:52:00', 'https://track.me/order49', 49, 14),
('2025-09-19 20:42:00', '2025-09-19 21:08:00', '2025-09-19 21:12:00', 'https://track.me/order51', 51, 6),
('2025-09-20 09:37:00', '2025-09-20 10:03:00', '2025-09-20 10:07:00', 'https://track.me/order52', 52, 19),
('2025-09-23 15:22:00', '2025-09-23 15:48:00', '2025-09-23 15:52:00', 'https://track.me/order53', 53, 1),
('2025-09-22 21:27:00', '2025-09-22 21:53:00', '2025-09-22 21:57:00', 'https://track.me/order54', 54, 5),
('2025-09-21 12:52:00', '2025-09-21 13:18:00', '2025-09-21 13:22:00', 'https://track.me/order56', 56, 8),
('2025-09-22 18:22:00', '2025-09-22 18:48:00', '2025-09-22 18:52:00', 'https://track.me/order59', 59, 11),
('2025-09-23 21:07:00', '2025-09-23 21:33:00', '2025-09-23 21:37:00', 'https://track.me/order60', 60, 4),
('2025-09-19 21:52:00', '2025-09-19 22:18:00', '2025-09-19 22:22:00', 'https://track.me/order62', 62, 17),
('2025-09-21 14:22:00', '2025-09-21 14:48:00', '2025-09-21 14:52:00', 'https://track.me/order63', 63, 13),
('2025-09-22 20:22:00', '2025-09-22 20:48:00', '2025-09-22 20:52:00', 'https://track.me/order64', 64, 2),
('2025-09-20 09:07:00', '2025-09-20 09:33:00', '2025-09-20 09:37:00', 'https://track.me/order67', 67, 10),
('2025-09-21 19:52:00', '2025-09-21 20:18:00', '2025-09-21 20:22:00', 'https://track.me/order68', 68, 6),
('2025-09-22 13:42:00', '2025-09-22 14:08:00', '2025-09-22 14:12:00', 'https://track.me/order70', 70, 20),
('2025-09-23 13:12:00', '2025-09-23 13:38:00', '2025-09-23 13:42:00', 'https://track.me/order72', 72, 1),
('2025-09-20 16:52:00', '2025-09-20 17:18:00', '2025-09-20 17:22:00', 'https://track.me/order73', 73, 5),
('2025-09-22 19:37:00', '2025-09-22 20:03:00', '2025-09-22 20:07:00', 'https://track.me/order75', 75, 15),
('2025-09-21 22:22:00', '2025-09-21 22:48:00', '2025-09-21 22:52:00', 'https://track.me/order76', 76, 8),
('2025-09-19 14:07:00', '2025-09-19 14:33:00', '2025-09-19 14:37:00', 'https://track.me/order79', 79, 11),
('2025-09-22 11:52:00', '2025-09-22 12:18:00', '2025-09-22 12:22:00', 'https://track.me/order80', 80, 4),
('2025-09-21 20:22:00', '2025-09-21 20:48:00', '2025-09-21 20:52:00', 'https://track.me/order81', 81, 18),
('2025-09-23 19:22:00', '2025-09-23 19:48:00', '2025-09-23 19:52:00', 'https://track.me/order83', 83, 9),
('2025-09-20 20:32:00', '2025-09-20 20:58:00', '2025-09-20 21:02:00', 'https://track.me/order84', 84, 3),
('2025-09-22 08:22:00', '2025-09-22 08:48:00', '2025-09-22 08:52:00', 'https://track.me/order85', 85, 20),
('2025-09-21 12:22:00', '2025-09-21 12:48:00', '2025-09-21 12:52:00', 'https://track.me/order87', 87, 13),
('2025-09-23 21:52:00', '2025-09-23 22:18:00', '2025-09-23 22:22:00', 'https://track.me/order89', 89, 7),
('2025-09-19 20:02:00', '2025-09-19 20:28:00', '2025-09-19 20:32:00', 'https://track.me/order91', 91, 1),
('2025-09-21 07:22:00', '2025-09-21 07:48:00', '2025-09-21 07:52:00', 'https://track.me/order93', 93, 8),
('2025-09-22 14:22:00', '2025-09-22 14:48:00', '2025-09-22 14:52:00', 'https://track.me/order95', 95, 12),
('2025-09-23 18:42:00', '2025-09-23 19:08:00', '2025-09-23 19:12:00', 'https://track.me/order96', 96, 5),
('2025-09-18 19:22:00', '2025-09-18 19:48:00', '2025-09-18 19:52:00', 'https://track.me/order98', 98, 11),
('2025-09-21 20:52:00', '2025-09-21 21:18:00', '2025-09-21 21:22:00', 'https://track.me/order99', 99, 4),
('2025-09-22 20:07:00', '2025-09-22 20:33:00', '2025-09-22 20:37:00', 'https://track.me/order100', 100, 18),
('2025-09-23 20:37:00', '2025-09-23 21:03:00', '2025-09-23 21:07:00', 'https://track.me/order102', 102, 9),
('2025-09-24 07:07:00', '2025-09-24 07:33:00', '2025-09-24 07:37:00', 'https://track.me/order103', 103, 3),
('2025-09-22 12:52:00', '2025-09-22 13:18:00', '2025-09-22 13:22:00', 'https://track.me/order104', 104, 20),
('2025-09-21 19:32:00', '2025-09-21 19:58:00', '2025-09-21 20:02:00', 'https://track.me/order107', 107, 7),
('2025-09-20 20:47:00', '2025-09-20 21:13:00', '2025-09-20 21:17:00', 'https://track.me/order109', 109, 2),
('2025-09-23 20:12:00', '2025-09-23 20:38:00', '2025-09-23 20:42:00', 'https://track.me/order111', 111, 10),
('2025-09-21 12:07:00', '2025-09-21 12:33:00', '2025-09-21 12:37:00', 'https://track.me/order113', 113, 16),
('2025-09-22 21:02:00', '2025-09-22 21:28:00', '2025-09-22 21:32:00', 'https://track.me/order114', 114, 8),
('2025-09-23 12:22:00', '2025-09-23 12:48:00', '2025-09-23 12:52:00', 'https://track.me/order116', 116, 5),
('2025-09-20 10:07:00', '2025-09-20 10:33:00', '2025-09-20 10:37:00', 'https://track.me/order118', 118, 11),
('2025-09-21 22:07:00', '2025-09-21 22:33:00', '2025-09-21 22:37:00', 'https://track.me/order119', 119, 4),
('2025-09-22 19:57:00', '2025-09-22 20:23:00', '2025-09-22 20:27:00', 'https://track.me/order121', 121, 18),
('2025-09-23 19:17:00', '2025-09-23 19:43:00', '2025-09-23 19:47:00', 'https://track.me/order122', 122, 9),
('2025-09-20 13:37:00', '2025-09-20 14:03:00', '2025-09-20 14:07:00', 'https://track.me/order124', 124, 3),
('2025-09-22 10:22:00', '2025-09-22 10:48:00', '2025-09-22 10:52:00', 'https://track.me/order127', 127, 14),
('2025-09-23 21:17:00', '2025-09-23 21:43:00', '2025-09-23 21:47:00', 'https://track.me/order128', 128, 7),
('2025-09-21 18:52:00', '2025-09-21 19:18:00', '2025-09-21 19:22:00', 'https://track.me/order129', 129, 1),
('2025-09-20 19:27:00', '2025-09-20 19:53:00', '2025-09-20 19:57:00', 'https://track.me/order131', 131, 6),
('2025-09-22 13:27:00', '2025-09-22 13:53:00', '2025-09-22 13:57:00', 'https://track.me/order132', 132, 16),
('2025-09-23 17:22:00', '2025-09-23 17:48:00', '2025-09-23 17:52:00', 'https://track.me/order133', 133, 8),
('2025-09-21 21:22:00', '2025-09-21 21:48:00', '2025-09-21 21:52:00', 'https://track.me/order136', 136, 5),
('2025-09-22 19:02:00', '2025-09-22 19:28:00', '2025-09-22 19:32:00', 'https://track.me/order137', 137, 11),
('2025-09-23 13:02:00', '2025-09-23 13:28:00', '2025-09-23 13:32:00', 'https://track.me/order139', 139, 4),
('2025-09-21 08:52:00', '2025-09-21 09:18:00', '2025-09-21 09:22:00', 'https://track.me/order141', 141, 18),
('2025-09-22 21:42:00', '2025-09-22 22:08:00', '2025-09-22 22:12:00', 'https://track.me/order142', 142, 9),
('2025-09-24 07:52:00', '2025-09-24 08:18:00', '2025-09-24 08:22:00', 'https://track.me/order143', 143, 3),
('2025-09-19 20:22:00', '2025-09-19 20:48:00', '2025-09-19 20:52:00', 'https://track.me/order145', 145, 20),
('2025-09-22 20:42:00', '2025-09-22 21:08:00', '2025-09-22 21:12:00', 'https://track.me/order146', 146, 14),
('2025-09-21 10:22:00', '2025-09-21 10:48:00', '2025-09-21 10:52:00', 'https://track.me/order148', 148, 1),
('2025-09-23 20:57:00', '2025-09-23 21:23:00', '2025-09-23 21:27:00', 'https://track.me/order149', 149, 6),
('2025-09-22 19:47:00', '2025-09-22 20:13:00', '2025-09-22 20:17:00', 'https://track.me/order151', 151, 16),
('2025-09-23 14:02:00', '2025-09-23 14:28:00', '2025-09-23 14:32:00', 'https://track.me/order153', 153, 8),
('2025-09-18 21:22:00', '2025-09-18 21:48:00', '2025-09-18 21:52:00', 'https://track.me/order154', 154, 12),
('2025-09-20 19:12:00', '2025-09-20 19:38:00', '2025-09-20 19:42:00', 'https://track.me/order156', 156, 5),
('2025-09-22 22:12:00', '2025-09-22 22:38:00', '2025-09-22 22:42:00', 'https://track.me/order157', 157, 11),
('2025-09-21 14:52:00', '2025-09-21 15:18:00', '2025-09-21 15:22:00', 'https://track.me/order159', 159, 18),
('2025-09-23 19:37:00', '2025-09-23 20:03:00', '2025-09-23 20:07:00', 'https://track.me/order160', 160, 9),
('2025-09-20 15:22:00', '2025-09-20 15:48:00', '2025-09-20 15:52:00', 'https://track.me/order163', 163, 3),
('2025-09-23 20:27:00', '2025-09-23 20:53:00', '2025-09-23 20:57:00', 'https://track.me/order164', 164, 20),
('2025-09-22 21:12:00', '2025-09-22 21:38:00', '2025-09-22 21:42:00', 'https://track.me/order165', 165, 14),
('2025-09-19 19:32:00', '2025-09-19 19:58:00', '2025-09-19 20:02:00', 'https://track.me/order167', 167, 7),
('2025-09-20 22:07:00', '2025-09-20 22:33:00', '2025-09-20 22:37:00', 'https://track.me/order168', 168, 1),
('2025-09-21 13:22:00', '2025-09-21 13:48:00', '2025-09-21 13:52:00', 'https://track.me/order169', 169, 6),
('2025-09-23 21:47:00', '2025-09-23 22:13:00', '2025-09-23 22:17:00', 'https://track.me/order170', 170, 16),
('2025-09-22 18:47:00', '2025-09-22 19:13:00', '2025-09-22 19:17:00', 'https://track.me/order172', 172, 8),
('2025-09-20 12:22:00', '2025-09-20 12:48:00', '2025-09-20 12:52:00', 'https://track.me/order173', 173, 12),
('2025-09-23 18:57:00', '2025-09-23 19:23:00', '2025-09-23 19:27:00', 'https://track.me/order174', 174, 5),
('2025-09-21 20:37:00', '2025-09-21 21:03:00', '2025-09-21 21:07:00', 'https://track.me/order175', 175, 11),
('2025-09-19 20:52:00', '2025-09-19 21:18:00', '2025-09-19 21:22:00', 'https://track.me/order177', 177, 4),
('2025-09-23 22:37:00', '2025-09-23 23:03:00', '2025-09-23 23:07:00', 'https://track.me/order178', 178, 18),
('2025-09-21 20:12:00', '2025-09-21 20:38:00', '2025-09-21 20:42:00', 'https://track.me/order180', 180, 9),
('2025-09-23 14:52:00', '2025-09-23 15:18:00', '2025-09-23 15:22:00', 'https://track.me/order182', 182, 3),
('2025-09-20 21:17:00', '2025-09-20 21:43:00', '2025-09-20 21:47:00', 'https://track.me/order183', 183, 20),
('2025-09-21 19:12:00', '2025-09-21 19:38:00', '2025-09-21 19:42:00', 'https://track.me/order185', 185, 7),
('2025-09-22 20:52:00', '2025-09-22 21:18:00', '2025-09-22 21:22:00', 'https://track.me/order186', 186, 1),
('2025-09-23 20:47:00', '2025-09-23 21:13:00', '2025-09-23 21:17:00', 'https://track.me/order187', 187, 6),
('2025-09-21 21:57:00', '2025-09-21 22:23:00', '2025-09-21 22:27:00', 'https://track.me/order189', 189, 16),
('2025-09-22 19:27:00', '2025-09-22 19:53:00', '2025-09-22 19:57:00', 'https://track.me/order190', 190, 8),
('2025-09-23 19:57:00', '2025-09-23 20:23:00', '2025-09-23 20:27:00', 'https://track.me/order191', 191, 12),
('2025-09-20 20:07:00', '2025-09-20 20:33:00', '2025-09-20 20:37:00', 'https://track.me/order192', 192, 5),
('2025-09-22 12:22:00', '2025-09-22 12:48:00', '2025-09-22 12:52:00', 'https://track.me/order193', 193, 11),
('2025-09-23 14:12:00', '2025-09-23 14:38:00', '2025-09-23 14:42:00', 'https://track.me/order194', 194, 4),
('2025-09-21 20:17:00', '2025-09-21 20:43:00', '2025-09-21 20:47:00', 'https://track.me/order195', 195, 18),
('2025-09-23 21:02:00', '2025-09-23 21:28:00', '2025-09-23 21:32:00', 'https://track.me/order198', 198, 9),
('2025-09-20 21:42:00', '2025-09-20 22:08:00', '2025-09-20 22:12:00', 'https://track.me/order199', 199, 3),

-- Out for Delivery Orders (Status 3)
('2025-09-24 09:05:00', NULL, '2025-09-24 09:37:00', 'https://track.me/order126', 126, 20),
('2025-09-24 09:10:00', NULL, '2025-09-24 09:42:00', 'https://track.me/order134', 134, 12),
('2025-09-24 09:12:00', NULL, '2025-09-24 09:44:00', 'https://track.me/order147', 147, 7),
('2025-09-24 09:15:00', NULL, '2025-09-24 09:47:00', 'https://track.me/order158', 158, 4),
('2025-09-24 09:16:00', NULL, '2025-09-24 09:48:00', 'https://track.me/order184', 184, 14),
('2025-09-24 08:50:00', NULL, '2025-09-24 09:22:00', 'https://track.me/order33', 33, 16),
('2025-09-24 09:08:00', NULL, '2025-09-24 09:40:00', 'https://track.me/order50', 50, 7),
('2025-09-24 08:45:00', NULL, '2025-09-24 09:17:00', 'https://track.me/order55', 55, 15),
('2025-09-24 08:58:00', NULL, '2025-09-24 09:30:00', 'https://track.me/order69', 69, 19),
('2025-09-24 09:03:00', NULL, '2025-09-24 09:35:00', 'https://track.me/order78', 78, 12),
('2025-09-24 08:55:00', NULL, '2025-09-24 09:27:00', 'https://track.me/order92', 92, 16),

-- Preparing Orders (Status 2)
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order3', 3, 11),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order9', 9, 6),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order19', 19, 1),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order30', 30, 10),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order39', 39, 13),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order43', 43, 17),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order57', 57, 2),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order65', 65, 9),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order86', 86, 18),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order97', 97, 4),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order123', 123, 20),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order150', 150, 15),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order161', 161, 8),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order179', 179, 14),
('2025-09-24 09:31:04', NULL, '2025-09-24 09:53:04', 'https://track.me/order196', 196, 6);



update users set password = "$2a$10$r8qkaN.iHLbg0JzIz5//oe/7Ua2wmo3GTs/vDtvvGD2QclMf2JQvi" where userid>0;