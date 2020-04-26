using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    /// <summary>
    /// Date        Coder       Vers        Notes
    /// 2020-01-18  Clay        1.0         Initial 
    /// 
    /// </summary>
    public partial class MapHome : System.Web.UI.Page
    {
        //Nobody gets to see these. This is supposed to be hidden and secure.
        //Never make anythig public here if you can make it private.
        private static List<DataObjects.Zombie> MasterZombieList;
        private static DataAccessClass.DataAccessClass TheDatabase;

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-18  Clay        1.0         Initial 
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                //So lets build the parts we need. Now for the term using...
                using (DataAccessClass.DataAccessClass TheDatabase = new DataAccessClass.DataAccessClass())
                {
                    MasterZombieList = TheDatabase.GetAllZombies();
                    BindLocationList();
                    //When this using ends. This object dies. No loose database connections
                }
            }
            catch(Exception E)
            {
                //Right now we are going to swallow errors. But we will soon 
                //log errors and help ourusers if somethinggoes wrong.
                //We DO NOT WANT TO SHOW ERRORS TO THE USER! 
            }
        }

        private void BindLocationList()
        {
            foreach (DataObjects.Zombie Z in MasterZombieList)
            {
                ListItem Item = new ListItem();
                Item.Text = Z.ContactName + " " + Z.ContactLocation.Date.ToString();
                Item.Attributes.Add("ZombieName", Z.ContactName);
                Item.Attributes.Add("Latitude", Z.ContactLocation.Latitude.ToString());
                Item.Attributes.Add("Longitude", Z.ContactLocation.Longitude.ToString());
                Item.Attributes.Add("Elevation",Z.ContactLocation.Elevation.ToString());
                Item.Attributes.Add("Date", Z.ContactLocation.Date.ToString());
                Item.Attributes.Add("SerialNumber", Z.ZombieSerialNumber.ToString());
                Item.Attributes.Add("ContactType", Z.ContactType.ToString());

               
                LocationList.Items.Add(Item);


            }


        }
        //Code the Web Method(s) here. Its near the bottom.

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-26  Clay        1.0         Initial 
        /// 
        /// Call down to the database and insert the Marker.
        /// </summary>
        /// <returns></returns>
        [System.Web.Services.WebMethod()]
        public static int CreateMarker(String Name, Double Elevation, String Date, int Serial, String ContactType, Double Lat, Double Long)
        {
            //We are going to have to some syntax acrobatics to get the Zombie in the database.
            //Lets try to figure the date out

            DataObjects.Toolset Tools = new DataObjects.Toolset();

            NodaTime.LocalDate D = Tools.StringToNodaDate(Date);
            GeoEngine_Workspace.Location Loc = new GeoEngine_Workspace.Location(Lat, Long, Elevation);
            Loc.SetDate(D.Year, D.Month, D.Day);

            DataObjects.Zombie Z = new DataObjects.Zombie(Loc, Name, DataObjects.Zombie.ZType.Slow);
            Z.SetZType(ContactType);
            DataObjects.Zombie ReturnZombie = new DataObjects.Zombie();
            using (DataAccessClass.DataAccessClass TheDatabase = new DataAccessClass.DataAccessClass())
            {
                ReturnZombie = TheDatabase.InsertZombie(Z);
            }
            return ReturnZombie.ZombieSerialNumber;
            
           
        }
        [System.Web.Services.WebMethod()]
        public static int DeleteMarkerByID(int PK)
        {
            using (DataAccessClass.DataAccessClass TheDatabase = new DataAccessClass.DataAccessClass())
            {
                return TheDatabase.DeleteZombieByID(PK);
            }
        }


        [System.Web.Services.WebMethod()]
        public static String[] GetAllMarkersByDateRange(String StartDate, String EndDate)
        {
            DataObjects.Toolset Tools = new DataObjects.Toolset();
            NodaTime.LocalDate ZStartDate = Tools.StringToNodaDate(StartDate);
            NodaTime.LocalDate ZEndDate = Tools.StringToNodaDate(EndDate);
            using (DataAccessClass.DataAccessClass TheDatabase = new DataAccessClass.DataAccessClass())
            {
                MasterZombieList = TheDatabase.GetAllZombiesByDateRange(ZStartDate, ZEndDate);
            }
            String[] ZombieArray = Tools.ConvertZombieListToStringArray(MasterZombieList);

            return ZombieArray;
        }

    }
}