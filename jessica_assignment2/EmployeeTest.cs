using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace jessica_assignment2
{
    class EmployeeTest
    {
        static void Main(string[] args)
        {
            Employee emp = new Employee();
            Employee emply = new Employee(1, "Employee1", 1000);

            Console.WriteLine("Enter Firstname:");
            emply.FirstName = Console.ReadLine();

            Console.WriteLine("Enter Lastname:");
            emply.LastName = Console.ReadLine();

            Console.WriteLine("Enter Base salary:");
            emply.BaseSalary = Console.ReadLine() != "" ? Convert.ToDouble(Console.ReadLine()) : emply.BaseSalary;

            Console.WriteLine("Enter Gross sales:");
            double grosssales = Convert.ToDouble(Console.ReadLine());

            while (!ZeroOrNegative(grosssales))
            {
                Console.WriteLine("Gross sales should not be zero or negative, enter again.");
                grosssales = Convert.ToDouble(Console.ReadLine());
            }

            emply.GrossSales = grosssales;

            Console.WriteLine("Enter Comission rate:");
            double comissionrate = Console.ReadLine() != "" ? Convert.ToDouble(Console.ReadLine()) : emply.ComissionRate;

            while (!ZeroOrNegative(comissionrate))
            {
                Console.WriteLine("Comission rate should not be zero or negative, enter again.");
                comissionrate = Convert.ToDouble(Console.ReadLine());
            }

            while (!BetweenRanges(0.1, 1.0, comissionrate))
            {
                Console.WriteLine("Please enter between 0.1 and 1.0, try again.");
                comissionrate = Convert.ToDouble(Console.ReadLine());
            }

            emply.ComissionRate = comissionrate;

            Console.WriteLine("Your earnings: $ " + emply.Earnings());
            Console.ReadKey();
        }

        public static bool ZeroOrNegative(double value)
        {
            return (value > 0);
        }

        public static bool BetweenRanges(double a, double b, double value)
        {
            return (a <= value && value <= b);
        }
    }
}
