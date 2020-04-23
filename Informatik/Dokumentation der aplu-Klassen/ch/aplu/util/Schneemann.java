package ch.aplu.util;
import java.awt.Color;

/**<p> 
 * Material für den Informatikunterricht Mutschke EF:<br />
 * Teil des Projekts MeinPark
 * <p/>
 * <p> 
 * Klasse Schneemann <br />
 *  Objekt der Klasse Schneemann wird in der Farbe weiß 
 *  an die gewünschten Koordinaten eines bestimmten GPanels gezeichnet.
 * </p>
 * 
 * @author Jasmin Lebon
 * @version April 2020 
 */
public class Schneemann {
  private GPanel gp;        // Board
  private double xPos;      // x-Koordinate des untersten Punktes
  private double yPos;      // y-Koordinate des untersten Punktes
  private double radius;    // Radius des größten Kreises
  private Color farbeSchneemann;
  
  /**
   * Konstruktor der Klasse Schneemann, bei dem ein Schneemann 
   * auf dem übergebenen GPanel erzeugt (aber noch nicht gezeichnet) wird.
   */
  public Schneemann(GPanel gp, double x, double y, double r, Color farbeSchneemann) {
    this.gp = gp;
    xPos = x;
    yPos = y;
    radius = r;
    farbeSchneemann = Color.WHITE;
  }
  
  /**
   * Der Schneemann wird gezeichnet.
   */ 
  public void zeichne(double xPos, double yPos, double radius, Color farbeSchneemann) {
    gp.move(xPos, yPos);                        // unterer Kreis
    gp.color(farbeSchneemann);
    gp.fillCircle(radius);
     
    gp.move(xPos, yPos+(radius+0.75*radius));            // mittlerer Kreis
    gp.color(farbeSchneemann);
    gp.fillCircle(radius * 0.75); 
    
    gp.move(xPos, yPos+(radius + 0.75*radius*2 + 0.5*radius));           // oberer Kreis
    gp.color(farbeSchneemann);
    gp.fillCircle(radius * 0.5); 
  }
  
   /**
   * Der Schneemann wird um 5% verkleinert.
   */ 
  public void schmelzeEinWenig() {
    verschwinde();
    radius= radius*0.95;
    zeichne(xPos, yPos, radius, Color.WHITE);
  }
  
  // Verschwindenlassen des Schneemanns durch blau (Hintergrundfarbe) malen
  private void verschwinde() { 
    zeichne(xPos, yPos, radius, Color.BLUE);
  }
 
   /**
   * Berechnen des Abstands zwischen zwei Punkten.
   */ 
  public double distance(double pX, double pY) {
    double p1X = xPos;
    double p1Y = yPos;
    double p2X = pX;
    double p2Y = pY;
    double abstand = Math.sqrt((p1X-p2X)*(p1X-p2X) + (p1Y-p2Y)*(p1Y-p2Y));
    return abstand;
  }
  
  public double getRadius() {
    return radius;
  }
  
  public double getPosX() {
    return xPos;
  } 
  
  public double getPosY() {
    return yPos;
  } 
  
  public void bewege(int nachX, int nachY) {
    verschwinde();
    zeichne(nachX, nachY, radius, farbeSchneemann);
  }
}
