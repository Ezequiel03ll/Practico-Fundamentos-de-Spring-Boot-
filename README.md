
---

# 📘 **Sistema de Gestión de Tareas – Spring Boot**



Aplicación desarrollada como Trabajo Práctico utilizando **Spring Boot**, **Java 21**, **Gradle**, e implementada en un entorno local con **IntelliJ IDEA**.
El sistema permite gestionar tareas en memoria aplicando conceptos fundamentales de Spring Boot: inyección de dependencias, beans condicionales, profiles y configuración externa.

---

## 📝 **Descripción General**

Este proyecto implementa un pequeño sistema de gestión de tareas (To-Do List) con las siguientes funcionalidades:

* ➕ Agregar nuevas tareas
* 📋 Listar todas las tareas
* 🔍 Filtrar tareas pendientes
* ✔️ Marcar tareas como completadas
* 📊 Mostrar estadísticas configurables
* ⚙️ Cambiar comportamiento según *profile* activo (dev / prod)

Toda la lógica de arranque se ejecuta mediante **CommandLineRunner**, lo cual permite probar el sistema directamente desde consola.

---

## 🧪 **Tecnologías Utilizadas**

| Tecnología            | Descripción                         |
| --------------------- | ----------------------------------- |
| **Java 21**           | Lenguaje base del proyecto          |
| **Spring Boot 3.x**   | Framework principal                 |
| **Gradle**            | Build system                        |
| **Lombok (opcional)** | Simplificación de código en modelos |
| **Spring DevTools**   | Hot reload                          |
| **IntelliJ IDEA**     | Entorno de desarrollo               |
| **Windows 10/11**     | Plataforma utilizada                |

---

## 📂 **Estructura del Proyecto**

```
src/main/java/com.utn.tareas
│
├── model
│   ├── Prioridad.java
│   └── Tarea.java
│
├── repository
│   └── TareaRepository.java
│
├── service
│   ├── MensajeService.java
│   ├── MensajeDevService.java
│   ├── MensajeProdService.java
│   └── TareaService.java
│
└── TareasApplication.java

src/main/resources
│
├── application.properties
├── application-dev.properties
└── application-prod.properties
```

---

## ⚙️ **Configuración de Profiles**

Spring Boot permite modificar el comportamiento del sistema según el entorno.

### 🔧 **Profile de Desarrollo (dev)**

Activado por defecto:

```
spring.profiles.active=dev
```

Características del modo dev:

* Muestra estadísticas
* Logging detallado
* Límite reducido de tareas para pruebas

Archivo: **application-dev.properties**

---

### 🚀 **Profile de Producción (prod)**

Para activarlo:

```
spring.profiles.active=prod
```

Características del modo prod:

* No muestra estadísticas
* Logging limitado
* Límite amplio de tareas

Archivo: **application-prod.properties**

---

## ▶️ **Cómo ejecutar el proyecto**

### 1️⃣ Clonar el repositorio

```
git clone https://github.com/usuario/tp-spring-tareas.git
cd tp-spring-tareas
```

### 2️⃣ Ejecutar con Gradle

```
./gradlew bootRun     # Linux / Mac
gradlew.bat bootRun   # Windows
```

O desde IntelliJ:
**Run → TareasApplication**

---

## 🔁 **Flujo de ejecución (CommandLineRunner)**

Durante el arranque de la aplicación:

1. Mostrar mensaje de bienvenida
2. Mostrar configuración actual
3. Listar tareas iniciales
4. Agregar nuevas tareas automáticamente
5. Listar pendientes
6. Completar una tarea
7. Mostrar estadísticas
8. Listar tareas completadas
9. Mostrar mensaje final

---

## 🖼️ **Capturas de ejecución**

Las capturas se encuentran en la carpeta:

```
/capturas de ejecucion
```

Incluyen:

* Ejecución con **dev**
* Ejecución con **prod**
* Comportamientos diferenciados
* Estadísticas
* Listados

---

## 💬 **Conclusiones**

* Comprendí cómo se estructura una aplicación real en Spring Boot.
* Implementé profiles, configuración externa y arquitectura en capas.
* Utilicé correctamente la inyección de dependencias por constructor.
* Aprendí a usar CommandLineRunner para lógica de inicio.
* Entendí el uso de beans condicionales mediante @Profile.

---

## 👤 **Autor**

**Llampa Pablo**
**Legajo: 50974**

---
