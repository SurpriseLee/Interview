package pers.lxs.interview.huawei20180418;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// int years = in.nextInt();
		// int weeks = in.nextInt();
		in.close();

		int years = 1;
		int weeks = 0;
		
		if(years < 1 || years > 400 || weeks < 0 || weeks > 6) {
			System.out.println(-1);
			return;
		}
		
		int count = 0;
		for(int year = 1900; year < 1900 + years; year++) {
			
			for(int month = 1; month <= 12; month++) {
				int days = getDays(year, month, 13);
				int week = days % 7;
				
				if(week == weeks) {
					count += 1;
				}
			}
		}
		
		System.out.println(count);
	}

	public static int getDays(int year, int month, int day) {
		
		int days = 0;
		for(int i = 1900; i < year; i++) {
			
			if(isLeap(i)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		
		for(int m = 1; m < month; m++) {
			days += getMonthDays(year, m);
		}
		
		days += day;
		
		return days;
	}

	public static int getMonthDays(int year, int month) {

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (isLeap(year))
				return 29;
			else
				return 28;
		}

		return -1;
	}

	public static boolean isLeap(int year) {

		if (year % 400 == 0) {
			return true;
		}

		if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}

		return false;
	}

}
