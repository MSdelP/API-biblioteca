1. Introducción
Este proyecto muestra un ejemplo completo de:
•	Spring Boot 3.4.5 para la capa de aplicación.
•	Spring Data JPA (Hibernate) para el acceso a datos.
•	Base de datos H2 en memoria.
•	Endpoints REST para crear, leer, actualizar y eliminar entidades Author, Category y Book.
________________________________________
2. Requisitos previos
•	Java 21 instalado y configurado en JAVA_HOME.
•	Git (si se clona desde un repositorio).
•	No se requiere instalar Maven globalmente: incluye Maven Wrapper (mvnw, mvnw.cmd).
________________________________________
3. Estructura del proyecto
demo/                   ← raíz del proyecto
├── mvnw                ← wrapper de Maven para Unix
├── mvnw.cmd            ← wrapper de Maven para Windows
├── pom.xml             ← configuración de Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/library/
│   │   │       ├── entity/        ← entidades JPA
│   │   │       │   ├ Author.java
│   │   │       │   ├ Category.java
│   │   │       │   └ Book.java
│   │   │       ├── repository/    ← repositorios Spring Data
│   │   │       │   ├ AuthorRepository.java
│   │   │       │   ├ CategoryRepository.java
│   │   │       │   └ BookRepository.java
│   │   │       └── controller/    ← controladores REST
│   │   │           ├ AuthorController.java
│   │   │           ├ CategoryController.java
│   │   │           └ BookController.java
│   │   └── resources/
│   │       └── application.properties  ← configuración de BD
│   └── test/           ← pruebas (opcional)
└── target/             ← artefactos compilados
    ├ demo-0.0.1-SNAPSHOT.jar
    └ demo-0.0.1-SNAPSHOT.jar.original
________________________________________
4. Configuración
Edita src/main/resources/application.properties si deseas cambiar la configuración de la base de datos:
spring.datasource.url=jdbc:h2:mem:librarydb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
________________________________________
5. Compilación y ejecución
Desde la carpeta raíz (demo/) ejecuta:
En Windows

.\mvnw.cmd clean package .
.\mvnw.cmd spring-boot:run

### En Linux/macOS
```bash
./mvnw clean package
./mvnw spring-boot:run
Al arrancar, verás en consola:
Started LibraryApplication in X.XXX seconds
La API estará disponible en http://localhost:8080.
________________________________________
6. Endpoints disponibles
Entidad	Método	URL	Descripción
Author	GET	/api/authors	Listar todos
Author	GET	/api/authors/{id}	Buscar por ID
Author	POST	/api/authors	Crear nuevo
Author	PUT	/api/authors/{id}	Actualizar existente
Author	DELETE	/api/authors/{id}	Eliminar por ID
Category	GET	/api/categories	Listar todas
Category	GET	/api/categories/{id}	Buscar por ID
Category	POST	/api/categories	Crear nueva
Category	PUT	/api/categories/{id}	Actualizar existente
Category	DELETE	/api/categories/{id}	Eliminar por ID
Book	GET	/api/books	Listar todos
Book	GET	/api/books/{id}	Buscar por ID
Book	POST	/api/books	Crear nuevo
Book	PUT	/api/books/{id}	Actualizar existente
Book	DELETE	/api/books/{id}	Eliminar por ID
Puedes usar cURL, Postman o Insomnia para probarlos.
________________________________________
7. Consola H2 (opcional)
1.	Abre: http://localhost:8080/h2-console
2.	Formulario:
o	JDBC URL: jdbc:h2:mem:librarydb
o	User: sa
o	Password: (vacío)
3.	Conéctate y ejecuta consultas SQL (p.ej. SELECT * FROM BOOK;).
