package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_14891_톱니바퀴 {

	static int[][] magnet;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		magnet = new int[4][8];
		List<int[]> rotate = new ArrayList<int[]>();
		StringTokenizer st = null;
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				magnet[i][j] = str.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for(int i =0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			rotate.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		for(int[] info : rotate) {
			rotateMagnet(info[0]-1, info[1]);
		}
		
		int res = 0;
		for(int i =0 ; i < 4 ; i++) {
			res += (magnet[i][0] == 1)? Math.pow(2, i):0;
		}
		System.out.println(res);
	}
	private static void rotateMagnet(int n, int d) {
		Queue<int[]> r = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[4];
		r.offer(new int[] {n, d});
		while(!r.isEmpty()) {
			int[] info = r.poll();
			int num = info[0];
			int dir = info[1];
			
			if(visited[num]) continue;
			
			visited[num] = true;
			if(num+1 < 4 && magnet[num][2] != magnet[num+1][6] && !visited[num+1]) {
				r.offer(new int[] {num+1, (dir*-1)});
			}
			if(num-1 >= 0 && magnet[num][6] != magnet[num-1][2] && !visited[num-1]) {
				r.offer(new int[] {num-1, (dir*-1)});
			}
			
			switch(dir) {
				case 1:{
					int last = magnet[num][7];
					for(int i = 7 ; i >=1 ; i--) {
						magnet[num][i] = magnet[num][i-1];
					}
					magnet[num][0] = last;
					break;
				}
				case -1:{
					int first = magnet[num][0];
					for(int i = 0 ; i < 7 ; i++) {
						magnet[num][i] = magnet[num][i+1];
					}
					magnet[num][7] = first;
					break;
				}
			}
		}
	}
}
