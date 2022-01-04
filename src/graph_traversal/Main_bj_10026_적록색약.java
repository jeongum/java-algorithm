package graph_traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_10026_적록색약 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;
	static char[][] color;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		color = new char[N][N];
		visited = new boolean[N][N];
		int res = 0;
		for(int i =0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j =0 ; j < N ; j++) {
				color[i][j] = str.charAt(j);
			}
		}
		//적록색약이 아닐 때, 구역 개수
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(!visited[i][j]) {
					area(i,j);
					res++;
				}
			}
		}
		sb.append(res).append(" ");
		
		res = 0;
		visited = new boolean[N][N];
		//적록색약일 때, 구역 개수
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(!visited[i][j]) {
					area(i,j);
					res++;
				}
			}
		}
		sb.append(res);
		System.out.println(sb.toString());
	}
	
	public static void area(int i, int j) {		//깊이우선탐색
		visited[i][j] = true;
		for(int d = 0; d< 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && !visited[ni][nj] && color[i][j] == color[ni][nj]) {
				area(ni, nj);
			}
		} 
		if(color[i][j] == 'G') color[i][j] = 'R';		//일반인 > 적록색약 순으로 검사하므로 일반인 검사 시에 G을 다 R로 바꿔 적록색약 검사를 위해 셋팅한다.
	}
}
