package circuits;

import java.util.Arrays;

public abstract class Gate {

	protected Gate[] inGates;

	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}

	public boolean calc() throws CircuitException {
		if (inGates == null)
			return func(null);
		boolean arr[] = new boolean[inGates.length];
		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i] == null)
				throw new CircuitException("inGates[i]==null");
			arr[i] = inGates[i].calc();
		}
		return func(arr);
	}

	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	public abstract String getName();

	public abstract Gate simplify();

	public String toString() {

		if (inGates == null)
			return getName();
		return getName() + Arrays.toString(inGates);

	}
}
