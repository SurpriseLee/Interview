package pers.lxs.interview.toutiao20180415;

import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        String options = in.nextLine();
        
        int Q = in.nextInt();
        
        int[] N = new int[Q];
        int[] M = new int[Q];
        int[] X = new int[Q];
        int[] Y = new int[Q];
        
        int index = 0;
        while(index < Q) {
        	 N[index] = in.nextInt();
        	 M[index] = in.nextInt();
        	 X[index] = in.nextInt();
        	 Y[index] = in.nextInt();
             index++;
        }
       
        in.close();
        
        index = 0;
        while(index < Q) {
        	System.out.println(getResult(N[index], M[index], X[index], Y[index], options));
        	index++;
        }
    }
    
    public static int getResult(int N, int M, int X, int Y, String options) {
    	
    	int count = 0;
    	
    	for(char option : options.toCharArray()) {
    		switch(option) {
    		case 'u':  
    			X -= 1; 
    			count += 1; 
    			if(!isInMat(N, M, X, Y)) {
    				return count;
    			}
    			break;
    		case 'd':
    			X += 1; 
    			count += 1; 
    			if(!isInMat(N, M, X, Y)) {
    				return count;
    			}
    			break;
    		case 'l':
    			Y -= 1; 
    			count += 1; 
    			if(!isInMat(N, M, X, Y)) {
    				return count;
    			}
    			break;
    		case 'r':
    			Y += 1; 
    			count += 1; 
    			if(!isInMat(N, M, X, Y)) {
    				return count;
    			}
    			break;
    		default: 
    		}
    	}
    	
    	return count;
    }
    
    public static boolean isInMat(int M, int N, int X, int Y) {
    	
    	if(X >= 1 && X <= M && Y >= 1 && Y <= N) {
    		return true;
    	}
    	
    	return false;
    }
}
