import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// This class takes the content of .txt file and stores the data in an array.
public final class FileIO {

	
	public static Item[] readInventory()
	{
		// array of items.
		Item[] items = new Item[14];
		
		try {
		      File myObj = new File("inventory.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] dataSplitted = data.split(",");  // splitting the data according to commas, and this process gives us the name, the kind and the weight of that item.
		        items[i] = new Item(dataSplitted[0], dataSplitted[1], Integer.parseInt(dataSplitted[2]));
		        i++;
		        
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return items;
	}
}
