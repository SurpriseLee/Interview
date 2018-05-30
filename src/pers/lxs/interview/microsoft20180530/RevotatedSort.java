package pers.lxs.interview.microsoft20180530;

import org.junit.Test;

public class RevotatedSort {
	
	@Test
	public void test() {
		
		int[] array = new int[]{4,7,9,0,1,2,3};
		
		int value = 5;
		
		int index = findIndex(array, value);
		
		System.out.println(index);
		
	}
	
	public int findIndex(int[] array, int value) {
		
		if(array == null || array.length <= 0) {
			return -1;
		}
		
		int left = 0;    int right = array.length - 1;
		
		while(left <= right) {
			
			if(array[left] == value) {
				return left;
			}
			
			if(array[right] == value) {
				return right;
			}
			
			int mid = (left + right) / 2;
			
			if(array[mid] == value) {
				return mid;
			}
			
			if(array[mid] > array[left] && array[mid] > array[right]) {
				
				if(value > array[left] && value < array[mid]) {
					left = mid + 1;
					right -= 1;
				} else {
					left += 1;
					right = mid - 1;
				}
				
			} else if(array[mid] < array[left] && array[mid] < array[right]) {
				
				if(value > array[mid] && value < array[right]) {
					left = mid + 1;
					right -= 1;
				} else {
					left += 1;
					right = mid -1;
				}
				
			} else {
				
				if(value > array[mid]) {
					left = mid +1;
					right -= 1;
				} else {
					left += 1;
					right = mid -1;
				}
			}
		}
		
		return -1;
	}
	

}
