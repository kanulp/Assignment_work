
//A variable in the scope of this whole Javascript project. Dangerous.
var heatmapData;
var heatMapData2;
var heatMapData3 = [];
var HeatMapStorage;


function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    

    var startLocation = new google.maps.LatLng(37.774546, -122.433523);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
       center: startLocation
    });

    //Add events on to the map.

    //Then populate the map.
	//loadTheData();
    //populateMap();
	NewLoadSystem();
	
	
	
	//test();
    
   
}


function NewLoadSystem()
{
	HeatMapStorage = [{Lat: 45, Long: -81, Weight: 5},
					{Lat: 45.5, Long: -81, Weight: 1},
					{Lat: 46, Long: -81, Weight: 3}
					];
//var fruits = ["Banana", "Orange", "Apple", "Mango"];
//fruits.push("Kiwi", "Lemon", "Pineapple");					
					
	for(var i = 0; i < HeatMapStorage.length; ++i)
	{
		//heatMapData3.push(location new google.maps.LatLng(HeatMapStorage[i].Lat,HeatMapStorage[i].Long),weight: HeatMapStorage[i].Weight );
		heatMapData3.push({location: new google.maps.LatLng(HeatMapStorage[i].Lat,HeatMapStorage[i].Long),weight: HeatMapStorage[i].Weight} );
	
	}
	//{location: new google.maps.LatLng(37.782, -122.447), weight: 0.5}
	var heatmap = new google.maps.visualization.HeatmapLayer({
	data: heatMapData3
	});
	heatmap.setMap(map);

}


////////////////////////////////////////////////////////////////////////////
//
function loadTheData()
{
	//Lets load a thing called an array that holds data. Think of it as a huge
	//set of slots where you can store data. All addressed like 1 or 2 or 3.
	//This is a terrible way to load the data. We will be loading KML data soon 
	
	heatmapData = [
  new google.maps.LatLng(37.782, -122.447),
  new google.maps.LatLng(37.782, -122.445),
  new google.maps.LatLng(37.782, -122.443),
  new google.maps.LatLng(37.782, -122.441),
  new google.maps.LatLng(37.782, -122.439),
  new google.maps.LatLng(37.782, -122.437),
  new google.maps.LatLng(37.782, -122.435),
  new google.maps.LatLng(37.785, -122.447),
  new google.maps.LatLng(37.785, -122.445),
  new google.maps.LatLng(37.785, -122.443),
  new google.maps.LatLng(37.785, -122.441),
  new google.maps.LatLng(37.785, -122.439),
  new google.maps.LatLng(37.785, -122.437),
  new google.maps.LatLng(37.785, -122.435)
					];
					

	
	
	}
	
	

	
	//This function will load the Weighted Heat Map. Seems to not like being made a global variable.
	//This is is because of memory being held by google. They want to resolve the object to a map in the same scope.
	//I can get around this but I need to make a "Zombie Object" called WeightedHeatMapObject. This will be part of next
	//next week's lecture.
function test()
{
	var heatMapData2 = [
  {location: new google.maps.LatLng(37.782, -122.447), weight: 0.5},
  new google.maps.LatLng(37.782, -122.445),
  {location: new google.maps.LatLng(37.782, -122.443), weight: 2},
  {location: new google.maps.LatLng(37.782, -122.441), weight: 3},
  {location: new google.maps.LatLng(37.782, -122.439), weight: 2},
  new google.maps.LatLng(37.782, -122.437),
  {location: new google.maps.LatLng(37.782, -122.435), weight: 0.5},

  {location: new google.maps.LatLng(37.785, -122.447), weight: 3},
  {location: new google.maps.LatLng(37.785, -122.445), weight: 2},
  new google.maps.LatLng(37.785, -122.443),
  {location: new google.maps.LatLng(37.785, -122.441), weight: 0.5},
  new google.maps.LatLng(37.785, -122.439),
  {location: new google.maps.LatLng(37.785, -122.437), weight: 2},
  {location: new google.maps.LatLng(37.785, -122.435), weight: 3}
];
	heatMapData3 = [
  {location: new google.maps.LatLng(37.782, -122.447), weight: 0.5},
  new google.maps.LatLng(37.782, -122.445),
  {location: new google.maps.LatLng(37.782, -122.443), weight: 2},
  {location: new google.maps.LatLng(37.782, -122.441), weight: 3},
  {location: new google.maps.LatLng(37.782, -122.439), weight: 2},
  new google.maps.LatLng(37.782, -122.437),
  {location: new google.maps.LatLng(37.782, -122.435), weight: 0.5},

  {location: new google.maps.LatLng(37.785, -122.447), weight: 3},
  {location: new google.maps.LatLng(37.785, -122.445), weight: 2},
  new google.maps.LatLng(37.785, -122.443),
  {location: new google.maps.LatLng(37.785, -122.441), weight: 0.5},
  new google.maps.LatLng(37.785, -122.439),
  {location: new google.maps.LatLng(37.785, -122.437), weight: 2},
  {location: new google.maps.LatLng(37.785, -122.435), weight: 3}
];

var heatmap = new google.maps.visualization.HeatmapLayer({
  data: heatMapData3
});
heatmap.setMap(map);
}

//This function puts the Heatmap data together with the map.
function populateMap()
{
  
        var heatmap = new google.maps.visualization.HeatmapLayer({
						data: heatmapData
						});
		
		heatmap.setMap(map);

        
   
   }
        
        
        

   
        

