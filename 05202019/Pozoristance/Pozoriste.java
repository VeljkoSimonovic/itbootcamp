package Pozoristance;

public class Pozoriste {
	private static int idplus;
	private int id;
	private String naziv;
	
		public Pozoriste(String ime) {
			naziv=ime;
			idplus++;
			id=idplus;
		}

		public int getId() {
			return id;
		}

		public String getNaziv() {
			return naziv;
		}
		public String toString() {
			String str=naziv + " " + id;
			return str;
		}
		public String getSkraceniNaziv() {
			String[] skr=new String[100];
			String str="";
			skr=naziv.split(" ");
			for(int i=0;i<skr.length;i++) {
				skr[i]=skr[i].toUpperCase();
				str+=skr[i].charAt(0);
			}
				
			return str;
		}

}
