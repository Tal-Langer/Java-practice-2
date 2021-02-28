package circuits;

public class OrGate extends Gate {

	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (inValues == null)
			throw new CircuitException("inValues=null , OR gate must have inValues ");

		/* if inValues[i]==1 >> OrGate = true */
		for (int i = 0; i < inValues.length; i++)
			if (inValues[i])
				return true;
		return false;// all array is false
	}

	@Override
	public String getName() {
		return "OR";
	}

	@Override
	public Gate simplify() {
		int falseGate_cnt = 0;
		/* check if has true gate */
		Gate[] simplify_array = new Gate[inGates.length];
		for (int i = 0; i < inGates.length; i++) {
			if (inGates[i] == null) {
				System.out.println("inGates[i]==null");
			}
			simplify_array[i] = inGates[i].simplify();// simplify_array simplify of all sons
		}
		/* check if has a TrueGate */
		for (int i = 0; i < simplify_array.length; i++) {
			if (simplify_array[i] instanceof TrueGate)
				return TrueGate.instance();
			if (simplify_array[i] instanceof FalseGate)
				falseGate_cnt++;
		}

		Gate[] no_falseGate_simplify_array = new Gate[simplify_array.length - falseGate_cnt];
		int no_falseGate_cnt = 0;
		/* copy all gates other than FalseGate */
		for (int i = 0; i < simplify_array.length && no_falseGate_cnt < no_falseGate_simplify_array.length; i++) {
			if (!(simplify_array[i] instanceof FalseGate)) {
				no_falseGate_simplify_array[no_falseGate_cnt] = simplify_array[i];
				no_falseGate_cnt++;
			}
		}

		if (no_falseGate_cnt == 1)
			return no_falseGate_simplify_array[0].simplify();

		if (no_falseGate_cnt == 0)
			return TrueGate.instance();
		return new OrGate(no_falseGate_simplify_array);

	}// simplify()

}// class
