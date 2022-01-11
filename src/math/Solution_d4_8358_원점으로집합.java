package math;

import java.util.*;
import java.io.*;

public class Solution_d4_8358_원점으로집합 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		next:for(int tc = 1; tc<=T ; tc++) {
			int N = sc.nextInt();
			int[] a = new int[N];
			int max = 0;
			for(int i = 0 ; i < N ; i++) {
				a[i] = Math.abs(sc.nextInt()) + Math.abs(sc.nextInt());
				max = Math.max(max, a[i]);
			}
			for(int i = 1; i<N ; i++) {
				if((a[0]%2)!=(a[i]%2)) {
					System.out.println("#"+tc+" -1");
					continue next;
				}
			}
			int sum = 0;
			for(int i =0 ; ; i++) {
				sum+=i;
				if(sum>=max && (sum%2) == (max%2)) {
					System.out.println("#"+tc+" "+i);
					continue next;
				}
			}
		}
	}

}
