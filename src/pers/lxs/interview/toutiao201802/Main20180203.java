package pers.lxs.interview.toutiao201802;

import java.util.Scanner;

public class Main20180203 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		sc.close();
		
		String[] strs = s.split(" ");
		
		String str = strs[0].trim();
		int m = Integer.parseInt(strs[1]);
		
		System.out.println(str + " " + m);
		
		if(s.length() < 1 || s.length() > 1000 || m < 1 || m > 1000000) {
			System.out.println(0);
			return;
		}
		
		
		
		System.out.println(2);
		
		
	}
}
