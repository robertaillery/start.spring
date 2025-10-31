# Lab 6: REST Endpoints

[cite_start]This is a Spring Boot project for Lab 6 [cite: 1] that provides two REST endpoints for validation:
1.  Password quality checking
2.  Basic email address validation

## Prerequisites

* Java 17+
* A terminal or command-line interface

## How to Run

1.  **Make the Maven Wrapper Executable**
    [cite_start]Before running the project for the first time, you must give the Maven wrapper script execution permissions[cite: 70].
    ```bash
    chmod a+x ./mvnw
    ```

2.  **Run Unit Tests**
    [cite_start]To build the project and run all the required unit tests, use the following command[cite: 8, 16]:
    ```bash
    ./mvnw test
    ```
    You should see a `BUILD SUCCESS` message.

3.  **Run the Application**
    [cite_start]To run the main application and start the web server[cite: 72]:
    ```bash
    ./mvnw spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

## Endpoints

The server provides two `POST` endpoints.

### 1. Password Quality

* **Endpoint:** `POST /api/password-quality`
* **Consumes:** `application/json`
    ```json
    {
      "password": "your-password-here"
    }
    ```
* **Returns:** `application/json`
    ```json
    {
      "quality": "Weak"
    }
    ```

### 2. Email Address Validity

* **Endpoint:** `POST /api/email-address-valid`
* **Consumes:** `application/json`
    ```json
    {
      "email": "your-email-here"
    }
    ```
* **Returns:** `application/json`
    ```json
    {
      "isValid": true
    }
    ```
