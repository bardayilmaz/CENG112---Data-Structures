public class Main {

	public static void main(String[] args) {
		
		IOSPriorityQueue processQueue = new OSProcessQueue();
		
		int[] counts = new int[] {3, 5, 10};
		int i = 0;
		
		while(i < counts.length)
		{
			Simulation sim = new Simulation(counts[i], processQueue);
			if(i < 2)
			{
				sim.setNext(new Simulation(counts[i+1], processQueue));				
			}
			sim.simulate();
			sim=sim.getNext();
			i++;
		}
		
	}
}
