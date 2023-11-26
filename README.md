# Active_MQ_Spring


This repository contains a basic Employee Management System implemented using Spring Boot with CRUD operations and ActiveMQ integration.

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

Make sure you have the following installed on your machine:

- Java Development Kit (JDK)
- Apache Maven
- ActiveMQ (for messaging)

### Installing

1. Clone the repository:

    ```bash
    git clone https://github.com/subhajit-1/Active_MQ_Spring.git
    ```

2. Navigate to the project directory:

    ```bash
    cd Active_MQ_Spring
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

### Running the Application

1. Start ActiveMQ:

    Make sure ActiveMQ is running. You can download it [here](http://activemq.apache.org/components/classic/download/).

2. Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

The application will be accessible at `http://localhost:8080`.

## Usage

- Access the Employee Management System through the provided RESTful APIs.

  Example API endpoints:

  - Get all employees: `GET http://localhost:8080/employees`
  - Get an employee by ID: `GET http://localhost:8080/employees/{id}`
  - Create a new employee: `POST http://localhost:8080/employees`
  - Update an existing employee: `PUT http://localhost:8080/employees/{id}`
  - Delete an employee: `DELETE http://localhost:8080/employees/{id}`

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for creating Java-based enterprise applications.
- [ActiveMQ](http://activemq.apache.org/) - Message broker for messaging communication.

## Authors

- SUBHAJIT DAS 


