<%@ Page Title="" Language="C#" MasterPageFile="~/MapMasterLayout.Master" AutoEventWireup="true" CodeBehind="MapHome.aspx.cs" Inherits="WebApplication1.MapHome" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
<title>Map Home</title>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!---You have to include a ASP object called a ScriptManager here.-->
    <asp:ScriptManager ID="ScriptManager1" runat="server" EnablePageMethods="true" ></asp:ScriptManager> 
     
    <div class="grid-frame" id="test">


        <div class="small-12 colomns">&nbsp;</div>
        <div class="row">
            <div id="LocationHolder" class="small-3 columns" runat="server">

                <asp:ListBox class="LocationListBox" ID="LocationList" runat="server"></asp:ListBox>
                <fieldset>
                <legend>Infection Start Date:</legend>
                <label><input id ="StartDate" type="date" runat="server"/></label>
                </fieldset>
                <fieldset>
                <legend>Infection End Date:</legend>
                <label><input id ="EndDate" type="date" runat="server"/></label>
                </fieldset>

                <a role="button" id="DateSearch" onclick="searchByDate()" href="#" class="button expand">Search</a>
            </div>
            <div class="small-9 columns">
                <div id="map"></div>
            </div>

        </div>
        </div>
   


     <div id="ModalAddLocation" class="reveal-modal" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">

            <p ID= "Modal_Lead" class="lead">Details</p>

            <div class="row">
            <div class="small-3 columns">
            <label>Zombie Name:</label></div>
            <div class="small-9 columns">
            <label><input id="NameBox" type="text" placeholder="" runat="server"/></label></div>
            </div>

            <div class="row">
            <div class="small-3 columns">
            <label>Latitude:</label></div>
            <div class="small-9 columns">
            <label><input id ="MarkerLat" type="text" placeholder="lat" runat="server" readonly/></label></div>
            </div>


            <div class="row">
            <div class="small-3 columns">
            <label>Longitude</label></div>
            <div class="small-9 columns">
            <label><input id ="MarkerLng" type="text" placeholder="lng" runat="server" readonly/></label></div>
            </div>

            <div class="row">
            <div class="small-3 columns">
            <label>Zombie Type</label></div>
            <div class="small-9 columns">
            <label>
            <asp:RadioButton ID="rbSlow" runat="server" Text="Slow" />
            <asp:RadioButton ID="rbMedium" runat="server" Text="Medium" />
            <asp:RadioButton ID="rbFast" runat="server" Text="Fast" />   </div>
            </div>

            <div class="row">
            <div class="small-3 columns">
            <label>Infection Date</label></div>
            <div class="small-9 columns">
            <label><input id ="ZDate" type="date" runat="server"/></label></div>
            </div>

            <div class="row">
            <div class="small-3 columns">
            <label>Zombie Serial</label></div>
            <div class="small-9 columns">
            <label><input id ="MarkerID" type="text" placeholder="ID" runat="server" readonly/></label></div>
            </div>
          
                <div class="row">
                <div class="small-6 columns"><a role="button" id="ModalSubmit" href="#" class="button expand">Save</a></div>
                <div class="small-6 columns"><a role="button" id="ModalDelete" href="#" class="button expand">Delete</a></div>
                    </div>
            </div>
            <!--This is where the x is indicated inside the modal.-->
            <a class="close-reveal-modal" aria-label="Close">&#215;</a>

        <script src="javascript_files/vendor/jquery.js"></script>
        <script src="javascript_files/maps/markers.js"></script>
        <script src="javascript_files/foundation/foundation.js"></script>
        <script src="javascript_files/foundation/foundation.reveal.js"></script>
        <script src="javascript_files/foundation/foundation.topbar.js"></script>
        <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAX6haxPnf_GlOOJLMl4XX-_y9id7NBzh8&libraries=visualization&callback=initMapMarker"> </script>
        <script>
            $(document).foundation();
            $(document).foundation('reveal', 'reflow');           
        </script>

</asp:Content>
