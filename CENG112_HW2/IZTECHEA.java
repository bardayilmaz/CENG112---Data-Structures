import java.util.Random;
	
import java.util.Scanner;

public class IZTECHEA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		IQueue<Product> line = new FactoryLine<>();
		
		Warehouse<Product> sofaWarehouse = new SofaWarehouse<>();
		Warehouse<Product> bedWarehouse = new BedWarehouse<>();
		Warehouse<Product> chairWarehouse = new ChairWarehouse<>();
		Warehouse<Product> dresserWarehouse = new DresserWarehouse<>();
		Warehouse<Product> tableWarehouse = new TableWarehouse<>();
		Warehouse<Product> bookcaseWarehouse = new BookcaseWarehouse<>();
		
		Marketing_Analyst marketingAnalyst = new Marketing_Analyst();
		Storage_Chief storageChief = new Storage_Chief(sofaWarehouse, bedWarehouse, chairWarehouse, dresserWarehouse, tableWarehouse, bookcaseWarehouse);
		Customer customer = new Customer();
		
		
                System.out.println("--------------------------------------------");
		System.out.print("Enter the number of random request cycles:");
		int requestCycleCount = scan.nextInt();  // taking user input.
		for(int i = 0; i < requestCycleCount; i++)
		{
			int whichProcess = random.nextInt(3);
			switch(whichProcess)
			{
			case 0:
				marketingAnalyst.manufacture(line);
				break;
			case 1:
				Product frontProduct = marketingAnalyst.sendToWarehouse(line);
				storageChief.manageWarehouses(frontProduct);
				frontProduct = null;
				break;
			case 2:
				customer.request(storageChief);
				break;
			}
		}
		
		
		displayCycle(); 
				
	}
	
	private static void displayCycle()  // printing function
	{
		System.out.println("\n----------------------------------------------"
				+ "\n\n\t##### REPORT #####\n\nAmount of Bed in Factory Line: " + Bed.manufacturedCount+"\n"
				+ "Amount of Sofa in Factory Line: " + Sofa.manufacturedCount + "\n"
				+ "Amount of Dresser in Factory Line: " + Dresser.manufacturedCount + "\n"
				+ "Amount of Table in Factory Line: " + Table.manufacturedCount + "\n"
				+ "Amount of Chair in Factory Line: " + Chair.manufacturedCount + "\n"
				+ "Amount of Bookcase in Factory Line: " + Bookcase.manufacturedCount + "\n");
               
                
		System.out.println("*********************************");
                
		System.out.println("Amount of Bed in Bed Warehouse: " + Bed.storedCount + "\n"
				+ "Amount of Sofa in Sofa Warehouse: " + Sofa.storedCount + "\n"
				+ "Amount of Dresser in Dresser Warehouse: " + Dresser.storedCount + "\n"
				+ "Amount of Table in Table Warehouse: " + Table.storedCount + "\n"
				+ "Amount of Chair in Chair Warehouse: " + Chair.storedCount + "\n"
				+ "Amount of Bookcase in Bookcase Warehouse: " + Bookcase.storedCount + "\n");
				
                System.out.println("*********************************");
                
		System.out.println("Amount of Bed Sold: " + Bed.bedSoldCount + "\n"
				+ "Amount of Sofa Sold: " + Sofa.soldCount + "\n"
				+ "Amount of Dresser Sold: " + Dresser.soldCount + "\n"
				+ "Amount of Table Sold: " + Table.soldCount + "\n"
				+ "Amount of Chair Sold: " + Chair.soldCount + "\n"
				+ "Amount of Bookcase Sold:" + Bookcase.bookcaseSoldCount + "\n");
		System.out.println("THANK YOU FOR USING IZTECHEA!");
               
		
	}

}
