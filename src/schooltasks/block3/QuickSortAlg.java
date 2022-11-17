package schooltasks.block3;

import java.util.Arrays;
import java.util.Random;

public class QuickSortAlg {

	public static void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(arr));

		quickSort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
