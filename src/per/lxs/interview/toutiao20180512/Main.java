package per.lxs.interview.toutiao20180512;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {// ע��while������case
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
		}
		in.close();
	}
}
