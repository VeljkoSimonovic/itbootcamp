package Posta;
import java.util.Scanner;
public class Posta {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Dobrodosli u pametni sistem poste!\n"
        		+ "-----------------------------------\nUnesite pristigla pisma: ");
        Scanner s= new Scanner(System.in);
		pisma[] pismo=new pisma[100];
		int x, y=0, poKod=0;
		for(int i=0;i<pismo.length;i++) {
			pismo[i]=new pisma();
			pismo[i].setPismo();			
			x=pismo[i].getEnd();
			y++;
			if(x==1)break;
		}
		
		System.out.println("------------------------------------------\nPisma uspesno ucitana!\n"
				+ "------------------------------------------\n");
		while(poKod!=-1) {
		System.out.println("Unesite postanski broj grada, ili -1 za kraj programa: ");
		poKod=s.nextInt();
		for(int i=0;i<y-1;i++) {
			int zip=pismo[i].getZip();
			if(poKod==zip){System.out.println(pismo[i]);}
			}
		System.out.println("------------------------------------------\n");
		}
		System.out.println("Kraj programa.");
		
		
		
		
	}

}
	
	
	
	
	
	
	
	
	
