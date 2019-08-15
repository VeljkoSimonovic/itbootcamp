package Stringovanje;

import java.util.Scanner;

public class Stringovic {
public static StringBuilder ukloniChar(String s, char c) {
	StringBuilder str=new StringBuilder(s);
	for (int i = str.length()-1; i >= 0; i--) {
		if(str.charAt(i)==c)str.deleteCharAt(i);
	}
	return str;
}
public static String obrniReci(String s) {
	String[]str=s.split(" ");
	s="";
	for (int i = 0; i < str.length; i++) {
		String pom="";
		for (int j = str[i].length()-1; j >=0 ; j--) {
			pom+=str[i].charAt(j);
		}
		s+=(pom+" ");
	}
	return s;
}
public static String duplikati(String s) {
	StringBuilder str=new StringBuilder(s);
	s="";
	for (int i = str.length()-1, x=0; i >=0; i--, x=0) {
		for (int j = str.length()-1; j >=0; j--) {
			if(str.charAt(i)==str.charAt(j)) x++;
			if(x>1&&str.charAt(i)==str.charAt(j)) str.setCharAt(j, '*');
		}
		if(x>1&&str.charAt(i)!='*') {
			s+=(str.charAt(i)+":"+x+" ");
		}
	}
	return s;
}
public static void satrovacki(String s, String s1) {
	boolean b=false;
	String str=s+s;
	if(s.length()!=s1.length()) {System.out.println(b);return;}
	if(s.equals(s1)) {System.out.println(b+" Reci su iste.");return;}
	if(str.contains(s1)) b=true;
	else {System.out.println(b);return;}
		if(b) {
			int x=0;
			for (int i = 0; i < s.length(); i++) {
				if(s1.contains(s.substring(0, i)))x=s.substring(0, i).length();
				else {System.out.println(b+", "+x);return;}
			}
			System.out.println(b+", "+s.length()/2);
		}
	}
public static void palindrom(String s) {
	boolean b=true;
	for (int i = s.length()-1, j=0; i >=0 ; i--,j++) {
		if(s.charAt(i)!=s.charAt(j)) {System.out.println(!b);return;}
	}
	System.out.println(b);
}
public static StringBuilder cezar(String s, int x) {
	StringBuilder str=new StringBuilder(s);
	for (int i = 0; i<str.length(); i++) {
		if(str.charAt(i)!=' ')
		str.setCharAt(i, (char)(((int)str.charAt(i) + x - 97) % 26 + 97));             
	}
	return str;
}
public static void main(String[] args) {
		System.out.println(ukloniChar("Ala je lep ovaj svet", 'e'));
		System.out.println(obrniReci("danas je divan dan"));
		System.out.println(duplikati("programiranje"));
		satrovacki("programiranje", "gramiranjepro");
		palindrom("anavolimilovana");
		palindrom("danasjelepdan");
		System.out.println(cezar("danas je lep dan", 13));
	}
}