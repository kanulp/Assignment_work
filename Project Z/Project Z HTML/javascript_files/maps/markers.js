
//A variable in the scope of this whole Javascript project. Dangerous.
var markers = [];
var builtmarkers = [];


function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    

    var startLocation = new google.maps.LatLng(-34, 151);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
       center: startLocation
    });

    //Add events on to the map.

    //Then populate the map.
	loadTheData();
    populateMap();

	
}



////////////////////////////////////////////////////////////////////////////
//
function loadTheData()
{
	//Lets load a thing called an array that holds data. Think of it as a huge
	//set of slots where you can store data. All addressed like 1 or 2 or 3.
	//This is a terrible way to load the data.
	
	
	
	//var marker = {position: {lat: -34, lng:151},title: 'Simon Pegg', elevation: 100,date: '2019-01-01', serialnumber: 1, contacttype: 'Slow'};
	
	//markers.push(marker);	
	markers.push( {position: {lat: -34, lng:151},title: 'Simon Pegg', elevation: 100,date: '2019-01-01', serialnumber: 1, contacttype: 'Fast'});
	markers.push({position: {lat: -34, lng:152},title: 'Nick Frost', elevation: 100,date: '2019-01-10', serialnumber: 2, contacttype: 'Slow'});
	}


function populateMap()
{
   for(var i = 0; i < markers.length; i++)
   {
   var position = new google.maps.LatLng(markers[i].position.lat,markers[i].position.lng);

        var ZombieName = markers[i].title;
        var Elevation = markers[i].elevation;
        var Date = markers[i].date;
        var SerialNumber = markers[i].serialnumber;
        var ContactType = markers[i].contacttype;

        //I do think I am going to move these styling calls to another function.
        //Clean things up.
        // var image = 'http://http://icons.iconarchive.com//icons//hopstarter//halloween-avatar//256//Zombie-PVZ-icon.png';
       
        var image = 'image_files/Icon_Zombie_Small.png';
        
		

        var marker = new google.maps.Marker({
            position: position,
            title: ZombieName,
			//label: ZombieName,
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

        builtmarkers.push(marker);
        marker.setMap(map);
   
   
   }
        
        
        

   
        
}
