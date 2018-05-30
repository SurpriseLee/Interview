package pers.lxs.interview.toutiao201802;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main20180202 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		
		List<Map<Integer, Integer>> maps = new ArrayList<Map<Integer, Integer>>();
		
		for(int i = 0; i < n; i++) {
			
			int temp = sc.nextInt();
			
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for(int j = 0; j < temp; j++) {
				map.put(sc.nextInt(), 1);
			}
			
			maps.add(map);
		}
		sc.close();
		
		if(n < 1 || n > 10000 || m < 1 || m > 1000 || c < 1 || c > 50) {
			System.out.println(0);
			return;
		}
		
		int count = 0;
		for(int i = 1; i <= c; i++) {
			
			if(!isLegal(i, m, maps)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isLegal(int color, int m, List<Map<Integer, Integer>> maps) {
		
		if(maps == null || maps.size() <= 0) {
			return true;
		}
		
		int count = 0;
		int index = 0;
		int M = maps.size() + m;
		for(int i = 0; i < M; i++) {
			
			Map<Integer, Integer> map = maps.get(i % maps.size());
			
			if(map.containsKey(color)) {
				
				count += 1;
				
				if(count >= 2) {
					return false;
				}
				
			}
			
			index = count == 0 ? 0 : index + 1;

			if(index == m) {
				count = 0;
				index = 0;
			}
			
		}
		
		return true;
	}
	
	
}
