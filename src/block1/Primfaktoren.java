package block1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Primfaktoren {

	public static void main(String args[]) {
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number ::");
//		number = sc.nextInt();
		number = 9876;

		Primfaktoren primfaktoren = new Primfaktoren();

		List<Clock> clocks = benchmark(20000, number, primfaktoren.getPrimeFactors);

		List<Long> times = new ArrayList<>(clocks.size());

		for (Clock c : clocks)
			times.add(c.endTime - c.startTime);

		Long sum = times.stream().reduce(0L, Long::sum);

		System.out.println("Avg time: " + (sum / times.size()) + "ns");

		sc.close();
	}

	public static <V> List<Clock> benchmark(int rep, int number, Function<Integer, List<V>> fun) {
		List<Clock> times = new ArrayList<Clock>(rep + 10);

		for (int i = 0; i < rep; i++) {
			Clock clock = new Clock();
			fun.apply(number);
			times.add(clock.stop());
		}
		return times;
	}

	private Function<Integer, List<Integer>> getPrimeFactors = new Function<Integer, List<Integer>>() {

		@Override
		public List<Integer> apply(Integer number) {
			List<Integer> numbers = new ArrayList<>(number / 2);

			while (number % 2 == 0) {
				number = number / 2;
				numbers.add(2);
			}
			for (int i = 3; i < number / 2; i+=2) {
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

	private static class Clock {

		public final long startTime;
		public long endTime;

		public Clock() {
			startTime = System.nanoTime();
		}

		public Clock stop() {
			endTime = System.nanoTime();
			return this;
		}

	}

}
