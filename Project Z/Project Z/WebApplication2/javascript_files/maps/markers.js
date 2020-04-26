
//A variable in the scope of this whole Javascript project. Dangerous.
var markers = [];



function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    //If you look in the DOM by "viewing source" for the MapHome.aspx
    //you can see we loaded data as we loaded the page. This is not the
    //greatest way of getting data. We should call home and get a selectiveamount of data
    //at some point.
    //For now lets populate the map with markers that were loaded into the DOM.

    //So we collect all the details of the Zombies from the DOM.
    //var LocationList = document.getElementById("LocationList");

    //And we iterate through it
    //for (var i = 0; LocationList.options.length; ++i)
    //{
        
        //LocationList.options[i].getAttribute("ZombieName");
        //LocationList.options[i].getAttribute("Latitude");
        //LocationList.options[i].getAttribute("Longitude");
        //LocationList.options[i].getAttribute("Elevation");
        //LocationList.options[i].getAttribute("Date");
        //LocationList.options[i].getAttribute("SerialNumber");
        //LocationList.options[i].getAttribute("ContactType");

    //    alert(LocationList.options[i].getAttribute("ZombieName"));
    //}

    var startLocation = new google.maps.LatLng(0, 0);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 2,
        center: startLocation
    });

    //Add events on to the map.

    //Then populate the map.
    populateMap();

    
   
}

function populateMap()
{
    var LocationList = document.getElementById("LocationList");

    for (var i = 0; i < LocationList.options.length; ++i) {

        //I copied this from the c # side so I didnt mispell anything or forget.
        //LocationList.options[i].getAttribute("ZombieName");
        //LocationList.options[i].getAttribute("Latitude");
        //LocationList.options[i].getAttribute("Longitude");
        //LocationList.options[i].getAttribute("Elevation");
        //LocationList.options[i].getAttribute("Date");
        //LocationList.options[i].getAttribute("SerialNumber");
        //LocationList.options[i].getAttribute("ContactType");


        var position = new google.maps.LatLng(LocationList.options[i].getAttribute("Latitude"),
            LocationList.options[i].getAttribute("Longitude"));

        var ZombieName = LocationList.options[i].getAttribute("ZombieName");
        var Elevation = LocationList.options[i].getAttribute("Elevation");
        var Date = LocationList.options[i].getAttribute("Date");
        var SerialNumber = LocationList.options[i].getAttribute("SerialNumber");
        var ContactType = LocationList.options[i].getAttribute("ContactType");

        //I do think I am going to move these styling calls to another function.
        //Clean things up.
        // var image = 'http://http://icons.iconarchive.com//icons//hopstarter//halloween-avatar//256//Zombie-PVZ-icon.png';
       
        var image = '../image_files/Icon_Zombie_Small.png';
        


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


        //alert(marker);

        markers.push(marker);
        marker.setMap(map);

    }
        
}
