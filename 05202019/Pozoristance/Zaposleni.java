package Pozoristance;

public abstract class Zaposleni {
	private String ime;
	private Pozoriste pozoriste;
	
		public Zaposleni(String name, Pozoriste p) {
			ime=name;
			pozoriste=p;			
		}
		public abstract String imePosla();
		
		public String getIme() {
			return ime;
		}
		public Pozoriste getPozoriste() {
			return pozoriste;
		} 
		public String getSkrImePosla() { 
			String str="";
			str+=imePosla().charAt(0);
			return str.toUpperCase();
		}
		public String toString() {
			String str=ime + " (" + imePosla() + ", " + getPozoriste().getSkraceniNaziv() + ")";
			return str;
		}
		

}
