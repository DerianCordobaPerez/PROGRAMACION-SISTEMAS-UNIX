using System;

namespace Excepciones_Ejercicio02
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Persona persona = new Persona();
            Empleado empleado = new Empleado();
            Persona personaEmpleado = new Empleado();

            persona.LeerPersona();
            empleado.LeerPersona();
            personaEmpleado.LeerPersona();
            
            Console.Clear();
            persona.MostrarDatos();
            empleado.MostrarDatos();
            personaEmpleado.MostrarDatos();
        }
    }
}