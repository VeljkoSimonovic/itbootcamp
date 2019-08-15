package bg;

import java.util.Scanner;

public class OfficeWord {
	public static String[] izmenaRecenica(String recenice[], int izmena, String recenica) {
		for (int j = 0; j < recenice.length; j++) {
			if (j == izmena)
				recenice[j - 1] = recenica.trim();
		}
		return recenice;
	}

	public static String[] blokTxt(String recenica, String[] receniceBlok) {
		receniceBlok = recenica.split("(?<=[!?\\.])");
		return receniceBlok;
	}

	public static String[] brisanjeRecenica(String recenice[], int brisanje) {
		for (int j = 0; j < recenice.length; j++) {
			if (j == brisanje - 1) {
				for (int n = j; n < recenice.length - 1; n++) {
					recenice[n] = recenice[n + 1];
				}
			}
		}
		return recenice;
	}

	public static String[] upisRecenica(String recenice[], int i, String recenica) {

		recenice[i] = recenica;
		recenice[i] = recenice[i].trim();
		return recenice;
	}

	public static String[] velikoSlovo(String recenice[], int i) {
		for (int j = 0; j < i; j++) {
			recenice[j] = recenice[j].substring(0, 1).toUpperCase() + recenice[j].substring(1).toLowerCase();
		}
		return recenice;
	}

	public static int brojReci(String recenice[], String nreci1[], int i, int nreci) {
		for (int j = 0; j < i; j++) {
			nreci1 = recenice[j].split(" ");
			nreci += nreci1.length;
		}
		return nreci;
	}

	public static String[] dodajTacku(String recenice[], String tacka1[], int tacka, int i) {
		for (int j = 0; j < i; j++) {
			tacka1 = recenice[j].split("(?=[!?\\.])");
			tacka = tacka1.length - 1;
			if (tacka == 0)
				recenice[j] = recenice[j] + ". ";
		}
		return recenice;
	}

	// ------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Dobrodosli u konzolni Word™!\n---------------------------\n"
				+ "Komande:\n -1) Izlaz iz programa\n 0) Obrisi recenicu [int]\n 1) Dodaj recenicu"
				+ "[String]\n 2) Dodaj blok teksta [String]\n 3) Izmeni recenicu [int] [String]\n"
				+ " 4) Ispis celog teksta\n 99) Ispis komandnog menija\n---------------------------\n");

		int i = 0, cmd = 0, brisanje = 0, izmena = 0, nreci = 0, tacka = 0;
		String[] recenice = new String[100], receniceBlok = new String[200], nreci1 = new String[1000],
				tacka1 = new String[10];
		String recenica;
		while (cmd != -1) {
			System.out.println("Komanda: ");
			cmd = s.nextInt();
			switch (cmd) {
			case 0:
				brisanje = s.nextInt();
				brisanjeRecenica(recenice, brisanje);
				i--;
				break;
			case 1:
				recenica = s.nextLine();
				upisRecenica(recenice, i, recenica);
				i++;
				break;
			case 2:
				receniceBlok = blokTxt(recenica = s.nextLine(), receniceBlok);
				for (int j = 0; j < receniceBlok.length; j++) {
					/*
					 * ocajnicki sam pokusao da implementiram celu funkciju u metodu ali nisam nasao
					 * ni jedan nacin da mi vrati int i(brojac) tako da je podeljeno na ovaj nacin.
					 */
					recenice[i] = receniceBlok[j];
					recenice[i] = recenice[i].trim();
					i++;
				}
				;
				break;
			case 3:
				izmena = s.nextInt();
				recenica = s.nextLine();
				izmenaRecenica(recenice, izmena, recenica);
				break;
			case 4:
				nreci = 0;
				velikoSlovo(recenice, i);
				nreci = brojReci(recenice, nreci1, i, nreci);
				dodajTacku(recenice, tacka1, tacka, i);
				System.out.println("-----------tekst-----------\n");
				for (int j = 0; j < i; j++) {
					System.out.println((j + 1) + ": " + recenice[j] + "\n");
				}
				System.out.println("-----------status----------\n");
				System.out.println("Broj reci: " + nreci + "\n");
				System.out.println("---------------------------\n");
				break;
			case 99:
				System.out.println("Dobrodosli u konzolni Word™!\n---------------------------\n"
						+ "Komande:\n -1) Izlaz iz programa\n 0) Obrisi recenicu [int]\n 1) Dodaj recenicu"
						+ "[String]\n 2) Dodaj blok teksta [String]\n 3) Izmeni recenicu [int] [String]\n"
						+ " 4) Ispis celog teksta\n 99) Ispis komandnog menija\n---------------------------\n");
			}
		}
	}
}
