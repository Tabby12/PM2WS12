package aufgabenblatt4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolygonSkripting {
	
		private final Pattern pattern;
		private Matcher matcher;

		/**
		 * Konstruktor
		 */
		public PolygonSkripting() {
			pattern = Pattern.compile("(bewege)\\s->" + "\\s(0|-?[0-9]*\\.?[0-9]*),\\s?(0|-?[0-9]*\\.?[0-9]*)");
			matcher = null;
		}
	
	public boolean istGueltigerBefehl(String befehl){
		matcher = pattern.matcher(befehl);
		return matcher.matches();
		
	}
	
	public double getX(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(3));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}
	
	public double getY(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(2));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

}
