
//A variable in the scope of this whole Javascript project. Dangerous.
var overlay;
var imagebounds;
var valueNorth;

function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 
   var valueNorth;

    var startLocation = new google.maps.LatLng(55, 0);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 11,
       center: startLocation,
	   mapTypeId: 'satellite'
	   
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
	
	 var imageBounds = {north: 40.773941,south: 40.712216,east: -74.12544,west: -74.22655};
	 var imageBounds1 =   {north: 60.52,south: 52,east: 1.7,west: -5.5};	
	 var imageBounds2 = {north: 53,south: 52,east: -4.5,west: -5.5};
	 ValueNorth = imageBounds1.north;
	
  	overlay = new google.maps.GroundOverlay('https://www.lib.utexas.edu/maps/historical/newark_nj_1922.jpg',imageBounds);
  	overlay1 = new google.maps.GroundOverlay('image_files/UK_map.jpg',imageBounds1);
	overlay2 = new google.maps.GroundOverlay('image_files/Cardiff_SW_England.png',imageBounds2);
	
	
}

function adjustOverlay()
{
	ValueNorth = ValueNorth + 1;
	alert(ValueNorth);
}

function populateMap()
{
  
 overlay.setMap(map);
  overlay1.setMap(map);
  overlay2.setMap(map);
}




