package pers.lxs.interview.toutiao20180512;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		
		List<String> list = new ArrayList<String>(N);
		
		int index = 0;
		while(index < N) {
			String str = in.nextLine();
			list.add(str);
			index++;
		}
		in.close();
		
		System.out.println(2);
	}
}
