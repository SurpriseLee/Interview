package pers.lxs.interview.pinduoduo;

public class Main11 {
	
	public static void main(String[] args) {
		
		String string = "1+2*3+4*5*6+7";
		
		String[] nums = string.split("\\*|\\+");
		String[] operator = string.split("\\w");

		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		

		for(int i = 0; i < operator.length; i++) {
			System.out.print(operator[i] + " ");
		}
		System.out.println();
		
		int result = Integer.parseInt(nums[0]);
		System.out.println("result: " + result);
		for(int i = 1; i < nums.length; i++) {
			
			System.out.println("i = " + i);
			System.out.println("op: " + operator[0]);
			
			if(operator[i].equals("+")) {
				result += Integer.parseInt(nums[i]);
				System.out.println(i + " " + nums[i] + " +: " + result);
			} else if(operator[i].equals("*")) {
				result *= Integer.parseInt(nums[i]);
				System.out.println(nums[i]  + " *: " + result);
			}
		}
		
		System.out.println(result);
		
		
		
	}

}
