package circuits;

public class VarGate extends Gate {
	private String name;
	private boolean value;
	private int set_flag = 0;

	public VarGate(String name) {
		super(null);
		this.name = name;
	}

	public String getName() {
		return "V" + name;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if (set_flag == 0)
			throw new CircuitException("value = null");
		return value;
	}

	public void setVal(boolean value) {
		this.value = value;
		set_flag = 1;// value has been set
	}

	@Override
	public Gate simplify() {

		if (set_flag == 0)/* val = null */
			return this;
		if (value) /* val = true */
			return TrueGate.instance();
		/* val = false */
		return FalseGate.instance();
	}

}// class
