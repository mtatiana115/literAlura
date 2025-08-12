# LiterAlura

¡Bienvenido a LiterAlura! Este proyecto es una aplicación de consola en Java que te permite interactuar con la API de Gutendex para buscar y gestionar información sobre libros y sus autores.

## Funcionalidades

La aplicación ofrece un menú interactivo con las siguientes opciones:

    **Buscar libro por título:** Permite buscar un libro en la API de Gutendex y guardarlo en la base de datos si no existe.

    **Listar libros registrados:** Muestra todos los libros que se han guardado en la base de datos local.

    **Listar autores registrados:** Muestra una lista de todos los autores cuyos libros han sido registrados.

    **Listar autores vivos en un año:** Busca y muestra los autores que estaban vivos en un año específico.

    **Listar libros por idioma:** Filtra y muestra los libros registrados según un idioma seleccionado.

    **Mostrar estadísticas por idioma:** Proporciona estadísticas sobre la cantidad de libros por cada idioma registrado.

    **Salir:** Termina la ejecución de la aplicación.

## Tecnologías Utilizadas

* **Java:** Lenguaje de programación principal.

* **Spring Boot:** Framework para el desarrollo de la aplicación.

* **JPA / Hibernate:** Para la gestión de la persistencia de datos.

* **PostgreSQL:** Base de datos relacional para almacenar la información.

* **Gutendex API:** API externa utilizada para obtener datos de libros.

* **Jackson (fasterxml):** Para el procesamiento de JSON.

## Cómo empezar

### 1. Requisitos previos

Asegúrate de tener instalado lo siguiente:

* JDK 17 o superior

* Maven

* PostgreSQL

### 2. Configuración de la base de datos

    Crea una base de datos en PostgreSQL con el nombre `literatura`.

    Configura las credenciales de la base de datos en el archivo `application.properties` (o `application.yml`) de tu proyecto.

### 3. Ejecutar la aplicación

    Clona el repositorio.

    Abre el proyecto en tu IDE favorito.

    Ejecuta la clase principal `LiteraturaApplication`.

La aplicación se iniciará y mostrará el menú principal en la consola, listo para que interactúes.

### 4. Despliegue

Para desplegar la aplicación en un entorno de producción, sigue estos pasos:

    **Empaquetar la aplicación:** Usa Maven para crear un archivo JAR ejecutable. Abre una terminal en el directorio raíz del proyecto y ejecuta el siguiente comando:

    ```bash
    mvn clean package
    ```

    Esto generará el archivo `literatura-0.0.1-SNAPSHOT.jar` (o similar) en el directorio `target/`.

    **Configurar el entorno de producción:** Asegúrate de que el servidor de destino tenga instalado Java y una base de datos PostgreSQL accesible. Si las credenciales de la base de datos son diferentes a las de desarrollo, puedes sobreescribirlas a través de variables de entorno o un archivo de configuración externo.

    **Ejecutar el JAR:** Sube el archivo JAR a tu servidor y ejecútalo con el siguiente comando:

    ```bash
    java -jar target/literatura-0.0.1-SNAPSHOT.jar
    ```

    Con estos pasos, tu aplicación se ejecutará en el servidor y se conectará a la base de datos de producción.

## Contribuciones

Siéntete libre de contribuir a este proyecto. Si encuentras un error o tienes una sugerencia, por favor, abre un issue o un pull request.

¡Disfruta explorando el mundo de la literatura con LiterAlura!