package Pozoristance;

public class Kostimograf extends Zaposleni{
	private String imePosla="Kostimograf";
	
	public Kostimograf(String name, Pozoriste p) {
		super(name, p);
	}

	public String imePosla() {
		return imePosla;
	}
	
}
