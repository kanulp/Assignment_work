using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project_Z
{
    /// <summary>
    /// Name: ProjectZFrontEnd.cs
    /// Purpose: The place where the project starts. Just for testing.
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-01-08  Clay        1.0         Initial
    /// 2020-01-22  CLay        1.1         Renamed the Class to ProjectZFrontEnd
    /// 
    /// </summary>
    class ProjectZFrontEnd
    {
        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-17  Clay        1.0         Initial
        /// 2020-01-21  Clay        1.1         Refactored to always keep at least 20
        ///                                     records in the DB.
        /// 
        /// </summary>
        /// <returns></returns>
        private static bool TestCode()
        {
            DataAccessClass.DataAccessClass TheDataBase = new DataAccessClass.DataAccessClass();

            List<DataObjects.Zombie> CurrentData = TheDataBase.GetAllZombies();
            if (CurrentData.Count < 200)
            {
                DataAccessClass.TestDataGenerator GenerateData = new DataAccessClass.TestDataGenerator(200, new NodaTime.LocalDate(2019, 01, 05), new NodaTime.LocalDate(2020, 01, 10));
                List<DataObjects.Zombie> TestData = GenerateData.GenerateTestData();
                foreach (DataObjects.Zombie Z in TestData)
                {
                    TheDataBase.InsertZombie(Z);
                }
            }

            List<DataObjects.TrackObject> TrackLists = new List<DataObjects.TrackObject>();

            TrackLists = TheDataBase.GetTrackByID(1);



            //Create a Zombie 
            DataObjects.Zombie Z10 = new DataObjects.Zombie(45.5, -81.5, 110, 2020, 01, 18, DataObjects.Zombie.ZType.Slow, "Fred the Zombie", 0);
            //Send it to the database
            DataObjects.Zombie Z20 = TheDataBase.InsertZombie(Z10);
            //Get another back from the database.
            DataObjects.Zombie Z30 = TheDataBase.GetZombieByID(Z20.ZombieSerialNumber);
            if (Z20 == Z30)
            {
                int x = 0;
            }



            //Now I need to organize some tests before I go any further...
            //So I can build some tests.

            //Test down to the database.
            DataAccessClass.DataAccessClass TheDatabase = new DataAccessClass.DataAccessClass();

            //Lets add a Zombie to the database
            DataObjects.Zombie Z0 = new DataObjects.Zombie(23.5, 34.989, 100, 1990, 02, 13, DataObjects.Zombie.ZType.Medium, "Charles");
            DataObjects.Zombie Z1 = TheDatabase.InsertZombie(Z0);

            //Now are these two zombies the same. Aside from the SerialNumber they should
            //be. That would be an important test that system works. If only there was an
            //easy way to compare zombies. We cant use this code. It will not work..yet.

            //if(Z0 == Z1)
            //{
            //    Console.WriteLine("Insert functioning properly.")
            //}

            //So lets get all the zombies.
            List<DataObjects.Zombie> TheZombieList = TheDatabase.GetAllZombies();

            //Lets get a zombie by its Primary Key.
            if (TheZombieList.Count >= 1)
            {
                DataObjects.Zombie TestZombie = TheDatabase.GetZombieByID(TheZombieList[0].ZombieSerialNumber);

            }

            //Lets update a zombie and then compare what we get using the GetZombieByID again.
            Z1.ContactType = DataObjects.Zombie.ZType.Fast;
            Z1.ContactName = "Simon Pegg";

            DataObjects.Zombie Z2 = TheDatabase.UpdateZombieByID(Z1);

            DataObjects.Zombie Z3 = TheDatabase.GetZombieByID(Z2.ZombieSerialNumber);

            //And we have to delete a Zombie by its pk.
            int ZombieAlive = TheDatabase.DeleteZombieByID(Z2.ZombieSerialNumber);


            GeoEngine_Workspace.Location L = new GeoEngine_Workspace.Location();
            Z0.MakeNoise();
            Console.ReadLine();

            DataObjects.Zombie Z4 = new DataObjects.Zombie();
            Z2.ContactType = DataObjects.Zombie.ZType.Fast;

            if (Z2.ContactType == DataObjects.Zombie.ZType.Fast)
            {
                Console.WriteLine("Fast");
            }
            return true;
        }
        


        static void Main(string[] args)
        {
            try
            {
                //TestCode();

                String TestString = "9999-12-31";

              

                Console.WriteLine("Welcome to Project Z! Zombies are cool!");
                Console.WriteLine("Conducting tests...");





            }
            catch (Exception E)
            {
                Console.WriteLine("Something went wrong.");
                Console.WriteLine(E.Message);
            }
        }
    }
}
