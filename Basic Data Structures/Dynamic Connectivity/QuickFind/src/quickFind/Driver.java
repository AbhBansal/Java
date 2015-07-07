package quickFind;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to find the connectivity between two nodes using Quick Find Approach.
 * 
 * Cost:
 * Initialize = O(N)
 * Union = O(N)
 * find = O(1)
 */

/*
 * Driver class contains the logic for client testing i.e the functioning of QuickFind Program
 */

public class Driver {

	/*
	 * main function which drives the program, object of QuickFind is created and different operations are performed to test.
	 */
	
	public static void main(String[] args) {
		QuickFind QF = new QuickFind(8);
		System.out.println("Quick Find");
		System.out.println(QF.connected(1, 4));
		QF.union(1,4);
		System.out.println(QF.connected(1, 4));
		QF.union(2,5);
		QF.union(3,5);
		QF.union(1,5);
		System.out.println(QF.connected(5, 4));
		for(int counter = 0 ; counter < 7 ; counter++)
			System.out.println(counter + " and "+ (counter + 1) +" are connected "+   QF.connected(counter, counter+1));
	}
}
