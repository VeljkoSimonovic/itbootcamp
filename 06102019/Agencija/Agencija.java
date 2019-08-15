package Agencija;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

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

	public AdminPanel loginAdmin(String user, String pass) {

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
	public KorisnickiPanel loginKorisnik(String user, String pass) {

		String upit = "SELECT KorIme, IdOsobe, Lozinka FROM Korisnik";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit)) {
			ResultSet rez = stm.executeQuery();
			if (user.equals(rez.getString("KorIme")) && pass.equals(rez.getString("Lozinka")))
				return new KorisnickiPanel(rez.getInt("IdOsobe"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public void registrujKorisnika(Scanner n) {//metoda dodata da se iz jave registruju korisnici koji su u bazi, ili dodaju od nule ako nisu(da ne bi rucno popunjavali tabelu u DBbrowseru)
		String upit="";
		try(Connection con = DriverManager.getConnection(DBurl)){
		PreparedStatement stm = null;
		String s="1 - Ako ste vec u bazi korisnika.\n2 - Ako ste prvi put kod nas. ";
		System.out.println(s);
		int x=n.nextInt();
		switch(x) {
		case 1:
			upit="INSERT INTO Korisnik VALUES(?,?,?)";
			System.out.println("Unesite vas ID, Username i Sifru: ");
			stm=con.prepareStatement(upit);
				stm.setInt(2, n.nextInt());
				stm.setString(1, n.next());
				stm.setString(3, n.next());
				stm.execute();		
				break;
		case 2:
			System.out.println("Unesite vase Ime i Prezime i Broj telefona: ");
			String[] imepre=new String[2];
			String str=n.nextLine().trim();
			if(str.trim().equals(""))str=n.nextLine();
			imepre=str.split(" ");		
			upit = "INSERT INTO Osoba (Ime, Prezime, Kontakt) VALUES ( ? , ? , ? )";
			stm=con.prepareStatement(upit);
			stm.setString(1, imepre[0]);
			stm.setString(2, imepre[1]);
			stm.setString(3, n.nextLine());
			stm.executeUpdate();			
			ResultSet rez=stm.getGeneratedKeys();
			upit = "INSERT INTO Korisnik VALUES(?,?,?)";
			stm=con.prepareStatement(upit);
			System.out.println("Unesite vas Username i Sifru: ");		
				stm.setInt(2, rez.getInt(1));
				stm.setString(1, n.next());
				stm.setString(3, n.next());
				stm.execute();		
				break;
	    default:System.out.println("Nepostojeca komanda pokusajte ponovo: \n"+s);

		}
		} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
