package block1;
import java.util.ArrayList;
import java.util.List;

public class Teiler {

	public static void main(String[] args) {
		Teiler.getDivisors(53245);
	}

	public static void getDivisors(int num) {
		List<Integer> nums = new ArrayList<>();

		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				nums.add(i);
			}
		}

		System.out.println(nums);

	}

}
