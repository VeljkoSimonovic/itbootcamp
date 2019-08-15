package Pozoristance;

public class Glumac extends Zaposleni{
	private String imePosla="Glumac";
	
	public Glumac(String name, Pozoriste p) {
		super(name, p);
	}

	public String imePosla() {
		return imePosla;
	}
	

}
