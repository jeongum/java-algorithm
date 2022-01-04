package graph_traversal;

import java.util.*;
import java.io.*;

public class Main_bj_9466_텀프로젝트 {
	static int N, cnt;
	static int[] fav;
	static boolean[] visited, finished;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int T = 1 ; T <= tc ; T++) {
			N = Integer.parseInt(br.readLine());
			fav = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =1 ; i <= N ; i++) {
				fav[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			for(int i =1 ; i <= N; i++) {
				dfs(i);
			}
			System.out.println(N - cnt);
		}
	}
	private static void dfs(int i) {
		if(visited[i]) return;
		visited[i] = true;
		int n = fav[i];
		if(!visited[n]) dfs(n);
		else {
			if(!finished[n]) {
				cnt++;
				while(n != i) {
					cnt ++;
					n = fav[n];
				}
			}
		}
		finished[i] = true;
	}

}
