using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataObjects
{
    /// <summary>
    /// Name: Horde.cs
    /// Purpose: The horde object that inherets from the zombie object.
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-01-09  Clay        1.0         Initial
    /// 
    /// I really wonder if anyone reads the comments. I wonder...If I offer
    /// a bounty to the first person to identify this comment....Game on.
    /// Seriously...read the comments. Its worth your time. See how Horde
    /// takes almost all its code and properties from Zombie.
    /// 
    /// And also I will anounce the winner as soon as I get my first email.
    /// the question...you must answer...what sound does a horde make?
    /// 
    /// </summary>
    class Horde : Zombie
    {
        //Another enum for the size of the horde. The classifican choice for the size of a group
        //Zombies? BigglyBig?? Sometimes you have schema choices that don't make sense but match
        //everywhere in the system you have been hired to deal with. You should make better choices for 
        //what enums can accomplish...Great Exam or Interview Question....
        //Small is low. BigglyBig is High. :)
        public enum HordeSize
        {
            Small,
            Medium,
            Large,
            Big,
            Huge,
            BigglyBig

        }

        public HordeSize ContactHordeSize;

        /// <summary>
        /// Name: Horde
        /// Purpose: Default Constructor
        /// 
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial
        /// </summary>
        public Horde()
        {
            this.ContactLocation = new GeoEngine_Workspace.Location();
            this.ContactName = "";
            this.ContactType = ZType.Slow;
            this.ContactHordeSize = HordeSize.Small;
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
        /// <param name="Size"></param>
        public Horde(GeoEngine_Workspace.Location L, String N, ZType ZType, HordeSize Size)
        {
            this.ContactLocation = L;
            this.ContactName = N;
            this.ContactType = ZType;
            this.ContactHordeSize = Size;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial 
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
        /// <param name="Size"></param>
        public Horde(double Lat, double Long, double Elevate, int Year, int Month, int Day, ZType ZType, String Name, HordeSize Size)
        {
            this.ContactLocation = new GeoEngine_Workspace.Location(Lat, Long, Elevate);
            this.ContactLocation.SetDate(Year, Month, Day);
            this.ContactType = ZType;
            this.ContactName = Name;
            this.ContactHordeSize = Size;
        }

        /// <summary>
        /// Name: MakeNoise
        /// Purpose: A testing function.
        /// 
        /// Date        Coder       Vers        Notes
        /// 2020-01-08  Clay        1.0         Initial 
        /// 
        /// This is the overrride function for the virtual function in
        /// the Zombie class. Inheretince!
        /// </summary>
        public override void MakeNoise()
        {
            Console.WriteLine("We all want BRAINS!!!");
        }

    }
}