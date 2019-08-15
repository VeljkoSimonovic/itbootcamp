package Energija;

public class Pice extends Namirnica{
	private double kolicina;
	private double enVr;
	
		public Pice(String i, double kol, double enV) {
			super(i);
			kolicina=kol;
			enVr=enV;
			
		}
		public double energVr() {
			double enV;
			enV=kolicina*enVr;
			return enV;
		}
		public double getKolicina() {
			return kolicina;
		}
		public String toString() {
			String str="["+getId()+"] "+ getIme() + "(" + kolicina + "l, " + Math.round(energVr() * 10) / 10.0 + "kJ)" ;
			return str;
		}

}
