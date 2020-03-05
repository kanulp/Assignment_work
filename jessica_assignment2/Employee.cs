using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace jessica_assignment2
{
    public class Employee
    {
        #region constructor
        public Employee() { }
        public Employee(int employeeID, string firstName, double baseSalary)
        {
            employeeId = employeeID;
            this.firstName = firstName;
            this.baseSalary = baseSalary;
        }
        #endregion

        #region fields
        private int employeeId;
        private string firstName;
        private string lastName;
        private double baseSalary;
        private double grossSales;
        private double comissionRate;
        #endregion

        #region properties
        public int EmployeeId
        {
            get { return this.employeeId; }
        }
        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public double BaseSalary
        {
            get;
            set;
        } = 1000;

        public double GrossSales
        {
            get { return grossSales; }
            set { grossSales = value; }
        }

        public double ComissionRate
        {
            get;
            set;
        } = 0.1;
        #endregion

        #region method
        public double Earnings()
        {
            return (ComissionRate * GrossSales + BaseSalary);
        }
        #endregion region

    }
}
