using System;

namespace Excepciones_Ejercicio02
{
    public class Utilidades
    {
        public static string LeerString(string enunciado)
        {
            string cadena;
            do
            {
                Console.WriteLine(enunciado);
                cadena = Console.ReadLine().Trim();
                if(String.IsNullOrEmpty(cadena)) Console.WriteLine("El nombre no puede ser un campo vacio, favor ingreselo de nuevo");
            } while (String.IsNullOrEmpty(cadena));

            return cadena;
        }

        public static double LeerDouble(string enunciado)
        {
            try
            {
                Console.WriteLine(enunciado);
                return double.Parse(Console.ReadLine());
            }
            catch (FormatException)
            {
                Console.WriteLine("El formato ingreado no es le adecuado, favor ingresarlo nuevamente");
                return LeerDouble(enunciado);
            }
        }
        
        public static int LeerInt(string enunciado)
        {
            try
            {
                Console.WriteLine(enunciado);
                return int.Parse(Console.ReadLine());
            }
            catch (FormatException)
            {
                Console.WriteLine("El formato ingreado no es le adecuado, favor ingresarlo nuevamente");
                return LeerInt(enunciado);
            }
        }
    }
}