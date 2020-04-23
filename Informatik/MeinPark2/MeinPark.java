import ch.aplu.util.*;
import java.awt.event.*;
import java.awt.Color;

public class MeinPark {
  
  GPanel myGPanel;  // das Board
  Blume flower;
  boolean starten = true;
  
  // Erstellen des Boards
  public MeinPark() {
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
  }  
    
  public static void main(String[] args) {
    new MeinPark();
  }  
  
  public void mausWurdeGedrueckt(MouseEvent evt) {
    if (starten) {
      flower.zeichne();
      starten = false;
    } else {
      System.exit(0);
    }
  }
}
