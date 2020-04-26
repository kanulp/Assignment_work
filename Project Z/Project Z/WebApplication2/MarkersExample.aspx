<%@ Page Title="" Language="C#" MasterPageFile="~/ZombiePage.Master" AutoEventWireup="true" CodeBehind="MarkersExample.aspx.cs" Inherits="WebApplication2.MarkersExample" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <title>Marker Example</title>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!---You have to include a ASP object called a ScriptManager here.-->
    <asp:ScriptManager ID="ScriptManager1" runat="server" EnablePageMethods="true" />

    
    <div class="grid-frame" id="test">


        <div class="small-12 colomns">&nbsp;</div>
        <div class="row">
            <div id="LocationHolder" class="small-4 columns" runat="server">

                <asp:ListBox class="LocationListBox" ID="LocationList" runat="server"></asp:ListBox>
            </div>
            <div class="small-8 columns">
                <div id="map"></div>
            </div>

        </div>

        <script src="javascript_files/vendor/jquery.js"></script>
        <script src="javascript_files/maps/markers.js"></script>
        <script src="javascript_files/foundation/foundation.js"></script>
        <script src="javascript_files/foundation/foundation.reveal.js"></script>
        <script src="javascript_files/foundation/foundation.topbar.js"></script>
        <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAX6haxPnf_GlOOJLMl4XX-_y9id7NBzh8&callback=initMapMarker"> </script>
        <script>
            $(document).foundation();
            $(document).foundation('reveal', 'reflow');           
        </script>
</asp:Content>
