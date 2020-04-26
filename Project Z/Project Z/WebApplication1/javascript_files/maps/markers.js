
////////////////////////////////////////////////////////////////////////
//
//Name: markers.js
//Date: 2020-01-23
//
//      Name:      Vers:     Date:            Notes:
//      Clay       1.0       2020-01-23       Initial Official Check in
//      Clay       1.1       2020-02-05       Modal Implementation
//
////////////////////////////////////////////////////////////////////////


//A variable in the scope of this whole Javascript project. Dangerous.
var markers = [];
var HeatMapList = [];
var heatmap;

////////////////////////////////////////////////////////////////////////
//
//Name: initMapMarker
//Date: 2020-01-23
//
//      Name:      Vers:     Date:            Notes:
//      Clay       1.0       2020-01-23       Initial
//
//      Gets the program running. Creates the map. then calls
//      populate map function to get the data from the DOM.
////////////////////////////////////////////////////////////////////////
function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    //If you look in the DOM by "viewing source" for the MapHome.aspx
    //you can see we loaded data as we loaded the page. This is not the
    //greatest way of getting data. We should call home and get a selective amount of data
    //at some point.
    //For now lets populate the map with markers that were loaded into the DOM.

    //So we collect all the details of the Zombies from the DOM.
    //var LocationList = document.getElementById("LocationList");

   
    //we call markers and empty the container. Reset the data.
    markers = [];
    var startLocation = new google.maps.LatLng(45, -81);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 2,
        center: startLocation
    });

    //Add events on to the map.
    //In order to capture events on the map. Like clicking, dragging or other
    //interactions. We have to bind them to the map here. This is done after the page
    //loads. This is an example of late binding.
    //This is really ugly but if you look at it carefully it is a nested function 
    //call and passes the event details into the createMarker function.

    //map.addListener('rightclick', function (event) { createMarker(event); });
    map.addListener('rightclick', function (event) { createMarkerModal(event); });   

    //Then populate the map. This call gets all the data from the map. We have consider
    //maybe its time for us to be selective in the call. As of 2020-02-12 I have implemented 
    //the date range functionality. We should do this soon. :)
    populateMap();
}

/// Name: searchByDate
    /// Purpose: Taking the two values from the date search field sets
    /// we are going to craft a series of steps to clear the map. Clear
    /// the markers array. Then call a web method and get all the markers
    /// from the database that meet the date criteria.
    ///          
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-02-06  Clay        1.0         Initial
function searchByDate()
{
    //Before we do anything lets check to see if the dates are valid. We need the start date
    //and the end date for the period we are interested in. Lets grab these from the date picker
    //We also will do some validation to help the user.

    var ZombieInfectionStartDate = document.getElementById("StartDate").value;
    var ZombieInfectionEndDate = document.getElementById("EndDate").value;

    //Prevent GIGO!
    //Garbage In Garbage Out

    //Now I am going to make sure that both are valid dates. If not the function returns and nothing
    //happens.
    if (!ZombieInfectionStartDate) {
        alert("Invalid Start Date.");
        return;
    }
    if (!ZombieInfectionEndDate) {
        alert("Invalid End Date.");
        return;
    }
    if (ZombieInfectionStartDate == ZombieInfectionEndDate) {
        alert("Start Date and End Date must be different dates.");
        return;
    }
    if (ZombieInfectionStartDate > ZombieInfectionEndDate) {
        alert("Start Date must be before End Date");
        return;
    }

    //If we got here the dates are valid.

    //So lets clear the map first.
    for (var i = 0; i < markers.length; ++i)
    {
        markers[i].setMap(null);
    }
    //Next we have to clear the heatmap.
    //Yeah it's that easy... 
    heatmap.setMap(null);

    //Next we need to blow away the contents of the markers array.
    markers = [];
    //And the heatmap list.
    HeatMapList = [];

    //Now the location list box has to be cleared out...
    document.getElementById("LocationList").options.length = 0;

    //So now we have a map and a clean slate to work from. 

    PageMethods.GetAllMarkersByDateRange(ZombieInfectionStartDate, ZombieInfectionEndDate, OnSuccess, OnError);
    function OnError(result) {
        alert('Something wrong.');
    }
    function OnSuccess(result) {
        populateLocationList(result);
        populateMap();
    } 

}

