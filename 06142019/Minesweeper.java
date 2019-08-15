package iksoks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Minesweeper {
public static int[][] txtCitac(Scanner sc) {
	int[][] polja=new int[0][0];
	try {  
			BufferedReader b = new BufferedReader(new FileReader("minice.txt"));
			String[] txtfajl = b.readLine().split(" ");
			int y = Integer.parseInt(txtfajl[0]);
			while (y < 2 || y > 100) {
				System.out.println("Nedozvoljena visina, pokusajte ponovo: ");
				y = sc.nextInt();
			}
			int x = Integer.parseInt(txtfajl[1]);
			while (x < 2 || x > 100) {
				System.out.println("Nedozvoljena sirina, pokusajte ponovo: ");
				x = sc.nextInt();
			}
			polja = new int[y][x];
			char[] polje;
			for(int i=0;i<polja.length;i++) {
				polje=b.readLine().trim().toCharArray();
				for (int j = 0; j < polja[i].length; j++) {
					polja[i][j]=Character.getNumericValue(polje[j]);
				}
			}
		} catch (Exception e) {

		}
	return polja;
}
public static int[][] upis(int y, int x, int[][] polja){
	int[][] polja1 = new int[y][x];
	for (int i = 0; i < polja.length; i++) {
			for (int j = 0; j < polja[i].length; j++) {
				if(polja[i][j]==1) {
					if(i-1>=0 && j-1>=0)polja1[i-1][j-1]++;
					if(i-1>=0)polja1[i-1][j]++;
					if(i-1>=0&&j+1<x)polja1[i-1][j+1]++;
					if(j-1>=0)polja1[i][j-1]++;
					if(j+1<x)polja1[i][j+1]++;
					if(i+1<y&&j-1>=0)polja1[i+1][j-1]++;
					if(i+1<y)polja1[i+1][j]++;
					if(i+1<y&&j+1<x)polja1[i+1][j+1]++;
				}
			}
		}
	return polja1;
}
public static void txtUpis(int[][] polja1) {
	try(FileWriter fw = new FileWriter("bombs.txt")){
			fw.write(polja1.length + " " + polja1[0].length + "\n");
			for(int i=0;i<polja1.length;i++) {
				for (int j = 0; j < polja1[0].length; j++) {
					fw.write(Integer.toString(polja1[i][j]));
				}
				fw.write("\n");
			}
			
			} catch(IOException e) {
			e.printStackTrace();
			}
}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] polja =txtCitac(sc);
		int[][] polja1=upis(polja.length, polja[0].length, polja);
		txtUpis(polja1);
	}
}
