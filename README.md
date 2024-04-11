# Proyecto de Gestión de Usuarios

Este proyecto proporciona una API para crear, actualizar y eliminar usuarios.

## Arquitectura Hexagonal

Este proyecto sigue el patrón de arquitectura hexagonal, también conocido como puertos y adaptadores. La arquitectura hexagonal se centra en la separación de preocupaciones y la modularidad del sistema. 

En esta arquitectura, el núcleo de la aplicación, que contiene la lógica de negocio y las reglas de dominio, se encuentra en el centro. Este núcleo es independiente de cualquier tecnología externa, como bases de datos o frameworks web. En lugar de eso, utiliza puertos para definir interfaces que deben ser implementadas por adaptadores externos.

- **Puertos**: Definen las interfaces que proporcionan la funcionalidad requerida por la aplicación. En este proyecto, los puertos serían las interfaces que definen las operaciones de creación, eliminación y actualización de usuarios.

- **Adaptadores**: Implementan las interfaces definidas por los puertos y se encargan de interactuar con tecnologías externas, como bases de datos o frameworks web. En este proyecto, los adaptadores serían las clases que implementan los métodos `createUser`, `deleteUser` y `updateContactData`.

Esta separación permite que el núcleo de la aplicación permanezca independiente de los detalles de implementación externos, lo que facilita las pruebas unitarias, el mantenimiento y la escalabilidad del sistema.

![Arquitectura hexagonal](https://miro.medium.com/v2/resize:fit:1400/1*yR4C1B-YfMh5zqpbHzTyag.png)


## Uso

La API expone los siguientes endpoints:

### Crear Usuario

```http
POST /create
```

Crea un nuevo usuario con la información proporcionada en el cuerpo de la solicitud.

### Eliminar Usuario

```http
POST /delete
```

Elimina un usuario existente utilizando el identificador proporcionado en el cuerpo de la solicitud.

### Actualizar datos de Usuario

```http
PUT /updateContactData
```

Actualiza los datos de un usuario utilizando los datos proporcionados.

## Probar en Postman

Para la realización de pruebas en Postman, dejo aquí una serie de ejemplos probados:

### Crear Usuario

```http
POST http://localhost:8080/frontapi/users/create
```

Y de body incluiremos:

```http
{
    "who": "ADMINISTRATOR",
    "whoId": "999",
    "name": "myName",
    "surname": "newSurname",
    "phone" : "phone",
    "email": "email@mail.com"
}
```

### Eliminar Usuario

```http
POST http://localhost:8080/frontapi/users/delete
```

Y como body:

```http
{
    "who": "ADMINISTRATOR",
    "whoId": "999",
    "userToDeleteId": "1"
}
```

### Actualizar datos de Usuario

```http
PUT http://localhost:8080/frontapi/users/updateContactData
```

Y como body:

```http
{
    "who": "ADMINISTRATOR",
    "whoId": "789",
    "userToUpdateId": "1",
    "newMail": "a@a.com",
    "newPhone": "+33123456789"
}
```
