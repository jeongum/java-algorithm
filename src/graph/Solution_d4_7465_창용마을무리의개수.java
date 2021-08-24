package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7465_창용마을무리의개수 {
	static int N, M;
	static int[] arr;
	static boolean[] isChild;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int T = 1 ; T <= tc ; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			isChild = new boolean[N+1];
			for(int i = 1 ; i <= N ; i++) arr[i] = i;
			for(int i =0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			int res = 0;
			for(int i =1 ; i < N+1 ; i++) 
				if(!isChild[i]) res++;
			sb.append("#").append(T).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static int find(int a) {
		if(arr[a] == a) return a;
		return find(arr[a]);
	}
	
	public static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		if(ar == br) return;
		arr[br] = ar;
		isChild[ar] = false;
		isChild[br] = true;
		return;
	}
}
