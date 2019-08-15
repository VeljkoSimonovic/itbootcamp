package Muzika;

public class LP extends AlbumArtikal{
		private int tezina;
		
		public LP(Album alb, String izd, double cen, int kol, int tez) {
			super(alb, izd, cen, kol);
			alb=getAlbum();
			izd=getIzdavac();
			cen=getCena();
			kol=getKolicina();
			tezina=tez;
		}
		public String ime(){		
			String str= getAlbum().getIzvodjac() + " - " + getAlbum().getNaziv() + " (" + tezina + "[g] LP)";
			return str;
		}
		
}
