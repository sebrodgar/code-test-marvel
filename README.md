# Marvel technical test
Este es un proyecto que se ha desarrollado como ejercicio técnico. En ella se solicita la creación de dos pantallas:
 - Pantalla en forma de listado de personajes.
 - Pantalla para ver el detalle de un personaje.
Los datos a mostrar se obtendrían de la API https://developer.marvel.com/

Como recomendaciones se establecieron las siguientes:
 - Usar Android Studio para el desarrollo.
 - Se puede hacer uso de frameworks y librerías de terceros.
 - Se valorará la implementación de tests
 - Se valorará un correcto control de errores.
 - Total libertad para añadir cualquier funcionalidad extra que se considere.

 ## Tecnologías usadas
 Desarrollada la prueba en lenguaje Kotlin. Las librerías usadas aparte de las de androidx son:

#### Consumo de apis
 - Gson
 - Retrofit
 - Okhttp
#### Injeccion de dependencias
 - Dagger2
#### Testing
 - Mockito
#### Debug
 - Chucker para mostrar los logs de las peticiones HTTP.
 - LeakCanary para prevenir memory leaks.
#### Otras
  - Glide para mostrar las imágenes.

 Además de kotlin se han usado las librerias para hacer uso de las coroutinas con flow.

 ## Arquitectura
 Se ha decidido realizar la arquitectura MVVM ya que con esta arquitectura se puede testear muy bien la aplicación. Para ello se han organizado las carpetas divididas en una carpeta de common(se utiliza para guardar todo lo que es común para todas las capas) y luego una carpeta para cada capa (data, domain, presentation). Dentro de cada capa se divide en features, de esta manera hace más fácil la escalabilidad si en un futuro se quisiese ampliar las funcionalidades. 

  ## Testing
Se ha desarrolla testing de la capa de datos, dominio y presentacion, distribuidas por carpetas igual que lo comentado en el punto anterior.

Por falta de tiempo no se ha podido realizar una cobertura de test acorde para cubrir todos los casos posibles de cada apartado, como pueden ser los diferentes errores, aun así, se ha desarrollado diferentes test para mostrar el testing en diferentes capas de la arquitectura.

  ## Mejoras
Como mejoras incluiría:
 - Cacheo de la información en una base de datos sqlite a través de Room, con esta arquitecutura sería fácil añadirlo.
 - Añadir más testing unitario para cubrir todos los posibles errores.
 - Añadir más funcionalidades, por ejemplo mostrar las series, comics, stories y eventos relacionados con un personaje cuando se entre en el detalle del mismo.
 - Añadir testing de interfaz.

  ## Comentarios
El desarrollo se ha centrado en gran parte en la creación de una arquitectura que sea muy escalable y fácil para agregar nuevas funcionalidades.