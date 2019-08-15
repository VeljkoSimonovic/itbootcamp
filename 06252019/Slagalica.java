package Slagalica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Slagalica {
	public static ArrayList<String> citaj() {
		ArrayList<String> recnik = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("recnik.txt"))) {
			while (br.ready()) {
				recnik.add(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return recnik;
	}
	public static boolean proveriSlova(String slova, String unos) {
		StringBuilder slovca = new StringBuilder(slova.toLowerCase());
		StringBuilder rec = new StringBuilder(unos);
		for (int i = 0; i < rec.length(); i++) {
			for (int j = 0; j < slovca.length(); j++) {
				if (rec.charAt(i) == slovca.charAt(j)) {
					slovca.setCharAt(j, '*');				
					rec.setCharAt(i, '*');				
					break;
				}
			}
			if (rec.charAt(i) != '*')
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String azbuka = "АБВГДЂЕЖЗИЈКЛЉМНЊОПРСТЋУФХЦЧЏШ";
		String slova = "";
		String str = "";
		ArrayList<String> recnik = citaj();
		for (int i = 0; i < 12; i++) {
			slova += azbuka.charAt(r.nextInt(30));
		}
		for (int i = 0; i < slova.length(); i++) {
			System.out.print(slova.charAt(i) + " ");
		}
		long pocetno = System.currentTimeMillis();
		boolean b = true;
		while (b && !(System.currentTimeMillis() - pocetno > 60000)) {
			System.out.println("\nUnesite rec: ");
			str = sc.next().toLowerCase();
			if (System.currentTimeMillis() - pocetno > 60000) {
				break;
			}
			if (proveriSlova(slova, str)) {
				System.out.println("Користили сте недозовољена слова! Пробајте опет!");
				continue;
			}
			for (int i = 0; i < recnik.size(); i++) {
				if (recnik.get(i).equals(str)) {
					System.out.println("Pogodak!!!");
					b = false;
					break;
				}
			}
		}
		if (b)
			System.out.println("Nazalost, vreme je isteklo.");
		else
			System.out.println("Osvojili ste " + str.length() * 2 + " poena");
	}
}
