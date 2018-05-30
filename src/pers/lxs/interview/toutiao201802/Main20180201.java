package pers.lxs.interview.toutiao201802;

import java.util.Scanner;

public class Main20180201 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] values = new int[N];
		
		for(int i = 0; i < N; i++) {
			values[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[] ls = new int[M];
		int[] rs = new int[M];
		int[] ks = new int[M];
		
		for(int i = 0; i < M; i++) {
			ls[i] = sc.nextInt();
			rs[i] = sc.nextInt();
			ks[i] = sc.nextInt();
		}
		sc.close();
		
        if(N <= 0 || N > 300000 || M <= 0 || M > 300000) {
            return;
        }
		
		for(int i = 0; i < M; i++) {			
			int count = findK(ls[i] - 1, rs[i] - 1, ks[i], values);
			System.out.println(count);
		}
		
	}
	
	public static int findK(int left, int right, int k, int[] values) {
		
		if(values == null || values.length <= 0) {
			return 0;
		}
		
		int count = 0;
		for(int i = left; i <= right; i++) {
			if(values[i] == k) {
				count += 1;
			}
		}
		
		return count;
	}
	

}
