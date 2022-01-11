package basic;

import java.util.Scanner;

public class Main_bj_8th_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int three = 0;
		int rem =0;
		int five = n/5;
		int tmp = n;
		boolean b = false;
		while(five>-1) {
			three = 0;
			rem = tmp - (five * 5);
			if(rem%3 == 0) {
				b = true;
				three = (rem/3);
				break;
			}
			five --;
		}
		if(b) System.out.println(five+three);
		else System.out.println("-1");
		sc.close();
	}
}
