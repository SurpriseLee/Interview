package pers.lxs.interview.pdd0805;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();

		int count = 0;
		for(int i = 0; i < str.length() - 1; i++) {
			
			int n1 = getNum(str, 0, i);
			int n2 = getNum(str, i + 1, str.length() - 1);
			count += (n1 * n2);
		}
		
		System.out.println(count);
	}
	
	public static int getNum(String str, int p, int q) {
		
		if(p == q) {
			return 1;
		}
		
		if(str.charAt(p) != '0' && str.charAt(q) != '0') {
			return q - p + 1;
		} 

		if(str.charAt(p) != '0' && str.charAt(q) == '0') {
			return 1;
		} 

		if(str.charAt(p) == '0' && str.charAt(q) != '0') {
			return 1;
		} 

		if(str.charAt(p) == '0' && str.charAt(q) == '0') {
			return 0;
		} 
		
		return 0;
	}

}
