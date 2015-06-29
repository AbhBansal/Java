
public class QuickFind {
	private int[] id;
	
	public QuickFind(int n) {
		id = new int[n];
		for(int counter = 0; counter < n; counter++)
			id[counter] = counter;
	}

	public boolean connected(int id1, int id2) {
		return (id[id1]==id[id2]);
	}
	
	public void union(int id1, int id2) {
		int parentId1 = id[id1];
		int parentId2 = id[id2];
		for(int counter = 1; counter < id.length; counter++) {
			if (id[counter] == parentId1)
				id[counter] = parentId2;
		}
	}
}
