package pers.lxs.interview.alibaba20180511;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[5];
		double[] p = new double[5];
		
		for(int i = 0;i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}

		int N = sc.nextInt();
		
		for(int i = 0; i < p.length; i++) {
			p[i] = sc.nextDouble();
		}
		
		sc.close();
		
		double expection = 0.0;
		for(int i = 0; i < scores.length; i++) {
			expection += scores[i] * p[i];
		}
		
		System.out.println(N / expection);
	}
	

}
