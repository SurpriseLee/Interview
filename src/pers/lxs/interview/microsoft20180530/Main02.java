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
		
		Hight h = new Hight();
		System.out.println(isAVL(root, h));		
	}
	
	public void getValue(Hight h) {
		
		h.hight = 10;
	}
	
	public boolean isAVL(Node root, Hight h) {
		
		if(root == null) {
			h.setHight(0);
			return true;
		}
		
		Hight leftHight = new Hight();
		Hight rightHight = new Hight();
		
		boolean leftFlag = isAVL(root.left, leftHight);
		boolean rightFlag = isAVL(root.right, rightHight);
		
		h.setHight(Math.max(leftHight.getHight(), rightHight.getHight()) + 1);
		
		return leftFlag && rightFlag && (Math.abs(leftHight.getHight() - rightHight.getHight()) <= 1);		
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
	
	class Hight {
		
		private int hight;
		
		public Hight(){}
		
		public Hight(int hight) {
			this.hight = hight;
		}
		
		public void setHight(int hight) {
			this.hight = hight;
		}
		
		public int getHight() {
			return hight;
		}
		
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
