package pers.lxs.utils;

import java.util.Arrays;

import org.junit.Test;

public class ThrowException {
	
	@Test
	public void test() {
		
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		
		StringBuilder tempSb = new StringBuilder("\n");
		
		tempSb.append("The info you want to know!\n");
		tempSb.append(Arrays.toString(array));
		
		try {
			throw new Exception(tempSb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
