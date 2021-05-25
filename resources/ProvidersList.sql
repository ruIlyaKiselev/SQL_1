SELECT provider.provider_id AS ID_Поставщика,
       provider.category AS Категория,
       provider.name AS Название,
       address AS Адрес,
       country_id AS Код_Страны,
       COUNT(M.PROVIDER_ID) AS Представительсв
FROM provider INNER JOIN MANUFACTURER_AND_PROVIDER M on PROVIDER.PROVIDER_ID = M.PROVIDER_ID
GROUP BY provider.provider_id, provider.category, provider.name, address, country_id