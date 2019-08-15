package Anagram;

import java.util.Scanner;

/*Obzirom da zadatak ne trazi boolean niti nam povratna vrednost sluzi icemu osim informacije 
da li su nizovi anagrami ili ne, uradio sam ga ovako jer mi je delovalo interesantno. 
Da se informacija koristi za nesto unutar programa kopirao bih nizove(da ih ne menja u mainu) i vratio boolean. */
public class Anagram {
	public static double[] ucitniza(Scanner n, int z, int id) {
		double[] a = new double[z];
		System.out.println("Unesite " + a.length + " vrednosti " + id + ". niza");
		for (int i = 0; i < a.length; i++) {
			a[i] = n.nextDouble();
		}
		return a;
	}

	public static String poredjenjeNizova(Scanner n) {
		System.out.println("Unesite duzinu nizova 1-100: ");
		int z = n.nextInt();
		if (z < 1 || z > 100)
			return "Nedozvoljena duzina niza, kraj programa";
		int id = 0;
		double[] x = ucitniza(n, z, ++id);
		double[] y = ucitniza(n, z, ++id);
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (x[i] == y[j]) {
					x[i] = Double.NaN;
					y[j] = Double.NaN;
					break;
				}
			}
			if (!Double.isNaN(x[i]))
				return "Nizovi nisu anagrami";
		}
		return "Nizovi su anagrami";
	}

	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.println(poredjenjeNizova(n));
	}
}
