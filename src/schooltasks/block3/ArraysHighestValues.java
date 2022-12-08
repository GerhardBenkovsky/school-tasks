package schooltasks.block3;

import java.util.Arrays;

public class ArraysHighestValues {

	public static void main(String[] args) {
		int[][] arrays = { //
				{ 3, 1, 5, 7, 4, 12, -3, 8, -2 }, //
				{ -3, -1, -5, -7, -4, -12, -3, -8, -2 }, //
				{ 3, 1, 5, 12, 4, 12, -3, 8, -2 }, //
				{ 12, 12, 3, 1, 5, 4, -3, 8, -2 }, //
				{ -2, 8, -3, 5, 4, 3, 1, 12, 12 }, //
				{ 11, 12, 5, 7, 4, 1, -3, 8, -2 } //
		};

		for (int[] arr : arrays) {
			System.out.println(Arrays.toString(arr) + " ---> " + findHighestTwoValues(arr));
		}
	}

	public static Result findHighestTwoValues(int[] arr) {
		int first = arr[0];
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];

			if (num < second) {
				continue;
			}

			if (num > first) {
				first = num;
			} else {
				second = num;
			}

		}
		return new Result(first, second);

	}

	public record Result(int first, int second) {
	}

}
