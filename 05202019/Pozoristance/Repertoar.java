package Pozoristance;
import java.util.Scanner;
import java.util.LinkedList;

public class Repertoar {
	private Pozoriste pozoriste;
	private LinkedList<Predstava> predstave=new LinkedList<Predstava>();
	
	public Repertoar(Pozoriste p) {
		pozoriste=p;
	}
	public void dodaj(Predstava p) {
		predstave.add(p);
	}
	public void ukloni() {
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite ime predstave koju zelite da uklonite: ");
		String ime=s.nextLine();
		for(int i=0;i<predstave.size();i++) {
			if(predstave.get(i).getNaziv().toLowerCase().contains(ime))predstave.remove(i);
	   }
	}
	public String toString() {
		String str1="";
		for(int i=0;i<predstave.size();i++) {
			str1+="\n" + predstave.get(i);
		}
		String str=pozoriste.getId() + " " + pozoriste.getNaziv() + ": " + str1;
		return str;
	}

}
