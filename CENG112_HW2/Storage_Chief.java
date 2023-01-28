
public class Storage_Chief {
	
	Warehouse<Product> sofaWh ;
	Warehouse<Product> bedWh; 
	Warehouse<Product> chairWh;
	Warehouse<Product> dresserWh;
	Warehouse<Product> tableWh;
	Warehouse<Product> bookcaseWh;
	
	
	
	public Storage_Chief(Warehouse<Product> sofaWh, Warehouse<Product> bedWh, Warehouse<Product> chairWh,
			Warehouse<Product> dresserWh, Warehouse<Product> tableWh, Warehouse<Product> bookcaseWh) {
		this.sofaWh = sofaWh;
		this.bedWh = bedWh;
		this.chairWh = chairWh;
		this.dresserWh = dresserWh;
		this.tableWh = tableWh;
		this.bookcaseWh = bookcaseWh;
	}

	public void manageWarehouses(Product frontProduct)
	{
		if(frontProduct != null)
		{
			switch(frontProduct.getClass().getName())
			{
			case("Sofa"):
				frontProduct.store();
			sofaWh.push(frontProduct);
			break;
			case("Bed"):
				frontProduct.store();
			bedWh.push(frontProduct);
			break;
			case("Chair"):
				frontProduct.store();
			chairWh.push(frontProduct);
			break;
			case("Dresser"):
				frontProduct.store();
			dresserWh.push(frontProduct);
			break;
			case("Table"):
				frontProduct.store();
			tableWh.push(frontProduct);
			break;
			case("Bookcase"):
				frontProduct.store();
			bookcaseWh.push(frontProduct);
			break;
			}
			
			System.out.println("Storage chief has added " + frontProduct + " to warehouse.");
		}
		
		else
		{
			System.out.println("Factory line is empty!");
		}
	}
	
	public boolean sendToCustomer(Product desiredProduct)
	{
		boolean sold = false;
		switch(desiredProduct.getClass().getName())  // which product
		{
		case("Sofa"):
			
			if(checkForProduct(desiredProduct, sofaWh))
			{
				sofaWh.pop();
				sold = true;				
			}
		break;
			
			
		case("Bed"):
			
			if(checkForProduct(desiredProduct, bedWh))
			{
				bedWh.pop();
				sold = true;
			}
			
			break;
			
		case("Chair"):
			
			if(checkForProduct(desiredProduct, chairWh))
			{
				chairWh.pop();
				sold = true;
			}
			
			break;
			
		case("Dresser"):
		
			if(checkForProduct(desiredProduct, dresserWh))
			{
				dresserWh.pop();
				sold = true;
				
			}
			
			break;
			
		case("Table"):
		
			if(checkForProduct(desiredProduct, tableWh))
			{
				tableWh.pop();
				sold = true;
			}
			break;
			
		case("Bookcase"):
			
			if(checkForProduct(desiredProduct, bookcaseWh))
			{
				bookcaseWh.pop();
				sold = true;
			}
			break;
			
		}
		return sold;
	}
	
	private boolean checkForProduct(Product product, Warehouse<Product> wh)  // Was the customer able to buy the product successfully or not? Control function.
	{
		if(!wh.isEmpty())
		{
			System.out.println(" SUCCESS, Customer bought " + product);
			return true;
		}
		System.out.println(" FAIL, " + product + " warehouse empty.");
		return false;
	}

}
