package com.practice.datastructure.trees;

public class BinarySearchTree {

	private Node rootNode;

	private Node insert(Node rootNode, int data) {
		if (rootNode == null) {
			rootNode = new Node(data);
			return rootNode;
		}
		if (data < rootNode.getData()) {
			rootNode.leftChild = insert(rootNode.getLeftChild(), data);
		} else {
			rootNode.rightChild = insert(rootNode.getRightChild(), data);
		}

		return rootNode;
	}

	public void delete(int data) {
		if (rootNode == null) {
			return;
		}
		Node parent = rootNode;
		Node currentNode = rootNode;
		boolean isLeftChild = false;
		while (currentNode.data != data) {
			parent = currentNode;
			if (currentNode.data > data) {
				currentNode = currentNode.getLeftChild();
				isLeftChild = true;
			} else {
				currentNode = currentNode.getRightChild();
				isLeftChild = false;
			}
		}

		if (currentNode.getLeftChild() != null
				&& currentNode.getRightChild() != null) {

			Node successor = currentNode.getRightChild();
			Node temp = successor.getLeftChild();
			Node successorParent = currentNode;
			while (temp != null) {
				successorParent = successor;
				successor = temp;
				temp = temp.getLeftChild();
			}

			if (successor != currentNode.getRightChild()) {
				successorParent.leftChild = successor.getRightChild();
			}
			successor.leftChild = currentNode.leftChild;
			successor.rightChild = currentNode.rightChild;
			if (currentNode == rootNode) {
				rootNode = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}

		} else if (currentNode.getLeftChild() == null) {
			if (currentNode == rootNode) {
				rootNode = currentNode.getRightChild();
				return;
			}
			if (isLeftChild) {
				parent.leftChild = currentNode.getRightChild();
			} else {
				parent.rightChild = currentNode.getRightChild();
			}
		} else if (currentNode.getRightChild() == null) {
			if (currentNode == rootNode) {
				rootNode = currentNode.getLeftChild();
				return;
			}
			if (isLeftChild) {
				parent.leftChild = currentNode.getLeftChild();
			} else {
				parent.rightChild = currentNode.getLeftChild();
			}
		} else {
			if (currentNode == rootNode) {
				rootNode = null;
				return;
			}
			if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
	}

	public void insert(int data) {
		if (rootNode == null) {
			rootNode = new Node(data);
		} else {
			insert(rootNode, data);
		}
	}

	public void displayPreOrder() {

		preOrderTraversal(rootNode);

	}

	private void preOrderTraversal(Node rootNode) {

		if (rootNode == null) {
			return;
		}
		System.out.println(rootNode.getData());
		preOrderTraversal(rootNode.getLeftChild());
		preOrderTraversal(rootNode.getRightChild());

	}

	class Node {

		private int data;
		private Node leftChild;
		private Node rightChild;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", leftChild=" + leftChild
					+ ", rightChild=" + rightChild + "]";
		}

	}

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(5);
		binarySearchTree.insert(4);
		binarySearchTree.insert(10);
		binarySearchTree.insert(12);
		binarySearchTree.insert(11);
		binarySearchTree.insert(8);
		binarySearchTree.insert(7);
		binarySearchTree.insert(2);

		binarySearchTree.displayPreOrder();
		binarySearchTree.delete(10);
		System.out.println();
		binarySearchTree.displayPreOrder();
	}

}
