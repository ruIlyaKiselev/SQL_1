INSERT INTO country (country_id, name)
VALUES ('RUS', 'Russia');
/
INSERT INTO country (country_id, name)
VALUES ('USA', 'USA');
/
INSERT INTO country (country_id, name)
VALUES ('DEU', 'German');
/
INSERT INTO country (country_id, name)
VALUES ('JAP', 'Japan');
/
INSERT INTO country (country_id, name)
VALUES ('CHN', 'China');
/
INSERT INTO country (country_id, name)
VALUES ('KOR', 'Korea');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (1, 'Firm', 'BOSCH Russia', 'RUS', 'г. Новосибирск, ул. Красный Проспект 147/2');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (2, 'Firm', 'Hyundai Russia', 'RUS', 'г. Москва, пр, Мира 10');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (3, 'Firm', 'BMW Russia', 'RUS', 'г. Санкт-Петербург, ул. Зольная 23');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (4, 'Firm', 'Mercedes-Benz Russia', 'RUS', 'г. Москва, ул. Красноармейская 27');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (1, 'Little fact.', 'Auto24', 'KOR', 'г. Ансан, ул. Хосудон 89');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (2, 'Little fact.', 'Mansory', 'GER', 'г. Мюнхен, ул. Гронос 27');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (1, 'Little deal.', 'GEAR-AUTO', 'USA', 'г. Вашингтон, ул. Ферре 67');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (1, 'Shop', 'Автомир', 'RUS', 'г. Санкт-Петербург, ул. Большевиков 8');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (2, 'Shop', 'Auto-Parts', 'JAP', 'г. Киото, ул. Макаёми 14');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (3, 'Shop', 'SAT-Parts', 'CHN', 'г. Пекин, ул. Чхун-дзю 3');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (1, 'Dealer', 'Рольф', 'RUS', 'г. Москва, ул. Московская 9');
/
INSERT INTO abstract_provider (abstract_provider_id, category, name, address, country_id)
VALUES (2, 'Dealer', 'Авто-Ваз', 'RUS', 'г. Москва, ул. Державина 18');
/
INSERT INTO abstract_provider_adapter (abstract_provider_id, category)
VALUES (1, 'Firm');
/
INSERT INTO abstract_provider_adapter (abstract_provider_id, category)
VALUES (2, 'Firm');
/
INSERT INTO abstract_provider_adapter (abstract_provider_id, category)
VALUES (3, 'Firm');
/
INSERT INTO abstract_provider_adapter (abstract_provider_id, category)
VALUES (1, 'Little fact.');
/
INSERT INTO little_factory (abstract_provider_id, category)
VALUES (1, 'Little fact.');
/
INSERT INTO shop (abstract_provider_id, category)
VALUES (1, 'Shop');
/
INSERT INTO shop (abstract_provider_id, category)
VALUES (2, 'Shop');
/
INSERT INTO shop (abstract_provider_id, category)
VALUES (3, 'Shop');
/
INSERT INTO little_dealer (abstract_provider_id, category)
VALUES (1, 'Little deal.');
/
INSERT INTO dealer (abstract_provider_id, category, contract)
VALUES  (1, 'Dealer', 42434);
/
INSERT INTO dealer (abstract_provider_id, category, contract)
VALUES  (2, 'Dealer', 59235);
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (1, 1, 'Firm');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (2, 2, 'Firm');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (3, 3, 'Firm');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (4, 1, 'Little fact.');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (5, 1, 'Shop');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (5, 1, 'Shop');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (6, 2, 'Shop');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (7, 3, 'Shop');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (8, 1, 'Little deal.');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (9, 1, 'Dealer');
/
INSERT INTO provider (provider_id, abstract_provider_id, category)
VALUES (10, 2, 'Dealer');
/
INSERT INTO manufacturer (manufacturer_id, abstract_provider_id, category)
VALUES (1, 1, 'Firm');
/
INSERT INTO manufacturer (manufacturer_id, abstract_provider_id, category)
VALUES (2, 2, 'Firm');
/
INSERT INTO manufacturer (manufacturer_id, abstract_provider_id, category)
VALUES (3, 3, 'Firm');
/
INSERT INTO manufacturer (manufacturer_id, abstract_provider_id, category)
VALUES (4, 1, 'Little fact.');
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (1, 'Радиатор', 'Усиленный', 'Honda Civic FD5', 1);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (2, 'Радиатор', 'Аллюминиевый', 'Honda Civic FD5', 3);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (3, 'Фара левая (Л)', 'Линзованная', 'Honda Civic FD7', 2);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (4, 'Фара правая (Л)', 'Линзованная', 'Honda Civic FD7', 2);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (5, 'Фара левая', 'Галогеновая', 'Honda Civic FD1', 3);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (6, 'Фара правая', 'Галогеновая', 'Honda Civic FD1', 3);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (7, 'Стеклоподъемник', 'П/Л передние', 'Honda Civic FD1', 4);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (8, 'Стеклоподъемник', 'П/Л передние', 'Honda Civic FD1', 1);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (9, 'Бензонасос', 'С антиотливом', 'Honda Civic FD5', 2);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (10, 'Вентилятор печки', '10 Вт', 'Honda Civic FD1', 1);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (11, 'Генератор', '600А', 'Honda Civic FD1', 1);
/
INSERT INTO spare_part (spare_part_id, name, description, auto_model, manufacturer_id)
VALUES (12, 'Рулевая рейка', '1130мм', 'Honda Civic FD1', 4);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (1, 1, 2500, 28);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (2, 2, 1800, 25);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (3, 3, 5800, 17);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (4, 4, 5800, 18);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (5, 5, 5300, 9);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (6, 6, 5300, 13);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (7, 7, 2800, 14);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (8, 8, 2700, 25);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (9, 9, 5000, 6);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (10, 10, 2400, 15);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (11, 11, 4800, 15);
/
INSERT INTO cell (cell_id, spare_part_id, price, quantity)
VALUES (12, 12, 3500, 8);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 1, '03.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (2, 1, '15.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 2, '13.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 3, '11.03.21', 2300);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (2, 3, '19.03.21', 2600);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 4, '25.03.21', 2100);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 5, '17.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 6, '28.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 7, '10.03.21', 1200);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 8, '13.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 9, '20.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (1, 10, '23.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (2, 5, '29.03.21', 0);
/
INSERT INTO abstract_supply (abstract_supply_id, provider_id, supply_date, taxes)
VALUES (2, 6, '25.03.21', 0);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (1, 1, 534543);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (1, 10, 52354);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (1, 2, 334212);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (1, 3, 88693);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (1, 9, 216965);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (2, 1, 128503);
/
INSERT INTO contract (contract_id, supply_id, provider_id)
VALUES (2, 3, 325904);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (1, 1, 1);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (2, 2, 1);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (3, 1, 2);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (4, 1, 3);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (5, 2, 3);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (6, 1, 4);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (7, 1, 5);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (8, 1, 6);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (9, 1, 7);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (10, 1, 8);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (11, 1, 9);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (12, 1, 10);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (13, 2, 5);
/
INSERT INTO supply (supply_id, abstract_supply_id, provider_id)
VALUES (14, 2, 6);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (1, 1, '1 мес', 3, 10, 2100);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (1, 8, '3 мес', 5, 15, 2500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (1, 10, '3 мес', 0, 10, 1900);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (1, 11, '6 мес', 3, 9, 4500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (2, 1, '1 мес', 3, 10, 2100);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (2, 11, '6 мес', 0, 3, 4500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (3, 3, '1 год', 3, 6, 5500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (3, 4, '1 год', 3, 6, 5500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (3, 9, '6 мес', 3, 4, 4600);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (4, 2, '1 год', 0, 15, 1500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (4, 5, '2 года', 0, 9, 5000);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (4, 6, '2 года', 0, 9, 5000);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (5, 2, '1 год', 0, 10, 1500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (5, 2, '2 года', 0, 10, 1500);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (5, 6, '2 года', 0, 4, 5000);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (5, 1, '2 года', 1, 2, 4200);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (5, 2, '1 год', 1, 2, 5000);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (6, 12, 'нет', 0, 8, 3200);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (6, 7, 'нет', 0, 7, 2400);
/
INSERT INTO supply_details (supply_id, spare_part_id, price, quantity, discount, warranty)
VALUES (7, 11, 'нет', 2, 1, 3200);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (1, 1, 1);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (2, 1, 8);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (3, 1, 10);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (4, 1, 11);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (5, 2, 1);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (6, 2, 11);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (7, 3, 3);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (8, 3, 4);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (9, 3, 9);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (1, 1, 1);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (10, 4, 2);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (11, 4, 5);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (12, 4, 6);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (13, 5, 2);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (14, 5, 6);
/
INSERT INTO product (product_id, supply_id, spare_part_id)
VALUES (15, 16, 12);
/
INSERT INTO broken_product (broken_product_id, product_id, return_date, quantity)
VALUES (1, 3, '15.04.21', 1);
/
INSERT INTO broken_product (broken_product_id, product_id, return_date, quantity)
VALUES (2, 7, '1.04.21', 2);
/
INSERT INTO broken_product (broken_product_id, product_id, return_date, quantity)
VALUES (3, 11, '2.05.21', 1);
/
INSERT INTO customer (customer_id, first_name, second_name, third_name)
VALUES (1, 'Петров', 'Иван', 'Васильевич');
/
INSERT INTO customer (customer_id, first_name, second_name, third_name)
VALUES (2, 'Алексеев', 'Геннадий', 'Петрович');
/
INSERT INTO customer (customer_id, first_name, second_name, third_name)
VALUES (3, 'Александров', 'Максим', 'Иванович');
/
INSERT INTO customer (customer_id, first_name, second_name, third_name)
VALUES (4, 'Васильев', 'Николай', 'Викторович');
/
INSERT INTO customer (customer_id, first_name, second_name, third_name)
VALUES (5, 'Антонов', 'Петр', 'Николаевич');
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (1, '14.05.21', 1);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (2, '1.05.21', 1);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (3, '4.05.21', 2);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (4, '10.05.21', 2);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (5, '24.05.21', 3);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (6, '29.05.21', 4);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (7, '11.05.21', 5);
/
INSERT INTO customer_order (customer_order_id, order_date, customer_id)
VALUES (8, '19.05.21', 5);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (27, 8, 25, 1);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (1, 1, 1, 2);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (2, 1, 11, 1);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (3, 1, 15, 2);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (4, 2, 5, 2);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (5, 2, 6, 3);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (6, 2, 1, 1);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (7, 3, 14, 1);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (8, 3, 7, 1);
/
INSERT INTO order_details (order_details_id, quantity, order_id, product_id)
VALUES (10, 3, 28, 1);
/
INSERT INTO customer_application (customer_application_id, application_date, customer_id)
VALUES (1, '18.02.21', 1);
/
INSERT INTO customer_application (customer_application_id, application_date, customer_id)
VALUES (2, '24.02.21', 1);
/
INSERT INTO customer_application (customer_application_id, application_date, customer_id)
VALUES (3, '25.02.14', 2);
/
INSERT INTO customer_application (customer_application_id, application_date, customer_id)
VALUES (4, '28.02.14', 4);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (1, 1, 3, 3);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (2, 1, 7, 1);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (3, 2, 2, 2);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (4, 3, 9, 1);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (5, 3, 10, 4);
/
INSERT INTO application_details (application_details_id, quantity, customer_application_id, spare_part_id)
VALUES (6, 4, 11, 2);
/