SELECT broken_product.product_id AS ID_Продукта,
       return_date AS Дата_возврата,
       broken_product.quantity AS Количество,
       supply_id AS ID_Поставки,
       P.spare_part_id AS ID_Запчасти,
       SP.name AS Запчасть,
       C2.cell_id AS ID_Ячейки
FROM broken_product
    INNER JOIN PRODUCT P on P.PRODUCT_ID = BROKEN_PRODUCT.PRODUCT_ID
    INNER JOIN SPARE_PART SP on SP.SPARE_PART_ID = P.SPARE_PART_ID
    INNER JOIN CELL C2 on BROKEN_PRODUCT.QUANTITY = C2.QUANTITY
GROUP BY broken_product.product_id, return_date, broken_product.quantity, supply_id, P.spare_part_id, SP.name, C2.cell_id