using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class MapMasterLayout : System.Web.UI.MasterPage
    {
        /// <summary>
        /// Date        Coder       Vers        Notes
        /// 2020-01-18  Clay        1.0         Initial
        /// 
        /// It just controls the styling of the tabs on the navigation bar.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void Page_Load(object sender, EventArgs e)
        {
            Markers.Attributes.Remove("class");
            HeatMap.Attributes.Remove("class");


            if (Page.AppRelativeVirtualPath == "~/MapHome.aspx")
            {
                Markers.Attributes.Add("class", "is-active");
            }

            if (Page.AppRelativeVirtualPath == "~/HeatMap.aspx")
            {
                HeatMap.Attributes.Add("class", "is-active");
            }


        }
    }
}