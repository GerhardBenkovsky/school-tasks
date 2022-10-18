package schooltasks.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

import schooltasks.util.Benchmark.Clock;

public class Benchmark {

	private Benchmark() {
	}

	public static <T, R> List<Clock> markbench(int rep, T input, Function<T, List<R>> fun) {
		List<Clock> times = new ArrayList<Clock>(rep + 10);

		TimerTask ts = new TimerTask() {
			private Instant start = Instant.now();

			@Override
			public void run() {
				System.out.format("Elapsed time: %ds\n", ChronoUnit.SECONDS.between(start, Instant.now()));
			}
		};

		new Timer("Elapsed time").scheduleAtFixedRate(ts, 0, 1000);

		for (int i = 0; i < rep; i++) {
			Clock clock = new Clock();
			fun.apply(input);
			times.add(clock.stop());
		}

		ts.cancel();

		return times;
	}

	public static int eval(List<Clock> clocks) {
		List<Long> times = new ArrayList<>(clocks.size());

		for (Clock c : clocks)
			times.add(c.end - c.start);

		Long sum = times.stream().reduce(0L, Long::sum);
		return (int) (sum / times.size());
	}

	public static class Clock {

		public final long start;
		public long end;

		public Clock() {
			start = System.nanoTime();
		}

		public Clock stop() {
			end = System.nanoTime();
			return this;
		}

	}

}
