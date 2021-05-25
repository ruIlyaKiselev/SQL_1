INSERT INTO country VALUES ('RUS', 'Россия', 0);
/
INSERT INTO country VALUES ('DEU', 'Германия', 4);
/
INSERT INTO country VALUES ('USA', 'США', 7);
/
INSERT INTO country VALUES ('KOR', 'Корея', 3);
/
INSERT INTO country VALUES ('JAP', 'Япония', 5);
/
INSERT INTO country VALUES ('FRH', 'Франция', 3);
/
INSERT INTO customer VALUES (1, 'Большим', 'Максим', 'Анатольевич', 'Москва', 'ул. Мира 5', '453214');
/
INSERT INTO customer VALUES (2, 'Быкова', 'Галина', 'Павловна', 'Санкт-Петербург', 'ул. Красноармейская 7', '215754');
/
INSERT INTO customer VALUES (3, 'Власов', 'Семён', 'Сергеевич', 'Екатеринбург', 'пл. Ленина 21', '568543');
/
INSERT INTO customer VALUES (4, 'Дробышевский', 'Иван', 'Александрович', 'Казань', 'ул. Маршала Жукова 45', '764368');
/
INSERT INTO customer VALUES (5, 'Зибарев', 'Артем', 'Олегович', 'Калуга', 'ул. Кузьмы Минина 8', '793654');
/
INSERT INTO customer VALUES (6, 'Киселев', 'Илья', 'Сергеевич', 'Новосибирск', 'ул. Красный Проспект 111', '630075');
/
INSERT INTO customer VALUES (7, 'Левченко', 'Кирилл', 'Константинович', 'Владивосток', 'ул. Трудовая 24', '864246');
/
INSERT INTO customer VALUES (8, 'Масеевский', 'Антон', 'Михайлович', 'Сочи', 'ул. Героев Революции 23', '214684');
/
INSERT INTO customer VALUES (9, 'Миронов', 'Владимир', 'Сергеевич', 'Грозный', 'ул. Ахмата Кадырова 43', '123643');
/
INSERT INTO customer VALUES (10, 'Погребникова', 'Мария', 'Николаевна', 'Воронеж', 'ул. Нарымская', '321575');
/
INSERT INTO customer VALUES (11, 'Хлиманкова', 'Галина', 'Константиновна', 'Рязань', 'ул. 1905 года', '643287');
/
INSERT INTO customer VALUES (12, 'Чемагин', 'Александр', 'Сергеевич', 'Новороссийск', 'ул. Достоевского', '935743');
/
INSERT INTO manufacturer VALUES (1, 'Авто-Ваз');
/
INSERT INTO manufacturer VALUES (2, 'Mercedes-Benz');
/
INSERT INTO manufacturer VALUES (3, 'BMW');
/
INSERT INTO manufacturer VALUES (4, 'Toyota');
/
INSERT INTO manufacturer VALUES (5, 'Nissan');
/
INSERT INTO manufacturer VALUES (6, 'Renault');
/
INSERT INTO manufacturer VALUES (7, 'KIA');
/
INSERT INTO manufacturer VALUES (8, 'SAT');
/
INSERT INTO manufacturer VALUES (9, 'SED');
/
INSERT INTO manufacturer VALUES (10, 'TYG');
/
INSERT INTO application VALUES (1, TO_DATE('01-01-2003', 'DD-MM-YYYY'), 12);
/
INSERT INTO application VALUES (2, TO_DATE('03-01-2003', 'DD-MM-YYYY'), 11);
/
INSERT INTO application VALUES (3, TO_DATE('07-01-2003', 'DD-MM-YYYY'), 10);
/
INSERT INTO application VALUES (4, TO_DATE('14-01-2003', 'DD-MM-YYYY'), 9);
/
INSERT INTO application VALUES (5, TO_DATE('17-01-2003', 'DD-MM-YYYY'), 8);
/
INSERT INTO application VALUES (6, TO_DATE('21-01-2003', 'DD-MM-YYYY'), 7);
/
INSERT INTO application VALUES (7, TO_DATE('23-01-2003', 'DD-MM-YYYY'), 6);
/
INSERT INTO application VALUES (8, TO_DATE('25-01-2003', 'DD-MM-YYYY'), 5);
/
INSERT INTO application VALUES (9, TO_DATE('26-01-2003', 'DD-MM-YYYY'), 4);
/
INSERT INTO application VALUES (10, TO_DATE('02-02-2003', 'DD-MM-YYYY'), 3);
/
INSERT INTO application VALUES (11, TO_DATE('07-02-2003', 'DD-MM-YYYY'), 2);
/
INSERT INTO application VALUES (12, TO_DATE('16-02-2003', 'DD-MM-YYYY'), 1);
/
INSERT INTO orders VALUES (1, TO_DATE('05-01-2003', 'DD-MM-YYYY'), 12, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (2, TO_DATE('07-01-2003', 'DD-MM-YYYY'), 11, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (3, TO_DATE('12-01-2003', 'DD-MM-YYYY'), 10, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (4, TO_DATE('20-01-2003', 'DD-MM-YYYY'), 9, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (5, TO_DATE('25-01-2003', 'DD-MM-YYYY'), 8, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (6, TO_DATE('28-01-2003', 'DD-MM-YYYY'), 7, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (7, TO_DATE('02-02-2003', 'DD-MM-YYYY'), 6, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (8, TO_DATE('07-02-2003', 'DD-MM-YYYY'), 5, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (9, TO_DATE('12-02-2003', 'DD-MM-YYYY'), 4, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (10, TO_DATE('15-02-2003', 'DD-MM-YYYY'), 3, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (11, TO_DATE('21-02-2003', 'DD-MM-YYYY'), 2, 'Ожидает оплаты');
/
INSERT INTO orders VALUES (12, TO_DATE('26-02-2003', 'DD-MM-YYYY'), 1, 'Ожидает оплаты');
/
INSERT INTO provider VALUES (1, 'Dealer', 'Авто-ВАЗ', 'г. Тольятти, ул. Мира 12', 'RUS');
/
INSERT INTO provider VALUES (2, 'Dealer', 'Mercedes-Benz', 'Штутгарт, Германия', 'DEU');
/
INSERT INTO provider VALUES (3, 'Dealer', 'BMW', 'Мюнхен, Германия', 'DEU');
/
INSERT INTO provider VALUES (4, 'Dealer', 'Toyota', 'Тойота, Айти, Япония', 'JAP');
/
INSERT INTO provider VALUES (5, 'Dealer', 'Nissan', 'Иокогама, Канагава, Япония', 'JAP');
/
INSERT INTO provider VALUES (6, 'Dealer', 'Renault', 'Булонь-Бийанкур, Франция', 'FRH');
/
INSERT INTO provider VALUES (7, 'Dealer', 'KIA', 'Сеул, Южная Корея', 'KOR');
/
INSERT INTO provider VALUES (8, 'Firm', 'Mansory', 'Мюнхен, Германия', 'DEU');
/
INSERT INTO provider VALUES (9, 'Firm', 'Hamann', 'Лаупхайм, Германия', 'DEU');
/
INSERT INTO provider VALUES (10, 'Firm', 'MTR Design', 'Тойота, Айти, Япония', 'JAP');
/
INSERT INTO provider VALUES (11, 'Workshop', 'M-Service', 'г. Новосибирск,', 'RUS');
/
INSERT INTO provider VALUES (12, 'Workshop', 'Авантаж', 'г. Москва, ул. Каменская 232', 'RUS');
/
INSERT INTO provider VALUES (13, 'Workshop', 'Авто-Дик', 'г. Санкт-Петербург, ул. Фрунзе 24', 'RUS');
/
INSERT INTO provider VALUES (14, 'Shop', 'Автомир', 'г. Новосибирск, ул. Богдана Хмельницкого 1/1', 'RUS');
/
INSERT INTO provider VALUES (15, 'Shop', 'Автотрейд', 'г. Барнаул, ул. Залесского 75', 'RUS');
/
INSERT INTO provider VALUES (16, 'Shop', 'Столица Запчастей', 'г. Москва, ул. Анодная 24', 'RUS');
/
INSERT INTO spare_part VALUES (1, 'Бампер передний', 'Оригинальный, окрашенный', 'ВАЗ 2114', 1);
/
INSERT INTO spare_part VALUES (2, 'Лобовое стекло', 'Оригинальное, с синей полоской', 'Лада Гранта 2014', 1);
/
INSERT INTO spare_part VALUES (3, 'Выхлопная система', 'Оригинальная, AMG-packet', 'MB W223', 2);
/
INSERT INTO spare_part VALUES (4, 'Фара левая передняя', 'Оригинальная, оптическая матричная', 'MB W223', 2);
/
INSERT INTO spare_part VALUES (5, 'Фара правая передняя', 'Оригинальная, оптическая матричная', 'MB W223', 2);
/
INSERT INTO spare_part VALUES (6, 'Решетка радиатора', 'Оригинальная, с сеткой от камней', 'BMW X5 2015', 3);
/
INSERT INTO spare_part VALUES (7, 'Заднее стекло', 'Оригинальное, с фиолетовым оттенком', 'BMW M8 2020', 3);
/
INSERT INTO spare_part VALUES (8, 'Ремень генератора', 'Для двигателя K24Z', 'Toyota Camry', 4);
/
INSERT INTO spare_part VALUES (9, 'Цепь привода ГРМ', 'Для двигателя R18A', 'Toyota Corolla', 4);
/
INSERT INTO spare_part VALUES (10, 'Ремень генератора', 'Для двигателя K24Z', 'Toyota Camry', 4);
/
INSERT INTO spare_part VALUES (11, 'Руль', 'Рулевое колесо кожаное с кнопками', 'Nissan Teana', 5);
/
INSERT INTO spare_part VALUES (12, 'Подсветка заднего номера', 'Оригинальная, хромированная', 'Nissan Patrol', 5);
/
INSERT INTO spare_part VALUES (13, 'Ручка двери', 'Передняя правая черная', 'Renault Logan', 6);
/
INSERT INTO spare_part VALUES (14, 'Ручка двери', 'Передняя левая черная', 'Renault Logan', 6);
/
INSERT INTO spare_part VALUES (15, 'Моторчик омывателя', 'Для переднего стекла зимний пакет', 'Kia Soul', 7);
/
INSERT INTO spare_part VALUES (16, 'Значок передний', 'Оригинальный', 'Kia Rio', 7);
/
INSERT INTO spare_part VALUES (17, 'Лампочка ксеноновая', '3000К 20 Вт', 'Любая', 8);
/
INSERT INTO spare_part VALUES (18, 'Лампочка светодиодная', '2000К 5 Вт', 'Любая', 8);
/
INSERT INTO spare_part VALUES (19, 'Болт нержавеющий', 'd = 18mm', 'Любая', 9);
/
INSERT INTO spare_part VALUES (20, 'Зажим пластиковый', 'd = 36mm', 'Любая', 9);
/
INSERT INTO spare_part VALUES (21, 'Колпаки для колес', 'Серебристые 205 55 R16', 'Любая', 10);
/
INSERT INTO spare_part VALUES (22, 'Колпаки для колес', 'Желтые 195 45 R15', 'Любая', 10);
/
INSERT INTO spare_part VALUES (23, 'Колпаки для колес', 'Черные 225 65 R18', 'Любая', 10);
/
INSERT INTO application_details VALUES (1, 2, 4000, 1, 1);
/
INSERT INTO application_details VALUES (2, 1, 20000, 2, 3);
/
INSERT INTO application_details VALUES (3, 3, 5000, 3, 2);
/
INSERT INTO application_details VALUES (4, 1, 7000, 3, 4);
/
INSERT INTO application_details VALUES (5, 2, 6700, 4, 5);
/
INSERT INTO application_details VALUES (6, 1, 25000, 5, 7);
/
INSERT INTO application_details VALUES (7, 2, 34000, 6, 8);
/
INSERT INTO application_details VALUES (8, 3, 2500, 7, 8);
/
INSERT INTO application_details VALUES (9, 3, 3799, 8, 9);
/
INSERT INTO application_details VALUES (10, 6, 3799, 8, 10);
/
INSERT INTO application_details VALUES (11, 3, 5599, 9, 11);
/
INSERT INTO application_details VALUES (12, 2, 6854, 10, 12);
/
INSERT INTO application_details VALUES (13, 5, 2258, 11, 13);
/
INSERT INTO application_details VALUES (14, 1, 8643, 11, 14);
/
INSERT INTO application_details VALUES (15, 1, 4784, 12, 15);
/
INSERT INTO cell VALUES (1, 1, 5000, 5);
/
INSERT INTO cell VALUES (2, 2, 12000, 7);
/
INSERT INTO cell VALUES (3, 3, 5000, 2);
/
INSERT INTO cell VALUES (4, 4, 7000, 1);
/
INSERT INTO cell VALUES (5, 5, 7000, 1);
/
INSERT INTO cell VALUES (6, 6, 24000, 1);
/
INSERT INTO cell VALUES (7, 7, 34000, 1);
/
INSERT INTO cell VALUES (8, 8, 2500, 2);
/
INSERT INTO cell VALUES (9, 9, 3000, 3);
/
INSERT INTO manufacturer_and_provider VALUES (1, 1);
/
INSERT INTO manufacturer_and_provider VALUES (2, 2);
/
INSERT INTO manufacturer_and_provider VALUES (3, 3);
/
INSERT INTO manufacturer_and_provider VALUES (4, 4);
/
INSERT INTO manufacturer_and_provider VALUES (5, 5);
/
INSERT INTO manufacturer_and_provider VALUES (6, 6);
/
INSERT INTO manufacturer_and_provider VALUES (7, 7);
/
INSERT INTO manufacturer_and_provider VALUES (2, 8);
/
INSERT INTO manufacturer_and_provider VALUES (3, 9);
/
INSERT INTO manufacturer_and_provider VALUES (4, 10);
/
INSERT INTO manufacturer_and_provider VALUES (8, 11);
/
INSERT INTO manufacturer_and_provider VALUES (9, 12);
/
INSERT INTO manufacturer_and_provider VALUES (10, 13);
/
INSERT INTO manufacturer_and_provider VALUES (1, 14);
/
INSERT INTO manufacturer_and_provider VALUES (1, 15);
/
INSERT INTO manufacturer_and_provider VALUES (1, 16);
/
INSERT INTO manufacturer_and_provider VALUES (2, 14);
/
INSERT INTO manufacturer_and_provider VALUES (2, 15);
/
INSERT INTO manufacturer_and_provider VALUES (2, 16);
/
INSERT INTO manufacturer_and_provider VALUES (3, 14);
/
INSERT INTO manufacturer_and_provider VALUES (3, 15);
/
INSERT INTO manufacturer_and_provider VALUES (4, 15);
/
INSERT INTO manufacturer_and_provider VALUES (5, 14);
/
INSERT INTO manufacturer_and_provider VALUES (6, 15);
/
INSERT INTO manufacturer_and_provider VALUES (7, 15);
/
INSERT INTO manufacturer_and_provider VALUES (7, 16);
/
INSERT INTO manufacturer_and_provider VALUES (8, 14);
/
INSERT INTO manufacturer_and_provider VALUES (8, 15);
/
INSERT INTO manufacturer_and_provider VALUES (8, 16);
/
INSERT INTO manufacturer_and_provider VALUES (9, 14);
/
INSERT INTO manufacturer_and_provider VALUES (9, 15);
/
INSERT INTO manufacturer_and_provider VALUES (9, 16);
/
INSERT INTO manufacturer_and_provider VALUES (10, 14);
/
INSERT INTO manufacturer_and_provider VALUES (10, 15);
/
INSERT INTO manufacturer_and_provider VALUES (10, 16);
/
INSERT INTO supply VALUES (1, 14, TO_DATE('05-02-2003', 'DD-MM-YYYY'), 0.05, 0);
/
INSERT INTO supply VALUES (2, 15, TO_DATE('07-02-2003', 'DD-MM-YYYY'), 0.05, 0);
/
INSERT INTO supply VALUES (3, 16, TO_DATE('08-02-2003', 'DD-MM-YYYY'), 0.05, 0);
/
INSERT INTO supply VALUES (4, 2, TO_DATE('12-02-2003', 'DD-MM-YYYY'), 0.20, 1);
/
INSERT INTO supply VALUES (5, 3, TO_DATE('13-02-2003', 'DD-MM-YYYY'), 0.20, 1);
/
INSERT INTO supply VALUES (6, 7, TO_DATE('26-02-2003', 'DD-MM-YYYY'), 0.10, 1);
/
INSERT INTO product VALUES (1, 1, 17, 4);
/
INSERT INTO product VALUES (2, 1, 18, 2);
/
INSERT INTO product VALUES (3, 2, 19, 1);
/
INSERT INTO product VALUES (4, 3, 21, 1);
/
INSERT INTO product VALUES (5, 3, 22, 1);
/
INSERT INTO supply_details VALUES (1, 17, 1500, 10, 0.05, '1 год');
/
INSERT INTO supply_details VALUES (1, 18, 300, 100, 0.05, '1 год');
/
INSERT INTO supply_details VALUES (2, 19, 20, 1000, 0, 'Нет');
/
INSERT INTO supply_details VALUES (3, 21, 2500, 40, 0.10, 'Нет');
/
INSERT INTO supply_details VALUES (3, 22, 2500, 8, 0.10, 'Нет');
/
INSERT INTO broken_product VALUES (1, 1, TO_DATE('25-06-2003', 'DD-MM-YYYY'), 1);
/
INSERT INTO orders_details VALUES (1, 1, 5000, 2, 1);
/
INSERT INTO orders_details VALUES (2, 4, 10000, 3, 2);
/