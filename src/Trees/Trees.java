package Trees;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class Trees {

	Node root;
	Node prev;

	public Trees() {
		root = null;
		prev = null;
	}

	IntFunction<Node> ifRootIsNull = (data) -> {
		this.foundOrNot = Boolean.FALSE;
		Node newNode = new Node();
		newNode.data = data;
		if (root == null) {
			root = newNode;
			return newNode;
		}
		return newNode;
	};

	BiFunction<Node, Integer, Node> insertInBST = (tree, data) -> {
		return Optional.ofNullable(tree).filter(checkDuplicateNode -> !this.searchInTree.test(tree, data)).map(node -> {
			return Optional.of(node).filter(checkPos -> data < checkPos.data).map(insertLeft -> {
				node.left = this.insertInBST.apply(node.left, data);
				return node;
			}).orElseGet(() -> {
				node.right = this.insertInBST.apply(node.right, data);
				return node;
			});
		}).orElse(this.ifRootIsNull.apply(data));
	};

	Boolean foundOrNot = Boolean.FALSE;
	BiPredicate<Node, Integer> searchInTree = (tree, key) -> {
		return Optional.ofNullable(tree).filter(checkKey -> {
			return Optional.of(checkKey).filter(checkData -> checkData.data == key).map(settingFlag -> {
				foundOrNot = Boolean.TRUE;
				return false;
			}).orElse(!foundOrNot);
		}).map(node -> {
			this.searchInTree.test(node.left, key);
			return this.searchInTree.test(node.right, key);
		}).orElse(foundOrNot);
	};

	int maxHeight;
	IntUnaryOperator checkIfHeightMax = height -> {
			return Optional.of(height).filter(checkMaxHeight -> height > maxHeight).map(setMaxHeight -> {
				maxHeight = height;
				return maxHeight;
			}).orElse(maxHeight-1);
	};

	int height;
	ToIntFunction<Node> heightBST = tree -> {
		return Optional.ofNullable(tree).map(node -> {
			height++;
			this.heightBST.applyAsInt(node.left);
			this.heightBST.applyAsInt(node.right);
			height--;
			return maxHeight;
		}).orElse(this.checkIfHeightMax.applyAsInt(height));
	};
	
	int min,max;
	Consumer<Node> findMaxAndMinEle = tree -> {
		
	};
	
	Consumer<Node> printMinEle = tree -> {
//		 Optional.ofNullable(tree).ifPresent(node->{
//				min = node.data;
//				this.findMaxAndMinEle.accept(node.left);
//			}).orElse(System.out.print(min));
	};

	Consumer<Node> preOrderTraversal = tree -> Optional.ofNullable(tree).ifPresent(node -> {
		System.out.print(node.data + "<------>");
		this.preOrderTraversal.accept(node.left);
		this.preOrderTraversal.accept(node.right);
	});;

	Consumer<Node> inOrderTraversal = tree -> Optional.ofNullable(tree).ifPresent(node -> {
		this.inOrderTraversal.accept(node.left);
		System.out.print(node.data + "<------>");
		this.inOrderTraversal.accept(node.right);
	});;

	Consumer<Node> postOrderTraversal = tree -> Optional.ofNullable(tree).ifPresent(node -> {
		this.postOrderTraversal.accept(node.left);
		this.postOrderTraversal.accept(node.right);
		System.out.print(node.data + "<------>");
	});;

	Function<List<Integer>, Node> createBinarySearchTree = listData -> listData.stream()
			.map(data -> this.insertInBST.apply(root, data)).reduce((first, second) -> first = second).get();;
}
