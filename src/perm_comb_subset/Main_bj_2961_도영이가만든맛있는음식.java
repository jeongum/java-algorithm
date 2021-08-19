package perm_comb_subset;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식 {
	static int n;
	static int[][] tasty;
	static boolean[] isSelected;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tasty = new int[n][2];
		isSelected = new boolean[n];
		for(int i =0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			tasty[i][0] = Integer.parseInt(st.nextToken());
			tasty[i][1] = Integer.parseInt(st.nextToken());
		}
		cook(0);
		System.out.println(min);
		br.close();
	}

	public static void cook(int cnt) {
		int sour = 1;
		int bitter = 0;
		if(cnt == n) {
			for(int i =0 ; i < n ; i++) {
				if(isSelected[i]) {
					sour *= tasty[i][0];
					bitter += tasty[i][1];
				}
			}
			if(sour!= 1 && bitter!=0) min = Math.min(min, Math.abs(sour-bitter));
			return;
		}
		isSelected[cnt] = true;
		cook(cnt+1);
		isSelected[cnt] = false;
		cook(cnt+1);
	}
}
