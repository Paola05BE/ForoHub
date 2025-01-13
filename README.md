
# Título principal
ForoHub - API REST para Gestión de Tópicos

# Descripción del Proyecto
"ForoHub es una API RESTful diseñada para gestionar tópicos en un foro. 
Permite realizar operaciones CRUD "
"(crear, leer, actualizar, eliminar) sobre los tópicos, con autenticación segura mediante JWT"
"Este proyecto fue desarrollado como parte del Alura Challenge Back End y tiene como objetivo facilitar la "
"gestión de temas dentro de un foro, brindando a los usuarios la posibilidad de interactuar con los tópicos."


# Descripción de las operaciones del proyecto

"- **Crear un nuevo tópico**: Permite crear un tópico.\n"
"- **Mostrar todos los tópicos creados**: Obtiene una lista de todos los tópicos almacenados en la base de datos.\n"
"- **Mostrar un tópico específico**: Permite ver la información detallada de un tópico.\n"
"- **Actualizar un tópico**: Modifica los detalles de un tópico existente.\n"
"- **Eliminar un tópico**: Elimina un tópico de la base de datos.\n\n"
"Además, cuenta con un sistema de autenticación con JWT para proteger el acceso a los servicios de la API."


# Ejemplos de Solicitudes en Insomnia
# Ejemplo 1: Registrar un Tópico
'Método: POST\nURL: http://localhost:8082/topicos'

'Cuerpo de la solicitud:\n'
'{\n'
'  "idUsuario": "",\n'
'  "mensaje": "",\n'
'  "nombreCurso": "",\n'
'  "titulo": "",\n'
'  "estado": ""\n'
'}'

# Ejemplo 2: Listar los Tópicos

'Método: GET\nURL: http://localhost:8082/topicos'
'Respuesta:\n'
'{\n'
'  "id": ,\n'
'  "idUsuario": "",\n'
'  "mensaje": "",\n'
'  "nombreCurso": "",\n'
'  "titulo": "",\n'
'  "estado": ""\n'
'}'

# Ejemplo 3: Editar un Tópico

'Método: PUT\nURL: http://localhost:8082/topicos/id'

'Cuerpo de la solicitud:\n'

'  "mensaje": "",\n'
'  "nombreCurso": "",\n'
'  "titulo": "",\n'
'  "estado": ""\n'

# Ejemplo 4: Obtener Datos de un Tópico
Método: GET\nURL: http://localhost:8082/topicos/10'

# Ejemplo 5: Login de Usuario
'Método: POST\nURL: http://localhost:8082/login'
'Cuerpo de la solicitud:\n'
'{\n'
'  "login": "",\n'
'  "clave": ""\n'
'}'



'Ejemplo respuesta Token:\n'
'{\n'

'  "jwTtoken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJmb3JvaHViIiwic3ViIjoic3BiZXRhbiIsImlkIjoxLCJleHAiOjE3MzY3Mjc3OTR9.DISNCjlXCFLRZisiC9thbPJwkKcrP0Y2-f54cLVHZdo"\n'
'}'

# Tecnologías Utilizadas
"Este proyecto utiliza las siguientes tecnologías:\n"
"- **Java 19**: Lenguaje de programación utilizado.\n"
"- **Spring Boot 3.4.1**: Framework para el desarrollo de aplicaciones Java basado en Spring.\n"
"- **MySQL**: Sistema de gestión de bases de datos utilizado para almacenar los tópicos.\n"
"- **Hibernate (JPA)**: Framework ORM para la gestión de las entidades y la base de datos.\n"
"- **Flyway**: Herramienta para la migración de bases de datos.\n"
"- **JWT (JSON Web Token)**: Método de autenticación y autorización para asegurar el acceso a los endpoints de la API.\n"
"- **Lombok**: Biblioteca que simplifica el código mediante la generación automática de métodos como `getter`, `setter`, `toString`, entre otros."


# Configuración del Entorno

"1. Clona el repositorio:"
"   ```bash\n"
    "   git clone https://github.com/Paola05BE/ForoHub.git\n"
    
"2. Configuración del archivo `application.properties`:
   En el archivo `application.properties`, configura los siguientes parámetros:


'''spring.application.name=API
server.port=8082

# Configuración de la base de datos
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORDF}

# Configuración de Hibernate
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql=trace
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true

# Configuración de Flyway
flyway.url=jdbc:mysql://localhost:3306/forohub?useSSL=false&serverTimezone=UTC
flyway. User=${DB_USERNAME}
flyway.password=${DB_PASSWORDF}
flyway.locations=classpath:db/migration

# Configuración de Flyway (alternativa)
spring.flyway.url=jdbc:mysql://localhost:3306/forohub
spring.flyway.user=${DB_USERNAME}
spring.flyway.password=${DB_PASSWORDF}

# Configuración de seguridad JWT
api.security.secret=${JWT_SECRET}


# Configuración de la base de datos

Crea una base de datos en MySQL llamada `forohub` y configura el acceso mediante las variables de entorno para `DB_USERNAME`, `DB_PASSWORDF` y `JWT_SECRET`


