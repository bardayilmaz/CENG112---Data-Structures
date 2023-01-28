import java.util.Random;

public class Marketing_Analyst {

	Random rnd;
	
	public Marketing_Analyst()
	{
		rnd = new Random();
	}
	
	public void manufacture(IQueue line)
	{
		int productIndex = rnd.nextInt(6);
		
		switch(productIndex)  // check for product
		{
		case 0:
			Sofa sofa = new Sofa();
			sofa.manufacture();
			line.enqueue(sofa);
			System.out.println("Marketing analyst has manufactured " + sofa+".");
			break;
		case 1:
			Bed bed = new Bed();
			bed.manufacture();
			line.enqueue(bed);
			System.out.println("Marketing analyst has manufactured " + bed+".");
			break;
		case 2:
			Chair chair = new Chair();
			chair.manufacture();
			line.enqueue(chair);
			System.out.println("Marketing analyst has manufactured " + chair+".");
			break;
		case 3:
			Dresser dresser = new Dresser();
			dresser.manufacture();
			line.enqueue(dresser);
			System.out.println("Marketing analyst has manufactured " + dresser+".");
			break;
		case 4:
			Table table = new Table();
			table.manufacture();
			line.enqueue(table);
			System.out.println("Marketing analyst has manufactured " + table+".");
			break;
		case 5:
			Bookcase bookcase = new Bookcase();
			bookcase.manufacture();
			line.enqueue(bookcase);
			System.out.println("Marketing analyst has manufactured " + bookcase+".");
			break;
		}
	}
	
	public Product sendToWarehouse(IQueue line)  // removes the product form factory line
	{
		if(!line.isEmpty())
		{
			Product removed =  (Product)line.dequeue();
			return removed;	
		}
		else
		{
			return null;
		}
	}
	
	
}
