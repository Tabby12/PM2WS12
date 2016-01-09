/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sun.javafx.scene.paint.GradientUtils.Point;

/**
 * Repraesentiert ein Polygon.
 * 
 * @author Helena Lajevardi
 */
public class Polygon extends Observable {
	
	/**
	 * Eine Liste der Polygonpunkte.
	 */
	private List<Punkt> punkte;
	
	private String name;
	
	public Polygon() {
		this.punkte = new ArrayList<Punkt>();
	}
	
	public void punktHinzufuegen(Punkt punkt){
		punkte.add(punkt);
		setChanged();
		notifyObservers();
	}
	
	public void punktVerschieben(Punkt punkt,int x, int y){
		setChanged();
		notifyObservers();
		
		
	}

	@Override
	public String toString() {
		return name = "Polygon mit " + punkte.size() + " Punkten";
	}

	public List<Punkt> getPunkte() {
		return punkte;
	}
	
	
	
	

}
