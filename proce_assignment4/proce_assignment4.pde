/*
This program draws different balls in a screen and every colorful 
ball represent happy incidents.

*/
Ball2[] balls = new Ball2[20];

void setup(){
  size(1280,720);
  //random size given in class constructor 
  for(int i=0;i<balls.length;i++){
    balls[i] = new Ball2(int(random(50,400)), int(random(50,400)), int(random(5)), int(random(5)),  int(random(10,100))  );
  }
}

void draw(){
  background(255, 304, 5);
   textSize(35);
  text("Happy", 10, 30); 
    
  //20 balls are created as 1st line we have passed
  for(int i=0;i<balls.length;i++){
    balls[i].display();
    balls[i].update();  
   }
  
  
  
}
