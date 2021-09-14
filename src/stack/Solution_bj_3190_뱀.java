package stack;

import java.io.*;
import java.util.*;


public class Solution_bj_3190_뱀 {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		//사과가 있는 곳: 1
		for(int i =0 ; i < k ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		//방향정보가 담긴 배열
		int l = Integer.parseInt(br.readLine());
		int[][] dirArr = new int[l][2];
		for(int i = 0 ; i < l ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			dirArr[i][0] = Integer.parseInt(st.nextToken());
			dirArr[i][1] = st.nextToken().charAt(0);
		}
		
		//snake의 몸 정보를 담을 Deque
		Deque<int[]> snake = new ArrayDeque<>();
		
		//초기 셋팅
		snake.offerFirst(new int[] {0,0});
		map[0][0] = 2;
		int dir = 0;
		int time = 0;
		int idx = 0;
		while(true) {
			if(time == dirArr[idx][0]) {	//방향을 바꿔야 하는 시간
				if(dirArr[idx][1] == (int)'D') dir ++;
				else {
					dir --;
					if(dir == -1) dir = 3;		//dir이 -1이 된다면 '상' 방향으로 재 설정
				}
				if(idx < l-1) idx++;	//방향정보가 시간순대로 저장되어 있으므로, 남은 방향정보가 있다면 그 정보로 셋팅
			}
			
			//다음에 갈 맵 주소 ni, nj
			int ni = snake.peekFirst()[0] + di[dir%4];	
			int nj = snake.peekFirst()[1] + dj[dir%4];
			
			//종료조건
			if(ni<0 || ni>=n || nj<0 || nj>=n) break;
			if(map[ni][nj] == 2) break;
			
			//가는 곳에 사과가 없다면, 몸길이를 늘리지 않음
			if(map[ni][nj] == 0) {
				int[] tmp = snake.pollLast();	//꼬리의 주소 값을 뺌
				map[tmp[0]][tmp[1]] = 0;	//해당 주소의 맵 정보 0으로 재설정
			}
			snake.offerFirst(new int[] {ni,nj});	//항상 머리를 늘림 
			map[ni][nj] = 2;	// 뱀이 있는 곳에 맵 정보를 2로 재설정
			time ++;
		}
		System.out.println(time+1);
	}
}
