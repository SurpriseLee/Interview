package pers.lxs.interview.microsoft20180530;

import org.junit.Test;

/**
 * Given a buffer, implement write data into buffer circularly
 * @author SurpriseLee
 *
 */
public class Main01 {

	@Test
	public void test() {
		
		String str = "abcdefghijklmn";
		
		for(char ch : str.toCharArray()) {
			writeBuffer((byte)ch);
			System.out.println(new String(buffer));
		}
		
	}
	
	byte[] buffer = new byte[10];
	int index = 0;
	
	public void writeBuffer(byte data) {
		buffer[index] = data;
		index = (index + 1) % buffer.length;
	}
	
}
