package basic;

import java.util.Scanner;

public class Main_bj_7th_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int cnt = n;
		
		System.out.println((int)('z'-97));
		
		for(int i =0 ; i < n ;i++) {
			char[] carr = sc.nextLine().toCharArray();
			int[] alp =new int [26];
			alp[carr[0]-97]++;
			for(int j = 1; j<carr.length ; j++) {
				//바뀔때
				if( carr[j]!=carr[j-1]) {
					alp[carr[j-1]-97] = 2;
					if(alp[carr[j]-97]==2) {
						cnt--; break;
					}
					alp[carr[j]-97] = 1;
				}
				//연속될때
				else if(carr[j]==carr[j-1]) continue;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
