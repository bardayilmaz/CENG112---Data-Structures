
public class Process implements IProcess {
	
	private String type;
	private int priority;
	
	public Process(String _type)
	{
		assert ( (type == "High") || (type == "Normal") || (type == "Low") ) : " Invalid type! "; // type must be High, Low or Normal. Nothing else
		type = _type;
		priority = getPriority();
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public int getPriority() {
		assert ((type != null)) : " Type hasn't assigned yet! ";
		int prior;
		if(getType() == "High")
		{
			prior = 1;
		}
		else if(getType() == "Normal")
		{
			prior = 2;
		}
		else if(getType() == "Low")
		{
			prior = 3;
		}
		else
		{
			prior = -1;
		}
		
		assert prior != -1 && prior != 0;
		
		return prior;
	}
	
	@Override
	public String toString()
	{
		assert ((type != null)) : " Type hasn't assigned yet! ";
		
		return type;
	}

}
