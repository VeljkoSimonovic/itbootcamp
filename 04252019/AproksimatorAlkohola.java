package bg;

import java.util.Scanner;
import java.text.DecimalFormat;

public class AproksimatorAlkohola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner sc = new Scanner(System.in);
		double y=1, a=0, r=0, alc=0, ualc=0, bac=0;
		System.out.println("Dobrodosli u alko aproksimator 9000!\n");
			while(true) {		
			System.out.println("Unesite vasu tezinu:\n ");
			double n=sc.nextDouble();
			a=n*1000;
			System.out.println("vasa tezina je " + n + " kg\n");break;
			
			} 
			while(true) {
				System.out.println("Unesite vas pol: ");
				int m=sc.nextInt();
				switch(m) {
				case 0:r=0.68;break;
				case 1:r=0.55;break;
				default:System.err.println("Greska u unosu. Pokusajte ponovo!");continue;
				}		
				if(m==0) {System.out.println("Vas pol je muski\n");}
				else if(m==1) {System.out.println("Vas pol je zenski\n");};break;
				};
			
			while(true) {
				System.out.println("Unesite sta ste i koliko popili ili -1 za kraj alkoholisanja: ");
				y=0;
				ualc+=alc;
				int x=sc.nextInt();
				switch(x) {
				case-1:x=-1;break;
				case 1:y=0.50;break;
				case 2:y=0.40;break;
				case 3:y=0.047;break;
				case 4:y=0.11;break;
				case 0:;
				double c=sc.nextDouble();
				y=c/100;break;
				default:System.err.println("Greska, zeljeni id nije u bazi podataka. Pokusajte ponovo! \n ");continue;
				}
				if(x==-1) break;
		
				double k=sc.nextDouble();
			    if(x==1) {System.out.println("Popili ste " + k +  " ml rakije\n");}
				else if(x==2) {System.out.println("Popili ste " + k + " ml vinjaka\n" );}
				else if(x==3) {System.out.println("Popili ste " + k + " ml piva\n");}
				else if(x==4) {System.out.println("Popili ste " + k + " ml vina\n");}
				else if(x==0) {System.out.println("Popili ste " + k + " ml nepoznatog pica koje sadrzi " + y*100 + "% alkohola\n");}			 
			    alc=k*y;
			    }
		    bac=(ualc/(a*r))*1000;
			double zbac = Math. round(bac * 100.0) / 100.0;
			if(zbac<0.21) {
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - BAC je u zakonskim granicama, udri!\n" );
				System.out.println("----------------------------------\n");			
			}else if(zbac>=0.21 && zbac<=0.5){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Umerena alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 10000din\n");
				System.out.println("Kazneni poeni: 0\n");
				System.out.println("Zabrana voznje: /\n");
				System.out.println("----------------------------------\n");
			}else if(zbac>=0.51 && zbac<=0.8){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Srednja alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 10000-20000 din\n");
				System.out.println("Kazneni poeni: 6\n");
				System.out.println("Zabrana voznje: 3 meseca\n");
				System.out.println("----------------------------------\n");
			}else if(zbac>=0.81 && zbac<=1.2){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Visoka alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 20000-40000 din\n");
				System.out.println("Kazneni poeni: 8\n");
				System.out.println("Zabrana voznje: 4 meseca\n");
				System.out.println("----------------------------------\n");
			}else if(zbac>=1.21 && zbac<=1.6){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Teska alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 100000-120000 din\n");
				System.out.println("Kazneni poeni: 9\n");
				System.out.println("Zabrana voznje: 8 meseci\n");
				System.out.println("----------------------------------\n");
			}else if(zbac>=1.61 && zbac<=2.0){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Teska alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 100000-120000 din\n");
				System.out.println("Kazneni poeni: 14\n");
				System.out.println("Zabrana voznje: 8 meseci\n");
				System.out.println("----------------------------------\n");
			}else if(zbac>2.0){
				System.out.println("----------------------------------\n");			
				System.out.println("BAC: " + zbac + " - Potpuna alkoholisanost\n" );
				System.out.println("----------------------------------\n");			
				System.out.println("Kazna: 30-60 dana zatvora\n");
				System.out.println("Kazneni poeni: 15\n");
				System.out.println("Zabrana voznje: 9 meseci\n");
				System.out.println("----------------------------------\n");
			}if(zbac>0.2)System.out.println("Uzmite autobus!");	
		 }
    }
			
		
			    	  
				
	

				
				
				
			
		
		

	

