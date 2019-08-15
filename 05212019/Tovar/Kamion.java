package Tovar;

import java.util.LinkedList;

public class Kamion {
	private String regBroj;
	private LinkedList<Tovar> tovar=new LinkedList<>();
	private double nosivost;
	private double teret=0;
	
		public Kamion(String s, double d) {
			regBroj=s;
			nosivost=d;
		}
	
		public boolean stavi(Tovar t) {
			boolean uspeh;
			teret+=t.tezina();
			if(teret<=nosivost) {tovar.add(t);uspeh=true;}
			else {System.out.println("Maksimalna nosivost prekoracena.");teret-=t.tezina();uspeh=false;}
			return uspeh;
		}
		public void skini() {
			if(tovar.size()>0) {tovar.remove(tovar.size()-1);teret-=tovar.get(tovar.size()-1).tezina();}
			else System.out.println("Kamion je prazan.");
		}
		public String toString() {
			String str="";
			for (int i = 0; i < tovar.size(); i++) {
				str+="\n" + tovar.get(i);
			}
			return regBroj + "(" + teret + "/" + nosivost + ")" + str;
		}
}
