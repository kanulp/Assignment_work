using System;


namespace jessica_assignment2
{
    public class Employee
    {
         public Employee(){

        }
        public Employee(int employeeID,string firstName,double baseSalary){
            employeeId=employeeID;
            this.firstName=firstName;
            this.baseSalary=baseSalary;

        }

        private int employeeId;
        private string firstName;
        private string lastName;
        private double baseSalary;
        private double grossSales;
        private double commissionRate;



        public double Earnings(){

        }

       
    }
}