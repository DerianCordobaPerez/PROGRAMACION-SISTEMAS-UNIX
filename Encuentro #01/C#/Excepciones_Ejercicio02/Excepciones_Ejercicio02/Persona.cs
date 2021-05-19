using System;

namespace Excepciones_Ejercicio02
{
    public class Persona
    {
        public string Nombre { get; set; }
        public int Edad { get; set; }

        private void Encabezado()
        {
            if (this is Empleado) Console.WriteLine("\nDATOS DEL EMPLEADO");
            else Console.WriteLine("\nDATOS DE LA PERSONA");
        }
        public virtual void LeerPersona()
        {
            Encabezado();
            this.Nombre = Utilidades.LeerString("Ingrese el Nombre");
            this.Edad = Utilidades.LeerInt("Ingrese la Edad");
        }
        
        public virtual void MostrarDatos()
        {
            Encabezado();
            Console.WriteLine($"Nombre: {Nombre}, Edad: {Edad}");
        }
    }
}