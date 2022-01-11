package basic;

import java.util.Scanner;

public class Main_bj_4th_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m =n;
		int cnt = 0;
		do {
			int x = m/10;
			int y = m%10;
			m=(y*10)+((x+y)%10);
			cnt++;
		} while(n != m);
		System.out.println(cnt);
	}
}
