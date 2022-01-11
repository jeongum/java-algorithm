package dynamic_programming;

import java.util.*;
import java.io.*;

public class Main_bj_15486_퇴사2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+1];
		int[] price = new int[N+1];
		int[] dp = new int[N+2];
		StringTokenizer st = null;
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N ; i++) {
			// 현재 기준 최댓값 갱신
			max = Integer.max(max, dp[i]);
			// 오늘 날짜에 할당된 일의 기간이 유효할 경우
			if(i + time[i] <= N+1) {
				// 오늘 일을 했을 경우 가치 = 기존 값 vs 기존 최댓값 + 오늘 일의 가치
				dp[i+time[i]] = Math.max(dp[i+time[i]], max+price[i]);
			}
		}
		/* 뒤에서부터 해보기 */
		for(int i = N ; i >= 1 ; i--) {
			if(i + time[i] <= N) {
			}
		}
		
		System.out.println(max);
	}
	

	/* 부분집합 코드 -> 시간초과 */
	/*
	static int N, res = Integer.MIN_VALUE;
	static int[] time, price;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		price = new int[N];
		StringTokenizer st = null;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		schedule(0);
		
		System.out.println(res);
	}
	private static void schedule(int day) {
		if(day > N) return;
		if(day == N) {
			int tmp = 0;
			for(int i =0 ; i < N ; i++) {
				if(isSelected[i]) {
					tmp += price[i];
				}
			}
			res = Integer.max(res, tmp);
			return;
		}
		isSelected[day] = true;
		schedule(day+time[day]);
		isSelected[day] = false;
		schedule(day+1);
	}
	 */
}
