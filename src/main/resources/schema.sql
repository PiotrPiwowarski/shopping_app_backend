-- Tworzenie tabeli USERS
CREATE TABLE USERS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

-- Tworzenie tabeli TOKENS
CREATE TABLE TOKENS (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        token VARCHAR(255) NOT NULL,
                        user_id BIGINT,
                        CONSTRAINT fk_tokens_user FOREIGN KEY (user_id) REFERENCES USERS(id)
);

-- Tworzenie tabeli ITEMS
CREATE TABLE ITEMS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       shop VARCHAR(255),
                       product_name VARCHAR(255),
                       price DECIMAL(19, 2),
                       amount DECIMAL(19, 2),
                       description VARCHAR(255),
                       image_url VARCHAR(255),
                       bought boolean,
                       user_id BIGINT,
                       CONSTRAINT fk_items_user FOREIGN KEY (user_id) REFERENCES USERS(id)
);