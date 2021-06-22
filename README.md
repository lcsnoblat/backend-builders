# Builders Backend Api

[Spring Boot]: https://spring.io/projects/spring-boot

## Features

* Provides a CRUD for Users

## Supported versions

"orika-spring-boot-starter" supports the following versions.  
Other versions might also work, but we have not tested it.

* Java 11, 15
* Spring Boot 2.4.0

## Usage

### Docker-compose

Assuming you changed the application.properties file to call the local docker generated mongo db you should be able to just run 
(by default it is using a cloud mongo db option)
```
docker-compose build
```

and then 

```
docker-compose up
```



### Swagger

You can see the endpoints in our swagger interface when running the project

```
localhost:8080/swagger-ui.html
```
