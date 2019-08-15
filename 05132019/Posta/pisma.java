package Posta;
import java.util.Scanner;
public class pisma {

	private String posaljilac;
	private String primalac;
	private boolean kraj;
	public int end;
	private int poBroj;
	private double tezina;
	private boolean prioritetno;
	private int cena;
	Scanner s= new Scanner(System.in);
	public pisma() {
		
	}
	
	public void setPismo() {
		String kraj1=s.next();
		kraj=kraj1.indexOf("kraj") !=-1? true:false;				
		if(kraj==false) {
		posaljilac=kraj1 + " " + s.next() + " ";
		primalac=s.next() + " " + s.next() + " ";
		poBroj=s.nextInt();
		tezina=s.nextDouble();
		int bool=s.nextInt();
		if(bool==1)prioritetno=true;
		else prioritetno=false;
		}
		if (kraj==true)end=1;
		
	}public int cena(int cena) {
		if(tezina<=20)cena=23;
		else if(tezina>20 && tezina<=100)cena=35;
		else if(tezina>100 && tezina<=250)cena=46;
		else if(tezina>250 && tezina<=500)cena=81;
		else if(tezina>500 && tezina<=1000)cena=92;
		else if(tezina>1000 && tezina<=2000)cena=127;
		else cena=150; //Nisam nasao u tabeli za tezinu preko 2000g, pa sam dodao 150 dinara.
		if(prioritetno==true)cena=cena+46;
		return cena;
	}
	public String toString() {
		String str;
		if(prioritetno==false) {str=posaljilac + " ->  " + primalac + " : " + 
	     poBroj + ", " + tezina + "g "  + " => " + cena(cena) + "din";}
		else {str=posaljilac + " ->  " + primalac + " : " + 
			     poBroj + ", " + tezina + "g "  + " prioritetno => " + cena(cena) + "din";}		
		return str;
	}
	public int getEnd() {		
		return end;
	}
	
    public int getZip(){
    	return poBroj;
	}   
  
    }
	
		
	
	
		
		
	
	

	
	
	
	
	
	
	

