package greedy;

import java.util.*;
import java.io.*;

public class Main_bj_11000_강의실배정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lectures = new int[N][2];
		for(int i =0 ; i< N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			lectures[i][0] = Integer.parseInt(st.nextToken());
			lectures[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lectures, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> time = new PriorityQueue<>();
		time.offer(lectures[0][1]);
		for(int i = 1; i<lectures.length ; i++) {
			if(time.peek() <= lectures[i][0]) time.poll();
			time.offer(lectures[i][1]);
		}
		System.out.println(time.size());
	}
}
