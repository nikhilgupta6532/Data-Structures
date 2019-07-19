package singlyLinkedList;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import stack.Stack;

public class SinglyLinkedList {

	Node head;
	Node prev;
	Node next;
	Node current;
	Node temp;

	public SinglyLinkedList() {
		head = null;
		prev = null;
		next = null;
		current = null;
		temp = null;
	}

	Function<Node, Node> traverseNode = (linkedList) -> {
		return Optional.ofNullable(linkedList).map(node -> {
			node = node.next;
			return this.traverseNode.apply(node);
		}).orElse(linkedList);
	};

	Function<Node, Node> reverseList = (linkedList) -> {
		return Optional.ofNullable(linkedList).map(node -> {
			prev = current;
			current = node;
			next = current.next;
			current.next = prev;
			return this.reverseList.apply(next);
		}).orElse(current);
	};

	BiConsumer<Node, Integer> printKEle = (node, key) -> {
		Optional.ofNullable(node).filter(list -> key != 0).ifPresent(n -> {
			System.out.print(n.data + " --->");
			this.printKEle.accept(n.next, key - 1);
		});
	};

	BiConsumer<Node, Integer> printLastKEle = (node, key) -> {
		Node current = reverseList.apply(node);
		this.printKEle.accept(current, key);
	};

	BiFunction<Node, Integer, Node> addToHead = (node, data) -> {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = node;
		head = newNode;
		return newNode;
	};

	BiFunction<Node, Integer, Node> addToTail = (node, data) -> {
		Node newNode = new Node();
		newNode.data = data;
		Node lastNode = traverseNode.apply(node);
		lastNode.next = newNode;
		newNode.next = null;
		return node;
	};

	Consumer<Node> printList = (linkedList) -> {
		Optional.ofNullable(linkedList).ifPresent(node -> {
			System.out.print(linkedList.data + " --->");
			node = node.next;
			this.printList.accept(node);
		});
	};

	Function<Node, Node> swapAdjacentNodes = (linkedList) -> {
		return Optional.ofNullable(linkedList).filter(n -> n.next != null).map(node -> {
			if (next != null) {
				temp = next.next;
				temp.next = node.next;
				next = node.next;
				node.next = next.next;
				next.next = node;
				return this.swapAdjacentNodes.apply(node.next);
			} else {
				next = node.next;
				node.next = next.next;
				next.next = node;
				head = next;
				return this.swapAdjacentNodes.apply(node.next);
			}
		}).orElse(head);
	};
	Stack<Integer> stack = new Stack<>();

	Function<Node, Integer> stackPush = (linkedList) -> {
		return Optional.ofNullable(linkedList).map(node -> {
			stack.pushToStack.apply(node.data);
			return this.stackPush.apply(node.next);
		}).orElse(stack.getTop.get());
	};

	Consumer<Integer> stackPop = (top) -> {
		Optional.ofNullable(top).filter(t -> t != 0).ifPresent(stackPop -> {
			Integer nodeData = stack.popFromStack.get();
			System.out.print(nodeData + "----->");
			this.stackPop.accept(stackPop - 1);
		});
	};

	Consumer<Node> reverseUsingStack = (linkedList) -> {
		Integer top = this.stackPush.apply(linkedList);
		this.stackPop.accept(top);
	};

	BiFunction<Node, Node, Node> doSomeLogic = (linkedList, last) -> {
		return Optional.ofNullable(linkedList).filter(list -> list != last && list.next != last).map(node -> {
			next = node.next;
			node.next = next.next;
			temp = last.next;
			last.next = next;
			next.next = temp;
			return this.doSomeLogic.apply(node.next, last);
		}).orElse(head);
	};

	Consumer<Node> appendOddNodesAndEvenReverse = (linkedList) -> {
		Optional.ofNullable(linkedList).ifPresent(node -> {
			Node last = this.traverseNode.apply(node);
			this.printList.accept(this.doSomeLogic.apply(node, last));
		});
	};

	Boolean swapping;

	BiFunction<Node, Node, Node> swapTwoNodes = (start, end) -> {
		swapping = Boolean.TRUE;
		if (prev == null) {
			start.next = end.next;
			end.next = start;
			prev = end;
			head = prev;
			current = end;
		} else {
			prev.next = start.next;
			start.next = end.next;
			end.next = start;
			prev = prev.next;
			current = end;
		}
		return start;
	};

	Supplier<Node> checkIfSwappingDone = () -> {
		return Optional.of(swapping).filter(Boolean::booleanValue).map(t->{
			current = null;
			swapping = Boolean.FALSE;
			return this.sortListUsingBubbleSort.apply(head);
		}).orElse(head);
	};

	Function<Node, Node> sortListUsingBubbleSort = (linkedList) -> {
		return Optional.ofNullable(linkedList).filter(list -> list.next!= null).map(node -> {
			prev = current;
			current = node;
			next = node.next;
			if (node.data > next.data) {
				return this.sortListUsingBubbleSort.apply(this.swapTwoNodes.apply(node, next));
			} else {
				return this.sortListUsingBubbleSort.apply(node.next);
			}
		}).orElse(this.checkIfSwappingDone.get());
	};
	
	Function<List<Integer>, Node> createLinkedList = (nodes) -> {
		return nodes.stream().map(data -> addToHead.apply(head, data)).reduce((first, second) -> first = second).get();
	};

}
