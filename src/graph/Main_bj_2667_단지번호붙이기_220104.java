package graph;

import java.util.*;
import java.io.*;

public class Main_bj_2667_단지번호붙이기_220104 {
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, -1, 0, 1};
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> town;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		town = new ArrayList<Integer>();
		for(int i =0 ; i < N; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					setTown(i, j);
					town.add(cnt);
				}
			}
		}
		System.out.println(town.size());
		Collections.sort(town);
		for(Integer t : town) {
			System.out.println(t);
		}
	}
	private static void setTown(int i, int j) {
		visited[i][j] = true;
		for(int d = 0 ; d < 4 ; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && map[ni][nj] == 1 && !visited[ni][nj]) {
				setTown(ni, nj);
				cnt++;
			}
		}
	}

}
