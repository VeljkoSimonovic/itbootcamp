package Tovar;

public abstract class Tovar {
	public abstract String vrsta();
	public abstract double tezina();
	public String toString() {
		String str= vrsta() + " (" + tezina() + ")";
		return str;
	}
}
