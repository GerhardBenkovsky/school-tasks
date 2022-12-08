package schooltasks.block3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysHighestValuesTest {

	@Test
	void testFindHighestTwoValues() {

		int[] array = { 3, 1, 5, 7, 4, 12, -3, 8, -2 };
		int[] array2 = { -3, -1, -5, -7, -4, -12, -3, -8, -2 };
		int[] array3 = { 3, 1, 5, 12, 4, 12, -3, 8, -2 };
		int[] array4 = { 12, 12, 3, 1, 5, 4, -3, 8, -2 };
		int[] array5 = { -2, 8, -3, 5, 4, 3, 1, 12, 12 };
		int[] array6 = { 11, 12, 5, 7, 4, 1, -3, 8, -2 };

		assertEquals(ArraysHighestValues.findHighestTwoValues(array), new ArraysHighestValues.Result(12, 8));
		assertEquals(ArraysHighestValues.findHighestTwoValues(array2), new ArraysHighestValues.Result(-1, -2));
		assertEquals(ArraysHighestValues.findHighestTwoValues(array3), new ArraysHighestValues.Result(12, 12));
		assertEquals(ArraysHighestValues.findHighestTwoValues(array4), new ArraysHighestValues.Result(12, 12));
		assertEquals(ArraysHighestValues.findHighestTwoValues(array5), new ArraysHighestValues.Result(12, 12));
		assertEquals(ArraysHighestValues.findHighestTwoValues(array6), new ArraysHighestValues.Result(12, 11));

	}

}
