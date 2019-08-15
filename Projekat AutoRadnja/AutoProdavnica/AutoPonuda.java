package AutoProdavnica;
//SELECT auto.Model, Godiste, Konja, Kubikaza, Tip, Gorivo, cenaNab, Stanje from Auto, Radnja where auto.Model=radnja.Model GROUP by Auto.Model
public class AutoPonuda {
	private String Model;
	private int Godiste;
	private int Konja;
	private int Kubikaza;
	private String Tip;
	private String Gorivo;
	private int cenaPro;
	private int cenaNab;
	private int Stanje;
		public AutoPonuda(String mod, int god, int konj, int kub, String tip, String gor, int cenP,  int cen, int Stanj) {
			Model=mod;
			Godiste=god;
			Konja=konj;
			Kubikaza=kub;
			Tip=tip;
			Gorivo=gor;
			cenaPro=cenP;
			cenaNab=cen;
			Stanje=Stanj;	
		}
		public String toString() {
			return Model + " " + Godiste + "god. " + Konja +"hp " + Kubikaza + "cc " +  Tip + " " + Gorivo + " Prodajna: " + cenaPro + " Nabavna: "  + cenaNab + " " + Stanje + "kom.";
		}
		public String logIspis() {
			return Model + " " + Godiste + "god. " + Konja +"hp " + Kubikaza + "cc " +  Tip + " " + Gorivo + " Prodajna: " + cenaPro;
			
		}
		public String nelogIspis() {
			return Model + " " + Godiste + "god. " + Konja +"hp " + Kubikaza + "cc ";
		}
}
