package circularLinkedList;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class CircularLinkedList {

	Node tail;
	
	public CircularLinkedList() {
		tail = null;
	}
	
	BiFunction<Node, Integer, Node> addToHead = (node,data) -> {
		Node newNode = new Node();
		newNode.data = data;
		if(tail == null) {
			node = newNode;
			tail = node;
			node.next = tail;
		}else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		return newNode;
	};
	
	BiFunction<Node, Integer, Node> addToTail = (node,data) -> {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = tail.next;
		tail.next = newNode;
		tail = newNode;
		return node;
	};
	
	Consumer<Node> printList = (linkedList) -> {
		Optional.ofNullable(linkedList).filter(list->list!=tail).ifPresent(node->{
			System.out.print(node.data + "--->");
			node = node.next;
			this.printList.accept(node);
		});
		if(linkedList == tail) {
			System.out.print(tail.data);
		}
	};
	
	Function<List<Integer>, Node> createCircularLinkedList = (nodes) -> {
		return nodes.stream().map(data->addToHead.apply(tail, data)).reduce((first,second)->first=second).get();
	};
}
