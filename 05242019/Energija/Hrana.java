package Energija;

public class Hrana extends Namirnica {
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugHidrati;

		public Hrana(String i, double t, double b, double m, double u) {
			super(i);
			//if((b/100)*t+(m/100)*t+(u/100)*t>tezina) 
			if(b+m+u<=100) {
				tezina=t;
				belancevine=b;
				masti=m;	
				ugHidrati=u;
			}
			else System.out.println("Greska u unosu.");
			
		}

		public double getTezina() {
			return tezina;
		}

		public double getBelUgram() {
			return (belancevine/100)*tezina;
		}

		public double getMastiUgram() {
			return (masti/100)*tezina;
		}

		public double getUHuGram() {
			return (ugHidrati/100)*tezina;
		}

		public double energVr() {
			double enVr;
			enVr=(getBelUgram()*16.7)+(getMastiUgram()*37.6)+(getUHuGram()*17.2);			
			return enVr;
		}
		public String toString() {
			String str="["+getId()+"] "+ getIme() + "(" + tezina + "g, " + Math.round(energVr() * 10) / 10.0 + "kJ)" ;
			return str;
		}
}
