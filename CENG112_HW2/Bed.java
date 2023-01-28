
public class Bed extends Product {
	
	public static int manufacturedCount = 0;
	public static int storedCount = 0;
	public static int bedSoldCount = 0;
	
	private boolean manufactured;
	private boolean stored;
	private boolean sold;
	
    @Override
	public void manufacture()
	{
		manufacturedCount++;
		manufactured = true;
	}
	
    @Override
	public void store()
	{
		manufacturedCount--;
		storedCount++;
		stored = true;
	}
	
    @Override
	public void sell()
	{
		storedCount--;
		bedSoldCount++;
		sold = true;
	}
}
