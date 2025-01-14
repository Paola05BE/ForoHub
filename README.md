<h1 align="center">ForoHub - API REST para Gestión de Tópicos</h1>

<p>¡Hola! Bienvenidos al proyecto ForoHub, una API RESTful que permite gestionar tópicos en un foro. Este proyecto fue desarrollado como parte del Alura Challenge Back End, y su objetivo principal es facilitar la administración de temas dentro de un foro, brindando a los usuarios la posibilidad de interactuar con los tópicos de manera eficiente y segura. Todo esto con autenticación mediante JWT para proteger el acceso.</p>

<h2>Descripción del Proyecto</h2>

<p>ForoHub permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los tópicos, de una manera sencilla y clara. Este es un sistema pensado para quienes necesitan administrar múltiples tópicos, realizar interacciones dentro de un foro, y ofrecer seguridad en el acceso a los servicios.</p>

<h3>Operaciones disponibles en el proyecto:</h3>

<ul>
    <li><strong>Crear un nuevo tópico:</strong> Permite agregar un tópico al foro.</li>
    <li><strong>Mostrar todos los tópicos:</strong> Obtiene una lista completa de todos los tópicos almacenados.</li>
    <li><strong>Mostrar un tópico específico:</strong> Permite ver la información detallada de un tópico.</li>
    <li><strong>Actualizar un tópico:</strong> Modifica los detalles de un tópico existente.</li>
    <li><strong>Eliminar un tópico:</strong> Permite eliminar un tópico del sistema.</li>
</ul>

<p>Además, cuenta con un sistema de autenticación utilizando JWT para garantizar la seguridad en las interacciones con la API.</p>

<h2>Ejemplos de Solicitudes en Insomnia</h2>

<h3>1: Registrar un Tópico</h3>
<p><strong>Método:</strong> POST</p>
<p><strong>URL:</strong> http://localhost:8082/topicos</p>
<p><strong>Cuerpo de la solicitud:</strong></p>
<pre>
{
    "idUsuario": "32",
    "mensaje": "",
    "nombreCurso": "",
    "titulo": "",
    "estado": ""
}
</pre>

<h3>2: Listar los Tópicos</h3>
<p><strong>Método:</strong> GET</p>
<p><strong>URL:</strong> http://localhost:8082/topicos</p>
<p><strong>Respuesta:</strong></p>
<pre>
{
    "content": [
        {
            "id": 1,
            "idUsuario": "32",
            "mensaje": "",
            "nombreCurso": "",
            "titulo": "",
            "estado": ""
        }
    ]
}
</pre>

<h3>3: Editar un Tópico</h3>
<p><strong>Método:</strong> PUT</p>
<p><strong>URL:</strong> http://localhost:8082/topicos/{id}</p>
<p><strong>Cuerpo de la solicitud:</strong></p>
<pre>
{
    "mensaje": "",
    "nombreCurso": "",
    "titulo": "",
    "estado": ""
}
</pre>

<h3>4: Obtener Datos de un Tópico</h3>
<p><strong>Método:</strong> GET</p>
<p><strong>URL:</strong> http://localhost:8082/topicos/{id}</p>

<h3>5: Eliminar un Tópico</h3>
<p><strong>Método:</strong> DELETE</p>
<p><strong>URL:</strong> http://localhost:8082/topicos/{id}</p>

<h3>6: Login de Usuario</h3>
<p><strong>Método:</strong> POST</p>
<p><strong>URL:</strong> http://localhost:8082/login</p>
<p><strong>Cuerpo de la solicitud:</strong></p>
<pre>
{
    "login": "usuario",
    "clave": "contraseña"
}
</pre>
<p><strong>Ejemplo respuesta Token:</strong></p>
<pre>
{
    "jwTtoken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJmb3JvaHViIiwic3ViIjoic3BiZXRhbiIsImlkIjoxLCJleHAiOjE3MzY3Mjc3OTR9.DISNCjlXCFLRZisiC9thbPJwkKcrP0Y2-f54cLVHZdo"
}
</pre>

<h2>Tecnologías Utilizadas</h2>

<p>Este proyecto fue desarrollado utilizando las siguientes tecnologías:</p>
<ul>
    <li><strong>Java 19</strong>: Lenguaje de programación utilizado.</li>
    <li><strong>Spring Boot 3.4.1</strong>: Framework para el desarrollo de aplicaciones Java basado en Spring.</li>
    <li><strong>MySQL</strong>: Sistema de gestión de bases de datos utilizado para almacenar los tópicos.</li>
    <li><strong>Hibernate (JPA)</strong>: Framework ORM para la gestión de las entidades y la base de datos.</li>
    <li><strong>Flyway</strong>: Herramienta para la migración de bases de datos.</li>
    <li><strong>JWT (JSON Web Token)</strong>: Método de autenticación y autorización para asegurar el acceso a los endpoints de la API.</li>
    <li><strong>Lombok</strong>: Biblioteca que simplifica el código mediante la generación automática de métodos como `getter`, `setter`, `toString`, entre otros.</li>
</ul>

<h2>Configuración del Entorno</h2>

<p>Para comenzar a usar el proyecto, sigue estos pasos:</p>
<ol>
    <li><strong>Clona el repositorio:</strong>
        <pre>git clone https://github.com/Paola05BE/ForoHub.git</pre>
    </li>
    <li><strong>Configura el archivo <code>application.properties</code>:</strong>
        En el archivo <code>application.properties</code>, configura los siguientes parámetros:
        <pre>
spring.application.name=API
server.port=8082

# Configuración de la base de datos
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORDF}

# Configuración de Flyway
flyway.url=jdbc:mysql://localhost:3306/forohub?useSSL=false&serverTimezone=UTC
flyway.user=${DB_USERNAME}
flyway.password=${DB_PASSWORDF}
spring.flyway.url=jdbc:mysql://localhost:3306/forohub
spring.flyway.user=${DB_USERNAME}
spring.flyway.password=${DB_PASSWORDF}

# Configuración de seguridad JWT
api.security.secret=${JWT_SECRET}
</pre>
</li>
</ol>

<p>Recuerda crear una base de datos llamada <code>forohub</code> en MySQL y configura las variables de entorno para <code>DB_USERNAME</code>, <code>DB_PASSWORDF</code> y <code>JWT_SECRET</code>.</p>

<h2>Estado del Proyecto</h2>

<p>El proyecto está completamente funcional. Actualmente se encuentra en fase de desarrollo con posible mejoras más adelante.</p>

<h2 id="personas-desarrolladores">Personas Desarrolladoras del Proyecto</h2>

<ul>
    <li><strong>Paola Betancourth</strong> - Desarrolladora principal.</li>
</ul>

<h2>Conclusión</h2>

<p>ForoHub es una API  para la gestión de tópicos en foros. Gracias al uso de Spring Boot y JWT, ofrece una solución eficiente y fácil de configurar. ¡Espero que este proyecto sea útil para ti y que lo disfrutes tanto como yo disfruté desarrollándolo!</p>
