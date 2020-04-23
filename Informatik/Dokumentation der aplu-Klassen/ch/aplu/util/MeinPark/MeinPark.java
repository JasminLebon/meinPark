package ch.aplu.util;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;
 
public class MeinPark {
 
  GPanel myGPanel;  // das Board
  Blume[] flower = new Blume[5];  // Objekte Blumen Deklaration
  Sonne sun;                      // Objekt Sonne Deklaration
  Schneemann snowman;             // Objekt Schneemann Deklaration
  double xPos;
  double yPos;
  Color farbeSchneemann;
  //Color farbeBlume;                   
  boolean starten = true;
  Color[] farbeBluete = {Color.RED, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.CYAN}; // Farben der Blüten(Blumen)
 
  
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
    
    // Erschaffung der Objekte Blumen
    for (int i=0; i<5; i++) {
      myGPanel.bgColor(Color.BLUE);    // blauer Hintergrund, als Himmel und zur Sichtbarkeit des Schneemanns
      int koordinate1 = new Random().nextInt(1000) + 100;
      int koordinate2 = new Random().nextInt(600) + 50;
      while ((koordinate1 <= 575 && koordinate1 >= 625) && (koordinate2 <= 113)) {
        koordinate1 = new Random().nextInt(1000) + 100;
        koordinate2 = new Random().nextInt(600) + 50;
      }
      flower[i] = new Blume(koordinate1,koordinate2,myGPanel,farbeBluete[i]);  
    } 
    
    // Erschaffung des Objekts Sonne
    sun = new Sonne(100, 500, 40, myGPanel, Color.YELLOW);
    
    // Erschaffung des Objektes Schneemann 
    snowman = new Schneemann(myGPanel, 600, 60, 60, Color.WHITE); 
    xPos = snowman.getPosX();
    yPos = snowman.getPosY();
    
    
    // Zeichnen der Sonne 
    sun.zeichne(); 
    while (starten) {
      sun.bewegeZufaellig();    // zufälliges Bewegen der Sonne
      double pX = sun.getPosX();
      double pY = sun.getPosY();
      double r = sun.getRadius();
      double distance = snowman.distance(pX, pY);
      if (distance < (r*4) ) {
        snowman.schmelzeEinWenig();
        GPanel.delay(500);
        sun.setRadius(r*0.05);
        sun.zeichne();
      } 
      
      // Zeichnen der Blumen
      for (int i=0; i<5; i++) {
        flower[i].zeichne();
      } // end of for
      
      snowman.zeichne(xPos, yPos, snowman.getRadius(), farbeSchneemann);      // Zeichnen des Schneemanns
      
      if (snowman.getRadius() < 5) {
        break;
      }
    } 
  }  
    
  public static void main(String[] args) {
    new MeinPark();
  }  
    
  public void mausWurdeGedrueckt(MouseEvent evt) {
    System.exit(0);
  }
  
  private void bewegeSchneemannFallsTasteGedrueckt() {
    int keyCode = myGPanel.getKeyCode(); 
    int x = (int)xPos;        
    int y = (int)yPos;    
    switch (keyCode) {         
      case KeyEvent.VK_LEFT:       
        snowman.bewege(x-1,y);      
        break;     
      case KeyEvent.VK_RIGHT:
        snowman.bewege(x+1,y);
        break;  
      default: // nichts (nur der Form halber ein default)
        break;
    }   
  } 
}
  
