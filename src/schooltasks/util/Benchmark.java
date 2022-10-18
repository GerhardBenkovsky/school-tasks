package schooltasks.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Benchmark {

	private Benchmark() {
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
