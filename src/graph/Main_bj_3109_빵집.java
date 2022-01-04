package graph;

import java.io.*;
import java.util.*;

public class Main_bj_3109_빵집 {
	static int R, C, cnt;
	static char[][] map;		//맵 정보 저장
	static int[] di = {-1,0,1};		//우상, 우, 우하
	static int[] dj = {1,1,1};
	static boolean flag = false;	//백트래킹 flag

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		cnt = 0;
		for(int i =0 ; i < R ; i++) {
			String str = br.readLine();
			for(int j =0 ; j < C ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0 ; i< R ; i++) {		//0행에서 R-1행까지 탐색
			flag = false;		
			setPipe(i, 0);		//깊이 우선 탐색
		}
		System.out.println(cnt);
	}
	
	private static void setPipe(int rowNo, int colNo) {
		if(colNo == C-1) {		//기저조건
			map[rowNo][colNo] = 'O';	
			flag = true;	//해당 경로에서의 경우의 수 탐색이 종료되었음을 알림
			cnt++;	
			return;
		}
		for(int i =0 ; i < 3 ; i++) {		//삼방탐색
			int ni = rowNo + di[i];
			int nj = colNo + dj[i];
			if(0<=ni&&ni<R && 0<=nj&&nj<C && map[ni][nj] == '.') {
				map[rowNo][colNo] = 'O';	
				setPipe(ni, nj);	//깊이 우선 탐색
				if(flag) return;		//해당 경로에서 더이상 탐색하지 않도록
			}
		}
	}
}
