# Hotel Reservation System

This is a demo project for a Hotel Reservation System built using Spring Boot. The project includes REST, SOAP, GraphQL, and gRPC services for managing hotel reservations.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [gRPC Services](#grpc-services)
- [GraphQL Services](#graphql-services)
- [SOAP Services](#soap-services)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, update, retrieve, and delete hotel reservations.
- RESTful API for managing reservations.
- SOAP web services for managing reservations.
- GraphQL API for managing reservations.
- gRPC services for managing reservations.

## Technologies Used

- Java 21
- Spring Boot 3.4.0
- Spring Data JPA
- Spring Web
- Spring Web Services
- Spring GraphQL
- gRPC
- MySQL
- Lombok
- Maven


## Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/hotel-reservation.git
   cd hotel-reservation

## Set up the MySQL database:



   CREATE DATABASE hotel_reservation;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON hotel_reservation.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
## Update the src/main/resources/application.properties file with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_reservation
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update


mvn clean install


mvn spring-boot:run

## API Endpoints
## REST API
**POST** /api/reservations: Create a new reservation.
**GET** /api/reservations/{id}: Retrieve a reservation by ID.
**PUT** /api/reservations/{id}: Update a reservation by ID.
**DELETE** /api/reservations/{id}: Delete a reservation by ID.
### gRPC Services
**CreateReservation(CreateReservationRequest):** Create a new reservation.
**GetReservation(GetReservationRequest):** Retrieve a reservation by ID.
**UpdateReservation(UpdateReservationRequest):** Update a reservation by ID.
**DeleteReservation(DeleteReservationRequest):** Delete a reservation by ID.
### GraphQL Services
**mutation createReservation(clientName:** String, startDate: Date, **endDate: Date, roomPreferences: String):** Create a new reservation.
**query getReservation(id: Long):** Retrieve a reservation by ID.
**mutation updateReservation(id: Long, clientName: String, startDate:** Date, endDate: Date, roomPreferences: String): Update a reservation by ID.
**mutation deleteReservation(id: Long):** Delete a reservation by ID.
SOAP Services
**CreateReservation(CreateReservationRequest):** Create a new reservation.
**GetReservation(GetReservationRequest):** Retrieve a reservation by ID.
**UpdateReservation(UpdateReservationRequest):** Update a reservation by ID.
**DeleteReservation(DeleteReservationRequest):** Delete a reservation by ID.
### Contributing
Contributions are welcome! Please fork the repository and submit a pull request.


This README file provides an overview of your project, including its features, technologies used, project structure, installation instructions, and API endpoints. Adjust the content as needed to fit your specific project details.