package pers.lxs.interview.pinduoduo;

public class Main14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[]{1,0,1,0,2,3,0,5,8,13};
		
		int len = 0;
		
		int last = 0;
		int cur = 0;
		int target = 0;
		int index = 0;
		
		while(index < nums.length) {
			if(nums[index] == 1) {
				len += 1;		System.out.println(len + ": " + nums[index]);
				cur = nums[index];
				target = cur + last;
				index++;
				break;
			}
			index++;
		}
		while(index < nums.length) {
			if(nums[index] == target) {
				len += 1;		System.out.println(len + ": " + nums[index]);
				last = cur;
				cur = nums[index];
				target = cur + last;
			}
			
			index++;	
		}
		
		System.out.println(len);
	}

}
