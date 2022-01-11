package simulation;

import java.io.*;
import java.util.*;

public class Main_bj_2846_오르막길 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int max = Integer.MIN_VALUE;
		while(end!=N-1) {
			if(arr[end] < arr[end+1]) end++;
			else {
				max = Integer.max(arr[end]-arr[start], max);
				start = end+1;
				end = start;
			}
		}
		max = Integer.max(arr[end]-arr[start], max);
		start = end+1;
		end = start;
		System.out.println(max);
	}

}
