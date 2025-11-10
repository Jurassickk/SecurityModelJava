# Configuración Simple de Base de Datos con Perfiles

## 🎯 **Solución Final: Perfiles de Spring**

**Solo cambias el perfil para elegir la base de datos:**

### PostgreSQL (Base de datos principal)
```bash
# PostgreSQL (postgres) - BASE PRINCIPAL
mvnw.cmd spring-boot:run
```

### MySQL
```bash
# Cambiar a MySQL
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=mysql
```

### SQL Server
```bash
# Cambiar a SQL Server
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=sqlserver
```

## 📋 **Perfiles Disponibles**

| Perfil | Base de Datos | Comando |
|--------|---------------|---------|
| `postgresql` | PostgreSQL (postgres) | `mvnw.cmd spring-boot:run` |
| `mysql` | MySQL | `mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=mysql` |
| `sqlserver` | SQL Server | `mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=sqlserver` |


## 🎉 **Ventajas**

✅ **Súper dinámico** - Solo cambias el perfil
✅ **Sin archivos duplicados** - Configuración limpia
✅ **Funciona para todas las bases de datos** - PostgreSQL, MySQL, SQL Server
✅ **Migraciones automáticas** - Flyway se adapta automáticamente
✅ **Compilación perfecta** - Sin errores