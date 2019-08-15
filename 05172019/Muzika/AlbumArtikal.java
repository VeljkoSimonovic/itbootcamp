package Muzika;

public abstract class AlbumArtikal extends Artikal{
		private String izdavac;
		private Album album;
		
		
		public AlbumArtikal(Album alb, String izd, double cen, int kol) {
				super(cen, kol);
				izdavac=izd;
				album=alb;
		}
		public abstract String ime();
		public String getIzdavac() {
			return izdavac;
		}
		public Album getAlbum() {
			return album;
		} 
		
	
	
	
	
	

}
