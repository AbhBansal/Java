
public class binaryTreeNode {
	
		int data;
		binaryTreeNode lNode = null;
		binaryTreeNode rNode = null;
		
		public binaryTreeNode(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public binaryTreeNode getlNode() {
			return lNode;
		}
		public void setlNode(binaryTreeNode lNode) {
			this.lNode = lNode;
		}
		public binaryTreeNode getrNode() {
			return rNode;
		}
		public void setrNode(binaryTreeNode rNode) {
			this.rNode = rNode;
		}
}
