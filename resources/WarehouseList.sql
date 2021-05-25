SELECT cell_id AS ID_ячейки,
       cell.spare_part_id AS ID_запчисти,
       name AS Запчасть,
       auto_model AS Модель,
       quantity AS Количество
FROM cell INNER JOIN spare_part sp on sp.spare_part_id = cell.spare_part_id
GROUP BY cell_id, cell.spare_part_id, name, auto_model, quantity