package bg;

import java.util.Scanner;

public class ProblemSpecijalnihPopusta {
   
	public static void main(String[] args) {
		System.out.println("Dobrodosli u Brasko++ pametnu kasu!");
		System.out.println("Koji je danas dan: ");
		int brpica1=0, musterija=0, triplus=0, sedma=0, day=0;
        double cena=0, ukcena=0, ccap=320, cpep=290, cves=310, cap=ccap, pep=cpep, 
        		ves=cves, ukvespopust=0, ukcappopust=0, ukpeppopust=0, ukcenapopust=0;				 
		Scanner d=new Scanner(System.in); 		
		while(true) {
			String dan = d.next();
			switch (dan) {
		case "pon":{System.out.println("Ponedeljak");break;}
		case "uto":{System.out.println("Utorak");day=1;break;}
		case "sre":{System.out.println("Sreda");break;}
		case "cet":{System.out.println("Cetvrtak");day=2;break;}
		case "pet":{System.out.println("Petak");break;}
		case "sub":{System.out.println("Subota");day=3;break;}
		case "ned":{System.out.println("Nedelja");day=3;break;}
		default: System.out.println("Nepostojeci dan. Unesite u formatu pon/uto/sre...");continue;
			};break;
		}		
		while(true) {
			int j=1;
			 ukvespopust=0;
			 ukcappopust=0;
			 ukpeppopust=0;
			musterija++;
			double ukcap=0, ukpep=0, ukves=0;
			System.out.println("Musterija id#" + musterija);
			int brpica=d.nextInt();
			triplus=0;
			brpica1=brpica;
			if(brpica1==-1) {System.out.println("Kraj dana.");break;}
			 while(brpica>0) {
				 int idpice1=0; 
				   cap=320; pep=290; ves=310;
				    if(day==1) {cap=320; pep=290; ves=ves*0.9;}
					else if(day==2) {cap=cap*0.9; pep=290; ves=310;}
					else if(day==3) {cap=cap*0.85; pep=pep*0.85; ves=ves*0.85;}
					else {cap=320; pep=290; ves=310;}
				 brpica--;
				 int idpice=d.nextInt();
				switch (idpice) {
				 case 2:cena=cap;idpice1=1;break;
				 case 3:cena=pep;idpice1=2;break;
				 case 5:cena=ves;idpice1=3;break;
				 default:brpica++;System.out.println("Greska u unosu, pokusajte opet");break;
				 }
				while(j!=0) {j--;System.out.println("------------------------------\n - Racun za musteriju id# " + musterija + " -\n");}
				triplus++;
				sedma++;
				if(triplus%4!=0 && sedma%7!=0) {
					if(idpice1==1){System.out.println("Pizza Cappricosa " + ccap);ukcappopust+=ccap;}
					else if(idpice1==2) {System.out.println("Pizza Pepperoni " + cpep); ukpeppopust+=cpep;}
					else if(idpice1==3) {System.out.println("Pizza Vesuvio " + cves);ukvespopust+=cves;}
					}				
				if(triplus%4==0) {
					cena=0;cap=0; pep=0; ves=0;
					if(idpice1==1)System.out.println("Akcija 3+1 Cappricosa " + cap);
					else if(idpice1==2)System.out.println("Akcija 3+1 Pepperoni " + pep);
					else if(idpice1==3)System.out.println("Akcija 3+1 Vesuvio " + ves);
					}
				if(sedma%7==0) {cena=0;cap=0; pep=0; ves=0;
					if(idpice1==1)System.out.println("Akcija #7 Cappricosa " + cap);
					else if(idpice1==2)System.out.println("Akcija #7 Pepperoni " + pep);
					else if(idpice1==3)System.out.println("Akcija #7 Vesuvio " + ves);					
				}				
				 if(idpice1==1)ukcap+=cap;
				 if(idpice1==2)ukpep+=pep;
				 if(idpice1==3)ukves+=ves;
				 ukcenapopust=(ukcap+ukpep+ukves);
				 }
			     ukcena=(ukvespopust+ukcappopust+ukpeppopust);
			     System.out.println("------------------------------");
			     System.out.println("ukupno " + ukcena);			     
			        if(day==1) {System.out.println("Dnevna 10% Vesuvio -" + (ukvespopust*0.1));}
					else if(day==2) {System.out.println("Dnevna 10% Capriccosa -" + (ukcappopust*0.1));}
					else if(day==3) {System.out.println("Dnevna 15% SVE -" + (ukcena*0.15));}
			       if(day==1 || day==2 || day==3)System.out.println("ukupno sa popustom " + ukcenapopust);
				 System.out.println("------------------------------");				 
						}
	}
}
	 
				 
				 
				
				
				  
				 
			 
			
			
			
			
			
			

