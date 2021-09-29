package graph;

import java.io.*;
import java.util.*;

public class Solution_d3_3307_최장증가부분수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] lis = new int[N];
			int length = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i =0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i =0 ; i < N ; i++) {
				lis[i] = 1;
				for(int j =0 ; j < i ; j++) {
					if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
						lis[i] = 1 + lis[j];
					}
				}
				length = Math.max(length, lis[i]);
			}
			sb.append("#").append(tc).append(" ").append(length).append("\n");
		}
		System.out.println(sb);
	}
}
