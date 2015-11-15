package aufgabenblatt2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringverarbeitungTest {

	private String[] strArray={"Eingabe","Äußeres",null,"Straßen-Feger"," ein Haus"};
	private List<String> strList = Arrays.asList(strArray);

	private String[] vergleichsArray = {"EINGABE","AEUSSERE","STRASSEN","EIN HAUS"};
	
	@Test
	public void verarbeiteTest() {
		List<String> bearbeiteteListe = Stringverarbeitung.verarbeite(strList);
		
		for(int i=0; i<vergleichsArray.length; i++){
			assertEquals("Mindestens ein String unterscheidet sich von der Erwartung", vergleichsArray[i], bearbeiteteListe.get(i));
		}
	}
}