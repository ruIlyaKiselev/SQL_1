SELECT manufacturer.manufacturer_id AS ID_Производителя,
       manufacturer.name AS Название,
       COUNT(M.MANUFACTURER_ID) AS Представляет
FROM manufacturer INNER JOIN MANUFACTURER_AND_PROVIDER M on MANUFACTURER.MANUFACTURER_ID = M.MANUFACTURER_ID
GROUP BY manufacturer.manufacturer_id, manufacturer.name