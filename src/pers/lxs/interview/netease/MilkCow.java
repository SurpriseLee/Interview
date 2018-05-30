package pers.lxs.interview.netease;

import java.io.IOException;
import java.util.Scanner;

public class MilkCow {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int[] apples = new int[N];
		
		int sum = 0;
		for(int i = 0; i < apples.length; i++) {
			apples[i] = scanner.nextInt();
			sum += apples[i];
		}
		
		if(sum % apples.length != 0) {
			System.out.println(-1);
			scanner.close();
			return;
		}
		
		int ave = sum / apples.length;
		
		int time = 0;
		for(int i = 0; i < apples.length ; i++) {
			
			if((apples[i] - ave) % 2 != 0) {
				time = -1;
				
				break;
			}
			
			
			if(apples[i] < ave) {
				
				if((ave - apples[i]) % 2 != 0) {
					time = -1;
					
					System.out.println(ave + "  " + apples[i]);
					
					break;
				}
				
				time += (ave - apples[i]) / 2;
				
			}
		}
		
		System.out.println(time);
		
		scanner.close();
	}

}
