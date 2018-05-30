package pers.lxs.interview.toutiao201801;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main20180101 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Point> list = new ArrayList<Point>();
		
		int N = scanner.nextInt();
		Point p = new Point(0, 0);
		for(int i = 0; i < N; i++) {
			
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			if(x >= p.x || y >= p.y) {
				p = new Point(x, y);
				list.add(p);
			}
		}
		
		Collections.sort(list);
		
		int minx = Integer.MIN_VALUE;
		
		for(Point point : list) {
			if(point.x > minx) {
				System.out.println(point.x + " " + point.y);
				minx = point.x;
			}
		}
		
		scanner.close();
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			// TODO Auto-generated method stub
			
			if(this.y != p.y) {
				return p.y - this.y;
			}
			
			return this.x - p.x;
		}
	}
}
