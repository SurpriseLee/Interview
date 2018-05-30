package pers.lxs.interview.huawei20180418;

import java.util.Scanner;

public class Main01 {
	
	
	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine().trim();
        
        int N = in.nextInt();
        in.close();
        
        if(N <= 0 || str.trim().equals("")) {
        	System.out.println("");
        	return;
        }
        
        int index = 0;
        char[] strs = str.toCharArray();
        
        int p = 0;  
        boolean flag = false;
        for(char ch : strs) {
        	p++;
        	if(ch >= 256) {
        		index += 2;
        		flag = true;
        	} else {
        		index += 1;
        		flag = false;
        	}
        	
        	if(index >= N) {
        		break;
        	}
        }
        
        if(flag && index > N) {
        	p -= 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p; i++) {
        	 if(!(strs[i] >= '0' && strs[i] <= '9')) {
        		 sb.append(strs[i]);
             }
        }
		
		System.out.println(sb.toString());
	}
	
}
