SELECT customer.customer_id AS ID_Клиента,
       first_name AS Имя,
       second_name AS Фамилия,
       third_name AS Отчество,
       city AS Город,
       address AS Адрес,
       post_index AS Индекс,
       COUNT(application_id) AS Число_Заявок,
       COUNT(orders_id) AS Число_Заказов
FROM customer
    FULL JOIN APPLICATION A2 on CUSTOMER.CUSTOMER_ID = A2.CUSTOMER_ID
    FULL OUTER JOIN ORDERS O on CUSTOMER.CUSTOMER_ID = O.CUSTOMER_ID
GROUP BY customer.customer_id, first_name, second_name, third_name, city, address, post_index