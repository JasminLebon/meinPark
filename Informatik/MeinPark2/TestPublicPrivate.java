import ch.aplu.util.*;
import java.awt.event.*;
import java.awt.Color;

public class TestPublicPrivate {
  
  GPanel myGPanel;  
  Blume flower;
  boolean starten = true;
  
  // Erstellen des Boards
  public TestPublicPrivate() {
    myGPanel = new GPanel(new Size(1200,700));
    myGPanel.window(0, 1200, 0, 700);      // Festlegung des Koordinatensystems
    myGPanel.title("Mein Park");
    myGPanel.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent evt) {
        mausWurdeGedrueckt(evt);
      }
    });
    
    myGPanel.bgColor(Color.WHITE);
    flower = new Blume(800,500,myGPanel); 
    flower.zeichne();
  }  
    
  public static void main(String[] args) {
    new TestPublicPrivate();
  }  
  
  public void mausWurdeGedrueckt(MouseEvent evt) {
    if (starten) {
      flower.farbe = Color.BLACK;
      flower.zeichne();
      starten = false;
    } else {
      System.exit(0);
    }
  }
}
