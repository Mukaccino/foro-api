# foro-api
challenge-alura

# API Documentation

## Endpoints

### Tópicos

#### GET `/topicos`
- **Descripcion:** trae todos los topicos.

#### GET `/topicos/:id`
- **Descripcion:** trae topico por id.

#### PUT `/topicos/:id`
- **Descripcion:** actualiza un topico por id.

#### POST `/topicos`
- **Descripcion:** crea un topico.

#### DELETE `/topicos/:id`
- **Description:** Realiza borrado logico por id.

### Autenticación

#### POST `/login`
- **Description:** Realiza autentificacion de usuario para retornar un jwt (bearer).
- **Request Body:**
  - JSON con los siguientes valores:
    - `username` (string): Nombre usuario.
    - `password` (string): Contraseña.
- **Response:**
  - Status: `200 OK`
  - Body: un Json que contiene un jwt:
    ```json
    {
      "token": "your-jwt-token"
    }
    ```
