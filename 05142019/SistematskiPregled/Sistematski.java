package SistematskiPregled;
import java.util.Scanner;

public class Sistematski {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int x=0, y=0, z, m; //z i n su pomocne varijable za brojacke nizove, x sluzi kao pomocna varijabla za kraj unosa a y odredjuje koliko pacijenata ima u nizu. m sluzi za ispis rednih brojeva u histogramu
		int[] histo=new int[4];
		int[] histo1=new int[4]; //pomocni brojac za histogram
			String ime, prezime;
			double visina, tezina;
			boolean kraj;
					
		Osoba[] pacijent=new Osoba[100];
		BMI[] bmi=new BMI[100];
		System.out.println("Unesite osobe: ");
		for(int i=0;i<pacijent.length;i++) {
			String kraj1=s.next();
			kraj=kraj1.indexOf("kraj") !=-1? true:false;
			if(kraj==true)x=1;
			if(x==1)break;				
			prezime=s.next();
			ime=kraj1 + " ";	
			visina=s.nextDouble();
		    tezina=s.nextDouble();					
			pacijent[i]=new Osoba(ime, prezime, visina, tezina) ;
			bmi[i]=new BMI(visina, tezina);
			y++;
			z=bmi[i].getVrednost();
			if(z==0)histo[z]+=1;
			else if(z==1)histo[z]+=1;
			else if(z==2)histo[z]+=1;
			else if(z==3)histo[z]+=1;
			
		}
		System.out.println("Osobe uspesno ucitane!\n\n--------------------------------------------------------------------------\n");
		for(int i=0;i<y;i++) {
		System.out.println(pacijent[i] + " " + bmi[i]);
		}
		System.out.println("\n--------------------------------------------------------------------------\nStatistika:\n");
	//--------brojac koji odredjuje najveci broj pripadnika odredjene kategorije--------//	
		for(int i=0;i<histo.length;i++) {
			histo1[i]=histo[i];
		}		
		for(int i=0; i<histo1.length;i++) {
			int pom=0;
			int pom1=0;
			for(int j=i+1;j<histo1.length;j++) {
				if(histo1[i]<histo1[j]) {
					pom=histo1[i];
					histo1[i]=histo1[j];
					histo1[j]=pom;				
				}	
			}
		}	
		m=histo1[0];
		for(int i=0;i<histo1[0];i++) {
			if(m<10) //if koji sluzi da zvezdice budu lepo centrirane ako je max vrednost dvocifrena(pomeri ih u stranu)
			System.out.print(m + "   ");
			else if (m>=10) System.out.print(m + "  ");
			
			for(int j=0;j<4;j++) {
				if(histo[j]>=m)System.out.print(" *");
				else System.out.print("  ");
				System.out.print(" ");
				
			}System.out.println("\n");
			m--;
		}
		
		System.out.println("     N  IM PM G ");
		
	}
}
