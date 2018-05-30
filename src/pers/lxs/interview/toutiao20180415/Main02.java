package pers.lxs.interview.toutiao20180415;

import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int m = in.nextInt();
        
        int[] a = new int[n1];
        int[] b = new int[n2];
        
        int index = 0;
        while(index < n1) {
        	a[index++] = in.nextInt();
        }
        
        index = 0;
        while(index < n1) {
        	b[index++] = in.nextInt();
        }
        
        in.close();
        
        System.out.println(m);
    }
}
