# Spring Boot 3.0 JWT OAuth2 User Registration and CRUD Rest API

This project demonstrates the implementation of security using Spring Boot 3.0, JSON Web Tokens (JWT), OAuth, and user CRUD operations. It includes the following features:

## Features

- User Registration and Login with JWT and OAuth2 Authentication
- Password encryption using BCrypt
- Role-based authorization with Spring Security
- OpenAPI and Swagger
- Refresh token
- CRUD Operations on Users


## Technologies

- Spring Boot 3.0
- Spring Security
- JSON Web Tokens (JWT)
- OAuth2
- BCrypt
- Maven

## Getting Started

To get started with this project, you will need to have the following installed on your local machine:

- JDK 17+
- Maven 3+

## To build and run the project, follow these steps:

- Clone the repository: git clone https://github.com/Ginowine/jwt-oauth-user-registration-rest-api.git
- Navigate to the project directory: cd spring-boot-security-jwt
- Add database "registration" to postgres
- Build the project: ```mvn clean install```
- Run the project: ```mvn spring-boot:run```
-> The application will be available at http://localhost:8080.

## Exposed APIs

## Register a user

http://localhost:8080/api/v1/auth/register 

You need to use a POST request on Postman and then enter a request body
```
  {
    "firstname": "enter firstname",
    "lastname": "enter second name",
    "email": "enter email",
    "password": "enter password"
  }
```

## Login or Authenticate a user

http://localhost:8080/api/v1/auth/authenticate

You need to use a POST request on Postman and then enter a request body

``` 
{
	"email": "enter registration email",
	"password": "enter registration password"
}
```
## Use the generated token to access other endpoints - GET

http://localhost:8080/api/v1/demo-controller

- You need to use a GET request and authorize a user 
- Enter token generated from the previous step
- Token name is Bearer token

## Get all users - GET
http://localhost:8080/api/v1/users

## Update a user - PUT
http://localhost:8080/api/v1/users/update/1

Use a PUT request to update user and enter request body

```
  {
    "firstname": "registered firstname",
    "lastname": "registered lastname",
    "email": "registered email",
    "password": "registered password"
  }
```

## Delete a user
http://localhost:8080/api/v1/users/delete/1

## Get a user 
http://localhost:8080/api/v1/users/1

## Signin with GitHub
http://localhost:8080/oauth2/authorization/github

## Signin with Google
http://localhost:8080/oauth2/authorization/google
