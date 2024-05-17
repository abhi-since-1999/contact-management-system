Create the database with the name : contact_management_db

Go to the Application.properties and set the  following parameters:

spring.application.name=contact-management-system

server.port=8085

# Database properties
spring.datasource.url=jdbc:postgresql://localhost:5432/contact_management_db
spring.datasource.username=
spring.datasource.password=

# Hibernate properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto = update

# Logging properties
logging.level.org.springframework=INFO
logging.level.com.example=DEBUG

Then run the applciation.  The Tomcat server should start.

Commands:

//To get all the contacts
![image](https://github.com/abhi-since-1999/contact-management-system/assets/65460598/4075b9a7-dd23-4b7d-8379-4113bb4b425b) 

//To register user
![image](https://github.com/abhi-since-1999/contact-management-system/assets/65460598/88e18d16-0503-4ea6-a618-2a181175701f)

//To add contact
![image](https://github.com/abhi-since-1999/contact-management-system/assets/65460598/7ba126ab-0334-4f62-9f06-8117b7b75fcd)

//delete contact
![image](https://github.com/abhi-since-1999/contact-management-system/assets/65460598/15eda360-246f-410e-b140-a49e1489b812)



