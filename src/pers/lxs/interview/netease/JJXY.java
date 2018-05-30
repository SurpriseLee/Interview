package pers.lxs.interview.netease;

import java.util.Scanner;

public class JJXY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int[] x = new int[N];
		int[] y = new int[N];
		
		for(int i = 0; i < x.length; i++) {
			x[i] = scanner.nextInt();
		}
		for(int i = 0; i < x.length; i++) {
			y[i] = scanner.nextInt();
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < x.length; i++) {
			
			int distance = x[i] - 1 + y[i] - 1;
			
			result = distance < result ? distance : result;
		}
		
		System.out.println(result);
		
		scanner.close();
	}

}
