package aufgabenblatt1;


public class Pruefungsleistung {
	private String modulname;
	  private int note;
	  
	  public Pruefungsleistung(String modulname, int note){
		this.modulname = modulname;
		this.note=note;	
	  }
  public String getModulname() {
		return modulname;
	}

	public void setModulname(String modulname) {
		this.modulname = modulname;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
}
