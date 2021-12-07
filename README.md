# StudentsScheduler
This project is for the Full Stack Engineer Coding Exercise from inMarket/Mirigos

This project is built with Maven, Spring Boot, JPA, H2 and java 8.

To run the project you can run the next command:
mvn clean spring-boot:run

Persistence for this project is provided by H2 in memory database, so you don't need to setup any database in your system.

I used Postman in order to test the REST API endpoints:

Here is the datail for every service:

STUDENTS:

- POST  http://localhost:8080/student Creates and student.

    Payload example:
{
    "studentFirstName": "Miguel",
    "studentLastName": "Mendoza"
}

- GET http://localhost:8080/student/85b80a9e-d894-4c4c-8549-24cec169cacf Retrieves an student given the UUID.

- GET http://localhost:8080/student Lists all the students.

- DELETE http://localhost:8080/student/f9af4f64-c4cd-4dc6-9e08-477ee714139c deletes an Student given the UUID.

- PATCH http://localhost:8080/student updates an Student given the UUID and the updated fields.

    Payload example:
{
    "studentId": "e969ab67-6405-4a70-876b-e3e222eb0876",
    "studentFirstName": "Pilar",
    "studentLastName": "Ponce"
}

- GET http://localhost:8080/student/find/Mendoza Finds an Student filtering by First or Last name.

COURSES

- POST http://localhost:8080/course Creates a Course.

    Payload Example:
{
    "courseTitle":"ENGLISH",
    "courseDescription":"ENGLISH 1"
}

- GET http://localhost:8080/course/3241cf0f-28c7-4528-a5f9-fdba2df0592f Retrieves a Course given the UUID.

- GET http://localhost:8080/course Lists all the courses.

- DELETE http://localhost:8080/course/3241cf0f-28c7-4528-a5f9-fdba2df0592f deletes a course given the course UUID.

- PATCH http://localhost:8080/course/ Updates a course given the UUID and the updated fields.

    Payload Example:
{
    "courseCode": "9c619f95-90b2-48c3-9d97-3ace2485fc94",
    "courseTitle": "ENGLISH",
    "courseDescription": "ENGLISH 2"
}

- GET http://localhost:8080/course/find/ENGLISH Finds a Course filtering by Title or Description.

STUDENT SUBSCRIPTIONS:

- POST http://localhost:8080/subscribe/ Subscribe an Student into a course given the UUIDS.

    Payload example:
{
    "fkStudentId": "69c42b58-3ad3-444e-9de4-b6bd40e22caa",
    "fkCourseCode": "206c7d37-0cf0-4b28-85be-0314c87f8f1d"
}

- GET http://localhost:8080/student/courses/31448c64-0d05-40b1-aaf2-9e015e9fdca8 Retrieves all the Student's courses given its UUID.

- GET http://localhost:8080/course/student/206c7d37-0cf0-4b28-85be-0314c87f8f1d Retrieves all the Students from some course given the course UUID.

