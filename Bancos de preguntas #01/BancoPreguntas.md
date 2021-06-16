# Banco de preguntas Programacion sistemas distribuidos
## Primera pregunta
### Dentro de una interface en java, la siguiente sintaxis es valida?
```java
default String saltar(String... args) {
    return "Estoy saltando a una distancia de " + args[0];
}
```
[X] Verdadero [ ] Falso
<hr>

## Segunda pregunta
### Cual es el puerto por defecto lanzado para las aplicaciones de RMI en java
<br>

[X] 1099 [ ] 1109 [ ] 2099 [ ] 10099 [ ] Ninguno de los anteriores
<hr>

## Tercera pregunta
### Se tiene una interface ISaludo, la cual es implementada por el servidor, se necesita crear una variable con el nombre stub haciendo uso de la clase UnicastRemoteObject, completa el codigo para realizar esta accion siendo exportado en el puerto 0
```java
ISaludo saludo = new SaludoServidor();
saludo.mensaje = "Hola desde el servidor";

// Respuesta
ISaludo stub = (ISaludo) UnicastRemoteObject.exportObject(saludo, 0);
```
<hr>

## Cuarta pregunta
### Todos los metodos de una interfaz que deriva de la interfaz Remote no es obligatorio establecer el uso de la excepcion RemoteException
<br>

[ ] Verdadero [X] Falso
<hr>

## Quinta pregunta
### Que excepcion lanza el metodo bind de la clase Registry
<br>

[X] AlreadyBoundException [ ] IOException [ ] RemoteException [ ] MalformedURLException [ ] La tercera y cuarta respuesta son correctas
<hr>

## Sexta pregunta
### Desde la clase Naming cual es el metodo que encuentra cualquier objeto exportado a la red
```java
// Respuesta
Naming.lookup("Nombre del objeto")
```
<hr>

## Septima pregunta
### Los metodos creados desde una clase Servidor que no se encuentren implementados desde la interfaz seran visibles para el cliente
<br>

[ ] Verdadero [X] Falso
<hr>

## Octava pregunta
### Seleccione los metodos que nos permiten hacer visible un objeto en la red
<br>

[ ] [registry, createRegistry]
[X] [rebind, bind]
[ ] [registry, startRegistry]
[ ] [bind, exportObject]
[ ] [bind, getRegistry]
<hr>

## Novena pregunta
### Palabra reservada que hace referencia al objeto actual dentro de la clase
```java
this
```

### Decima pregunta
### Al obtener un objeto exportado por el servidor que excepcion se puede generar
<br>

[ ] RemoteException
[X] ClassCastException
[ ] ExportException
[ ] MalformedURLException
[ ] StubNotFoundException
<hr>