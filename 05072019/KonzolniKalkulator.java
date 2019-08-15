package bg;

import java.util.Scanner;

public class KonzolniKalkulator {
	
	public static double sab (double br, double rezultat) {
		rezultat+=br;
		return rezultat;
	}
	public static double min (double br, double rezultat) {
		 rezultat-=br;
		 return rezultat;
	}
	public static double puta(double br, double rezultat) {
		rezultat*=br;
		return rezultat;
	}
	public static double del(double br, double rezultat) {
		rezultat/=br;
		return rezultat;
	}
	public static double step(int st, double rezultat) {
		while(st>1) {
			rezultat*=rezultat;
			st-=1;
		}
		return rezultat;
	}
	public static double fakt(int fkt, double rezultat) {
		rezultat=1;
		while(fkt>0) {
			rezultat*=fkt;
			fkt--;
		}
		return rezultat;
	}
	public static double mods(int mod, double rezultat) {
		rezultat%=mod;
		return rezultat;
	}
	public static Double bin(int br,  double rezultat) {
		String x= "";
		int y;
		 while(br > 0)
	        {
	            y = br % 2;
	      
	            x = x + "" + y;
	            br = br / 2;
	        }
	        rezultat=Double.parseDouble(x);
	        return rezultat;
	}
	public static double koren(double kor, double rezultat) {
		double z=0;

		double sqrt = kor/2;

		 while ((z - sqrt) != 0) {
			z = sqrt;
			sqrt = (z + (kor / z)) / 2;
		 }
		 rezultat=sqrt;
		return rezultat;
	}
//------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner n= new Scanner (System.in);
		double rezultat=0;
		System.out.println("Dobrodosli u 'konzolni kalkulator 9000'!\n");
		System.out.println("----------------------------------------\n");
		System.out.println("Komande:\n-1) Izlaz iz programa\n 0) Reset\n 1) Saberi [double]\n "
				+ "2) Oduzmi [double]\n 3) Pomnozi [double]\n 4) Podeli [double != 0]\n "
				+ "5) Digni na stepen [int]\n 6) Faktorijel [int]\n 7) Modulus [int]\n 8) Binarni broj [int]"
				+ "\n 9) Koren [double]\n99) Ispis komandnog menija\n\n"
				+ "---------------------------------------- ");
		System.out.println("---------------------------\n Trenutna vrednost: " + rezultat + 
				   "\n\n Komanda: \n---------------------------");

		while(true) {
			int op=n.nextInt();
			if(op==-1) {System.out.println("Kraj programa");break;}
		   if(op==0) rezultat=0;
		   else if(op==1) {
		       double br=n.nextDouble();
		       rezultat=sab(br, rezultat);
		
		   }
		   else if(op==2) {
			   double br=n.nextDouble();
			   rezultat=min(br, rezultat);
		   }
		   else if(op==3) {
			   double br=n.nextDouble();
			   rezultat=puta(br, rezultat);
		   }
		   else if(op==4) {
			   double br=n.nextDouble();
			   rezultat=del(br, rezultat);
		   }
		   else if(op==5) {
			   int st=n.nextInt();
			   rezultat=step(st, rezultat);
		   }
		   else if(op==6) {
			   int fkt=n.nextInt();
			   rezultat=fakt(fkt, rezultat);
		   }
		   else if(op==7) {
			   int mod=n.nextInt();
			   rezultat=mods(mod, rezultat);
		   }
		   else if(op==8) {
			   int br=n.nextInt();
			   rezultat=bin(br, rezultat);
		   }
		   else if(op==9) {
			   double kor=n.nextDouble();
			   rezultat=koren(kor, rezultat);
		   }
		   else if(op==99) {
			   System.out.println("---------------------------\n");
				System.out.println("Komande:\n-1) Izlaz iz programa\n 0) Reset\n 1) Saberi [double]\n "
						+ "2) Oduzmi [double]\n 3) Pomnozi [double]\n 4) Podeli [double != 0]\n "
						+ "5) Digni na stepen [int]\n 6) Faktorijel [int]\n 7) Modulus [int]\n 8) Binarni broj [int]"
						+ "\n 9) Koren [double]\n99) Ispis komandnog menija\n\n");
		   }
		   else System.out.println("Greska, nepostojeca operacija, pokusajte ponovo. ");
		   System.out.println("---------------------------\n Trenutna vrednost: " + rezultat + 
				   "\n\n Komanda: \n---------------------------");
		}
	}

}
