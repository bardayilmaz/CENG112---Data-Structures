import java.util.Arrays;
import java.util.EmptyStackException;

public abstract class Warehouse<T> implements IStack<T> {

	
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	
	public Warehouse()
	{
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
		stack = tempStack;
		topIndex = -1;
		initialized = true;	
	}
	
	@Override
	public void push(T newEntry) {  // adding
		checkInitalization();
		ensureCapacity();
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T pop() {  // removing
		checkInitalization();
		
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = peek();
			stack[topIndex] = null;
			topIndex--;
			return top;
		} 
	}

	@Override
	public T peek() {  // show last if not empty
		checkInitalization();
		
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}

	@Override
	public boolean isEmpty() {  // is it empty or not
		return topIndex < 0;
	}

	@Override
	public void clear() {
		while(!isEmpty())
		{
			pop();
		}
	}
	
	private void ensureCapacity()  // capacity control
	{
		if (topIndex == stack.length - 1) // If array is full, double its size
		{
		int newLength = 2 * stack.length;
		stack = Arrays.copyOf(stack, newLength);
		}
	}
	
	private void checkInitalization()
	{
		if(!initialized)
			throw new SecurityException("Stack object is not initialized properly.");
	}

}
