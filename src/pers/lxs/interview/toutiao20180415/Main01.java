package pers.lxs.interview.toutiao20180415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        int index = 0;
        while(index < N) {
        	int len = in.nextInt();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	int i = 0;
        	while(i < len) {
        		list.add(in.nextInt());
        		i++;
        	}
        	lists.add(list);
        	index++;
        }
        in.close();
        
//        for(int i = 0; i < N; i++) {
//        	for(int e : lists.get(i)) {
//        		System.out.print(e + " ");
//        	}
//        	System.out.println();
//        }
        
        for(ArrayList<Integer> list : lists) {
        	
        	int T = getT(list);
        	if(T > 0) {
        		System.out.println(T);
        	} else {
        		System.out.println();
        	}
        }
        
    }
    
    public static int getT(List<Integer> list) {
    	
    	if(list == null || list.size() <= 1) {
    		return 0;
    	}
    	
    	for(int i = 1; i < list.get(list.size() - 1); i++) {
    		
    		boolean isT = true;
    		
    		for(int e : list) {
    			int temp = e + i;
    			if(temp >= list.get(0) && temp <= list.get(list.size() - 1) && !list.contains(e + i)) {
    				isT = false;
    				break;
    			}
    		}
    		
    		if(isT) {
    			return i;
    		}
    	}
    	
    	return 0;
    }
}
