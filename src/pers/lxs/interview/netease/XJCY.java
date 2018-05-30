package pers.lxs.interview.netease;

import java.util.Scanner;

public class XJCY {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		long h = Long.parseLong(scanner.nextLine());
		
		long k = new XJCY().mathodOne(h);
		System.out.println(k);
		
		k = new XJCY().methodTwo(h);
		System.out.println(k);
		
		scanner.close();
	}
	
	public long mathodOne(long h) {
		long k = (long) (Math.sqrt(h + 1.0 / 4) - 0.5);
		return k;
	}
	
	public long methodTwo(long h) {
		
		long k = (long) Math.pow(h, 0.5);
		
		if(k * (k + 1) > h) {
			k -= 1;
		}
		
		return k;
	}

}
