using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SurvivorTester
{
    class Program
    {
        static void Main(string[] args)
        {
            DataObjects.Survivor S1 = new DataObjects.Survivor(1);
            DataObjects.Survivor S2 = new DataObjects.Survivor(1);

            int ValueA = 10;
            int ValueB = 20;
            int ValueC = 10;

            if(S1 == S2)
            {
                Console.WriteLine("Equal");
            }

            if(ValueA == ValueC)
            {

                Console.WriteLine("Equal");
            }
        }
    }
}
