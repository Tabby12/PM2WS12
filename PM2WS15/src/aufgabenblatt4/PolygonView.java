/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.rmi.CORBA.PortableRemoteObjectDelegate;

import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;

/**
 * Repraesentiert die Darstellung fuer Polygone.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 10.1.2016
 */
public class PolygonView extends BorderPane implements Observer{
	
	private PolygonModell model;
	
	private Path pathSchwarz;
	private Path pathRot;
	//ObservableList<PathElement> pathElements;
	
	
	public PolygonView(PolygonModell model) {
		
		this.model = model;
		model.addObserver(this);
		pathSchwarz = new Path();
		pathRot = new Path();
		this.getChildren().add(pathSchwarz);
		this.getChildren().add(pathRot);
		
		pathSchwarz.setStrokeWidth(3);
		pathSchwarz.setStroke(Color.BLACK);
		pathRot.setStrokeWidth(3);
		pathRot.setStroke(Color.RED);
		
		// Testblock
//		MoveTo movRot = new MoveTo();
//		movRot.setX(0);
//		movRot.setY(0);
//		LineTo roteLinie=new LineTo();
//		roteLinie.setX(50);
//		roteLinie.setY(50);
//		pathRot.getElements().add(movRot);
//		pathRot.getElements().add(roteLinie);
	}

	private void erzeugeStartPunkt(List<Punkt> punkte, ObservableList<PathElement> pathElements) {
		MoveTo moveToStartpunkt = new MoveTo();
		Punkt startPunkt = punkte.get(0);
		moveToStartpunkt.setX(startPunkt.getX());
		moveToStartpunkt.setY(startPunkt.getY());
		pathElements.add(moveToStartpunkt);
	}

	private void erzeugePunkt(Punkt aktuellerPunkt, Color color) {
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(aktuellerPunkt.getX());
		ellipse.setCenterY(aktuellerPunkt.getY());
		ellipse.setRadiusX(1);
		ellipse.setRadiusY(1);
		ellipse.setStrokeWidth(3);
		ellipse.setStroke(color);
		this.getChildren().add(ellipse);
	}

	private void erzeugeLinie(ObservableList<PathElement> pathElements, Punkt aktuellerPunkt) {
		LineTo lineToAktuellerPunkt = new LineTo();
		lineToAktuellerPunkt.setX(aktuellerPunkt.getX());
		lineToAktuellerPunkt.setY(aktuellerPunkt.getY());
		pathElements.add(lineToAktuellerPunkt);
	}

	@Override
	public void update(Observable o, Object arg) {
		pathRot.getElements().clear();//-alles
		zeichnePolygone();
	}
	
	/**
	 * Fuegt der Darstellung alle Polygone hinzu
	 */
	private void zeichnePolygone() {
		
		
		//fuege aktuelles Polygon hinzu
		zeichnePolygon(model.getAktuellesPolygon(),Color.RED);
		
		//fuege bearbeitete Polygone hinzu
		List<Polygon> polygone = model.getPolygonListe();
		for (Polygon polygon : polygone) {
			zeichnePolygon(polygon, Color.BLACK);
		}
	}

	/**
	 * Fuegt der Darstellung ein Polygon hinzu
	 * @param polygon	das Darzustellende Polygon
	 * @param color	 	die gewuenschte Farbe
	 */
	private void zeichnePolygon(Polygon polygon, Color color) {
		
		if(polygon != null){
			
			ObservableList<PathElement> pathElements=null;
			if(color == Color.RED){
				pathElements = pathRot.getElements();           //- ObservableList<PathElement>
			}else{
				pathElements = pathSchwarz.getElements(); 
			}
			Punkt letzterPunkt = null;
			List<Punkt> punkte = polygon.getPunkte();
			if(!punkte.isEmpty()) {
				erzeugeStartPunkt(punkte, pathElements);									//-ObservableList<PathElement>
			}
			for (Punkt aktuellerPunkt : punkte) {
				if(letzterPunkt != null){
					erzeugeLinie(pathElements, aktuellerPunkt);  //aenderung 				//-ObservableList<PathElement>
				}
				erzeugePunkt(aktuellerPunkt,color);
				letzterPunkt = aktuellerPunkt;
			}
		}
	}
}
