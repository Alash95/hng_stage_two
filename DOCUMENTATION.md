# API Documentation

## Overview

This document provides information on how to use the API endpoints, standard request and response formats, sample usage, and instructions for setting up and deploying the API.

### Base URL

https://hng-task-two-7r8p.onrender.com/api


## Endpoints
### Create a User

- **Endpoint**: `POST `
- **Description**: Create a new user with a name and a value and email and value.
- **Request Body**:
```json
{
  "name": "John Doe",
  "email" : "john@gmail.com"
}
```
- **Success Response (HTTP Status Code: 201 Created):**
- **Response**:

```json
{
  "id": 1,
  "name": "John Doe",
  "email" : "john@gmail.com"
}
- **Error Response (HTTP Status Code: 400 Bad Request):**

```json
{
  "id": null,
  "name": "Name must be a string",
  "email" : null
}```
- **Error Response (HTTP Status Code: 400 Bad Request):**
```json
{
  ""id": null,
  "name": null,
  "email" : "Email must be a string"
}```


### Get a Person by ID

- **Endpoint**: `GET /{user_id}`
- **Description**: Retrieve a user by their ID.
- **Response**:
- `user_id` (Long) - The ID of the user's data to retrieve.
```json
{
  "id": 1,
  "name": "John Doe",
  "email" : "john@gmail.com"
}
```

### Update a Person by ID
- `user_id` (Long) - The ID of the person to update.

- **Endpoint**: `PUT /{user_id}`
- **Description**: Update a user's name and value by their ID.
- **Request Body**:

```json
{
  "name": "new name",
  "email" : "new email"

}
```
- **Success Response (HTTP Status Code: 201 Created):**
- **Response**:

```json
{
  "name": "updated name",
  "email" : "updated email"
}
```

### Delete a Person by ID
- `user_id` (Long) - The ID of the user to delete.
- **Endpoint**: `DELETE /{user_id}`
- **Description**: Delete a user by their ID.
- **Response**:

```json
{
  "message": "User has been successfully deleted"
}
```

#### Response Format

- **Success Response (HTTP Status Code: 200 OK):**

```json
{
  "id": 1,
  "name": "John Doe",
}
```


## Known Limitations

- This API does not include authentication and authorization mechanisms. Consider implementing them for production use.

## Setup and Deployment

1. Clone the repository to your local machine.
   
2. git clone https://github.com/Alash95/hng_stage_two.git

3. Run `mvn clean install` to build the project.

4. Configure the application

The configuration for this API is stored in the `application.properties` file. To configure the API or make changes to its behavior, you can edit this file. Here's how:

- Navigate to the directory where the `application.properties` file is located.

- Open `application.properties` in a text editor of your choice.

- Modify the configuration settings as needed. Common configurations include database connection details, server port, or API secret keys.

Example `application.properties`:

  # Database configuration
    server.port = PORT
    spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
    spring.datasource.username=username
    spring.datasource.password=password

5. Package your application in a jar file using

```bash
mvn clean package
mvn install package
```

6. Run the package by using the jar application file found in the target folder:

7. java -jar your-application.jar

