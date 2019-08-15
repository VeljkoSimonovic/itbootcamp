package SalterskaSluzba;

public class Portir extends Radnik{
	public Portir() {
		super('P');
	}
	public boolean aktivnost(CustomList cl, CustomList cl1) {
		Klijent k=new Klijent();
		setAdresa(k);
		cl.dodaj(k);
		return true;
	}
	

}
