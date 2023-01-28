
public interface IOSPriorityQueue {

public void enqueue(Computation newEntry);
	
	public Computation dequeue();
	
	public Computation getFront();
	
	public boolean isEmpty();
	
	public void clear();
}
