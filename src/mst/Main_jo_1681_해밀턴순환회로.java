package mst;

import java.io.*;
import java.util.*;

public class Main_jo_1681_해밀턴순환회로 {
	static int N, res;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		res = Integer.MAX_VALUE;
		visited[0] = true;
		getCost(0,1,0);
		System.out.println(res);
	}
	private static void getCost(int start, int cnt, int cost) {
		if(cnt == N) {
			if(map[start][0] == 0) return;
			cost += map[start][0];
			res = Math.min(res, cost);
			return;
		}
		if(cost>res) return;
		for(int i = 1; i < N ; i++) {
			if(visited[i] || map[start][i]==0) continue;
			visited[i] = true;
			getCost(i, cnt+1, cost+map[start][i]);
			visited[i] = false;
		}
	}
}
