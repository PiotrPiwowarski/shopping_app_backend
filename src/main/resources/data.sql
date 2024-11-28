INSERT INTO USERS (email, password, role) VALUES ('admin@gmail.com', '$2y$10$STKqUJ3v5miGEYFNrb4GyuUItn4s2CJYNMnZ1ZDjQChGh.NjDrFzO', 'USER'); /*password: admin*/

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, bought, user_id)
VALUES ('Biedronka', 'Mleko', 4.99, 1, 'Dobre mleko', 'https://res.cloudinary.com/dj484tw6k/f_auto,q_auto,c_pad,b_white,w_557,h_557/v1548061372/be/3268.jpg', false, 1);

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, bought, user_id)
VALUES ('Lidl', 'Mleko', 5.59, 3, 'Mleko jest bardzo zdrowe dla zdrowia', 'https://cdn.britannica.com/77/200377-050-4326767F/milk-splashing-glass.jpg', false, 1);

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, bought, user_id)
VALUES ('Lidl', 'Kabanosy', 9.69, 7, 'Duża paczka kabanosów', 'https://www.zmlukow.pl/wp-content/uploads/2015/05/kabanosy_lukowskie_smaki_ok1kg_180g_nowa_etykieta_lukow-2048x1536.jpg', false, 1);

INSERT INTO ITEMS (shop, product_name, price, amount, description, image_url, bought, user_id)
VALUES ('Carrefour', 'Chleb', 6.99, 2, 'Chleb 1kg razowy', 'https://wiejskiewypieki.pl/hpeciai/eb02a5704392ea318d740c97ed57487a/pol_pl_Chleb-razowy-na-naturalnym-zakwasie-500-g-84_1.jpg', false, 1);
