
public class Item {
	
	private String _name;
	private String _kind;
	private int _weight;
	
	// The items in the market. They have name, kind and weight.
	public Item(String name, String kind, int weight)
	{
		_name = name;
		_kind = kind;
		_weight = weight;
	}
	
	public String toString()
	{
		return _name+", "+_kind+", "+_weight;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getKind()
	{
		return _kind;
	}
	
	public int getWeight()
	{
		return _weight;
	}
}

