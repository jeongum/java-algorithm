package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1206_View {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc<= 10 ; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i =0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			for(int i = 2 ; i < n-2 ; i++) {
				int tmp = Integer.MAX_VALUE ;
				for(int j = -2 ; j < 3 ; j++) {
					if(j == 0) continue;
					if(arr[i] > arr[i+j]) {
						tmp = Integer.min(tmp, arr[i]-arr[i+j]);
					}
					else {
						tmp = 0;
						break;
					}
				}
				res += tmp;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
