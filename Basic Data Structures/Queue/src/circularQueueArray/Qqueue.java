package circularQueueArray;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Circular Queue using Array.
 * 
 */

/*
 * Qqueue class contains the logic for isEmpty, enqueue and dequeue on Queue.
 * @var : front is the pointer to the front element of the queue .
 * @var : rear is the pointer to the rear element of the queue.
 */

class Qqueue {
	int Storage[];
	int front, rear;
	int Capacity;
	
	/*
	 * Constructor which sets the front, rear and Capacity to zero and instantiate the array of size 5.
	 */
	
	Qqueue() {
		Storage = new int[5];
		front = 0;
		rear = 0;
		Capacity=0;
	}

	/*
	 * isEmpty method is used to check if the queue is empty or not.
	 * @return : boolean, true if queue is empty else false.
	 */
	
	boolean IsEmpty() {
		if (Capacity==0)
			return true;
		else {
			return false;
		}
	}

	/*
	 * peek method is use to peek the front element of the queue which will not delete the front element.
	 * @return : int, which the front element of the queue
	 */
	
	int peek() {
		if (!IsEmpty()) {
			int element = Storage[front];
			return element;
		} else {
			throw new IllegalStateException("Queue is Empty");
		}
	}

	/*
	 * dequeue method is use to dequeue the front element of the queue.
	 * @return : int, which the front element of the queue
	 */
	
	int dequeue() {
		if (!IsEmpty()) {
			int element = Storage[front];
			front = (front + 1) % Storage.length;
			Capacity--;
			return element;
		} else {
			throw new IllegalStateException("Queue is Empty");
		}
	}

	/*
	 * enqueue method enqueue the element to the rear of the queue.
	 * @var : element is the new element which will be added to the rear of the queue.
	 * @return int, the element which is added.
	 */
	
	int Enqueue(int element) {
		if (Capacity==Storage.length) {
			throw new IllegalStateException("Queue is Full");
		} else {
			Storage[rear] = element;
			rear = (rear + 1) % Storage.length;
			Capacity++;
			return element;
		}
	}
}
