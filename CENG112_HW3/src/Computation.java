
public class Computation {
	
	private int id;
	private IProcess process;
	private int occupation;
	
	public Computation(int _id, IProcess _process, int _occupation)
	{
		id = _id;
		process = _process;
		occupation = _occupation;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getOccupation()
	{
		return occupation;
	}
	
	public IProcess getProcess()
	{
		return process;
	}
	
	public String toString()
	{
		return getId() + "," + getProcess().toString() + "," + getOccupation()+"ns";  // 1,High,1ns
	}
}
