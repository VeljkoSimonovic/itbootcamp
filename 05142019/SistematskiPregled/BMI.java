package SistematskiPregled;
import java.util.Scanner;
public class BMI {
	Scanner s= new Scanner(System.in);
	public final int id;
	public final String kategorija;
	public final String skracenica;
	public final double vrednost;
	
	
	public BMI(double vis, double tez) {
		vrednost=tez/(vis*vis);	
		if(vrednost<18.5) {kategorija="Neuhranjenost"; skracenica="N"; id=0;}
		else if(vrednost>=18.5 && vrednost<24.9) {kategorija="Idealna masa"; skracenica="IM"; id=1;}
		else if(vrednost>=24.9 && vrednost<=29.9) {kategorija="Prekomerna masa"; skracenica="PM";id=2;}
		else if(vrednost>29.9) {kategorija="Gojaznost"; skracenica="G";id=3;}
		else {kategorija=" ";skracenica=" ";id=4;}
		
	}
	public String toString() {	
		String str=Math.round(vrednost*100.00)/100.00 + " => " + kategorija;
		return str;
	}
	public int getVrednost() {
		int x;
		if(vrednost<18.5)x=0;
		else if(vrednost>=18.5 && vrednost<24.9)x=1;
		else if(vrednost>=24.9 && vrednost<=29.9)x=2;
		else if(vrednost>29.9)x=3;
		else x=4;
		return x;
	}

}
