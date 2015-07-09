package stackArray;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Stack ADT using Array.
 * 
 */

import java.util.Scanner;

/*
 * StackDriver class contains the logic for client testing i.e the functioning of Stack Program
 */

public class StackDriver {

	/*
	 * main function which drives the program, object of Sstack is created and different operations are performed to test.
	 */

	public static void main(String[] args) {
		Sstack stackObj = new Sstack(5);
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice != 5) {
			System.out.println("Array Implmentation");
			System.out.println("1. Empty");
			System.out.println("2. Peek");
			System.out.println("3. Pop");
			System.out.println("4. Push");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean bool=stackObj.empty();
				if(bool==true)
					System.out.println("Stack is Empty");
				else
					System.out.println("Stack contains Elements");
				break;
			case 2:
				try{
				String peekElement=stackObj.peek();
				System.out.println("Top Element is: "+peekElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 3:
				try{
				String popElement=stackObj.pop();
				System.out.println("Poped Element is: "+popElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter the Element you want to push: ");
				String pushElement=sc.next();
				try{
					stackObj.push(pushElement);
					System.out.println("Pushed Element");
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
