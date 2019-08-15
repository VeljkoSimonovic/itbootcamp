package bg;

import java.util.Scanner;

public class ServisZaPorudzbine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u Brasko++ servis za narucivanje! ");
		System.out.println("Molimo unesite kolicinu sastojaka koje zelite: ");
		System.out.println("Napomena: Svaki sastojak se moze izabrati samo jednom. ");

		int x = sc.nextInt();
		// 4 sastojka
		if (x == 4) {
			System.out.println("Molimo unesite oznake sastojaka koje zelite: ");

			int a = sc.nextInt();
			switch (a) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int b = sc.nextInt();
			switch (b) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int c = sc.nextInt();
			switch (c) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int d = sc.nextInt();
			switch (d) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			System.out.println("Izabrali ste pizzu Kombinacija!");
			System.out.println("Vas racun je 360din.");
		}

		// 3 sastojka
		else if (x == 3) {

			System.out.println("Molimo unesite oznake sastojaka koje zelite: ");

			int a1 = sc.nextInt();
			switch (a1) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int b1 = sc.nextInt();
			switch (b1) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int c1 = sc.nextInt();
			switch (c1) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			{
				int p1 = a1 * b1 * c1;
				if (p1 == 30) {
					System.out.println("Izabrali ste pizzu Capprisiosu!");
					System.out.println("Vas racun je 320din");
				} else if (p1 == 42) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 330din");
				} else if (p1 == 70) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 320din");
				} else if (p1 == 105) {
					System.out.println("izabrali ste pizzu Vesuvio!");
					System.out.println("Vas racun je 310din");
				}
			}
		}

		// 2 sastojka
		else if (x == 2) {
			System.out.println("Molimo unesite oznake sastojaka koje zelite: ");

			int a2 = sc.nextInt();
			switch (a2) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			int b2 = sc.nextInt();
			switch (b2) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			{
				int p2 = a2 * b2;
				if (p2 == 6) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 290din");
				} else if (p2 == 10) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 280din");
				} else if (p2 == 14) {
					System.out.println("izabrali ste pizzu Pepperoni!");
					System.out.println("Vas racun je 290din");
				} else if (p2 == 15) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 270din");
				} else if (p2 == 21) {
					System.out.println("izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 280din");
				} else if (p2 == 35) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 270din");
				}
			}
		}
		// 1 sastojak
		else if (x == 1) {
			System.out.println("Molimo unesite oznake sastojaka koje zelite: ");

			int a3 = sc.nextInt();
			switch (a3) {
			case 2:
				System.out.println();
				break;
			case 3:
				System.out.println();
				break;
			case 5:
				System.out.println();
				break;
			case 7:
				System.out.println();
				break;
			default:
				System.err.println("Greska, zeljeni sastojak ne postoji u bazi podataka. Pokusajte ponovo. ");
				break;
			}

			{
				int p3 = a3;
				if (p3 == 2) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 250din");
				} else if (p3 == 3) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 240din");
				} else if (p3 == 5) {
					System.out.println("izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 230din");
				} else if (p3 == 7) {
					System.out.println("Izabrali ste pizzu Kombinacija!");
					System.out.println("Vas racun je 240din");
				}
			}
		}
		// Bez sastojaka
		else if (x == 0) {
			System.out.println("Izabrali ste picu bez sastojaka. ");
			System.out.println("Vas racun je 200din. ");
		}

	}

}
