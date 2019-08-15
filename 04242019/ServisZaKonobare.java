package bg;

import java.util.Scanner;

public class ServisZaKonobare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			System.out.println("Dobrodosli u pametni servis za konobare!");
		}
		{
			System.out.println("Unesite porudzbine: ");
			Scanner sc = new Scanner(System.in);
			//x=cena pica/y=cena hrane/a=ukp. pice/b=ukp. hrane/c=procenat pica/d=procenat hrane/e=ukp. proc. zarada
			int x = 0, y = 0, a = 0, b = 0;
		    double c = 0, d = 0;
			while (true) {
				a+=x;
				b+=y;
				x=0; y=0;
				c=a*0.1;
				d=b*0.15;
				int n = sc.nextInt();
				
				if (n == 1 || n == 2 || n == 3 || n == 4 || n == 41 || n == 42 || n == 43) {
					switch (n) {
					case 1:x=60;;break;  
					case 2:x=60; ;break;
					case 3:x=100;;break;
					case 4:x=120;;break;
					case 41:y=250;;break;
					case 42:y=240;;break;
					case 43:y=290;;break;
					default:System.out.println();break;
					};
					
				} 
				  else if (n == 0) {
					System.out.println();
					break;
				} else {
					System.out.println("Greška, željeni id nije u bazi podataka. Pokušajte ponovo. ");
					;continue;
					}
				}
			System.out.print("Ukupna cena pica je   " + a + "din   ");
			System.out.println("Procenat zarade od pica  " + (c) + "din  "); 
			System.out.print("Ukupna cena hrane je  " + b + "din  ");
			System.out.println(" Procenat zarade od hrane " + (d) + "din  ");
			System.out.println("Ukupna zarada: " + (c+d) + "din  ");
	  }
	 }
	}
	


