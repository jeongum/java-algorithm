package basic;

import java.io.*;
import java.util.*;

public class Main_bj_17276 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int T = 1; T <= tc; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());								//배열크기
			int angle = Integer.parseInt(st.nextToken());							//각도
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {											//배열 입력받는 부분
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < (angle = (angle < 0) ? angle + 360 : angle) / 45; j++) {		// -45도의 경우 315도와 같다는 성질을 이용하여 +360 해줌
				for (int i = 0; i < n / 2; i++) {												// 시계침처럼 축( arr[n/2][n/2] )을 기준으로 이동시킴
					int tmp = arr[i][i];
					arr[i][i] = arr[(n + 1) / 2 - 1][i];
					arr[(n + 1) / 2 - 1][i] = arr[n - 1 - i][i];
					arr[n - i - 1][i] = arr[n - i - 1][(n + 1) / 2 - 1];
					arr[n - i - 1][(n + 1) / 2 - 1] = arr[n - i - 1][n - i - 1];
					arr[n - i - 1][n - i - 1] = arr[(n + 1) / 2 - 1][n - i - 1];
					arr[(n + 1) / 2 - 1][n - i - 1] = arr[i][n - i - 1];
					arr[i][n - i - 1] = arr[i][(n + 1) / 2 - 1];
					arr[i][(n + 1) / 2 - 1] = tmp;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
