README - API REST para COMPANY
Requisitos previos
- Java JDK 17
- MySQL (con XAMPP)
- Maven
- Base de datos "ada_prueba" ya creada con las tablas de las actividades 2 y 3 de la prueba las tablas deben estar creadas y tener datos (como se hizo en el procedimiento almacenado de la actividad 3) Especialmente la tabla company debe contener registros para que la API funcione correctamente

Pasos para ejecutar
1. Abrir el proyecto en VS Code:
Abrir la carpeta del proyecto en VS Code

2. Verificar configuración:
Asegurarse que el archivo application.properties tenga:

spring.datasource.url=jdbc:mysql://localhost:3306/ada_prueba
spring.datasource.username=root
spring.datasource.password=

3. Ejecutar la aplicación:
Abrir terminal en VS Code (Ctrl + Ñ)
Ejecutar:

mvn spring-boot:run

Esperar hasta ver: "Tomcat started on port 8080"

4. Probar la API:
Abrir navegador y visitar:
http://localhost:8080/api/companies (listar todas las compañías)
http://localhost:8080/api/companies/by-codigo/COMP001 (método especial)
