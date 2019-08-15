package Pozoristance;

import java.util.LinkedList;

public class Predstava {
	private String naziv;
	private Pozoriste pozoriste;
	private LinkedList<Zaposleni> ekipa=new LinkedList<Zaposleni>();
	
		public Predstava(String ime, Pozoriste p, Reditelj r) {
			naziv=ime;
			pozoriste=p;
			Pozoriste provera1=r.getPozoriste();
			if(provera1!=pozoriste) {System.out.println("Nije zaposlen u ovom pozoristu");}
			else ekipa.add(r);
		}

		public String getNaziv() {
			return naziv;
		}

		public Pozoriste getPozoriste() {
			return pozoriste;
		}
//--------------------------------------------------------------------------------------------------------------//		
	public boolean dodajReditelja(Reditelj r) {
		boolean b = false;
		for (int i = 0; i < ekipa.size(); i++) {
			Pozoriste provera1 = r.getPozoriste();
			if (provera1 != pozoriste) {
				System.out.println("Nije zaposlen u ovom pozoristu");
				b = true;  //Ova metoda je potpuno opciona i moze biti zanemarena, obzirom da ionako ne postoji
				break;     //u zadatku metoda za dodavanje reditelja, a u konstruktoru dodajemo samo jednog.
			}              //Ostavio sam je radi provere, i da objasnim logiku koju sam koristio
			String provera = ekipa.get(i).getSkrImePosla();
			if (provera.contains("R")) {
				System.out.println("Samo jedan reditelj");
				b = true;
				break;
			} else
				ekipa.add(r);
		}
		return b;
	}
	//--------------------------------------------------------------------------------------------------------------//		
	public boolean dodaj(Kostimograf k) {
		boolean b = false;
		int x = 1;//Brojac za proveru broja kostimografa
		for (int i = 0; i < ekipa.size(); i++) {
			String provera = ekipa.get(i).getSkrImePosla();
			if (provera.contains("K"))
				x++;
		}
		while (b == false) {
			Pozoriste provera1 = k.getPozoriste();
			if (provera1 != pozoriste) {
				System.out.println("Nije zaposlen u ovom pozoristu");
				b = true;
				break;
			}
			if (x > 2) {
					System.out.println("Dva kostimografa su dovoljna");
					b = true;
					break;
				} 
             else {ekipa.add(k);break;}
		}
		return b;
	}
	public boolean dodaj(Glumac g) {
		boolean b = false;
		 while (b == false) {
			Pozoriste provera = g.getPozoriste();
			if (provera != pozoriste) {
				System.out.println("Nije zaposlen u ovom pozoristu");
				b = true;
				break;
			}
            else {ekipa.add(g);break;}
		}
		return b;
	}
	public String toString() {
		String str1="";
				for(int i=0;i<ekipa.size();i++) {
					str1+="\n\t" + ekipa.get(i);
				}
		String str=naziv + ": " + str1;
		return str;
	}
}			
	
	
	
	
	
	
	
	
	
	


