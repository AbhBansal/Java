public class WeightedQUPathCompression {

	private int[] id;
	private int[] size;

	public WeightedQUPathCompression(int n) {
		id = new int[n];
		size = new int[n];
		for (int counter = 0; counter < n; counter++) {
			id[counter] = counter;
			size[counter] = 0;
		}
	}

	public int root(int id1) {
		while (id[id1] != id1){
			id[id1] = id[id[id1]];
			id1 = id[id1];
		}
		return id1;
	}

	public boolean connected(int id1, int id2) {
		return root(id1) == root(id2);
	}

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
