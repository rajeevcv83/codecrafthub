**CodeCraftHub** is a simple personalized learning platform designed for developers to track courses they want to learn. Built with Java and Spring Boot, it provides a RESTful API to manage course data without the complexity of databases, storing all data in a JSON file instead. This project is ideal for beginners to learn REST API fundamentals and file-based data persistence.

### Features
- Create, Read, Update, and Delete (CRUD) operations for courses.
- Stores course data in a JSON file (`courses.json`) automatically created if it doesn’t exist.
- Each course tracks:
    - `id` (auto-generated integer starting from 1)
    - `name` (required)
    - `description` (required)
    - `targetDate` (required, format `YYYY-MM-DD`)
    - `status` (required; must be one of: "Not Started", "In Progress", "Completed")
    - `createdAt` (auto-generated timestamp)
- Proper validation and error handling for missing fields, invalid statuses, course not found, and file read/write errors.
- Beginner-friendly code with helpful comments.

---

## Installation Instructions

### Prerequisites
- Java JDK 17 or higher installed ([Download](https://adoptium.net/))
- Maven installed ([Download](https://maven.apache.org/install.html))
- Git (optional, for cloning repository)

### Clone the repository (optional)
```bash
git clone https://github.com/yourusername/codecrafthub.git
cd codecrafthub
Build the project
Run the following command in the project root directory to download dependencies and build the application:

mvn clean install
How to Run the Application
Run the Spring Boot application using Maven:

mvn spring-boot:run
Alternatively, run the generated jar file (after building):

java -jar target/codecrafthub-0.0.1-SNAPSHOT.jar
By default, the app runs on port
8080
. You can access the API at:

http://localhost:8080/api/courses
API Endpoint Documentation
All endpoints are prefixed with
/api/courses
.

1. Get All Courses
Request:
GET /api/courses

Response:
Returns a JSON array of all courses.

Example Response:

[
  {
    "id": 1,
    "name": "Spring Boot Basics",
    "description": "Learn the basics of Spring Boot.",
    "targetDate": "2024-07-31",
    "status": "Not Started",
    "createdAt": "2024-06-01T12:00:00"
  }
]
2. Get a Course by ID
Request:
GET /api/courses/{id}

Replace
{id}
with the course ID (integer).

Response:
Returns the course JSON object or 404 if not found.

3. Create a New Course
Request:
POST /api/courses

Content-Type:
application/json

Request Body Example:

{
  "name": "Learn REST APIs",
  "description": "Understand REST API design and implementation.",
  "targetDate": "2024-08-15",
  "status": "Not Started"
}
Response:
Returns the created course with auto-generated
id
and
createdAt
.
4. Update an Existing Course
Request:
PUT /api/courses/{id}

Content-Type:
application/json

Replace
{id}
with the course ID.

Request Body:
Same format as create, all fields required.

Response:
Returns updated course or 404 if not found.

5. Delete a Course
Request:
DELETE /api/courses/{id}

Replace
{id}
with the course ID.

Response:
Returns HTTP 204 No Content on success or 404 if not found.

Sample Curl Commands for Testing
Create a course
curl -X POST http://localhost:8080/api/courses \
     -H "Content-Type: application/json" \
     -d '{
           "name": "Learn REST APIs",
           "description": "Understand REST API design and implementation.",
           "targetDate": "2024-08-15",
           "status": "Not Started"
         }'
Get all courses
curl http://localhost:8080/api/courses
Get a course by ID (e.g., ID = 1)
curl
