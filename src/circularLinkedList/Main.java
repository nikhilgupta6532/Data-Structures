package circularLinkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();

		Node circularList = circularLinkedList.createCircularLinkedList.apply(Arrays.asList(2, 3, 4, 5, 6));

		// Display linked list
		System.out.print("Circular List : ");
		circularLinkedList.printList.accept(circularList);

		circularList = circularLinkedList.addToTail.apply(circularList, 50);
		// Display linked list
		System.out.print("Circular List : ");
		circularLinkedList.printList.accept(circularList);

		circularList = circularLinkedList.addToHead.apply(circularList, 20);
		// Display linked list
		System.out.print("Circular List : ");
		circularLinkedList.printList.accept(circularList);
	}

}
