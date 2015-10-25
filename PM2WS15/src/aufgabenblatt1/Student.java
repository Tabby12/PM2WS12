package aufgabenblatt1;
import java.util.ArrayList;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 * 
 */


/**
 * Diese Klasse repräsentiert einen Studenten.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class Student implements Comparable<Student>{

 /**
  * Der Vorname des Studenten.
  */		
  private final String vorname;
  
 /**
  * Der Nachname des Studenten.
  */	 
  private final String nachname;
  
 /**
  * Die Matrikelnummer des Studenten.
  */	
  private final int matrikelnummer;
  
 /**
  * Eine Liste der Pruefungsleistungen des Studenten.
  */	
  private ArrayList<Pruefungsleistung> pruefungsleistungen;

 /**
  * Im Konstruktor werden die Objektvariablen initialisiert.
  * 
  * @param vorname
  *            Initialisierungswert fuer den Vornamen.
  * 
  * @param nachname
  *            Initalisierungswert fuer den Nachnamen.
  * 
  * @param matrikelnummer
  *            Initialisierungswert fuer die Matrikelnummer.
  * 
  */	
  public Student(String vorname, String nachname, int matrikelnummer){
	this.vorname=vorname;
	this.nachname=nachname;
	this.matrikelnummer=matrikelnummer;
  }

 /**
  * Getter & Setter.
  */
  public String getVorname() {
	  return vorname;
  }
  
  public String getNachname() {
	  return nachname;
  }
  
  public int getMatrikelnummer() {
	  return matrikelnummer;
  }
  
  
  public ArrayList<Pruefungsleistung> getPruefungsleistungen() {
	  return pruefungsleistungen;
  }
  
  public void setPruefungsleistungen(
		  ArrayList<Pruefungsleistung> pruefungsleistungen) {
	  this.pruefungsleistungen = pruefungsleistungen;
  }
  
  @Override
  public int compareTo(Student student) {
	  int rueckgabe=0;
	  if (matrikelnummer<student.matrikelnummer){
	   	rueckgabe=-1;
	  }else if(matrikelnummer>student.matrikelnummer){
		rueckgabe=1;
	  }
	  return rueckgabe;
    }


}
