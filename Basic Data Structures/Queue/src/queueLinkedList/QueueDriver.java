package queueLinkedList;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to implement basic operations of Queue ADT using Singly Linked List.
 * 
 */

import java.util.Scanner;

/*
 * QueueDriver class contains the logic for client testing i.e the functioning of Queue Program
 */

public class QueueDriver {

	/*
	 * main function which drives the program, object of Qqueue is created and different operations are performed to test.
	 */
	
	public static void main(String[] args) {

		Qqueue queueObj = new Qqueue();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		while (choice != 4) {
			System.out.println("Queue Linked List Implementation");
			System.out.println("1. Empty");
			System.out.println("2. Dequeue");
			System.out.println("3. Enqueue");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean bool = queueObj.isEmpty();
				if (bool == true)
					System.out.println("Queue is Empty");
				else
					System.out.println("Queue contains Elements");
				break;
			case 2:
				try {
					String dequeueElement = queueObj.dequeue();
					System.out.println("Dequeued Element is: " + dequeueElement);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter the Element you want to Enqueue: ");
				String enqueueElement = sc.next();
				try {
					queueObj.enqueue(enqueueElement);
					System.out.println("Enqueued Element");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				break;

			}
		}
		sc.close();
	}
}
