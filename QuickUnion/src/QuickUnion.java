
public class QuickUnion {
	
	private int[] id;
	
	public QuickUnion(int n) {
		id = new int[n];
		for(int counter = 0 ; counter < n; counter++)
			id[counter] = counter;
	}
	
	public int root(int id1) {
		while(id[id1] != id1)
			id1 = id[id1];
		return id1;
	}
	
	public boolean connected(int id1, int id2) {
		return root(id1) == root(id2);
	}

	public void union(int id1, int id2) {
		int rootId1 = root (id1);
		int rootId2 = root (id2);
		id[rootId1] = rootId2;
	}
}
