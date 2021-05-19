namespace Ejercicio_01
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Oyente oyente = new Oyente();
            oyente.LeerOyente();
            oyente.mostrarOyente();
    
            Ponente ponente = new Ponente();
            ponente.LeerPonente();
            ponente.mostrarPonente();
        }
    }
}