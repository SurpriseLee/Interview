package pers.lxs.netease;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int[] x1 = new int[N];
		int[] y1 = new int[N];
		int[] x2 = new int[N];
		int[] y2 = new int[N];
		
		for(int i = 0; i < N; i++) {
			x1[i] = scanner.nextInt();
		}
		for(int i = 0; i < N; i++) {
			y1[i] = scanner.nextInt();
		}
		for(int i = 0; i < N; i++) {
			x2[i] = scanner.nextInt();
		}
		for(int i = 0; i < N; i++) {
			y2[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		int minx = Integer.MAX_VALUE;	int miny = Integer.MAX_VALUE;
		int maxx = Integer.MIN_VALUE;	int maxy = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			minx = x1[i] < minx ? x1[i] : minx;
		}
		for(int i = 0; i < N; i++) {
			miny = y1[i] < miny ? y1[i] : miny;
		}
		for(int i = 0; i < N; i++) {
			maxx = x2[i] > maxx ? x2[i] : maxx;
		}
		
		for(int i = 0; i < N; i++) {
			maxy = y2[i] > maxy ? y2[i] : maxy;
		}
		
		int maxNum = 1;
		
		for(int x = minx; x <= maxx; x++) {
			for(int y = miny; y < maxy; y++) {
				
				int count = 0;
				for(int i = 0; i < N; i++) {
					count += contain(x, y, x1[i], y1[i], x2[i], y2[i]);
				}
				maxNum = count > maxNum ? count : maxNum;
				if(maxNum >= N) {
					System.out.println(maxNum);
					return;
				}
			}
		}
		
		System.out.println(maxNum);
	}
	
	public static int contain(int x, int y, int x1, int y1, int x2, int y2) {
		
		if(x >= x1 && x <= x2 && y >= y1 && y <= y2) {
			return 1;
		}
		
		return 0;
	}

}
