# foro-api
challenge-alura

# API Documentation

## Endpoints

### Tópicos

#### GET `/topicos`
- **Description:** Retrieves a list of all tópicos.
- **Response:**
  - Status: `200 OK`
  - Body: An array of tópicos in JSON format.

#### GET `/topicos/:id`
- **Description:** Retrieves a specific tópico by its ID.
- **Path Parameter:**
  - `id` (string): The unique identifier of the tópico.
- **Response:**
  - Status: `200 OK`
  - Body: The tópico object in JSON format.
  - Status: `404 Not Found` if the tópico does not exist.

#### PUT `/topicos/:id`
- **Description:** Updates a specific tópico by its ID.
- **Path Parameter:**
  - `id` (string): The unique identifier of the tópico.
- **Request Body:**
  - JSON object containing the fields to update.
- **Response:**
  - Status: `200 OK`
  - Body: The updated tópico object in JSON format.
  - Status: `404 Not Found` if the tópico does not exist.

#### POST `/topicos`
- **Description:** Creates a new tópico.
- **Request Body:**
  - JSON object containing the details of the new tópico.
- **Response:**
  - Status: `201 Created`
  - Body: The newly created tópico object in JSON format.

#### DELETE `/topicos/:id`
- **Description:** Deactivates a specific tópico by its ID.
- **Path Parameter:**
  - `id` (string): The unique identifier of the tópico.
- **Response:**
  - Status: `200 OK`
  - Body: Confirmation of the deactivation.
  - Status: `404 Not Found` if the tópico does not exist.

### Autenticación

#### POST `/login`
- **Description:** Authenticates a user and returns a JWT (JSON Web Token).
- **Request Body:**
  - JSON object with the following fields:
    - `username` (string): The user's username.
    - `password` (string): The user's password.
- **Response:**
  - Status: `200 OK`
  - Body: A JSON object containing the JWT:
    ```json
    {
      "token": "your-jwt-token"
    }
    ```
  - Status: `401 Unauthorized` if authentication fails.

## Notes
- All endpoints expect and return JSON-formatted data.
- Use the JWT returned by `/login` in the `Authorization` header for endpoints that require authentication.
- Example header:
  ```
  Authorization: Bearer your-jwt-token
  ```

