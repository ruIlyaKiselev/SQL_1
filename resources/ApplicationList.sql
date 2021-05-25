SELECT application.application_id AS ID_заявки,
       application_date AS Дата_заявки,
       customer_id AS ID_клиента,
       SUM(quantity) AS Количество,
       SUM(max_price) AS Цена
FROM application INNER JOIN APPLICATION_DETAILS AD on APPLICATION.APPLICATION_ID = AD.APPLICATION_ID
GROUP BY application.application_id, application_date, customer_id