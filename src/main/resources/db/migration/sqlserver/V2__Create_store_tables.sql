-- V2__Create_store_tables.sql for SQL Server

-- Category table
CREATE TABLE category (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NTEXT,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Customer table
CREATE TABLE customer (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    first_name NVARCHAR(255),
    last_name NVARCHAR(255),
    email NVARCHAR(255) UNIQUE,
    phone NVARCHAR(50),
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Supplier table
CREATE TABLE supplier (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    contact_email NVARCHAR(255),
    phone NVARCHAR(50),
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Product table
CREATE TABLE product (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NTEXT,
    price DECIMAL(10,2),
    stock INTEGER,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Order table
CREATE TABLE [order] (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    order_date DATETIME2,
    total_amount DECIMAL(10,2),
    status NVARCHAR(50),
    customer_id BIGINT,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- Order_Item table
CREATE TABLE order_item (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    quantity INTEGER,
    unit_price DECIMAL(10,2),
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (order_id) REFERENCES [order](id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Product_Category junction table
CREATE TABLE product_category (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT unique_product_category UNIQUE (product_id, category_id)
);

-- Product_Supplier junction table
CREATE TABLE product_supplier (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    product_id BIGINT NOT NULL,
    supplier_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    CONSTRAINT unique_product_supplier UNIQUE (product_id, supplier_id)
);