CREATE TABLE customer (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    countryAndCity VARCHAR(50) NOT NULL,
    discount NUMBER(10)
);

CREATE TABLE provider (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL,
    countryAndCity VARCHAR(50) NOT NULL,
    discount NUMBER(10),
    rating NUMBER(10),
    documents VARCHAR(10),
    warranty VARCHAR(10)
);

CREATE TABLE product (
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price NUMBER(10) NOT NULL,
    isBroken VARCHAR(10),
    wasTaxes VARCHAR(10),
    provider_id NUMBER(10),
    FOREIGN KEY (provider_id) REFERENCES provider
);

CREATE TABLE customer_order (
    id NUMBER(10) PRIMARY KEY,
    customer_id NUMBER(10) NOT NULL,
    product_id NUMBER(10) NOT NULL,
    wishPrice NUMBER(10),
    FOREIGN KEY (customer_id) REFERENCES customer,
    FOREIGN KEY (product_id) REFERENCES provider
);

CREATE TABLE provider_offer (
    id NUMBER(10) PRIMARY KEY,
    product_id NUMBER(10) NOT NULL,
    provider_id NUMBER(10) NOT NULL,
    price NUMBER(10),
    FOREIGN KEY (product_id) REFERENCES product,
    FOREIGN KEY (provider_id) REFERENCES provider
);

CREATE SEQUENCE sq_customer
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE SEQUENCE sq_provider
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE SEQUENCE sq_product
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE SEQUENCE sq_customer_order
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

CREATE SEQUENCE sq_provider_offer
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;