SELECT orders.orders_id AS ID_Заказа,
       orders_date AS Дата,
       customer_id AS ID_Клиента,
       SUM(price) AS Сумма,
       orders.status AS Статус
FROM orders
         JOIN orders_details ON orders.orders_id = orders_details.orders_id
GROUP BY orders.orders_id, orders_date, customer_id, orders.status