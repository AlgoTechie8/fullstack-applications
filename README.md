# fullstack-applications
I'm targeting to build real-time FullStack application using Java, Spring Boot, HTML5, CSS3, JavaScript, Thymeleaf, ReactJS, Angular, etc...

student management system 
	Student management system is a simple CURD application is used to develop using following tech stack.
Feature:
  1. Request method to fetch All students from DB - Backend and frontend Part
  2. Request method to insert new student entry into DB - Backend and frontend Part
  3. Request method to edit the student details - Backend and frontend Part
  4. Request method to handle update student from request - frontend part
  5. Request method to handle delete student request 
  6. Request method to handle view perticular student details on UI

Tech stack: 
	Java 25
	Spring Boot
	Spring Data JPA
	Bean Validation
	Thymeleaf template
	PostgreSQL DB
	
	


Note: 
### 1. Key Configuration Options
  spring.datasource.url: The JDBC connection string. The default PostgreSQL port is 5432.
  spring.jpa.hibernate.ddl-auto: Controls how Hibernate manages the schema.
  update: Automatically updates the schema based on your entities.
  create: Drops and recreates the schema on startup.
  none: Disables automatic schema changes (recommended for production).
  spring.jpa.show-sql: Set to true to log generated SQL queries in the console for debugging.

### 2. Running with Docker (Optional)
If you do not have PostgreSQL installed locally, you can quickly start a container using [Docker](https://docker.com):
bash:
docker run --name my-postgres -e POSTGRES_PASSWORD=your_password -d -p 5432:5432 postgres


