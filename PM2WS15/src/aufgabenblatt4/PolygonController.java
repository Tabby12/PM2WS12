/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Repraesentiert einen Controller fuer Polygone.
 * 
 * @author Helena Lajevardi
 */
public class PolygonController extends Application {

	/**
	* Startet die Anwendung.
	* @param args nichts
	*/
	public static void main(String[] args) {
		launch(args);
	}
	
	private PolygonView view;
	private PolygonModell model;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new PolygonModell();
		view = new PolygonView(model);
		initialisiereGUI(primaryStage, model);
		
		
	}
	
	private void initialisiereGUI(Stage primaryStage, PolygonModell model) {
		
		int GROESSE = 400;
		
		primaryStage.setTitle("Polygon Zeicheneditor");
		
		SplitPane container = new SplitPane();
		ObservableList<Node> containerContent = container.getItems();
		container.setOrientation(Orientation.HORIZONTAL);

		//Canvas viewPort = new Canvas(GROESSE / 2, GROESSE + 100);
		GridPane controlPane = new GridPane();
		
		ListView<Polygon> polygonListView = new ListView<>();
		//polygonListView.setColumnResizePolicy(polygonListView.CONSTRAINED_RESIZE_POLICY);
		TableColumn<Polygon, String> polygonName = new TableColumn<Polygon, String>("Polygone");
		polygonName.setCellValueFactory(new PropertyValueFactory<Polygon, String>("name"));
		//polygonListView.getColumns().add(polygonName);
		
		
		Button setzenNeuButton = new Button("Setzen/Neu");
		setzenNeuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				model.polygonBearbeitungAbschliessen();
				polygonListView.setItems(model.getPolygonListe());
			
				
			}
		});
		
		TextField consoleField = new TextField();
		
		Button eingabeButton = new Button("Eingabe");
		eingabeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});

		controlPane.add(setzenNeuButton, 0, 0);
		controlPane.add(polygonListView, 0, 1);
		controlPane.add(consoleField, 0, 2);
		controlPane.add(eingabeButton, 0, 3);
		
		view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println(event.getSceneX()+"");
				Punkt punkt = new Punkt(event.getSceneX(), event.getSceneY());
				Polygon aktuellesPolygon = model.getAktuellesPolygon();
				if(aktuellesPolygon!= null){
					aktuellesPolygon.punktHinzufuegen(punkt);
				}
			}
		});
		
		containerContent.add(view);
		containerContent.add(controlPane);
		
		Scene scene = new Scene(container, GROESSE, GROESSE + 100);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
