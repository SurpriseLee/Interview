package pers.lxs.interview.huawei20180711;

import java.util.Scanner;

public class Main22 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String str = in.nextLine().trim();

		in.close();

		int num1 = 0;
		int num2 = 0;

		boolean flag1 = false;
		boolean flag2 = false;

		int index = 0;
		if (str.charAt(index) == '-') {
			flag1 = true;
			index++;
		}
		while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			num1 = num1 * 10 + (str.charAt(index) - '0');
			index++;
		}
		char operator = str.charAt(index++);
		if (str.charAt(index) == '-') {
			flag2 = true;
			index++;
		}
		while (index < str.length()) {
			num2 = num2 * 10 + (str.charAt(index) - '0');
			index++;
		}

		num1 = flag1 ? -num1 : num1;
		num2 = flag2 ? -num2 : num2;

		int result = 0;

		switch (operator) {

		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		default:
			break;
		}

		System.out.println(result);
	}

}
