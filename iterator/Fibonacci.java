package iterator;

public class Fibonacci implements MyIterator {
	int upperBound;
	int cnt = 0, cur_fib = 0;

	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public boolean hasNext() {
		if (upperBound > fib(cnt))// fib(cnt) = next fib
			return true;
		return false;
	}

	@Override
	public int next() {
		if (!hasNext())
			return cur_fib; // last fib number
		cur_fib = fib(cnt);// calc new fib
		cnt++;
		return cur_fib;
	}

	private int fib(int index) {
		if (index == 0 || index == 1)// start of Fibonacci
			return 1;
		return fib(index - 1) + fib(index - 2); // index = index -1 + index -2

	}// fib

}// class
