package Trees;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Trees trees = new Trees();
		Node root = trees.createBinarySearchTree.apply(Arrays.asList(15,10,10,20,5,12,16,30,7,8,13,14,9));
		System.out.print("\nPreorder Traversal is : \n");
		trees.preOrderTraversal.accept(root);
		System.out.print("\nInOrder Traversal is : \n");
		trees.inOrderTraversal.accept(root);
		System.out.print("\nPostOrder Traversal is : \n");
		trees.postOrderTraversal.accept(root);
		
		System.out.print("\n\nSearch a given key in BST\n\n");
		Boolean isFound = trees.searchInTree.test(root,1);
		if(isFound) {
			System.out.println("FOUND");
		} else {
			System.out.println("NOT FOUND");
		}
		
		System.out.println("Height of a given binary search tree");
		int heightBST = trees.heightBST.applyAsInt(root);
		System.out.println(heightBST);
		
		System.out.print("\n\nFind Max and Min element in BST\n\n");
		trees.findMaxAndMinEle.accept(root);
		
	}
}
