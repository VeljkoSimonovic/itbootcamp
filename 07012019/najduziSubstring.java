package SubString;

import java.util.Scanner;

public class najduziSubstring {
public static boolean ponavljanja(String s1) {
	for (int i = 0; i < s1.length(); i++) {
		for (int j = 0; j < s1.length(); j++) {
			if(s1.charAt(i)==s1.charAt(j)&&i!=j)return false;
		}
	}
	return true;
}
public static String najduziString(String s) {
	String s1="";
	for (int i = 0, x=0; i <= s.length(); i++) {
			if(ponavljanja(s.substring(x, i))) {
				if(s.substring(x, i).length()>s1.length())s1=s.substring(x, i);
			}
			else x++;
		}
	return s1;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String s1 = najduziString(s);
		System.out.println("Najduzi substring je: [" + s1 + "] duzine: " + s1.length());
		sc.close();
	}
}
