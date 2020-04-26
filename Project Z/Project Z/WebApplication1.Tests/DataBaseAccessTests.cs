using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace WebApplication1.Tests
{
    [TestClass]
    public class DataBaseAccessTests
    {
        [TestMethod]
        public void TestInsert()
        {
            DataAccessClass.DataAccessClass TheDataBase = new DataAccessClass.DataAccessClass();

            //Create a Zombie 
            DataObjects.Zombie Z1 = new DataObjects.Zombie(45.5, -81.5, 110, 2020, 01, 18, DataObjects.Zombie.ZType.Slow, "Fred the Zombie", 0);
            //Send it to the database
            DataObjects.Zombie Z2 = TheDataBase.InsertZombie(Z1);
            //Get another back from the database.
            DataObjects.Zombie Z3 = TheDataBase.GetZombieByID(Z2.ZombieSerialNumber);
            //That means down to the database and back works.
            Assert.IsTrue(Z2 == Z3);
        }

        [TestMethod]
        public void TestUpdate()
        {
            DataAccessClass.DataAccessClass TheDataBase = new DataAccessClass.DataAccessClass();

            //Create a Zombie 
            DataObjects.Zombie Z1 = new DataObjects.Zombie(-45.5, 81.5, 210, 2019, 02, 02, DataObjects.Zombie.ZType.Fast, "Martin VanNostrum", 0);
            //Send it to the database
            DataObjects.Zombie Z2 = TheDataBase.InsertZombie(Z1);

            //Lets make some changes to the zombie.
            Z2.ContactName = "Lana Kane";

            //And send it to the database as update.
            DataObjects.Zombie Z3 = TheDataBase.UpdateZombieByID(Z2);

            //Get another back from the database.
            DataObjects.Zombie Z4 = TheDataBase.GetZombieByID(Z3.ZombieSerialNumber);
            //That means down to the database and back works.
            Assert.IsTrue(Z3 == Z4);
        }



    }
}
