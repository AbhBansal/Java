package quickUnion;
/*  
 * @author Abhishek Bansal
 * @email-id abhi.bansal08@gmail.com
 * @version 1.0
 * 
 * Program to find the connectivity between two nodes using Quick Union (lazy Approach) Approach.
 * 
 * Cost(Worst case):
 * Initialize = O(N)
 * Union = O(N)
 * find = O(N)
 */


/*
 * QuickUnion class contains the logic for connected, Union method and a method to find the root of a node.
 * @var : id is an integer array which is used to store the root of any node.
 */

public class QuickUnion {
	
	private int[] id;
	
	/*
	 * Constructor which initialize id with appropriate size and set the root of node to itself.
	 * @param : n is number of nodes.
	 */
	
	public QuickUnion(int n) {
		id = new int[n];
		for(int counter = 0 ; counter < n; counter++)
			id[counter] = counter;
	}
	
	/*
	 * Root method find the root of a node by looking into the id array.
	 * @param : id1 is the number of node 1
	 * return : int, the root node is returned.
	 */
	
	public int root(int id1) {
		while(id[id1] != id1)
			id1 = id[id1];
		return id1;
	}
	
	/*
	 * Connected method check if the 2 nodes are connected or not
	 * @param : id1 is the number of node 1
	 * @param : id2 is the number of node 2
	 * @return : boolean, if they are connected it returns true else false.
	 */
	
	public boolean connected(int id1, int id2) {
		return root(id1) == root(id2);
	}

	/*
	 * Union method connects the two node and set the parent of one node to the other.
	 * @param : id1 is the number of node 1
	 * @param : id2 is the number of node 2
	 * @return : void.
	 */
	
	public void union(int id1, int id2) {
		int rootId1 = root (id1);
		int rootId2 = root (id2);
		id[rootId1] = rootId2;
	}
}
