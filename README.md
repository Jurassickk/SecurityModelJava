# SecurityModel - Multi-Database Modular Application

A Spring Boot application implementing a modular security model with hexagonal architecture, supporting multiple databases (PostgreSQL, MySQL, SQL Server) using Flyway for database migrations.

## Features

- **Modular Architecture**: Security and Store modules with clean separation of concerns
- **Hexagonal Architecture**: Domain-driven design with clear boundaries
- **Multi-Database Support**: PostgreSQL, MySQL, and SQL Server
- **Database Migrations**: Flyway-powered migrations for each database
- **JWT Authentication**: Secure authentication with JWT tokens
- **Docker Support**: Easy database setup with Docker Compose

## Project Structure

```
src/main/java/com/example/
├── SecurityModelApplication.java
├── security/                    # Security module
│   ├── application/
│   │   ├── dto/
│   │   ├── mapper/
│   │   └── service/
│   ├── domain/
│   │   ├── entity/
│   │   └── repository/
│   └── infrastructure/
│       ├── config/
│       ├── controller/
│       ├── exception/
│       └── security/
└── store/                       # Store module
    ├── application/
    │   ├── dto/
    │   ├── mapper/
    │   └── service/
    ├── domain/
    │   ├── entity/
    │   └── repository/
    └── infrastructure/
        └── controller/
```

## Database Setup

### Using Docker Compose

1. **PostgreSQL**:
   ```bash
   docker-compose -f docker-compose.postgresql.yml up -d
   ```

2. **MySQL**:
   ```bash
   docker-compose -f docker-compose.mysql.yml up -d
   ```

3. **SQL Server**:
   ```bash
   docker-compose -f docker-compose.sqlserver.yml up -d
   ```

### Application Profiles

Run the application with different database profiles:

```bash
# PostgreSQL (default)
mvn spring-boot:run

# MySQL
mvn spring-boot:run -Dspring-boot.run.profiles=mysql

# SQL Server
mvn spring-boot:run -Dspring-boot.run.profiles=sqlserver
```

## Database Configuration

Each profile has its own configuration:

- **PostgreSQL**: `application-postgresql.properties`
- **MySQL**: `application-mysql.properties`
- **SQL Server**: `application-sqlserver.properties`

## Migrations

Flyway migrations are organized by database type:

```
src/main/resources/db/migration/
├── postgresql/
│   ├── V1__Create_security_tables.sql
│   └── V2__Create_store_tables.sql
├── mysql/
│   ├── V1__Create_security_tables.sql
│   └── V2__Create_store_tables.sql
└── sqlserver/
    ├── V1__Create_security_tables.sql
    └── V2__Create_store_tables.sql
```

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### Security Module
- `GET /api/roles` - Get all roles
- `GET /api/permissions` - Get all permissions
- `GET /api/modules` - Get all modules
- `GET /api/users` - Get all users

### Store Module
- `GET /api/categories` - Get all categories
- `GET /api/products` - Get all products
- `GET /api/customers` - Get all customers
- `GET /api/orders` - Get all orders
- `GET /api/suppliers` - Get all suppliers

## Technologies Used

- **Spring Boot 3.4.0**
- **Java 17**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **Flyway**
- **PostgreSQL**
- **MySQL**
- **SQL Server**
- **Docker & Docker Compose**
- **Lombok**
- **OpenAPI/Swagger**

## Building and Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SecurityModelJava
   ```

2. **Start your preferred database**
   ```bash
   # Choose one:
   docker-compose -f docker-compose.postgresql.yml up -d
   docker-compose -f docker-compose.mysql.yml up -d
   docker-compose -f docker-compose.sqlserver.yml up -d
   ```

3. **Run the application**
   ```bash
   mvn clean install
   mvn spring-boot:run -Dspring-boot.run.profiles=<postgresql|mysql|sqlserver>
   ```

4. **Access the application**
   - API: http://localhost:8081
   - Swagger UI: http://localhost:8081/swagger-ui.html

## Database Isolation

Each database instance is completely independent:
- Data stored in PostgreSQL is not visible in MySQL or SQL Server
- Separate schemas and migration scripts for each database
- Profile-based configuration ensures clean separation

## Development

### Adding New Migrations

1. Create migration files in the appropriate database folder
2. Follow Flyway naming convention: `V{version}__{description}.sql`
3. Test migrations on all supported databases

### Adding New Entities

1. Create entity in the appropriate module (`security` or `store`)
2. Extend `BaseEntity` for audit fields
3. Create corresponding migration scripts for all databases
4. Update DTOs, mappers, and services as needed

## Contributing

1. Follow the existing modular structure
2. Ensure database compatibility across all supported databases
3. Add appropriate tests
4. Update documentation

## License

This project is licensed under the MIT License.