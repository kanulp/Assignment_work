using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeoEngine_Workspace
{
    class Program
    {
        static void Main(string[] args)
        {
            GeoEngine G = new GeoEngine();
           
            Location L1 = new Location(1, 1, 0);
            Location L2 = new Location(10, 0, 0);

            Double D1 = G.Distance(L2, L1, 'm');
            Double D2 = G.Distance(L1, L2, 'm');

            Double B1 = G.BearingTo(L1, L2);
            Double B2 = G.BearingTo(L2, L1);

            Location Toronto = new Location(43.65, -79.38);
            Location Gatwick = new Location(51.1,0.18);

            Double D3 = G.Distance(Toronto, Gatwick, 'm');
            Double D4 = G.Distance(Gatwick, Toronto, 'm');

            Double B3 = G.BearingTo(Toronto, Gatwick);
            Double B4 = G.BearingTo(Gatwick, Toronto);

            Location L3 = G.DestinationPoint(L1, 1000, 90, 'm');
            Location L4 = G.DestinationPoint(L3, 1000, 270, 'm');
            

            

        }
    }
}
