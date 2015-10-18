package aufgabenblatt1;

public class ListenTool {
  public static <T> boolean istErstesElementZahl(ArrayListe<T> liste){
	if(liste.getAnzahlElemente()>0){
	  return liste.get(0) instanceof Number;
	}
	return false;
  }
  
  public static int bildeSumme(ArrayListe<Integer> liste){
	int summe = 0;
	int anzElemente = liste.getAnzahlElemente();
	if(anzElemente > 0){
	  for(int i=0; i<anzElemente; i++){
		summe += (Integer)liste.get(i);
	  }
	}
	return summe;
  }
  
  public static void main(String[] args){
	ArrayListe<Integer> intL = new ArrayListe<Integer>();
	intL.hinzufuegen(3);
	intL.hinzufuegen(7);
	intL.hinzufuegen(5);
	intL.hinzufuegen(9);
	System.out.println("Summe: "+ListenTool.bildeSumme(intL));
	System.out.println("intL: Erstes Element Zahl? "+ListenTool.istErstesElementZahl(intL));
	ArrayListe<Integer> intL2 = new ArrayListe<Integer>();
	System.out.println("intL2: Erstes Element Zahl? "+ListenTool.istErstesElementZahl(intL2));
  }
}

