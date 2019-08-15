package SalterskaSluzba;

public class CustomList {
	private Klijent[] k;
	public CustomList() {
		k=new Klijent[0];
	}
	public void dodaj(Klijent k1) {
		Klijent[] pomk=new Klijent[k.length+1];
		for (int i = 0; i < pomk.length-1; i++) {
			pomk[i]=k[i];
		}
		pomk[pomk.length-1]=k1;
		k=new Klijent[pomk.length];
		for (int i = 0; i < k.length; i++) {
			k[i]=pomk[i];
		}
	}
	public boolean ukloni() {//obzirom da nije naznaceno da se bira ko se uklanja pretpostavio sam da je prvi klijent u redu na salteru
		if(k.length==0) {System.out.println("Lista je prazna");return false;}
		Klijent[] pomK=new Klijent[k.length-1];
		if(k.length==1) k=new Klijent[0];
		else {
			for (int i = 0; i < pomK.length; i++) {
				pomK[i]=k[i+1];
			}
			k=new Klijent[pomK.length];
			for (int i = 0; i < k.length; i++) {
				k[i]=pomK[i];
			}
		}
		return true;
	}
	public Klijent uzmi(int x) {
		if(k.length==0) {System.out.println("Lista je prazna");return null;}
		else {
			return k[x];
		}
	}
	public int duzina() {
		return k.length;
	}
	public String toString() {
		String str="";
		if(k.length==0)return "Lista je prazna";
		for (int i = 0; i < k.length; i++) {
			str+=("Pozicija " + i + " "+"["+k[i]+"]\n");
		}
		return str;
	}
}
