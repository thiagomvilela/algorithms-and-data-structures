
public class BinarySearchTree {

	private BinaryTreeNode root;
	
	public void add(int data) {
		if (this.root == null) {
			this.root = new BinaryTreeNode(data);
		} else {
			addInternal(this.root, data);
		}
	}
	
	private void addInternal(BinaryTreeNode node, int data) {
		if(data < node.getData()) {
			if (node.getLeft() == null) {
				node.setLeft(new BinaryTreeNode(data));
			} else {
				addInternal(node.getLeft(), data);
			}
		} else if (data > node.getData()) {
			if (node.getRight() == null) {
				node.setRight(new BinaryTreeNode(data));
			} else {
				addInternal(node.getRight(), data);
			}
		}
	}
	
	public void remove(int data) {
		removeInternal(this.root, data);
	}
	
	private BinaryTreeNode removeInternal(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (data == node.getData()) {
			if (node.getLeft() == null && node.getRight() == null) {
				return null;
			} else if (node.getLeft() == null || node.getRight() == null) {
				if (node.getLeft() == null) {
					return node.getRight();
				} else {
					return node.getLeft();
				}
			} else {
				BinaryTreeNode largestAntecessor = node.getLeft();
				while (largestAntecessor.getRight() != null) {
					largestAntecessor = largestAntecessor.getRight();
				}
				
				node.setData(largestAntecessor.getData());
				node.setLeft(removeInternal(node.getLeft(), largestAntecessor.getData()));
				return node;
			}
		} else if (data < node.getData()) {
			node.setLeft(removeInternal(node.getLeft(), data));
			return node;
		} else {
			node.setRight(removeInternal(node.getRight(), data));
			return node;
		}
	}
	
	public boolean contains(int data) {
		boolean toReturn = false;
		if (this.root != null) {
			toReturn = containsInternal(this.root, data);
		}
		return toReturn;
	}
	
	private boolean containsInternal(BinaryTreeNode node, int data) {
		if (node == null) {
			return false;
		} else {
			if(data == node.getData()) {
				return true;
			} else if (data < node.getData()) {
				return containsInternal(node.getLeft(), data);
			} else {
				return containsInternal(node.getRight(), data);
			}
		}
	}

	public void traversePreOrder() {
		traversePreOrderInternal(this.root);
	}
	
	private void traversePreOrderInternal(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.getData() + ", ");
			traversePreOrderInternal(node.getLeft());
			traversePreOrderInternal(node.getRight());
		}
	}
	
	public void traverseInOrder() {
		traverseInOrderInternal(this.root);
	}
	
	private void traverseInOrderInternal(BinaryTreeNode node) {
		if (node != null) {
			traverseInOrderInternal(node.getLeft());
			System.out.print(node.getData() + ", ");
			traverseInOrderInternal(node.getRight());
		}
	}
	
	public void traversePostOrder() {
		traversePostOrderInternal(this.root);
	}
	
	private void traversePostOrderInternal(BinaryTreeNode node) {
		if (node != null) {
			traversePostOrderInternal(node.getLeft());
			traversePostOrderInternal(node.getRight());
			System.out.print(node.getData() + ", ");
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(5);
		tree.add(10);
		tree.add(2);
		tree.add(4);
		tree.add(7);
		tree.add(3);
		tree.add(8);
		tree.add(1);
		tree.add(6);
		tree.add(9);
//		tree.add(5);
		
//		tree.traversePreOrder();
//		System.out.println();
//		tree.traverseInOrder();
//		System.out.println();
//		tree.traversePostOrder();
//		
//		System.out.println();
//		
//		System.out.println(tree.contains(8));
//		System.out.println(tree.contains(10));
//		System.out.println(tree.contains(-20));
//		System.out.println(tree.contains(5));
//		System.out.println(tree.contains(100));
		
		tree.traversePreOrder();
		System.out.println();
		
		tree.remove(5);
		
		tree.traversePreOrder();
		System.out.println();
	}
	
}
