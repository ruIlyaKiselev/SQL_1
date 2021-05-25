CREATE TABLE country (
  country_id VARCHAR2(3) NOT NULL,
  name VARCHAR2(50) NOT NULL,
  taxes INTEGER NOT NULL,
  PRIMARY KEY (country_id)
);
/
CREATE TABLE customer (
  customer_id NUMBER NOT NULL,
  first_name VARCHAR2(50) NOT NULL,
  second_name VARCHAR2(50) NOT NULL,
  third_name VARCHAR2(50) DEFAULT NULL,
  city VARCHAR2(50) DEFAULT NULL,
  address VARCHAR2(50) DEFAULT NULL,
  post_index INTEGER DEFAULT NULL,
  PRIMARY KEY (customer_id)
);
/
CREATE TABLE manufacturer (
  manufacturer_id INTEGER NOT NULL,
  name VARCHAR2(50) NOT NULL,
  PRIMARY KEY (manufacturer_id)
);
/
CREATE TABLE shop_info (
  warehouse_cells_limit INTEGER NOT NULL,
  users_count INTEGER NOT NULL, clients_count NUMBER NOT NULL
);
/
CREATE TABLE application (
  application_id INTEGER NOT NULL,
  application_date DATE NOT NULL,
  customer_id INTEGER NOT NULL,
  PRIMARY KEY (application_id),
  CONSTRAINT application_constraint_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);
/
CREATE TABLE orders (
  orders_id INTEGER NOT NULL,
  orders_date DATE NOT NULL,
  customer_id INTEGER NOT NULL,
  status VARCHAR2(50) NOT NULL,
  PRIMARY KEY (orders_id),
  CONSTRAINT orders_constraint_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);
/
CREATE TABLE provider (
  provider_id NUMBER NOT NULL,
  category VARCHAR2(20) NOT NULL,
  name VARCHAR2(50) NOT NULL,
  address VARCHAR2(100) DEFAULT NULL,
  country_id VARCHAR2(3) DEFAULT NULL,
  PRIMARY KEY (provider_id),
  CONSTRAINT provider_constraint_1 FOREIGN KEY (country_id) REFERENCES country (country_id)
);
/
CREATE TABLE spare_part (
  spare_part_id INTEGER NOT NULL,
  name VARCHAR2(50) NOT NULL,
  description VARCHAR2(100) DEFAULT NULL,
  auto_model VARCHAR2(50) DEFAULT NULL,
  manufacturer_id INTEGER DEFAULT NULL,
  PRIMARY KEY (spare_part_id),
  CONSTRAINT spare_part_constraint_1 FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (manufacturer_id)
);
/
CREATE TABLE application_details (
  application_details_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL,
  max_price BINARY_DOUBLE DEFAULT NULL,
  application_id INTEGER NOT NULL,
  spare_part_id INTEGER NOT NULL,
  PRIMARY KEY (application_details_id),
  CONSTRAINT applic_details_constraint_1 FOREIGN KEY (application_id) REFERENCES application (application_id),
  CONSTRAINT applic_details_constraint_2 FOREIGN KEY (spare_part_id) REFERENCES spare_part (spare_part_id)
);
/
CREATE TABLE cell (
  cell_id INTEGER NOT NULL,
  spare_part_id INTEGER NOT NULL,
  price BINARY_DOUBLE NOT NULL,
  quantity INTEGER NOT NULL,
  PRIMARY KEY (cell_id),
  CONSTRAINT cell_constraint_1 FOREIGN KEY (spare_part_id) REFERENCES spare_part (spare_part_id)
);
/
CREATE TABLE manufacturer_and_provider (
  manufacturer_id NUMBER NOT NULL,
  provider_id NUMBER NOT NULL,
  PRIMARY KEY (
    manufacturer_id, provider_id
  ),
  CONSTRAINT man_and_prov_constraint_1 FOREIGN KEY (manufacturer_id) REFERENCES manufacturer (manufacturer_id),
  CONSTRAINT man_and_prov_constraint_2 FOREIGN KEY (provider_id) REFERENCES provider (provider_id)
);
/
CREATE TABLE supply (
  supply_id INTEGER NOT NULL,
  provider_id INTEGER NOT NULL,
  supply_date DATE NOT NULL,
  taxes BINARY_DOUBLE NOT NULL,
  contract INTEGER NOT NULL,
  PRIMARY KEY (supply_id),
  CONSTRAINT supply_constraint_1 FOREIGN KEY (provider_id) REFERENCES provider (provider_id)
);
/
CREATE TABLE product (
  product_id INTEGER NOT NULL,
  supply_id INTEGER NOT NULL,
  spare_part_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL,
  PRIMARY KEY (product_id),
  CONSTRAINT product_constraint_1 FOREIGN KEY (supply_id) REFERENCES supply (supply_id),
  CONSTRAINT product_constraint_2 FOREIGN KEY (spare_part_id) REFERENCES spare_part (spare_part_id)
);
/
CREATE TABLE supply_details (
  supply_id INTEGER NOT NULL,
  spare_part_id INTEGER NOT NULL,
  price BINARY_DOUBLE NOT NULL,
  quantity INTEGER NOT NULL,
  discount BINARY_DOUBLE DEFAULT NULL,
  warranty VARCHAR2(50) DEFAULT NULL,
  PRIMARY KEY (supply_id, spare_part_id),
  CONSTRAINT supp_det_constraint_1 FOREIGN KEY (supply_id) REFERENCES supply (supply_id),
  CONSTRAINT supp_det_constraint_2 FOREIGN KEY (spare_part_id) REFERENCES spare_part (spare_part_id)
);
/
CREATE TABLE broken_product (
  broken_product_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  return_date DATE NOT NULL,
  quantity INTEGER NOT NULL,
  PRIMARY KEY (broken_product_id),
  CONSTRAINT brok_prod_constraint_1 FOREIGN KEY (product_id) REFERENCES product (product_id)
);
/
CREATE TABLE orders_details (
  orders_details_id INTEGER NOT NULL,
  quantity INTEGER NOT NULL,
  price BINARY_DOUBLE NOT NULL,
  orders_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  PRIMARY KEY (orders_details_id),
  CONSTRAINT ord_deta_constraint_1 FOREIGN KEY (orders_id) REFERENCES orders (orders_id),
  CONSTRAINT ord_deta_constraint_2 FOREIGN KEY (product_id) REFERENCES product (product_id)
);
/