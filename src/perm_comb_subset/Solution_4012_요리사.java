package perm_comb_subset;

import java.io.*;
import java.util.*;

public class Solution_4012_요리사 {
	static int N;
	static int[][] arr;		//시너지 배열을 저장하는 변수
	static boolean[] isSelected;	//a조합에 선택된 재료 idx: true, b조합에 선택된 재료 idx: false
	static int tasty;	//결과 값(=최소 맛 차이)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());	//테스트케이스 수
		for(int T=1 ; T<=tc ; T++) {
			N = Integer.parseInt(br.readLine());	//재료의 수
			arr = new int[N][N];
			for(int i =0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j =0 ; j < N ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());	//시너지 값 저장
				}
			}
			isSelected = new boolean[N];
			tasty = Integer.MAX_VALUE;
			comb(0,0);	
			sb.append("#").append(T).append(" ").append(tasty).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//재료의 조합을 결정하는 메소드
	static void comb(int cnt, int start) {
		if(cnt == N/2) {	//기저조건: 재료가 N/2개 선택되었을 때
			tasty = Math.min(tasty, compTasty());		//현재 조합으로의 맛 차이(compTasty()), 기존의 맛차이(tasty) 중 최솟값 선택
			return;
		}
		for(int i = start ; i < N ; i++) {		
			isSelected[i] = true;	//선택된 재료: true
			comb(cnt+1, i+1);	//다음자리 조합 뽑으러
			isSelected[i] = false;	//다음 조합에 영향을 주지 않기 위해 다시 초기화
		}
	}
	
	static int compTasty() {
		int[] a = new int[N/2] , b = new int[N/2];		// a, b 요리 재료의 idx를 저장하는 배열
		int a_idx = 0, b_idx = 0;		
		for(int i =0 ; i < N ; i++) {
			if(isSelected[i]) a[a_idx++] = i;		//조합에서 선택되었다면 a요리
			else b[b_idx++] = i;					//선택되지 않았다면 b요리
		}
		int a_ts = 0, b_ts =0;		//a, b 요리의 맛
		for(int i = 0 ; i < a.length ; i++) {
			for(int j = 0 ; j<a.length ; j++) {
				a_ts += arr[a[i]][a[j]];	//요리의 각 재료간의 시너지를 더함
				b_ts += arr[b[i]][b[j]];	
			}
		}
		return Math.abs(a_ts - b_ts);
	}
}
