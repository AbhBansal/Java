package stackArray;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Stack ADT using Array.
 * 
 */

/*
 * Sstack class contains the logic for isEmpty, peek, pop and push on stack.
 * @var : stack is an String array which is used to store the elements.
 * @var : top is the pointer the top element of the stack.
 */

class Sstack {
	private String stack[];
	private int top;

	/*
	 * Constructor which create a stack with required capacity and setting top to 0
	 * @param : capacity is the size of the stack.
	 */
	
	Sstack(int capacity) {
		stack = new String[capacity];
		top = 0;
	}

	/*
	 * empty method is used to check if the stack is empty or not.
	 * @return : boolean, true is stack is empty else false.
	 */
	
	public boolean empty() {
		return top==0;
	}

	/*
	 * peek method is use to look the top element of the stack without deleting it.
	 * @return : string, which the top element of the stack
	 */
	
	public String peek() {
		if (top == 0)
			throw new IllegalStateException("Stack is Empty");
		else
			return stack[top-1];
	}

	/*
	 * pop method is use to pop the top element of the stack.
	 * @return : string, which the top element of the stack
	 */
	
	String pop() {
		if (top == 0)
			throw new IllegalStateException("Stack is Empty");
		else {
			String item = stack[--top];
			stack[top] = null;
			return item;
		}
	}

	/*
	 * push method pushes the element to the top of the stack.
	 * @var : element is the new element which will be added to the stack.
	 * @return void.
	 */
	
	void push(String element) {
		if (top == stack.length)
			throw new IllegalStateException("Stack is Full");
		else {
			stack[top++] = element;
		}
	}
}
