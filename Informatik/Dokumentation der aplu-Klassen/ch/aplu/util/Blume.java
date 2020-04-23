package ch.aplu.util;
import java.awt.Color;

/**
 * <p>
 * Material f�r den Informatikunterricht Mutschke EF:<br />
 * Einf�hrung in die objektorientierte Programmierung, Projekt MeinPark
 * </p>
 * <p>
 * Klasse Blume   <br />
 * Objekte der Klasse Blume werden in einer zuf�llig gew�hlten Farbe an die 
 * gew�nschten Koordinaten eines bestimmten GPanels gezeichnet.
 * </p>
 * 
 * @author Sabine Mutschke
 * @version April 2019
 */

public class Blume {
  private GPanel gp;
  private int xPos;         // x-Koordinate des unteren Ende des St�ngels
  private int yPos;         // y-Koordinate des unteren Ende des St�ngels
  private Color farbeBlume;
  private Color farbeBluete[];
  
  /**
   * Konstruktor der Klasse Blume, bei dem eine Blume mit zuf�lliger Farbe
   * auf dem �bergebenen GPanel erzeugt (aber noch nicht gezeichnet) wird. 
   * Das untere Ende des St�ngels erh�lt die �bergebenen Koordinaten (x|y).
   */
  public Blume(int x, int y, GPanel gp, Color farbeBluete) {
    xPos = x;
    yPos = y;
    this.gp = gp;
    farbeBlume = farbeBluete; 
  }
  
  /**
   * Konstruktor der Klasse Blume, bei dem eine Blume mit zuf�lliger Farbe
   * auf dem �bergebenen GPanel erzeugt (aber noch nicht gezeichnet) wird. 
   * Das untere Ende des St�ngels erh�lt die �bergebenen Koordinaten (x|y).
   * Die farbe der Bl�te wird zf�llig aus vier Farben gew�hlt.
   */
//  public Blume(int x, int y, GPanel gp) {
//    xPos = x;
//    yPos = y;
//    this.gp = gp;
//    int zufall = (int) (Math.random()*4);
//    switch (zufall) {
//      case 0: 
//        farbe = Color.RED;
//        break;
//      case 1: 
//        farbe = Color.MAGENTA;
//        break;
//      case 2: 
//        farbe = Color.YELLOW;
//        break;
//      case 3: 
//        farbe = Color.ORANGE;
//        break;
//    }
//  }
  
  /** 
  * Die Blume wird gezeichnet.
   */
  public void zeichne() {
    zeichneStaengel();
    zeichneBluete();
  }
  
  private void zeichneStaengel() {               // St�ngel der Blume wird gezeichnet
    gp.color(Color.GREEN);
    gp.move(xPos,yPos); 
    gp.draw(xPos,yPos+20);
    gp.move(xPos,yPos+10);
    gp.draw(xPos+10,yPos+15);
    gp.move(xPos,yPos+10);
    gp.draw(xPos-10,yPos+15);
    gp.move(xPos,yPos+25);
  } 

  private void zeichneBluete() {                 // Bl�te der Blume wird gezeichnet
    gp.color(farbeBlume);
    gp.fillCircle(5);
  }
}   
