import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BubbleTetris implements World { // or extends if you use the adapter 
  
  ArrayList<Circle> circles;
  Circle current;
  Random gen = new Random();
  static final int SIZE = 400;
  
  public BubbleTetris() {
    this.circles = new ArrayList<Circle>();
    this.current = new Circle(gen.nextInt(SIZE), 0, gen.nextInt(40) + 10,
                   new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
    this.circles.add(this.current);
  }
  
  public void teh() {
    if (this.current.y < SIZE - 40)
      this.current.drop();
    else {
      this.current = new Circle(gen.nextInt(SIZE), 0, gen.nextInt(40) + 10,
                     new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
      circles.add(this.current);
    }
    for (int i = 0; i < this.circles.size() - 1; i++) {
      if (this.current.isColliding(this.circles.get(i))) {
        this.current = new Circle(gen.nextInt(SIZE), 0, gen.nextInt(40) + 10,
                       new Color(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255)));
        circles.add(this.current);
      }
    }
  }
  
  public void meh(MouseEvent e) {
    
  }
  
  public void keh(KeyEvent e) {
    int code = e.getKeyCode();
    
    if (code == 37)
        this.current.moveLeft();
    else if (code == 39)
        this.current.moveRight();
  }
  
  public void draw(Graphics g) {  
    for (Circle c : this.circles)
      c.draw(g);
  }
  
  public static void main(String[] args) {
    BigBang b = new BigBang(new BubbleTetris()); 
    b.start(15, // delay 
            SIZE  // size 
           ); 
  }
  
  public boolean hasEnded() {
    for (int i = 0; i < this.circles.size() - 1; i++)
      if (this.circles.get(i).y - this.circles.get(i).radius <= this.current.radius)
          return true;
    return false;
  }
  
  public void sayBye() {
    
  }
}
