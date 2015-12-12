package aufgabenblatt3;

	import java.util.Observable;
	import java.util.Observer;
	import javafx.application.Application;
	import javafx.application.Platform;
	import javafx.geometry.Pos;
	import javafx.scene.Scene;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.StackPane;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.LineTo;
	import javafx.scene.shape.MoveTo;
	import javafx.scene.shape.Path;
	import javafx.stage.Stage;

	/**
	 * Grafische Darstellung der Simulation.
	 * @author Lennart Hartmann, Helena Lajevardi
	 */
	
	public class Visualisierung extends Application implements Observer{

	    /**
	     * Der dasrgestellte Bahnhof.
	     */
	    private Rangierbahnhof rBhf ;

	    /**
	     * speichert die Linien, aus denen die Darstellung zusammengesetzt ist
	     */
	    private Path path;
	    
	    /**
	     * Rahmen der Darstellung.
	     */
	    private BorderPane borderPane;
	    
	    @Override
	    public void start(Stage primaryStage) {        
	        initialisiereSimulation();
	        initialisiereDarstellung(primaryStage);
	    }
	    
	    @Override
	    public void update(Observable arg0, Object arg1) {
	        if (arg0 instanceof Simulation){
	            Platform.runLater(() -> zeichneBahnhof());
	        }
	    }
	    
	    /**
	     * Initialisiert und startet die Simulation eines Bahnhofs.
	     */
	    private void initialisiereSimulation(){
	    	Simulation simulation = new Simulation();
	        rBhf = simulation.bhf;
	        simulation.addObserver(this);
	        new Thread(simulation).start();
	    }
	    
	    /**
	     * Initialisiert die grafische Darstellung
	     * @param primaryStage
	     */
	    private void initialisiereDarstellung(Stage primaryStage){
	        primaryStage.setTitle("Bahnhof");
	        
	        //WurzelKnoten
	        StackPane root = new StackPane();       
	        root.setAlignment(Pos.CENTER);
	        
	        //Knoten den Rahmen
	        borderPane = new BorderPane();       
	        //Knoten fuer Linien
	        path = new Path();                      
	        path.setStrokeWidth(3);
	        path.setStroke(Color.BLACK);
	        
	        //Baumstruktur erzeugen
	        root.getChildren().add(borderPane);
	        root.getChildren().add(path);
	        
	        primaryStage.setScene(new Scene(root,300,300));
	        primaryStage.show();
	    }
	    
	    /**
	     * Zeichnet die Gleise und die am Bahnhof und geparkte Zuege.
	     */
	    private void zeichneBahnhof(){
	        path.getElements().clear();
	        borderPane.getChildren().clear();
	        zeichneGleise();
	        zeichneZuege();
	    }

	    /**
	     * Zeichnet die Gleise
	     */
		public void zeichneGleise(){
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
		}
	    
		/**
		 * Zeichnet einen Zug auf jedes gelegte Gleis
		 */
	    private void zeichneZuege(){
	        for (int i=0; i<Rangierbahnhof.ANZ_GLEISE; i++){ 
	        	try{
	            if (rBhf.istBelegt(i)){ 
	                zeichneZug(i);
	            	}
	            }catch(IllegalAccessException e){
	            	e.printStackTrace();
	            }
	        }
	    }
	    
	    /**
	     * Zeichnet einen Zug auf das angegebene Gleis
	     * @param i das Gleis, auf welchem ein Zug gezeichent werden soll
	     */
	    private void zeichneZug(int i){
	    	switch(i){
	    		case 0: 
	    			zeichneZug0();
	    			break;
	    		case 1: 
	    			zeichneZug1();
	    			break;
	    		case 2: 
	    			zeichneZug2();
	    			break;
	    		default:
	    			break;
	    	}
	    }
	    
	    /**
	     * Zeichnet einen Zug auf Gleis 0
	     */
		public void zeichneZug0(){
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
		
		/**
	     * Zeichnet einen Zug auf Gleis 1
	     */
		public void zeichneZug1(){
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
		
		/**
	     * Zeichnet einen Zug auf Gleis 2
	     */
		public void zeichneZug2(){
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
	    
	    
	    public static void main(String[] args){
	        Application.launch(args);
	    }
	    
	}
