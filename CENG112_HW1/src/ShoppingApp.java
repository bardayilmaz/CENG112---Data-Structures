import java.util.Scanner;

public class ShoppingApp {

	public static void main(String[] args) {
		Item[] items = FileIO.readInventory();  // array for displaying the items in market.
		IBag<Item> bag = new ShoppingBag<>();
		IBag<Item> fridge = new FridgeBag<Item>();
		
		BasketChecker basketChecker = new BasketChecker();
		FridgeChecker fridgeChecker = new FridgeChecker();
		
		Scanner scanner = new Scanner(System.in);
		
		
		boolean finishShopping = false;
		do{
			displayOptions1();
			int choice = scanner.nextInt(); // taking user input.
			
			if(choice == 1)  // choice, go to shopping.
			{
				goToShopping();  // printing choices
				System.out.println();
				choice = scanner.nextInt();
				if(choice == 1)  // add an item to the basket.
				{
					addAnItem(items);  // printing choices
					System.out.println();
					choice = scanner.nextInt();
					
					for(int i = 0; i < items.length; i++)  // linear check for input.
					{
						if(choice == i+1)
						{
							if(basketChecker.weightCheck(items[i].getWeight()))
							{
								if(bag.add(items[i]))
								{
									basketChecker.setWeight(items[i].getWeight());
								}
							}
						}
					}
				}
				else if(choice == 2)  // see the basket
				{
					bag.displayItems();
				}
				else if(choice == 3)  // finish shopping
				{
					System.out.println("Shopping is finished and going to fill the fridge.\nThe fridge is filled");
					while(!bag.isEmpty())
					{
						Item removed = bag.remove();  // taking the removed item.
						basketChecker.setWeight(-removed.getWeight());  // decrementing the weight in the basket.
						if(fridgeChecker.categoryChecker(removed.getKind()))  // checking for validity of category of item.
						{
							if(fridgeChecker.weightChecker(removed.getWeight(), removed.getKind()))  // checking for weight
							{
								System.out.println("i is: "+removed + ", transferring " + removed);
								bag.transferTo(fridge, removed);  // adding to fridge
							}
						}
						else {
							System.out.println("invalid category");
						}
						
					}
					finishShopping = fridgeChecker.checkForFull();  // is fridge full?
				}
			}
			else if(choice == 2)
			{
				fridgeChecker.displayRemainings();
			}
			else if(choice == 3)
			{
				System.out.println("shopping is finished");
				finishShopping = true;
			}
			
		}while(!finishShopping);
		
		scanner.close();
		
	}
	
	private static void displayOptions1()
	{
		System.out.println("Welcome to The Shopping App! Please select an option:"
				+ "\n[1]Go to shopping\n[2]See the status of the fridge\n[3]Exit");
	}
	
	private static void goToShopping()
	{
		System.out.println("Please select an option:\n[1]Add an item to the basket\n[2]See the basket\n[3]Finish shopping");
	}
	
	private static void addAnItem(Item[] items)
	{
		System.out.println("Please select an item:");
		for(int i = 0; i < items.length; i++)
		{
			System.out.println("[" + (i+1) + "]"+items[i].getName());
		}
	}

}
