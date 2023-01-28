public class OSProcessQueue implements IOSPriorityQueue {

	private Node firstNode;
	private Node lastNode;
	
	public OSProcessQueue()
	{
		firstNode = null;
		lastNode = null;
	}
	
	// enqueue function finds the proper location of computation by traversing the queue in a linear fashion and puts it there.
	@Override
	public void enqueue(Computation newEntry) {
		
		Node newNode = new Node(newEntry);
		
		if(isEmpty()) // if queue is empty, new entry is the first entry.
		{
			firstNode = newNode;
			lastNode = newNode;
		}
		else
		{
			Node currentNode = firstNode; // current checked node
			Node nodeBefore = null;  // previous node of currentNode
			
			while(currentNode != null) // if we are still in the queue
			{
				if(compare(newNode.getData().getProcess(), currentNode.getData().getProcess()))  // if newEntry has higher priority
				{
					if(currentNode == firstNode) // newEntry should be first element
					{
						newNode.setNextNode(currentNode);
						firstNode = newNode;
						break;
					}
					else if(currentNode == lastNode)  // newEntry should be last element
					{
						lastNode.setNextNode(newNode);
						lastNode = newNode;
						break;
					}
					else //newEntry is somewhere between first and last elements
					{
						nodeBefore.setNextNode(newNode); // previous node of currentNode now point newNode
						newNode.setNextNode(currentNode);  // newNode now points currentNode, so newNode places itself in between.
						break;
					}
					
					
				}
				else
				{
					if(currentNode == lastNode)  // newNode hasn't higher priority and we are at the end, so it should be last of queue
					{
						lastNode.setNextNode(newNode);
						lastNode = newNode;
						break;
					}
					nodeBefore = currentNode;
					currentNode = currentNode.getNextNode();
				}
				
			}
		}
		
	}

	@Override
	public Computation dequeue() {
		Computation front;
		
		if(!isEmpty())
		{
			front = getFront(); // Might throw EmptyQueueException
			firstNode.setData(null);
			firstNode = firstNode.getNextNode();
			
			if (isEmpty())
				lastNode = null;
			
			return front;
		}
		
		return null;
	}

	@Override
	public Computation getFront() {
		if(isEmpty())
			return null;
		
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;

	}
	
	private boolean compare(IProcess pr1, IProcess pr2)
	{
		return pr1.getPriority() <= pr2.getPriority(); // true if p1 has higher priority
		
	}
	
	private class Node
	{
		private Computation data;
		private Node next;
		
		private Node(Computation data_)
		{
			this(data_, null);
		}
		private Node(Computation data_, Node next_)
		{
			data = data_;
			next = next_;
		}
		
		private Computation getData()
		{
			return data;
		}
		
		private Node getNextNode()
		{
			return next;
		}
		
		private void setData(Computation newData)
		{
			data = newData;
		}
		
		private void setNextNode(Node newNextNode)
		{
			next = newNextNode;
		}
	}

}
