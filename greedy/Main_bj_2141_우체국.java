package greedy;

import java.util.*;
import java.io.*;

public class Main_bj_2141_우체국 {
	static int N;
	static List<int[]> town;
	static long distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		town = new ArrayList<int[]>();
		long pop = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			town.add(new int[] {t, p});
			pop += p;
		}
		
		town.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		long sum = 0;
		for(int[] arr : town) {
			sum += arr[1];
			if(sum >= (pop + 1)/2) {
				System.out.println(arr[0]);
				break;
			}
		}
	}

}
