package SalterskaSluzba;

public class Salter {
	private CustomList ulazna;
	private CustomList redA;
	private CustomList redB;
	private CustomList redC;
	private Portir portir;
	private Razvodnik razvodnik;
	private SalterskiSluzbenik sluz1;
	private SalterskiSluzbenik sluz2;
	private SalterskiSluzbenik sluz3;
	public Salter() {
		ulazna=new CustomList();
		portir=new Portir();
		razvodnik=new Razvodnik();
		sluz1=new SalterskiSluzbenik();
		sluz2=new SalterskiSluzbenik();
		sluz3=new SalterskiSluzbenik();
		redA=new CustomList();
		redB=new CustomList();
		redC=new CustomList();
	}
	public void rad(int x) {
		for (int i = 0; i < x; i++) {
			double y=Math.random();
			if(y>=0&&y<0.2) {
				if(portir.aktivnost(ulazna, null))System.out.println(portir);
			}
			if(y>=0.2&&y<0.4) {
				char c=' ';
				if(ulazna.duzina()>0)
				c=ulazna.uzmi(0).getUsluga();
				if(c=='a') {
					if(razvodnik.aktivnost(ulazna, redA))System.out.println(razvodnik);
				}
                if(c=='b') {
                	if(razvodnik.aktivnost(ulazna, redB))System.out.println(razvodnik);
				}
                if(c=='c') {
                	if(razvodnik.aktivnost(ulazna, redC))System.out.println(razvodnik);
                }
			
			}
			if(y>=0.4&&y<0.6) {
				if(sluz1.aktivnost(redA, null))System.out.println(sluz1);
			}
			if(y>=0.6&&y<0.8) {
				if(sluz2.aktivnost(redB, null))System.out.println(sluz2);
			}
			if(y>=0.8&&y<=1) {
				if(sluz3.aktivnost(redC, null))System.out.println(sluz3);
			}
		}
	}
	public String toString() {
			return "Ulazna\n"+ulazna+"\nRed A\n"+redA+"\nRed B\n"+redB+"\nRed C\n"+redC;
		}
}
