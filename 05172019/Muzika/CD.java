package Muzika;

public class CD extends AlbumArtikal{
	public CD(Album alb, String izd, double cen, int kol) {
		super(alb, izd, cen, kol);
		alb=getAlbum();
		izd=getIzdavac();
		cen=getCena();
		kol=getKolicina();
		
	}
	public String ime(){		
		String str= getAlbum().getIzvodjac() + " - " + getAlbum().getNaziv() + " (CD)";
		return str;
	}

}
