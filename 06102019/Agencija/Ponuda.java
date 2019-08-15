package Agencija;

import java.sql.*;

public class Ponuda {
	private int idTerm;
	private String naziv;
	private String drzava;
	private int datumOd;
	private int datumDo;
	private int preostaloMesta;
	private int cena;

	public Ponuda(int id, String ime, String drz, int Od, int Do, int mesta, int cen) {
		idTerm = id;
		naziv = ime;
		drzava = drz;
		datumOd = Od;
		datumDo = Do;
		preostaloMesta = mesta;
		cena = cen;
	}
	public Ponuda(int id, String ime, String drz, int Od, int Do) {
		idTerm = id;
		naziv = ime;
		drzava = drz;
		datumOd = Od;
		datumDo = Do;
	}

	public boolean zakupi(int x) {
		if (preostaloMesta > 0) {
			String upit = "update Termin set PreostaloMesta=PreostaloMesta-1 where IdTer= ? ";
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db")) {
				PreparedStatement stm = con.prepareStatement(upit);
				stm.setInt(1, idTerm);
				stm.execute();
				upit = "insert INTO Putuje (IdOsobe, IdTer) VALUES ( ? , ?)";
				stm = con.prepareStatement(upit);
				stm.setInt(1, x);
				stm.setInt(2, idTerm);
				stm.execute();
				stm.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			return true;
		} else
			return false;
	}

	public int getIdTerm() {
		return idTerm;
	}

	public String toString() {
		return "(" + idTerm + ") " + naziv + "(" + drzava + ") " + datumOd + " - " + datumDo + " / " + cena + "€ : "
				+ preostaloMesta + ".";
	}
	public String ispisPutovanja() {
		//Sluzi za ispisivanje putovanja korisniku, bez cene i preostalih mesta
		return "(" + idTerm + ") " + naziv + "(" + drzava + ") " + datumOd + " - " + datumDo;
	}

	public boolean zakupi(String ime, String prezime, String telefon) {
		if (preostaloMesta > 0) {
			String upit = "update Termin set PreostaloMesta=PreostaloMesta-1 where IdTer= ? ";
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db")) {
				PreparedStatement stm = con.prepareStatement(upit);
				stm.setInt(1, idTerm);
				stm.execute();
				upit = "INSERT INTO Osoba (Ime, Prezime, Kontakt) VALUES ( ? , ? , ? )";
				stm = con.prepareStatement(upit);
				stm.setString(1, ime);
				stm.setString(2, prezime);
				stm.setString(3, telefon);
				stm.execute();
				upit = "select IdOsobe from Osoba where Kontakt= ? ";
				stm = con.prepareStatement(upit);
				stm.setString(1, telefon);
				ResultSet rez = stm.executeQuery();
				upit = "insert INTO Putuje (IdOsobe , IdTer) VALUES ( ? , ?)";
				stm = con.prepareStatement(upit);
				stm.setInt(1, rez.getInt(1));
				stm.setInt(2, idTerm);
				stm.execute();
				stm.close();
			} catch (Exception e) {
			}

			return true;
		} else
			return false;
	}

}
