package circuits;

public class NotGate extends Gate{
	
	public NotGate(Gate in)
	{
		super(new Gate[] {in});
	}
	
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException  {
		if(inValues==null)
		throw new CircuitException("inValues=null , NOT gate must have inVal ");
		return !inValues[0]; // opposite of the only  val
	}

	@Override
	public String getName() {
		return "NOT";
	}

	@Override
	public Gate simplify() {	
		/*son is TrueGate*/
		if(inGates[0].simplify() instanceof TrueGate)
			return FalseGate.instance();
		/*son is FalseGate*/
		if(inGates[0].simplify() instanceof FalseGate) 
			return TrueGate.instance();
			
			
		if(inGates[0].simplify() instanceof NotGate)
			return inGates[0].inGates[0].simplify();
		/*not instanceof TrueGate || FalseGate || NotGate*/
		return this;
		
	}

	
}//class