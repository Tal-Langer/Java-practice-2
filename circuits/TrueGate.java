package circuits;

public class TrueGate extends Gate {

	private static TrueGate True_instance = null;

	private TrueGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	public String getName() {
		return "T";
	}

	@Override
	public Gate simplify() {
		return this;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	public static Gate instance() {
		if (True_instance == null)
			True_instance = new TrueGate(null);
		return True_instance;

	}
	
}//class

