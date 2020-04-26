
//A variable in the scope of this whole Javascript project. Dangerous.
var laBoundaries;
var kml_url;

function initMapMarker()
{
    //This is where the first Javascript is called. This call wakes the map
    //and we can initialize all the other code we need. 

    

    var startLocation = new google.maps.LatLng(0, 0);

    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
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
	//We can load data using a KML file. Neat.
	//kml_url  = "https://dff40dea-a-62cb3a1a-s-sites.googlegroups.com/site/acmekml/kml_ver2/Test.kml?attachauth=ANoY7cqISjnpke-xu6lxhQEpet2R_0-ejr9v2nf6rzEb9Gx71W__ahpey9F9btsq0uLyVjgvIJJSGXTZEeY6MNGvURMIOM1o33X2EuvzyrtW07lbp16rmbVdPel21ppnTffHMNZdb2yMtqLH-A4CeUcEQit0HQNgtVffqaga-V2IMM4k5SYcfd1ynoT9Om_1YbxPWJxjc4-jO_tXCKEp-nGwgiv2m_EjhQ%3D%3D&attredirects=0&d=1"
	//kml_url = "https://controllerdata.lacity.org/api/geospatial/3mvs-psab?method=export&format=KML";
	//kml_url = "image_files/Los Angeles Council District Boundaries.kml";
	kml_url = "https://bc7d283b-a-62cb3a1a-s-sites.googlegroups.com/site/clayskml/storage/SampleKml1.kml?attachauth=ANoY7cpMOLKpn4BAbVULfWRtcon3LzdokVv12oVmwM9BlepH47AMbiUBfqyF23hQ3UrOb7eHg_wKfKE9CSTVemAOxBO_lP6CjcT9BqseXK-hp7LQYrbT9eqFlOVFDSgN2TH4H6QE9MfLd7JYzKUP9dOy7EBo5ts5TGC4mBp9D47zfIUR7HPUTCf643IF1SJdxLFuNGzkoezzEPf1L3a1u-iQS_7CEkUAlg%3D%3D&attredirects=0&d=1";
	}
	
	


function populateMap()
{
   laBoundaries = new google.maps.KmlLayer({
    url: kml_url,
    map: map
	});
   
}
        
        
        

   
        

