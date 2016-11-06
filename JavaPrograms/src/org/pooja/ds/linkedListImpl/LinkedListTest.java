package org.pooja.ds.linkedListImpl;


public class LinkedListTest {

	private static SinglyLinkedList<String> singlyList = new SinglyLinkedList<>();
	public static void main(String[] args) {
		singlyList.addAtLast("Pooja");
		singlyList.addAtLast("Saqib");
		singlyList.addAtLast("Aman");
		singlyList.addAtLast("Vishakha");
		singlyList.addAtLast("Anuja");
		singlyList.addAtLast("Deep");
		singlyList.addAtLast("Yogesh");
		
		singlyList.nodeFromEnd(5);
		
	}
	
}
