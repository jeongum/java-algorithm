package brute_force;

import java.io.*;
import java.util.*;

public class Main_bj_17281_야구 {
	static int n;
	static int[][] score;
	static int max_score;
	static boolean[] isSelected;
	static int[] tasun;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		score = new int[n][9];
		
		for(int i =0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < 9 ; j ++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max_score = Integer.MIN_VALUE;
		isSelected = new boolean[9];
		isSelected[0] = true;				//1번선수는 이미 배치
		tasun = new int[9];
		tasun[3] = 0;						//4번타자는 이미 배치
		perm(0);							//순열 실행
		
		System.out.println(max_score);
	}
	
	public static void perm(int cnt) {
		if(cnt == 3) { // 4번째 타자는 1번.
            perm(cnt + 1);
            return;
        }
		else if(cnt == 9) {		//기저조건
			game();				//게임진행
			return;
		}
		for(int i = 1; i < 9 ; i++) {
			if(isSelected[i]) continue;	
			tasun[cnt] = i; 
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void game() {
		int out = 0;						//out카운트
		int cur = 0;						//현재 타자 순서
		int ining = 0;						//이닝
		int win =0;							//승점
		boolean hit[] = new boolean[3];		//루의 상태(false-주자 없음, true-주자있음)
		while(ining<n) {
			out = 0;					//이닝 시작시 out과 루 초기화
			hit = new boolean[3];
			while(out<3) {			//1~4에 따른 루의 변화 및 득점
				if(score[ining][tasun[cur]] == 0) out++;	//아웃
				else if(score[ining][tasun[cur]] == 1) {	//안타
					if(hit[2]) win ++;
					hit[2] = hit[1];
					hit[1] = hit[0];
					hit[0] = true;
				}
				else if(score[ining][tasun[cur]] == 2) {	//2루
					if(hit[2]) win ++;
					if(hit[1]) win++;
					hit[2] = hit[0];
					hit[1] = true;
					hit[0] = false;
				}
				else if(score[ining][tasun[cur]] == 3) {	//3루
					if(hit[2]) win ++;
					if(hit[1]) win++;
					if(hit[0]) win++;
					hit[2] = true;
					hit[1] = false;
					hit[0] = false;
				}
				else if(score[ining][tasun[cur]] == 4) {	//홈런
					if(hit[2]) win++;
					if(hit[1]) win++;
					if(hit[0]) win++;
					hit[2] = false;
					hit[1] = false;
					hit[0] = false;
					win++;
				}
				cur = (cur+1)%9;		//9번 선수 후, 다시 1번으로 돌아가는 순환구조이므로
			}
			ining ++;
		}
		max_score = Math.max(max_score, win);
	}
}
