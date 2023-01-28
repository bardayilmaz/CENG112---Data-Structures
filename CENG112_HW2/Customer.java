import java.util.Random;

public class Customer {
	
	Random rnd;
	Product[] products; 
	
	public Customer()
	{
		rnd = new Random();
		products =  new Product[] {new Sofa(), new Bed(), new Chair(), new Dresser(),
				new Table(), new Bookcase()};
	}
	
	public void request(Storage_Chief storageChief)  // customer asks for randomly indexed product, demand is met
	{
		int requestedIndex = rnd.nextInt(products.length);
		
		System.out.print("Customer buying " + products[requestedIndex] + ",");
		
		if(storageChief.sendToCustomer(products[requestedIndex]))
		{
			products[requestedIndex].sell();
		}
		
	}
	
}
