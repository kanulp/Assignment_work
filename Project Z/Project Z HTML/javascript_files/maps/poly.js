
//A variable in the scope of this whole Javascript project. Dangerous.
var flightpath = [];
var triangleCoords = [];



function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    

    var startLocation = new google.maps.LatLng(0, -180);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 2,
       center: startLocation,
	   mapTypeId: 'terrain'
    });

    //Add events on to the map.

    //Then populate the map.
	loadTheData();
    populateMap();
	test();
    
   
}

////////////////////////////////////////////////////////////////////////////
//
function loadTheData()
{
	//Lets load a thing called an array that holds data. Think of it as a huge
	//set of slots where you can store data. All addressed like 1 or 2 or 3.
	//This is a terrible way to load the data.
	
	
	
	flightpath.push({lat: 45, lng: -80});
	//flightpath.push({lat: 21.291, lng: -157.821});
   // flightpath.push({lat: -18.142, lng: 178.431});
    flightpath.push({lat: 50, lng: 0});
	
	triangleCoords = [
    {lat: 25.774, lng: -80.190},
    {lat: 18.466, lng: -66.118},
    {lat: 32.321, lng: -64.757},
	{lat: 0, lng:0},
	{lat:89.9,lng:0},
	{lat: 25.774, lng: -80.190},
	
	
  ];
	
}
function test() {
  

  // Define the LatLng coordinates for the polygon's  outer path.
  var outerCoords = [
    {lat: 25.774, lng: -80.190},
    {lat: 18.466, lng: -66.118},
    {lat: 32.321, lng: -64.757}
  ];

  // Define the LatLng coordinates for the polygon's inner path.
  // Note that the points forming the inner path are wound in the
  // opposite direction to those in the outer path, to form the hole.
  var innerCoords = [
    {lat: 28.745, lng: -70.579},
    {lat: 29.570, lng: -67.514},
    {lat: 27.339, lng: -66.668}
  ];

  // Construct the polygon, including both paths.
  var bermudaTriangle = new google.maps.Polygon({
    paths: [outerCoords, innerCoords],
    strokeColor: '#FFC107',
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: '#FFC107',
    fillOpacity: 0.35
  });
  bermudaTriangle.setMap(map);
}


function populateMap()
{
   var flightPath = new google.maps.Polyline({
    path: flightpath,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 10
  });

  flightPath.setMap(map);
  
  var bermudaTriangle = new google.maps.Polygon({
    paths: triangleCoords,
    strokeColor: '#FF0000',
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: '#FF0000',
    fillOpacity: 0.35
  });
  bermudaTriangle.setMap(map);
        
        
   
   
        
}