function populateLocationList(result)
{
    var LocationList = document.getElementById("LocationList");

    for (var i = 0; i < result.length; ++i)
    {
        var ZombieArray = result[i].split("|");    
       
        var zombie = document.createElement("option");
        zombie.text = ZombieArray[0] + " " + ZombieArray[6];
        zombie.setAttribute('Latitude',ZombieArray[3]);
        
        zombie.setAttribute('Longitude',ZombieArray[4]);
        zombie.setAttribute('ZombieName',ZombieArray[0]);
        zombie.setAttribute('Elevation',ZombieArray[5]);
        zombie.setAttribute('SerialNumber',ZombieArray[2]);
        zombie.setAttribute('Date',ZombieArray[6]);
        zombie.setAttribute('ContactType',ZombieArray[1]);
        LocationList.options.add(zombie);

        //Z.ContactName + "|" +
        //    Z.ContactType + "|" +
        //    Z.ZombieSerialNumber + "|" +
        //    Z.ContactLocation.Latitude + "|" +
        //    Z.ContactLocation.Longitude + "|" +
        //    Z.ContactLocation.Elevation + "|" +
        //    Z.ContactLocation.Date
    }

    //Item.Text = Z.ContactName + " " + Z.ContactLocation.Date.ToString();
    //Item.Attributes.Add("ZombieName", Z.ContactName);
    //Item.Attributes.Add("Latitude", Z.ContactLocation.Latitude.ToString());
    //Item.Attributes.Add("Longitude", Z.ContactLocation.Longitude.ToString());
    //Item.Attributes.Add("Elevation", Z.ContactLocation.Elevation.ToString());
    //Item.Attributes.Add("Date", Z.ContactLocation.Date.ToString());
    //Item.Attributes.Add("SerialNumber", Z.ZombieSerialNumber.ToString());
    //Item.Attributes.Add("ContactType", Z.ContactType.ToString());
}

function createMarkerModal(eventobject)
{
    //Code in the Modal Pop Up.
    $('#ModalAddLocation').foundation('reveal', 'open');
    $("#ModalSubmit").unbind('click');
    $("#ModalDelete").unbind('click');
    $("#ModalDelete").show();

    $("#ModalSubmit").show();
    $("#ModalZombieTextBox").show();
    document.getElementById('MarkerLat').value = eventobject.latLng.lat();
    document.getElementById('MarkerLng').value = eventobject.latLng.lng();
    document.getElementById('Modal_Lead').innerText = "New Zombie";
    //Now the modal gets populated with the previous modal's data so we have to clear
    //Some fields 
    document.getElementById("NameBox").value = "";
    document.getElementById("ZDate").value = "";
    document.getElementById("MarkerID").value = "";

    document.getElementById('rbSlow').checked = true;
    document.getElementById('rbMedium').checked = false;
    document.getElementById('rbFast').checked = false;

    $('#ModalSubmit').click(function () {

        //This is where we send the Zombie to the Database...
        var ZombieName = document.getElementById("NameBox").value;
        var ZombieType = "Slow";

        //If the user does not set the date correctly. The date field will be NULL and that will 
        //not go well being passed back to the server side.
        var ZombieDate;  
        //This tests to see if the DatePicker is NULL.
        if (document.getElementById("ZDate").value)
        {
        ZombieDate = document.getElementById("ZDate").value;
        }
        else
        {
           //Javascript is terrible with dates. I just want to create a date for today. 
           //So I rolled this function to do the job.
            ZombieDate = GetDate();
        }
       
        if (document.getElementById('rbSlow').checked)
        {
            ZombieType = "Slow";
        }
        else if (document.getElementById('rbMedium').checked)
        {
            ZombieType = "Medium";
        }
        else if (document.getElementById('rbFast').checked)
        {
            ZombieType = "Fast";
        }

        createMarker(eventobject, ZombieName, ZombieType, ZombieDate);
        $('#ModalAddLocation').foundation('reveal', 'close');
    });

    $('#ModalDelete').click(function () {
       $('#ModalAddLocation').foundation('reveal', 'close');
    });

}

