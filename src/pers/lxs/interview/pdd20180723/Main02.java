package pers.lxs.interview.pdd20180723;

import java.util.Arrays;
import java.util.Scanner;


public class Main02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] h = new int[N];
		for(int i = 0; i < N; i++) {
			h[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		int[] w = new int[M];
		
		for(int i = 0; i < M; i++) {
			w[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(h);
		Arrays.sort(w);
		
		int p = 0;   int q = 0;
		int count = 0;
		while(p < w.length && q < h.length) {
			
			if(w[p] >= h[q]) {
				count += 1;
				p++;
				q++;
			} else {
				p++;
			}
		}
		
		
		System.out.println(count);
		
	}
}
