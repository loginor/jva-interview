
# Duration Formatter API

## Online hosted: 
https://spring-interview-backend.onrender.com/api/duration/61

(Free host instance will spin down with inactivity, which can delay requests by 50 seconds or more the first time using after inactivity.)

This is a simple RESTful API built with Spring Boot that formats a given number of seconds into a human-readable duration, such as years, days, hours, minutes, and seconds.

## Features

- Convert seconds into a readable duration format.
- Supports various time units: years, days, hours, minutes, and seconds.
- Handles invalid inputs gracefully.

## Prerequisites

- Java 17 or higher
- Maven
- Docker (optional, for containerization)

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/loginor/spring-interview-backend.git
   cd spring-interview-backend
   ```

2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## API Usage

### Get Formatted Duration

To get the formatted duration of a given number of seconds, send a `GET` request to:

```
GET /api/duration/{seconds}
```

#### Example:

Request:
```
GET http://localhost:8080/api/duration/3661
```

Response:
```
1 hour and 1 minute
```

### Error Handling

If the input is invalid (non-numeric or out of range), the API will return an error message.

#### Example:

Request:
```
GET http://localhost:8080/api/duration/abc
```

Response:
```
Invalid input: Please provide a valid number within the range of a long integer.
```

## Docker (Optional)

If you want to run the application in a Docker container, use the following commands:

1. Build the Docker image:

   ```bash
   docker build -t duration-formatter .
   ```

2. Run the Docker container:

   ```bash
   docker run -p 8080:8080 duration-formatter
   ```
   
## Docker with batch file (Optional 2, Windows only)

1. Run the run.bat file