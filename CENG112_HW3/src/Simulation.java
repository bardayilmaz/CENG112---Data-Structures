import java.util.Random;

public class Simulation {
		
	private Simulation nextSimulation;
	
	private Random rn;
	
	private static int simulationNumber = 1;
	
	private int num;
	
	private int computationCount;
	private int totalTime;
	private int averageTime;
	
	private int totalHighCount;
	private int totalHighTime;
	private int averageHighTime;
	
	private int totalNormalCount;
	private int totalNormalTime;
	private int averageNormalTime;
	
	private int totalLowCount;
	private int totalLowTime;
	private int averageLowTime;
	
	private IOSPriorityQueue compQue;
	
	private String computationQueueStr;
	
	public Simulation(int _computationcount, IOSPriorityQueue queue)
	{
		rn = new Random();
		
		num = simulationNumber;
		simulationNumber++;
		computationCount = _computationcount;
		
		totalTime = 0;
		averageTime = 0;
		
		totalHighCount = 0;
		totalHighTime = 0;
		averageHighTime = 0; 
		
		totalNormalCount = 0;
		totalNormalTime = 0;
		averageNormalTime = 0;
		
		totalLowCount = 0;
		totalLowTime = 0;
		averageLowTime = 0;
		
		compQue = queue;
		
		computationQueueStr = "";
	}
	
	public void simulate()
	{
		int processCount = computationCount;
		for(int i = 0; i < processCount; i++)
		{
			Computation cmp = new Computation(i+1, getRandomProcess(), getRandomTime());  // creating random computations
			compQue.enqueue(cmp); // and getting them into the queue.
			
			if(cmp.getProcess().getType().equals("High"))
			{
				totalHighCount++;
				totalHighTime += cmp.getOccupation();
			}
			else if(cmp.getProcess().getType().equals("Normal"))
			{
				totalNormalCount++;
				totalNormalTime+= cmp.getOccupation();
			}
			else if(cmp.getProcess().getType().equals("Low"))
			{
				totalLowCount++;
				totalLowTime+= cmp.getOccupation();
			}

		}
		for(int j = 0; j< processCount; j++)  // this can be visualized as "executing prcesses"
		{
			Computation cmp = compQue.dequeue();
			
			if(j != processCount-1)
				computationQueueStr = computationQueueStr.concat(cmp.toString() + " ← ");
			else
				computationQueueStr = computationQueueStr.concat(cmp.toString());
		}
		
		displaySimulationResults();
		
	// creates processes with random priorities	
	}
	
	private int getRandomTime()
	{
		int time = (int)(10*rn.nextFloat()) +1;
		totalTime += time;
		return time;
	}
	
	private IProcess getRandomProcess()
	{
		int processType = rn.nextInt(3)+1; // 1, 2, 3
		
		IProcess process;
		
		switch(processType)
		{
		case 1:
			process = new Process("High");
			break;
		case 2:
			process = new Process("Normal");
			break;
		case 3:
			process = new Process("Low");
			break;
		default:
			process = null;
			break;
		}
		
		return process;
	}
	
	public void displaySimulationResults()
	{
		System.out.println("\nSimulation Number: " + num+
				"\nComputation Queue: " + computationQueueStr+
				"\nTotal Waiting Time: "+totalTime+"\nAverage Waiting Time: "+ (float)totalTime/computationCount+
				
				"\n\nTotal number of computations for High: " + totalHighCount+"\nTotal number of computations for Normal: "+totalNormalCount+
				"\nTotal number of computations for Low: " + totalLowCount);
				
		
		System.out.print("\nTotal waiting time for High: " + totalHighTime );
		if(totalHighCount > 0)
			System.out.println("\nAverage waiting time for High: " + (float)totalHighTime/totalHighCount);
		else
			System.out.println("\nAverage waiting time for High: 0");
		
		
		System.out.print("\nTotal waiting time for Normal: " + totalNormalTime);
		if(totalNormalCount > 0)
			System.out.println("\nAverage waiting time for Normal: " + (float)totalNormalTime/totalNormalCount);
		else
			System.out.println("\nAverage waiting time for Normal: 0");
			
		
		System.out.print("\nTotal waiting time for Low: " + totalLowTime);
		if(totalLowCount>0)
			System.out.println("\nAverage waitign time for Low: " + (float)totalLowTime/totalLowCount);
		else
			System.out.println("\nAverage waitign time for Low: 0");
				
				System.out.println("\n-------------------------------------------");
	}



	public Simulation getNext()
	{
		return nextSimulation;
	}
	
	public void setNext(Simulation sim)
	{
		nextSimulation = sim;
	}
}
