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

/*
 * WeightedQUPathCompression class contains the logic for connected, Union method and a method to find the root of a node.
 * @var : id is an integer array which is used to store the root of any node.
 * @var : size is an array which stores the number of Predecessors of the node  
 */

public class WeightedQUPathCompression {

	private int[] id;
	private int[] size;

	/*
	 * Constructor which initialize id with appropriate size and set the root of node to itself. The size of each node is initialized to 0
	 * @param : n is number of nodes.
	 */
	
	public WeightedQUPathCompression(int n) {
		id = new int[n];
		size = new int[n];
		for (int counter = 0; counter < n; counter++) {
			id[counter] = counter;
			size[counter] = 0;
		}
	}

	/*
	 * Root method find the root of a node by looking into the id array. If Path is long it is compressed by setting the root to Grandparent.
	 * @param : id1 is the number of node 1
	 * return : int, the root node is returned.
	 */
	
	public int root(int id1) {
		while (id[id1] != id1){
			id[id1] = id[id[id1]];     //Path Compression
			id1 = id[id1];
		}
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
	 * Union method connects the two node and set the parent of one node to the other. Size of node is also set accordingly.
	 * @param : id1 is the number of node 1
	 * @param : id2 is the number of node 2
	 * @return : void.
	 */
	
	public void union(int id1, int id2) {
		int rootId1 = root(id1);
		int rootId2 = root(id2);
		if (rootId1 == rootId2)
			return;
		else {
			if (size[rootId1] > size[rootId2]) {
				id[rootId2] = rootId1;
				size[rootId1] = +size[rootId2];
			} else {
				id[rootId1] = rootId2;
				size[rootId2] = +size[rootId1];

			}
		}
	}
}
