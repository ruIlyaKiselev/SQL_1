SELECT orders.orders_id AS ID_заказа,
       orders_date AS Дата_заказа,
       customer_id AS ID_клиента,
       SUM(quantity) AS Количество,
       SUM(price) AS Цена
FROM orders INNER JOIN ORDERS_DETAILS OD on ORDERS.ORDERS_ID = OD.ORDERS_ID
GROUP BY orders.orders_id, orders_date, customer_id