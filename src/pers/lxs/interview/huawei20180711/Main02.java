package pers.lxs.interview.huawei20180711;

import java.util.Scanner;

public class Main02 {
	
	
	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine().trim();
		
        in.close();
        
        String[] strs = str.trim().split("[+|-|*+/]");
        
        int num1 = Integer.parseInt(strs[0]);
        int num2 = Integer.parseInt(strs[1]);
        
        char operator = str.charAt(strs[0].length());

        int result = 0;
        
        switch(operator) {
        
        case '+': result = num1 + num2; break;
        case '-': result = num1 - num2; break;
        case '*': result = num1 * num2; break;
        case '/': result = num1 / num2; break;
        	default:
        		break;
        }
		
		System.out.println(result);
	}
	
}