function GetDate()
{
    //I really should start breaking some of these helper functions into a new Javascript file.
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    today = yyyy + '-' + mm + '-' + dd;

    return today;
}

/// Name: updateMarkerModal
    /// Purpose: This code controls the the modal I call.
    ///          
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-02-06  Clay        1.0         Initial
    /// 2020-02-12  Clay        1.1         Added the update button.
function updateMarkerModal(marker)
{
    $('#ModalAddLocation').foundation('reveal', 'open');
    $("#ModalSubmit").unbind('click');
    $("#ModalDelete").unbind('click');
    $("#ModalDelete").hide();

    $("#ModalSubmit").show();
    $("#ModalDelete").show();
    $("#ModalZombieTextBox").show();
    document.getElementById('MarkerLat').value = marker.getPosition().lat();
    document.getElementById('MarkerLng').value = marker.getPosition().lng()
    document.getElementById('Modal_Lead').innerText = marker.title;
    document.getElementById("NameBox").value = marker.title;
    document.getElementById("ZDate").value = formatDate(marker.date);
    document.getElementById("MarkerID").value = marker.serialnumber;
    
    document.getElementById('rbSlow').checked = true;
    document.getElementById('rbMedium').checked = false;
    document.getElementById('rbFast').checked = false;
       
   
    if (marker.contacttype == "Medium")
    {
        document.getElementById('rbSlow').checked = false;
        document.getElementById('rbMedium').checked = true;
        document.getElementById('rbFast').checked = false;
    }
    else if (marker.contacttype == "Fast")
    {
        document.getElementById('rbSlow').checked = false;
        document.getElementById('rbMedium').checked = false;
        document.getElementById('rbFast').checked = true;
    }

    //I am going to bind an event handler on the Submit button. 
    $('#ModalSubmit').click(function () {
        $('#ModalAddLocation').foundation('reveal', 'close');
    });

    $('#ModalDelete').click(function () {

        PageMethods.DeleteMarkerByID(marker.serialnumber, OnSuccess, OnError);
        function OnError(result) {
            alert('We didnt write it yet.:)');

        }
        function OnSuccess(result) {
            
            for (var i = 0; i < markers.length; ++i)
            {
                //alert(marker.serialnumber);
                //if (markers[i].serialnumber == marker.serialnumber)
                //{
                //    markers[i].setMap(null);
                //    delete markers[i]; 
                //}
                
                //HeatMapList = [];
                //heatmap.setMap(null);
                for (var i = 0; i < document.getElementById("LocationList").options.length; ++i)
                {
                    if (LocationList.options[i].getAttribute("SerialNumber") == marker.serialnumber)
                    {
                        LocationList.remove(i);
                        //So we found the Location List item. So lets clear the map and reload the
                        //data from the LocationList
                        for (var i = 0; i < markers.length; ++i) {
                            markers[i].setMap(null);
                        }
                        //Next we have to clear the heatmap.
                        //Yeah it's that easy... 
                        heatmap.setMap(null);

                        //Next we need to blow away the contents of the markers array.
                        markers = [];
                        //And the heatmap list.
                        HeatMapList = [];

                        //now lets reload everything from the LocationList.
                        populateMap();
                    }
                }
                

               



            }
        }

        $('#ModalAddLocation').foundation('reveal', 'close');
        //sigh...wemust now delete a zombie. and do some Cleanup on the map.
    });


}

