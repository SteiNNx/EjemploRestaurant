# EjemploRestaurant

Privilegios
=======
Usuario:jora
Password:1234


Caso 
=====
- Se nos solicito crear una aplicacion, que simule un restaurant en el cual el usuario se logee y se desplegen las distintas opciones que el posea
- Las Distintas opciones del Usuario son:
  - Generar Pedido
  - Listar Pedidos
  - Cerrar Sesion

Requerimientos
==============
- Desarrollar una Aplicacion:
  - Lenguaje Nativo Android
  - Consumir un Servicio Web REST API    http://kailalkalil.esy.es/WebServices_Restaurante/
  - Base de Datos MySQL https://www.hostinger.es/

¿Que Utilizamos?
================
- Para la Serializacion usamos Retrofit      link Documentacion => http://square.github.io/retrofit/
  - compile 'com.squareup.retrofit2:retrofit:2.3.0'
  - compile 'com.squareup.retrofit2:converter-gson:2.3.0'
  
- Para Visualizacion de Imagenes usamos Picasso link Documentacion => http://square.github.io/picasso/
  - compile 'com.squareup.picasso:picasso:2.5.2'
  
- Material Design 
  - compile 'com.android.support:appcompat-v7:25.3.1'
  - compile 'com.android.support:design:25.3.1'
  - compile 'com.android.support:support-v4:25.3.1'
