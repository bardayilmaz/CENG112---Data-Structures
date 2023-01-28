public final class ShoppingBag<T> implements IBag<T> {

	
	private final T[] bag;
	private int itemCount = 0;
	private final static int ITEM_LIMIT = 9; // lightest item of the list weighs 250 gram. So, 2000 grams / 250 grams = 8.
	
	
	// constructor of the shopping bag, declares an array.
	public ShoppingBag()
	{
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[ITEM_LIMIT]; // Unchecked cast
		bag = tempBag;
	}
	@Override
	public boolean add(T newItem) {
		if(!isFull())  // if the array is not full...
		{
			bag[itemCount] = newItem;  // assign the item to the top of array.
			itemCount++; // increase item count
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return itemCount == 0;
	}

	@Override
	public boolean isFull() {
		return itemCount == bag.length;
	}

	@Override
	public T removeByIndex(int index) {
		if(index < itemCount)  // if the given index is valid...
		{
			swap(index, itemCount-1);  // swap that object with the top object of array
			return remove();  // and remove it
		}
		System.out.println("There is not an item in the bag with the given index");
		return null;
	}

	@Override
	public T remove() {
		if(!isEmpty()) // if the array is not empty...
		{
			T itemToBeRemoved = bag[itemCount-1];  // we need that item to return it.
			bag[itemCount-1] = null;
			itemCount--;
			return itemToBeRemoved;			
		}
		return null;  // array is empty, can not remove someting.
	}

	@Override
	public T remove(T item) {
		int i = getIndexOf(item);  // getting index of that item
		if(i != -1)  // if that item exists...
		{
			swap(itemCount-1, i);
			return remove();	
		}
			return null;
	}

	@Override
	public int getItemCount() {
		return itemCount;
	}

	@Override
	public int getIndexOf(T item) {
		for(int i = 0; i < itemCount; i++)  // linear search.
		{
			if(bag[i].equals(item))
				return i;
		}
		return -1;  // item is not in the array.
	}

	@Override
	public boolean contains(T item) {
		for(int i = 0; i < itemCount; i++)  // linear search but does not return index.
		{
			if(bag[i].equals(item))
				return true;
		}
			
		return false;
	}

	@Override
	public void displayItems() {
		for(int i = 0; i < itemCount; i++)  
			System.out.println(bag[i]);
	}

	@Override
	public void dump() {
		while(!isEmpty())
		{
			remove();
		}
		
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		if(targetBag.add(item))  // if can add to a bag, it adds.
		{
			return true;
		}
		System.out.println("Could not transfer. ");
		return false;
	}
	
	private void swap(int index1 , int index2)
	{
		T temp = bag[index1];
		bag[index1] = bag[index2];
		bag[index2] = temp;
	}

}
