# Trabajo Práctico JPA
Proyecto donde se ponen en práctica conceptos bases de JPA implementada con Hibernate y la base de datos H2.
## Contenidos
- [Introducción](#introducción)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Ejecución del proyecto](#ejecución-del-proyecto)
- [Dependencias](#dependencias)
## Introducción
En este proyecto, se implementan las bases de JPA para persistir entidades, según la cardinalidad de las relaciones entre ellas. Para ello se utiliza la implementación de JPA, Hibernate. El diagrama de clases del ejemplo a implementar es este:
![image](https://github.com/user-attachments/assets/5a4e390f-e093-46bd-bf2d-8cdca3b1d7f1)

## Estructura del proyecto
El paquete `org.example.entidades` contiene todas las clases de las entidades a persistir.
En el archivo `Main.java` se realiza una transacción donde se crean varias entidades a modo
de demostración del funcionamiento del proyecto.
## Ejecución del proyecto
Los pasos 2 y 3 pueden omitirse si tu IDE provee plug-ins que se encarguen de las dependencias del proyecto y permitan
ejecutarlo. 
1. **Clonar el repositorio.**
```sh
git clone https://github.com/jpbiondo/trabajo-practico-jpa.git
cd trabajo-practico-jpa
```
2. **Contruir el proyecto.** Para armar el proyecto, instalar las dependencias requeridas:
```sh
./gradlew build
```
3. **Correr el projecto.**
```sh
./gradlew run
```
## Dependencias
Este proyecto utiliza las siguientes dependencias:
- **[Hibernate](https://hibernate.org/)**: Implementación de JPA para persistir y mapear objetos a entidades del modelo relacional de base de datos.
- **[H2](https://www.h2database.com/html/main.html)**: Una base de datos ligera donde se persistirán las entidades.
- **[Lombok](https://projectlombok.org/)**: Librería que permite desintoxicar al proyecto de código como getters, setter y constructores.
