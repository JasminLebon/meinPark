package ch.aplu.util;
import java.awt.Color;

/**<p> 
 * Material für den Informatikunterricht Mutschke EF:<br />
 * Teil des Projekts MeinPark
 * <p/>
 * <p> 
 * Klasse Sonne <br />
 *  Objekt der Klasse Sonne wird in der Farbe gelb 
 *  an die gewünschten Koordinaten eines bestimmten GPanels gezeichnet.
 * </p>
 * 
 * @author Jasmin Lebon
 * @version April 2020 
 */


public class Sonne {
  private GPanel gp;        // Board
  private int xPos;         // x-Koordinate 
  private int yPos;         // y-Koordinate 
  private double radius;       // Radius der Sonne
  private Color farbe;      // Farbe der Sonne
  
  /**
   * Konstruktor der Klasse Sonne, bei dem eine Sonne in gelb
   * auf dem übergebenen GPanel erzeugt (aber noch nicht gezeichnet) wird. 
   * Die Sonne hat die übergebenen Koordinaten (x|y) und einen Radius r.
   */
  public Sonne(int x, int y, double r, GPanel gp, Color farbe) {
    xPos = x;
    yPos = y;
    radius = r;
    this.gp = gp;
    farbe = Color.YELLOW; 
  }
  
  /**
   * Die Sonne wird gezeichnet.
   */
  public void zeichne() {
    gp.move(xPos, yPos);
    gp.color(Color.YELLOW);
    gp.fillCircle(radius);
  }
  
  // Verschwindenlassen der Sonne durch blau (Hintergrundfarbe) malen
  private void verschwinde() {
    gp.move(xPos, yPos);
    gp.color(Color.BLUE);
    gp.fillCircle(radius);
  }
  
  /**
   * Die Sonne wird in eine zufällige Richtung bewegt.
   */
  public void bewegeZufaellig() {  
    verschwinde();            // vorherige Sonne verschwindet
    int zufall = (int) (Math.random()*4);
    switch (zufall) {
      case 0: 
        if (xPos < 1150) {
          xPos += 10;   // Verschiebung nach rechts
          zeichne();
          GPanel.delay(500); 
        }
        break;
      case 1: 
        if (xPos < 60) {
          xPos -= 10;   // Verschiebung nach links
          zeichne();
          GPanel.delay(500);
        }
        break;
      case 2: 
        if (yPos < 650) {
          yPos += 10;   // Verschiebung nach oben
          zeichne();
          GPanel.delay(500);
        }
        break;
      case 3: 
        if (yPos > 60) {
          yPos -= 10;   // Verschiebung nach unten
          zeichne();     
          GPanel.delay(500);
        }
        break;
    }
  }
  
  public int getPosX() {
    return xPos;
  }
  
  public int getPosY() {
    return yPos;
  }
  
  public double getRadius() {
    return radius;
  }
  
  public void setRadius(double pRadius) {
    radius = pRadius;
  }
}
