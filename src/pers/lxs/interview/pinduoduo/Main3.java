package pers.lxs.interview.pinduoduo;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int area = 0;
		while(move(0)) {
			area+= 1;
		}
		
		while(true) {
			if(move(4)) {
				break;
			} else {
				boolean down = move(0);
				if(down) {
					break;
				}
			}
		}
		
		System.out.println(area);
		
		scanner.close();
	}
	
	public static boolean move(int direction) {
		boolean flag = false;
		
		return flag;
	}

}
