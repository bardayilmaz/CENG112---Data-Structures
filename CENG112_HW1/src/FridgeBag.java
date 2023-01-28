
public final class FridgeBag<T> implements IBag<T> {

	
	private final T[] bag;
	private int itemCount;
	private final static int ITEM_LIMIT = 57;  // 14000 grams / 250 grams = 56, we gave +1 of it.
	
	
	public FridgeBag()
	{
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[57]; // Unchecked cast
		bag = tempBag;
		itemCount = 0;
	}
	
	@Override
	public boolean add(T newItem) {
		if(!isFull())
		{
			bag[itemCount] = newItem;
			itemCount++;
			return true;
		}
		System.out.println("Fridge is full.");
		return false;
	}

	@Override
	public boolean isEmpty() {
		return itemCount == 0;
	}

	@Override
	public boolean isFull() {
		return itemCount == ITEM_LIMIT-1;
	}

	
	
	// Since these functions are not used in the shopping app, we did not implement them. They are same with the shopping bag.
	
	@Override
	public T removeByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOf(T item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		// TODO Auto-generated method stub
		return false;
	}

}
