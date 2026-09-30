# Help Desk Ticket Management System

A RESTful backend application built using Java and Spring Boot to manage employees, support agents, and help desk tickets.

## Features

* Employee management
* Support agent management
* Ticket management
* Ticket status management
* Ticket priority management
* Filter tickets by status
* Filter tickets by priority
* Input validation
* Global exception handling
* MySQL database integration
* REST APIs tested using Postman

## Technologies Used

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Postman
* Git & GitHub

## Project Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL Database
```

### Main Packages

```text
controller/
service/
repository/
entity/
dto/
enums/
exception/
```

## Main Entities

### Employee

Stores employee information such as:

* ID
* Name
* Email
* Department

### Support Agent

Stores support agent information such as:

* ID
* Name
* Email
* Specialization

### Ticket

Stores support ticket information such as:

* ID
* Title
* Description
* Status
* Priority
* Employee
* Support Agent

## Ticket Status

```text
OPEN
IN_PROGRESS
RESOLVED
CLOSED
```

## Ticket Priority

```text
LOW
MEDIUM
HIGH
```

## API Endpoints

### Employee APIs

| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| POST   | `/api/employees`      | Create employee    |
| GET    | `/api/employees`      | Get all employees  |
| GET    | `/api/employees/{id}` | Get employee by ID |
| PUT    | `/api/employees/{id}` | Update employee    |
| DELETE | `/api/employees/{id}` | Delete employee    |

### Support Agent APIs

| Method | Endpoint                   | Description             |
| ------ | -------------------------- | ----------------------- |
| POST   | `/api/support-agents`      | Create support agent    |
| GET    | `/api/support-agents`      | Get all support agents  |
| GET    | `/api/support-agents/{id}` | Get support agent by ID |
| PUT    | `/api/support-agents/{id}` | Update support agent    |
| DELETE | `/api/support-agents/{id}` | Delete support agent    |

### Ticket APIs

| Method | Endpoint                           | Description                |
| ------ | ---------------------------------- | -------------------------- |
| POST   | `/api/tickets`                     | Create ticket              |
| GET    | `/api/tickets`                     | Get all tickets            |
| GET    | `/api/tickets/{id}`                | Get ticket by ID           |
| PUT    | `/api/tickets/{id}`                | Update ticket              |
| DELETE | `/api/tickets/{id}`                | Delete ticket              |
| GET    | `/api/tickets/status/{status}`     | Filter tickets by status   |
| GET    | `/api/tickets/priority/{priority}` | Filter tickets by priority |

## Validation and Exception Handling

The application uses Jakarta Bean Validation to validate incoming request data.

Examples:

* Required fields cannot be blank.
* Required IDs cannot be null.
* Invalid employee, support-agent, or ticket IDs return a `404 Not Found` response.

A global exception handler provides clean error responses.

## Database

The application uses MySQL with Spring Data JPA and Hibernate.

The database schema is automatically managed using Hibernate's JPA configuration.

## How to Run

### Prerequisites

Install:

* Java 21
* Maven
* MySQL
* Git

### Steps

1. Clone the repository.

2. Create a MySQL database:

```sql
CREATE DATABASE helpdesk_db;
```

3. Create your local `application.properties` file under:

```text
src/main/resources/application.properties
```

4. Configure your MySQL username and password.

5. Run the application:

```bash
mvn spring-boot:run
```

6. The application runs on:

```text
http://localhost:8080
```

## Testing

REST APIs were tested using Postman.

CRUD operations and ticket filtering were tested for successful and invalid requests.

## Future Enhancements

* Authentication and authorization using Spring Security
* JWT-based login
* Ticket search
* Pagination and sorting
* Email notifications
* Dashboard and reporting
* Docker deployment

## Author

Talari Devika
