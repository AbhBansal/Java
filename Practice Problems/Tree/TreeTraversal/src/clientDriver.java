																													
public class clientDriver {

	public static void main(String[] args) {
		treeTraversal traversal = new treeTraversal();
		traversal.insert(1);
		traversal.insert(2);
		traversal.insert(3);
		traversal.insert(4);
		traversal.insert(7);
		traversal.insert(6);
		traversal.insert(5);
		traversal.inOrder();
		traversal.postOrder();
		traversal.preOrder();
	}
}
