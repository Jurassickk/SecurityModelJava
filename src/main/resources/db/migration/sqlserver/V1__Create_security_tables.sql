-- V1__Create_security_tables.sql for SQL Server

-- User table
CREATE TABLE [user] (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(255) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL,
    active BIT DEFAULT 1,
    registration_date DATETIME2 DEFAULT GETDATE(),
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Person table
CREATE TABLE person (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    first_name NVARCHAR(255),
    last_name NVARCHAR(255),
    document_type NVARCHAR(50),
    document_number NVARCHAR(50) UNIQUE,
    phone_number NVARCHAR(50),
    gender NVARCHAR(20),
    active BIT DEFAULT 1,
    city_id NVARCHAR(50),
    user_id BIGINT UNIQUE,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (user_id) REFERENCES [user](id)
);

-- Role table
CREATE TABLE [role] (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) UNIQUE NOT NULL,
    description NTEXT,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Permission table
CREATE TABLE permission (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) UNIQUE NOT NULL,
    description NTEXT,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Module table
CREATE TABLE module (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) UNIQUE NOT NULL,
    description NTEXT,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Form table
CREATE TABLE form (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) UNIQUE NOT NULL,
    description NTEXT,
    url NVARCHAR(500),
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Form_Module junction table
CREATE TABLE form_module (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    form_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (form_id) REFERENCES form(id),
    FOREIGN KEY (module_id) REFERENCES module(id),
    CONSTRAINT unique_form_module UNIQUE (form_id, module_id)
);

-- Role_User junction table
CREATE TABLE role_user (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (role_id) REFERENCES [role](id),
    FOREIGN KEY (user_id) REFERENCES [user](id),
    CONSTRAINT unique_role_user UNIQUE (role_id, user_id)
);

-- Role_Module_Permission junction table
CREATE TABLE role_module_permission (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    module_id BIGINT NOT NULL,
    is_deleted BIT DEFAULT 0,
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2,
    FOREIGN KEY (role_id) REFERENCES [role](id),
    FOREIGN KEY (permission_id) REFERENCES permission(id),
    FOREIGN KEY (module_id) REFERENCES module(id),
    CONSTRAINT unique_role_module_permission UNIQUE (role_id, permission_id, module_id)
);