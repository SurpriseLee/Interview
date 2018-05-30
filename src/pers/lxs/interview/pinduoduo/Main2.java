package pers.lxs.interview.pinduoduo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();
		
		Deque<String> stack = new ArrayDeque<String>();
		
		int bigNum = 0;
		int midNum = 0;
		int smallNum = 0;
		
		boolean midFlag = false;
		boolean smallFlag = false;
		
		boolean flag = true;
		int index = 0;
		while (index < str.length() && flag) {
			String sign = str.charAt(index) + "";
			switch (sign) {
			case "{":
				
				if(smallNum == 0 && midNum == 0) {
					stack.offerFirst(sign);
					bigNum++;
					midFlag = false;
				} else {
					flag = false;
				}
				
				break;
			case "[":
				
				if(midNum == 0 && smallNum == 0) {
					stack.offerFirst(sign);
					midNum++;
					midFlag = true;
					smallFlag = false;
				} else {
					flag = false;
				}
				
				break;
			case "(":
				
				if(smallNum == 0) {
					
					if(bigNum > 0 && midNum <= 0) {
						flag = false;
					} else {
						stack.offerFirst(sign);
						smallNum++;
						smallFlag = true;
					}
				} else {
					flag = false;
				}
				
				break;
			case "}":
				String temp = stack.pollFirst();
				if (temp == null || !temp.equals("{") || !midFlag) {
					flag = false;
				} else{
					bigNum--;
				}
				
				break;
			case "]":
				temp = stack.pollFirst();
				if (temp == null || !temp.equals("[") || !smallFlag) {
					flag = false;
				} else {
					midNum--;
				}
				break;
			case ")":
				temp = stack.pollFirst();
				if (temp == null || !temp.equals("(")) {
					flag = false;
				} else {
					smallNum--;
				}
				break;
			default:
				break;
			}

			index++;
		}

		if (!stack.isEmpty()) {
			flag = false;
		}

		System.out.println(flag);

		scanner.close();
	}

}
