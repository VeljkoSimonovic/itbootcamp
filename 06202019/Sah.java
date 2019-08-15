package Sah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sah {
	public static void ispis(char[][] polja) {
		for (int i = 0; i < polja.length; i++) {
			for (int j = 0; j < polja.length; j++) {
				if(polja[i][j]=='O') {polja[i][j]=' ';	
				}
			}
		}//metoda sluzi iskljucivo za ispis tabele u konzoli, i da promeni 'O' u ' ' radi preglednosti
		System.out.println();
		int x=8;
		for (int i = 0; i < polja.length; i++) {
			System.out.print(x + " |");
			for (int j = 0; j < polja[i].length; j++) {
				System.out.print(polja[i][j] + "|");
			}
			System.out.println();
			x--;
		}
		System.out.println("   A B C D E F G H");
	}
	public static void postaviFigure(char[][] beli, char[][] crni) {
		try {
			BufferedReader b = new BufferedReader(new FileReader("beli.txt"));
			BufferedReader c = new BufferedReader(new FileReader("crni.txt"));
			char[] belac;
			char[] crnac;
			for(int i=0;i<beli.length;i++) {
				belac=b.readLine().trim().toCharArray();
				crnac=c.readLine().trim().toCharArray();
				for (int j = 0; j < beli[i].length; j++) {
					beli[i][j]=belac[j];
					crni[i][j]=crnac[j];
				}
			}
	    b.close();
		c.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[] nadjiFigure(char fig, char[][] svefig) {
		ArrayList<Double> nadjeneFigure = new ArrayList<Double>();
		for (int i = 0; i < svefig.length; i++) {
			for (int j = 0; j < svefig[i].length; j++) {
				if (fig == svefig[i][j]) {
					nadjeneFigure.add((double) i);
					nadjeneFigure.add((double) j);
				}
			}//ova metoda je mogla prostije ali sam se igrao sa castovima i arraylistama
		}
		int[] koordinate=new int[nadjeneFigure.size()];
		for (int i = 0; i < koordinate.length; i++) {
			koordinate[i]=(int) (nadjeneFigure.get(i)*1);
		}
		
		return koordinate;
	}
	public static void skakacJede(int[] koords, char[][] polja) {
		char[] slova= {'A','B','C','D','E','F','G','H'};
		int[] broj= {8,7,6,5,4,3,2,1};
		int x=0, y=0;
		for (int i = 0; i < koords.length; i+=2) {
			y=koords[i];
			x=koords[i+1];
			System.out.print("\nS("+slova[x]+broj[y]+"): ");
			if(y-1>=0&&x-2>=0&&polja[y-1][x-2]!=' ')System.out.print(polja[y-1][x-2]+"("+slova[x-2]+broj[y-1]+") ");
			if(y+1<8&&x-2>=0&&polja[y+1][x-2]!=' ')System.out.print(polja[y+1][x-2]+"("+slova[x-2]+broj[y+1]+") ");
			if(y-1>=0&&x+2<8&&polja[y-1][x+2]!=' ')System.out.print(polja[y-1][x+2]+"("+slova[x+2]+broj[y-1]+") ");
			if(y+1<8&&x+2<8&&polja[y+1][x+2]!=' ')System.out.print(polja[y+1][x+2]+"("+slova[x+2]+broj[y+1]+") ");
			if(y-2>=0&&x+1<8&&polja[y-2][x+1]!=' ')System.out.print(polja[y-2][x+1]+"("+slova[x+1]+broj[y-2]+") ");
			if(y-2>=0&&x-1>0&&polja[y-2][x-1]!=' ')System.out.print(polja[y-2][x-1]+"("+slova[x-1]+broj[y-2]+") ");
			if(y+2<8&&x-1>=0&&polja[y+2][x-1]!=' ')System.out.print(polja[y+2][x-1]+"("+slova[x-1]+broj[y+2]+") ");
			if(y+2<8&&x+1<8&&polja[y+2][x+1]!=' ')System.out.print(polja[y+2][x+1]+"("+slova[x+1]+broj[y+2]+") ");
		}
	}
	public static void main(String[] args) {
		char[][] beli = new char[8][8];
		char[][] crni = new char[8][8];
		postaviFigure(beli, crni);
		int[] koordinate=nadjiFigure('S', beli);
		System.out.println("Beli");
		ispis(beli);
		System.out.println("Crni");
		ispis(crni);
		skakacJede(koordinate, crni);
	}
}
