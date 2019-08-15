package SistematskiPregled;
import java.util.Scanner;
public class Osoba {
	Scanner s= new Scanner(System.in);
	private String ime;
	private double visina;
	private double tezina;
	
	public Osoba(String name, String prezime, double vis, double tez) {
		ime=name+prezime;
		visina=vis;
		tezina=tez;
		}
		
	public String toString() {
		String str=ime + " " + " (" + visina + "m, " + tezina +"kg) :";
		return str;
	}

}
