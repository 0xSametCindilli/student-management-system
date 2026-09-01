# 🆕 Updates in the New Version

In this version, the project has been migrated from the previous **console-based structure to a REST API architecture**.

In the previous version, CRUD operations for students were performed through the console. In the new version, these operations are performed through a **REST API using HTTP requests**.

## 🌐 REST API Added

REST API support has been added to the project by introducing the `StudentRestController` class.

### API Endpoints

| HTTP Method | Endpoint | Description |
|------------|----------|-------------|
| GET | `/api/students` | Retrieves all students |
| GET | `/api/students/{id}` | Retrieves a student by ID |
| POST | `/api/students` | Creates a new student |
| PUT | `/api/students/{id}` | Updates student information |
| DELETE | `/api/students/{id}` | Deletes a student |

Student operations can now be performed using **API testing tools such as Postman** or through a **frontend application**.

## 🏗️ Improved Layered Architecture

The project structure has been improved and moved to a more **organized, maintainable, and scalable architecture**.

The basic structure is:

```text
Entity
   ↓
Repository
   ↓
Service
   ↓
REST Controller