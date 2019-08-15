package RimskiBrojevi;

import java.util.HashMap;

public class RimskiBrojevi {
	public static int konvertujBroj(String rome, HashMap<String, Integer> mapa) {
		int arab = 0;
		for (int i = rome.length(); i >= 0; i--) {
			if (i - 1 < 0)
				break;
			if (i - 2 >= 0 && mapa.containsKey(rome.substring(i - 2, i))) {
				arab += mapa.get(rome.substring(i - 2, i));
				i--;
			}

			else if (mapa.containsKey(rome.charAt(i - 1) + ""))
				arab += mapa.get(rome.charAt(i - 1) + "");

		}
		return arab;
	}

	public static void main(String[] args) {
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("I", 1);
		mapa.put("IV", 4);
		mapa.put("V", 5);
		mapa.put("IX", 9);
		mapa.put("X", 10);
		mapa.put("XL", 40);
		mapa.put("L", 50);
		mapa.put("XC", 90);
		mapa.put("C", 100);
		mapa.put("CD", 400);
		mapa.put("D", 500);
		mapa.put("CM", 900);
		mapa.put("M", 1000);
		System.out.println(konvertujBroj("III", mapa));
		System.out.println(konvertujBroj("IV", mapa));
		System.out.println(konvertujBroj("IX", mapa));
		System.out.println(konvertujBroj("LVIII", mapa));
		System.out.println(konvertujBroj("MCMXCIV", mapa));
		System.out.println(konvertujBroj("MDCCLXXVI", mapa));
		System.out.println(konvertujBroj("MMMCMXCIX", mapa));

	}

}
