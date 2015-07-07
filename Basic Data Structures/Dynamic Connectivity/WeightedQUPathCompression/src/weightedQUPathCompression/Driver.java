package weightedQUPathCompression;

/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to find the connectivity between two nodes using Weighted (Number of nodes connected to the node) Quick Union using Path Compression Approach.
 * 
 * Cost: N + M (lg* N) - N Nodes and M Union-Find operations
 * Initialize = O(N)
 * Union = O(lg* N)
 * find = O(Lg* N)
 */

public class Driver {

	/*
	 * main function which drives the program, object of WeightedQUPathCompression is created and different operations are performed to test.
	 */
	
	public static void main(String[] args) {
		WeightedQUPathCompression WQU = new WeightedQUPathCompression(8);
		System.out.println("Weighted Quick Union with Path Compression");
		System.out.println(WQU.connected(1, 4));
		WQU.union(1,4);
		System.out.println(WQU.connected(1, 4));
		WQU.union(2,5);
		WQU.union(3,5);
		WQU.union(1,5);
		System.out.println(WQU.connected(5, 4));
		for(int counter = 0 ; counter < 7 ; counter++)
			System.out.println(counter + " and "+ (counter + 1) +" are connected "+   WQU.connected(counter, counter+1));
	}
}
