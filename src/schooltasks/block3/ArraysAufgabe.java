package schooltasks.block3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArraysAufgabe {

	public static void main(String[] args) {
		// Messungen in ml
		int[] messungen = { 248, 249, 251, 247, 250, 252, 246, 248, 249, 250 };

		// a
		System.out.format("%15s%10s%n", "Nummber der Messung", "Messung");
		for (int i = 0; i < messungen.length; i++) {
			System.out.format("%10d %16d %n", i, messungen[i]);
		}

		// b
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int v : messungen)
			list.add(v);
		System.out.format("Summe: %dml%n", Arrays.stream(messungen).summaryStatistics().getSum());

		Arrays.stream(messungen).summaryStatistics().getAverage();
		System.out.format("Durchschnitt: %.2f ml%n", Arrays.stream(messungen).summaryStatistics().getAverage());

		// d
		list = new ArrayList<Integer>();
		for (int v : messungen)
			list.add(v);
		int deviation = list.stream().reduce(0, (subtotal, element) -> (subtotal + Math.abs(250 - element.intValue())));
		System.out.format("Gesamtabweichung: %d ml%n", deviation);

		// e

		printRange(245, 250, messungen);

		// f
		System.out.format("%15s%10s%n", "Nummber der Messung", "Messung");
		for (int i = messungen.length - 1; i > -1; i--) {
			System.out.format("%10d %16d %n", i, messungen[i]);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Type 1 for ascending and -1 for decending");
		int a = sc.nextInt();
		
		sc.close();
	}

	private static void printRange(int min, int max, int[] arr) {
		for (int v : arr) {
			if (v < max || v > min)
				System.out.println(v);
		}
	}

}
