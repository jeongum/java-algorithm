package basic;

import java.io.*;
import java.util.*;

public class Main_bj_20436 {
	public static char[][] leftK = {
			{'q','w','e','r','t'},
			{'a','s','d','f','g'},
			{'z','x','c','v','0'},
	};
	public static char[][] rightK = {
			{'0','y','u','i','o','p'},
			{'0','h','j','k','l','0'},
			{'b','n','m','0','0','0'},
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		char sl = st.nextToken().charAt(0);
		char sr = st.nextToken().charAt(0);
		char[] word = br.readLine().toCharArray();
		int rx = 0;
		int ry = 0;
		int lx = 0;
		int ly = 0;
		out: for(int i = 0 ; i < 3 ; i ++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(leftK[i][j] == sl) {
					lx = j;
					ly = i;
					break out;
				}
			}
		}
		out: for(int i = 0 ; i < 3 ; i ++) {
			for(int j = 0 ; j < 6 ; j++) {
				if(rightK[i][j] == sr) {
					rx = j;
					ry = i;
					break out;
				}
			}
		}
		int time = 0;
		out:for(int k =0 ; k < word.length ; k++) {
			char tar = word[k];
			 for(int i = 0 ; i < 3 ; i ++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(leftK[i][j] == tar) {
						time += Math.abs(lx-j) + Math.abs(ly-i) + 1;
						lx = j;
						ly = i;
						continue out;
					}
				}
			}
			for(int i = 0 ; i < 3 ; i ++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(rightK[i][j] == tar) {
						time += Math.abs(rx-j) + Math.abs(ry-i) + 1;
						rx = j;
						ry = i;
						continue out;
					}
				}
			}
		}
		System.out.println(time);
	}
}
