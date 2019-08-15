package iksoks;

import java.util.Scanner;

public class XO {
	public static void ispis(int visina, int sirina, String [][] polja) {
		//-------------Ispis tablice--------------------//		
		System.out.print("   ");
		for(int i=0;i<sirina;i++) {
			if(i<10)System.out.print(i+" ");
			else System.out.print((i-10)+" ");
		}
		System.out.print("\n  ");
		for(int i=0;i<sirina*2+1;i++) {
		System.out.print("-");
		}
		System.out.println();
		for(int i=0;i<visina;i++) {
			if(i<10)System.out.print(i+" |");
			else System.out.print((i-10)+" |");
			for(int j=0;j<polja[i].length;j++) {
				System.out.print(polja[i][j]+"|");
			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i=0;i<sirina*2+1;i++) {
			System.out.print("-");
			}
//-------------Ispis tablice--------------------//	
	}
    public static int horizontala(int zaPobedu, String[][] polja) {
    	int horPobeda=1;
    	for(int i=0;i<polja.length;i++) {
			horPobeda=1;
			for(int j=0;j<polja[i].length-1;j++) {							 		 
				     if(polja[i][j].equals(polja[i][j+1])&&!polja[i][j].equals("-")&&!polja[i][j+1].equals("-"))horPobeda++;
				     else horPobeda=1;	
				     if(horPobeda==zaPobedu)break;
				}
			if(horPobeda==zaPobedu)break;
			}
    	return horPobeda;
    }
    public static int vertikala(int zaPobedu, String[][] polja) {
    	int verPobeda=1;
    	for(int i=0;i<polja[0].length;i++) {
			verPobeda=1;
			for(int j=0;j<polja.length-1;j++) {							 		 
				     if(polja[j][i].equals(polja[j+1][i])&&!polja[j][i].equals("-")&&!polja[j+1][i].equals("-"))verPobeda++;
				     else verPobeda=1;	
				     if(verPobeda==zaPobedu)break;				     		     		     
				}
			if(verPobeda==zaPobedu)break;
			}
    	return verPobeda;	
    }
    public static int dijagonalaDesno(int zaPobedu, String[][] polja) {
    	int digdesPobeda=1;
    	int vert=0;
    	int horz=0;
		for (int i = 0, j=0; i<polja.length-1; i++) {
			vert=i;
			horz=j;
			if (digdesPobeda == zaPobedu)				
				break;
			digdesPobeda=1;
					while(vert<polja.length-1) {  
				if (polja[vert][horz].equals(polja[vert+1][horz + 1]) && !polja[vert][horz].equals("-")
							&& !polja[vert+1][horz + 1].equals("-")) {
						digdesPobeda++;	
				}
					else
						digdesPobeda = 1;
					if (digdesPobeda == zaPobedu)				
						break;
					
					horz++;
					vert++;
					}	
			}
		for (int i = 0, j=0; j<polja[0].length-1; j++) {
			vert=i;
			horz=j;
			if (digdesPobeda == zaPobedu)				
				break;
			digdesPobeda=1;
					while(horz<polja[0].length-1) {  
				if (polja[vert][horz].equals(polja[vert+1][horz + 1]) && !polja[vert][horz].equals("-")
							&& !polja[vert+1][horz + 1].equals("-")) {
						digdesPobeda++;	
				}
					else
						digdesPobeda = 1;
					if (digdesPobeda == zaPobedu)				
						break;
					
					horz++;
					vert++;
					}	
			}
		
		
		return digdesPobeda;
	}
    public static int dijagonalaLevo(int zaPobedu, String[][] polja) {
    	int diglevPobeda=1;
    	int vert=0;
    	int horz=0;
    	for (int i = 0, j=0; i<polja.length; i++) {
			vert=i;
			horz=j;
			if (diglevPobeda == zaPobedu)				
				break;
			diglevPobeda=1;
					while(vert>0) {  
				if (polja[vert][horz].equals(polja[vert-1][horz + 1]) && !polja[vert][horz].equals("-")
							&& !polja[vert-1][horz + 1].equals("-")) {
						diglevPobeda++;	
				}
					else
						diglevPobeda = 1;
					if (diglevPobeda == zaPobedu)				
						break;
					
					horz++;
					vert--;
					}	
			}
    	for (int i = polja.length-1, j=0; j<polja[0].length; j++) {
			vert=i;
			horz=j;
			if (diglevPobeda == zaPobedu)				
				break;
			diglevPobeda=1;
					while(horz<polja[0].length-1) {  
				if (polja[vert][horz].equals(polja[vert-1][horz + 1]) && !polja[vert][horz].equals("-")
							&& !polja[vert-1][horz + 1].equals("-")) {
						diglevPobeda++;	
				}
					else
						diglevPobeda = 1;
					if (diglevPobeda == zaPobedu)				
						break;
					
					horz++;
					vert--;
					}	
			}
    	
    	
    	
    	
    	
    	
    	return diglevPobeda;
    }
    public static boolean nereseno(String[][]polja) {
    	for(int i=0;i<polja.length;i++) {
			for(int j=0;j<polja[i].length;j++) {							 		 
				     if(polja[i][j].equals("-"))return false;
				}
			}
    	return true;
    }
 public static void main(String[] args) {
		Scanner n=new Scanner(System.in);
		int x=0; //X koordinata 
		int y=0; //Y koordinata
		int z=0; //Brojac koji meri koji je igrac na potezu	
		System.out.println("Unesite dimenzije tablice: ");
		int dimenzije=n.nextInt();
		while(dimenzije<=2 || dimenzije>20) {
			System.out.println("Minimum 3 Maximum 20\n");
			System.out.println("Unesite dimenzije tablice: ");
			dimenzije=n.nextInt();
			}
		System.out.println("Koliko spojenih za pobedu: ");
		
		int zaPobedu=n.nextInt();
		while(zaPobedu>dimenzije||zaPobedu<3) {
			System.out.println("Nemoguc uslov.\n");
			System.out.println("Koliko spojenih za pobedu: ");
			zaPobedu=n.nextInt();
		}
		String[][] polja=new String[dimenzije][dimenzije];
		
		for(int i=0;i<polja.length;i++) {
			for(int j=0;j<polja[i].length;j++) {
				polja[i][j]="-";
			}	
		}
		ispis(dimenzije, dimenzije, polja);
		while(true) {
		System.out.println("\nUnesite koordinatu gde zelite da postavite vas znak(1. Y 2. X) ");
		y=n.nextInt();
		x=n.nextInt();
		if(polja[y][x].equals("-") && z%2==0) {polja[y][x]="X";z++;}
		else if(polja[y][x].equals("-") && z%2!=0) {polja[y][x]="O";z++;}
		else System.out.println("Polje zauzeto, pokusajte ponovo. ");
		ispis(dimenzije, dimenzije, polja);
		if(nereseno(polja))break;
		if(horizontala(zaPobedu, polja)==zaPobedu) break;	
		if(vertikala(zaPobedu, polja)==zaPobedu) break;
		if(dijagonalaDesno(zaPobedu, polja)==zaPobedu) break;
		if(dijagonalaLevo(zaPobedu, polja)==zaPobedu) break;
         }
		if(nereseno(polja))System.out.println("Nereseno. ");
		else if(z%2!=0)System.out.println("\nIgrac X je pobednik!");
		else System.out.println("\nIgrac O je pobednik!");
}	
}


