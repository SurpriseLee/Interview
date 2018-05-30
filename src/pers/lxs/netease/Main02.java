package pers.lxs.netease;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int l = scanner.nextInt();
		int r = scanner.nextInt();
		
		int temp = getTotal(l - 1);
		int count = 0;
		for(int i = l; i <= r; i++) {
			temp += getValue(i);
			
			if(temp % 3 == 0) {
				count++;
			}
			
		}
		
		System.out.println(count);
		
		scanner.close();
	}
	
	public static int getTotal(int l) {
		int result = 0;
		
		for(int i = 1; i <= l; i++) {
			result += getValue(i);
		}
		
		return result;
	}
	
	public static int getValue(int a) {
		int result = 0;
		
		while(a > 10) {
			result += a % 10;
			a = a / 10;
		}
		
		result += a;
		
		return result;
	}

}
