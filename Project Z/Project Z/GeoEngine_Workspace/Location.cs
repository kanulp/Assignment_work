using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Globalization;
using NodaTime;

namespace GeoEngine_Workspace
{
    /// <summary>
    /// Name:       Location
    /// Purpose:    A class that holds the basic working concept of a location and date upon the surface of a sphere.
    /// Change History:
    /// Vers        Date        Coder       Notes:
    /// 1.0         2015-01-01  Clay        Initial Version
    /// 1.5         2016-08-20  Clay        Added an ID number
    /// 2.0         2018-01-01  Clay        Added a the Noda.dll for date and time
    /// </summary>
    public class Location
    {
        public double Latitude { get; private set; }
        public double Longitude { get; private set; }
        public double Elevation { get; private set; }
        public char Unit { get; private set; }
        public NodaTime.LocalDate Date { get; private set; }

        //Leaving it public for ease of access to the coder. Mess with it at your own risk.
        public Int32 ID;

        /// <summary>
        /// Sets the Date using the noda.dll library
        /// </summary>
        /// <param name="Y"></param>
        /// <param name="M"></param>
        /// <param name="D"></param>
        public void SetDate(int Y, int M, int D)
        {
            Date = new LocalDate(Y, M, D);
        }

        /// <summary>
        /// Sets the Longitide. (How far east or west)
        /// 
        /// </summary>
        /// <param name="value"></param>
        public void SetLongitude(double value)
        {
            //These asserts will throw errors to prevent us from creating nonesense Longitudes.
            Debug.Assert(value <= 180);
            Debug.Assert(value >= -180);
            Longitude = value;
        }

        /// <summary>
        /// Sets the Longitude. (How far east or west)
        /// </summary>
        /// <param name="degLng"></param>
        /// <param name="minLng"></param>
        /// <param name="secLng"></param>
        /// <param name="CardinalLng"></param>
        public void SetLongitude(int degLng, int minLng, int secLng, String CardinalLng)
        {
            Debug.Assert(degLng >= 0);
            Debug.Assert(degLng <= 180);
            Debug.Assert(minLng >= 0);
            Debug.Assert(minLng <= 59);
            Debug.Assert(secLng >= 0);


            Debug.Assert(CardinalLng.ToUpper() == "W" || CardinalLng.ToUpper() == "E");


            Longitude = Convert.ToDouble(degLng) + Convert.ToDouble(minLng) / 60.0 + Convert.ToDouble(secLng) / 3600.0;


            if (CardinalLng.ToUpper() == "W")
            {
                Longitude = Longitude * -1.0;
            }
        }

        /// <summary>
        /// Sets the Latitude. (How far north or south)
        /// </summary>
        /// <param name="degLat"></param>
        /// <param name="minLat"></param>
        /// <param name="secLat"></param>
        /// <param name="CardinalLat"></param>
        public void SetLatitude(int degLat, int minLat, int secLat, String CardinalLat)
        {
            Debug.Assert(degLat >= 0);
            Debug.Assert(degLat <= 90);
            Debug.Assert(minLat >= 0);
            Debug.Assert(minLat <= 59);
            Debug.Assert(secLat >= 0);

            Debug.Assert(CardinalLat.ToUpper() == "N" || CardinalLat.ToUpper() == "S");

            double Latitude = Convert.ToDouble(degLat) + Convert.ToDouble(minLat) / 60.0 + Convert.ToDouble(secLat) / 3600.0;


            if (CardinalLat.ToUpper() == "S")
            {
                Latitude = Latitude * -1.0;
            }

        }

        /// <summary>
        /// Sets the Latitude. (How far north or south)
        /// </summary>
        /// <param name="value"></param>
        public void SetLatitude(double value)
        {
            Debug.Assert(value <= 90);
            Debug.Assert(value >= -90);
            Latitude = value;
        }

        /// <summary>
        /// Sets the elevation of the location above or below sea level in meters. It defaults to metric.
        /// </summary>
        /// <param name="value"></param>
        public void SetElevation(double value)
        {
            Elevation = value;
        }

        /// <summary>
        /// The default constructor.
        /// Defaults to 0 deg lat, 0 deg lng, 0 m elevation, metric units, January 1, Year 1 CE (AD), ID of 0
        /// </summary>
        public Location()
        {
            Latitude = 0;
            Longitude = 0;
            Elevation = 0;
            Unit = 'm';
            Date = new LocalDate(1, 1, 1);
            ID = 0;
        }

       
        /// <summary>
        /// Takes Lat, lng and elevation, metric units, January 1, Year 1 CE (AD), ID of 0
        /// </summary>
        /// <param name="Lat"></param>
        /// <param name="Long"></param>
        /// <param name="Elevate"></param>
        public Location(double Lat, double Long, double Elevate)
        {
            Debug.Assert(Lat <= 90);
            Debug.Assert(Lat >= -90);
            Debug.Assert(Long <= 180);
            Debug.Assert(Long >= -180);
            Latitude = Lat;
            Longitude = Long;
            Elevation = Elevate;
            Date = new LocalDate(1, 1, 1);
            Unit = 'm'; ;
            ID = 0;

        }

        /// <summary>
        /// Defaults the elevation to 0 meters, metric units, January 1, Year 1 CE (AD), ID of 0
        /// </summary>
        /// <param name="Lat"></param>
        /// <param name="Long"></param>
        public Location(double Lat, double Long)
        {
            Debug.Assert(Lat <= 90);
            Debug.Assert(Lat >= -90);
            Debug.Assert(Long <= 180);
            Debug.Assert(Long >= -180);

            Latitude = Lat;
            Longitude = Long;
            Elevation = 0;
            Unit = 'm';
            Date = new LocalDate(1, 1, 1);
            ID = 0;
        }

        public Location(int degLat, int minLat, int secLat, String CardinalLat, int degLng, int minLng, int secLng, String CardinalLng, double E)
        {
            Debug.Assert(degLat >= 0);
            Debug.Assert(degLat <= 90);
            Debug.Assert(minLat >= 0);
            Debug.Assert(minLat <= 59);
            Debug.Assert(secLat >= 0);

            Debug.Assert(degLng >= 0);
            Debug.Assert(degLng <= 180);
            Debug.Assert(minLng >= 0);
            Debug.Assert(minLng <= 59);
            Debug.Assert(secLng >= 0);

            Debug.Assert(CardinalLat.ToUpper() == "N" || CardinalLat.ToUpper() == "S");
            Debug.Assert(CardinalLng.ToUpper() == "W" || CardinalLng.ToUpper() == "E");

            SetLatitude(degLat, minLat, secLat, CardinalLat);
            SetLongitude(degLng, minLng, secLng, CardinalLng);
            SetElevation(E);
            Date = new LocalDate(1, 1, 1);
            Unit = 'm';
        }


    }
}
