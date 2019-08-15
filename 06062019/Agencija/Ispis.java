package Agencija;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Ispis {
	public static void main(String[] args) {

		Agencija agencija = new Agencija("ZimoTurs");
		List<Ponuda> p = agencija.pretrazi("Bugarska");
		p.get(0).zakupi("Marko", "Kraljevic", "064987678");
		p.get(0).zakupi("Jovanka", "Orleanka", "066555666");
		p.get(0).zakupi("Jug", "Bogdan", "063853657");
		AdminPanel panel = agencija.login("admin", "admin");
		panel.stampajOsobe(p.get(0).getIdTerm());

	}
}
