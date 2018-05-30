package pers.lxs.interview.toutiao20180415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        int[] K = new int[N];
        int[][] a = new int[N][];
        
        int index = 0;
        in.nextLine();
        while(index < N) {
        	String str = in.nextLine();
        	String[] strs = str.trim().split(" ");
        	
        	K[index] = Integer.parseInt(strs[0]);
        	a[index] = new int[strs.length - 1];
            
        	for(int i = 1;i < strs.length; i++) {
        		a[index][i - 1] = Integer.parseInt(strs[i]);
        	}
        	index++;
        }
       
        in.close();
        
        int[] m = new int[1];
        int[] n = new int[1];
        index = 0;
        while(index < N) {
        	
        	getK(a[index], K[index], m, n);
        	
        	System.out.println(m[0] + " " + n[0]);
        	index++;
        }
    }
    
    
    public static void getK(int[] a, int K, int[] m, int[] n) {
    	
    	if(a == null || a.length <= 0) {
    		return;
    	}
    	
    	int p = 0;    int q = a.length - 1;
    	    	
    	TreeSet<Node> tree = new TreeSet<Node>();
    	List<Node> list = new ArrayList<Node>();
    	
    	tree.add(new Node(p, q, a[p] * 1.0 / a[q]));
    	while(list.size() < K && !tree.isEmpty()) {
    		Node node = tree.pollFirst();
    		list.add(node);
    		p = node.p;
    		q = node.q;
    		
    		if(p < a.length - 1 && p < q - 1) {
    			tree.add(new Node(p + 1, q, a[p + 1] * 1.0 / a[q]));
    		}
    		if(q > 0 && q > p + 1) {
    			tree.add(new Node(p, q - 1, a[p] * 1.0 / a[q - 1]));
    		}
    	}
    	
    	for(Node node : list) {
    		System.out.println(node.p + " " + node.q + " " + a[node.p] + " " + a[node.q]);
    	}
    	
    	Node node = list.get(K - 1);
    	
    	m[0] = a[node.p];
    	n[0] = a[node.q];
    }
    
    static class Node implements Comparable<Node> {
    	int p;
    	int q;
    	
    	double result;
    	
    	public Node(int p, int q, double result) {
    		this.p = p;
    		this.q = q;
    		this.result = result;
    	}

		@Override
		public int compareTo(Node o) {
			int flag = 1;
			if(result - o.result < 0)
				flag = -1;
			return flag;
		}
    }
}
