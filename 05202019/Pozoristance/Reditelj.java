package Pozoristance;

public class Reditelj extends Zaposleni{
	private String imePosla="Reditelj";
		
		public Reditelj(String name, Pozoriste p) {
			super(name, p);
		}

		public String imePosla() {
			return imePosla;
		}
		
}
