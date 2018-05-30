package pers.lxs.interview.microsoft20180530;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Determine a binary tree is AVL
 * @author SurpriseLee
 *
 */
public class Main02 {

	@Test
	public void test() {
		
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		Node root = buildTree(array);
		
		System.out.println(isAVL(root));		
	}
	
	public boolean isAVL(Node root) {
		
		if(root == null) {
			return true;
		}
		
		return isAVL(root.left) && isAVL(root.right);		
	}
	
	public Node buildTree(int[] array) {
		
		if(array == null || array.length <= 0) {
			return null;
		}
		
		Node root = new Node(array[0]);
		List<Node> list = new ArrayList<Node>();
		list.add(root);
		int index = 1;
		while(index < array.length) {
			
			Node node = list.remove(0);
			node.left = new Node(array[index++]);
			list.add(node.left);
			
			if(index < array.length) {
				node.right = new Node(array[index++]);	
				list.add(node.right);
			}
			
		}
		
		return root;
	}
	
	class Node {
		
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	
}
