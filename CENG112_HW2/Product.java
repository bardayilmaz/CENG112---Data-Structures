
public abstract class Product implements IProduct {


	private boolean manufactured;
	private boolean stored;
	private boolean sold;
	
	public Product()
	{
		manufactured = false;
		stored = false;
		sold = false;
	}
	
	public String toString()
	{
		return getClass().getName();
	}
	@Override
	public boolean isManufactured() {
		return manufactured;
	}

	@Override
	public boolean isStored() {
		return stored;
	}

	@Override
	public boolean isSold() {
		return sold;
	}
	
	public void manufacture()
	{
		manufactured = true;
	}
	
	public void store()
	{
		stored = true;
	}
	
	public void sell()
	{	
		sold = true;
	}

}
