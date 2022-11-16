package schooltasks.block2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LKWMaut {

	private static final Map<String, Double[]> KLASSEN = new HashMap<String, Double[]>();

	static {
		KLASSEN.put("A", new Double[] { 12.5d, 13.1d });
		KLASSEN.put("B", new Double[] { 14.6d, 15.2d });
		KLASSEN.put("C", new Double[] { 15.7d, 16.3d });
		KLASSEN.put("D", new Double[] { 18.8d, 19.4d });
		KLASSEN.put("E", new Double[] { 19.8d, 20.4d });
		KLASSEN.put("F", new Double[] { 20.8d, 21.4d });
	}

	public static record LKW(int achsen, String klasse) {
	}

	public static double calc(LKW lkw, double km) {
		return KLASSEN.get(lkw.klasse)[lkw.achsen() < 4 ? 0 : 1] * km;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Gebe die Klasse ein [A-F]");
		String klasse = sc.next();

		System.out.println("Gebe die Anzahl der Achsen ein");
		int achsen = sc.nextInt();

		System.out.println("Gebe die Strecke in km ein");
		double distance = sc.nextDouble();

		double kosten = LKWMaut.calc(new LKW(achsen, klasse.toUpperCase()), distance);

		System.out.format(Locale.GERMAN, "Kosten für %.2fkm = %.2f\n", distance, kosten);

		sc.close();
	}

}
