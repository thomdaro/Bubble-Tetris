package H212Lab9;

import java.awt.Graphics; 
import java.awt.event.KeyEvent; 
import java.awt.event.MouseEvent; 

interface World {
  void draw(Graphics g);  
  void teh(); 
  void meh(MouseEvent e); 
  void keh(KeyEvent e); 
  boolean hasEnded(); 
  void sayBye(); 
}