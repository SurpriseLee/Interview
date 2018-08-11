package pers.lxs.interview.pdd20180723;

import java.util.Arrays;
import java.util.Scanner;


public class Main01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		
		int[] maxs = new int[3];
		int[] mins = new int[2];
		
		maxs[0] = array[0];
		mins[0] = array[0];
		
		for(int i = 1; i < array.length; i++) {
			
			if(array[i] >= maxs[0]) {
				maxs[2] = maxs[1];
				maxs[1] = maxs[0];
				maxs[0] = array[i];
			} else if(array[i] >= maxs[1]) {
				maxs[2] = maxs[1];
				maxs[1] = array[i];
			} else if(array[i] >= maxs[2]) {
				maxs[2] = array[i];
			}
			
			if(array[i] <= mins[0]) {
				mins[1] = mins[0];
				mins[0] = array[i];
			} else if(array[i] <= mins[1]) {
				mins[1] = array[i];
			}
		}
		
		System.out.println(Arrays.toString(maxs));
		System.out.println(Arrays.toString(mins));
		
		long result1 = 1;
		for(int e : maxs) {
			result1 *= e;
		}
		
		long result2 = maxs[0];
		for(int e : mins) {
			result2 *= e;
		}
		System.out.println(result1);
		System.out.println(result2);
		
		System.out.println(result1 > result2 ? result1 : result2);
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
	}
	
	

}
