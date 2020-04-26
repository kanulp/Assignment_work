using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessClass
{
    public class TestDataGenerator
    {
        private List<String> FirstNames;
        private List<String> LastNames;
        private List<GeoEngine_Workspace.Location> Locations;
        private List<DataObjects.Zombie.ZType> ContactTypes;
        private NodaTime.LocalDate StartDate;
        private NodaTime.LocalDate EndDate;
        private int DataSetSize;
        private Random random; 

        public TestDataGenerator(int Iterations, NodaTime.LocalDate SDate, NodaTime.LocalDate EDate)
        {
            FirstNames = new List<string>();
            LastNames = new List<string>();
            Locations = new List<GeoEngine_Workspace.Location>();
            ContactTypes = new List<DataObjects.Zombie.ZType>();
            DataSetSize = Iterations;
            StartDate = SDate;
            EndDate = EDate;
            random = new Random();
            LoadLists();
        }

        private void LoadLists()
        {
            FirstNames.Add("Mary");
            FirstNames.Add("Mark");
            FirstNames.Add("Susan");
            FirstNames.Add("Sam");
            FirstNames.Add("Alice");
            FirstNames.Add("Art");
            FirstNames.Add("Betty");
            FirstNames.Add("Barry");
            FirstNames.Add("Cindy");
            FirstNames.Add("Charles");
            FirstNames.Add("Diane");
            FirstNames.Add("Derek");
            FirstNames.Add("Evangeline");
            FirstNames.Add("Eric");
            FirstNames.Add("Francine");
            FirstNames.Add("Frank");
            FirstNames.Add("Gilda");
            FirstNames.Add("Gary");

            LastNames.Add("Smith");
            LastNames.Add("Brown");
            LastNames.Add("Cameron");
            LastNames.Add("Vertman");
            LastNames.Add("Watt");
            LastNames.Add("McComb");
            LastNames.Add("Bore");
            LastNames.Add("Malcom");
            LastNames.Add("Strathmore");
            LastNames.Add("Middleton");
            LastNames.Add("Greenwood");
            LastNames.Add("Eliot");
            LastNames.Add("Charest");
            LastNames.Add("LeRoque");
            LastNames.Add("Travie");
            LastNames.Add("White");

            ContactTypes.Add(DataObjects.Zombie.ZType.Fast);
            ContactTypes.Add(DataObjects.Zombie.ZType.Medium);
            ContactTypes.Add(DataObjects.Zombie.ZType.Slow);
        }

        public List<DataObjects.Zombie> GenerateTestData()
        {
            List<DataObjects.Zombie> returnList = new List<DataObjects.Zombie>();

            for(int i = 0; i <= DataSetSize; ++i)
            {
                DataObjects.Zombie Z = this.RandomZombie();
                    returnList.Add(Z);
            }

            return returnList;
        }

        private DataObjects.Zombie RandomZombie()
        {
           
            NodaTime.Period P = NodaTime.Period.Between(StartDate, EndDate);
            int Days = random.Next(0,P.Days);
            NodaTime.LocalDate ZDate = StartDate.PlusDays(Days);
            DataObjects.Zombie Z = new DataObjects.Zombie();
            Z.ContactLocation.SetDate(ZDate.Year, ZDate.Month, ZDate.Day);
            Z.ContactName = FirstNames[random.Next(0, FirstNames.Count-1)] + " " + LastNames[random.Next(0, LastNames.Count-1)];
            Z.ContactType = ContactTypes[random.Next(0, ContactTypes.Count - 1)];
            Z.ContactLocation.SetLatitude(Convert.ToDouble(random.Next(0, 90)));
            Z.ContactLocation.SetLongitude(Convert.ToDouble(random.Next(-180,0)));
            Z.ContactLocation.SetElevation(Convert.ToDouble(random.Next(0, 250)));

            return Z;
        }

    }
}
