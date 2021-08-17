package basic;

import java.io.*;
import java.util.*;

public class Main_bj_5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		end:for(int T = 1 ; T<=tc ; T++) {
			
			char[] func = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().replace("[", "").replace("]", "").replace(","," ").split(" ");
			
			int dir = 0;									
			Deque<String> deque = new ArrayDeque<>();		
			
			for(int i =0 ; i < n ; i++) {
				deque.offerLast(input[i]);					
			}
			
			for(int i = 0 ; i < func.length ; i++) {
				switch(func[i]) {
					case 'R':{
						dir = Math.abs(dir-1);
						break;
					}
					case 'D':{
						if(deque.isEmpty()) {
							sb.append("error\n");
							continue end;
						}
						if(dir == 0) {
							deque.pollFirst();
						}else {
							deque.pollLast();
						}
						break;
					}
				}
			}

			String c;
			int i = 0;
			String[] result = new String[deque.size()];
			if(dir == 0) {
				while((c = deque.pollFirst()) != null) result[i++] = c;
			}
			else {
				while((c = deque.pollLast()) != null) result[i++] = c;
			}
			sb.append(Arrays.toString(result).replace(" ", "")).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
