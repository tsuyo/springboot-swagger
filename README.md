# Spring Boot 2.0 + Swagger Template

This repository consists of the following 3 template modules implemented by spring boot 2.0 with swagger. The codes are based on [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) from Spring Guides.

## 1. springboot-swagger-server-descriptive
A descriptive (spring code to swagger api) RESTful Web Service: This is almost the same as the original spring guides code, but with swagger-ui. You can check API documentation in http://localhost:8080/swagger-ui.html

Terminal 1
```
$ cd springboot-swagger-server-descriptive
$ mvn clean package
$ java -jar target/springboot-swagger-server-descriptive-*.jar
```
Terminal 2
```
$ curl http://localhost:8080/greeting?name=tsuyo
{"id":1,"content":"Hello, tsuyo!"}
$ curl http://localhost:8080/swagger-ui.html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Swagger UI</title>
...  
```

## 2. springboot-swagger-server-prescriptive
A prescriptive (swagger api to spring code) RESTful Web Service: The swagger api/model are automatically generated from swagger yaml file. The spring boot application is written based on these api/model. The generated codes are included within the application code tree (target/generated-sources) and you might need to "Reimport" (Right click a project -> Maven -> Reimport) on IntelliJ IDEA to recognize these files.

Terminal 1
```
$ cd springboot-swagger-server-prescriptive
$ mvn clean package
$ java -jar target/springboot-swagger-server-prescriptive-*.jar
```
Terminal 2
```
$ curl http://localhost:8080/greeting?name=tsuyo
{"content":"Hello, tsuyo!","id":1}
$ curl http://localhost:8080/swagger-ui.html
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Swagger UI</title>
```

## 3. springboot-swagger-client
A client of these RESTful Web Service: For demonstration purpose, this time I separate a swagger-generated module from an application module. You can choose whichever style you like (integrating app and generated codes into one source tree vs separating app codes from generated ones). You need to launch either of the above servers to try this client.

```
$ ./generate.sh # generate swagger api/model
[main] INFO io.swagger.parser.Swagger20Parser - reading from ./swagger.json
...
$ mvn clean install
$ netstat -na | grep 8080 # check if a server is up and running
tcp46      0      0  *.8080                 *.*                    LISTEN
$ java -jar springboot-swagger-client-app/target/springboot-swagger-client-app-*.jar
...
class Greeting {
    content: Hello, tsuyo!
    id: 2
}
...
```
