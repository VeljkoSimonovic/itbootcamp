package Agencija;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Ispis {

	private static void simulacijaImpl(Agencija agencija, String pocetnaPoruka, LinkedList<Ponuda> ponuda) {
		System.out.println("-- Osoba ulazi u turisticku agenciju " + agencija.getNaziv() + " --");
		System.out.println("Osoba: Dobar dan! " + pocetnaPoruka + " Sta imate u ponudi?");
		if (ponuda.size() == 0) {
			System.out.println("Prodavac: Nazalost nemamo to u ponudi :(");
			System.out.println("Osoba: I vi ste mi neka agencija...!");
		} else {
			System.out.println("Prodavac: Ponuda za trazeni upit je sledeca");
			for (int i = 0; i < ponuda.size(); i++)
				System.out.println(" " + ponuda.get(i));
			boolean zakupio = false;
			while (ponuda.size() > 0 && !zakupio) {
				System.out.println("Osoba: Zakupicu termin -- " + ponuda.get(0));
				zakupio = ponuda.get(0).zakupi();
				if (!zakupio) {
					System.out.println("Prodavac: Nazalost nemamo mesta u tom terminu :(");
					ponuda.remove(0);
				}
			}
			if (zakupio) {
				System.out.println("Prodavac: Zakupljeno!");
				System.out.println("Osoba: Hvala! Nadam se da ce provod biti odlican!");
			} else {
				System.out.println("Osoba: I vi ste mi neka agencija...!");
			}
		}
		System.out.println();
	}

	public static void simulacija(Agencija agencija, String drzava) throws SQLException {
		simulacijaImpl(agencija, String.format("%s je moja odabrana zemlja zimovanja!", drzava),
				agencija.pretrazi(drzava));
	}

	public static void simulacija(Agencija agencija, int maxCena) throws SQLException {
		simulacijaImpl(agencija, String.format("Zanimaju me ponude do %d€.", maxCena), agencija.pretrazi(maxCena));

	}
//---------------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		try {
			Agencija agencija = new Agencija("ZimoTurs");
			AdminPanel panel = agencija.login("admin", "admin");
			if(panel != null) {
			panel.modifikujCene(0.14);
			List<Ponuda> p = agencija.pretrazi("Bugarska");
			if(p.size() == 0)
			throw new SQLException("Nema Bugarske u bazi!");
			System.out.println(p.get(0));
			panel.ukloni(p.get(0).getIdTerm());
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
}
