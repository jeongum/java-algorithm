package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_3289_서로소집합 {
	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int T = 1 ; T <= tc ; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			
			for(int i =1 ; i< n+1 ; i++) arr[i] = i;
			
			sb.append("#").append(T).append(" ");
			
			for(int i =0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(op == 0){
					union(a,b); 
				}
				else {
					if(findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int findSet(int x) {
		if(x == arr[x]) return x;
		return findSet(arr[x]);
	}
	private static void union(int a, int b) {
		int a_root = findSet(a);
		int b_root = findSet(b);
		if(a_root == b_root) return;
		if(a_root>b_root) arr[a_root] = b_root;
		else arr[b_root] = a_root;
	}
}
