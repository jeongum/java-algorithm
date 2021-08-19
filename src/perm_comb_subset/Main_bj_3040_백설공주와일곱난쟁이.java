package perm_comb_subset;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이 {
	static int n = 9;
	static int r = 7;
	static int[] arr;
	static int[] res;
	public static void comb(int cnt, int start) {
		if(cnt == r) {
			int sum =0 ;
			for(int i =0 ; i < 7 ; i++) {
				sum+=res[i];
			}
			if(sum == 100) {
				for(int i =0 ; i < 7; i++) {
					System.out.println(res[i]);
				}
			}
			return;
		}
		for(int i = start; i < n ; i++) {	
			res[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[n];
		res = new int[r];
		for(int i =0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	
}
