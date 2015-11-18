package aufgabenblatt3;

public class Lokfuehrer extends Thread{
	
	public enum Aufgabe {AUSFAHREN, EINFAHREN}
	
	private Aufgabe aufgabe;
	
	private Rangierbahnhof rangierbahnhof;
	
	public Lokfuehrer(Aufgabe aufgabe, Rangierbahnhof rangierbahnhof) {
		this.aufgabe = aufgabe;
		this.rangierbahnhof = rangierbahnhof;
	}

	@Override
	public void run() {
		
		if(aufgabe.equals(Aufgabe.EINFAHREN)){
			rangierbahnhof.einfahren(null, 0);
			System.out.println();
		}
		else if (aufgabe.equals(Aufgabe.AUSFAHREN)){
			rangierbahnhof.ausfahren(0);
			System.out.println();
			
		}
		
	}
	
	

}
