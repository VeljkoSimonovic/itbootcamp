package SalterskaSluzba;

public class Razvodnik extends Radnik{

	public Razvodnik() {
		super('R');
	}

	public boolean aktivnost(CustomList cl, CustomList cl1) {
		if(cl.duzina()==0)return false;
		setAdresa(cl.uzmi(0));
		cl1.dodaj(cl.uzmi(0));
		cl.ukloni();
		return true;
	}

}
