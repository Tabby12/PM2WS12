package aufgabenblatt3;

import java.util.Observable;

import aufgabenblatt3.Zug;

public class Rangierbahnhof extends Observable{
	public static final int ANZ_GLEISE = 3;
	Zug[] gleise = new Zug[ANZ_GLEISE];
	
	/**
	 * Laesst einen Zug einfahren
	 * @param gleisNr	die Nr des zu belegenden Gleises
	 * @param zug		der einfahrende Zug
	 * @throws IllegalAccessException 
	 */
	public synchronized void einfahren(int gleisNr, Zug zug) throws IllegalAccessException{
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		//solange Gleis besetzt ist
		while(gleise[gleisNr]!=null){
			System.err.println("Gleis besetzt");			
			try{
				this.wait();
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				return;
			}
		}
		//Zug auf Gleis abstellen
		gleise[gleisNr]=zug;
		System.err.println("Zug auf Gleis "+gleisNr+" eingefahren");	
		try{
			Thread.sleep(500);		
		}catch(InterruptedException e){
		}
		this.notifyAll();
		//neu
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Laesst einen Zug ausfahren
	 * @param gleisNr	die Nummer des Gleises, von welchem der Zug abfahren soll 
	 * @return			der ausfahrende Zug, null falls nicht Gleis nicht belegt
	 * @throws IllegalAccessException 
	 */
	public synchronized Zug ausfahren(int gleisNr) throws IllegalAccessException{
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		//solange kein Zug auf dem Gleis
		while(gleise[gleisNr]==null){
			System.err.println("Kein Zug auf diesem Gleis.");
			try{
				this.wait();
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				return null;
			}
		}
		//Zug auswaehlen und vom Gleis entfernen
		Zug zug = gleise[gleisNr];
		gleise[gleisNr]=null;
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
		}
		
		System.err.println("Zug auf Gleis"+gleisNr+" faehrt aus.");
		this.notifyAll();
		//neu
		setChanged();
		notifyObservers();
		//end neu
		return zug;
	}
	
	/**
	 * Pueft, ob Gleis belegt ist
	 * @param gleisNr	die Nummer des zu pruefenden Gleises
	 * @return			belegt, oder nicht belegt
	 * @throws IllegalAccessException 
	 */
	public boolean istBelegt(int gleisNr) throws IllegalAccessException{
		
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		if (gleise[gleisNr]!=null){
			return true;
			}
		return false;
	}
}

//public class Rangierbahnhof {
//	
//	private Zug[] zuege;
//	
//	public Rangierbahnhof(int anzGleise) {
//		zuege = new Zug[anzGleise];
//	}
//	
//	public synchronized void einfahren(Zug zug,int gleisNr){
//		if(zuege[gleisNr]==null){
//			zuege[gleisNr]= zug;
//		}
//	
//	}
//	
//	public synchronized void ausfahren(int gleisNr){
//		if(zuege[gleisNr] !=null){
//			zuege[gleisNr]= null;
//			
//		}
//	
//	}
//}
