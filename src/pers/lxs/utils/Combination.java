package pers.lxs.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Combination {
	
	@Test
	public void test() {
		
		int N = 100;
		int n = 10;
		
		int[] array = new int[N];
		
		for(int i = 0; i < N; i++) {
			array[i] = i + 1;
		}
		
		combine(array, n);
	}
	
	
	public void combine(int[] array, int n) {
		
		if(array == null || n <= 0 || array.length < n) {
			return;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		combine(array, list, 0, n);
	}
	
	public void combine(int[] array, List<Integer> list, int index, int n) {
		
		if(n == 0) {
			System.out.println(list.toString());
			return;
		}
		
		for(int i = index; i <= array.length - n; i++) {
			list.add(array[i]);
			combine(array, list, i + 1, n - 1);
			list.remove(list.size() - 1);
		}
		
	}
	
}
