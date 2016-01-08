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

import com.sun.javafx.scene.paint.GradientUtils.Point;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;

/**
 * Repraesentiert die Darstellung fuer Polygone.
 * 
 * @author Helena Lajevardi
 */
public class PolygonView extends BorderPane implements Observer{
	
	//todo registriere die view als Observer am modell
	
	private PolygonModell model;
	
	public PolygonView(PolygonModell model) {
		
		this.model = model;
		zeichnePolygone();
		zeichneAktuellesPolygon();
		model.addObserver(this);
	}

	private void zeichneAktuellesPolygon() {
		Path path = new Path();
		if(model.getAktuellesPolygon()!= null){
		for (int i = 0; i < model.getAktuellesPolygon().getPunkte().size(); i++) {
			Punkt punkt = model.getAktuellesPolygon().getPunkte().get(i);
			Ellipse ellipse = new Ellipse();
			ellipse.setCenterX(punkt.getX());
			ellipse.setCenterY(punkt.getY());
			getChildren().add(ellipse);
			
		}
		
		}
		
	}

	public void zeichnePolygone() {
		
		List<Polygon> polygone = model.getPolygone();
		for (Polygon polygon : polygone) {
			for (int i = 0; i < polygon.getPunkte().size(); i++) {
				Punkt punkt = polygon.getPunkte().get(i);
				Ellipse ellipse = new Ellipse();
				ellipse.setCenterX(punkt.getX());
				ellipse.setCenterY(punkt.getY());
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		zeichnePolygone();
		zeichneAktuellesPolygon();
	}



	
	
}
