package aufgabenblatt3;

public class Rangierbahnhof {
	
	private Zug[] zuege;
	
	public Rangierbahnhof(int anzGleise) {
		zuege = new Zug[anzGleise];
	}
	
	public synchronized void einfahren(Zug zug,int gleisNr){
		if(zuege[gleisNr]==null){
			zuege[gleisNr]= zug;
		}
	
	}
	
	public synchronized void ausfahren(int gleisNr){
		if(zuege[gleisNr] !=null){
			zuege[gleisNr]= null;
			
		}
	
	}

}
