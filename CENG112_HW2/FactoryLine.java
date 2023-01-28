
public class FactoryLine<T> implements IQueue<T> {

	private T[] line;
	
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private final static int DEFAULT_CAPACITY = 6;  // we have 6 product
	private final static int MAX_CAPACITY = 10000;
	
	
	public FactoryLine() {		
		@SuppressWarnings("unchecked")
		T[] tempLine = (T[]) new Object[DEFAULT_CAPACITY+1];
		line = tempLine;
		
		frontIndex = 0;
		backIndex = DEFAULT_CAPACITY;
		initialized = true;
	}
	
	@Override
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		
		backIndex = (backIndex + 1 ) % line.length;
		line[backIndex] = newEntry;

	} 

	@Override
	public T dequeue() {
		checkInitialization();
		
		if(isEmpty())
			return null;
		else
		{
			T front = line[frontIndex];
			line[frontIndex] = null;
			frontIndex = (frontIndex + 1) % line.length;
			return front;
		} 
	}

	@Override
	public T getFront() {
		if(isEmpty())
		{
			return null;
		} 
		else
			return line[frontIndex];
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % line.length);
	}

	@Override
	public void clear() {
		while(!isEmpty())
		{
			dequeue();
		} 
	} 
	
	private void ensureCapacity()
	{
		if(frontIndex == ((backIndex + 2 ) % line.length))  // queue is full (with one unused location)
		{
			T[] oldFactoryLine = line;
			int oldSize = oldFactoryLine.length;
			int newSize = 2 * oldSize;
			
			@SuppressWarnings("unchecked")
			T[] tempLine = (T[]) new Object[newSize];
			line = tempLine;
			
			for(int index = 0; index < oldSize-1;index++)
			{
				line[index] = oldFactoryLine[frontIndex];
				frontIndex = (frontIndex +1 ) % oldSize;
			} 
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	} 
	
	private void checkInitialization()
	{
		if(!initialized)
			throw new SecurityException("Queue object is not initialized properly.");
	}

}
