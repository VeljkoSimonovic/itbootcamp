package SalterskaSluzba;

public class Klijent extends Osoba{
	private char usluga;
	public Klijent() {
		super('K');
		double x=Math.random();
		if(x>=0&&x<=0.33)usluga='a';
		if(x>0.33&&x<=0.66)usluga='b';
		if(x>0.66&&x<=1)usluga='c';
	}
	public String toString() {
		return getId()+" "+getVrsta()+" "+"("+usluga+")";
	}
	public char getUsluga() {
		return usluga;
	}
}
