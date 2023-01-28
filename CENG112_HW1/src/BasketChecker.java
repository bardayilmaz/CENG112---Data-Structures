// this class is for tracking the weight.
public final class BasketChecker {
	 
	int currentWeight;  
	private final static int WEIGHT_LIMIT = 2000; // grams
	
	public BasketChecker()
	{
		currentWeight = 0;
	}
	
	public boolean weightCheck(int weight)
	{
		if(currentWeight + weight > WEIGHT_LIMIT)
		{
			System.out.println("This item is too heavy to add.");
			return false;
		}
		return true;
	}
	
	public void setWeight(int weight)
	{
		currentWeight += weight;
	}

}
