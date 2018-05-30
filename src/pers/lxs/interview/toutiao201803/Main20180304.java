package pers.lxs.interview.toutiao201803;

import java.util.Scanner;

public class Main20180304 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		if(n < 2 || n > 100000 || x < 1 || x > n) {
			sc.close();
			return;
		}
		
		long[] a = new long[n];
		
		long min = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
			
			if(a[i] < min) {
				min = a[i];
				index = i;
			}
			
			if(a[i] == min && i <= (x - 1)) {
				index = i;
			}
			
		}
		sc.close();
		

		
		a[index] = 0;
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			
			if((x - 1) < index) {
				if(i < x || i > index) {
					a[i] -= (min + 1);
					count += 1;
				} else {
					a[i] -= min;
				}
			} else if((x - 1) == index) {
				a[i] -= min;
			} else if((x - 1) > index) {
				if(i > index && i < x) {
					a[i] -= (min + 1);
					count += 1;
				} else {
					a[i] -= min;
				}
			}
		}
		
		a[index] = min * a.length + count;
		
		System.out.println(min + " " + index + " " + count + " " + a[index]);
		
		StringBuilder sb = new StringBuilder();
		for(long e : a) {
			sb.append(e + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
}
