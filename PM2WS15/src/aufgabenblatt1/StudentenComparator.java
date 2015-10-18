package aufgabenblatt1;

import java.util.Comparator;

/**
 * 
 * @author Lennart
 *
 */
public class StudentenComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
	  int rueckgabe = 0;
	  rueckgabe = student1.getNachname().compareTo(student2.getNachname());
	  if(rueckgabe == 0){
		rueckgabe = student1.getVorname().compareTo(student2.getVorname());  
	  }
	  return rueckgabe;
  }
}
