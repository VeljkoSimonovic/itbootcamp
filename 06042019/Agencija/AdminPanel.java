package Agencija;
import java.sql.*;
public class AdminPanel {
	public void modifikujCene(double procenat) {
		String upit = "update Termin set cena=cena + (cena* ? )";
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db");
				PreparedStatement stm = con.prepareStatement(upit)) {
			stm.setDouble(1, procenat);
				
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}
	public void ukloni(int idTer) {
		String upit = "delete FROM Termin where IdTer= ? ";
		try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\Downloads\\Agencija.db");
				PreparedStatement stm = con.prepareStatement(upit)) {
				stm.setInt(1, idTer);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}		
		
	}
}
