package pers.lxs.interview.toutiao20180512;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<List<String>> libLists = new ArrayList<List<String>>();
		List<List<String>> queryLists = new ArrayList<List<String>>();
		while(true) {
			
			String numberLine = in.nextLine();
			
			if(numberLine.length() <= 1) {
				in.close();
				break;
			}
			
			String[] numbers = numberLine.split(" ");
			
			int M = Integer.parseInt(numbers[0]);
			int N = Integer.parseInt(numbers[1]);
			
			if(M <= 0 || M > 2000000 || N <= 0 || N > 2000000) {
				in.close();
				return;
			}
			
			List<String> libList = new ArrayList<String>(M);
			List<String> queryList = new ArrayList<String>(N);
			
			int index = 0;
			while(index < M) {
				String str = in.nextLine();
				libList.add(str);
				index++;
			}
			in.nextLine();
			
			index = 0;
			while(index < N) {
				String str = in.nextLine();
				queryList.add(str);
				index++;
			}
			in.nextLine();
			
			libLists.add(libList);
			queryLists.add(queryList);
		}
		
		in.close();
		
		for(int i = 0; i < queryLists.size(); i++) {
			
			List<String> libList = libLists.get(i);
			List<String> queryList = queryLists.get(i);
			for(String query : queryList) {
				int result = query(query, libList);
				System.out.println(result);
			}
			System.out.println();
		}
		
	}
	
	public static int query(String query, List<String> libList) {
		
		if(query == null || query.length() <= 0 || libList == null || libList.size() <= 0) {
			return -1;
		}
		
		int index = getIndex(query, libList);
		
		if(index == -1) {
			return -1;
		}
		
		int tempIndex = index;
		while(tempIndex >= 0 && libList.get(tempIndex).charAt(0) == query.charAt(0)) {
			
			if(libList.get(tempIndex).length() <= query.length()) {
				
				boolean flag = query.startsWith(libList.get(tempIndex));
				
				if(flag) {
					return 1;
				}
			}
			
			tempIndex -= 1;
		}
		
		tempIndex = index + 1;
		while(tempIndex >= 0 && tempIndex < libList.size() && libList.get(tempIndex).charAt(0) == query.charAt(0)) {
			
			if(libList.get(tempIndex).length() <= query.length()) {
				
				boolean flag = query.startsWith(libList.get(tempIndex));
				
				if(flag) {
					return 1;
				}
			}
			
			tempIndex += 1;
		}
		
		return -1;
	}
	
	public static int getIndex(String query, List<String> libList) {
		
		int left = 0; int right = libList.size() - 1; 
		int index = (left + right) >> 1;
		while(left <= right) {
			
			index = (left + right) >> 1;
			
			if(libList.get(index).charAt(0) == query.charAt(0)) {
				break;
			} else if(libList.get(index).charAt(0) > query.charAt(0)) {
				 right = index - 1;
				
			} else if(libList.get(index).charAt(0) < query.charAt(0)) {
				 left = index + 1;
			}
		}
		
		if(index >= 0 && index < libList.size() && libList.get(index).charAt(0) == query.charAt(0)) {
			return index;
		} else {
			return - 1;
		}
		
	}
}
