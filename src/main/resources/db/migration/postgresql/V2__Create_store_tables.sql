-- V2__Create_store_tables.sql for PostgreSQL

-- Category table
CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_category_updated_at BEFORE UPDATE ON category
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Customer table
CREATE TABLE customer (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(50),
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_customer_updated_at BEFORE UPDATE ON customer
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Supplier table
CREATE TABLE supplier (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255),
    phone VARCHAR(50),
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_supplier_updated_at BEFORE UPDATE ON supplier
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Product table
CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2),
    stock INTEGER,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_product_updated_at BEFORE UPDATE ON product
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Order table
CREATE TABLE "order" (
    id BIGSERIAL PRIMARY KEY,
    order_date TIMESTAMP,
    total_amount DECIMAL(10,2),
    status VARCHAR(50),
    customer_id BIGINT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TRIGGER update_order_updated_at BEFORE UPDATE ON "order"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Order_Item table
CREATE TABLE order_item (
    id BIGSERIAL PRIMARY KEY,
    quantity INTEGER,
    unit_price DECIMAL(10,2),
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES "order"(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TRIGGER update_order_item_updated_at BEFORE UPDATE ON order_item
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Product_Category junction table
CREATE TABLE product_category (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    UNIQUE(product_id, category_id)
);

CREATE TRIGGER update_product_category_updated_at BEFORE UPDATE ON product_category
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Product_Supplier junction table
CREATE TABLE product_supplier (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    supplier_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    UNIQUE(product_id, supplier_id)
);

CREATE TRIGGER update_product_supplier_updated_at BEFORE UPDATE ON product_supplier
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();