package Agencija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class KorisnickiPanel {
	private int idKor;
		public KorisnickiPanel(int id) {
			idKor=id;
		}
		public LinkedList<Ponuda> mojaPutovanja() {
			String upit="select termin.IdTer, Naziv, Drzava, Od, Do from Termin, Skijaliste, Putuje where termin.IdTer=Putuje.IdTer and termin.IdSki=Skijaliste.IdSki and IdOsobe= ?";
			LinkedList<Ponuda> putovanja=new LinkedList<Ponuda>();
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db"); PreparedStatement stm = con.prepareStatement(upit)) {
				stm.setInt(1, idKor);
				ResultSet rez = stm.executeQuery();
				while(rez.next()) {
					putovanja.add(new Ponuda(rez.getInt("IdTer"),rez.getString("Naziv"), rez.getString("Drzava"), rez.getInt("Od"), rez.getInt("Do")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return putovanja;
		}
		public void ukloni(Ponuda p) {
			String upit="delete from Putuje where IdOsobe= ? and IdTer= ?";
			try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db"); PreparedStatement stm = con.prepareStatement(upit)) {
				stm.setInt(1, idKor);
				stm.setInt(2, p.getIdTerm());
				stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
