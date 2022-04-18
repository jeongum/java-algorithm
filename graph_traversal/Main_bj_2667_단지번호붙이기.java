package graph_traversal;

import java.io.*;
import java.util.*;

public class Main_bj_2667_단지번호붙이기 {
	static int N, idx;
	static int[][] arr;
	static int[] cnt;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cnt = new int[N*N];
		visited = new boolean[N][N];
		idx = 0;
		
		for(int i =0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j =0 ; j < N ; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i =0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					idx++;
				}
			}
		}
		cnt = Arrays.copyOf(cnt, idx);
		Arrays.sort(cnt);
		System.out.println(idx);
		for(int i =0 ; i < idx ; i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void dfs(int ci, int cj) {
		cnt[idx] ++;
		visited[ci][cj] = true;
		for(int i =0 ; i < 4 ; i++) {
			int ni = ci+di[i];
			int nj = cj+dj[i];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && arr[ni][nj] == 1 && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}
}
