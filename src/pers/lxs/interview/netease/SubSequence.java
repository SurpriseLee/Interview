package pers.lxs.interview.netease;

import java.util.Scanner;

public class SubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		
		boolean isSubseq = new SubSequence().isSubseq(str1, str2);
		
		String result = isSubseq ? "Yes" : "No";
		
		System.out.println(result);
		
		scanner.close();

	}
	
	public boolean isSubseq(String str1, String str2) {
		
		if(str1 == null || str2 == null) {
			return false;
		}
		
		boolean isSubseq = true;
		
		int index = -1;
		
		for(int i = 0; i < str2.length(); i++) {
			
			if(index >= str1.length() - 1) {
				isSubseq = false;
				break;
			}
			
			System.out.println(index);
			
			char ch = str2.charAt(i);
			char temp = str1.charAt(++index);
			
			while(index < str1.length() - 1 && temp != ch) {
				index++;
				temp = str1.charAt(index);
			}
			
			if(index == str1.length()  - 1 && temp != ch) {
				isSubseq = false;
			}
			
		}
		
		return isSubseq;
	}

}
