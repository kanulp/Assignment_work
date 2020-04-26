using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace DataObjects
{
    /// <summary>
    /// Name: Zombie.cs
    /// Purpose: The zombie object.
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-01-08  Clay        1.0         Initial
    /// 2020-01-09  Clay        1.1         Flushed out a few basic variables and properties
    /// 2020-01-17  Clay        1.2         Added the Serial Number integer the PK from the database.
    /// 2020-01-19  Clay        1.3         Added the Binary OperatorOverloads for Equal and Not Equal. Required for testing.
    /// </summary>
    public class Zombie
    {
        //https://www.w3schools.com/cs/cs_enums.asp
        //check out the enum artical. This is how I solve the differentiation problem.
       public enum ZType
        {
            Slow,
            Medium,
            Fast
        }


        public GeoEngine_Workspace.Location ContactLocation;
        public String ContactName;
        public ZType ContactType;
        public int ZombieSerialNumber { get; private set; }
        public int OrdinalPosition;
        
        public void SetZType(String Type)
        {
            if(Type == "Fast")
            {
                this.ContactType = ZType.Fast;
            }
            if(Type == "Slow")
            {
                this.ContactType = ZType.Slow;
            }
            if(Type == "Medium")
            {
                this.ContactType = ZType.Medium;
            }
        }

        public Zombie(int SerialNumber)
        {
            this.ZombieSerialNumber = SerialNumber;
        }

        /// <summary>
        /// Name: Zombie
        /// Purpose: Default Constructor
        /// 
        /// Date        Coder       Vers        Notes
        /// 2020-01-08  Clay        1.0         Initial
        /// 2020-01-09  Clay        1.1         Added the references to the new variables
        /// 
        /// </summary>
        public Zombie()
        {
            //Beware the defaults used when not passing the details to the location 
            //constructor.
            ContactLocation = new GeoEngine_Workspace.Location();
            ContactName = "";
            //ContactType = ZType.Slow;

        }

       
    

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial 
        /// 
        /// There will be several overloads for the constructor. 
        /// </summary>
        /// <param name="L"></param>
        /// <param name="N"></param>
        /// <param name="ZType"></param>
        public Zombie(GeoEngine_Workspace.Location L, String N, ZType ZType)
        {
            ContactLocation = L;
            ContactName = N;
            ContactType = ZType;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial 
        /// 2020-01-18  Clay        1.1         Added the serial number.
        /// 
        /// This is the biggie constructor :)
        /// </summary>
        /// <param name="Lat"></param>
        /// <param name="Long"></param>
        /// <param name="Elevate"></param>
        /// <param name="Year"></param>
        /// <param name="Month"></param>
        /// <param name="Day"></param>
        /// <param name="ZType"></param>
        /// <param name="Name"></param>
        public Zombie(double Lat, double Long, double Elevate, int Year, int Month, int Day, ZType ZType, String Name, int Serial)
        {
            ContactLocation = new GeoEngine_Workspace.Location(Lat, Long, Elevate);
            ContactLocation.SetDate(Year, Month, Day);
            ContactType = ZType;
            ContactName = Name;
            ZombieSerialNumber = Serial;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-18  Clay        1.0         Initial 
        /// 
        /// 
        /// This is the biggie constructor without the Serial Number. 
        /// Why would I need to different constructors. The answer is
        /// to remember who gives out the serial numbers. The database. :)
        /// </summary>
        /// <param name="Lat"></param>
        /// <param name="Long"></param>
        /// <param name="Elevate"></param>
        /// <param name="Year"></param>
        /// <param name="Month"></param>
        /// <param name="Day"></param>
        /// <param name="ZType"></param>
        /// <param name="Name"></param>
        public Zombie(double Lat, double Long, double Elevate, int Year, int Month, int Day, ZType ZType, String Name)
        {
            ContactLocation = new GeoEngine_Workspace.Location(Lat, Long, Elevate);
            ContactLocation.SetDate(Year, Month, Day);
            ContactType = ZType;
            ContactName = Name;
            ZombieSerialNumber = 0;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-18  Clay        1.0         Initial 
        /// 
        /// This is a binary operator overload for the not equal test.
        /// I will be doing a big talk about this coming up.
        /// </summary>
        /// <param name="LHS"></param>
        /// <param name="RHS"></param>
        /// <returns></returns>
        public static bool operator !=(Zombie LHS, Zombie RHS)
        {
            if (LHS.ContactLocation.Date == RHS.ContactLocation.Date &&
               LHS.ContactLocation.Elevation == RHS.ContactLocation.Elevation &&
               LHS.ContactLocation.Latitude == RHS.ContactLocation.Latitude &&
               LHS.ContactLocation.Longitude == RHS.ContactLocation.Longitude &&
               LHS.ContactName == RHS.ContactName &&
               LHS.ContactType == RHS.ContactType &&
               LHS.ZombieSerialNumber == LHS.ZombieSerialNumber)
            {
                return false;
            }
            return true;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-18  Clay        1.0         Initial 
        /// 
        /// This is a binary operator overload for the equality test.
        /// I will be doing a big talk about this coming up.
        /// </summary>
        /// <param name="LHS"></param>
        /// <param name="RHS"></param>
        /// <returns></returns>
        public static bool operator ==(Zombie LHS, Zombie RHS)
        {
            if (LHS.ContactLocation.Date == RHS.ContactLocation.Date &&
               LHS.ContactLocation.Elevation == RHS.ContactLocation.Elevation &&
               LHS.ContactLocation.Latitude == RHS.ContactLocation.Latitude &&
               LHS.ContactLocation.Longitude == RHS.ContactLocation.Longitude &&
               LHS.ContactName == RHS.ContactName &&
               LHS.ContactType == RHS.ContactType &&
               LHS.ZombieSerialNumber == LHS.ZombieSerialNumber)
            {
                return true;
            }
            return false;
        }




        /// <summary>
        /// Name: MakeNoise
        /// Purpose: A testing function.
        /// 
        /// Date        Coder       Vers        Notes
        /// 2020-01-08  Clay        1.0         Initial
        /// 
        /// </summary>
        public virtual void MakeNoise()
        {
            Console.WriteLine("Brains!");
        }
    }
}
