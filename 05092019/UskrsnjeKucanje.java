package bg;
import java.util.Scanner;
public class UskrsnjeKucanje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner (System.in);
		System.out.println("Unesite koliko ima takmicara: ");
		int brojtk=s.nextInt();
		int[] takm= new int[brojtk];
		double[] jaje=new double[brojtk];
		System.out.println("Unesite redni broj takmicara i jacinu njegovog jajeta: ");
		  for(int i=0;i<brojtk;i++){
		   int tk=s.nextInt();
		     takm[i]=tk;
		   double jj=s.nextDouble();
		     jaje[i]=jj;
		    }
			for(int i=0; i<jaje.length;i++) {
				double pom=0;
				int pom1=0;
				for(int j=i+1;j<jaje.length;j++) {
					if(jaje[i]>jaje[j]) {
						pom=jaje[i];
						jaje[i]=jaje[j];
						jaje[j]=pom;
						pom1=takm[i];
						takm[i]=takm[j];
						takm[j]=pom1;
					}	
				}	
			}	
			for(int i=1;i<=3;i++)
			System.out.println("Prvo mesto osvojio je takmicar #"+takm[takm.length-i] + " sa jacinom jajeta " + jaje[jaje.length-i]);			
        }
	}				
				
				
				
				
	
		  
	


