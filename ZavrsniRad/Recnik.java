package ZavrsniRad;

import java.util.HashMap;
import java.sql.*;

public class Recnik {
	private HashMap<String, String> recnik=new HashMap<String, String>();
	private String DBurl ="jdbc:sqlite:C:\\Users\\User\\Downloads\\Dictionary.db";

	public Recnik() {
		ucitajRecnik();
	}

	public void ucitajRecnik() {
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement("select word, definition FROM entries")) {
			ResultSet rez = stm.executeQuery();
			while (rez.next()) {
				recnik.put(rez.getString("word").toLowerCase(), rez.getString("definition").toLowerCase());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		String str="";
		for(String s:recnik.keySet()) {
			str+=s+"\n";
		}
		return str;
	}
	public HashMap<String, String> uzmiRecnik(){
		return recnik;
	}
	
}
