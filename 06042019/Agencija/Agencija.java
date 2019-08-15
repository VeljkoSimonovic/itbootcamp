package Agencija;

import java.sql.*;
import java.util.LinkedList;

public class Agencija {
	private String naziv;
	private String DBurl = "jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db";

	public Agencija(String ime) {
		naziv = ime;
	}

	public LinkedList<Ponuda> pretrazi(int maxCena) {
		LinkedList<Ponuda> ponuda = new LinkedList<Ponuda>();
		String upit = "SELECT IdTer, Naziv, Drzava, Od, Do, PreostaloMesta, Cena FROM Skijaliste s, Termin t WHERE s.IdSki=t.IdSki and cena< ? ORDER by cena ASC";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit)) {
			stm.setInt(1, maxCena);

			ResultSet rez = stm.executeQuery();

			while (rez.next()) {
				ponuda.add(new Ponuda(rez.getInt("idTer"), rez.getString("Naziv"), rez.getString("Drzava"),
						rez.getInt("Od"), rez.getInt("Do"), rez.getInt("PreostaloMesta"), rez.getInt("Cena")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return ponuda;
	}

	public LinkedList<Ponuda> pretrazi(String drzava) {
		LinkedList<Ponuda> ponuda = new LinkedList<Ponuda>();
		String upit = "SELECT IdTer, Naziv, Drzava, Od, Do, PreostaloMesta, Cena FROM Skijaliste s, Termin t WHERE s.IdSki=t.IdSki and drzava= ? ORDER by cena ASC";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit)) {
			stm.setString(1, drzava);

			ResultSet rez = stm.executeQuery();

			while (rez.next()) {
				ponuda.add(new Ponuda(rez.getInt("idTer"), rez.getString("Naziv"), rez.getString("Drzava"),
						rez.getInt("Od"), rez.getInt("Do"), rez.getInt("PreostaloMesta"), rez.getInt("Cena")));
			}

		} catch (Exception e) {

		}
		return ponuda;
	}

	public String getNaziv() {
		return naziv;
	}

	public AdminPanel login(String user, String pass) {

		String upit = "SELECT KorIme, Lozinka FROM Administrator";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit)) {
			ResultSet rez = stm.executeQuery();
			if (user.equals(rez.getString("KorIme")) && pass.equals(rez.getString("Lozinka")))
				return new AdminPanel();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
