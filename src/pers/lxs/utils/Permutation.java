package pers.lxs.utils;

import java.util.Arrays;

import org.junit.Test;

public class Permutation {
	
	@Test
	public void test() {
		int[] array = new int[]{1,2,3,4,5,6,8,9};
		permutation(array);
	}

	public void permutation(int[] array) {
		
		if(array == null || array.length <= 0) {
			return;
		}
		
		permutation(array, 0);
	}
	
	public void permutation(int[] array, int index) {
		
		if(index == array.length - 1) {
			System.out.println(Arrays.toString(array));
		}
		
		for(int i = index; i < array.length; i++) {
			swap(array, index, i);
			permutation(array, index + 1);
			swap(array, index, i);
		}
	}
	
	public void swap(int[] array, int left, int right) {
		
		if(array == null || left < 0 || right < 0 || left >= array.length || right >= array.length) {
			return;
		}
		
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
