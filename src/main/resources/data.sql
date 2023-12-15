-- CREATE TABLE food_category (
--                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                               name VARCHAR(15) NOT NULL
-- );
--
--
-- CREATE TABLE member (
--                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                         name VARCHAR(20) NOT NULL,
--                         address VARCHAR(40) NOT NULL,
--                         spec_address VARCHAR(40) NOT NULL,
--                         gender VARCHAR(10),
--                         social_type VARCHAR(15),
--                         status VARCHAR(15) DEFAULT 'ACTIVE',
--                         inactive_date DATE,
--                         email VARCHAR(50),
--                         point INT
-- );
-- CREATE TABLE region (
--                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                         name VARCHAR(20) NOT NULL
-- );
--
-- CREATE TABLE store (
--                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                        name VARCHAR(50) NOT NULL,
--                        address VARCHAR(50) NOT NULL,
--                        score FLOAT,
--                        region_id BIGINT,
--                        FOREIGN KEY (region_id) REFERENCES Region(id)
-- );
--
-- CREATE TABLE mission (
--                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                          reward INT,
--                          deadline DATETIME,
--                          mission_spec TEXT,
--                          store_id BIGINT,
--                          FOREIGN KEY (store_id) REFERENCES Store(id)
-- );
--
-- CREATE TABLE review (
--                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
--                         title TEXT,
--                         score FLOAT,
--                         body TEXT,
--                         member_id BIGINT,
--                         store_id BIGINT,
--                         FOREIGN KEY (member_id) REFERENCES Member(id),
--                         FOREIGN KEY (store_id) REFERENCES Store(id)
-- );
--


INSERT INTO food_category (name) VALUES ('Italian');
INSERT INTO food_category (name) VALUES ('Japanese');
INSERT INTO food_category (name) VALUES ('Mexican');

INSERT INTO Member (name, address, spec_address, gender, status, email, point) VALUES ('John Doe', '123 Main St', 'Apt 4', 'MALE', 'ACTIVE', 'john.doe@example.com', 100);
INSERT INTO Member (name, address, spec_address, gender, status, email, point) VALUES ('Jane Smith', '456 Oak Ave', 'Unit 2B', 'FEMALE', 'ACTIVE', 'jane.smith@example.com', 150);
INSERT INTO Member (name, address, spec_address, gender, status, email, point) VALUES ('Alex Johnson', '789 Pine Rd', 'Suite 6', 'OTHER', 'INACTIVE', 'alex.j@example.com', 200);

INSERT INTO Region (name) VALUES ('North');
INSERT INTO Region (name) VALUES ('South');
INSERT INTO Region (name) VALUES ('East');

INSERT INTO Store (name, address, score, region_id) VALUES ('Store A', '1000 A St', 4.5, 1);
INSERT INTO Store (name, address, score, region_id) VALUES ('Store B', '2000 B Ave', 4.0, 1);
INSERT INTO Store (name, address, score, region_id) VALUES ('Store C', '2000 C Ave', 4.0, 1);

INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (50, '2023-12-31', 'Complete 5 deliveries', 1);
INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (50, '2023-12-31', 'Complete 5 deliveries', 1);
INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (100, '2024-01-15', 'Rate 10 products', 2);
INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (50, '2023-12-31', 'Complete 5 deliveries', 2);
INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (30, '2024-02-01', 'Refer 3 friends', 3);
INSERT INTO Mission (reward, deadline, mission_spec, store_id) VALUES (50, '2023-12-31', 'Complete 5 deliveries', 3);


INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Great service', 4.5, 'Loved the quick delivery', 1, 1);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Good quality', 4.0, 'Products are top-notch', 2, 2);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Good quality', 4.0, 'Products are top-notch', 2, 2);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Good quality', 4.0, 'Products are top-notch', 2, 2);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Good quality', 4.0, 'Products are top-notch', 2, 2);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Average experience', 3.0, 'Decent but not exceptional', 3, 3);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Average experience', 3.0, 'Decent but not exceptional', 3, 3);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Average experience', 3.0, 'Decent but not exceptional', 3, 3);
INSERT INTO Review (title, score, body, member_id, store_id) VALUES ('Average experience', 3.0, 'Decent but not exceptional', 3, 3);

INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('COMPLETE', 1, 1);
INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('CHALLENGING', 2, 1);
INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('COMPLETE', 1, 2);
INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('CHALLENGING', 3, 2);
INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('COMPLETE', 2, 3);
INSERT INTO Member_Mission (status, member_id, mission_id) VALUES ('CHALLENGING', 3, 3);
