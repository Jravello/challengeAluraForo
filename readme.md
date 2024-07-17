# Foro Challenge API

Este es un proyecto de API para la gestión de tópicos en un foro. La API permite crear, actualizar, eliminar y listar tópicos. El proyecto está desarrollado en Java utilizando Spring Boot.

## Endpoints

### Listar todos los tópicos

**GET** `/topico`

#### Respuestas

- **200 OK**: Devuelve una lista de todos los tópicos.
- **204 NO CONTENT**: No hay tópicos disponibles.

### Crear un nuevo tópico

**POST** `/topico`

#### Cuerpo de la solicitud
```json
{
  "titulo": "Título del tópico",
  "mensaje": "Mensaje del tópico",
  "fechaCreacion": "2024-07-16T15:30:00",
  "status": "activo",
  "idPerfil": 1,
  "idCurso": 1
}
```

#### Respuestas

- **201 CREATED**: Tópico creado exitosamente.
- **400 BAD REQUEST**: Si alguno de los campos obligatorios está ausente o el campo `id` está presente.

### Actualizar un tópico

**PUT** `/topico`

#### Cuerpo de la solicitud
```json
{
  "id": 1,
  "titulo": "Nuevo título del tópico",
  "mensaje": "Nuevo mensaje del tópico",
  "fechaCreacion": "2024-07-16T15:30:00",
  "status": "activo",
  "idPerfil": 1,
  "idCurso": 1
}
```

#### Respuestas

- **200 OK**: Tópico actualizado correctamente.
- **404 NOT FOUND**: Si el tópico no existe.

### Eliminar un tópico

**DELETE** `/topico/{id}`

#### Parámetros de ruta
- `id`: ID del tópico a eliminar.

#### Respuestas

- **200 OK**: Tópico eliminado correctamente.
- **400 BAD REQUEST**: Si el `id` es nulo.
- **404 NOT FOUND**: Si el tópico no existe.

## Auth

### Iniciar sesión

**POST** `/login`

#### Cuerpo de la solicitud
```json
{
  "email": "admin@admin.cl",
  "password": "admin"
}
```

#### Respuestas

- **200 OK**: Inicio de sesión exitoso.
```json 
{ 
  "token": "ey.....",
  "tipo": "Bearer"
}
```
- **400 BAD REQUEST**: Si el email o la contraseña son incorrectos.~~

