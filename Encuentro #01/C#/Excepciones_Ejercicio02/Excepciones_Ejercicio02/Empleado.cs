using System;

namespace Excepciones_Ejercicio02
{
    public class Empleado : Persona
    {
        public double Sueldo { get; set; }
        public override void LeerPersona()
        {
            base.LeerPersona();
            this.Sueldo = Utilidades.LeerDouble("Ingrese el sueldo");
        }

        public override void MostrarDatos()
        {
            base.MostrarDatos();
            Console.WriteLine($"Sueldo: {Sueldo}");
        }
    }
}