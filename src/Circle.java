package H212Lab9;

import java.awt.Graphics; 
import java.awt.Color;

class Circle {
  int x, y, radius;
  Color color;
  
  Circle(int x, int y, int r, Color c) {
    this.x = x;
    this.y = y; 
    this.radius = r; 
    this.color = c;
  }
  
  void draw(Graphics g) {
    g.setColor(new Color(0, 0, 0));
    g.drawOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius); 
    g.setColor(this.color);
    g.fillOval(this.x - this.radius + 1, this.y - this.radius + 1, 
               2 * (this.radius - 1), 2 * (this.radius - 1));
  }
  
  void drop() {
    this.y += 1;
  }
  
  void moveLeft() {
      this.x -= 2;
  }
  
  void moveRight() {
      this.x += 2;
  }
  
  boolean isColliding(Circle other) {
    return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2)) <=
           this.radius + other.radius;
  }
}