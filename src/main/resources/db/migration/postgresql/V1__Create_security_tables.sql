-- V1__Create_security_tables.sql for PostgreSQL

-- Create base entity columns function (for audit fields)
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- User table
CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_user_updated_at BEFORE UPDATE ON "user"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Person table
CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    document_type VARCHAR(50),
    document_number VARCHAR(50) UNIQUE,
    phone_number VARCHAR(50),
    gender VARCHAR(20),
    active BOOLEAN DEFAULT TRUE,
    city_id VARCHAR(50),
    user_id BIGINT UNIQUE,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES "user"(id)
);

CREATE TRIGGER update_person_updated_at BEFORE UPDATE ON person
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Role table
CREATE TABLE "role" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_role_updated_at BEFORE UPDATE ON "role"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Permission table
CREATE TABLE permission (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_permission_updated_at BEFORE UPDATE ON permission
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Module table
CREATE TABLE module (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_module_updated_at BEFORE UPDATE ON module
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Form table
CREATE TABLE form (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    url VARCHAR(500),
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TRIGGER update_form_updated_at BEFORE UPDATE ON form
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Form_Module junction table
CREATE TABLE "form_module" (
    id BIGSERIAL PRIMARY KEY,
    form_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (form_id) REFERENCES form(id),
    FOREIGN KEY (module_id) REFERENCES module(id),
    UNIQUE(form_id, module_id)
);

CREATE TRIGGER update_form_module_updated_at BEFORE UPDATE ON "form_module"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Role_User junction table
CREATE TABLE "role_user" (
    id BIGSERIAL PRIMARY KEY,
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES "role"(id),
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    UNIQUE(role_id, user_id)
);

CREATE TRIGGER update_role_user_updated_at BEFORE UPDATE ON "role_user"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();

-- Role_Module_Permission junction table
CREATE TABLE "role_module_permission" (
    id BIGSERIAL PRIMARY KEY,
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES "role"(id),
    FOREIGN KEY (permission_id) REFERENCES permission(id),
    FOREIGN KEY (module_id) REFERENCES module(id),
    UNIQUE(role_id, permission_id, module_id)
);

CREATE TRIGGER update_role_module_permission_updated_at BEFORE UPDATE ON "role_module_permission"
    FOR EACH ROW EXECUTE FUNCTION update_updated_at_column();