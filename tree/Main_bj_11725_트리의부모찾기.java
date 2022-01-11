package tree;

import java.io.*;
import java.util.*;

public class Main_bj_11725_트리의부모찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		Deque<int[]> queue = new ArrayDeque<>();
		int[] arr = new int[n];
		arr[0] = 1;
		
		for(int i = 0; i < n-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			queue.offer(new int[] {a,b});
		}
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(arr[tmp[0]-1] != 0) {
				arr[tmp[1]-1] = tmp[0];
			} else if(arr[tmp[1]-1] != 0){
				arr[tmp[0]-1] = tmp[1];
			}else {
				queue.offer(tmp);
			}
		}
		
		for(int i =1 ; i < n ; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
