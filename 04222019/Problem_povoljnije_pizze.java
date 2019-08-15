package bg;

public class Problem_povoljnije_pizze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Za varijable koristio sam skracenice koje se odnose na artikal u pitanju
		//cmpp=cap. mala poluprecnik, cmdin=cap. mala cena etc.
		//varijable sa prefiskom z poput zpcm, zppp, su rezultati koji ce biti zaokruzeni u prikazu
		double cmpp=23, cmdin=170, cvpp=40, cvdin=750, cpdin=150, pi=3.14159;
		double pcm=cmpp*cmpp*pi;
	    double pcv=cvpp*cvpp*pi;
	    double ppp=pcv/5;
	    double zpcm = Math. round(pcm * 100.0) / 100.0;
	    double zppp = Math. round(ppp * 100.0) / 100.0;
	    double zmpd= Math. round(pcm/cmdin * 100.0) / 100.0;
	    double zppd = Math. round(ppp/cpdin * 100.0) / 100.0;
		
	    System.out.println("Povrsina male:    " + zpcm + "  cm² " + "  cena: " + cmdin + " din   " + "cm² po dinaru: " + zmpd + "cm²");
		System.out.println("Povrsina parceta: " + zppp + " cm² " + "  cena: " + cpdin + " din   " + "cm² po dinaru: " + zppd + "cm²");
		
		if(zmpd>zppd) {
			System.out.println("Mala pizza je isplativija!");
		}else {
			System.out.println("Parce pizze je isplativije!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
