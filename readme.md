# Spring demo
This is a super simple interface-less CRUD application to demonstrate a few common tasks/patterns in Spring.

This project uses Spring Boot, Spring Web, and Spring Data JPA.

For now it uses an in-memory H2 database, so anyone can get up and running.

It uses Lombok to generate getters/setters/constructors

## Instructions
1) Clone the repository
2) Install Maven dependencies (`mvn compile`)
3) Start the app (either build + run or use Spring Boot's Maven plugin (`org.springframework.boot:spring-boot-maven-plugin:2.3.0.RELEASE:run`))
4) Go to [/h2-console](https://localhost:8080/h2-console)
   * click 'Connect' (there is no password) to view the database
5) Go to [/update-models](https://localhost:8080/update-models)
	* notice that some of the `Book` records have their `author_id` updated
6) Go to [/author?lastName=hemingway](https://localhost:8080/author?lastName=hemingway)
	* notice that the `books` property has values
7) Go to [/book?title=farewell](https://localhost:8080/book?title=farewell)
	* notice that the `author` property has value