using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataObjects
{
    public class Toolset
    {
        public NodaTime.LocalDate StringToNodaDate(String D)
        {
            try
            {
            //Date Example "2020-01-01"
            string[] words = D.Split('-');
            return new NodaTime.LocalDate(Convert.ToInt32(words[0]), Convert.ToInt32(words[1]), Convert.ToInt32(words[2]));

            }
            catch(Exception E)
            {
                throw E;
            }
           
        }

        public String[] ConvertZombieListToStringArray(List<Zombie> ZList)
        {
            List<String> WorkList = new List<string>();

            foreach(Zombie Z in ZList)
            {
                WorkList.Add(   Z.ContactName + "|" + 
                                Z.ContactType + "|" + 
                                Z.ZombieSerialNumber + "|" +
                                Z.ContactLocation.Latitude + "|" +
                                Z.ContactLocation.Longitude + "|" +
                                Z.ContactLocation.Elevation + "|" +
                                Z.ContactLocation.Date);
            }
            String[] returnArray = WorkList.ToArray();
            return returnArray;
        }

    }
}
