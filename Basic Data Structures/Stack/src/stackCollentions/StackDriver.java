package stackCollentions;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Stack ADT using Stack Collections class.
 * 
 */

import java.util.Scanner;
import java.util.Stack;

/*
 * StackDriver class contains the logic for client testing i.e the functioning of Stack Program
 */

public class StackDriver {

	/*
	 * main function which drives the program and different operations are performed to test the functionality.
	 */
	
	public static void main(String[] args) {
		Stack<Integer> stackObj = new Stack<Integer>();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice != 5) {
			System.out.println("Collection Implementation");
			System.out.println("1. Empty");
			System.out.println("2. Peek");
			System.out.println("3. Pop");
			System.out.println("4. Push");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean bool=stackObj.isEmpty();					// Stack class isEmpty method is used.
				if(bool==true)
					System.out.println("Stack is Empty");
				else
					System.out.println("Stack contains Elements");
				break;
			case 2:
				try{
				int peekElement=stackObj.peek();					// Stack class peek method is used.
				System.out.println("Top Element is: "+peekElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 3:
				try{
				int popElement=stackObj.pop();						// Stack class pop method is used.
				System.out.println("Poped Element is: "+popElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter the Element you want to push: ");
				int pushElement=sc.nextInt();
				try{
					pushElement=stackObj.push(pushElement);			// Stack class push method is used.
					System.out.println("Pushed Element is: "+pushElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			}
		}
		sc.close();
	}
}
