package schooltasks.block1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import schooltasks.util.Benchmark;
import schooltasks.util.Benchmark.Clock;
import schooltasks.util.Settings;

public class Primfaktoren {

	public Primfaktoren(int number) {
		System.out.println(getPrimeFactors.apply(number));

		if (Settings.BENCHMARK) {
			List<Clock> clocks = Benchmark.markbench(10000, number, getPrimeFactors);
			System.out.println("Avg time: " + Benchmark.eval(clocks) + "ns");
		}
	}

	private Function<Integer, List<Integer>> getPrimeFactors = new Function<Integer, List<Integer>>() {

		@Override
		public List<Integer> apply(Integer number) {
			List<Integer> numbers = new ArrayList<>(number / 2);

			while (number % 2 == 0) {
				number = number / 2;
				numbers.add(2);
			}
			for (int i = 3; i < number / 2; i += 2) {
				while (number % i == 0) {
					number = number / i;
					numbers.add(i);
				}
			}
			if (number > 2) {
				numbers.add(number);
			}
			return numbers;
		}
	};

	public static void main(String args[]) {
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number ::");
//		number = sc.nextInt();
		number = 1236521;

		new Primfaktoren(number);
		sc.close();

		new GregorianCalendar().isLeapYear(number);
	}

}
