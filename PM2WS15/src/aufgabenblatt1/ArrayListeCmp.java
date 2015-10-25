package aufgabenblatt1;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.4
 * 
 */

/**
 * Diese Klasse repräsentiert .
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class ArrayListeCmp<T extends Comparable<T>> {
	
  /**
   * Die Anzahl der Elemente.
   */
  public int anzahlElemente;
  
  /**
   * Eine Liste der Elemente.
   */
  private Object[] liste;
  
  /**
   * Konstruktor.
   */
  public ArrayListeCmp(){
    anzahlElemente = 0;  
    liste = new Object[0];	  
  }
  
  /**
   * 
   * @param element
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
   * 
   * @param index
   * @return
   */
  @SuppressWarnings("unchecked")
  public T get(int index){
    return (T)liste[index];
  }
	 
  /**
   * 
   * @param element
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
	  entferneElementAnIndex(gesuchterIndex);
	}
  }

  /**
   * 
   * @param i
   */
  public void entferneElementAnIndex(int i){
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
   * 
   * @return
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
   * 
   * @return
   */
  @SuppressWarnings("unchecked")
  public T getKleinstesElement(){
    T kleinstesElement = null;
	if(anzahlElemente > 0){
	  kleinstesElement = (T)liste[0];
	  for(Object element : liste){
	    if(((T)element).compareTo((T) kleinstesElement) < 0){
		  kleinstesElement = (T)element;
		}
	  }
	}
	return kleinstesElement;
  }
	  
//  public static void main(String[] args){
//	ArrayListeCmp<String> liste = new ArrayListeCmp<String>();
//	liste.hinzufuegen("Hallo");
//	liste.hinzufuegen("Welt");
//	liste.hinzufuegen("Dummies");
//	System.out.println("anz. Elemente: "+liste.getAnzahlElemente());
//	System.out.println(liste.toString());
//	System.out.println("Kleinstes Element: "+liste.getKleinstesElement());
//	
//	ArrayListeCmp<Integer> intList = new ArrayListeCmp<Integer>();
//	intList.hinzufuegen(new Integer(3));
//	intList.hinzufuegen(new Integer(1));
//	intList.hinzufuegen(new Integer(2));
//	System.out.println(intList.toString());
//	System.out.println("Kleinstes Element: "+intList.getKleinstesElement());
//	intList.entfernen(2);
//	System.out.println(intList.toString());
//  }
}
