package graphTraversal;

import java.util.*;
import java.io.*;

public class Main_bj_5014_스타트링크 {
	static int F,S,G,U,D, res=-1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());	// 층 수
		S = Integer.parseInt(st.nextToken());	// 강호가 지금 있는 곳
		G = Integer.parseInt(st.nextToken());	// 스타트링크가 있는 곳
		U = Integer.parseInt(st.nextToken());	// 위로 U층 가는 버튼
		D = Integer.parseInt(st.nextToken());	// 아래로 D층 가는 버튼
		
		elevator();
		
		System.out.println(res==-1?"use the stairs":res);
	}

	private static void elevator() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[F+1];
		q.offer(new int[] {S, 0});
		visited[S] = true;
		while(!q.isEmpty()) {
			int[] s = q.poll();
			
			if(s[0] == G) res = s[1];
			
			int u = s[0]+U;
			int d = s[0]-D;
			
			if(u <= F && !visited[u]) {
				q.offer(new int[] {u, s[1]+1});
				visited[u] = true;
			}
			
			if(1 <= d && !visited[d]) {
				q.offer(new int[] {d, s[1]+1});
				visited[d] = true;
			}
		}
	}
}
