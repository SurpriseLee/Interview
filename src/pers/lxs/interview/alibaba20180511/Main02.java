package pers.lxs.interview.alibaba20180511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextInt();
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>(N);
		
		for(int i = 0; i < N; i++) {
			lists.add(new ArrayList<Integer>());
		}
		
		for(int i = 0;i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			lists.get(start).add(end);
		}
		sc.close();
		
		int maxPathNumber = getMaxPathNumber(lists);
		
		System.out.println(maxPathNumber);
	}
	
	
	
	public static int getMaxPathNumber(List<List<Integer>> lists) {
		
		if(lists == null || lists.size() <= 0) {
			return 0;
		}
		
		int[] pathNumbers = new int[lists.size()];
		for(int i = 0; i< pathNumbers.length; i++) {
			pathNumbers[i] = -1;
		}
		
		int maxPathNumber = 0;
		
		for(int i = 0; i < lists.size(); i++) {
			
			int pathNumber = getMaxPathNumber(i, pathNumbers, lists);
			
			maxPathNumber = maxPathNumber < pathNumber ? pathNumber : maxPathNumber;
		}
		
		System.out.println(Arrays.toString(pathNumbers));
		
		return maxPathNumber;
	}
	
	public static int getMaxPathNumber(int start, int[] pathNumbers, List<List<Integer>> lists) {
		
		if(lists.get(start).size() == 0) {
			pathNumbers[start] = 0;
			return 0;
		}
		
		if(pathNumbers[start] > -1) {
			return pathNumbers[start];
		}
		
		for(int index : lists.get(start)) {
			
			if(pathNumbers[start] == -1) {
				pathNumbers[start] = 1;
			} else{
				pathNumbers[start] += 1;
			}
			
			if(pathNumbers[index] < 0) {
				getMaxPathNumber(index, pathNumbers, lists);
			}
			
			pathNumbers[start] += pathNumbers[index];
		}
		
		
		return pathNumbers[start];
	}
	
	
}
