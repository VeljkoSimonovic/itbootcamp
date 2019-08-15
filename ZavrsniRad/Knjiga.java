package ZavrsniRad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Knjiga{
	private HashMap<String, Integer> reci = new HashMap<String, Integer>();
	private HashMap<Integer, String> sveReci = new HashMap<Integer, String>();

	public Knjiga() {
		izvadiReci();
		izvadiSveReci();
	}

	public void izvadiReci() {
		int x = 1;
		try (BufferedReader br = new BufferedReader(new FileReader("knjiga.txt"))) {
			while (br.ready()) {
				String[] str = br.readLine().toLowerCase().split("\\W+");
				for (int i = 0; i < str.length; i++) {
					if (!str[i].equals("") && !jelBroj(str[i]))
						reci.put(str[i], x);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void izvadiSveReci() {
		//("[,\\.\\?!:;\\-*() ]")
		//("\\P{Alpha}+")
		//("\\W+")
		int x = 1;
		try (BufferedReader br = new BufferedReader(new FileReader("knjiga.txt"))) {
			while (br.ready()) {
				String[] str = br.readLine().toLowerCase().split("\\W+");
				for (int i = 0; i < str.length; i++) {
					if (!str[i].equals("")&&!jelBroj(str[i]))
						sveReci.put(x++, str[i]);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public String toString() {
		String str = "";
		for (String s : reci.keySet()) {
			str += s + " " + reci.get(s)+"\n";
		}
		return str;
	}
	public static boolean jelBroj(String str) {
	    try {
	        double d = Double.parseDouble(str);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	public HashMap<String, Integer> uzmiReci(){
		return reci;
	}
	public HashMap<Integer, String> uzmiSveReci(){
		return sveReci;
	}
}
