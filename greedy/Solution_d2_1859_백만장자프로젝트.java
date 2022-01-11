package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_d2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[n-1];
			long res = 0;
			for(int i = n-1 ; i >= 0 ; i--) {
				if(max>arr[i]) res += (max-arr[i]);
				else max = Math.max(arr[i], max);
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

}
