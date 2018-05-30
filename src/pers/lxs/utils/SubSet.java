package pers.lxs.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubSet {
	
	@Test
	public void test() {
		
		int N = 10;
		
		int[] array = new int[N];
		
		for(int i = 1; i <= N; i++) {
			array[i - 1] = i;
		}
		
		subSet(array);
	}
	
	public void subSet(int[] array) {
		
		if(array == null || array.length <= 0) {
			return;
		}
		
		int n = (int) Math.pow(2, array.length) - 1;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			
			String str = Integer.toBinaryString(i);
			
			int index = 0;
			for(int j = str.length() - 1; j >= 0; j--) {
				
				if(str.charAt(j) == '1') {
					list.add(array[index]);
				}
				
				index++;
			}
			
			System.out.println(list.toString());
			
			list.clear();
		}
	}

}
