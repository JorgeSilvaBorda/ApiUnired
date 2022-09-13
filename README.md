# ApiUnired

Este proyecto utiliza Quarkus como framework de desarrollo de aplicaciones.
Se utilizó técnica de desarrollo de microservicios como pequeños monolitos.
La documentación oficial del Framwork de desarollo se encuentra en: https://quarkus.io/ .

## Ejecutar la aplicación en modo desarrollo:

Dentro de la raíz del directorio en el que se encuentra el proyecto, se debe ejecutar el siguiente script:
```shell script
./mvnw compile quarkus:dev
```
## Compilar y empaquetar la aplicación

Para empaquetar la aplicación, se debe ejecutar el siguiente comando:
```shell script
./mvnw package
```
Esto produce el archivo `quarkus-run.jar` en el directorio `target/quarkus-app/` de la raíz del proyecto.
Esto no genera un _über-jar_,y todas las dependencias son copiadas al directorio `target/quarkus-app/lib/`.
Si se copia solo el archivo `quarkus-run.jar`, la aplicación no se ejecutará.

Ahora la aplicación es ejecutable con el comando `/ruta/a/java/bin/java -jar target/quarkus-app/quarkus-run.jar`.

Para obtener el jar compilado con sus dependencias dentro de un solo archivo, se debe ejecutar:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```
Ahora se puede ejecutar solo llamando al jar
