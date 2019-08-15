package Energija;

public abstract class Namirnica extends Energent{
	private String ime;
	private static int idplus;
	private int id;
	
		public Namirnica(String i) {
			ime=i;
			idplus++;
			id=idplus;
		}

		public String getIme() {
			return ime;
		}

		public int getId() {
			return id;
		}
		public String toString() {
			String str="["+id+"] "+ ime;
			return str;
		}

		public int getIdplus() {
			return idplus;
		}
		

}
