🚀 API de Gestión de Suscripciones v1.0
Este proyecto es un microservicio desarrollado con Spring Boot 4 y Java 21, diseñado para demostrar una arquitectura limpia de 3 capas y despliegue automatizado con Docker.

---

🛠️ Tecnologías y Stack
• Java 21: Implementación de Virtual Threads para alto rendimiento.

• Spring Boot 4.0.x: Framework base para la API REST.

• Lombok: Automatización de código boilerplate (Getters/Setters).

• Docker: Empaquetado en imágenes ligeras multi-stage.

• GitHub Actions: Integración y Despliegue Continuo (CI/CD).

---

🏗️ Arquitectura del Sistema
El código está organizado siguiendo el estándar de 3 Capas:

1. Controller: Manejo de rutas y peticiones HTTP.

2. Service: Lógica de negocio y validaciones de seguridad.

3. Repository: Persistencia de datos (Simulada con `ArrayList`).

---

🚀 Instalación y Uso Local
1. Clonar el repositorio:

```

git clone https://github.com/j-camposar/suscipciones_fullstack1

```

2. Ejecutar con Maven:

```

mvn spring-boot:run

```


---

🐳 Despliegue con Docker
Para correr este microservicio como un contenedor, utiliza los siguientes comandos:

1. Construir la imagen:

```

docker build -t suscripciones-api:v1 .

```

2. Levantar el contenedor:

```

docker run -d -p 8080:8080 --name api-suscripciones suscripciones-api:v1

```


---

🛣️ Endpoints de la API (v1)

| Método | Endpoint | Parámetros | Descripción |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/v1/buscarTodos` | Ninguno | Lista todas las suscripciones. |
| **POST** | `/api/v1/crear` | `@RequestBody` | Crea un nuevo plan (Price > 0). |
| **PUT** | `/api/v1/actualizar/{id}` | `ID` + JSON | Actualiza datos de un plan. |
| **GET** | `/api/v1/buscarPorId/{id}` | `ID` | Busca una suscripción por su ID. |
| **GET** | `/api/v1/buscarPorCategoria/{cat}` | `Categoría` | Filtra por nombre de categoría. |
| **GET** | `/api/v1/buscarActivos` | Ninguno | Lista solo planes con `active: true`. |
| **GET** | `/api/v1/suscripcion/{id}/activo` | `ID` | Cambia el estado (Toggle) del plan. |
| **DELETE** | `/api/v1/suscripcion/eliminar/{id}` | `ID` | Elimina si el plan está inactivo. |
---

👤 Autor
• Jose Campos - Docente FullStack1

• Institución: Duoc UC

• Versión: 1.0 (Marzo 2026)

# Actualizaci�n Pipeline AWS
