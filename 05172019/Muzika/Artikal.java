package Muzika;

public abstract class Artikal {
		private static int id;
		private int idplus;
		private double cena;
		private int kolicina;
		
		public Artikal(double cen, int kol) {
			cena=cen;
			kolicina=kol;
			id++;
			idplus=id;
		}
		public boolean kupi() {
			boolean kupi;
			if(getKolicina()!=0) {
			 kupi=true;
			 kolicinaMinus();}
			else kupi=false;
			
			return kupi;
		}
		public abstract String ime();
		public double getCena() {
			return cena;
		}
		public int getId() {
			return id;
		}
		public int getKolicina() {
			return kolicina;
		}
		public String toString() {
			String str="#" + idplus + ":" + ime() + " - " + cena + " [kol: " + kolicina + "]";
			return str;
		}
		public void kolicinaMinus() {
			kolicina--;
		}
		
}
