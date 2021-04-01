CREATE TABLE country (
    country_id VARCHAR2(3) PRIMARY KEY,
    name VARCHAR2(10) NOT NULL
);
/
CREATE TABLE abstract_provider (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    name VARCHAR2(30) NOT NULL,
    address VARCHAR2(50) NOT NULL,
    country_id VARCHAR2(3) NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country,
    CONSTRAINT abstract_provider_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE provider (
    provider_id NUMBER(10) PRIMARY KEY,
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider
);
/
CREATE TABLE little_dealer (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider,
    CONSTRAINT little_dealer_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE shop (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider,
    CONSTRAINT shop_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE dealer (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    contract VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider,
    CONSTRAINT dealer_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE abstract_provider_adapter (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider,
    CONSTRAINT abstract_provider_adapter_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE little_factory (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider_adapter,
    CONSTRAINT little_factory_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE firm (
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    contract VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider_adapter,
    CONSTRAINT firm_pk PRIMARY KEY (abstract_provider_id, category)
);
/
CREATE TABLE manufacturer (
    manufacturer_id NUMBER(10) PRIMARY KEY,
    abstract_provider_id NUMBER(10) NOT NULL,
    category VARCHAR2(20) NOT NULL,
    FOREIGN KEY (abstract_provider_id, category) REFERENCES abstract_provider_adapter
);
/
CREATE TABLE spare_part (
    spare_part_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    description VARCHAR2(50),
    auto_model VARCHAR2(20),
    manufacturer_id NUMBER(10) NOT NULL,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer
);
/
CREATE TABLE cell (
    cell_id NUMBER(10) PRIMARY KEY,
    spare_part_id NUMBER(10) NOT NULL,
    price NUMBER(10) NOT NULL,
    quantity NUMBER(10) NOT NULL,
    FOREIGN KEY (spare_part_id) REFERENCES spare_part
);
/
CREATE TABLE customer (
    customer_id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(20) NOT NULL,
    second_name VARCHAR2(20) NOT NULL,
    third_name VARCHAR2(20)
);
/
CREATE TABLE customer_order (
    customer_order_id NUMBER(10) PRIMARY KEY,
    order_date DATE NOT NULL,
    customer_id NUMBER(10) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer
);
/
CREATE TABLE customer_application (
    customer_application_id NUMBER(10) PRIMARY KEY,
    application_date DATE NOT NULL,
    customer_id NUMBER(10) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer
);
/
CREATE TABLE application_details (
    application_details_id NUMBER(10) PRIMARY KEY,
    quantity NUMBER(10) NOT NULL,
    customer_application_id NUMBER(10) NOT NULL,
    spare_part_id NUMBER(10) NOT NULL,
    FOREIGN KEY (customer_application_id) REFERENCES customer_application,
    FOREIGN KEY (spare_part_id) REFERENCES spare_part
);
/
CREATE TABLE abstract_supply (
    abstract_supply_id NUMBER(10) NOT NULL,
    provider_id NUMBER(10) NOT NULL,
    supply_date DATE NOT NULL,
    taxes NUMBER(10) NOT NULL,
    FOREIGN KEY (provider_id) REFERENCES provider,
    CONSTRAINT abstract_supply_pk PRIMARY KEY (abstract_supply_id, provider_id)
);
CREATE TABLE supply (
    supply_id NUMBER(10) PRIMARY KEY,
    abstract_supply_id NUMBER(10) NOT NULL,
    provider_id NUMBER(10) NOT NULL,
    FOREIGN KEY (abstract_supply_id, provider_id) REFERENCES abstract_supply
)
/
CREATE TABLE supply_details (
    supply_id NUMBER(10) NOT NULL,
    spare_part_id NUMBER(10) NOT NULL,
    price NUMBER(10) NOT NULL,
    quantity NUMBER(10) NOT NULL,
    discount NUMBER(10) NOT NULL,
    warranty VARCHAR2(20) NOT NULL,
    FOREIGN KEY (supply_id) REFERENCES supply,
    FOREIGN KEY (spare_part_id) REFERENCES spare_part,
    CONSTRAINT supply_details_pk PRIMARY KEY (supply_id, spare_part_id)
)
/
CREATE TABLE contract (
    contract_id NUMBER(10) PRIMARY KEY,
    supply_id NUMBER(10) NOT NULL,
    provider_id NUMBER(10) NOT NULL,
    FOREIGN KEY (supply_id, provider_id) REFERENCES abstract_supply
);
/
CREATE TABLE product (
    product_id NUMBER(10) PRIMARY KEY,
    supply_id NUMBER(10) NOT NULL,
    spare_part_id NUMBER(10) NOT NULL,
    FOREIGN KEY (supply_id, spare_part_id) REFERENCES supply_details
);
/
CREATE TABLE broken_product (
    broken_product_id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    return_date DATE NOT NULL,
    quantity NUMBER(10) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product
);
/
CREATE TABLE order_details (
    order_details_id NUMBER(10) PRIMARY KEY,
    quantity NUMBER(10) NOT NULL,
    order_id NUMBER(10) NOT NULL,
    product_id NUMBER(10) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES customer_order,
    FOREIGN KEY (product_id) REFERENCES product
);
/
CREATE SEQUENCE sq_country
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_country
before INSERT
ON country
FOR each row
BEGIN
  SELECT sq_country.nextval
  INTO :new.country_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_abstract_provider
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_abstract_provider
before INSERT
ON abstract_provider
FOR each row
BEGIN
  SELECT sq_abstract_provider.nextval
  INTO :new.abstract_provider_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_provider
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_provider
before INSERT
ON provider
FOR each row
BEGIN
  SELECT sq_provider.nextval
  INTO :new.provider_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_manufacturer
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_manufacturer
before INSERT
ON manufacturer
FOR each row
BEGIN
  SELECT sq_manufacturer.nextval
  INTO :new.manufacturer_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_spare_part
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_spare_part
before INSERT
ON spare_part
FOR each row
BEGIN
  SELECT sq_spare_part.nextval
  INTO :new.spare_part_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_cell
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_cell
before INSERT
ON cell
FOR each row
BEGIN
  SELECT sq_cell.nextval
  INTO :new.cell_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_customer
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_customer
before INSERT
ON customer
FOR each row
BEGIN
  SELECT sq_customer.nextval
  INTO :new.customer_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_customer_order
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_customer_order
before INSERT
ON customer_order
FOR each row
BEGIN
  SELECT sq_customer_order.nextval
  INTO :new.customer_order_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_customer_application
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_customer_application
before INSERT
ON customer_application
FOR each row
BEGIN
  SELECT sq_customer_application.nextval
  INTO :new.customer_application_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_application_details
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_application_details
before INSERT
ON application_details
FOR each row
BEGIN
  SELECT sq_application_details.nextval
  INTO :new.application_details_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_abstract_supply
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_abstract_supply
before INSERT
ON abstract_supply
FOR each row
BEGIN
  SELECT sq_abstract_supply.nextval
  INTO :new.abstract_supply_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_supply
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_supply
before INSERT
ON supply
FOR each row
BEGIN
  SELECT sq_supply.nextval
  INTO :new.supply_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_contract
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_contract
before INSERT
ON contract
FOR each row
BEGIN
  SELECT sq_contract.nextval
  INTO :new.contract_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_product
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_product
before INSERT
ON product
FOR each row
BEGIN
  SELECT sq_product.nextval
  INTO :new.product_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_broken_product
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_broken_product
before INSERT
ON broken_product
FOR each row
BEGIN
  SELECT sq_broken_product.nextval
  INTO :new.broken_product_id
  FROM dual;
END;
/
CREATE SEQUENCE sq_order_details
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
/
CREATE OR REPLACE TRIGGER tr_auto_increment_order_details
before INSERT
ON order_details
FOR each row
BEGIN
  SELECT sq_order_details.nextval
  INTO :new.order_details_id
  FROM dual;
END;
/