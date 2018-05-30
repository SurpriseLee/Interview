package pers.lxs.interview.toutiao201801;

import java.util.Scanner;

public class Main20180102 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int[] a = new int[N];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}		
		scanner.close();
		
		int maxResult = 0;
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			
			int min = a[i];
			sum = a[i];
			
			int index = i - 1;
			while(index >= 0 && a[index] >= min) {
				sum += a[index--];
			}
			index = i + 1;
			while(index < a.length && a[index] >= min) {
				sum += a[index++];
			}
			
			if(min * sum > maxResult) {
				System.out.println("update: " + min + " " + sum + " " + min * sum);
			}
			
			maxResult = min * sum > maxResult ? min * sum : maxResult;
		}
		
		System.out.println(maxResult);
	}
}
