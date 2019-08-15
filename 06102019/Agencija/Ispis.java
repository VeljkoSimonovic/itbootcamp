package Agencija;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ispis {
	public static void main(String[] args) {
        Scanner n=new Scanner(System.in);
		Agencija agencija = new Agencija("ZimoTurs");
		agencija.registrujKorisnika(n);//zarad uspesnog testiranja uneti user i sifru hardkodovanu u liniji 17
		LinkedList<Ponuda> p=agencija.pretrazi("Francuska");
		p.get(0).zakupi(4);
		p.get(1).zakupi(4);
		p.get(2).zakupi(4);
		KorisnickiPanel k=agencija.loginKorisnik("test", "1234")	;	
        LinkedList<Ponuda> putovanja=k.mojaPutovanja();
        for(int i=0;i<putovanja.size();i++) {
        	System.out.println(putovanja.get(i).ispisPutovanja());
        }
        k.ukloni(putovanja.get(0));
        putovanja=k.mojaPutovanja();
        for(int i=0;i<putovanja.size();i++) {
        	System.out.println(putovanja.get(i).ispisPutovanja());
        }
      
	}
}
