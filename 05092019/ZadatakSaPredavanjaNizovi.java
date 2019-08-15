package bg;
import java.util.Scanner;
public class ZadatakSaPredavanjaNizovi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*napraviti niz koji ce da sadrzi reci.
		 * sve dok korisnik ne unese rec stop traziti da unese neku rec i vratiti
		 * da li ta rec postoji u nizu ili ne. ako postoji vrati i na kom mestu u nizu se nalazi
		 */
		Scanner s= new Scanner (System.in);
		String[] reci= {"jedan", "dva", "tri", "cetiri", "pet"};
		String rec= s.next();
		Boolean[] DaNe= {true, true, true, true, true};
		int i=0;
		while(!rec.equals("stop")) {
			for(i=0;i<reci.length;i++) {
			if(reci[i].equals(rec)) {
				System.out.println("pogodak na poziciji " + i);
				DaNe[i]=false;
				break;
				
				}
			}
			if(i==reci.length)System.out.println("nema reci");
			if(DaNe[0]==false && DaNe[1]==false && DaNe[2]==false && DaNe[3]==false && DaNe[4]==false)
			{System.out.println("Sve reci su pogodjene!");break;}
			rec= s.next();
			
			
	}	System.out.println("kraj");
}
	}

	//za domaci napisati da li je pogodjena svaka rec ili ne koristeci niz[false][false][false];


