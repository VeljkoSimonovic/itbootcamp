package AutoProdavnica;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Radnja {

	public static void ispisStanja(String DBurl, int x) {
		LinkedList<AutoPonuda> ponuda = new LinkedList<AutoPonuda>();
		String s = "SELECT radnja.Model, Godiste, Konja, Kubikaza, Tip, Gorivo,  cenaNab, cenaProd, sum(Stanje) from Auto, Radnja where auto.Model=radnja.Model GROUP by Radnja.Model";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(s)) {
			ResultSet rez = stm.executeQuery();
			int i = 0;
			while (rez.next()) {
				ponuda.add(new AutoPonuda(rez.getString("Model"), rez.getInt("Godiste"), rez.getInt("Konja"),
						rez.getInt("Kubikaza"), rez.getString("Tip"), rez.getString("Gorivo"), rez.getInt("cenaNab"),
						rez.getInt("cenaProd"), rez.getInt("sum(Stanje)")));
				if (x == 1)
					System.out.println((i + 1) + " " + ponuda.get(i++).logIspis());
				else if (x == 2)
					System.out.println((i + 1) + " " + ponuda.get(i++).nelogIspis());
				else if (x == 3)
					System.out.println((i + 1) + " " + ponuda.get(i++));
			}
		} catch (Exception e) {

		}
	}

	public static void signup(String DBurl, Scanner n) {
		try (Connection con = DriverManager.getConnection(DBurl);) {
			System.out.println("Unesite Vase Ime i Prezime, User i Sifru");
			PreparedStatement stm = con
					.prepareStatement("INSERT INTO Osoba (Naziv, Tip, User, Pass) VALUES ( ? , 'Kupac', ? , ? )");
			String ime = n.nextLine();
			// ocisti djubre ako ga ima
			if (ime.trim().equals(""))
				ime = n.nextLine();
			// sad line sadrzi validan podatak iz linije
			String user = n.next();
			String pass = n.next();
			stm.setString(1, ime);
			stm.setString(2, user);
			stm.setString(3, pass);
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}

	public static int login(String DBurl, Scanner n, int x) {
		System.out.println("Unesite vas korisnicki nalog i sifru: ");
		String user = n.next();
		String pass = n.next();
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement("SELECT idOsb, Naziv, User, Pass FROM Osoba")) {
			ResultSet rez = stm.executeQuery();
			while (rez.next()) {
				if (x == 0 && user.equals(rez.getString("User")) && pass.equals(rez.getString("Pass"))
						&& !user.equals("admin")) {
					System.out.println(rez.getString("Naziv") + " dobrodosli u Autovelju! Kako mozemo da pomognemo? ");
					return rez.getInt("idOsb");
				}
				if (x == 1 && user.equals(rez.getString("User")) && user.equals("admin")
						&& pass.equals(rez.getString("Pass"))) {
					System.out.println(rez.getString("Naziv") + " opet kasnis na robiju? ");
					return rez.getInt("idOsb");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Pogresan Nalog ili Sifra.");
		return 0;
	}

	public static void kupi(String DBurl, Scanner n, int idO) {
		System.out.println(
				"Unesite Model Automobila, idDobavljaca i Kolicinu, zatim unesite u koliko rata zelite da platite(Ako placate u celosti to je 1 rata)");
		String model = n.nextLine();
		if (model.trim().equals(""))
			model = n.nextLine();
		int dob = n.nextInt();
		int kol = n.nextInt();
		int rata = n.nextInt();
		int iznos = 0;
		int Stanje = 0;
		String upit1 = "SELECT cenaProd, Stanje FROM Auto, Radnja WHERE Radnja.Model=Auto.Model and Radnja.Model= ? and Radnja.Dobavljac="
				+ dob;
		String upit = "INSERT INTO Promet(tipTrans, idOsb, Model,Kolicina, Iznos, brojRata, Dobavljac) VALUES ('Prodaja', ?, ?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(upit1);) {
			stm.setString(1, model);
			ResultSet rez = stm.executeQuery();
			iznos = kol * rez.getInt("CenaProd");
			Stanje = rez.getInt("Stanje");
		} catch (SQLException e) {
			System.out.println("Nemamo Auto od tog Dobavljaca.");
		}
		for (int i = 0; i < 1; i++) {
			try (Connection con = DriverManager.getConnection(DBurl);
					PreparedStatement stm = con.prepareStatement(upit);) {
				if (kol <= Stanje) {
					stm.setInt(1, idO);
					stm.setString(2, model);
					stm.setInt(3, kol);
					stm.setInt(4, iznos);
					stm.setInt(5, rata);
					stm.setInt(6, dob);
					stm.execute();
				}

				else {
					System.out.println("Nema na stanju");
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try (Connection con = DriverManager.getConnection(DBurl)) {
				Statement stm1 = con.createStatement();
				stm1.executeUpdate("UPDATE Radnja SET Stanje=Stanje - " + kol + "  WHERE Model='" + model
						+ "' and Dobavljac=" + dob);
				stm1.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Unesite danasnji datum");
			int dat = n.nextInt();
			String s2 = "SELECT idProm from Promet where idOsb= " + idO + " ORDER by idProm desc LIMIT 1";
			String s1 = "INSERT INTO Rate (idProm, Rata, PreostaleRate, Datum) VALUES (?, ?, ?, ?)";
			int idpro = 0;
			try (Connection con = DriverManager.getConnection(DBurl);
					PreparedStatement stm = con.prepareStatement(s2);) {
				ResultSet rez = stm.executeQuery();
				idpro = rez.getInt("idProm");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try (Connection con = DriverManager.getConnection(DBurl);
					PreparedStatement stm = con.prepareStatement(s1);) {
				stm.setInt(1, idpro);
				stm.setInt(2, iznos / rata);
				stm.setInt(3, rata - 1);
				stm.setInt(4, dat);
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void nabavi(String DBurl, Scanner n) {
		System.out.println("Unesite ID zeljenog dobavljaca, Model Automobila i Kolicinu");
		int dob = n.nextInt();
		String s = n.nextLine().trim();
		if (s.trim().equals(""))
			s = n.nextLine().trim();
		int kol = n.nextInt();
		int iznos = 0;
		String upit1 = "SELECT cenaNab FROM Auto where model= ? ";
		String upit = "INSERT INTO Promet(tipTrans, Model,Kolicina, Iznos, brojRata, Dobavljac) VALUES ('Nabavka', ?, ?, ?, 1, ?)";
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(upit1);) {
			stm.setString(1, s);
			ResultSet rez = stm.executeQuery();
			iznos = kol * rez.getInt("CenaNab");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit);) {
			stm.setString(1, s);
			stm.setInt(2, kol);
			stm.setInt(3, iznos);
			stm.setInt(4, dob);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl)) {
			Statement stm = con.createStatement();
			Statement stm2 = con.createStatement();
			Statement stm3 = con.createStatement();
			ResultSet rez = stm.executeQuery("SELECT Model FROM Radnja WHERE Model='" + s + "'");
			ResultSet rez1 = stm2.executeQuery("SELECT Dobavljac FROM Radnja WHERE Dobavljac=" + dob);
			ResultSet rez2 = stm3
					.executeQuery("SELECT Dobavljac FROM Radnja WHERE Model='" + s + "' and Dobavljac=" + dob);
			Statement stm1 = con.createStatement();

			for (int i = 0; i < 1; i++) {
				if (rez.isClosed()) {
					stm1.executeUpdate("INSERT INTO Radnja (Model, Stanje, Dobavljac) VALUES ('" + s + "'," + kol + ","
							+ dob + ")");
					break;
				}
				if (rez1.isClosed()) {
					stm1.executeUpdate("INSERT INTO Radnja (Model, Stanje, Dobavljac) VALUES ('" + s + "'," + kol + ","
							+ dob + ")");
					break;
				}

				if (rez2.isClosed()) {
					stm1.executeUpdate("INSERT INTO Radnja (Model, Stanje, Dobavljac) VALUES ('" + s + "'," + kol + ","
							+ dob + ")");
					break;
				}

				if (rez1.getInt("Dobavljac") == dob && rez.getString("Model").equals(s)) {
					stm1.executeUpdate("UPDATE Radnja SET Stanje=Stanje+ " + kol + "  WHERE Model='" + s
							+ "' and Dobavljac=" + dob);
					break;
				}
			}
			stm.close();
			stm1.close();
			stm2.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void platiRatu(String DBurl, Scanner n, int x) {
		int ostaloRata = -1;
		int idProm = -1;
		int rata = -1;
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(
						"select idRate, Rate.idProm, Rata, PreostaleRate, Datum from Rate, Promet, Osoba where rate.idProm=Promet.idProm and promet.idOsb="
								+ x + " group by Rate.idProm");) {
			ResultSet rez = stm.executeQuery();
			System.out.println("Vase neisplacene rate su: ");
			while (rez.next()) {
				System.out.println("ID Prometa " + rez.getInt("idProm") + " Iznos 1 rate: " + rez.getInt("Rata")
						+ " Ostalo " + rez.getInt("PreostaleRate") + " Rata " + " Uplaceno: " + rez.getInt("Datum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl)) {
			System.out.println("Unesite ID Prometa za koji zelite da uplatite ratu: ");
			idProm = n.nextInt();
			PreparedStatement stm1 = con.prepareStatement(
					"select min(PreostaleRate), Rata from Rate, Promet, Osoba where rate.idProm=Promet.idProm and promet.idOsb="
							+ x + " and promet.idProm=" + idProm);
			ResultSet rez = stm1.executeQuery();
			ostaloRata = rez.getInt("min(PreostaleRate)");
			rata = rez.getInt("Rata");
			System.out.println("Preostalo rata " + ostaloRata);
			stm1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con
						.prepareStatement("INSERT INTO Rate ( idProm, Rata, PreostaleRate, Datum) VALUES (" + idProm
								+ ", " + rata + ", ? , ? )")) {
			if (ostaloRata == 0)
				System.out.println("Isplatili ste sve rate za ovaj promet.");
			else {
				System.out.println("Datum uplate rate: ");
				stm.setInt(2, n.nextInt());
				stm.setInt(1, --ostaloRata);
				stm.execute();
			}
			stm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void autoPoKupcu(String DBurl, Scanner n) {
		System.out.println("Unesite ID Kupca");
		int x = n.nextInt();
		String s = "SELECT  Naziv, Model, sum(DISTINCT Kolicina) from Promet, Osoba where tipTrans='Prodaja' and Promet.idOsb=Osoba.idOsb and Promet.idOsb="
				+ x + " group by Model";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(s);) {
			ResultSet rez = stm.executeQuery();
			if (rez.isClosed())
				System.out.println("Nepostojeci Kupac.");
			else {
				System.out.println(rez.getString("Naziv") + ": \n");
				while (rez.next()) {
					System.out.println(rez.getString("Model") + " Kolicina: " + rez.getInt("sum(DISTINCT Kolicina)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void autoPoDobavljacu(String DBurl, Scanner n) { // metoda vrsi pretragu po tabeli promet
		System.out.println("Unesite ID Dobavljaca");
		int x = n.nextInt();
		String s = "SELECT  Naziv, Model, sum(DISTINCT Kolicina) from Promet, Osoba where tipTrans='Nabavka' and Promet.idOsb=Osoba.idOsb and Promet.idOsb="
				+ x + " group by Model";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(s);) {
			ResultSet rez = stm.executeQuery();

			if (rez.isClosed())
				System.out.println("Nepostojeci dobavljac.");
			else {
				System.out.println(rez.getString("Naziv") + ": \n");
				while (rez.next()) {
					System.out.println(rez.getString("Model") + " Kolicina: " + rez.getInt("sum(DISTINCT Kolicina)"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void stanje(String DBurl) {
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con
						.prepareStatement("select model, stanje, Dobavljac from radnja order by Model");) {
			ResultSet rez = stm.executeQuery();
			while (rez.next()) {
				System.out.println(rez.getString("Model") + " Kolicina: " + rez.getInt("Stanje") + " Dobavljac: "
						+ rez.getInt("Dobavljac"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void modifikujCene(String DBurl, Scanner n) {
		System.out
				.println("Unesite Model ciju cenu zelite menjati i procentualni udeo za koliko zelite da promenite: ");
		String mod = n.nextLine();
		// ocisti djubre ako ga ima
		if (mod.trim().equals(""))
			mod = n.nextLine();
		double procenat = n.nextDouble();
		String upit = "update Auto set cenaProd=cenaProd + (cenaProd * ? ) where Model= ? ";
		try (Connection con = DriverManager.getConnection(DBurl); PreparedStatement stm = con.prepareStatement(upit)) {
			stm.setDouble(1, procenat);
			stm.setString(2, mod);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void profit(String DBurl, Scanner n) {
		System.out.println("Unesite Model za koji zelite da vidite broj prodatih, kupljenih i profit: ");
		String mod = n.nextLine();
		// ocisti djubre ako ga ima
		if (mod.trim().equals(""))
			mod = n.nextLine();
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(
						"SELECT model, sum(DISTINCT kolicina) from Promet where tipTrans='Nabavka' and Model= ? group by Model")) {
			stm.setString(1, mod);
			ResultSet rez = stm.executeQuery();
			System.out.println("Nabavljeno: " + rez.getString("model") + " " + rez.getInt("sum(DISTINCT kolicina)"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(
						"SELECT model, sum(DISTINCT kolicina) from Promet where tipTrans='Prodaja' and Model= ? group by Model")) {
			stm.setString(1, mod);
			ResultSet rez = stm.executeQuery();
			System.out.println("Prodato: " + rez.getString("model") + " " + rez.getInt("sum(DISTINCT kolicina)"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int iznos = 0;
		int kol = 0;
		int nabCena = 0;
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement(
						"Select sum(Iznos), sum(Kolicina) from promet where model= ? and tipTrans='Prodaja'")) {
			stm.setString(1, mod);
			ResultSet rez = stm.executeQuery();
			iznos = rez.getInt("sum(Iznos)");
			kol = rez.getInt("sum(Kolicina)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(DBurl);
				PreparedStatement stm = con.prepareStatement("select cenaNab from Auto where model= ? ")) {
			stm.setString(1, mod);
			ResultSet rez = stm.executeQuery();
			nabCena = rez.getInt("cenaNab");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Profit of prodatih " + mod + " = " + (iznos - nabCena * kol));
	}

//----------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		String DBurl = "jdbc:sqlite:C:\\Users\\User\\Downloads\\AutoRadnja.db";
		while (true) {
			System.out.println(
					"Dobrodosli u AutoVelju, vaseg najpouzdanijeg AutoDilera! \n Ko ulazi u radnju? \n 1 - Kupac\n 2 - Prodavac\n-1 - Kraj programa");
			int x = n.nextInt();
			if (x == 1) {
				System.out.println("1 - Uloguj se\n2 - Kreiraj nalog\n3 - Samo razgledam");
				x = n.nextInt();
				switch (x) {
				case 1:
					int y = login(DBurl, n, 0);
					if (y != 0) {
						while (true) {
							System.out.println(
									"1 - Gledaj ponudu\n2 - Gledaj karakteristike Automobila u ponudi\n3 - Kupi Automobil\n4 - Plati Ratu\n5 - Idi kuci");
							x = n.nextInt();
							if (x == 1)
								stanje(DBurl);
							if (x == 2)
								ispisStanja(DBurl, 1);
							if (x == 3)
								kupi(DBurl, n, y);
							if (x == 4)
								platiRatu(DBurl, n, y);
							if (x == 5)
								break;
						}
					} else
						continue;
					break;
				case 2:
					signup(DBurl, n);
					break;
				case 3:
					while (true) {
						System.out.println("1 - Razgledaj\n2 - Idi kuci");
						x = n.nextInt();
						if (x == 1)
							ispisStanja(DBurl, 2);
						if (x == 2)
							break;
					}
				}
				continue;
			} else if (x == 2) {
				int z = login(DBurl, n, 1);
				if (z != 0) {
					while (true) {
						System.out.println(
								"1 - Menjaj cene\n2 - Nabavka\n3 - Profit\n4 - Prodato Auta po Kupcu\n5 - Nabavljeno Auta po Dobavljacu\n6 - Ispis stanja\n7 - Idi kuci");
						x = n.nextInt();
						if (x == 1)
							modifikujCene(DBurl, n);
						if (x == 2)
							nabavi(DBurl, n);
						if (x == 3)
							profit(DBurl, n);
						if (x == 4)
							autoPoKupcu(DBurl, n);
						if (x == 5)
							autoPoDobavljacu(DBurl, n);
						if (x == 6)
							ispisStanja(DBurl, 3);
						if (x == 7)
							break;
					}
				} else
					continue;
			} else if (x == -1) {
				break;
			} else
				System.out.println("Pogresna komanda pokusajte ponovo. ");
		}
	}
}
