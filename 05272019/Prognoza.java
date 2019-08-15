package VremenskaPrognoza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Prognoza {

	public static void main(String[] args) {
		String city = "Belgrade";
		String cntrCode = "RS";
		System.out.println("Dobrodosli u konzolnu vremensku prognozu! \n");
		String meni = "-----------------------------------------\n"
				+ "Komande: \n-1) Izlaz iz programa\n 0) Promena grada\n 1) Trenutni vremenski uslovi\n 2) Prognoza za "
				+ "5 dana\n99) Ispis komandnog menija";
		for (int i = 99; i != -1;) {
			Scanner s = new Scanner(System.in);
			switch (i) {
			case 99:
				System.out.println(meni);
				break;
			case 0:
				System.out.println("Unesite grad u formatu: city, countryCode");
				String[] gradIkod = new String[2];
				String str = s.nextLine();
				gradIkod = str.split(", ");
				city = gradIkod[0];
				cntrCode = gradIkod[1];
				break;
			case 1: //VremeInfoPom su pomocne varijable dok VremeInfo vadi podatke o vremenu
				JSONObject VremeInfo = new JSONObject();
				JSONObject VremeInfoPom = new JSONObject();
				JSONObject VremeInfoPom1 = new JSONObject();
				JSONParser parser = new JSONParser();
				try {
					VremeInfo = (JSONObject) parser.parse(getWeatherInfo(city, cntrCode, Type.CURRENT));
				} catch (ParseException | IOException e) {
					e.printStackTrace();break;
				}
				VremeInfoPom = (JSONObject) VremeInfo.get("main");
				VremeInfoPom1=(JSONObject) VremeInfo.get("wind");
				System.out.println(city + ": ");
				System.out.println("Trenutna: " + VremeInfoPom.get("temp")+ "°C");
				System.out.println("Maksimalna: " + VremeInfoPom.get("temp_max")+ "°C");
				System.out.println("Minimalna: " + VremeInfoPom.get("temp_min")+ "°C");
				System.out.println("Pritisak: " + VremeInfoPom.get("pressure") + "mb");
				System.out.println("Vlaznost vazduha: " + VremeInfoPom.get("humidity") + "%");
				System.out.println("Brzina vetra: " + VremeInfoPom1.get("speed") + "km/h");
				break;

			case 2: //Ovaj deo je malo iskomplikovan vezbe radi. Kao i u case-u iznad VremeInfo1/2 su pomocne varijable dok VremeInfo3 vadi podatke o vremenu
				try {
					Calendar calendar = Calendar.getInstance();
					String[] dani = {"Ned","Pon","Uto","Sre","Cet","Pet","Sub"};
					JSONArray VremeInfo1 = new JSONArray();
					JSONArray VremeInfo2 = new JSONArray();
					JSONParser parser1 = new JSONParser();
					JSONObject VremeInfo3 = (JSONObject) parser1.parse(getWeatherInfo(city, cntrCode, Type.FORECAST));
					VremeInfo1 = (JSONArray) VremeInfo3.get("list");
					VremeInfo2 = (JSONArray) VremeInfo3.get("list");
					System.out.println(city + ": ");
					for (int j = 0; j < VremeInfo1.size(); j += 8) {
						calendar.add(Calendar.DATE, 1);
						int index = calendar.get(Calendar.DAY_OF_WEEK) - 1;				
						VremeInfo3 = (JSONObject) VremeInfo1.get(j);
						VremeInfo3 = (JSONObject) VremeInfo3.get("main");
						System.out.println(dani[index] + ": Temperatura: " + VremeInfo3.get("temp") + "°C");
						System.out.println("     Pritisak: " + VremeInfo3.get("pressure") + "mb");
						System.out.println("     Vlaznost vazduha: " + VremeInfo3.get("humidity") + "%");
						VremeInfo3=(JSONObject) VremeInfo2.get(j);
						VremeInfo3 = (JSONObject) VremeInfo3.get("wind");
						System.out.println("     Brzina vetra: " + VremeInfo3.get("speed") + "km/h\n");
						
					}
				} catch (IOException e) {
					e.printStackTrace();break;
				} catch (ParseException e) {
					e.printStackTrace();break;
				}
				break;
				default:System.out.println("Nepostojeca komanda, pokusajte ponovo. ");break;

			}
			System.out.println("----------------------------------------- \nKomanda: ");
			i = s.nextInt();
		}
		System.out.println("Kraj programa.");

		// ------------------------------------------------------------------------------------------------------------------------------------//
	}

	static long lastRequestTimestamp;

	public static enum Type {
		CURRENT, FORECAST
	};

	public static String getWeatherInfo(String city, String countryCode, Type type) throws IOException {
		String authToken = "d0f1969fd9856fe09e3f7d0753d84ed4";
		String addr = String.format("http://api.openweathermap.org/data/2.5/%s?q=%s,%s&appid=%s&units=metric",
				type == Type.CURRENT ? "weather" : "forecast", city, countryCode, authToken);
		if (System.currentTimeMillis() - lastRequestTimestamp < 5000) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		URLConnection yc = new URL(addr).openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		StringBuilder buffer = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine);
		in.close();
		lastRequestTimestamp = System.currentTimeMillis();
		return buffer.toString();
	}
}
