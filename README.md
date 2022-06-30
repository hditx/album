#Proyecto Album
Es un microservicio que permite consultar datos de una API externa
y generar permisos para albums a los distintos usuarios.
---
##Tecnologia
El proyecto esta desarrollado con:
* Spring Boot
* Mysql
* Gradle gestor de dependecias

##Requisitos
Para poder ejecutar el programa se requiere las siguientes herramientas
instaladas:
* Java 11
* Mysql
* Gradle

En caso de no reemplazar el usuario y contrasenia del application.properties
correr el script _**createUser.sql**_ de SQL que se encuentra en
**resource/script**
##Documentacion
Para saber como funcionan los endpoint y los que tiene acceder al swagger
a traves de la URL **localhost:8080/swagger-ui.html**
