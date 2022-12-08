package schooltasks.block3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Search {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { -123, -1, 2, 5, 23, 543, 1231, 2131, 31213 };
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);
		System.out.println(Arrays.toString(list.toArray()));
		boolean binarySearch = binarySearch(list, Integer.valueOf(31213));
		System.out.println(binarySearch);
	}

	public static <T extends Number> int indexOf(T[] arr, T obj) {
		for (int i = 0; i < arr.length; i++) {
			T t = arr[i];
			if (t.equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> boolean binarySearch(List<T> arr, T obj) {
		int index = arr.size() / 2;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(index).compareTo(obj) == 0) {
				return true;
			} else if (arr.get(index).compareTo(obj) < 0) {
				index += arr.size() / 2;
			} else if (arr.get(index).compareTo(obj) > 0) {
				index -= arr.size() / 2;
			}

		}
		return false;
	}
}
