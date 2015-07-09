package stackLinkedList;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Stack ADT using Singly Linked List.
 * 
 */

/*
 * Sstack class contains the logic for isEmpty, peek, pop and push on stack.
 * @var : top is the pointer the top element of the stack or first Element of the Linked List.
 */

class Sstack {
	private Node top;

	/*
	 * Constructor which sets the top pointer to null
	 */
	
	Sstack() {
		top = null;
	}

	/*
	 * private inner class for a node which contains a data field and an pointer field
	 * @var : data is used to store the data of the item
	 * @var : link is the pointer to the next node of the list
	 */
	
	private class Node {
		int data;
		Node link;
	}

	/*
	 * isEmpty method is used to check if the stack is empty or not.
	 * @return : boolean, true is stack is empty else false.
	 */
	
	public boolean isEmpty() {
		return top == null;
	}

	/*
	 * peek method is use to look the top element of the stack without deleting it.
	 * @return : int, the top element of the stack
	 */
	
	int peek() {
		if (top != null)
			return top.data;
		else
			throw new IllegalStateException("Stack is Empty");
	}

	/*
	 * pop method is use to pop the top element of the stack.
	 * @return : int, which the top element of the stack
	 */
	
	int pop() {
		if (top != null) {
			int element = top.data;
			top = top.link;
			return element;
		} else
			throw new IllegalStateException("Stack is Empty");
	}

	/*
	 * push method pushes the element to the top of the stack.
	 * @var : element is the new element which will be added to the stack.
	 * @return int, the element which is added.
	 */
	
	int push(int element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.link = top;
		top = newNode;
		return top.data;
	}
}
