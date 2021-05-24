# PROGRAMACION EN SISTEMAS UNIX
##

## Lugar y hora de la clase
>Laboratorio 1 Basico los dias miercoles de 1 a 3 pm.

<br>

## Lenguaje a usar
>La asignatura se vera implementada bajo el lenguaje de programacion Java, aplicacndo tecnicas sobre envio de objetos por red o serializacion de los mismos.

## Kit de desarrollo
- El software recomandado para el desarrollo de las actividades y practicas sera NetBeans. 

- Sistema operativo que utilice el kernel de linux (Ubuntu, Debian, etc).

- Version de java desde 7.0 o superior.

>La tecnologia que principalmente sera el RMI [(Remote Method Invocation).](https://es.wikipedia.org/wiki/Java_Remote_Method_Invocation), dicha tecnologia solamente se encuentra disponible para el lenguaje java

```java
// El paquete RMI debe ser accesido de la siguiente manera
import java.rmi.*;
...
```

> De esta manerea hemos importado todos las clases y metodos del paquete RMI, en caso de querer acceder algunas funcionalidades especificas de dicho paquete podemos hacer lo de la siguiente manera.

```java
// Algunos ejemplos de clases que RMI nos proporciona

import java.rmi.Naming; //La clase Naming proporciona métodos para almacenar y obtener referencias a objetos remotos en un registro de objetos remotos.

import java.rmi.Remote; //La interfaz remota sirve para identificar interfaces cuyos métodos pueden invocarse desde una máquina virtual no local.

import java.rmi.Registry; //Registry es una interfaz remota para un registro de objetos remotos simple que proporciona métodos para almacenar y recuperar referencias de objetos remotos enlazadas con nombres de cadenas arbitrarios.
...
```

## Temas abordados
> Encuentro #01 => Principios de POO. [Enlaces de los ejercicios del primer encuentro](https://github.com/DerianCordobaPerez/PROGRAMACION-SISTEMAS-UNIX/tree/Master/Encuentro%20%2301).

> Encuentro #02 => Principios de RMI. [Enlaces de los ejercicios del segundo encuentro](https://github.com/DerianCordobaPerez/PROGRAMACION-SISTEMAS-UNIX/tree/Master/Encuentro%20%2302)

> Proximo encuentro => **_26/05/2021_**