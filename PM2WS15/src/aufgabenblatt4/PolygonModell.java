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
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Repraesentiert ein Polygonmodell zur Verwaltung von Polygonen.
 * 
 * @author Helena Lajevardi
 */
public class PolygonModell extends Observable implements Observer{
	
	/**
	 * Das aktuelle Polygon.
	 */
	private Polygon aktuellesPolygon;
	
	/**
	 * Eine Liste der bearbeiteten Polygone.
	 */
	private ObservableList<Polygon> polygonListe;
	
	public PolygonModell() {
		polygonListe = FXCollections.observableArrayList();
		aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
		
	}
	
	
	public void polygonBearbeitungAbschlieﬂen(){
		this.polygonListe.add(this.aktuellesPolygon);
		this.aktuellesPolygon = new Polygon();
		setChanged();
		notifyObservers();
	}
	
	public List<Polygon> getPolygone() {
		return polygonListe;
	}
	
	


	public Polygon getAktuellesPolygon() {
		return aktuellesPolygon;
	}


	public void setAktuellesPolygon(Polygon aktuellesPolygon) {
		this.aktuellesPolygon = aktuellesPolygon;
	}


	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}

}
