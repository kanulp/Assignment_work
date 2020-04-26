<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="HelloWorld.aspx.cs" Inherits="WebApplication2.HelloWorld" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
     <link rel="stylesheet" href="css_files/foundation.css" /> 
     <link rel="stylesheet" href="css_files/app.css" /> 
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <div class="small-12 colomns">&nbsp;</div>
        <div class="row">
            <div id="LocationHolder" class="small-4 columns" runat="server">

                <asp:ListBox class="LocationListBox" ID="LocationList" runat="server"></asp:ListBox>
            </div>
            <div class="small-8 columns">
                <div id="map"></div>
            </div>

        </div>
        </div>
    </form>
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
</body>
</html>
