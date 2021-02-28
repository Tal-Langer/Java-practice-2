package iterator;

public class IteratorToString {

	public static String toString(MyIterator it) {

		StringBuilder str1 = new StringBuilder();
		str1.append("[");
		while (it.hasNext()) {
			str1.append(it.next() + " ");
		}
		str1.deleteCharAt(str1.length() - 1);
		str1.append("]");
		return str1.toString();

	}

}