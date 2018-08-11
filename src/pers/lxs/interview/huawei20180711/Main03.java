package pers.lxs.interview.huawei20180711;

import java.util.Scanner;

public class Main03 {
	
	
	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine().trim();
		
        in.close();
        
        String[] strs = str.split(" ");
        int[] prices = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
        	
        	if(strs[i].charAt(strs[i].length() - 1) == 'S') {
        		prices[i] = Integer.parseInt(strs[i].substring(0, strs[i].length() - 1)) * 7;
        	} else {
        		prices[i] = Integer.parseInt(strs[i].substring(0, strs[i].length() - 1));
        	}
        }
		
		int min = prices[0];
		int profit = 0;
		
		for(int i = 0; i < prices.length; i++) {
			
			if(prices[i] < min) {
				min = prices[i];
			} else if(profit < (prices[i] - min)) {
				profit = prices[i] - min;
			}
		}
		
		System.out.println(profit);
	}
}