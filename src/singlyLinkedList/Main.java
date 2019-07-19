package singlyLinkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		// create a singly linked list
		Node linkedList = singlyLinkedList.createLinkedList.apply(Arrays.asList(2, 3, 4, 5, 6));

		// Display linked list
		System.out.print("Linked List : ");
		singlyLinkedList.printList.accept(linkedList);
		System.out.print("null");

		linkedList = singlyLinkedList.addToHead.apply(linkedList, 20);

		System.out.print("Linked List : ");
		singlyLinkedList.printList.accept(linkedList);
		System.out.print("null");
		
		System.out.print("Linked List : ");
		singlyLinkedList.addToTail.apply(linkedList, 50);
		singlyLinkedList.printList.accept(linkedList);
		System.out.print("null");
		
		System.out.print("Linked List : ");
		singlyLinkedList.addToTail.apply(linkedList, 60);
		singlyLinkedList.printList.accept(linkedList);
		System.out.print("null");
		
		System.out.println("\n--------------------------------------------\n");
		
		SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
		
		Node newLinkedList = singlyLinkedList2.createLinkedList.apply(Arrays.asList(7,8,9,0));
		
		System.out.print("Linked List : ");
		singlyLinkedList.printList.accept(newLinkedList);
		System.out.print("null");
		
		SinglyLinkedList singlyLinkedList3 = new SinglyLinkedList();
		Node linkedList3 = singlyLinkedList3.createLinkedList.apply(Arrays.asList(1,2,3,4,5,5));
		System.out.print("Linked List : ");
		singlyLinkedList.printList.accept(linkedList3);
		System.out.print("null");
		
		Node current = singlyLinkedList3.reverseList.apply(linkedList3);
		System.out.print("Reverse Linked List : ");
		singlyLinkedList.printList.accept(current);
		System.out.print("null");
		
		System.out.print("\n\nPrint the last k nodes of the linked list in reverse order\n\n");
		SinglyLinkedList singlyLinkedList4 = new SinglyLinkedList();
		Node linkedList4 = singlyLinkedList4.createLinkedList.apply(Arrays.asList(1,2,3,4,5,6,7));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList4);
		System.out.print("null\n");
		singlyLinkedList4.printLastKEle.accept(linkedList4, 3);
		System.out.print("\n------------------------------------------------------\n");
		
		System.out.print("\n\nPariwise swap adjacent nodes of a linked list\n\n");
		
		SinglyLinkedList singlyLinkedList5 = new SinglyLinkedList();
		Node linkedList5 = singlyLinkedList5.createLinkedList.apply(Arrays.asList(1,2,3,4,5,6));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList5);
		System.out.print("null\n");
		linkedList5 = singlyLinkedList5.swapAdjacentNodes.apply(linkedList5);
		singlyLinkedList5.printList.accept(linkedList5);
		
		System.out.print("\n\nReverse a linked list using stack\n\n");
		
		SinglyLinkedList singlyLinkedList6 = new SinglyLinkedList();
		Node linkedList6 = singlyLinkedList6.createLinkedList.apply(Arrays.asList(1,2,3,4,5,6,7));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList6);
		System.out.print("null\n");
		
		singlyLinkedList6.reverseUsingStack.accept(linkedList6);
		
		System.out.print("\n\nAppend odd position nodes in reverse at the end of even positioned nodes\n\n");
		
		SinglyLinkedList singlyLinkedList7 = new SinglyLinkedList();
		Node linkedList7 = singlyLinkedList7.createLinkedList.apply(Arrays.asList(7,6,5,4,3,2,1));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList7);
		System.out.print("null\n");
		
		singlyLinkedList7.appendOddNodesAndEvenReverse.accept(linkedList7);
		
		System.out.print("\n\nSort a linked list using bubble sort\n\n");
		
		SinglyLinkedList singlyLinkedList8 = new SinglyLinkedList();
		Node linkedList8 = singlyLinkedList8.createLinkedList.apply(Arrays.asList(3,1,2,5,7,0,10,4,6,2,1));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList8);
		System.out.print("null\n");
		
		current = singlyLinkedList8.sortListUsingBubbleSort.apply(linkedList8);
		singlyLinkedList8.printList.accept(current);
		
		System.out.print("\n\nConvert singly linked list into XOR linked list\n\n");
		SinglyLinkedList singlyLinkedList9 = new SinglyLinkedList();
		Node linkedList9 = singlyLinkedList9.createLinkedList.apply(Arrays.asList(4,3,2,1));
		System.out.print("Linked List : \n");
		singlyLinkedList.printList.accept(linkedList9);
		System.out.print("null\n");
		
	}

}
