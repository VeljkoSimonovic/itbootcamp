package IzomorfneReci;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class IzomorfneReci {
	public static int[] randomizer() {
		Random rn = new Random();
		int[] rnd = new int[26];
		for (int i = 0; i < rnd.length; i++) {
			boolean b = false;
			int x = rn.nextInt(27);
			for (int j = 0; j < rnd.length; j++) {
				if (rnd[j] == x || x == 0) {
					b = true;
					break;
				}

			}
			if (b) {
				i--;
				continue;
			}
			rnd[i] = x;
		}
		return rnd;
	}

	public static boolean provera(String s, String s1, HashMap<Character, Character> slovca) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (slovca.get(c[i]) != s1.charAt(i))
				return false;
		}
		return true;
	}

	public static HashMap<Character, Character> kreirajMapu() {
		HashMap<Character, Character> slovca = new HashMap<Character, Character>();
		int[] key = randomizer();
		int[] val = randomizer();
		char[] abc = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < abc.length; i++) {
			slovca.put(abc[key[i] - 1], abc[val[i] - 1]);
		}
		for (char c : slovca.keySet()) {
			System.out.println(c + " => " + slovca.get(c));
		}
		return slovca;
	}

	public static void main(String[] args) {
		HashMap<Character, Character> slovca = kreirajMapu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite dve reci da proverite da li su izomorfne: ");
		System.out.println(provera(sc.next(), sc.next(), slovca));
		sc.close();
	}

}
