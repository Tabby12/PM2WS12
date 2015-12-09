package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;
import javafx.application.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Visualisierung extends Application implements Observer {

//	private Stage primaryStage;

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Rangierbahnhof){
			Rangierbahnhof bhfSim = (Rangierbahnhof) o;
			
			String gleisdarstellung="|";
			for(int gleisNr=0; gleisNr<Rangierbahnhof.ANZ_GLEISE; gleisNr++){				
				try{
					if(bhfSim.istBelegt(gleisNr)){
						gleisdarstellung+="1|";
					}else{
						gleisdarstellung+="0|";
					}
				}catch(IllegalAccessException e){
					System.err.println(e.getMessage());
				}
			}
			System.err.println(gleisdarstellung);
		}
	}
	
	public void zeichneZug0(Path path){
		MoveTo move = new MoveTo();
		move.setX(60);
		move.setY(60);
		path.getElements().add(move);
		LineTo line = new LineTo();
		line.setX(200);
		line.setY(60);
		path.getElements().add(line);
		LineTo line1 = new LineTo();
		line1.setX(200);
		line1.setY(90);
		path.getElements().add(line1);
		LineTo line2 = new LineTo();
		line2.setX(60);
		line2.setY(90);
		path.getElements().add(line2);
		LineTo line3 = new LineTo();
		line3.setX(60);
		line3.setY(60);
		path.getElements().add(line3);
	}
	
	public void zeichneZug1(Path path){
		MoveTo move = new MoveTo();
		move.setX(60);
		move.setY(110);
		path.getElements().add(move);
		LineTo line = new LineTo();
		line.setX(200);
		line.setY(110);
		path.getElements().add(line);
		LineTo line1 = new LineTo();
		line1.setX(200);
		line1.setY(140);
		path.getElements().add(line1);
		LineTo line2 = new LineTo();
		line2.setX(60);
		line2.setY(140);
		path.getElements().add(line2);
		LineTo line3 = new LineTo();
		line3.setX(60);
		line3.setY(110);
		path.getElements().add(line3);
	}
	
	public void zeichneZug2(Path path){
		MoveTo move = new MoveTo();
		move.setX(60);
		move.setY(160);
		path.getElements().add(move);
		LineTo line = new LineTo();
		line.setX(200);
		line.setY(160);
		path.getElements().add(line);
		LineTo line1 = new LineTo();
		line1.setX(200);
		line1.setY(190);
		path.getElements().add(line1);
		LineTo line2 = new LineTo();
		line2.setX(60);
		line2.setY(190);
		path.getElements().add(line2);
		LineTo line3 = new LineTo();
		line3.setX(60);
		line3.setY(160);
		path.getElements().add(line3);
	}

	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("Gleise");
		StackPane root = new StackPane();
		root.setAlignment(Pos.CENTER);
		Path path = new Path();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(200);
		moveTo.setY(50);
		LineTo lineTo = new LineTo();
		lineTo.setX(50);
		lineTo.setY(50);
		LineTo lineTo1 = new LineTo();
		lineTo1.setX(50);
		lineTo1.setY(200);
		LineTo lineTo2 = new LineTo();
		lineTo2.setX(200);
		lineTo2.setY(200);
		MoveTo moveTo1 = new MoveTo();
		moveTo1.setX(50);
		moveTo1.setY(100);
		LineTo lineTo3 = new LineTo();
		lineTo3.setX(200);
		lineTo3.setY(100);
		MoveTo moveTo2 = new MoveTo();
		moveTo2.setX(50);
		moveTo2.setY(150);
		LineTo lineTo4 = new LineTo();
		lineTo4.setX(200);
		lineTo4.setY(150);
		path.getElements().add(moveTo);
		path.getElements().add(lineTo);
		path.getElements().add(lineTo1);
		path.getElements().add(lineTo2);
		path.getElements().add(moveTo1);
		path.getElements().add(lineTo3);
		path.getElements().add(moveTo2);
		path.getElements().add(lineTo4);
//		path.setStrokeWidth(3);
//		path.setStroke(Color.BLACK);
		root.getChildren().add(path);
		primaryStage.setScene(new Scene(root,250,250));
		if(true){
			zeichneZug0(path);
		}
		if(true){
			zeichneZug1(path);
		}
		if(true){
			zeichneZug2(path);
		}
		primaryStage.show();
	}
	public static void main(String[] args) {
		Simulation simRunnable = new Simulation();
		Visualisierung visualisierung = new Visualisierung();
		simRunnable.bhf.addObserver(visualisierung);
		
		Thread simThread = new Thread(simRunnable);
		simThread.start();
		Application.launch();
	}
}
