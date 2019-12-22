class Ball2{
  
  private int y,x,dy,dx,size;
  
  public Ball2(int y,int x, int dx, int dy, int size){
    this.y=y;
    this.x=x;
    this.dy=dy;
    this.dx=dx;
    this.size = size;
  }
  
  //calling move
  public void update(){
    move();
    checkCollisionwithWalls();
  }
  
  //to move balls on screen
  public void move(){
    y+=dy;
    x+=dx;  
  }
  
  public void checkCollisionwithWalls(){
    if(isCollidingHorizontal())
      setdy(getdy()*-1);
      
    if(isCollidingVertical())
      setdx(getdx()*-1);
  }
    
   //this is checking is balls are touching horizontal line
  public boolean isCollidingHorizontal(){
      if(getX() + (getSize()/2) > width || getX()-(getSize()/2) < 0 )
      return true;
    return false;
  }
  
  //this is checking is balls are touching vertical line
  public boolean isCollidingVertical(){
    if(getY() + (getSize()/2) > height || getY()-(getSize()/2) < 0 )
      return true;
    return false;
  }
  
  public void display(){
    fill(random(255), random(255), random(255));
    ellipse(x, y, size, size);

  }
  
  
  public int getY(){
    return this.y;
  }
  
  public int getX(){
    return this.x;
  }
  public int getdy(){
    return this.dy;
  }
  
  public int getdx(){
    return this.dx;
  }
  
  public void setdy(int dy){
    this.dy=dy;
  }
  public void setdx(int dx){
    this.dx=dx;
  }
  public int getSize(){
  return this.size;
  }
}
