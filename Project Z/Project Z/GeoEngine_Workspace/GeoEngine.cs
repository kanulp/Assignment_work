using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeoEngine_Workspace
{
    /// <summary>
    /// Name:       GeoEngine
    /// Purpose:    All the neat code that lets us code location objects on the Earths Surface
    /// Change History:
    /// Vers        Date        Coder       Notes:
    /// 1.0         2015-01-01  Clay        Initial Version
    /// 1.1         2019-10-30  Clay        Fixed Distance Bug, 
    ///                                     Fixed Bearingto Bug
    /// 
    /// </summary>

    public class GeoEngine
    {
        //const means constant. That means you can't change their values. 
        public const double EarthRadiusInMiles = 3959.0;
        public const double EarthRadiusInKilometers = 6371.0;
        public List<GeoEngine_Workspace.Location> Route;

        /// <summary>
        /// The Engine constructor
        /// </summary>
        public GeoEngine()
        {
            Route = new List<GeoEngine_Workspace.Location>();
        }

        public void Add(GeoEngine_Workspace.Location Loc)
        {
            Route.Add(Loc);
        }

        /// <summary>
        /// GetRouteLength Calculates the length of all the Location objects in the Route Container
        /// </summary>
        /// <returns></returns>
        public double GetRouteLength()
        {
            double temp = 0;



            for (int i = 0; i < Route.Count; ++i)
            {
                if (Route.Count == 1)
                {
                    return 0;
                }
                if (i != this.Route.Count - 1)
                {
                    double view = this.Distance(this.Route[i], this.Route[i + 1], 'm');
                    temp = temp + this.Distance(this.Route[i], this.Route[i + 1], 'm');
                }

            }

            return temp;
        }

        /// <summary>
        /// Prints out all the elements in the Route.
        /// </summary>
        public void PrintRoute()
        {
            if (this.Route.Count != 0)
            {
                Console.WriteLine("Current Route----- {0} Locations ", this.Route.Count);
                foreach (GeoEngine_Workspace.Location Loc in this.Route)
                {
                    Console.WriteLine("{0} Lat, {1} Long,", Loc.Latitude, Loc.Longitude);

                }
                Console.WriteLine("Total Distance = {0} {1}", this.GetRouteLength(), this.Route[0].Unit);
            }

            else
            {
                Console.WriteLine("Route is empty");
            }
        }

        /// <summary>
        /// Calculates the distance between two location objects
        /// </summary>
        /// <param name="loc1"></param>
        /// <param name="loc2"></param>
        /// <param name="unit"></param>
        /// <returns></returns>
        public double Distance(GeoEngine_Workspace.Location loc1, GeoEngine_Workspace.Location loc2, char unit)
        {
            double R;
            if (unit == 'm')
            {
                R = EarthRadiusInKilometers;
            }
            else
            {
                R = EarthRadiusInMiles;
            }

            double dLat = deg2rad(loc2.Latitude) - deg2rad(loc1.Latitude);
            double dLon = deg2rad(loc2.Longitude) - deg2rad(loc1.Longitude);
            double a = Math.Sin(dLat / 2) * Math.Sin(dLat / 2) + Math.Cos(deg2rad(loc1.Latitude)) * Math.Cos(deg2rad(loc2.Latitude)) * Math.Sin(dLon / 2) * Math.Sin(dLon / 2);
            double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));
            double distance = c * R;

            return Math.Round(distance, 2);
        }

        /// <summary>
        /// Calculates the distance between two sets of latitudes and longitudes
        /// </summary>
        /// <param name="lat1"></param>
        /// <param name="lng1"></param>
        /// <param name="lat2"></param>
        /// <param name="lng2"></param>
        /// <param name="unit"></param>
        /// <returns></returns>
        public double Distance(double lat1, double lng1, double lat2, double lng2, char unit)
        {
            double R;
            if (unit == 'm')
            {
                R = EarthRadiusInKilometers;
            }
            else
            {
                R = EarthRadiusInMiles;
            }

            double dLat = deg2rad(lat2) - deg2rad(lat1);
            double dLon = deg2rad(lng2) - deg2rad(lng1);
            double a = Math.Sin(dLat / 2) * Math.Sin(dLat / 2) + Math.Cos(deg2rad(lat1)) * Math.Cos(deg2rad(lat2)) * Math.Sin(dLon / 2) * Math.Sin(dLon / 2);
            double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));
            double distance = c * R;

            return Math.Round(distance, 2);
        }

        /// <summary>
        /// Calculates the bearing between two location objects
        /// Altered at 2019-10-30. New Code.
        /// </summary>
        /// <param name="loc1"></param>
        /// <param name="loc2"></param>
        /// <param name="lat1"></param>
        /// <returns></returns>
        public double BearingTo(GeoEngine_Workspace.Location loc1, GeoEngine_Workspace.Location loc2)
        {
            var dLon = deg2rad(loc2.Longitude - loc1.Longitude);
            var dPhi = Math.Log(
                Math.Tan(deg2rad(loc2.Latitude) / 2 + Math.PI / 4) / Math.Tan(deg2rad(loc1.Latitude) / 2 + Math.PI / 4));
            if (Math.Abs(dLon) > Math.PI)
                dLon = dLon > 0 ? -(2 * Math.PI - dLon) : (2 * Math.PI + dLon);
            return ToBearing(Math.Atan2(dLon, dPhi));

            //double dlat1 = deg2rad(loc1.Latitude);
            //double dlat2 = deg2rad(loc2.Latitude);
            //double dLon = deg2rad(loc1.Longitude) - deg2rad(loc2.Longitude);

            //double y = Math.Sin(dLon) * Math.Cos(dlat2);
            //double x = Math.Cos(dlat1) * Math.Sin(dlat2) - Math.Sin(dlat1) * Math.Cos(dlat2) * Math.Cos(dLon);
            //double brng = Math.Atan2(y, x);
            //return (rad2deg(brng) + 360) % 360;
        }

        /// <summary>
        /// Calculates bearing between two sets of latitudes and longitudes
        /// Altered at 2019-10-30. New Code.
        /// <param name="lat1"></param>
        /// <param name="lon1"></param>
        /// <param name="lat2"></param>
        /// <param name="lon2"></param>
        /// <returns></returns>
        public double BearingTo(double lat1, double lon1, double lat2, double lon2)
        {

            var dLon = deg2rad(lon2 - lon1);
            var dPhi = Math.Log(
                Math.Tan(deg2rad(lon2) / 2 + Math.PI / 4) / Math.Tan(deg2rad(lon1) / 2 + Math.PI / 4));
            if (Math.Abs(dLon) > Math.PI)
                dLon = dLon > 0 ? -(2 * Math.PI - dLon) : (2 * Math.PI + dLon);
            return ToBearing(Math.Atan2(dLon, dPhi));

            //double dlat1 = deg2rad(lat1);
            //double dlat2 = deg2rad(lat2);
            //double dLon = deg2rad(lon1) - deg2rad(lon2);

            //double y = Math.Sin(dLon) * Math.Cos(dlat2);
            //double x = Math.Cos(dlat1) * Math.Sin(dlat2) - Math.Sin(dlat1) * Math.Cos(dlat2) * Math.Cos(dLon);
            //double brng = Math.Atan2(y, x);
            //return (rad2deg(brng) + 360) % 360;
        }

        /// <summary>
        /// Calculates a location object based on a location object start, a distance and a bearing
        /// </summary>
        /// <param name="loc1"></param>
        /// <param name="dist"></param>
        /// <param name="brng"></param>
        /// <param name="unit"></param>
        /// <returns></returns>
        public GeoEngine_Workspace.Location DestinationPoint(GeoEngine_Workspace.Location loc1, double dist, double brng, char unit)
        {
            
            var distRatio = dist / EarthRadiusInKilometers;
            var distRatioSine = Math.Sin(distRatio);
            var distRatioCosine = Math.Cos(distRatio);

            var startLatRad = deg2rad(loc1.Latitude);
            var startLonRad = deg2rad(loc1.Longitude);

            var startLatCos = Math.Cos(startLatRad);
            var startLatSin = Math.Sin(startLatRad);

            var endLatRads = Math.Asin((startLatSin * distRatioCosine) + (startLatCos * distRatioSine * Math.Cos(deg2rad(brng))));

            var endLonRads = startLonRad
                + Math.Atan2(
                    Math.Sin(deg2rad(brng)) * distRatioSine * startLatCos,
                    distRatioCosine - startLatSin * Math.Sin(endLatRads));

            return new Location( Math.Round(rad2deg(endLatRads),3), Math.Round(rad2deg(endLonRads),3));
            

            //double R;
            //if (unit == 'm')
            //{
            //    R = EarthRadiusInKilometers;
            //}
            //else
            //{
            //    R = EarthRadiusInMiles;
            //}

            //dist = dist / R;
            //brng = Math.PI * brng / 180;
            //double lat1 = deg2rad(loc1.Latitude);
            //double lon1 = deg2rad(loc1.Longitude);
            //double lat2 = Math.Asin(Math.Sin(lat1) * Math.Cos(dist) + Math.Cos(lat1) * Math.Sin(dist) * Math.Cos(brng));
            //double lon2 = lon1 + Math.Atan2(Math.Sin(brng) * Math.Sin(dist) * Math.Cos(lat1), Math.Cos(dist) - Math.Sin(lat1) * Math.Sin(lat2));
            //lon2 = (lon2 + 3 * Math.PI) % (2 * Math.PI) - Math.PI;
            //lat2 = rad2deg(lat2);
            //lon2 = rad2deg(lon2);
            //GeoEngine_Workspace.Location temp = new GeoEngine_Workspace.Location(lat2, lon2);
            //return temp;
        }

        /// <summary>
        /// Converts degrees to radians
        /// </summary>
        /// <param name="deg"></param>
        /// <returns></returns>
        private double deg2rad(double deg)
        {
            const double degToRadFactor = Math.PI / 180;
            return deg * degToRadFactor;

          //  return (deg * Math.PI / 180.0);
        }

        /// <summary>
        /// Converts radians to degrees
        /// </summary>
        /// <param name="rad"></param>
        /// <returns></returns>

        private double rad2deg(double rad)
        {
            const double radToDegFactor = 180 / Math.PI;
            return rad * radToDegFactor;

       //     return (rad / Math.PI * 180.0);
        }

        private double ToBearing(double radians)
        {
            // convert radians to degrees (as bearing: 0...360)
            return (rad2deg(radians) + 360) % 360;
        }
    }
}
