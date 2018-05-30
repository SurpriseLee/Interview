package pers.lxs.interview.meituan20180420;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
		
        sc.close();
        
        if(n > N || m > N || N > 100000 || p > 100000) {
        	System.out.println("");
        	return;
        }
        
        int[] A = new int[N];
        A[0] = p;
        
        for(int i = 1; i < N; i++) {
        	A[i] = (A[i - 1] + 153) % p;
        }
        
        System.out.println(Arrays.toString(A));
        
        int sum = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		
        		String key = i + "" + j;
        		if(!map.containsKey(i + "" + j)) {
        			int value = gcd(i + 1, j + 1);
        			map.put(key, value);
        			map.put(j + "" + i, value);
        		}
        		
        		sum += A[map.get(key) - 1];
        	}
        }
        
        System.out.println(sum);
	}
	
	
	
	public static int gcd(int m, int n) {
		
		if(m <= 0 || n <= 0) {
			return 0;
		}
		
		if(m <= n && n % m == 0) {
			return m;
		}
		
		if(n <= m && m % n == 0) {
			return n;
		}
		
		int min = Math.min(m, n);
		
		if(m % min == 0 && n % min == 0) {
			return min;
		}
		
		for(int i = min / 2; i > 0; i--) {
			
			if(m % i == 0 && n % i == 0) {
				return i;
			}
		}
		
		return 1;
	}
}
