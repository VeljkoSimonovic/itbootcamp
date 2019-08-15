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

	public boolean zakupi() {
		if (preostaloMesta > 0) {
			String upit = "update Termin set PreostaloMesta=PreostaloMesta-1 where IdTer= ? ";
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db");
					PreparedStatement stm = con.prepareStatement(upit)) {
				stm.setInt(1, idTerm);
				stm.execute();
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

}
