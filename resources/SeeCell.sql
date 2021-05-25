SELECT cell_id AS ID_ячейки,
       cell.spare_part_id AS ID_запчисти,
       SP.name AS Запчасть,
       auto_model AS Модель,
       quantity AS Количество
FROM cell INNER JOIN SPARE_PART SP on SP.SPARE_PART_ID = CELL.SPARE_PART_ID
WHERE CELL_ID = :CELL_ID
GROUP BY cell_id, cell.spare_part_id, SP.name, auto_model, quantity