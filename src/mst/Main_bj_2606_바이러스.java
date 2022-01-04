package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2606_바이러스 {
	static boolean[][] arr;
	static boolean[] visited;
	static int N, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		cnt = 0;
		int M = Integer.parseInt(br.readLine());
		for(int i =0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = true;
			arr[to][from] = true;
		}
		dfs(1);
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		for(int i = 1 ; i <= N ; i++) {
			if(arr[start][i] && !visited[i]) {
				dfs(i);
				cnt++;
			}
		}
	}
}
