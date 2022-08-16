CREATE TABLE customer_tbl (
  id CHAR(36) NOT NULL,
   modify_by VARCHAR(255),
   modify_time TIMESTAMP WITHOUT TIME ZONE,
   create_by VARCHAR(255),
   create_time TIMESTAMP WITHOUT TIME ZONE,
   version VARCHAR(255),
   name VARCHAR(255),
   ic_no VARCHAR(255),
   email VARCHAR(255),
   address VARCHAR(255),
   CONSTRAINT pk_customer_tbl PRIMARY KEY (id)
);