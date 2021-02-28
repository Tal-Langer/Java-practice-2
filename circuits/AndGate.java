package circuits;

import java.util.Arrays;

public class AndGate extends Gate {

	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (inValues == null)
			throw new CircuitException("inValues=null , AND gate must have inValues ");
		/* if all array != 0 >> andGate = true */
		for (int i = 0; i < inValues.length; i++)
			if (!inValues[i])
				return false;
		return true;// all array is true
	}

	@Override
	public String getName() {
		return "AND";
	}

	@Override
	public Gate simplify() {
		int trueGate_cnt = 0;
		/* check if has false gate */
		Gate[] simplify_array = new Gate[inGates.length];
		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i] == null) {
				System.out.println("inGates[i]==null");
			}
			simplify_array[i] = inGates[i].simplify();// simplify_array = simplify of all sons
		}
		/* check if has a FalseGate */
		for (int i = 0; i < simplify_array.length; i++) {
			if (simplify_array[i] instanceof FalseGate)
				return FalseGate.instance();
			if (simplify_array[i] instanceof TrueGate)
				trueGate_cnt++;
		}

		Gate[] no_trueGate_simplify_array = new Gate[simplify_array.length - trueGate_cnt];
		int no_trueGate_cnt = 0;
		/* copy all gates other than TrueGates */
		for (int i = 0; i < simplify_array.length && no_trueGate_cnt < no_trueGate_simplify_array.length; i++) {
			if (!(simplify_array[i] instanceof TrueGate)) {
				no_trueGate_simplify_array[no_trueGate_cnt] = simplify_array[i];
				no_trueGate_cnt++;
			}
		}

		if (no_trueGate_cnt == 1)
			return no_trueGate_simplify_array[0].simplify();

		if (no_trueGate_cnt == 0)
			return FalseGate.instance();
		return (new AndGate(no_trueGate_simplify_array));

	}// simplify()

}// class
