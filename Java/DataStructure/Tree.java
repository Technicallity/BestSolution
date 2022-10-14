import java.util.List;
import java.util.Random;




public class Tree {
	

	class Node {

		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node insert(Node node, int data) {

		if (node == null) {
			node = new Node(data);
			return node;
		}

		if (data == node.data) {
			System.out.println("Duplicate Data...");
		} else if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		}

		return node;
	}

	private void inorder(Node node) {
		if (node.left == null && node.right == null) {
			System.out.print(node.data + "\t\t");
			return;
		}

		if (node.left != null) {
			inorder(node.left);
			System.out.print(node.data + "\t\t");
			if (node.right != null)
				inorder(node.right);
		} else if (node.right != null) {
			System.out.print(node.data + "\t\t");
			inorder(node.right);
		}
	}

	private void postorder(Node node) {
		if (node.left == null && node.right == null) {
			System.out.print(node.data + "\t\t");
			return;
		}
		if (node.left != null) {
			postorder(node.left);
			if (node.right != null)
				postorder(node.right);
			System.out.print(node.data + "\t\t");
		} else if (node.right != null) {
			postorder(node.right);
			System.out.print(node.data + "\t\t");
		}
	}

	private void preorder(Node node) {
		if (node.left == null && node.right == null) {
			System.out.print(node.data + "\t\t");
			return;
		}
		if (node.left != null) {
			System.out.print(node.data + "\t\t");
			preorder(node.left);
			if (node.right != null)
				preorder(node.right);
		} else if (node.right != null) {
			System.out.print(node.data + "\t\t");
			preorder(node.right);
		}
	}

	private int getSum(Node node) {
		/*
		 * int sum=0; if (node.left == null && node.right == null) { return node.data; }
		 * if(node.left!=null) { sum+=getSum(node.left); sum+=node.data; if (node.right
		 * != null) sum+=getSum(node.right); }else if(node.right != null) {
		 * sum+=getSum(node.right); sum+=node.data; } return sum;
		 */

		if (node == null) {
			return 0;
		}

		return node.data + getSum(node.left) + getSum(node.right);
	}

	public int getNodeCount(Node node) {

		if (node == null) {
			return 0;
		}

		/*
		 * int count = 0; if (node.left == null && node.right == null) { return 1; }
		 * 
		 * if (node.left != null) { count += getNodeCount(node.left); count++; if
		 * (node.right != null) count += getNodeCount(node.right); } else { count++;
		 * count += getNodeCount(node.right); }
		 * 
		 * return count;
		 */

		return 1 + getNodeCount(node.left) + getNodeCount(node.right);
	}

	public int getLeafNodeCount(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return getLeafNodeCount(node.left) + getLeafNodeCount(node.right);
	}

	private int getHeight(Node node, int data) {
		
		getLeafNodeCount(node);
		
		int count = 0;

		if (node.left == null & node.right == null) {
			return 0;
		}

		if (node.left != null && node.left.data == data) {
			return 1;
		}

		if (node.right != null && node.right.data == data) {
			return 1;
		}

		if (data < node.data) {

			if (node.left == null) {
				count = -1;
				System.out.println("ELEMENT NOT FOUND..");
				return -1;
			} else {
				count++;
				count += getHeight(node.left, data);
			}

		} else if (data > node.data) {

			if (node.right == null) {
				count = -1;				
				System.out.println("ELEMENT NOT FOUND..");
				return -1;
			} else {
				count++;
				count += getHeight(node.right, data);
			}

		}

		return count;
	}

	public static void main(String[] args) {

		Random random = new Random();
		Node root = null;
		Tree tree = new Tree();

		root = tree.insert(root, 503);
		root = tree.insert(root, 185);
		root = tree.insert(root, 838);
		root = tree.insert(root, 424);
		root = tree.insert(root, 954);

		// for (int i = 0; i < 50; i++) {
		// int value = random.nextInt(10000);
		// System.out.println("Inserting " + value);
		// root = tree.insert(root, value);
		// }

		tree.inorder(root);
		System.out.println();
		tree.postorder(root);
		System.out.println();
		tree.preorder(root);
		System.out.println();
		System.out.println(tree.getSum(root));
		// System.out.println(tree.getNodeCount(root));
		// System.out.println(tree.getLeafNodeCount(root));
		System.out.println(tree.getHeight(root, 424));
		System.out.println(tree.getHeight(root, 503));
		System.out.println(tree.getHeight(root, 838));
		System.out.println(tree.getHeight(root, 945));
		System.out.println(tree.getHeight(root, 2));
		
		
		
	}

}
