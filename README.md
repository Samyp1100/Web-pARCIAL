# Clinica Web

Aplicacion web full stack para la gestion de clinicas, desarrollada como proyecto practico de desarrollo web. El repositorio separa el trabajo de frontend y backend mediante ramas independientes, manteniendo una arquitectura clara y facil de evolucionar.

> Este proyecto forma parte de mi portafolio de desarrollo web. La estructura esta preparada para incorporar mas proyectos y mostrar de forma ordenada las tecnologias, decisiones y aprendizajes de cada uno.

## Indice

- [Resumen](#resumen)
- [Objetivos](#objetivos)
- [Funcionalidades](#funcionalidades)
- [Arquitectura](#arquitectura)
- [Tecnologias](#tecnologias)
- [Estructura del repositorio](#estructura-del-repositorio)
- [Ramas de trabajo](#ramas-de-trabajo)
- [Requisitos](#requisitos)
- [Puesta en marcha](#puesta-en-marcha)
- [API REST](#api-rest)
- [Modelo de datos](#modelo-de-datos)
- [Flujo de desarrollo](#flujo-de-desarrollo)
- [Seguridad y buenas practicas](#seguridad-y-buenas-practicas)
- [Estado y mejoras futuras](#estado-y-mejoras-futuras)
- [Otros proyectos](#otros-proyectos)
- [Autor](#autor)

## Resumen

Clinica Web permite registrar y consultar informacion basica de clinicas. El sistema esta compuesto por:

- Un frontend SPA construido con Angular.
- Un backend REST construido con Spring Boot.
- Persistencia mediante Spring Data JPA y una base de datos H2 para desarrollo.
- Comunicacion HTTP entre la interfaz y la API.
- Separacion del codigo por capas: componentes, servicios, modelos, controladores, servicios de negocio y repositorios.

El proyecto demuestra el ciclo completo de una aplicacion web: captura de datos en formularios, validacion basica, consumo de endpoints, listado de registros, eliminacion y organizacion de un backend mantenible.

## Objetivos

- Practicar el desarrollo de una aplicacion full stack.
- Implementar una API REST con operaciones sobre clinicas.
- Conectar una interfaz Angular con servicios HTTP.
- Aplicar separacion de responsabilidades entre presentacion, negocio y persistencia.
- Mantener un flujo de trabajo con ramas independientes para frontend y backend.
- Documentar el proyecto de forma reproducible para facilitar su evaluacion y continuidad.

## Funcionalidades

### Frontend

- Visualizacion de clinicas en una tabla.
- Creacion de clinicas mediante formulario.
- Captura de nombre, direccion, cantidad de camas, telefono, correo y fecha de creacion.
- Eliminacion de clinicas con confirmacion previa.
- Navegacion entre la lista y el formulario mediante Angular Router.
- Componentes standalone y formularios con `FormsModule`.
- Manejo basico de respuestas exitosas y errores HTTP.

### Backend

- API REST para administrar clinicas.
- Operaciones de consulta, creacion, actualizacion y eliminacion.
- Persistencia con repositorios JPA.
- DTOs para transportar datos entre la API y el cliente.
- ModelMapper para convertir entre entidades y DTOs.
- Configuracion CORS para permitir la comunicacion con el frontend durante el desarrollo.
- Base de datos H2 para ejecucion local y pruebas de desarrollo.

## Arquitectura

```text
										HTTP / JSON
		 +------------------------------------------+
		 |                                          |
		 v                                          |
+------------+       +----------------------+   |
| Angular 17 | ---->  | Spring Boot REST API |   |
| Frontend   | <----  | Backend              |   |
+------------+       +----------+-----------+   |
																|               |
																v               |
											 +----------------+       |
											 | JPA Repository |       |
											 +--------+-------+       |
																|               |
																v               |
											 +----------------+       |
											 | H2 Database    |       |
											 +----------------+       |
```

### Capas principales

1. **Presentacion:** componentes Angular para listar y registrar clinicas.
2. **Acceso del frontend:** `ClinicaService`, responsable de consumir la API.
3. **Control HTTP:** `ClinicaController`, responsable de exponer los endpoints.
4. **Transferencia:** DTOs que definen los datos intercambiados.
5. **Negocio:** `ClinicaService`, donde se centraliza la logica de la aplicacion.
6. **Persistencia:** repositorios Spring Data JPA y entidades del dominio.

## Tecnologias

| Area | Tecnologia | Uso |
| --- | --- | --- |
| Frontend | Angular 17 | Interfaz SPA y componentes standalone |
| Frontend | TypeScript 5.2 | Tipado y logica de la interfaz |
| Frontend | RxJS 7.8 | Observables y comunicacion asincrona |
| Backend | Java 17 | Lenguaje principal del servidor |
| Backend | Spring Boot 3.2 | Configuracion y ejecucion de la API |
| API | Spring Web | Controladores REST y HTTP |
| Persistencia | Spring Data JPA | Repositorios y acceso a datos |
| Base de datos | H2 | Persistencia local de desarrollo |
| Mapeo | ModelMapper | Conversion entre entidades y DTOs |
| Build | npm / Maven Wrapper | Instalacion, compilacion y ejecucion |

## Estructura del repositorio

```text
clinica/
|-- backend/                         # Aplicacion Spring Boot
|   |-- src/main/java/com/clinica/app/
|   |   |-- config/                  # CORS y configuracion de mapeo
|   |   |-- controller/              # Endpoints REST
|   |   |-- dto/                     # Objetos de transferencia
|   |   |-- model/                   # Entidades del dominio
|   |   |-- repository/              # Persistencia JPA
|   |   `-- service/                 # Logica de negocio
|   |-- src/main/resources/          # Configuracion de Spring
|   |-- pom.xml
|   `-- mvnw / mvnw.cmd
|-- frontend/                        # Aplicacion Angular
|   |-- src/app/components/          # Componentes de clinica
|   |-- src/app/models/              # Interfaces TypeScript
|   |-- src/app/services/            # Servicios HTTP
|   |-- package.json
|   `-- angular.json
|-- .gitignore                       # Secretos, dependencias y builds excluidos
`-- README.md                        # Documentacion general
```

## Ramas de trabajo

El proyecto utiliza dos ramas principales:

| Rama | Contenido | Uso |
| --- | --- | --- |
| `Front` | Aplicacion Angular | Desarrollo de interfaz y experiencia de usuario |
| `Back` | API Spring Boot | Desarrollo de endpoints, dominio y persistencia |

Ambas ramas conservan este README y el `.gitignore`. Para trabajar en un modulo especifico:

```bash
git clone https://github.com/Samyp1100/Web-pARCIAL.git
cd Web-pARCIAL
git switch Front   # frontend
git switch Back    # backend
```

## Requisitos

- Git.
- Node.js 18 o una version compatible con Angular 17.
- npm.
- Java Development Kit 17.
- Conexion a internet para instalar dependencias la primera vez.
- Maven no es obligatorio porque el backend incluye Maven Wrapper.

## Puesta en marcha

### 1. Levantar el backend

Desde la raiz del repositorio:

```bash
cd backend
./mvnw spring-boot:run
```

En Windows PowerShell:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

La API se inicia en:

```text
http://localhost:8080
```

Para compilar sin ejecutar:

```bash
./mvnw clean install -DskipTests
```

### 2. Levantar el frontend

En otra terminal:

```bash
cd frontend
npm install
npm start
```

La aplicacion queda disponible normalmente en:

```text
http://localhost:4200
```

El frontend debe ejecutarse mientras el backend esta disponible en el puerto `8080`.

### 3. Comandos utiles del frontend

```bash
npm start       # servidor de desarrollo
npm run build   # compilacion de produccion
npm test        # pruebas configuradas por Angular
```

## API REST

La API expone la ruta base `/api/clinicas`.

| Metodo | Ruta | Descripcion |
| --- | --- | --- |
| `GET` | `/api/clinicas` | Obtiene todas las clinicas |
| `GET` | `/api/clinicas/{id}` | Obtiene una clinica por identificador |
| `POST` | `/api/clinicas` | Registra una nueva clinica |
| `PUT` | `/api/clinicas/{id}` | Actualiza una clinica existente |
| `DELETE` | `/api/clinicas/{id}` | Elimina una clinica |

Ejemplo de payload para crear una clinica:

```json
{
	"nombre": "Clinica Central",
	"direccion": "Calle Principal 123",
	"cantidadCamas": 45,
	"telefono": "555-0100",
	"correo": "contacto@clinicacentral.example",
	"fechaCreacion": "2024-01-15"
}
```

Ejemplo de consulta con `curl`:

```bash
curl http://localhost:8080/api/clinicas
```

## Modelo de datos

La entidad principal `Clinica` contiene:

- `identificador`: identificador unico.
- `nombre`: nombre de la clinica.
- `direccion`: ubicacion fisica.
- `cantidadCamas`: capacidad disponible.
- `telefono`: numero de contacto.
- `correo`: correo institucional.
- `fechaCreacion`: fecha de registro.

El backend tambien contempla el modelo `Doctor` como parte del dominio de la aplicacion y deja preparada la organizacion para ampliar la gestion clinica.

## Flujo de desarrollo

1. Crear o cambiar a la rama del modulo correspondiente.
2. Instalar dependencias solo de forma local.
3. Ejecutar la aplicacion y validar el flujo manualmente.
4. Ejecutar compilacion o pruebas disponibles.
5. Revisar que no se incluyan secretos, dependencias ni artefactos generados.
6. Crear un commit pequeno y descriptivo.
7. Publicar los cambios en la rama correspondiente.

## Seguridad y buenas practicas

El archivo `.gitignore` excluye:

- Archivos `.env` y variantes locales.
- Llaves, certificados y archivos de credenciales.
- `node_modules` y cache de Angular.
- Carpeta `target` y salidas de Maven.
- Archivos ZIP, logs y archivos temporales.
- Configuracion personal del IDE.

Las credenciales y configuraciones sensibles deben mantenerse fuera del repositorio. Para incorporar configuracion local, se recomienda documentar las variables esperadas en un archivo de ejemplo sin valores reales.

## Estado y mejoras futuras

El proyecto cuenta con una base funcional para la gestion de clinicas. Algunas mejoras naturales para siguientes iteraciones son:

- Agregar pruebas unitarias para servicios, controladores y componentes.
- Implementar edicion completa desde la interfaz.
- Agregar validaciones de formulario mas detalladas.
- Centralizar el manejo de errores y mostrar mensajes de usuario.
- Incorporar paginacion, busqueda y filtros.
- Agregar autenticacion y autorizacion por roles.
- Migrar la base de datos local a PostgreSQL para un entorno productivo.
- Crear perfiles de configuracion para desarrollo, pruebas y produccion.
- Automatizar CI con compilacion y pruebas en cada pull request.
- Publicar una demo o capturas de la interfaz.

## Otros proyectos

Este repositorio puede crecer como portafolio personal. Para agregar nuevos proyectos, se recomienda mantener una ficha con objetivo, rol, stack, funcionalidades, decisiones tecnicas y enlaces de demostracion.

| Proyecto | Descripcion | Tecnologias | Enlace |
| --- | --- | --- | --- |
| Clinica Web | Gestion de clinicas full stack | Angular, Spring Boot, Java, H2 | Este repositorio |
| Proyecto 2 | Agregar descripcion del siguiente proyecto | Agregar stack | Agregar enlace |
| Proyecto 3 | Agregar descripcion del siguiente proyecto | Agregar stack | Agregar enlace |

## Autor

**Samyp1100**

Desarrollador web en formacion, interesado en construir aplicaciones completas, aprender nuevas tecnologias y documentar decisiones tecnicas de forma clara.

- GitHub: [github.com/Samyp1100](https://github.com/Samyp1100)
- Repositorio: [Web-pARCIAL](https://github.com/Samyp1100/Web-pARCIAL)

---

Este README esta pensado como carta tecnica del proyecto: explica que resuelve, como esta construido, como ejecutarlo y en que direccion puede evolucionar.