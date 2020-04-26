using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication2
{
    public partial class MarkersExample : System.Web.UI.Page
    {

        private List<DataObjects.Zombie> MasterZombieList;
        private DataAccessClass.DataAccessClass TheDatabase;

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
            catch (Exception E)
            {
                //Right now we are going to swallow errors. But we will soon 
                //log errors and help ourusers if somethinggoes wrong.
                //We DO NOT WANT TO SHOW ERRORS TO THE USER! 
            }
        }

        private void BindLocationList()
        {
            foreach (DataObjects.Zombie Z in this.MasterZombieList)
            {
                ListItem Item = new ListItem();
                Item.Text = Z.ContactName + " " + Z.ContactLocation.Date.ToString();
                Item.Attributes.Add("ZombieName", Z.ContactName);
                Item.Attributes.Add("Latitude", Z.ContactLocation.Latitude.ToString());
                Item.Attributes.Add("Longitude", Z.ContactLocation.Longitude.ToString());
                Item.Attributes.Add("Elevation", Z.ContactLocation.Elevation.ToString());
                Item.Attributes.Add("Date", Z.ContactLocation.Date.ToString());
                Item.Attributes.Add("SerialNumber", Z.ZombieSerialNumber.ToString());
                Item.Attributes.Add("ContactType", Z.ContactType.ToString());


                LocationList.Items.Add(Item);


            }


        }


    }
}