package queueLinkedList;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Queue ADT using Singly Linked List.
 * 
 */

/*
 * Qqueue class contains the logic for isEmpty, enqueue and dequeue on Queue.
 * @var : front is the pointer to the front element of the queue or the first Element of the Linked List.
 * @var : rear is the pointer to the rear element of the queue or the last Element of the Linked List.
 */

public class Qqueue {

	private Node front, rear;

	/*
	 * Constructor which sets the front and rear pointer to null
	 */
	
	Qqueue() {
		front = null;
		rear = null;
	}

	/*
	 * private inner class for a node which contains a data field and an pointer field
	 * @var : data is used to store the data of the item
	 * @var : link will be the pointer to the next node of the list
	 */
	
	private class Node {
		String data;
		Node link;
	}

	/*
	 * isEmpty method is used to check if the queue is empty or not.
	 * @return : boolean, true if queue is empty else false.
	 */
	
	public boolean isEmpty() {
		return front == null;
	}

	/*
	 * enqueue method enqueue the element to the rear of the queue.
	 * @var : item is the new element which will be added to the rear of the queue.
	 * @return void
	 */
	
	public void enqueue(String item) {
		Node oldNode = rear;
		rear = new Node();
		rear.data = item;
		rear.link = null;
		if (isEmpty())
			front = rear;
		else
			oldNode.link = rear;
	}

	/*
	 * dequeue method is use to dequeue the front element of the queue.
	 * @return : String, which the front element of the queue
	 */
	
	public String dequeue() {
		if (!isEmpty()) {
			String data = front.data;
			front = front.link;
			if (isEmpty()) {
				rear = null;
			}
			return data;
		} 
		else
			throw new IllegalStateException("Queue is Empty");
	}
}
