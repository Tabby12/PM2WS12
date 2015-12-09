

package aufgabenblatt3;

import java.util.Random;

/**
 * Repraesentiert Lokfuehrer, eine von zwei Aufgaben wird gewaehlt
 * @author lennarthartmann
 *
 */


public class Lokfuehrer extends Thread{
	//legt fest, ob ein Zug ein-/ oder ausgefahren wird
	public final boolean FAEHRT_EIN;
	public final Rangierbahnhof BHF;
	public final int GLEIS_NR;


	public Lokfuehrer(boolean faehrtEin, Rangierbahnhof bhf){
		this.FAEHRT_EIN=faehrtEin;
		this.BHF=bhf;
		Random zufall = new Random();
		GLEIS_NR = zufall.nextInt(Rangierbahnhof.ANZ_GLEISE);
	}
	
	@Override
	public void run(){
		if(FAEHRT_EIN){
			zugEinfahren();
		}else{
			zugAusfahren();
		}
	}
	
	/**
	 * Versuche einen neuen Zug einfahren zu lassen
	 */
	private void zugEinfahren(){
		System.err.println("Versucht Zug auf Gleis "+GLEIS_NR+" aunzufahren.");
		try{
			BHF.einfahren(GLEIS_NR, new Zug());
			}catch(IllegalAccessException e){
				System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Versuche einen Zug vom Gleis auszufahren
	 */
	private void zugAusfahren(){
		System.err.println("Versucht Zug von Gleis "+GLEIS_NR+" auszufahren.");
		try{
			BHF.ausfahren(GLEIS_NR);
			}catch(IllegalAccessException e){
				System.err.println(e.getMessage());
			}
	}
	
	@Override
	public String toString(){
		return this.getName()+" faehrt Zug ein: "+FAEHRT_EIN+"  Auf Gleis Nr.: "+GLEIS_NR+"  Bahnhof:"+BHF;
	}
	
	public static void main(String[] args){
		Random zufall =  new Random();
		Rangierbahnhof bhf = new Rangierbahnhof();
		for(int i=0; i<16; i++){
			Lokfuehrer lf = new Lokfuehrer(zufall.nextBoolean(), bhf);
			System.err.println(lf.toString());
		}
	}
}

//public class Lokfuehrer extends Thread{
//	
//	public enum Aufgabe {AUSFAHREN, EINFAHREN}
//	
//	private Aufgabe aufgabe;
//	
//	private Rangierbahnhof rangierbahnhof;
//	
//	public Lokfuehrer(Aufgabe aufgabe, Rangierbahnhof rangierbahnhof) {
//		this.aufgabe = aufgabe;
//		this.rangierbahnhof = rangierbahnhof;
//	}
//
//	@Override
//	public void run() {
//		
//		if(aufgabe.equals(Aufgabe.EINFAHREN)){
//			rangierbahnhof.einfahren(null, 0);
//			System.out.println();
//		}
//		else if (aufgabe.equals(Aufgabe.AUSFAHREN)){
//			rangierbahnhof.ausfahren(0);
//			System.out.println();
//			
//		}
//		
//	}
//}
