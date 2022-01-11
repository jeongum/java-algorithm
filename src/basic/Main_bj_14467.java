package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_14467 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] cnt = new int[10];
		int cross = 0;
		Arrays.fill(cnt, -1);
		for(int t = 1 ; t<=T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int p =Integer.parseInt(st.nextToken());
			if(cnt[num-1] == -1) cnt[num-1] = p;
			else if(cnt[num-1] != p) {
				cnt[num-1] = p;
				cross++;
			}
			else continue;
		}
		System.out.println(cross);
	}
}
