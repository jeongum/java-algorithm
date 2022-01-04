package today;

import java.util.*;
import java.io.*;

public class Main_bj_10448_유래카이론 {
	static int[] T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		T = new int[44];
		for(int i =0 ; i < 44; i++) {
			T[i] = (i+1)*(i+2)/2;
		}
		
		for(int i = 0 ; i < N ; i++) {
			System.out.println(eureka(num[i]));
		}
	}

	private static int eureka(int num) {
		for(int k = 0 ; k < 44 ; k++) {
			for(int j = 0 ; j < 44 ; j++) {
				for(int i =0 ; i < 44 ; i++) {
					if(T[k] + T[i] + T[j] == num) return 1;
				}
			}
		}
		return 0;
	}
}
