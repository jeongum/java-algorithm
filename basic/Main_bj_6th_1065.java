package basic;

import java.util.Scanner;

public class Main_bj_6th_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i =1 ; i <= n ; i++) {
			int tmp[] = new int [1000];
			int num = i;
			int j =0;
			while(num > 0) {
				tmp[j++] = num%10;
				num /= 10;
			}
			if(isArith(tmp,j)) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
	
	public static boolean isArith(int[] tmp, int j) {
		int i = 0;
		int dif = tmp[0]-tmp[1];
		for(i =0 ; i < j-1 ; i++) {
			if(dif != (tmp[i]-tmp[i+1])) break;
		}
		if(i == j-1) return true;
		return false;
	}
}
