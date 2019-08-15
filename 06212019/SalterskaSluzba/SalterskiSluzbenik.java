package SalterskaSluzba;

public class SalterskiSluzbenik extends Radnik{

	public SalterskiSluzbenik() {
		super('S');
	}

	public boolean aktivnost(CustomList cl, CustomList cl1) {
		if(cl.duzina()==0)return false;
		setAdresa(cl.uzmi(0));
		cl.ukloni();
		return true;
	}

}
