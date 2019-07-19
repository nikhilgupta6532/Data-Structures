package doublyLinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class DoublyLinkedList {

	Node head;
	Node temp;
	
	public DoublyLinkedList() {
		head = null;
		temp = null;
	}
	
	Function<Node,Node> traverseList = (linkedList) -> {
		return Optional.ofNullable(linkedList).filter(list->list.next!=null).map(node->{
			node = node.next;
			return this.traverseList.apply(node);
		}).orElse(linkedList);
	};
	
	BiFunction<Node, Integer, Node> addToHead = (node,data) -> {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = node;
		head = newNode;
		if(newNode.next == null) {
			head.prev = null;
		} else {
			head.next.prev = newNode;
		}
		return newNode;
	};
	
	BiFunction<Node, Integer, Node> addToTail = (node,data) -> {
		Node newNode = new Node();
		newNode.data = data;
		if(node == null) {
			head = newNode;
			temp = newNode;
			return temp;
		}
		Node lastNode = traverseList.apply(node);
		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = null;
		return newNode;
	};
	
	Consumer<Node> printList = (doubleList) -> {
		Optional.ofNullable(doubleList).filter(list->list!=null).ifPresent(node->{
			System.out.print(node.data + " <--->");
			node = node.next;
			this.printList.accept(node);
		});
	};
	
	Consumer<Node> printFromLast = (doubleList) -> {
		Optional.ofNullable(doubleList).filter(list->list!=null).ifPresent(node->{
			System.out.print(node.data + " <--->");
			node = node.prev;
			this.printFromLast.accept(node);
		});
	};
		
	BiFunction<Integer, Integer[], Boolean> checkIfPresentInArray = (data,arr) -> {
		return Arrays.stream(arr).anyMatch(values->values==data);
	};
	
	BiFunction<Node,Integer[],Node> connectedComponents = (linkedList,arr) -> {
		return Optional.ofNullable(linkedList).map(node->{
			Boolean connected = checkIfPresentInArray.apply(node.data,arr);
			if(connected) {
				this.addToTail.apply(temp, node.data);
				return this.connectedComponents.apply(node.next, arr);
			} else {
				this.printList.accept(temp);
				System.out.println();
				temp = null;
				return this.connectedComponents.apply(node.next, arr);
			}
		}).orElse(temp);
	};
	
	BiConsumer<Node,Integer[]> findConnectedComponents = (linkedList,arr) -> {
		Node lastComponent = this.connectedComponents.apply(linkedList, arr);
		this.printList.accept(lastComponent);
		System.out.println();
	};
	
	Function<List<Integer>, Node> createDoublyLinkedList = (nodes) -> {
		return nodes.stream().map(data->addToHead.apply(head, data)).reduce((first,second)->first = second).get();
	};
			
}
