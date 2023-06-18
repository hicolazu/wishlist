# **Wishlist API**

## **Description**
This is a simple API to manage a wishlist\
Designed with [Clean Architecture](https://helpdev.com.br/2020/05/21/descomplicando-a-clean-architecture/)

## **Requirements**
* [Java 17](https://jdk.java.net/17/)
* [Docker](https://docs.docker.com/get-docker/)
* [Docker Compose 1.9.0+](https://docs.docker.com/compose/install/)

## **Running local**
To setup the local environment, run the following command:

```docker-compose up -d```

It will start the following services:
* [MongoDB](http://localhost:27017/)
* [Mongo Express](http://localhost:8081/)

## **Setup IDE**
Setup VM options with property **-Dspring.profiles.active=local**

## **Swagger**
* [Swagger](http://localhost:8080/swagger-ui/index.html)

## **Postman**
To test the API with Postman, import the following collection:
https://api.postman.com/collections/15714649-0da82f21-46c3-4d70-a4e3-f5b77c95fe5a?access_key=PMAT-01H37TKZ1ZNT6RVA30YTGR94BQ

## **Tests**
This application is tested with [TestContainers](https://www.testcontainers.org/)