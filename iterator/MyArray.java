package iterator;

import java.util.function.IntPredicate;

public class MyArray implements MyIterator {
	private int i = 0, len_array;
	protected int[] numbers;

	public MyArray(int[] numbers) {
		this.numbers = numbers;
		len_array = numbers.length;
	}

	@Override
	public boolean hasNext() {
		return i < len_array;

	}

	@Override
	public int next() {
		if (!hasNext()) // i>length array
			throw new IndexOutOfBoundsException();
		i++;
		return numbers[i - 1];

	}

}