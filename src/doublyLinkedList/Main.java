package doublyLinkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		Node linkedList = doublyLinkedList.createDoublyLinkedList.apply(Arrays.asList(2, 3, 4, 5, 6));

		// Display linked list
		System.out.print("Linked List : ");
		doublyLinkedList.printList.accept(linkedList);
		System.out.print("null");

		linkedList = doublyLinkedList.addToHead.apply(linkedList, 20);

		// Display linked list
		System.out.print("Linked List : ");
		doublyLinkedList.printList.accept(linkedList);
		System.out.print("null");

		linkedList = doublyLinkedList.addToTail.apply(linkedList, 50);

		// Display linked list
		System.out.print("Linked List : ");
		doublyLinkedList.printFromLast.accept(linkedList);
		System.out.print("null");

		System.out.print("\n\nNumber of connected components in a doubly linked list\n\n");
		System.out.print("Given array ref is ");
		Integer[] arr = { 5, 10, 3, 1};
		Arrays.stream(arr).forEach(val -> System.out.print(val + " "));
		System.out.println();
		DoublyLinkedList doublyLinkedList2 = new DoublyLinkedList();
		linkedList = doublyLinkedList2.createDoublyLinkedList.apply(Arrays.asList(3, 1, 10, 2, 5));
		// Display linked list
		System.out.print("Linked List : ");
		doublyLinkedList.printList.accept(linkedList);
		System.out.print("null\n");
		doublyLinkedList2.findConnectedComponents.accept(linkedList, arr);

	}

}
