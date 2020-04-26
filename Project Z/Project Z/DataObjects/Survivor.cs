using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataObjects
{
    /// <summary>
    /// Name: Survivor.cs
    /// Purpose: The survivor object.
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-01-08  Clay        1.0         Initial 
    /// </summary>
    public class Survivor
    {
        public String ContactName;
        private int SurvivorContactNumber;

        public Survivor()
        {
        ContactName = "Chuck Norris";
            SurvivorContactNumber = 0;

        }

        public Survivor(int S)
        {
            SurvivorContactNumber = S;
        }

        public Survivor(int S, String N)
        {
            SurvivorContactNumber = S;
            ContactName = N;
        }

        public static bool operator ==(Survivor LHS, Survivor RHS)
        {
            if(LHS.SurvivorContactNumber == RHS.SurvivorContactNumber &&
               LHS.ContactName == RHS.ContactName && 
               String.IsNullOrEmpty(LHS.ContactName) == false &&
               String.IsNullOrEmpty(RHS.ContactName) == false)
            {
                return true;
            }
            return false;
        }

        public static bool operator !=(Survivor LHS, Survivor RHS)
        {
            if (LHS.SurvivorContactNumber == RHS.SurvivorContactNumber &&
               LHS.ContactName == RHS.ContactName &&
               String.IsNullOrEmpty(LHS.ContactName) == false &&
               String.IsNullOrEmpty(RHS.ContactName) == false)
            {
                return false;
            }
            return true;
        }

    }

   
}
