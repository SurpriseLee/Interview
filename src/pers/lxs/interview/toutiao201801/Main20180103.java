package pers.lxs.interview.toutiao201801;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main20180103 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int P = sc.nextInt();
		
		if(N <= 0 || M <= 0 || P <= 0) {
			sc.close();
			return;
		}
		
		List<Idea> list = new ArrayList<Idea>();
		List<ArrayList<Idea>> lists = new ArrayList<ArrayList<Idea>>();
		
		for(int i = 0; i < N + 1; i++) {
			lists.add(new ArrayList<Idea>());
		}
		
		int minTime = Integer.MAX_VALUE;
		
		for(int i = 0; i < P; i++) {
			
			int pm = sc.nextInt();
			int proposeTime = sc.nextInt();
			int priority = sc.nextInt();
			int costTime = sc.nextInt();
			Idea idea = new Idea(pm, proposeTime, priority, costTime);
			list.add(idea);
			lists.get(pm).add(idea);
			
			minTime = proposeTime < minTime ? proposeTime : minTime;
			
		}
		sc.close();
		
		for(ArrayList<Idea> l : lists) {
			
			Collections.sort(l, new Comparator<Idea>(){

				@Override
				public int compare(Idea idea1, Idea idea2) {
					return idea1.proposeTime - idea2.proposeTime;
				}
				
			});
			
		}
		
		
		int[] times = new int[M];
		
		List<PriorityQueue<Idea>> pms = new ArrayList<PriorityQueue<Idea>>();
		
		for(int i = 0; i < N + 1; i++) {
			pms.add(new PriorityQueue<Idea>());
		}
				
		while(hasUnfinishedIdea(pms, lists)) {
			int programmerIndex = findMin(times);
			updatePriorityQueue(times[programmerIndex], pms, lists);
			
			int pmIndex = findTask(pms);
			
			Idea idea = pms.get(pmIndex).remove();
			
			int time = idea.proposeTime > times[programmerIndex] ? idea.proposeTime : times[programmerIndex];
			
			idea.finishedTime = time + idea.costTime;
			times[programmerIndex] = idea.finishedTime;
		}
		
		for(Idea idea : list) {
			System.out.println(idea.finishedTime);
		}
	}
	
	public static void updatePriorityQueue(int time, List<PriorityQueue<Idea>> pms, List<ArrayList<Idea>> lists) {
		
		if(listsIsEmpty(lists)) {
			return;
		}
		
		int min = 0;
		if(priorityQueueIsEmpty(pms) && !listsIsEmpty(lists)) {
			min = findMin(lists);
		}
		
		int minTime = min > time ? min : time;
		for(int i = 0; i < pms.size(); i++) {
			
			PriorityQueue<Idea> pq = pms.get(i);
			ArrayList<Idea> list = lists.get(i);
			
			while(!list.isEmpty()) {
				Idea idea = list.get(0);
				if(idea.proposeTime <= minTime) {
					pq.add(idea);
					list.remove(0);
				} else {
					break;
				}
			}
		}
	}
	
	public static int findMin(List<ArrayList<Idea>> lists) {
		
		int min = Integer.MAX_VALUE;
		
		for(ArrayList<Idea> list : lists) {
			
			for(Idea idea : list) {
				min = idea.proposeTime < min ? idea.proposeTime : min;
			}
		}
		
		return min;
	}
	
	public static boolean hasUnfinishedIdea(List<PriorityQueue<Idea>> pms, List<ArrayList<Idea>> lists) {
		
		if(pms == null || lists == null) {
			return false;
		}
		
		return !priorityQueueIsEmpty(pms) || !listsIsEmpty(lists);
	}
	
	public static boolean listsIsEmpty(List<ArrayList<Idea>> lists) {
		
		if(lists == null || lists.size() <= 0) {
			return true;
		}
		
		for(ArrayList<Idea> list : lists) {
			
			if(list.size() > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean priorityQueueIsEmpty(List<PriorityQueue<Idea>> pms) {
		
		if(pms == null || pms.size() <= 0) {
			return true;
		}
		
		for(PriorityQueue<Idea> pq : pms) {

			if(pq.size() > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int findMin(int[] times) {
		
		if(times == null || times.length <= 0) {
			return -1;
		}
		
		int index = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < times.length; i++) {
			if(times[i] < min) {
				min = times[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int findTask(List<PriorityQueue<Idea>> pms) {
		
		if(pms == null || pms.size() <= 0) {
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		
		int index = -1;
		int i = 0;
		for(PriorityQueue<Idea> pq : pms) {
			
			Idea idea = pq.peek();
			
			if(idea != null && idea.costTime < min) {
				min = idea.costTime;
				index = i;
			}
			i++;
		}
		
		return index;
	}
	
	static class Idea implements Comparable<Idea> {
		int pm;
		int proposeTime;
		int priority;
		int costTime;
		int finishedTime;
		
		public Idea(int pm, int proposeTime, int priority, int costTime) {
			this.pm = pm;
			this.proposeTime = proposeTime;
			this.priority = priority;
			this.costTime = costTime;
		}

		@Override
		public int compareTo(Idea idea) {
			// TODO Auto-generated method stub
			
			if(this.priority != idea.priority) {
				return idea.priority - this.priority;
			}
			
			return this.proposeTime - idea.proposeTime;
		}
		
		public String toString() {
			return this.pm + " " + this.proposeTime + " " + this.priority + " " + this.costTime;
		}
		
	}
}
