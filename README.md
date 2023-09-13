# HNG-Task2

This API allows you to perform CRUD (Create, Read, Update, Delete) operations on User Objects.

# Prerequisites
Java 8 or higher
Maven
Postgresql 15

## Installation

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

4. Package your application in a jar file using

```bash
mvn clean package
mvn install package
```

6. Run the package by using the jar application file found in the target folder:

           java -jar your-application.jar


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

- **Response**:

```json
{
  "id": 1,
  "name": "John Doe",
  "email" : "john@gmail.com"
}
```

### Get a Person by ID

- **Endpoint**: `GET /{user_id}`
- **Description**: Retrieve a user by their ID.
- **Response**:

```json
{
  "id": 1,
  "name": "John Doe",
  "email" : "john@gmail.com"
}
```

### Update a Person by ID

- **Endpoint**: `PUT /{user_id}`
- **Description**: Update a user's name and value by their ID.
- **Request Body**:

```json
{
  "name": "new name",
  "email" : "new email"

}
```

- **Response**:

```json
{
  "name": "updated name",
  "email" : "updated email"
}
```

### Delete a Person by ID

- **Endpoint**: `DELETE /{user_id}`
- **Description**: Delete a user by their ID.
- **Response**:

```json
{
  "message": "User deleted successfully"
}
```

## Error Handling

- If the provided ID does not exist, you will receive a `404 Not Found` response.
- If the provided email already exists, you will receive a "email already exists" response.
- If the provided name is not a string, you will receive a "name must be a string" response.
- If the provided email is not a string and in the wrong format, you will receive an "email must be a string" response.
- If the request body does not contain valid name and value fields, you will receive a `400 Bad Request` response.
- If there is an internal server error, you will receive a `500 Internal Server Error` response.


