using System;

namespace Ejercicio_01
{
    public class Participante
    {
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        public string Email { get; set; }
        
        public Participante() { }
        
        public Participante(string nombre, string apellido, string email)
        {
            Nombre = nombre;
            Apellido = apellido;
            Email = email;
        }
        
        public void LeerParticipante()
        {
            Console.WriteLine("Rellene los Datos Personales : ");

            Console.Write("Nombre: ");
            Nombre = Console.ReadLine();

            Console.Write("Apellido: ");
            Apellido = Console.ReadLine();

            Console.Write("Ingrese su Email: ");
            Email = Console.ReadLine();
        }
        
        protected void MostrarParticipante()
        {
            Console.WriteLine($"DATOS DEL PARTICIPANTE\nNombre: {Nombre}\nApellido: {Apellido}\nEmail: {Email}");
        }
        
    }
}