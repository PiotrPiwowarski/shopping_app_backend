INSERT INTO USERS (email, password, role) VALUES ('admin@gmail.com', '$2y$10$STKqUJ3v5miGEYFNrb4GyuUItn4s2CJYNMnZ1ZDjQChGh.NjDrFzO', 'USER'); /*password: admin*/

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, user_id)
VALUES ('Example Shop', 'Example Product', 99.99, 1, 'This is a sample item description', 'http://example.com/image.jpg', 1);

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, user_id)
VALUES ('Lidl', 'Milk', 5.59, 3, 'Milk is very important for our health', 'https://cdn.britannica.com/77/200377-050-4326767F/milk-splashing-glass.jpg', 1);
