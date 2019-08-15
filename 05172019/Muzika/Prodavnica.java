package Muzika;

import java.util.LinkedList;
public class Prodavnica {
	private String ime;
	private String lokacija;
	private LinkedList<Artikal> inventar=new LinkedList<Artikal>();
	//------------------------------------------------------------------------------------//
		public Prodavnica(String i, String l) {
		ime=i;
		lokacija=l;
	}
		public void dodaj(Artikal a) {
			inventar.add(a);
			
		}
		public String getIme() {
			return ime;
		}
		public String getLokacija() {
			return lokacija;
		}
		public LinkedList<Artikal> pretrazi(String tekst) {
			String ime=tekst.toLowerCase();
			LinkedList<Artikal> pretraga=new LinkedList<Artikal>();
			for(int i=0;i<inventar.size();i++) {
			if(inventar.get(i).ime().toLowerCase().contains(ime))pretraga.add(inventar.get(i));
		   }
			return pretraga;
		}
		public String toString() {
			String str1="";
			for(int i=0; i<inventar.size(); i++) {
				str1+=("\n\t"+inventar.get(i).toString() +"\n");							
			}
			String str=ime + ": " + lokacija + " [" + str1;
			return str;
		}

}
