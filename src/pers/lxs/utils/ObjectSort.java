package pers.lxs.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ObjectSort {
	
	@Test
	public void test() {
		
		int[] xs = new int[]{1,2,3,4,4};
		int[] ys = new int[]{1,2,1,2,5};
		
		List<Node> list = new ArrayList<Node>();
		for(int i = 0; i < xs.length; i++) {
			Node node = new Node(xs[i], ys[i]);
			list.add(node);
		}
		
		Collections.sort(list);
		
		for(Node node : list) {
			System.out.println(node.x + " " + node.y);
		}
		
	}
	
	
	class Node implements Comparable<Node> {

		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		// Descend by y and Ascend by x.
		public int compareTo(Node o) {
			
			if(this.y != o.y) {
				return o.y - this.y;
			}
			
			return this.x - o.x;
		}
	}
}
