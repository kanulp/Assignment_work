var AnimalName = "Felix";
var AnimalArray  = [];

function EntryPoint()
{
	
	
	
	document.getElementById('display').innerHTML = "Hello World";
	document.getElementById('displayName').innerHTML = AnimalName;		
	//alert("Hello World");
	AnimalName = "Fido";
	changeAnimalName(AnimalName);
	SayMessage("Hello everyone my name is Felix");
	callaVariable();
	
	LoadTheArray();
	ChangeThePage();
	
	var TheAnswer = Add(10,20);
	SayMessage(TheAnswer);
	
	SingASong(99);
	
}

function SingASong(iteration)
{
	for(var i = 1; i < iteration+1; ++i)
	{
	var p = document.createElement("p");	
	p.innerHTML = i + " bottles of beer on the wall. " + i + " bottles of beer...";           
	document.body.appendChild(p);  	
	}
}

function Add(x,y)
{
	return x+y;
}

function LoadTheArray()
{
	AnimalArray.push("Cat");
	AnimalArray.push("Canary");
	AnimalArray.push("Dog");
	AnimalArray.push("Velociraptor?");
}

function ChangeThePage()
{
	 for(var i = 0; i < AnimalArray.length; i++)
   {
	    var ul = document.getElementById("AnimalList");
		var li = document.createElement("li");
		li.appendChild(document.createTextNode(AnimalArray[i]));
		ul.appendChild(li);
	   
   }
}

function callaVariable()
{
	alert(AnimalName);
}

function changeAnimalName(N)
{
		alert(N);
}

function SayMessage(S)
{
		alert(S);
}


