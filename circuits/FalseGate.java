package circuits;

public class FalseGate extends Gate {

	private static FalseGate False_instance = null;

	private FalseGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	public String getName() {
		return "F";
	}

	@Override
	public Gate simplify() {
		return this;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	public static Gate instance() {
		if (False_instance == null)
			False_instance = new FalseGate(null);
		return False_instance;

	}

}
