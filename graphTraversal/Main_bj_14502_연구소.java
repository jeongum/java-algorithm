package graphTraversal;

import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int n, m;
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] v;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		tmpMap = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0);
		System.out.println(result);
		
	}
	private static void makeWall(int cnt) {
		if(cnt == 3) {
			v = new boolean[n][m];
			for(int i = 0 ; i < n ; i++) {
				for(int j =0 ; j < m ; j++) {
					tmpMap[i][j] = map[i][j];
				}
			}
			for(int i = 0 ; i < n ; i++) {
				for(int j =0 ; j < m ; j++) {
					if(tmpMap[i][j] == 2 && !v[i][j]) {
						spreadVirus(i,j); 
					}
				}
			}
			int tmp = 0;
			for(int i =0 ; i < n ; i++) {
				for(int j =0 ; j < m ; j++) {
					if(tmpMap[i][j] == 0) tmp ++;
				}
			}
			result = Math.max(result, tmp);
			return;
		}
		for(int i =0 ; i < n ; i++) {
			for(int j =0 ; j < m ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	private static void spreadVirus(int ci, int cj) {
		v[ci][cj] = true;
		for(int d=0 ; d < 4 ; d++) {
			int ni = ci + di[d];
			int nj = cj + dj[d];
			if(0<=ni&&ni<n && 0<=nj&&nj<m && tmpMap[ni][nj]==0 && !v[ni][nj]) {
				tmpMap[ni][nj] = 2;
				spreadVirus(ni, nj);
			}
		}
	}
}
