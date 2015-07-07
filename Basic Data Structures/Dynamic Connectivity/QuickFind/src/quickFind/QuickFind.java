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
 * QuickFind class contains the logic for connected and Union functions.
 * @var : id is an integer array which is used to store the root of any node.
 */

public class QuickFind {
	private int[] id;
	
	/*
	 * Constructor which initialize id with appropriate size and set the root of node to itself.
	 * @param : n is number of nodes.
	 */
	
	public QuickFind(int n) {
		id = new int[n];
		for(int counter = 0; counter < n; counter++)
			id[counter] = counter;
	}

	/*
	 * Connected method check if the 2 nodes are connected or not
	 * @param : id1 is the number of node 1
	 * @param : id2 is the number of node 2
	 * @return : boolean, if they are connected it returns true else false.
	 */
	
	public boolean connected(int id1, int id2) {
		return (id[id1]==id[id2]);
	}
	
	/*
	 * Union method connects the two node and set the parent of one node to the other.
	 * @param : id1 is the number of node 1
	 * @param : id2 is the number of node 2
	 * @return : void.
	 */
	
	public void union(int id1, int id2) {
		int parentId1 = id[id1];
		int parentId2 = id[id2];
		for(int counter = 1; counter < id.length; counter++) {
			if (id[counter] == parentId1)
				id[counter] = parentId2;
		}
	}
}
