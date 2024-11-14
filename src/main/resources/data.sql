-- Dodanie przykładowego użytkownika do tabeli USERS
INSERT INTO USERS (email, password, role) VALUES ('Piotr', '$2y$10$iWG0RuDprLM1VJvizMXeVeMTG94izDVnkvRdDJqbNKo8el4iQq8dy', 'USER');

-- Dodanie przykładowego przedmiotu do tabeli ITEMS dla użytkownika o emailu 'Piotr'
-- Zakładamy, że ID użytkownika Piotr to 1, jeśli jest to pierwszy wpis w tabeli USERS.
INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, user_id)
VALUES ('Example Shop', 'Example Product', 99.99, 1, 'This is a sample item description', 'http://example.com/image.jpg', 1);
