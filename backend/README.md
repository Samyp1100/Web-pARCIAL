# Backend - Gestión de Clínicas

API REST desarrollada con Spring Boot para la gestión de clínicas.

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Lombok
- ModelMapper

## Ejecutar

```bash
cd backend
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`

## Endpoints

- `GET /api/clinicas` - Listar todas las clínicas
- `GET /api/clinicas/{id}` - Obtener clínica por ID
- `POST /api/clinicas` - Crear nueva clínica
- `PUT /api/clinicas/{id}` - Actualizar clínica
- `DELETE /api/clinicas/{id}` - Eliminar clínica
## Comandos Back :




.\mvnw clean install -DskipTes


.\mvnw spring-boot:run        
>> # o con Maven instalado
>> mvn spring-boot:run
>> # o si es Gradle
>> .\gradlew bootRun



Front:  

npm run start