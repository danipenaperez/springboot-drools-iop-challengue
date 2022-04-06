
# IOP-GRID-PRICES-CHALLENGE
Applicacion que calcula precios en base a productos, compañia y momento en el tiempo.
## Comentarios
La aplicacion esta construida sobre Maven y Spring Boot, usando persistenca H2 y Drools para la ejecucion del motor de Reglas.
Se ha hecho un enfoque a DDD (Domain Driven Desing) para mantener una arquitectura Clean implementada sobre una Arquitectura hexagonal (Ports & Adapters).

- Para la carga inicial de datos se ha usado flyway, scripts en la carpeta src/main/resources/db/migration
- Para la generacion a partir de enfoque API First se ha usado openapi-generator. el fichero de deficion de api se encuentra en src/main/resource/iop-grid-openapi-spec-v1.yml
- La decision de elegir la tarifa de mayor prioridad en caso de exisitr mas de una tarifa en el periodo se ha delegado en un motor de reglas (drools), se encuentran las reglas en la carpeta src/main/resources/rules
- Se han creado unos usuarios con distintos roles para implementar la seguridad en la aplicacion , las credenciales se pueden sacar de los scripts de bbdd en src/main/resources/db/migrationV1.1__create_initial_user_role_data
- La seguridad esta basada en estandar OAuth con JWT
- Existe una bateria de Test de integracion (Postman) en la carpeta /postman. Se encuentra el environment y la collection. Se pueden ejecutar con newman.

## Funcionalidad a probar
Para probar la aplicacion, no se requiere de nada en especial (quizas las dependencias de drools tengan que se descargadas desde los artifactory de Jboss, creo que no es necesario,pero ahi lo dejo).
Como contexto de la aplicacion,existe la documentacion funcional en la carpeta /documentacion_funcional

Paso 1:
```
mvn clean install spring-boot:run
```
Paso 2:
Ejecutar la Coleccion de postman en /postman iop-grid.postman_collection.json. La collecion contiene verificaciones en el apartado "test" de cada Request.

