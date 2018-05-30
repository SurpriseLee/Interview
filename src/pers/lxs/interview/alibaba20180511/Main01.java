package pers.lxs.interview.alibaba20180511;

import java.util.Scanner;

public class Main01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] a = new int[M][N];
		
		
		for(int i = 0;i < M; i++) {
			for(int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int[] m = new int[2];
		
		int max = m[0];
		int min = m[1];
		
		System.out.println(max);
		System.out.println(min);
	}
	
	
	public static void getMaxMin(int[] m, int[][] a) {
		
		if(a == null || a.length <= 0) {
			return;
		}
		
		
		System.out.println("Sorry, I cannot understand the meaning of this question clearly...");
		
	}

}
