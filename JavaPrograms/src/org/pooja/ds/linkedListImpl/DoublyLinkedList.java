package org.pooja.ds.linkedListImpl;

public class DoublyLinkedList<E>{
	private Node2<E> firstNode;
	private Node2<E> lastNode;
	private static int listSize;
	
	/*
	 * Set the next pointer of the new node to point to the first node.
	 * Set the previous pointer of the current head node to point to the new node.
	 * Make the new node as the first node.
	 */
	public void addFirst(E data){
		Node2<E> currentNode = new Node2<E>(null,data,firstNode);
		if(firstNode != null){
			firstNode.prevNode = currentNode;
		}
		firstNode = currentNode;  
		listSize++;
	}
	
	/*
	 * Set the previous pointer to the new node to point to the tail node 
	 * and the next pointer as null. Update the next pointer of the current tail node
	 * to point to the new node.
	 * Make the new node as the last node.
	 */
	public void addLast(E data){
		Node2<E> currentNode = new Node2<E>(lastNode, data, null);
		if(lastNode != null){
			lastNode.nextNode = currentNode;
		}else{
			firstNode = currentNode;
		}
		lastNode = currentNode;
		listSize++;
	}
	
	/*
	 * Traverse till (n-1) position. Now there are 2 pointers, one pointing to the nth position i.e.
	 * the position where current node has to be inserted and the other one pointing to
	 * the (n-1) position i.e. one before n.
	 * Insert the new node, where the previous pointer points to the (n-1)node next pointer points to
	 * the nth node.
	 * Update the next pointer of the (n-1) node to point to the new node and the previous pointer of the
	 * nth node to point to the new node.
	 */
	public void addAtIndex(int pos, E data){
		Node2<E> prevNode = firstNode;
		if(firstNode == null || pos == 1){
			addFirst(data);
			return;
		}else if(pos >= listSize){
			addLast(data);
			return;
		}else{
			int count = 1;
			while(count < pos -1){
				prevNode = prevNode.nextNode;
				count++;
			}			
			Node2<E> currentNode = prevNode.nextNode;
			Node2<E> tempNode = new Node2<E>(prevNode, data,currentNode);
			currentNode.prevNode = tempNode;
			prevNode.nextNode = tempNode;
		
			listSize++;
		}
	}
	/*
	 * Create a temp node reference and make it point to the first node. Now
	 * make the first node point to the temp node's next node. Then make the
	 * temp node point to null.
	 */
	public void removeFirst(){
		Node2<E> tempNode = firstNode;
		if(tempNode.nextNode !=  null){
			firstNode = tempNode.nextNode;
			firstNode.prevNode = null;
		}
		tempNode.data = null;
		tempNode.nextNode = null;
		listSize--;
	}
	
	public void removeLast(){
		Node2<E> tempNode = lastNode;
		if(tempNode.prevNode != null){
			lastNode = tempNode.prevNode;
			lastNode.nextNode = null;
		}
		tempNode.prevNode = null;
		tempNode.data = null;
		listSize--;
	}
	
	public void removeAtIndex(int pos){
		Node2<E> preNode = firstNode;
		if(pos == listSize){
			removeLast();
		}else if(pos == 0){
			removeFirst();
		}else{
			int count =1;
			while(count < pos-1){
				preNode = preNode.nextNode;
				count++;
			}
			Node2<E> currentNode = preNode.nextNode;
			
			preNode.nextNode = currentNode.nextNode;
			currentNode.nextNode.prevNode = preNode;
			//set the current node to null
			currentNode.prevNode =null;
			currentNode.nextNode = null;
			currentNode.data = null;
			currentNode = null;
		}
		listSize--;
	}
	
	public int getSize(){
		return listSize;
	}
	
	public void printList(){
		for(Node2<E> tempNode = firstNode; tempNode!= null; tempNode = tempNode.nextNode){
			System.out.println(tempNode.data);
		}
	}
}

class Node2<E>{
	
	Node2<E> prevNode;
	Node2<E> nextNode;
	E data;
	
	Node2(Node2<E> previousPointer, E data, Node2<E> nextPointer){
		this.prevNode = previousPointer;
		this.data = data;
		this.nextNode = nextPointer;
	}
}