package SalterskaSluzba;

public abstract class Radnik extends Osoba{
    private Klijent adresa;
	
	public Radnik(char c) {
		super(c);
	}
	public abstract boolean aktivnost(CustomList cl, CustomList cl1);//dve reference su stavljene zato sto razvodnik barata sa dve liste u isto vreme, tako da ce portiru i sluzbeniku biti prosledjen null na drugom mestu
	public void setAdresa(Klijent adresa) {
		this.adresa = adresa;
	}
	public String toString() {
		return "["+getId()+" "+getVrsta()+" "+adresa+"]";
	}
}
