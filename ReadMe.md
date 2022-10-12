# Parking lot
Java Spring + H2 project
## Requirements

---
For building adn running the application you need:
* [JDK 8](https://www.oracle.com/java/technologies/downloads/#java8)
* [MAVEN 3](https://maven.apache.org/)

## Running the application locally

---

The are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the project class from your IDE.

Alternatively you can use Maven plugin like:
```
mvn spring-boot:run
```

## About the Service

---

The service is just a simple parking lot review REST service. It uses an in-memory database (H2) to store the data.

Database have 3 tables which  interaction of program<br>
Main table is `DATE_AND_PRICE` contains information about prices for places and rental time.

The owners car __name__ u can see in table `CARS`
