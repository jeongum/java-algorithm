package greedy;

import java.util.*;
import java.io.*;

public class Main_bj_11000_강의실배정 {
	static class Class implements Comparable<Class>{
		int start, end;
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Class o) {
			int val = this.end - o.end;
			if(val != 0) return val;
			return this.start - o.start;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Class[] classes = new Class[N];
		for(int i =0 ; i< N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			classes[i] = new Class(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(classes);
		List<Integer> time = new ArrayList<Integer>();
		time.add(classes[0].end);
		for(int i = 1; i<classes.length ; i++) {
			boolean flag = false;
			for(int j = 0 ; j < time.size() ; j++) {
				if(time.get(j) <= classes[i].start) {
					time.set(j, classes[i].end);
					flag = true;
					break;
				}
			}
			if(!flag) time.add(classes[i].end);
		}
		System.out.println(time.size());
	}
}
