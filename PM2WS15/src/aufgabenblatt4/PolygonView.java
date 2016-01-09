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
 * @author Helena Lajevardi
 */
public class PolygonView extends BorderPane implements Observer{
	
	private PolygonModell model;
	
	private Path path;
	ObservableList<PathElement> pathElements;
	
	public PolygonView(PolygonModell model) {
		
		this.model = model;
		path = new Path();
		this.getChildren().add(path);
		//zeichnePolygone();
		//zeichneAktuellesPolygon();
		model.addObserver(this);
	}

	private void zeichneAktuellesPolygon() {
//		if(!path.getElements().isEmpty()){
			path.getElements().clear();
			
			
//		}
		pathElements = path.getElements();
		Polygon aktuellesPolygon = model.getAktuellesPolygon();
		Punkt letzterPunkt = null;
		if(model.getAktuellesPolygon()!= null){
			List<Punkt> punkte = aktuellesPolygon.getPunkte();
			if(!punkte.isEmpty()) {
				erzeugeStartPunkt(punkte, pathElements);
			}
			for (Punkt aktuellerPunkt : punkte) {
				if(letzterPunkt != null){
					erzeugeLinie(pathElements, aktuellerPunkt);
				}
				erzeugePunkt(aktuellerPunkt,Color.RED);
				letzterPunkt = aktuellerPunkt;
			}
			path.setStrokeWidth(3);
			path.setStroke(Color.RED);
			
		}
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

	public void zeichnePolygone() {
		
		List<Polygon> polygone = model.getPolygone();
		for (Polygon polygon : polygone) {
			erzeugeStartPunkt(polygon.getPunkte(), pathElements);
			for (int i = 0; i < polygon.getPunkte().size(); i++) {
				Punkt punkt = polygon.getPunkte().get(i);
				erzeugePunkt(punkt,Color.BLACK);

			}
			
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		zeichnePolygone();
		zeichneAktuellesPolygon();
	}



	
	
}
