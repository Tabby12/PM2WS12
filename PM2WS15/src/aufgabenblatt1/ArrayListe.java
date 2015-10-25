package aufgabenblatt1;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.4
 * 
 */


/**
 * Diese Klasse repräsentiert eine ArrayList.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class ArrayListe<T> {
  
/**
  * Die Anzahl der Elemente.
  */	
  private int anzahlElemente;
 /**
  * Eine Liste der Elemente.
  */
  private Object[] liste;
  
 /**
  * Konstruktor.
  */
  public ArrayListe(){
	anzahlElemente = 0;  
    liste = new Object[0];	  
  }
  
 /**
  * Fuegt ein Element zu der Liste hinzu.
  * 
  * @param element das element das hinzugefuegt wird.
  */
  public void hinzufuegen(T element){
	anzahlElemente += 1;  
	Object[] kopie = new Object[anzahlElemente];
	for(int i=0; i<anzahlElemente-1; i++){
	  kopie[i] = liste[i];
	}
	kopie[anzahlElemente-1] = element;
	liste = kopie;
  }
  
 /**
  * .
  */
  public Object get(int index){
	return liste[index];
  }
  
 /**
  * Entfernt das uebergebene Element aus der Liste.
  * 
  * @param element das uebergebene Element.
  */
  public void entfernen(T element){
	int gesuchterIndex = -1;
	int i = 0;
	while(i<anzahlElemente){	
	  if(liste[i].equals(element)){
		gesuchterIndex = i;
		break;
	  }
	  i++;
	}
	if(gesuchterIndex != -1){
	  entferneElementAtIndex(gesuchterIndex);
	}
  }
  
 /**
  * .
  */
  public void entferneElementAtIndex(int i){
	Object[] kopie = new Object[anzahlElemente-1];
	for(int k=0; k<i;k++){
	  kopie[k]=liste[k];
	}
	for(int k=i; k<anzahlElemente-1; k++){
	  kopie[k] = liste[k+1];
	}
	liste = kopie;	  
	anzahlElemente--;
  }
  
 /**
  * .
  */
  public int getAnzahlElemente(){
    return anzahlElemente;
  }
  
  @Override
  public String toString(){
	String string = "";  
	if(anzahlElemente > 0){
	  for(int i=0; i<anzahlElemente; i++){
	    string += liste[i].toString()+" ";
	  }
	}
	return string;
  }
  
 /**
  * .
  */
  public Object getKleinstesElement(){
	Object kleinstesElement = null;
	  if(anzahlElemente > 0){
		kleinstesElement = liste[0];
		for(Object element : liste){
		  if(element.toString().compareTo(kleinstesElement.toString()) < 0){
			kleinstesElement = element;
		  }
		}
	  }
	return kleinstesElement;
  }
  
//  public static void main(String[] args){
//	ArrayListe<String> stringList = new ArrayListe<String>();
//    System.out.println("Abzahl der Elemente: "+stringList.anzahlElemente);
//    stringList.hinzufuegen("Hallo");
//    stringList.hinzufuegen("ihr");
//    stringList.hinzufuegen("Leute");
//    stringList.hinzufuegen("Aber");
//    System.out.println("Abzahl der Elemente: "+stringList.anzahlElemente);
//    //stringList.entferneElementAnIndex(0);
//    System.out.println("Abzahl der Elemente: "+stringList.anzahlElemente);
//    System.out.println("Kleinstes Element: "+stringList.getKleinstesElement());
//    stringList.entfernen("ihr");
//    System.out.println(stringList.toString());
//  }
}
