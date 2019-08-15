package Muzika;
public class Numera {
	private String naziv;
	private String izvodjac;
	private String trajanje;
		
		public Numera(String naz, String izv, String traj) {
			naziv=naz;
			izvodjac=izv;
			trajanje=traj;
		}

		public String getNaziv() {
			return naziv;
		}
		public String getIzvodjac() {
			return izvodjac;
		}
		public String getTrajanje() {
			return trajanje;
		}
		public String toString() {
			String str;
			str=izvodjac + " - " + naziv + ": " + trajanje;
			return str;
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
