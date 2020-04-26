using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessClass
{
    /// <summary>
    /// Date        Coder       Vers        Notes
    /// 2020-01-18  Clay        1.0         Initial  
    /// 
    ///This class inherits from IDisposable. The idea is we can destroy these objects safely.
    /// </summary>
    public class DataAccessClass: IDisposable
    {
        List<DataObjects.Zombie> MasterZombieList;

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-17  Clay        1.0         Initial 
        /// Default Constructor
        /// </summary>
        public DataAccessClass()
        {
            MasterZombieList = new List<DataObjects.Zombie>();
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial 
        /// 
        /// There are many other ways of validating a connection to a database.
        /// This is a basic easy to understand method. Current technology is 
        /// using Active Directory (Outside the scope of this course). Security 
        /// a new and crticial emerging specialty. BTW we teach that specialty at Fanshawe...
        /// </summary>
        /// <returns></returns>
        public String GetConnectionString()
        {
            return "Server=DESKTOP-IU04KMD;Database=DB_ProjectZ;Trusted_Connection=Yes;";

        }

        /// Date        Coder       Vers        Notes
        /// 2020-01-17  Clay        1.0         Initial 
        /// 
        /// 
        public DataObjects.Zombie GetZombieByID(int PK)
        {
            DataObjects.Zombie ReturnZombie = new DataObjects.Zombie();

            try
            {
                System.Data.SqlClient.SqlDataReader t = PDM.Data.SqlHelper.ExecuteReader(GetConnectionString(), "sp_GetZombieByID", PK);

                if (t.HasRows)
                {

                    while (t.Read())
                    {
                        //I copied my query from the database so I can get the order right. :)

                        //SELECT L.LocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR, L.OccurenceDate), DATEPART(MONTH, L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name] FROM tbl_ContactLocation CL
                        //JOIN tbl_Location L ON L.LocationID = CL.LocationFK
                        //JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
                        DataObjects.Zombie NewZombie = new DataObjects.Zombie(Convert.ToInt32(t[0]));
                        NewZombie.ContactLocation = new GeoEngine_Workspace.Location(Convert.ToDouble(t[2]), Convert.ToDouble(t[3]), Convert.ToInt32(t[1]));
                        //I really should add a new Location Constructor to include the date.
                        NewZombie.ContactLocation.SetDate(Convert.ToInt32(t[4]), Convert.ToInt32(t[5]), Convert.ToInt32(t[6]));
                        NewZombie.SetZType(t[7].ToString());
                        NewZombie.ContactName = t[8].ToString();
                        ReturnZombie = NewZombie;
                    }

                }
            }

            //This is the catch block
            catch (SqlException SQLE)
            {

            }
            catch (Exception e)
            {

            }
            finally
            {

            }
            return ReturnZombie;
        }

        public int DeleteZombieByID(int PK)
        {
            bool q = false;
            int result = 0;
            try
            {
                object S = PDM.Data.SqlHelper.ExecuteScalar(GetConnectionString(), "sp_DeleteZombieByID",PK);
                q = Int32.TryParse(S.ToString(), out result);
                
                if(q)
                {
                    return result;
                }

            }

            //This is the catch block
            catch (SqlException SQLE)
            {
                //Im swallowing this error and indicating the failure. 
                //My program expects these often. The net is a dangerous place.
                return 0;
            }
            catch (Exception e)
            {
                //I am kicking this error up the stack to deal with later.
                throw e;
            }
            finally
            {
                //Nothing to seee here folks....I might write some logging here in a
                //later week.
            }
            return 0;
        }
        
        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-17  Clay        1.0         Initial 
        /// 
        /// This is a bit tricky. Its kinda different from GetZombieByID.
        /// I have to have the zombie to change. The idea is the zombie goes into this function
        /// and a new one comes out. Might be slower for large sets of updates. But I dont think I have to 
        /// worry about that...yet..
        /// </summary>
        public DataObjects.Zombie UpdateZombieByID(DataObjects.Zombie Z)
        {
            bool q = false;
            int result = 0;
            try
            {
                //@Elevation INT,
                //@Latitude DECIMAL(10, 8),
                //@Longitude DECIMAL(11,8),
                //@DATE DATETIME,
                //@ContactType VARCHAR(MAX)
                object S = PDM.Data.SqlHelper.ExecuteScalar(GetConnectionString(), "sp_UpdateZombieByID", Z.ContactLocation.Elevation, Z.ContactLocation.Latitude, Z.ContactLocation.Longitude, Z.ContactLocation.Date.ToString(), Z.ContactType, Z.ZombieSerialNumber, Z.ContactName);
                q = Int32.TryParse(S.ToString(), out result);
                return new DataObjects.Zombie(Z.ContactLocation.Latitude, Z.ContactLocation.Longitude, Z.ContactLocation.Elevation, Z.ContactLocation.Date.Year, Z.ContactLocation.Date.Month, Z.ContactLocation.Date.Day, Z.ContactType, Z.ContactName, result);

            }

            //This is the catch block
            catch (SqlException SQLE)
            {
                //Im swallowing this error and indicating the failure. 
                //My program expects these often. The net is a dangerous place.
                return new DataObjects.Zombie(0);
            }
            catch (Exception e)
            {
                //I am kicking this error up the stack to deal with later.
                throw e;
            }
            finally
            {
                //Nothing to seee here folks....I might write some logging here in a
                //later week.
            }
            return new DataObjects.Zombie(0);

        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-17  Clay        1.0         Initial 
        ///
        /// </summary>
        /// <param name="Z"></param>
        /// <returns></returns>
        public DataObjects.Zombie InsertZombie(DataObjects.Zombie Z)
        {
            bool q = false;
            int result = 0;
            try
            {
                //@Elevation INT,
                //@Latitude DECIMAL(10, 8),
                //@Longitude DECIMAL(11,8),
                //@DATE DATETIME,
                //@ContactType VARCHAR(MAX)
                object S = PDM.Data.SqlHelper.ExecuteScalar(GetConnectionString(), "sp_InsertZombie", Z.ContactLocation.Elevation, Z.ContactLocation.Latitude, Z.ContactLocation.Longitude, Z.ContactLocation.Date.ToString(), Z.ContactType, Z.ContactName);
                q = Int32.TryParse(S.ToString(), out result);
                return new DataObjects.Zombie(Z.ContactLocation.Latitude, Z.ContactLocation.Longitude,Z.ContactLocation.Elevation,Z.ContactLocation.Date.Year, Z.ContactLocation.Date.Month,Z.ContactLocation.Date.Day, Z.ContactType, Z.ContactName, result);

            }

            //This is the catch block
            catch (SqlException SQLE)
            {
                //Im swallowing this error and indicating the failure. 
                //My program expects these often. The net is a dangerous place.
                return new DataObjects.Zombie(0);
            }
            catch (Exception e)
            {
                //I am kicking this error up the stack to deal with later.
                throw e;
            }
            finally
            {
                //Nothing to seee here folks....I might write some logging here in a
                //later week.
            }
            return new DataObjects.Zombie(0); 
        }

        public List<DataObjects.TrackObject> GetTrackByID(int PK)
        {
            List<DataObjects.TrackObject> returnList = new List<DataObjects.TrackObject>();
            DataObjects.TrackObject T = new DataObjects.TrackObject();
            try
            {
                System.Data.SqlClient.SqlDataReader t = PDM.Data.SqlHelper.ExecuteReader(GetConnectionString(), "SP_GetZombieTrackByID", PK);

                if (t.HasRows)
                {

                    while (t.Read())
                    {
                        //I copied my query from the database so I can get the order right. :)

                        //SELECT L.LocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR, L.OccurenceDate), DATEPART(MONTH, L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name], CL.ContactName,HIS.OrdinalNumber FROM tbl_ContactLocationHistory HIS
                        //JOIN tbl_Location L ON L.LocationID = HIS.LocationFK
                        //JOIN tbl_ContactLocation CL ON CL.ContactLocationID = HIS.ContactLocationFK
                        //JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
                        //WHERE CL.ContactLocationID = @ZombieID
                        //ORDER BY HIS.OrdinalNumber
                        DataObjects.Zombie NewZombie = new DataObjects.Zombie(Convert.ToInt32(t[0]));
                        NewZombie.ContactLocation = new GeoEngine_Workspace.Location(Convert.ToDouble(t[2]), Convert.ToDouble(t[3]), Convert.ToInt32(t[1]));
                        //I really should add a new Location Constructor to include the date.
                        NewZombie.ContactLocation.SetDate(Convert.ToInt32(t[4]), Convert.ToInt32(t[5]), Convert.ToInt32(t[6]));
                        NewZombie.SetZType(t[7].ToString());
                        NewZombie.ContactName = t[8].ToString();
                        NewZombie.OrdinalPosition = Convert.ToInt32(t[9]);
                        T.TheTrack.Add(NewZombie);
                    }
                    returnList.Add(T);
                }
                return returnList;
            }

            //This is the catch block
            catch (SqlException SQLE)
            {

            }
            catch (Exception e)
            {

            }
            finally
            {

            }
            return returnList;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-09  Clay        1.0         Initial 
        /// 2020-01-17  Clay        1.1         Changed the encapsulation to public
        /// 
        /// Yup. Get all the zombies from the database.
        /// </summary>
        /// <returns></returns>
        public List<DataObjects.Zombie> GetAllZombies()
        {
            MasterZombieList = new List<DataObjects.Zombie>();

            try
            {
                System.Data.SqlClient.SqlDataReader t = PDM.Data.SqlHelper.ExecuteReader(GetConnectionString(), "sp_GetAllZombies");

                if (t.HasRows)
                {

                    while (t.Read())
                    {
                        //I copied my query from the database so I can get the order right. :)

                        //SELECT L.LocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR, L.OccurenceDate), DATEPART(MONTH, L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name] FROM tbl_ContactLocation CL
                        //JOIN tbl_Location L ON L.LocationID = CL.LocationFK
                        //JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
                        DataObjects.Zombie NewZombie = new DataObjects.Zombie(Convert.ToInt32(t[0]));
                        NewZombie.ContactLocation = new GeoEngine_Workspace.Location(Convert.ToDouble(t[2]), Convert.ToDouble(t[3]), Convert.ToInt32(t[1]));
                        //I really should add a new Location Constructor to include the date.
                        NewZombie.ContactLocation.SetDate(Convert.ToInt32(t[4]), Convert.ToInt32(t[5]), Convert.ToInt32(t[6]));
                        NewZombie.SetZType(t[7].ToString());
                        NewZombie.ContactName = (t[8].ToString());
                        MasterZombieList.Add(NewZombie);
                    }

                }
            }

            //This is the catch block
            catch (SqlException SQLE)
            {

            }
            catch (Exception e)
            {

            }
            finally
            {

            }
            return MasterZombieList;
        }

        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-02-06  Clay        1.0         Initial 
        /// 
        /// Get all the zombies from the database based on a date range
        /// </summary>
        /// <returns></returns>
        public List<DataObjects.Zombie> GetAllZombiesByDateRange(NodaTime.LocalDate StartDate, NodaTime.LocalDate EndDate)
        {
            MasterZombieList = new List<DataObjects.Zombie>();

            try
            {
                System.Data.SqlClient.SqlDataReader t = PDM.Data.SqlHelper.ExecuteReader(GetConnectionString(), "sp_GetAllZombiesByDateRange",StartDate.ToString(),EndDate.ToString());

                if (t.HasRows)
                {

                    while (t.Read())
                    {
                        //I copied my query from the database so I can get the order right. :)

                        //SELECT L.LocationID, L.Elevation, L.Latitude, L.Longitude, DATEPART(YEAR, L.OccurenceDate), DATEPART(MONTH, L.OccurenceDate), DATEPART(DAY, L.OccurenceDate), CT.[Name] FROM tbl_ContactLocation CL
                        //JOIN tbl_Location L ON L.LocationID = CL.LocationFK
                        //JOIN tbl_ContactType CT ON CT.ContactTypeID = CL.ContactTypeFK
                        DataObjects.Zombie NewZombie = new DataObjects.Zombie(Convert.ToInt32(t[0]));
                        NewZombie.ContactLocation = new GeoEngine_Workspace.Location(Convert.ToDouble(t[2]), Convert.ToDouble(t[3]), Convert.ToInt32(t[1]));
                        //I really should add a new Location Constructor to include the date.
                        NewZombie.ContactLocation.SetDate(Convert.ToInt32(t[4]), Convert.ToInt32(t[5]), Convert.ToInt32(t[6]));
                        NewZombie.SetZType(t[7].ToString());
                        NewZombie.ContactName = (t[8].ToString());
                        MasterZombieList.Add(NewZombie);
                    }

                }
            }

            //This is the catch block
            catch (SqlException SQLE)
            {

            }
            catch (Exception e)
            {

            }
            finally
            {

            }
            return MasterZombieList;
        }

        /// <summary>
        /// This little function allows me to destroy database connections and keep 
        /// connections to the database closed for safety. Hackers.....sheesh.
        /// </summary>
        void IDisposable.Dispose()
        {

        }
    }
}