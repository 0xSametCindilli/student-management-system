[🇹🇷 Türkçe](README_TR.md) | 🇬🇧 English
# Student Management System

A simple console-based student management system developed with Java, Spring Boot, Spring Data JPA and MySQL.

This project was created as a first Spring Boot project to practice database operations, CRUD operations, service-repository architecture and working with JPA.

## Features

* Add a student
* List all students
* Search for a student by ID
* Update student information
* Delete a student
* Store student information in MySQL
* Automatic ID generation
* Console-based menu system

## Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Project Structure

The project is currently kept simple because it is a learning project.

```text
src/main/java/com/samet/studentmanagement/
│
├── StudentManagementSystemApplication.java
├── Student.java
├── StudentRepository.java
├── StudentService.java
└── StudentMenu.java
```

### Student.java

Represents the student entity and contains:

* ID
* First name
* Last name
* Email

### StudentRepository.java

Handles database operations through Spring Data JPA.

### StudentService.java

Contains the CRUD operations and acts as the service layer between the menu and repository.

### StudentMenu.java

Contains the console menu and gets user input.

### StudentManagementSystemApplication.java

Starts the Spring Boot application.

---

# Requirements

Before running the project, make sure these are installed:

* Java JDK 17 or later
* MySQL Server
* MySQL Workbench (optional but recommended)
* IntelliJ IDEA or another Java IDE
* Maven (usually included with IntelliJ/Spring projects)

## 1. Install MySQL

Install MySQL Server on your computer.

During installation, create a MySQL user and password.

The project does not require the database tables to be created manually because Hibernate can create/update the table structure automatically.

## 2. Create the database

Open MySQL Workbench and connect to your MySQL server.

Run:

```sql
CREATE DATABASE student_management_system;
```

Then select it:

```sql
USE student_management_system;
```

You can check that it exists with:

```sql
SHOW DATABASES;
```

You do not need to create the `student` table manually.

Hibernate will create/update it from the `Student` entity.

---

# Database Configuration

The project uses environment variables so that personal database credentials are not stored directly in the project.

`application.properties`:

```properties
spring.application.name=student-management-system

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

You need to define these environment variables on your computer:

```text
DB_URL=jdbc:mysql://localhost:3306/student_management_system
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

Replace `your_mysql_password` with your own MySQL password.

Do not upload your real password to GitHub.

---

# Running the Project

After installing the requirements and creating the database:

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Make sure the MySQL server is running.
4. Set the required database environment variables.
5. Wait for Maven to download the dependencies.
6. Run:

```text
StudentManagementSystemApplication.java
```

When the application starts successfully, the console menu will appear.

---

# Console Menu

The application provides the following options:

```text
========================================
       STUDENT MANAGEMENT SYSTEM
========================================
1 -> Add Student
2 -> List Students
3 -> Search Student
4 -> Update Student
5 -> Delete Student
0 -> Exit
========================================
Select an option:
```

## 1 - Add Student

The program asks for:

```text
First Name:
Last Name:
Email:
```

A new student is created and saved to MySQL.

The ID is generated automatically by the database.

## 2 - List Students

Displays all students currently stored in the database.

Example:

```text
ID         : 1
First Name : Samet
Last Name  : Cindilli
Email      : samet@example.com
----------------------------------------
```

## 3 - Search Student

Asks for the student's ID and displays the student's information.

If the ID does not exist:

```text
Student not found.
```

## 4 - Update Student

Asks for the ID of the student to update and then requests the new:

* First name
* Last name
* Email

The existing record is updated in MySQL.

## 5 - Delete Student

Asks for the student's ID and removes the record from the database.

## 0 - Exit

Closes the console menu and exits the application.

---

# Database Table

The database table is generated from the `Student` entity.

The structure is approximately:

```text
student
├── id
├── first_name
├── last_name
└── email
```

The `id` column is automatically generated.

The Java fields are mapped to database columns using JPA annotations.

Example:

```java
@Column(name = "first_name")
private String firstName;
```

---

# Important Notes

The project uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

This allows Hibernate to automatically create and update the database table structure based on the entity.

The project is intended as a simple learning project, so the application currently uses a console interface instead of a web interface.

There is no authentication or authorization system.

There is no frontend.

There is no REST API yet.

These features can be added later as the project grows.

---

# Troubleshooting

## Database connection error

Check:

* Is MySQL Server running?
* Is `student_management_system` created?
* Is `DB_URL` correct?
* Is `DB_USERNAME` correct?
* Is `DB_PASSWORD` correct?

The default connection URL used by the project is:

```text
jdbc:mysql://localhost:3306/student_management_system
```

## Table does not exist

Make sure:

```properties
spring.jpa.hibernate.ddl-auto=update
```

is present and that the application can connect to MySQL.

## Application does not start

Check the console output and make sure:

* Java version is correct
* Maven dependencies are downloaded
* MySQL Server is running
* Database credentials are correct

---

# What I Learned From This Project

This project was built to practice the basics of Spring Boot and database development.

Main topics used in the project:

* Spring Boot
* Dependency Injection
* `@Component`
* `@Service`
* `@Entity`
* `@Id`
* `@GeneratedValue`
* `@Column`
* Spring Data JPA
* `JpaRepository`
* CRUD operations
* MySQL connection
* Hibernate
* Console input with `Scanner`
* Service and Repository layers

This project is kept intentionally simple as a first step before moving to REST APIs, web interfaces and more advanced Spring Boot features.