function formatDate(date)
{
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

    /// Name: createMarker
    /// Purpose: Adds a marker to the map based on an event being passed to it.
    ///          It adds themarker to the map and to the Markers array. It needs 
    ///          the event to figure out where to set the marker.
    ///          
    /// 
    /// Date        Coder       Vers        Notes
    /// 2020-01-23  Clay        1.0         Initial
    /// 2020-02-05  Clay        1.1         Changed for the modal.
function createMarker(eventobject,ZName,ZType, ZDate)
{
   

    //Gotta love the var variable type....It has issues we will talk about later.
    var geocoder = new google.maps.Geocoder;
    var position = new google.maps.LatLng(eventobject.latLng.lat(), eventobject.latLng.lng());

    
    

    var SerialNumber = 0;
    
    //I do think I am going to move these styling calls to another function.
    //Clean things up.
    // var image = 'http://http://icons.iconarchive.com//icons//hopstarter//halloween-avatar//256//Zombie-PVZ-icon.png';

    var image = '../image_files/Icon_Zombie_Small.png';

    var Elevation = 100;

   


    //This is where add Marker event handlers.
    //This is where we want to send this data DOWN to the Database. So we have to call the
    //last bit of the puzzle. A Web Method.
    //PageMethods.CreateMarker(ZombieName, Elevation, SerialNumber, ContactType,position.lat,position.lng,OnSuccess,OnError);
    PageMethods.CreateMarker(ZName, Elevation, ZDate, SerialNumber, ZType, eventobject.latLng.lat(), eventobject.latLng.lng(),OnSuccess, OnError);
    function OnError(result)
    {
            alert('Something wrong.');

    }
    function OnSuccess(result)
    {
        
    var marker = new google.maps.Marker({
            position: position,
            title: ZName,
            icon: image,
            //label: 'marker',
            animation: google.maps.Animation.DROP,
            elevation: Elevation,
            date: Date,
            serialnumber: result,
            contacttype: ZType,
            draggable: false

        });

        //I have to add an event listener to the the marker prior to placing it on the map.
        //marker.addListener('click', function (event, this) { updateMarkerModal(event, this); });
        google.maps.event.addListener(marker, 'click', function () { updateMarkerModal(this) });
            markers.push(marker);
            marker.setMap(map);
    }
}

function centerMap()
{    
    var source = event.target || event.srcElement;

    var latlng = new google.maps.LatLng(source.getAttribute("Latitude"),
        source.getAttribute("Longitude"));

    map.panTo(latlng);
    map.setZoom(5);
    map.setMapTypeId('satellite');
}

////////////////////////////////////////////////////////////////////////
//
//Name: populateMap
//Date: 2020-01-23
//
//      Name:      Vers:     Date:            Notes:
//      Clay       1.0       2020-01-23       Initial
//
//      Nuke the Markers Array and relaod all data from the DOM and place all 
//      markers on the map.
////////////////////////////////////////////////////////////////////////
function populateMap()
{
    //Nuke the Markers array again to make sure no data. Then get all the Markers from
    //the DOM
    var LocationList = document.getElementById("LocationList");
    
    for (var i = 0; i < LocationList.options.length; ++i) {

        //This is a a row in the locationlist.
        LocationList.options[i].onclick = function () { centerMap() };
        
        var position = new google.maps.LatLng(LocationList.options[i].getAttribute("Latitude"),
            LocationList.options[i].getAttribute("Longitude"));

        var ZombieName = LocationList.options[i].getAttribute("ZombieName");
        var Elevation = LocationList.options[i].getAttribute("Elevation");
        var Date = LocationList.options[i].getAttribute("Date");
        var SerialNumber = LocationList.options[i].getAttribute("SerialNumber");
        var ContactType = LocationList.options[i].getAttribute("ContactType");
        var ContactWeight = 10;
        if (ContactType == "Slow")
        {
            ContactWeight = 20;
        }
        if (ContactType == "Medium") {
            ContactWeight = 50;
        }
        if (ContactType == "Fast") {
            ContactWeight = 100;
        }

        //I do think I am going to move these styling calls to another function.
        //Clean things up.
        // var image = 'http://http://icons.iconarchive.com//icons//hopstarter//halloween-avatar//256//Zombie-PVZ-icon.png';
       
        var image = '../image_files/Icon_Zombie_Small.png';

        HeatMapList.push({ location: position, weight: ContactWeight });


        var marker = new google.maps.Marker({
            position: position,
            title: ZombieName,
            icon: image,
            //label: 'marker',
            animation: google.maps.Animation.DROP,
            elevation: Elevation,
            date: Date,
            serialnumber: SerialNumber,
            contacttype: ContactType,
            draggable: false

        });

        //This is where add Marker event handlers.
        //marker.addListener('click', function () { updateMarkerModal(this); });
        google.maps.event.addListener(marker, 'click', function () { updateMarkerModal(this) });
        markers.push(marker);
        marker.setMap(map);

    }
    heatmap = new google.maps.visualization.HeatmapLayer({
        data: HeatMapList
    });
    heatmap.setMap(map);
}
