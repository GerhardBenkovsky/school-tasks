package schooltasks.block1;
public class ShapesBeginners {

	public static void main(String[] args) {
		ShapesBeginners sb = new ShapesBeginners();
		sb.printTree(15);

	}

	public void printTree(int size) {
		if (size < 6)
			throw new IndexOutOfBoundsException();

		String stern = "*";
		String space = " ";

		for (int i = 1; i < size + 1; i += 2) {
			System.out.print(space.repeat((size - i) / 2));
			System.out.println(stern.repeat(i));
		}
		System.out.print(space.repeat(size - (size / 2) - 2));
		System.out.println(stern.repeat(3));
	}

	public void printDreieck(int size) {
		String stern = "*";
		String space = " ";

		System.out.println(stern.repeat(size));

		for (int i = size - 2; i > 1; i -= 2) {
			System.out.print(space.repeat((size - i) / 2));
			System.out.print(stern);
			System.out.print(space.repeat(i - 2));
			System.out.println(stern);
		}
	}

	public void schoenerName(String name) {
		String minus = "-";
		System.out.print("+");
		System.out.print(minus.repeat(name.length()));
		System.out.println("+");
		System.out.print("|");
		System.out.print(name);
		System.out.println("|");
		System.out.print("+");
		System.out.print(minus.repeat(name.length()));
		System.out.print("+");
	}

}
