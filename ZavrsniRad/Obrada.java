package ZavrsniRad;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;


public class Obrada {
	public static void recnikUpdate(Recnik recnik, Knjiga knjiga) {
		String brisi = "DROP TABLE IF EXISTS \"recnikplus\";";
		String stvori = "CREATE TABLE \"recnikplus\" (\r\n" + "	\"id\"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "	\"word\"	TEXT NOT NULL)";
		String ubaci = "INSERT INTO recnikplus (word) VALUES ( ? )";
		String DBurl = "jdbc:sqlite:C:\\Users\\User\\Downloads\\Dictionary.db";
		try (Connection con = DriverManager.getConnection(DBurl)) {
			PreparedStatement stm = con.prepareStatement(brisi);
			stm.execute();
			stm = con.prepareStatement(stvori);
			stm.execute();
			for (String str : knjiga.uzmiReci().keySet()) {
				if (!recnik.uzmiRecnik().containsKey(str)) {
					stm = con.prepareStatement(ubaci);
					stm.setString(1, str);
					stm.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void ponavljanje(Recnik recnik, Knjiga knjiga) {
		
		int brojac = 0;
		try {
			FileWriter fw = new FileWriter("ponavljanje.txt");
			for (String s : recnik.uzmiRecnik().keySet()) {
				brojac = Collections.frequency(knjiga.uzmiSveReci().values(), s);
				fw.append(s + " " + brojac + "\n");
				
			}
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void upisiUsql(Recnik recnik, Knjiga knjiga) {
		String komb = "select words from recnikplus";
		String ubaci = "INSERT INTO entries VALUES( ? , 'iz knjige', 'iz knjige', -1)";
		String DBurl = "jdbc:sqlite:C:\\Users\\User\\Downloads\\Dictionary.db";
		try (Connection con = DriverManager.getConnection(DBurl)) {
			PreparedStatement stm = con.prepareStatement(komb);
			ResultSet rez = stm.executeQuery();
			while (rez.next()) {
				stm = con.prepareStatement(ubaci);
				stm.setString(1, rez.getString("words"));
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void upisiUfajl() {
		String DBurl = "jdbc:sqlite:C:\\Users\\User\\Downloads\\Dictionary.db";
		String trazi = "select word from entries order by word ASC";

		try (Connection con = DriverManager.getConnection(DBurl)) {
			FileWriter fw = new FileWriter("leksiReci.txt");
			PreparedStatement stm = con.prepareStatement(trazi);
			ResultSet rez = stm.executeQuery();
			while (rez.next()) {
				fw.append(rez.getString("word") + "\n");
			}
			fw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void najponavljanijeReci(Knjiga knjiga) {
		int brojac = 0;
		for (String s : knjiga.uzmiReci().keySet()) {
			brojac = Collections.frequency(knjiga.uzmiSveReci().values(), s);
			knjiga.uzmiReci().put(s, brojac);
		}
		HashMap<Integer, String> sortirano = new HashMap<Integer, String>();
		for (String s : knjiga.uzmiReci().keySet()) {
			sortirano.put(knjiga.uzmiReci().get(s), s);
		}
		try {
			FileWriter fw = new FileWriter("top20.txt");
			for (int i = 0; i < 20; i++) {
				int max = Collections.max(sortirano.keySet());
				fw.append(i + 1 + " " + sortirano.get(max) + " " + max + "\n");
				fw.flush();
				sortirano.remove(max);			
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Recnik recnik = new Recnik();
		Knjiga knjiga = new Knjiga();
		ponavljanje(recnik, knjiga);
	}

}
