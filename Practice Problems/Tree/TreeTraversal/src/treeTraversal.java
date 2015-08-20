
public class treeTraversal {

	binaryTreeNode root;
	
	public void insert(int data)
    {
        root = insert(root, data);
    }
	
	private binaryTreeNode insert(binaryTreeNode node, int data) {
		if(node == null)
			node = new binaryTreeNode(data);
		else {
			if(node.getrNode()==null)
				node.rNode = insert(node.rNode, data);
			else
				node.lNode = insert(node.lNode, data);
		}
		return node;
	}

	public void inOrder() {
		System.out.println("InOrder");
		inOrder(root);
	}
	
	public void inOrder(binaryTreeNode subtreeRoot) {
		if(subtreeRoot != null) {
			inOrder(subtreeRoot.lNode);
			System.out.print(subtreeRoot.data + " ");
			inOrder(subtreeRoot.rNode);
		}
	}
	
	public void postOrder() {
		System.out.println("\nPost Order");
		postOrder(root);
	}
	
	private void postOrder(binaryTreeNode subtTreeRoot) {
		if(subtTreeRoot != null) {
			postOrder(subtTreeRoot.lNode);
			postOrder(subtTreeRoot.rNode);
			System.out.print(subtTreeRoot.data + " ");
		}
	}
	
	public void preOrder() {
		System.out.println("\nPreOrder");
		preOrder(root);
	}
	
	private void preOrder(binaryTreeNode subtreeRoot) {
		if(subtreeRoot != null) {
			System.out.print(subtreeRoot.data + " ");
			preOrder(subtreeRoot.lNode);
			preOrder(subtreeRoot.rNode);
		}
	}
	
}
