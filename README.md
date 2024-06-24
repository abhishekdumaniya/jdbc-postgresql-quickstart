# JDBC PostgreSQL Quickstart

This repository contains a basic project demonstrating how to use JDBC with PostgreSQL and Maven for managing dependencies.

## Project Structure

- **src/main/java/org/example**: Contains the Java source files.
- **src/main/resources**: Contains configuration files, if any.
- **pom.xml**: Maven configuration file.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6.0 or higher
- PostgreSQL 10 or higher

## Setup

### Database

1. Install PostgreSQL if it is not already installed.
2. Create a new database:
    ```sql
    CREATE DATABASE employeeDetails;
    ```
3. Create a table for demonstration:
    ```sql
    CREATE TABLE employee (
        empid integer PRIMARY KEY,
        empname text NOT NULL,
        empcity text NOT NULL,
        empstate text NOT NULL,
        empphoneno text NOT NULL,
        empsalary integer NOT NULL,
    );
    ```
4. Insert some sample data:
    ```sql
    INSERT INTO employee VALUES (12, 'John', 'Earth', 'Space', '789.......', 120000);
    ```

### Configuration

1. Update the database connection details in the `src/main/resources/database.properties` file:
    ```properties
    jdbc.url=jdbc:postgresql://localhost:5432/jdbc_example
    jdbc.username=your_username
    jdbc.password=your_password
    ```

### Maven

1. Navigate to the project directory and run the following command to install the dependencies:
    ```sh
    mvn clean install
    ```

## Running the Project

1. Run the `Employee.java` file to execute the project:
    ```sh
    mvn exec:java -Dexec.EmployeeClass="com.example.Employee"
    ```

## Dependencies

- PostgreSQL JDBC Driver
- Maven

These dependencies are managed through the `pom.xml` file:
```xml
<dependencies>
     <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
      </dependency>
</dependencies>
