/*
This program draws ellipses based on values provided and to show stress 
gradient color are highlighted. Background collor is dark and the text is 
also highlighted based on random color.

*/
int dim;

void setup()
{
size(800,600);

  dim = width/2;
  colorMode(HSB, 360, 100, 100);
  noStroke();
  ellipseMode(RADIUS);
  frameRate(20);
}

void draw()
{
    background(255, 304, 5);
    textSize(35);
    fill(random(255),random(255),random(255));
    text("Stress", 10, 30); 
     for (int x = 0; x <= width; x+=dim) {
      drawGradient(x, height/2);
    } 
}

/*this will draw gradient passing x and y
then radius is calculated
ellipse is drawn
*/
void drawGradient(float x, float y) {
  int radius = dim/2;
  float h = random(0, 360);
  for (int r = radius; r > 0; --r) {
    fill(h, 90, 90);
    ellipse(x, y, r, r);
    h = (h + 1) % 360;
  }
}
