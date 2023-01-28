
public class FridgeChecker {
	
	private final static int TOTAL_FRUIT_VEG_WEIGHT_LIMIT = 3000; // grams
	private final static int TOTAL_MEAT_WEIGHT_LIMIT = 5000;
	private final static int TOTAL_BEVERAGE_WEIGHT_LIMIT = 4000; 
	private final static int TOTAL_SNACK_WEIGHT_LIMIT = 2000; 
	
	
	private int currentFruitVegetablesWeight;  // grams
	private int currentMeatWeight;
	private int currentBeverageWeight;
	private int currentSnackWeight;
	
	
	public FridgeChecker()
	{
		// creating and empty fridge.
		currentBeverageWeight = 0;
		currentFruitVegetablesWeight = 0;
		currentMeatWeight = 0;
		currentSnackWeight = 0;
	}
	
	
	public boolean categoryChecker(String category)
	{
		return category.equals("vegetables and fruits") || 
				category.equals("meats") || category.equals("beverages") || category.equals("snacks") ;  // checks for validity of the given category.
	}
	
	public boolean weightChecker(int weight, String category)
	{
		if(categorizer(category) == 1)  // if it is vegetable or fruit... 
		{
			if(weight + currentFruitVegetablesWeight <= TOTAL_FRUIT_VEG_WEIGHT_LIMIT)  // and its weight is valid for adding...
			{
				currentFruitVegetablesWeight += weight;  // update the weight.
				return true;
			}
		}
		else if(categorizer(category) == 2)  // same with (== 1) case but for meats...
		{
			if(weight + currentMeatWeight <= TOTAL_MEAT_WEIGHT_LIMIT)
			{
				currentMeatWeight += weight;
				return true;
			}
		}
		else if(categorizer(category) == 3)  // for beverages
		{
			if(weight + currentBeverageWeight <= TOTAL_BEVERAGE_WEIGHT_LIMIT)
			{
				currentBeverageWeight += weight;
				return true;
			}
		}
		else if(categorizer(category) == 4) // for snacks.
		{
			if(weight + currentSnackWeight <= TOTAL_SNACK_WEIGHT_LIMIT)
			{
				currentSnackWeight += weight;
				return true;
			}
		}
		System.out.println("not enough place for that item");
		return false;
	}
	
	private int categorizer(String category)
	{
		if(category.equals("vegetables and fruits"))
		{
			return 1;
		}
		else if(category.equals("meats"))
		{
			return 2;
		}
		else if(category.equals("beverages"))
		{
			return 3;
		}
		else if(category.equals("snacks"))
		{
			return 4;
		}
		else
		{
			System.out.println("Invalid category.");
			return -1;
		}
	}	
	
	public void displayRemainings()
	{
		System.out.println("Remaining capacities of each compartments:");
		System.out.println("Vegetables and Fruits :"+ (TOTAL_FRUIT_VEG_WEIGHT_LIMIT-currentFruitVegetablesWeight)  
				+ " grams\nMeats :" + (TOTAL_MEAT_WEIGHT_LIMIT-currentMeatWeight)
				+ " grams\nBeverages :" + (TOTAL_BEVERAGE_WEIGHT_LIMIT-currentBeverageWeight)
				+ " grams\nSnacks :" + (TOTAL_SNACK_WEIGHT_LIMIT-currentSnackWeight)+" grams");
	}
	
	public boolean checkForFull()
	{
		// numbers are less than the limit values because at these values you can not add anything and the program won't stop.
		if(currentBeverageWeight > 3750 && currentFruitVegetablesWeight > 2500 && currentMeatWeight > 4500 && currentSnackWeight > 1750)
		{
			System.out.println("Fridge is full. No more need for shopping.");
			return true;
		}
		return false;
	}

}
