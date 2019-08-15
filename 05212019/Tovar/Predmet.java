package Tovar;

public class Predmet extends Tovar {
	private String vrsta;
	private double tezina;
	
		public Predmet(String tipe, double masa) {
			vrsta=tipe;
			tezina=masa;
		}
		public String vrsta() {
			return vrsta;
		}
		public double tezina() {
			return tezina;
		}

		
}
