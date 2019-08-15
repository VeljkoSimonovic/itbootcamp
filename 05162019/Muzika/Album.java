package Muzika;
import java.util.LinkedList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Album {
		private String naziv;
		private String izvodjac;
		private Date datum;
		private LinkedList<Numera> listaPesama=new LinkedList<Numera>();
		Scanner s= new Scanner(System.in);
		
		public Album(String naz, String izv, Date dat) {
			naziv=naz;
			izvodjac=izv;
			datum=dat;
		}
		public String getNaziv() {
			return naziv;
		}
		public String getIzvodjac() {
			return izvodjac;
		}
		public Date getDatum() {
			return datum;
		
		}
		public void dodaj(Numera x) {			
			listaPesama.add(x);
		}
		
		public void dodaj(String name, String trajanje) {		
			listaPesama.add(new Numera(name, izvodjac, trajanje));		
		}
		
		public String toString() {
			String str1=" ";
			for(int i=0; i<listaPesama.size(); i++) {
				str1+=("\n\t"+listaPesama.get(i).toString() +"\n");							
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");  //ne znam sta je u pitanju ali [date] ne daje unetu godinu
			String strDate = dateFormat.format(datum);  
			String ukupnoTrajanje=getTrajanje();
			String str=izvodjac + " - " + naziv + "(" +strDate+ ") :[\n" + str1 + "\n]: " + ukupnoTrajanje + "\n";	
			return str;
		}
		public Numera getNumera(int index) {
			System.out.println("Unesite index: ");
			index=s.nextInt();
			Numera n=listaPesama.get(index-1);
			return n;
		}
		public Numera getNumera1(String ime) {
			System.out.println("Unesite ime: ");
			ime=s.nextLine();
			Numera n1=new Numera(" ", " ", "");
			for(int i=0;i<listaPesama.size();i++) {
			if(listaPesama.get(i).getNaziv().contains(ime))n1=listaPesama.get(i);
		}
	      return n1;
		}	
		public String getTrajanje() {
			String[] ukpVreme=new String[200];
			String time="";
			int minut=0;
			int sekund=0;
			for(int i=0;i<listaPesama.size();i++) {
					time+=listaPesama.get(i).getTrajanje()+":";							
			}
			ukpVreme = time.split(":");
			time="";
			for(int i=0;i<ukpVreme.length;i=i+2) {
			minut+=Integer.parseInt(ukpVreme[i]);
			sekund+=Integer.parseInt(ukpVreme[i+1]);
			}
			time=(minut=minut+sekund/60) + ":" + (sekund=sekund%60);			
			return time;
		}
}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
