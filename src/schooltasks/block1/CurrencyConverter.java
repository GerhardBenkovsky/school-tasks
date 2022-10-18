package schooltasks.block1;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter US-Dollar amount: ");

		double dollar = sc.nextDouble();

		HashMap<String, Double> currencyMap = new HashMap<String, Double>();

		currencyMap.put("EUR", 1.04);
		currencyMap.put("JPY", 144.75);
		currencyMap.put("VEF", 808675.47);

		System.out.println("Available Currencies:");

		for (String key : currencyMap.keySet()) {
			System.out.println(key);
		}

		System.out.println("Enter currency code:");

		String currencyCode = sc.next();

		System.out.println(CurrencyConverter.dollarConverter(dollar, currencyCode, currencyMap));

		sc.close();
	}

	private static String dollarConverter(double dollarsUS, String ISO3DigitCurrencyCode,
			HashMap<String, Double> currencyMap) {
		return currencyMap.get(ISO3DigitCurrencyCode) * dollarsUS + ISO3DigitCurrencyCode;
	}
}