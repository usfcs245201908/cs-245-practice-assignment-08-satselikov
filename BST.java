public class BST<T> {

	private Node head;

	// constructor
	BST() {
		head = null;
	}

	public boolean find(Comparable item) {
		return find(head, item);
	}

	private boolean find(Node node, Comparable item) {
		if (node == null) {
			return false;
		}
		if (node.data.compareTo(item) == 0) {
			return true;
		} else if (node.data.compareTo(item) > 0) {
			return find(node.left, item);
		} else {
			return find(node.right, item);
		}
	}

	public void insert(Comparable item) {
		head = insert(head, item);
	}

	private Node insert(Node node, Comparable item) {

		if (node == null) { // base case
			Node n = new Node(item);
			return n;
		}

		if (node.data.compareTo(item) < 0) {
			node.right = insert(node.right, item);
			return node;
		}

		else {
			node.left = insert(node.left, item);
			return node;
		}

	}

	public void print() {
		print(head);
	}

	private void print(Node node) {

		if (node != null) {
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	public void delete(Comparable item) {
		head = delete(head, item);
	}

	private Node delete(Node node, Comparable item) {
		if (node == null) { // base case
			return null;
		}
		if (node.data.compareTo(item) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeitem(node.right);
					return node;
				}
			}
		} else if (node.data.compareTo(item) < 0) {
			node.right = delete(node.left, item);
		} else {
			delete(node.left, item);
		}

		return node;
	}

	Comparable removeitem(Node node) {

		if (node.left.left == null) {

			Comparable item = node.left.data;
			node.left = node.left.right;
			return item;
		} else {
			return removeitem(node.left);
		}
	}

}
