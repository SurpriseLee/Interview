package pers.lxs.interview.pinduoduo;

import java.util.HashMap;
import java.util.Map;

public class Main13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 5);
		map.put(2, 5);
		map.put(3, 4);
		map.put(4, 5);
		
		int result = map.get(4);
		
		System.out.println("result: " + result);
		
		int min = Math.min(map.get(1), map.get(3));
		result += min;
		
		map.replace(3, map.get(3) - min);
		map.replace(1, map.get(1) - min);
		
		result += map.get(3);
		System.out.println("result: " + result);
		
		result += map.get(2) / 2;
		map.replace(2, map.get(2) % 2);
		
		if(map.get(1) > 2) {
			
		}
		
		min = Math.min(map.get(1) / 2, map.get(2));	// 有问题
		
		result += min;
		
		result += map.get(2);
		System.out.println("result: " + result);
		
		if(map.get(1) % 4 != 0) {
			result += map.get(1) / 4 + 1;
		} else {
			result += map.get(1) / 4;
		}
		System.out.println("result: " + result);		
		
		System.out.println(result);
	}

}
