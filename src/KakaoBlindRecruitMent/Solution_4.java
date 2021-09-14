package KakaoBlindRecruitMent;


import java.util.*;

public class Solution_4 {
	static int max = 0;
	static int[] max_arr ;
	public static int[] solution(int n, int[] info) {
        int[] answer = new int[10];
        int[] cur = new int[10];
        max_arr = new int [10];
        subset(n, 0, cur, info, 0);
        if(max == 0 ) answer = new int[] {-1};
        else answer = max_arr;
        
        return answer;
    }
	private static void subset(int n, int cnt, int[] cur, int[] info, int idx) {
		if(idx >= 10) return;
		if(cnt == n) {
			int ryan_score = 0;
			int apea_score = 0;
			for(int i =0 ; i < 10 ; i++) {
				if(cur[i] > info[i]) ryan_score += (10 - i);
				else if(cur[i]< info[i]) apea_score += (10 - i);
			}
			System.out.println(Arrays.toString(cur));
			System.out.println(ryan_score);
			System.out.println(apea_score);
			if(ryan_score > apea_score) {
				max = Math.max(max, ryan_score);
				max_arr = cur;
			}
			return;
		}
		if(cur[idx] > info[idx] && idx < 9) {
			cur[idx+1] ++;
			subset(n, cnt+1, cur, info, idx+1);
			cur[idx+1]--;
			subset(n, cnt, cur, info, idx+1);
		}
		else {
			cur[idx] ++;
			subset(n, cnt+1, cur, info, idx);
			cur[idx] --;
			if(idx < 9) {
				cur[idx+1] ++;
				subset(n, cnt+1, cur, info, idx+1);
				cur[idx+1] --;
			}
			subset(n, cnt, cur, info, idx+1);
		}
	}
	public static void main(String[] args) {
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(Arrays.toString(solution(5, info)));
	}
}
