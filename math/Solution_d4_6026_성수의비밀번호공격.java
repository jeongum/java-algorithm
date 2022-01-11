package math;

import java.io.*;
import java.util.*;

public class Solution_d4_6026_성수의비밀번호공격 {
	static long p = 1000000007;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			long res = surjection(M, N);
			sb.append("#").append(tc).append(" ").append((res>=0? res:(res+p))).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static long surjection(int m, int n) {
		long tot = 0L;
		for(int i =0 ; i < m ; i++) {
			long t1 = (i%2 ==0)? 1:-1;
			long t2 = nCr(m, i)%p;
			long t3 = power(m-i, n)%p;
			tot = (tot +(t1*t2*t3)%p)%p;
		}
		return tot%p;
	}
	static long nCr(int n, int r) {
		if( r== 0 ) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i = 1; i <= n ; i++)
			fac[i] = fac[i-1] * i % p;
		
		return (fac[n]*power(fac[r],p-2)
				% p * power(fac[n-r],p-2) %p) %p;
	}
	
	private static long power(long x, long y) {
		long res = 1L;
		x %= p;
		while(y>0) {
			if(y%2 == 1) res = (res*x)%p;
			y /= 2;
			x = (x*x) % p;
		}
		return res;	
	}
}
