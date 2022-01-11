package greedy;

import java.util.*;
import java.io.*;

public class Main_bj_2138_전구와스위치 {
	static int N;
	static int[] origin_on,origin_off, target;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 첫번째 스위치를 건들고 시작할 때 / 안건들고 시작할 때
		origin_on = new int[N];
		origin_off = new int[N];
		target = new int[N];
		
		// 입력
		String str = br.readLine();
		for(int i =0 ; i < N ; i++) {
			origin_on[i] = str.charAt(i)-'0';
			origin_off[i] = str.charAt(i)-'0';
		}
		str = br.readLine();
		for(int i =0 ; i < N ; i++) {
			target[i] = str.charAt(i)-'0';
		}
		
		// 건들고 시작할 때, 초기 셋팅
		int cnt_on =0;
		int cnt_off =0;
		
		origin_on[0] = 1-origin_on[0];
		origin_on[1] = 1-origin_on[1];
		cnt_on++;
		
		//N-2까지 돌면서 i번 항목이 다를경우 i+1을 바꾸어줌(이전에 셋팅해놓은 것들을 건드리면 안되니까!)
		for(int i =0 ; i < N-1 ; i++) {
			if(origin_on[i] != target[i]) {
				onoff(origin_on,i+1);
				cnt_on ++;
			}
			if(origin_off[i] != target[i]) {
				onoff(origin_off,i+1);
				cnt_off ++;
			}
		}
		
		// 결과 셋팅
		int result = Integer.MAX_VALUE;
		if(origin_on[N-1] == target[N-1]) result = cnt_on;
		if(origin_off[N-1] == target[N-1]) result = Math.min(cnt_off, result);
		if(result == Integer.MAX_VALUE) result = -1;
		
		System.out.println(result);
	}

	private static void onoff(int[] arr, int i) {
		if(i-1>=0) arr[i-1] = 1- arr[i-1];
		arr[i] = 1 - arr[i];
		if(i+1 < N) arr[i+1] = 1-arr[i+1];
	}
}
