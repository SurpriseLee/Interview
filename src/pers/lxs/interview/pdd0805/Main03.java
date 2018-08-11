package pers.lxs.interview.pdd0805;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.nextLine();
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for(int i = 0; i < N; i++) {
			String str = scanner.nextLine().trim();
			String[] strs = str.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(String s : strs) {
				list.add(Integer.parseInt(s));
			}
			lists.add(list);
		}
		scanner.close();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(M, 1);
		for(int e : lists.get(M)) {
			map.put(e, 1);
		}
		
		int max = 0;    int index = -1;
		for(int i = 0; i < lists.size(); i++) {
			
			if(!map.containsKey(i)) {
				int count = 0;
				for(int e : lists.get(i)) {
					if(map.containsKey(e)) {
						count += 1;
					}
				}
				
				if(count > max) {
					max = count;
					index = i;
				}
			}
		}
		
		System.out.println(index);
	}

}
