using System;

namespace Ejercicio_01
{
    public class Ponente : Participante
    {
        public string Titulo_Ponencias { get; set; }
        public string Tematicas { get; set; }
        
        public Ponente() {}
        public Ponente(string nombre, string apellido, string email, string tituloPonencias, string tematicas)
            : base(nombre, apellido, email)
        {
            Titulo_Ponencias = tituloPonencias;
            Tematicas = tematicas;
        }
        
        public void LeerPonente()
        {
            LeerParticipante();
            Console.WriteLine("Ingrese el titulo de la ponencia");
            Titulo_Ponencias = Console.ReadLine();
            Console.WriteLine("Ingrese la tematica de la ponencia");
            Tematicas = Console.ReadLine();
        }
        
        public void mostrarPonente()
        {
            MostrarParticipante();
            Console.WriteLine($"Titulo: {Titulo_Ponencias}\nTematica: {Tematicas}");
        }
    }
}