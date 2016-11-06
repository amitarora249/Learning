package org.pooja.ds.linkedListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 
 * @author Pooja
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {
	private Node<E> firstNode;
	private Node<E> lastNode;
	private static int listSize = 0;

	/*
	 * A new node is inserted before the first node. In this case, you need to
	 * modify the next pointer of the new node and make it point to the current
	 * head(first) node.
	 */
	public void addAtFirst(E item) {
		listSize++;
		/* check if the head node is null which means the list is empty.
		 * If it is empty the new node which is being inserted will be both,
		 * the first as well as the last node.
		*/
		Node<E> tempNode = new Node<E>(item, firstNode);
		if (firstNode == null) {
			firstNode = tempNode;
			lastNode = firstNode;
		} else {
			firstNode = new Node<E>(item, tempNode);
		}
	}

	/*
	 * A new node is inserted at the end of the list. You need to modify two
	 * pointer in this case i.e. make the next pointer of the current last node
	 * point to the new node and make the next pointer of the new node point to
	 * null.
	 */
	public void addAtLast(E item) {
		listSize++;
		Node<E> tempNode = lastNode;
		Node<E> currentNode = new Node<E>(item, null);
		/*
		 * if the last node points to null, that means the list is empty and
		 * hence the both the head and tail node will now be pointing to the new
		 * node which is being inserted.
		 */
		lastNode = currentNode;
		if (tempNode != null) {
			tempNode.nextNode = currentNode;
		} else {
			firstNode = currentNode;
		}
	}

	/*
	 * You maintain 2 pointers, one for the current node and one for the
	 * previous node. You have to traverse the list till n-1 position ,now there are two pointers
	 * one pointing at (n-1) node and one at nth node.
	 * Make the next pointer of the previous node point to the new node and the
	 * next pointer of the new node to the node at the nth position.
	 */
	public void addInBetween(int position, E data) {
		listSize++;
		int count = 1;
		Node<E> previousNode = firstNode;
		if (position == 0) {
			addAtFirst(data);
			return;
		}
		while(count < position - 1){
			previousNode = previousNode.nextNode;
			count++;
		}
		Node<E> currentNode = previousNode.nextNode;
		Node<E> tempNode = new Node<E>(data, currentNode);
		previousNode.nextNode = tempNode;
	}

	/*
	 * Create a temp node reference and make it point to the first node. Now
	 * make the first node point to the temp node's next node. Then make the
	 * temp node point to null.
	 */
	public void removeFirst() {
		listSize--;
		Node<E> tempNode = firstNode;
		if (tempNode.nextNode != null) {
			firstNode = tempNode.nextNode;
		}
		tempNode.data = null;
		tempNode.nextNode = null;
	}

	/*
	 * Traverse till the end of node and maintain two pointers.
	 * When one pointer reaches the last node, the other pointer will be pointing to the
	 * second last node. Now, make the second last node as the last node and make the next pointer
	 * of the second last node point to null. Dispose the current last node.`
	 */
	public void removeLast() {
		listSize--;
		Node<E> prevNode = firstNode;
		while (prevNode.nextNode != null) {
			prevNode = prevNode.nextNode;
		}
		prevNode.nextNode = null;
		lastNode.data = null;
		lastNode = prevNode;
	}

	/* Maintain 2 pointers.
	 * Traverse till the n-1 position. Now the (n-1)th node will be your previous node
	 * and the nth node will be the node to be deleted.
	 * Make the next node of the (n-1)th node point to the next node of the nth node.
	 * Dispose the nth node.
	 */
	public void removeAtIndex(int position) {
		listSize--;
		int count = 1;
		Node<E> prevNode = firstNode;
		if (position == 0) {
			removeFirst();
		}
		if(position == listSize){
			removeLast();
		}
		while(count < position - 1){
			prevNode = prevNode.nextNode;
		}
		Node<E> currentNode = prevNode.nextNode;
		prevNode.nextNode = currentNode.nextNode;
		currentNode.data = null;
		currentNode.nextNode = null;
	}

	public int size() {
		return listSize;
	}

	public void printList() {
		Node<E> currentNode = firstNode;

		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.nextNode;
		}
	}
	
	public void nodeFromEnd(int n){
		int algo = 0;
		try(BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Please choose your algorithm");
			System.out.println("Enter 1 for BRUTE FORCE APPROACH");
			System.out.println("Enter 2 for HASHTABLE");
			System.out.println("ENTER 3 for TWO POINTER APPROACH");
		    algo = Integer.parseInt(bufferRead.readLine());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}	
		switch(algo){
		case 1:
			bruteForce(n);
			break;
		case 2:
			hashtableApproach(n);
			break;
		case 3:
			twoPointerApproch(n);
			break;
		default:
			twoPointerApproch(n);
			break;
		}
	}
	/* Starting with the head node count the no. of nodes after first node.
	 * If no. of nodes after the first node is < n-1, then return. Else move to 
	 * the next node and count the no. of nodes after the current node.
	 * Continue this till the no. of nodes after the next node is n-1;
	 */
	private void bruteForce(int n){
		Node<E> currentNode = firstNode;
		
		while(currentNode != null){
			int count = 1;
			Node<E> tempNode = currentNode.nextNode;
			while(tempNode.nextNode != null){
				tempNode = tempNode.nextNode;
				count++;
			}
			if(count < n-1){
				System.out.println("Fewer no. of nodes");
				return;
			}else if(count == n-1){
				System.out.println("Nth Node from end : "+currentNode.data);
				break;
			}
			currentNode = currentNode.nextNode;
		}
	}

	
	private void hashtableApproach(int n){
		HashMap<Integer, Node<E>> nodePositions = new HashMap<>();
		Node<E> currentNode = firstNode;
		int count = 0;
		while(currentNode != null){
			count++;
			nodePositions.put(count, currentNode);
			currentNode = currentNode.nextNode;
		}
		int node = count-n+1;
		System.out.println("Nth node from end: "+nodePositions.get(node).data);
	}
	
	private void twoPointerApproch(int n){
		Node<E> nthPointer = firstNode;
		Node<E> tempPtr = firstNode;
		int count = 0;
		while(count < n){
			tempPtr = tempPtr.nextNode;
			count++;
		}
		while(tempPtr != null){
			tempPtr = tempPtr.nextNode;
			nthPointer= nthPointer.nextNode;
		}
		System.out.println("Nth node from end: "+nthPointer.data);
	}
}

class Node<E> {

	Node<E> nextNode = null;
	E data = null;

	Node(E data, Node<E> nextPointer) {
		this.data = data;
		this.nextNode = nextPointer;

	}
}