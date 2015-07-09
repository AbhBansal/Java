package circularQueueArray;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Circular Queue using Array.
 * 
 */

import java.util.Scanner;

/*
 * QueueDriver class contains the logic for client testing i.e the functioning of Queue Program
 */

class QueueDriver {

	/*
	 * main function which drives the program, object of Qqueue is created and different operations are performed to test.
	 */
	
	public static void main(String[] args) {
		Qqueue queueObj = new Qqueue();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice != 5) {
			System.out.println("Array Implmentation");
			System.out.println("1. IsEmpty");
			System.out.println("2. Peek");
			System.out.println("3. Dequeue");
			System.out.println("4. Enqueue");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean bool=queueObj.IsEmpty();
				if(bool==true)
					System.out.println("Queue is Empty");
				else
					System.out.println("Queue contains Elements");
				break;
			case 2:
				try{
				int peekElement=queueObj.peek();
				System.out.println("Element at Front is: "+peekElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 3:
				try{
				int deqElement=queueObj.dequeue();
				System.out.println("Dequeued Element is: "+deqElement);
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter the Element you want to Enqueue: ");
				int enQElement=sc.nextInt();
				try{
					enQElement=queueObj.Enqueue(enQElement);
					System.out.println("Pushed Element is: "+enQElement);
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
