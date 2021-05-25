SELECT spare_part_id AS ID_Запчасти,
       spare_part.name AS Название,
       description AS Описание,
       auto_model AS Модель,
       M.name AS Производитель
FROM spare_part INNER JOIN MANUFACTURER M on M.MANUFACTURER_ID = SPARE_PART.MANUFACTURER_ID
GROUP BY spare_part_id, spare_part.name, description, auto_model, M.name