SELECT supply.supply_id AS ID_поставки,
       provider_id AS ID_поставщика,
       supply_date AS Дата_поставки,
       price AS Цена,
       quantity Количество
FROM supply INNER JOIN SUPPLY_DETAILS SD on SUPPLY.SUPPLY_ID = SD.SUPPLY_ID
GROUP BY supply.supply_id, provider_id, supply_date, price, quantity