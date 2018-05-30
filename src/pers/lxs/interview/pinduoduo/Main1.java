package pers.lxs.interview.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		
		int[][] m = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				m[i][j] = scanner.nextInt();
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		int max = 0;
		
		int i = 0;	int j = N - 1;
		
		
		while(i < M) {
			
			boolean flag = false;
			
			while(j >= 0 && m[i][j] == 1) {
				j--;
				max++;
				flag = true;
			}
			
			if(flag) {
				list.removeAll(list);
			}
			
			if(j != N - 1 && m[i][j + 1] == 1) {
				list.add(i + 1);
			}
			
			i++;
		}
		
		for(int index : list) {
			System.out.println("[" + index + "," + max + "]");
		}
		
		scanner.close();
	}

}
