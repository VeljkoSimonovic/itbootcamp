package Energija;

public class Meni {
	private Namirnica[] meni;
	private int brNam;
	private int x=0; //brojac koji uslovljava da se ne unosi vise namirnica nego sto ima polja u listi
	
		 
		public Meni(int kapacitet) {
			brNam=kapacitet;
			meni=new Namirnica[brNam];
		}
		public double energVr() {
			double enV=0;
			for (int i = 0; i < x; i++) {
				enV+=meni[i].energVr();
			}
			return enV;
		}	

	public boolean dodaj(Namirnica n) {
		boolean uspeh = false;
		if (n.getId() <= brNam) {
			meni[n.getId() - 1] = n;
			uspeh = true;
			x++;
			return uspeh;
		} else
			return uspeh;

	}
		public String ispisNiza() {
			String s="";
			for (int i = 0; i < x; i++) {
				s+="\n" + meni[i];
			}
			return s;
		}
		public String toString() {
			return "Meni " + "(" + Math.round(energVr() * 100) / 100.0 + "kJ):" + ispisNiza();
		}
			
		
}
