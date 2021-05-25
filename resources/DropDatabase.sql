ALTER TABLE application DROP CONSTRAINT application_customer_id_customer_customer_id_foreign;
/
ALTER TABLE order DROP CONSTRAINT order_customer_id_customer_customer_id_foreign;
/
ALTER TABLE provider DROP CONSTRAINT abstract_provider_country_id_country_country_id_foreign;
/
ALTER TABLE spare_part DROP CONSTRAINT spare_part_manufacturer_id_manufacturer_manufacturer_id_foreign;
/
ALTER TABLE application_details DROP CONSTRAINT application_details_application_id_application_application_id_foreign;
/
ALTER TABLE application_details DROP CONSTRAINT application_details_spare_part_id_spare_part_spare_part_id_foreign;
/
ALTER TABLE cell DROP CONSTRAINT cell_spare_part_id_spare_part_spare_part_id_foreign;
/
ALTER TABLE manufacturer_and_provider DROP CONSTRAINT manufacturer_and_provider_manufacturer_id_manufacturer_manufacturer_id_foreign;
/
ALTER TABLE manufacturer_and_provider DROP CONSTRAINT manufacturer_and_provider_provider_id_provider_provider_id_foreign;
/
ALTER TABLE supply DROP CONSTRAINT supply_provider_id_provider_provider_id_foreign;
/
ALTER TABLE product DROP CONSTRAINT product_supply_id_supply_supply_id_foreign;
/
ALTER TABLE product DROP CONSTRAINT product_spare_part_id_spare_part_spare_part_id_foreign;
/
ALTER TABLE supply_details DROP CONSTRAINT supply_details_supply_id_supply_supply_id_foreign;
/
ALTER TABLE supply_details DROP CONSTRAINT supply_details_spare_part_id_spare_part_spare_part_id_foreign;
/
ALTER TABLE broken_product DROP CONSTRAINT broken_product_product_id_product_product_id_foreign;
/
ALTER TABLE order_details DROP CONSTRAINT order_details_order_id_order_order_id_foreign;
/
ALTER TABLE order_details DROP CONSTRAINT order_details_product_id_product_product_id_foreign;
/
DROP TABLE order_details;
/
DROP TABLE broken_product;
/
DROP TABLE supply_details;
/
DROP TABLE product;
/
DROP TABLE supply;
/
DROP TABLE manufacturer_and_provider;
/
DROP TABLE cell;
/
DROP TABLE application_details;
/
DROP TABLE spare_part;
/
DROP TABLE provider;
/
DROP TABLE orders;
/
DROP TABLE application;
/
DROP TABLE manufacturer;
/
DROP TABLE customer;
/
DROP TABLE country;
/
DROP TABLE shop_info;
/