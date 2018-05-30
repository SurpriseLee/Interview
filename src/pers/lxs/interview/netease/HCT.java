package pers.lxs.interview.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HCT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine()) != null){
            int n = Integer.parseInt(line.trim());
            line = br.readLine();
            int[] nums = new int[n];
            String[] s = line.trim().split(" ");
            for(int i=0;i<n;i++){
                nums[i] = Integer.parseInt(s[i]);  //a[i]表示学生的能力值
            }
            line = br.readLine();
            String[] s1 = line.trim().split(" ");
            int k = Integer.parseInt(s1[0]);  //选取k个学生
            int d = Integer.parseInt(s1[1]);  //编号之差不超过d
            long[][] max = new long[k][n];
            long[][] min = new long[k][n];
            for(int i=0;i<k;i++){
                for(int j=0;j<n;j++){
                    max[i][j] = 1;
                    min[i][j] = 1;
                    if(i==0){
                        min[i][j] = nums[j];
                        max[i][j] = nums[j];
                    }
                }
            }
            for(int i=1;i<k;i++){
                for(int j=0;j<n;j++){
                    for(int m=1;m<=d;m++){
                        if(j-m >= 0){
                            if(nums[j] > 0){
                                min[i][j] = Math.min(min[i][j], min[i-1][j-m] * nums[j]);
                                max[i][j] = Math.max(max[i][j], max[i-1][j-m] * nums[j]);
                            }else{
                                min[i][j] = Math.min(min[i][j], max[i-1][j-m] * nums[j]);
                                max[i][j] = Math.max(max[i][j], min[i-1][j-m] * nums[j]);
                            }
                        }
                    }
                }
            }
            long res = 0;
            for(int i=0;i<n;i++){
                if(i>=k-1){
                    res = Math.max(res, max[k-1][i]);
                }
            }
            System.out.println(res);
        }
    }
}