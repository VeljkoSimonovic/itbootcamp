package Tovar;

import java.util.LinkedList;

public class Paket extends Tovar {
	private LinkedList<Tovar> tovar=new LinkedList<>();
	 
	public String vrsta() {
		 String str="";
		 for(int i=0;i<tovar.size();i++) {
			 if(i>0)str+=",";
			 if(i==0)str+="[";
			 str+=tovar.get(i).vrsta();
			 if(i==tovar.size()-1)str+="]";
		 }
		 return "paket" + " " + str;
	 }
	 public double tezina() {
		 int ukupnaTezina=0;
		 for(int i=0;i<tovar.size();i++) {
			 ukupnaTezina+=tovar.get(i).tezina();
		 }
		 return ukupnaTezina;
	 }
	 public void dodaj(Tovar p) {
		 tovar.add(p);
		  
	 }
	
}
