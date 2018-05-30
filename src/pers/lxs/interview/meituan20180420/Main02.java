package pers.lxs.interview.meituan20180420;

import java.util.Scanner;

public class Main02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] array = new int[T];
		
		for(int i = 0; i < T; i++) {
			array[i] = sc.nextInt();
		}
		
        sc.close();
        
        if(T <= 0 || T > 100) {
        	System.out.println(0);
        	return;
        }
        
        for(int e : array) {
        	System.out.println(getNumber(e));
        }
        
	}
	
	
	public static int getNumber(int n) {
		
		int index = (int)Math.log10(n);
		int temp = (int) Math.pow(10, index);
		
		int num = 0;
		int curr = 1;
		for(int i = 1; i <= index; i++) {
			
			if(i > 1) {
				curr *= 10;
			}
			
			num += (i * 9 * curr);
		}
		
		num += (index + 1) * (n - temp + 1);
		
		return num;
	}
}
