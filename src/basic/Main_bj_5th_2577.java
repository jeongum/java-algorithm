package basic;

import java.util.Scanner;

public class Main_bj_5th_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[10];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = a*b*c;
		
		while(n>0) {
			cnt[n%10]++;
			n /= 10;
		}
		
		for(int i : cnt) {
			System.out.println(i);
		}
	}	
}
