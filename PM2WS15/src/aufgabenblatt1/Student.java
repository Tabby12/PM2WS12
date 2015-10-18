package aufgabenblatt1;
import java.util.ArrayList;

public class Student implements Comparable<Student>{
  private final String vorname;
  private final String nachname;
  private final int matrikelnummer;
  private ArrayList<Pruefungsleistung> pruefungsleistungen;

  public Student(String vorname, String nachname, int matrikelnummer){
	this.vorname=vorname;
	this.nachname=nachname;
	this.matrikelnummer=matrikelnummer;
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

public String getVorname() {
	return vorname;
}

//public void setVorname(String vorname) {
//	this.vorname = vorname;
//}
//
public String getNachname() {
	return nachname;
}
//
//public void setNachname(String nachname) {
//	this.nachname = nachname;
//}
//
public int getMatrikelnummer() {
	return matrikelnummer;
}
//
//public void setMatrikelnummer(int matrikelnummer) {
//	this.matrikelnummer = matrikelnummer;
//}

public ArrayList<Pruefungsleistung> getPruefungsleistungen() {
	return pruefungsleistungen;
}

public void setPruefungsleistungen(
		ArrayList<Pruefungsleistung> pruefungsleistungen) {
	this.pruefungsleistungen = pruefungsleistungen;
}

}
