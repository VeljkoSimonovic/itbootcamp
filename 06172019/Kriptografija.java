package PrivatniKons;

import java.util.Scanner;

public class Kriptografija {
public static int brojac(int n) {//metoda koja provera koliko cifara ima unet kljuc, i rasporedjuje u length-ove odgovarajucih nizova 
	int brojac=0;
		while(n>0) {
			n/=10;
			brojac++;
		}
		return brojac;
}
public static int[] cifreUniz(int n) {//metoda razlaze n na cifre i ubacuje ih u niz pravilnim redosledom
	int[] kljuc=new int[brojac(n)];
	for (int i = kljuc.length-1; i >= 0; i--) {
			kljuc[i]=n%10;
			n/=10;
		}
	return kljuc;
}
public static char[][] kriptoMatrica(int x, int y, String[] s){//String s je niz od podeljenog String-a za enkripciju, i slaze ga u char matricu 
	char[][] enigma=new char[x][y];
	for (int i = 0; i < enigma.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				enigma[i][j]=s[i].charAt(j);
			}
		}
	return enigma;
}
public static String[] kriptovanjeNiza(int[] kljuc, char[][] enigma) {//metoda koja po kljucu slaze delove iz matrice u niz Stringova za kasniju obradu
	String[] kriptovaniNiz=new String[kljuc.length];
	for (int i = 0; i < kljuc.length; i++) {
			kriptovaniNiz[kljuc[i]-1]="";
			for (int j = 0; j < enigma.length; j++) {
				kriptovaniNiz[kljuc[i]-1]+=enigma[j][i];
			}
		}
	return kriptovaniNiz;
}
public static String finalnaEnkripcija(String[] kriptovaniNiz) {//slaze kriptovaniNiz u finalni string
	String s="";
	for (int i = 0; i < kriptovaniNiz.length; i++) {
			s+=kriptovaniNiz[i].trim();//dodao sam trim da ne bude bude razmaka u enkriptovanoj poruci
		}							   //u slucaju da poslednji red ima tipa samo jedan ili dva char-a;
		return s;
}
public static boolean proveraKljuca(int[] kljuc) {
	for (int i = 0; i < kljuc.length-1; i++) {
		for (int j = i; j < kljuc.length-1; j++) {
			if(kljuc[i]==kljuc[j+1]||kljuc[i]==0||kljuc[j+1]==0)return false;
		}
		
	}
	return true;
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite brojeve kljuca u formatu 123456789 bez nula i ponavljanja: ");
		int n=sc.nextInt();
		int[] kljuc=cifreUniz(n);
		if(proveraKljuca(kljuc)) {
		String zaEnkripciju="interesantnainformacija";
		String[] s=zaEnkripciju.split("(?<=\\G.{"+kljuc.length+"})");
		char[][] enigma=kriptoMatrica(s.length, kljuc.length, s);
		String[] kriptovaniNiz=kriptovanjeNiza(kljuc, enigma);
		zaEnkripciju=finalnaEnkripcija(kriptovaniNiz);
		System.out.println(zaEnkripciju);
		}
		else System.out.println("Pogresno unet kljuc, kraj programa");
	}
}

