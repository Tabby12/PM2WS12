package aufgabenblatt3;
import java.util.Observable;
import java.util.Random;

public class Simulation extends Observable implements Runnable{
	public final Rangierbahnhof bhf;
	private Random zufall;
	private boolean runnning;
	
	public Simulation() {
		bhf = new Rangierbahnhof();
		zufall = new Random();
		runnning = true;
	}

	@Override
	public void run() {
		while(runnning){
			setChanged();
	        notifyObservers();
			Lokfuehrer lokfuehrer = new Lokfuehrer(zufall.nextBoolean(), bhf);
			System.err.println("Neuer Lokfuehrer erzeugt.");
			lokfuehrer.start();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
		}
	}
	
	/**
	 * Beendet die Simulation
	 */
	public void beenden(){
		runnning=false;
	}
	
//	public static void main(String[] args){
//		Simulation sim = new Simulation();
//		Thread simThread = new Thread(sim);
//		simThread.start();
//	}
}
