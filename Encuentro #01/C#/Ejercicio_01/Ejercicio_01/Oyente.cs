using System;

namespace Ejercicio_01
{
    public class Oyente : Participante
    {
        public string Grado_Academico { get; set; }
        public Oyente() { }

        public Oyente(string nombre, string apellido, string email, string grado_Academico) : base(nombre, apellido, email)
        {
            this.Grado_Academico = grado_Academico;
        }
        
        public void LeerOyente()
        {
            LeerParticipante();
            Console.WriteLine("Ingrese el Grado Academico");
            Grado_Academico = Console.ReadLine();
        }

        public void mostrarOyente()
        {
            base.MostrarParticipante();
            Console.WriteLine($"Grado: {Grado_Academico}");
        }
        
    }
}