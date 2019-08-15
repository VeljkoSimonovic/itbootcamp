package SalterskaSluzba;

public abstract class Osoba {
	private static int idplus;
	private int id;
	private char vrsta;
	public Osoba(char c) {
		vrsta=c;
		idplus++;
		id=idplus;
	}
	public int getId() {
		return id;
	}
	public char getVrsta() {
		return vrsta;
	}
	public String toString() {
		return id+" "+vrsta;
	}
}
