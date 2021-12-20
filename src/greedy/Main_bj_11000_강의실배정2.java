package greedy;

import java.util.*;
import java.io.*;

public class Main_bj_11000_강의실배정2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> lectures = new ArrayList<int[]>();
		StringTokenizer st = null;
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			lectures.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		lectures.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures.get(0)[1]);
		for(int i = 1; i < lectures.size() ; i++) {
			if(pq.peek() <= lectures.get(i)[0]) pq.poll();
			pq.offer(lectures.get(i)[1]);
		}
		
		System.out.println(pq.size());
	}

}
