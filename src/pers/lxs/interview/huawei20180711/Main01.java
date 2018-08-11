package pers.lxs.interview.huawei20180711;

import java.util.Scanner;

public class Main01 {
	
	
	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine().trim();
		
        in.close();
        
        String[] strs = str.trim().split(" ");
        
        for(int i = strs.length - 1; i >= 0; i--) {
        	System.out.print(strs[i] + " ");
        }
	}
	
}
