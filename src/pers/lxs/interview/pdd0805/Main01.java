package pers.lxs.interview.pdd0805;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		scanner.close();
		
		int K = str.length() / 4;
		char[][] results = new char[K + 1][K + 1];
		for(int i = 0; i < results.length; i++) {
			for(int j = 0; j < results[i].length; j++) {
				results[i][j] = ' ';
			}
		}
		
		int p = 0;
		
		for(int i = 0; i < K + 1; i++) {
			results[0][i] = str.charAt(p++);
		}
		
		for(int i = 1; i < K + 1; i++) {
			results[i][K] = str.charAt(p++);
		}
		
		for(int i = K - 1; i >= 0; i--) {
			results[K][i] = str.charAt(p++);
		}
		
		for(int i = K - 1; i > 0; i--) {
			results[i][0] = str.charAt(p++);
		}
		
		for(int i = 0; i < K + 1; i++) {
			for(int j = 0; j < K + 1; j++){
				System.out.print(results[i][j]);
			}
			System.out.println();
		}
	}
}
