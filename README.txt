******************************************
******************************************
**					**
**	     SPACE REPORT v1		**
**					**
**					**
******************************************
******************************************

El proyecto Space report esta planteado pensando en un parque de diversiones,
llamado Spaceland, donde se quiere implantar un prototipo de comunicacion mucho mas 
actualizado y que haga uso de dispositivos moviles. Se piensa de la siguiente manera,
en Spaceland trabaja un gran numero de personas, entre ellos tecnicos, y demas personal.
Todos ellos conocen una serie de codigos que representan una solicitud, tal cual ocurre 
con los taxistas, policias, etc. Cuando un empleado quiere reportar o solicitar algo, 
accede a la aplicacion en su celular, y envia su nombre, cedula y codigo de solicitud.
De forma que en el area del parque en la que monitorean las solicitudes, dichas personas 
envien recursos a los solicitantes, o hagan lo necesario para responder a la solicitud. 


El proyecto tiene dos carpetas, que son dos proyectos en si,
ServerControllerGradle contiene todo el codigo con el se crea
el servidor, a partir de Application.java, y haciendo uso de 
los multiples archivos .java que alli se encuentran en la carpeta
src. En el caso de la carpeta SpaceReport, contiene todo lo necesario
para construir la aplicacion android. La actividad principal ocurre
en MainActivity.java, la conexion al servidor se ejecuta en 
ExecuteNetworkOperation.java.

En Spacereport/src/com/example/spacereport se encuentran:
ExecuteNetworkOperation.java ---> Hilo de red, donde se ejecuta la operacion
Intro.java ---> Pantalla de Presentacion de la app
MainActivity.java---> Hilo principal
Person.java --> Persona que se inserta al servidor
PersonSvcApi.java---> Define los gets y posts

IMPORTANTE: En caso de recibir errores enviando datos, chequee la conexion, y en el caso
de la evaluacion de este proyecto, se debe modificar la ip publica, que se encuentra en la linea
34 de ExecuteNetworkOperation.java, por la ip nueva que se indique.

